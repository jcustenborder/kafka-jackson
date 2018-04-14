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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.ConfigFeature;
import com.google.common.collect.ImmutableSet;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DeserializerConfigGeneratorTest extends ConfigGeneratorTest {

  @Override
  protected Set<ConfigFeature> skip() {
    return ImmutableSet.of();
  }

  @Override
  protected List<ConfigFeature> features() {
    List<ConfigFeature> features = new ArrayList<>();
    Arrays.stream(MapperFeature.values()).forEach(features::add);
    Arrays.stream(DeserializationFeature.values()).forEach(features::add);
    return features;
  }

  @Override
  protected String fullyQualifiedClassName() {
    return JacksonDeserializerConfig.class.getName();
  }

  @Override
  protected void after() {

    JFieldVar configConstant = configClass.field(
        JMod.PUBLIC | JMod.STATIC | JMod.FINAL,
        String.class,
        "OUTPUT_CLASS_CONFIG",
        JExpr.lit("output.class")
    );
    JFieldVar docConstant = configClass.field(
        JMod.STATIC | JMod.FINAL,
        String.class,
        "OUTPUT_CLASS_DOC",
        JExpr.lit("The java class to deserialize to.")
    );

    JFieldVar field = configClass.field(
        JMod.PUBLIC | JMod.FINAL,
        Class.class,
        "outputClass"
    );

    constructor.body().assign(
        field,
        JExpr.invoke(JExpr._super(), "getClass").arg(configConstant)
    );

    configMethod.body().invoke(
        configDefVar,
        "define"
    ).arg(configConstant)
        .arg(configDefTypeClass)
        .arg(codeModel.ref(JsonNode.class).dotclass().invoke("getName"))
        .arg(configDefImportanceHigh)
        .arg(docConstant);


  }
}
