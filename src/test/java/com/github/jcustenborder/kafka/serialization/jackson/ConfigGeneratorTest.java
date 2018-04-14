/**
 * Copyright © 2017 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jcustenborder.kafka.serialization.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.ConfigFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.CaseFormat;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public abstract class ConfigGeneratorTest {

  static JCodeModel codeModel;
  protected JDefinedClass configClass;
  protected JClass configDefType;
  protected JClass configDefImportanceType;
  protected JClass configDefTypeType;
  protected JClass collectionsType;
  protected JFieldRef configDefTypeBoolean;
  protected JFieldRef configDefTypeClass;
  protected JFieldRef configDefImportanceMedium;
  protected JFieldRef configDefImportanceHigh;
  protected JClass mapStringWildcard;
  protected JClass mapStringString;
  protected JClass mapStringConfigFeature;
  protected JClass mapConfigFeatureString;
  protected JMethod configureMethod;
  protected JMethod nonDefaultSettingsMethod;
  protected JVar objectMapper;
  protected JMethod configMethod;
  protected JMethod constructor;
  protected JVar settingsVar;
  protected JVar configDefVar;
  protected JVar nonDefaultSettingResult;
  protected JVar nonDefaultSettingIsEnabled;
  protected JVar nonDefaultSettingEnabledByDefault;
  protected JClass linkedHashMapClass;
  protected JClass booleanType;
  protected JFieldVar configFeatureToConfigMap;
  protected JFieldVar configToConfigFeatureMap;
  JVar configFeatureToConfigVar;
  JVar configToConfigFeatureVar;

  @BeforeAll
  public static void beforeAll() {
    codeModel = new JCodeModel();
  }

  @AfterAll
  public static void afterAll() throws IOException {
    File outputPath = new File("target/code");
    outputPath.mkdirs();
    codeModel.build(outputPath);
  }

  abstract protected Set<ConfigFeature> skip();

  abstract protected List<ConfigFeature> features();

  abstract protected String fullyQualifiedClassName();

  abstract protected void after();

  @AfterEach
  public void afterEach() {
    configMethod.body()._return(configDefVar);
    nonDefaultSettingsMethod.body()._return(nonDefaultSettingResult);


    configClass.init().assign(configFeatureToConfigMap,
        collectionsType.staticInvoke("unmodifiableMap").arg(configFeatureToConfigVar)
    );
    configClass.init().assign(configToConfigFeatureMap,
        collectionsType.staticInvoke("unmodifiableMap").arg(configToConfigFeatureVar)
    );


  }

  JClass map(Class<?> key, JClass value) {
    return map(
        codeModel.ref(key),
        value
    );
  }

  JClass map(JClass key, JClass value) {
    return codeModel.ref(Map.class)
        .narrow(
            Arrays.asList(
                key,
                value
            )
        );
  }

  JClass map(Class<?> key, Class<?> value) {
    return map(
        codeModel.ref(key),
        codeModel.ref(value)
    );
  }

  @BeforeEach
  public void beforeEach() throws JClassAlreadyExistsException {
    configClass = codeModel._class(JMod.NONE, fullyQualifiedClassName(), ClassType.CLASS);
    configClass._extends(AbstractConfig.class);
    configDefType = codeModel.ref(ConfigDef.class);
    collectionsType = codeModel.ref(Collections.class);
    booleanType = codeModel.ref(Boolean.class);
    linkedHashMapClass = codeModel.ref(LinkedHashMap.class);
    configDefImportanceType = codeModel.ref(ConfigDef.Importance.class);
    configDefTypeType = codeModel.ref(ConfigDef.Type.class);
    configDefTypeBoolean = configDefTypeType.staticRef("BOOLEAN");
    configDefTypeClass = configDefTypeType.staticRef("CLASS");
    configDefImportanceMedium = configDefImportanceType.staticRef("MEDIUM");
    configDefImportanceHigh = configDefImportanceType.staticRef("HIGH");


    mapStringWildcard = map(String.class, codeModel.wildcard());
    mapStringString = map(String.class, String.class);
    mapStringConfigFeature = map(String.class, ConfigFeature.class);
    mapConfigFeatureString = map(ConfigFeature.class, String.class);


    configFeatureToConfigMap = configClass.field(
        JMod.PUBLIC | JMod.STATIC | JMod.FINAL,
        mapConfigFeatureString,
        "CONFIGFEATURE_TO_CONFIG"
    );

    configToConfigFeatureMap = configClass.field(
        JMod.PUBLIC | JMod.STATIC | JMod.FINAL,
        mapStringConfigFeature,
        "CONFIG_TO_CONFIGFEATURE"
    );
    configFeatureToConfigVar = configClass.init().decl(
        JMod.FINAL,
        mapConfigFeatureString,
        "configFeatureToConfig",
        JExpr._new(linkedHashMapClass)
    );
    configToConfigFeatureVar = configClass.init().decl(
        JMod.FINAL,
        mapStringConfigFeature,
        "configToConfigFeature",
        JExpr._new(linkedHashMapClass)
    );


    configureMethod = configClass.method(JMod.PUBLIC, codeModel.VOID, "configure");
    objectMapper = configureMethod.param(JMod.FINAL, ObjectMapper.class, "objectMapper");
    configMethod = configClass.method(JMod.STATIC | JMod.PUBLIC, configDefType, "config");
    nonDefaultSettingsMethod = configClass.method(JMod.STATIC | JMod.PUBLIC, mapStringString, "nonDefaultSettings");
    nonDefaultSettingsMethod.param(JMod.FINAL, ObjectMapper.class, "objectMapper");
    nonDefaultSettingResult = nonDefaultSettingsMethod.body().decl(
        JMod.FINAL,
        mapStringString,
        "result",
        JExpr._new(linkedHashMapClass)
    );
    nonDefaultSettingIsEnabled = nonDefaultSettingsMethod.body().decl(
        codeModel.BOOLEAN,
        "isEnabled"
    );
    nonDefaultSettingEnabledByDefault = nonDefaultSettingsMethod.body().decl(
        codeModel.BOOLEAN,
        "enabledByDefault"
    );

    constructor = configClass.constructor(JMod.PUBLIC);
    settingsVar = constructor.param(mapStringWildcard, "settings");
    constructor.body().invoke("super")
        .arg(configClass.staticInvoke(configMethod.name()))
        .arg(settingsVar);

    configDefVar = configMethod.body().decl(
        JMod.FINAL,
        configDefType,
        "config",
        JExpr._new(configDefType)
    );

    ConfigurationEntry entry = addConfigurationEntry(
        "JAVA_TIME_MODULE_ENABLE_CONFIG",
        "java.time.module.enable",
        "JAVA_TIME_MODULE_ENABLE_DOC",
        "Flag to register the java time module.",
        "javaTimeModuleEnable"
    );
    addConfigDefItem(entry, JExpr.lit(false));
    constructor.body().assign(
        entry.configValue,
        JExpr.invoke(JExpr._super(), "getBoolean").arg(entry.configConstant)
    );

    configureMethod.body()._if(entry.configValue)._then()
        .invoke(objectMapper, "registerModule")
        .arg(JExpr._new(codeModel.ref(JavaTimeModule.class)));
  }

  ConfigurationEntry addConfigurationEntry(
      String configConstantName,
      String configConstantValue,
      String docConstantName,
      String docConstantValue,
      String fieldName
  ) {
    JFieldVar configConstant = configClass.field(
        JMod.PUBLIC | JMod.STATIC | JMod.FINAL,
        String.class,
        configConstantName,
        JExpr.lit(configConstantValue)
    );
    JFieldVar docConstant = configClass.field(
        JMod.STATIC | JMod.FINAL,
        String.class,
        docConstantName,
        JExpr.lit(docConstantValue)
    );
    JFieldVar field = configClass.field(
        JMod.PUBLIC | JMod.FINAL,
        Boolean.class,
        fieldName
    );

    return new ConfigurationEntry(docConstant, configConstant, field);
  }

  @Test
  public void generateConfigClass() throws JClassAlreadyExistsException {
    Set<ConfigFeature> skipFeatures = skip();
    List<ConfigFeature> features = features();

    for (ConfigFeature feature : features) {
      if (skipFeatures.contains(feature)) {
        continue;
      }
      final String constantName = feature.toString();
      final String configConstantName = constantName + "_CONFIG";
      final String docConstantName = constantName + "_DOC";
      final String docText = String.format(
          "See [%s](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/%s.html#%s)",
          feature.toString(),
          feature.getClass().getSimpleName(),
          feature.toString()
      );
      final String fieldName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, feature.toString());
      final String propertyName = constantName.toLowerCase().replace('_', '.') + ".enable";

      ConfigurationEntry entry = addConfigurationEntry(
          configConstantName,
          propertyName,
          docConstantName,
          docText,
          fieldName
      );

      constructor.body().assign(
          entry.configValue,
          JExpr.invoke(JExpr._super(), "getBoolean").arg(entry.configConstant)
      );

      final JClass featureClass = codeModel.ref(feature.getClass());
      final JFieldRef featureRef = featureClass.staticRef(feature.toString());
      final JInvocation enabledByDefault = JExpr.invoke(featureRef, "enabledByDefault");

      addConfigDefItem(entry, enabledByDefault);

      configureMethod.body().invoke(
          objectMapper,
          "configure"
      ).arg(featureRef)
          .arg(entry.configValue);

      nonDefaultSettingsMethod.body().assign(
          nonDefaultSettingIsEnabled,
          objectMapper.invoke("isEnabled").arg(featureRef)
      );
      nonDefaultSettingsMethod.body().assign(
          nonDefaultSettingEnabledByDefault,
          enabledByDefault
      );


      nonDefaultSettingsMethod.body()._if(nonDefaultSettingEnabledByDefault.ne(nonDefaultSettingIsEnabled))
          ._then().invoke(nonDefaultSettingResult, "put")
          .arg(entry.configConstant)
          .arg(booleanType.staticInvoke("toString").arg(nonDefaultSettingIsEnabled));

      configClass.init()
          .invoke(configFeatureToConfigVar, "put")
          .arg(featureRef)
          .arg(entry.configConstant);
      configClass.init()
          .invoke(configToConfigFeatureVar, "put")
          .arg(entry.configConstant)
          .arg(featureRef);
    }

    after();
  }

  private void addConfigDefItem(ConfigurationEntry entry, JExpression enabledByDefault) {
    configMethod.body().invoke(
        configDefVar,
        "define"
    ).arg(entry.configConstant)
        .arg(configDefTypeBoolean)
        .arg(enabledByDefault)
        .arg(configDefImportanceMedium)
        .arg(entry.docConstant);
  }

  class ConfigurationEntry {
    public final JFieldVar docConstant;
    public final JFieldVar configConstant;
    public final JFieldVar configValue;


    ConfigurationEntry(JFieldVar docConstant, JFieldVar configConstant, JFieldVar configValue) {
      this.docConstant = docConstant;
      this.configConstant = configConstant;
      this.configValue = configValue;
    }

  }
}
