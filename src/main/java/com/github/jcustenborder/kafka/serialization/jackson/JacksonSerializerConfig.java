/**
 * Copyright © 2017 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jcustenborder.kafka.serialization.jackson;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ConfigFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class JacksonSerializerConfig extends AbstractConfig {

  public final static Map<ConfigFeature, String> CONFIGFEATURE_TO_CONFIG;
  public final static Map<String, ConfigFeature> CONFIG_TO_CONFIGFEATURE;
  public final static String JAVA_TIME_MODULE_ENABLE_CONFIG = "java.time.module.enable";
  public final static String USE_ANNOTATIONS_CONFIG = "use.annotations.enable";
  public final static String USE_GETTERS_AS_SETTERS_CONFIG = "use.getters.as.setters.enable";
  public final static String PROPAGATE_TRANSIENT_MARKER_CONFIG = "propagate.transient.marker.enable";
  public final static String AUTO_DETECT_CREATORS_CONFIG = "auto.detect.creators.enable";
  public final static String AUTO_DETECT_FIELDS_CONFIG = "auto.detect.fields.enable";
  public final static String AUTO_DETECT_GETTERS_CONFIG = "auto.detect.getters.enable";
  public final static String AUTO_DETECT_IS_GETTERS_CONFIG = "auto.detect.is.getters.enable";
  public final static String AUTO_DETECT_SETTERS_CONFIG = "auto.detect.setters.enable";
  public final static String REQUIRE_SETTERS_FOR_GETTERS_CONFIG = "require.setters.for.getters.enable";
  public final static String ALLOW_FINAL_FIELDS_AS_MUTATORS_CONFIG = "allow.final.fields.as.mutators.enable";
  public final static String INFER_PROPERTY_MUTATORS_CONFIG = "infer.property.mutators.enable";
  public final static String INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES_CONFIG = "infer.creator.from.constructor.properties.enable";
  public final static String CAN_OVERRIDE_ACCESS_MODIFIERS_CONFIG = "can.override.access.modifiers.enable";
  public final static String OVERRIDE_PUBLIC_ACCESS_MODIFIERS_CONFIG = "override.public.access.modifiers.enable";
  public final static String USE_STATIC_TYPING_CONFIG = "use.static.typing.enable";
  public final static String DEFAULT_VIEW_INCLUSION_CONFIG = "default.view.inclusion.enable";
  public final static String SORT_PROPERTIES_ALPHABETICALLY_CONFIG = "sort.properties.alphabetically.enable";
  public final static String ACCEPT_CASE_INSENSITIVE_PROPERTIES_CONFIG = "accept.case.insensitive.properties.enable";
  public final static String ACCEPT_CASE_INSENSITIVE_ENUMS_CONFIG = "accept.case.insensitive.enums.enable";
  public final static String USE_WRAPPER_NAME_AS_PROPERTY_NAME_CONFIG = "use.wrapper.name.as.property.name.enable";
  public final static String USE_STD_BEAN_NAMING_CONFIG = "use.std.bean.naming.enable";
  public final static String ALLOW_EXPLICIT_PROPERTY_RENAMING_CONFIG = "allow.explicit.property.renaming.enable";
  public final static String ALLOW_COERCION_OF_SCALARS_CONFIG = "allow.coercion.of.scalars.enable";
  public final static String IGNORE_DUPLICATE_MODULE_REGISTRATIONS_CONFIG = "ignore.duplicate.module.registrations.enable";
  public final static String IGNORE_MERGE_FOR_UNMERGEABLE_CONFIG = "ignore.merge.for.unmergeable.enable";
  public final static String WRAP_ROOT_VALUE_CONFIG = "wrap.root.value.enable";
  public final static String INDENT_OUTPUT_CONFIG = "indent.output.enable";
  public final static String FAIL_ON_EMPTY_BEANS_CONFIG = "fail.on.empty.beans.enable";
  public final static String FAIL_ON_SELF_REFERENCES_CONFIG = "fail.on.self.references.enable";
  public final static String WRAP_EXCEPTIONS_CONFIG = "wrap.exceptions.enable";
  public final static String FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS_CONFIG = "fail.on.unwrapped.type.identifiers.enable";
  public final static String WRITE_DATES_AS_TIMESTAMPS_CONFIG = "write.dates.as.timestamps.enable";
  public final static String WRITE_DATE_KEYS_AS_TIMESTAMPS_CONFIG = "write.date.keys.as.timestamps.enable";
  public final static String WRITE_DATES_WITH_ZONE_ID_CONFIG = "write.dates.with.zone.id.enable";
  public final static String WRITE_DURATIONS_AS_TIMESTAMPS_CONFIG = "write.durations.as.timestamps.enable";
  public final static String WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS_CONFIG = "write.char.arrays.as.json.arrays.enable";
  public final static String WRITE_ENUMS_USING_TO_STRING_CONFIG = "write.enums.using.to.string.enable";
  public final static String WRITE_ENUMS_USING_INDEX_CONFIG = "write.enums.using.index.enable";
  public final static String WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED_CONFIG = "write.single.elem.arrays.unwrapped.enable";
  public final static String WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG = "write.date.timestamps.as.nanoseconds.enable";
  public final static String ORDER_MAP_ENTRIES_BY_KEYS_CONFIG = "order.map.entries.by.keys.enable";
  public final static String USE_EQUALITY_FOR_OBJECT_ID_CONFIG = "use.equality.for.object.id.enable";
  final static String JAVA_TIME_MODULE_ENABLE_DOC = "Flag to register the java time module.";
  final static String USE_ANNOTATIONS_DOC = "See [USE_ANNOTATIONS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#USE_ANNOTATIONS)";
  final static String USE_GETTERS_AS_SETTERS_DOC = "See [USE_GETTERS_AS_SETTERS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#USE_GETTERS_AS_SETTERS)";
  final static String PROPAGATE_TRANSIENT_MARKER_DOC = "See [PROPAGATE_TRANSIENT_MARKER](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#PROPAGATE_TRANSIENT_MARKER)";
  final static String AUTO_DETECT_CREATORS_DOC = "See [AUTO_DETECT_CREATORS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#AUTO_DETECT_CREATORS)";
  final static String AUTO_DETECT_FIELDS_DOC = "See [AUTO_DETECT_FIELDS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#AUTO_DETECT_FIELDS)";
  final static String AUTO_DETECT_GETTERS_DOC = "See [AUTO_DETECT_GETTERS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#AUTO_DETECT_GETTERS)";
  final static String AUTO_DETECT_IS_GETTERS_DOC = "See [AUTO_DETECT_IS_GETTERS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#AUTO_DETECT_IS_GETTERS)";
  final static String AUTO_DETECT_SETTERS_DOC = "See [AUTO_DETECT_SETTERS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#AUTO_DETECT_SETTERS)";
  final static String REQUIRE_SETTERS_FOR_GETTERS_DOC = "See [REQUIRE_SETTERS_FOR_GETTERS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#REQUIRE_SETTERS_FOR_GETTERS)";
  final static String ALLOW_FINAL_FIELDS_AS_MUTATORS_DOC = "See [ALLOW_FINAL_FIELDS_AS_MUTATORS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#ALLOW_FINAL_FIELDS_AS_MUTATORS)";
  final static String INFER_PROPERTY_MUTATORS_DOC = "See [INFER_PROPERTY_MUTATORS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#INFER_PROPERTY_MUTATORS)";
  final static String INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES_DOC = "See [INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES)";
  final static String CAN_OVERRIDE_ACCESS_MODIFIERS_DOC = "See [CAN_OVERRIDE_ACCESS_MODIFIERS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#CAN_OVERRIDE_ACCESS_MODIFIERS)";
  final static String OVERRIDE_PUBLIC_ACCESS_MODIFIERS_DOC = "See [OVERRIDE_PUBLIC_ACCESS_MODIFIERS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#OVERRIDE_PUBLIC_ACCESS_MODIFIERS)";
  final static String USE_STATIC_TYPING_DOC = "See [USE_STATIC_TYPING](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#USE_STATIC_TYPING)";
  final static String DEFAULT_VIEW_INCLUSION_DOC = "See [DEFAULT_VIEW_INCLUSION](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#DEFAULT_VIEW_INCLUSION)";
  final static String SORT_PROPERTIES_ALPHABETICALLY_DOC = "See [SORT_PROPERTIES_ALPHABETICALLY](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#SORT_PROPERTIES_ALPHABETICALLY)";
  final static String ACCEPT_CASE_INSENSITIVE_PROPERTIES_DOC = "See [ACCEPT_CASE_INSENSITIVE_PROPERTIES](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#ACCEPT_CASE_INSENSITIVE_PROPERTIES)";
  final static String ACCEPT_CASE_INSENSITIVE_ENUMS_DOC = "See [ACCEPT_CASE_INSENSITIVE_ENUMS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#ACCEPT_CASE_INSENSITIVE_ENUMS)";
  final static String USE_WRAPPER_NAME_AS_PROPERTY_NAME_DOC = "See [USE_WRAPPER_NAME_AS_PROPERTY_NAME](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#USE_WRAPPER_NAME_AS_PROPERTY_NAME)";
  final static String USE_STD_BEAN_NAMING_DOC = "See [USE_STD_BEAN_NAMING](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#USE_STD_BEAN_NAMING)";
  final static String ALLOW_EXPLICIT_PROPERTY_RENAMING_DOC = "See [ALLOW_EXPLICIT_PROPERTY_RENAMING](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#ALLOW_EXPLICIT_PROPERTY_RENAMING)";
  final static String ALLOW_COERCION_OF_SCALARS_DOC = "See [ALLOW_COERCION_OF_SCALARS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#ALLOW_COERCION_OF_SCALARS)";
  final static String IGNORE_DUPLICATE_MODULE_REGISTRATIONS_DOC = "See [IGNORE_DUPLICATE_MODULE_REGISTRATIONS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#IGNORE_DUPLICATE_MODULE_REGISTRATIONS)";
  final static String IGNORE_MERGE_FOR_UNMERGEABLE_DOC = "See [IGNORE_MERGE_FOR_UNMERGEABLE](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/MapperFeature.html#IGNORE_MERGE_FOR_UNMERGEABLE)";
  final static String WRAP_ROOT_VALUE_DOC = "See [WRAP_ROOT_VALUE](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRAP_ROOT_VALUE)";
  final static String INDENT_OUTPUT_DOC = "See [INDENT_OUTPUT](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#INDENT_OUTPUT)";
  final static String FAIL_ON_EMPTY_BEANS_DOC = "See [FAIL_ON_EMPTY_BEANS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#FAIL_ON_EMPTY_BEANS)";
  final static String FAIL_ON_SELF_REFERENCES_DOC = "See [FAIL_ON_SELF_REFERENCES](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#FAIL_ON_SELF_REFERENCES)";
  final static String WRAP_EXCEPTIONS_DOC = "See [WRAP_EXCEPTIONS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRAP_EXCEPTIONS)";
  final static String FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS_DOC = "See [FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)";
  final static String WRITE_DATES_AS_TIMESTAMPS_DOC = "See [WRITE_DATES_AS_TIMESTAMPS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_DATES_AS_TIMESTAMPS)";
  final static String WRITE_DATE_KEYS_AS_TIMESTAMPS_DOC = "See [WRITE_DATE_KEYS_AS_TIMESTAMPS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_DATE_KEYS_AS_TIMESTAMPS)";
  final static String WRITE_DATES_WITH_ZONE_ID_DOC = "See [WRITE_DATES_WITH_ZONE_ID](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_DATES_WITH_ZONE_ID)";
  final static String WRITE_DURATIONS_AS_TIMESTAMPS_DOC = "See [WRITE_DURATIONS_AS_TIMESTAMPS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_DURATIONS_AS_TIMESTAMPS)";
  final static String WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS_DOC = "See [WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)";
  final static String WRITE_ENUMS_USING_TO_STRING_DOC = "See [WRITE_ENUMS_USING_TO_STRING](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_ENUMS_USING_TO_STRING)";
  final static String WRITE_ENUMS_USING_INDEX_DOC = "See [WRITE_ENUMS_USING_INDEX](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_ENUMS_USING_INDEX)";
  final static String WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED_DOC = "See [WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)";
  final static String WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS_DOC = "See [WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)";
  final static String ORDER_MAP_ENTRIES_BY_KEYS_DOC = "See [ORDER_MAP_ENTRIES_BY_KEYS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#ORDER_MAP_ENTRIES_BY_KEYS)";
  final static String USE_EQUALITY_FOR_OBJECT_ID_DOC = "See [USE_EQUALITY_FOR_OBJECT_ID](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/SerializationFeature.html#USE_EQUALITY_FOR_OBJECT_ID)";

  static {
    final Map<ConfigFeature, String> configFeatureToConfig = new LinkedHashMap();
    final Map<String, ConfigFeature> configToConfigFeature = new LinkedHashMap();
    configFeatureToConfig.put(MapperFeature.USE_ANNOTATIONS, USE_ANNOTATIONS_CONFIG);
    configToConfigFeature.put(USE_ANNOTATIONS_CONFIG, MapperFeature.USE_ANNOTATIONS);
    configFeatureToConfig.put(MapperFeature.USE_GETTERS_AS_SETTERS, USE_GETTERS_AS_SETTERS_CONFIG);
    configToConfigFeature.put(USE_GETTERS_AS_SETTERS_CONFIG, MapperFeature.USE_GETTERS_AS_SETTERS);
    configFeatureToConfig.put(MapperFeature.PROPAGATE_TRANSIENT_MARKER, PROPAGATE_TRANSIENT_MARKER_CONFIG);
    configToConfigFeature.put(PROPAGATE_TRANSIENT_MARKER_CONFIG, MapperFeature.PROPAGATE_TRANSIENT_MARKER);
    configFeatureToConfig.put(MapperFeature.AUTO_DETECT_CREATORS, AUTO_DETECT_CREATORS_CONFIG);
    configToConfigFeature.put(AUTO_DETECT_CREATORS_CONFIG, MapperFeature.AUTO_DETECT_CREATORS);
    configFeatureToConfig.put(MapperFeature.AUTO_DETECT_FIELDS, AUTO_DETECT_FIELDS_CONFIG);
    configToConfigFeature.put(AUTO_DETECT_FIELDS_CONFIG, MapperFeature.AUTO_DETECT_FIELDS);
    configFeatureToConfig.put(MapperFeature.AUTO_DETECT_GETTERS, AUTO_DETECT_GETTERS_CONFIG);
    configToConfigFeature.put(AUTO_DETECT_GETTERS_CONFIG, MapperFeature.AUTO_DETECT_GETTERS);
    configFeatureToConfig.put(MapperFeature.AUTO_DETECT_IS_GETTERS, AUTO_DETECT_IS_GETTERS_CONFIG);
    configToConfigFeature.put(AUTO_DETECT_IS_GETTERS_CONFIG, MapperFeature.AUTO_DETECT_IS_GETTERS);
    configFeatureToConfig.put(MapperFeature.AUTO_DETECT_SETTERS, AUTO_DETECT_SETTERS_CONFIG);
    configToConfigFeature.put(AUTO_DETECT_SETTERS_CONFIG, MapperFeature.AUTO_DETECT_SETTERS);
    configFeatureToConfig.put(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS, REQUIRE_SETTERS_FOR_GETTERS_CONFIG);
    configToConfigFeature.put(REQUIRE_SETTERS_FOR_GETTERS_CONFIG, MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
    configFeatureToConfig.put(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS, ALLOW_FINAL_FIELDS_AS_MUTATORS_CONFIG);
    configToConfigFeature.put(ALLOW_FINAL_FIELDS_AS_MUTATORS_CONFIG, MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS);
    configFeatureToConfig.put(MapperFeature.INFER_PROPERTY_MUTATORS, INFER_PROPERTY_MUTATORS_CONFIG);
    configToConfigFeature.put(INFER_PROPERTY_MUTATORS_CONFIG, MapperFeature.INFER_PROPERTY_MUTATORS);
    configFeatureToConfig.put(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES, INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES_CONFIG);
    configToConfigFeature.put(INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES_CONFIG, MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES);
    configFeatureToConfig.put(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS, CAN_OVERRIDE_ACCESS_MODIFIERS_CONFIG);
    configToConfigFeature.put(CAN_OVERRIDE_ACCESS_MODIFIERS_CONFIG, MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    configFeatureToConfig.put(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS, OVERRIDE_PUBLIC_ACCESS_MODIFIERS_CONFIG);
    configToConfigFeature.put(OVERRIDE_PUBLIC_ACCESS_MODIFIERS_CONFIG, MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    configFeatureToConfig.put(MapperFeature.USE_STATIC_TYPING, USE_STATIC_TYPING_CONFIG);
    configToConfigFeature.put(USE_STATIC_TYPING_CONFIG, MapperFeature.USE_STATIC_TYPING);
    configFeatureToConfig.put(MapperFeature.DEFAULT_VIEW_INCLUSION, DEFAULT_VIEW_INCLUSION_CONFIG);
    configToConfigFeature.put(DEFAULT_VIEW_INCLUSION_CONFIG, MapperFeature.DEFAULT_VIEW_INCLUSION);
    configFeatureToConfig.put(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, SORT_PROPERTIES_ALPHABETICALLY_CONFIG);
    configToConfigFeature.put(SORT_PROPERTIES_ALPHABETICALLY_CONFIG, MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
    configFeatureToConfig.put(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, ACCEPT_CASE_INSENSITIVE_PROPERTIES_CONFIG);
    configToConfigFeature.put(ACCEPT_CASE_INSENSITIVE_PROPERTIES_CONFIG, MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
    configFeatureToConfig.put(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, ACCEPT_CASE_INSENSITIVE_ENUMS_CONFIG);
    configToConfigFeature.put(ACCEPT_CASE_INSENSITIVE_ENUMS_CONFIG, MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
    configFeatureToConfig.put(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME, USE_WRAPPER_NAME_AS_PROPERTY_NAME_CONFIG);
    configToConfigFeature.put(USE_WRAPPER_NAME_AS_PROPERTY_NAME_CONFIG, MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME);
    configFeatureToConfig.put(MapperFeature.USE_STD_BEAN_NAMING, USE_STD_BEAN_NAMING_CONFIG);
    configToConfigFeature.put(USE_STD_BEAN_NAMING_CONFIG, MapperFeature.USE_STD_BEAN_NAMING);
    configFeatureToConfig.put(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING, ALLOW_EXPLICIT_PROPERTY_RENAMING_CONFIG);
    configToConfigFeature.put(ALLOW_EXPLICIT_PROPERTY_RENAMING_CONFIG, MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING);
    configFeatureToConfig.put(MapperFeature.ALLOW_COERCION_OF_SCALARS, ALLOW_COERCION_OF_SCALARS_CONFIG);
    configToConfigFeature.put(ALLOW_COERCION_OF_SCALARS_CONFIG, MapperFeature.ALLOW_COERCION_OF_SCALARS);
    configFeatureToConfig.put(MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS, IGNORE_DUPLICATE_MODULE_REGISTRATIONS_CONFIG);
    configToConfigFeature.put(IGNORE_DUPLICATE_MODULE_REGISTRATIONS_CONFIG, MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS);
    configFeatureToConfig.put(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE, IGNORE_MERGE_FOR_UNMERGEABLE_CONFIG);
    configToConfigFeature.put(IGNORE_MERGE_FOR_UNMERGEABLE_CONFIG, MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE);
    configFeatureToConfig.put(SerializationFeature.WRAP_ROOT_VALUE, WRAP_ROOT_VALUE_CONFIG);
    configToConfigFeature.put(WRAP_ROOT_VALUE_CONFIG, SerializationFeature.WRAP_ROOT_VALUE);
    configFeatureToConfig.put(SerializationFeature.INDENT_OUTPUT, INDENT_OUTPUT_CONFIG);
    configToConfigFeature.put(INDENT_OUTPUT_CONFIG, SerializationFeature.INDENT_OUTPUT);
    configFeatureToConfig.put(SerializationFeature.FAIL_ON_EMPTY_BEANS, FAIL_ON_EMPTY_BEANS_CONFIG);
    configToConfigFeature.put(FAIL_ON_EMPTY_BEANS_CONFIG, SerializationFeature.FAIL_ON_EMPTY_BEANS);
    configFeatureToConfig.put(SerializationFeature.FAIL_ON_SELF_REFERENCES, FAIL_ON_SELF_REFERENCES_CONFIG);
    configToConfigFeature.put(FAIL_ON_SELF_REFERENCES_CONFIG, SerializationFeature.FAIL_ON_SELF_REFERENCES);
    configFeatureToConfig.put(SerializationFeature.WRAP_EXCEPTIONS, WRAP_EXCEPTIONS_CONFIG);
    configToConfigFeature.put(WRAP_EXCEPTIONS_CONFIG, SerializationFeature.WRAP_EXCEPTIONS);
    configFeatureToConfig.put(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS_CONFIG);
    configToConfigFeature.put(FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS_CONFIG, SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
    configFeatureToConfig.put(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, WRITE_DATES_AS_TIMESTAMPS_CONFIG);
    configToConfigFeature.put(WRITE_DATES_AS_TIMESTAMPS_CONFIG, SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    configFeatureToConfig.put(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, WRITE_DATE_KEYS_AS_TIMESTAMPS_CONFIG);
    configToConfigFeature.put(WRITE_DATE_KEYS_AS_TIMESTAMPS_CONFIG, SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
    configFeatureToConfig.put(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, WRITE_DATES_WITH_ZONE_ID_CONFIG);
    configToConfigFeature.put(WRITE_DATES_WITH_ZONE_ID_CONFIG, SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
    configFeatureToConfig.put(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, WRITE_DURATIONS_AS_TIMESTAMPS_CONFIG);
    configToConfigFeature.put(WRITE_DURATIONS_AS_TIMESTAMPS_CONFIG, SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS);
    configFeatureToConfig.put(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS, WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS_CONFIG);
    configToConfigFeature.put(WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS_CONFIG, SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS);
    configFeatureToConfig.put(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, WRITE_ENUMS_USING_TO_STRING_CONFIG);
    configToConfigFeature.put(WRITE_ENUMS_USING_TO_STRING_CONFIG, SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    configFeatureToConfig.put(SerializationFeature.WRITE_ENUMS_USING_INDEX, WRITE_ENUMS_USING_INDEX_CONFIG);
    configToConfigFeature.put(WRITE_ENUMS_USING_INDEX_CONFIG, SerializationFeature.WRITE_ENUMS_USING_INDEX);
    configFeatureToConfig.put(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED, WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED_CONFIG);
    configToConfigFeature.put(WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED_CONFIG, SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
    configFeatureToConfig.put(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG);
    configToConfigFeature.put(WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG, SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
    configFeatureToConfig.put(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, ORDER_MAP_ENTRIES_BY_KEYS_CONFIG);
    configToConfigFeature.put(ORDER_MAP_ENTRIES_BY_KEYS_CONFIG, SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
    configFeatureToConfig.put(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID, USE_EQUALITY_FOR_OBJECT_ID_CONFIG);
    configToConfigFeature.put(USE_EQUALITY_FOR_OBJECT_ID_CONFIG, SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID);
    CONFIGFEATURE_TO_CONFIG = Collections.unmodifiableMap(configFeatureToConfig);
    CONFIG_TO_CONFIGFEATURE = Collections.unmodifiableMap(configToConfigFeature);
  }

  public final Boolean javaTimeModuleEnable;
  public final Boolean useAnnotations;
  public final Boolean useGettersAsSetters;
  public final Boolean propagateTransientMarker;
  public final Boolean autoDetectCreators;
  public final Boolean autoDetectFields;
  public final Boolean autoDetectGetters;
  public final Boolean autoDetectIsGetters;
  public final Boolean autoDetectSetters;
  public final Boolean requireSettersForGetters;
  public final Boolean allowFinalFieldsAsMutators;
  public final Boolean inferPropertyMutators;
  public final Boolean inferCreatorFromConstructorProperties;
  public final Boolean canOverrideAccessModifiers;
  public final Boolean overridePublicAccessModifiers;
  public final Boolean useStaticTyping;
  public final Boolean defaultViewInclusion;
  public final Boolean sortPropertiesAlphabetically;
  public final Boolean acceptCaseInsensitiveProperties;
  public final Boolean acceptCaseInsensitiveEnums;
  public final Boolean useWrapperNameAsPropertyName;
  public final Boolean useStdBeanNaming;
  public final Boolean allowExplicitPropertyRenaming;
  public final Boolean allowCoercionOfScalars;
  public final Boolean ignoreDuplicateModuleRegistrations;
  public final Boolean ignoreMergeForUnmergeable;
  public final Boolean wrapRootValue;
  public final Boolean indentOutput;
  public final Boolean failOnEmptyBeans;
  public final Boolean failOnSelfReferences;
  public final Boolean wrapExceptions;
  public final Boolean failOnUnwrappedTypeIdentifiers;
  public final Boolean writeDatesAsTimestamps;
  public final Boolean writeDateKeysAsTimestamps;
  public final Boolean writeDatesWithZoneId;
  public final Boolean writeDurationsAsTimestamps;
  public final Boolean writeCharArraysAsJsonArrays;
  public final Boolean writeEnumsUsingToString;
  public final Boolean writeEnumsUsingIndex;
  public final Boolean writeSingleElemArraysUnwrapped;
  public final Boolean writeDateTimestampsAsNanoseconds;
  public final Boolean orderMapEntriesByKeys;
  public final Boolean useEqualityForObjectId;

  public JacksonSerializerConfig(Map<String, ?> settings) {
    super(JacksonSerializerConfig.config(), settings);
    javaTimeModuleEnable = super.getBoolean(JAVA_TIME_MODULE_ENABLE_CONFIG);
    useAnnotations = super.getBoolean(USE_ANNOTATIONS_CONFIG);
    useGettersAsSetters = super.getBoolean(USE_GETTERS_AS_SETTERS_CONFIG);
    propagateTransientMarker = super.getBoolean(PROPAGATE_TRANSIENT_MARKER_CONFIG);
    autoDetectCreators = super.getBoolean(AUTO_DETECT_CREATORS_CONFIG);
    autoDetectFields = super.getBoolean(AUTO_DETECT_FIELDS_CONFIG);
    autoDetectGetters = super.getBoolean(AUTO_DETECT_GETTERS_CONFIG);
    autoDetectIsGetters = super.getBoolean(AUTO_DETECT_IS_GETTERS_CONFIG);
    autoDetectSetters = super.getBoolean(AUTO_DETECT_SETTERS_CONFIG);
    requireSettersForGetters = super.getBoolean(REQUIRE_SETTERS_FOR_GETTERS_CONFIG);
    allowFinalFieldsAsMutators = super.getBoolean(ALLOW_FINAL_FIELDS_AS_MUTATORS_CONFIG);
    inferPropertyMutators = super.getBoolean(INFER_PROPERTY_MUTATORS_CONFIG);
    inferCreatorFromConstructorProperties = super.getBoolean(INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES_CONFIG);
    canOverrideAccessModifiers = super.getBoolean(CAN_OVERRIDE_ACCESS_MODIFIERS_CONFIG);
    overridePublicAccessModifiers = super.getBoolean(OVERRIDE_PUBLIC_ACCESS_MODIFIERS_CONFIG);
    useStaticTyping = super.getBoolean(USE_STATIC_TYPING_CONFIG);
    defaultViewInclusion = super.getBoolean(DEFAULT_VIEW_INCLUSION_CONFIG);
    sortPropertiesAlphabetically = super.getBoolean(SORT_PROPERTIES_ALPHABETICALLY_CONFIG);
    acceptCaseInsensitiveProperties = super.getBoolean(ACCEPT_CASE_INSENSITIVE_PROPERTIES_CONFIG);
    acceptCaseInsensitiveEnums = super.getBoolean(ACCEPT_CASE_INSENSITIVE_ENUMS_CONFIG);
    useWrapperNameAsPropertyName = super.getBoolean(USE_WRAPPER_NAME_AS_PROPERTY_NAME_CONFIG);
    useStdBeanNaming = super.getBoolean(USE_STD_BEAN_NAMING_CONFIG);
    allowExplicitPropertyRenaming = super.getBoolean(ALLOW_EXPLICIT_PROPERTY_RENAMING_CONFIG);
    allowCoercionOfScalars = super.getBoolean(ALLOW_COERCION_OF_SCALARS_CONFIG);
    ignoreDuplicateModuleRegistrations = super.getBoolean(IGNORE_DUPLICATE_MODULE_REGISTRATIONS_CONFIG);
    ignoreMergeForUnmergeable = super.getBoolean(IGNORE_MERGE_FOR_UNMERGEABLE_CONFIG);
    wrapRootValue = super.getBoolean(WRAP_ROOT_VALUE_CONFIG);
    indentOutput = super.getBoolean(INDENT_OUTPUT_CONFIG);
    failOnEmptyBeans = super.getBoolean(FAIL_ON_EMPTY_BEANS_CONFIG);
    failOnSelfReferences = super.getBoolean(FAIL_ON_SELF_REFERENCES_CONFIG);
    wrapExceptions = super.getBoolean(WRAP_EXCEPTIONS_CONFIG);
    failOnUnwrappedTypeIdentifiers = super.getBoolean(FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS_CONFIG);
    writeDatesAsTimestamps = super.getBoolean(WRITE_DATES_AS_TIMESTAMPS_CONFIG);
    writeDateKeysAsTimestamps = super.getBoolean(WRITE_DATE_KEYS_AS_TIMESTAMPS_CONFIG);
    writeDatesWithZoneId = super.getBoolean(WRITE_DATES_WITH_ZONE_ID_CONFIG);
    writeDurationsAsTimestamps = super.getBoolean(WRITE_DURATIONS_AS_TIMESTAMPS_CONFIG);
    writeCharArraysAsJsonArrays = super.getBoolean(WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS_CONFIG);
    writeEnumsUsingToString = super.getBoolean(WRITE_ENUMS_USING_TO_STRING_CONFIG);
    writeEnumsUsingIndex = super.getBoolean(WRITE_ENUMS_USING_INDEX_CONFIG);
    writeSingleElemArraysUnwrapped = super.getBoolean(WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED_CONFIG);
    writeDateTimestampsAsNanoseconds = super.getBoolean(WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG);
    orderMapEntriesByKeys = super.getBoolean(ORDER_MAP_ENTRIES_BY_KEYS_CONFIG);
    useEqualityForObjectId = super.getBoolean(USE_EQUALITY_FOR_OBJECT_ID_CONFIG);
  }

  public static ConfigDef config() {
    final ConfigDef config = new ConfigDef();
    config.define(JAVA_TIME_MODULE_ENABLE_CONFIG, ConfigDef.Type.BOOLEAN, false, ConfigDef.Importance.MEDIUM, JAVA_TIME_MODULE_ENABLE_DOC);
    config.define(USE_ANNOTATIONS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.USE_ANNOTATIONS.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_ANNOTATIONS_DOC);
    config.define(USE_GETTERS_AS_SETTERS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.USE_GETTERS_AS_SETTERS.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_GETTERS_AS_SETTERS_DOC);
    config.define(PROPAGATE_TRANSIENT_MARKER_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.PROPAGATE_TRANSIENT_MARKER.enabledByDefault(), ConfigDef.Importance.MEDIUM, PROPAGATE_TRANSIENT_MARKER_DOC);
    config.define(AUTO_DETECT_CREATORS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.AUTO_DETECT_CREATORS.enabledByDefault(), ConfigDef.Importance.MEDIUM, AUTO_DETECT_CREATORS_DOC);
    config.define(AUTO_DETECT_FIELDS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.AUTO_DETECT_FIELDS.enabledByDefault(), ConfigDef.Importance.MEDIUM, AUTO_DETECT_FIELDS_DOC);
    config.define(AUTO_DETECT_GETTERS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.AUTO_DETECT_GETTERS.enabledByDefault(), ConfigDef.Importance.MEDIUM, AUTO_DETECT_GETTERS_DOC);
    config.define(AUTO_DETECT_IS_GETTERS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.AUTO_DETECT_IS_GETTERS.enabledByDefault(), ConfigDef.Importance.MEDIUM, AUTO_DETECT_IS_GETTERS_DOC);
    config.define(AUTO_DETECT_SETTERS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.AUTO_DETECT_SETTERS.enabledByDefault(), ConfigDef.Importance.MEDIUM, AUTO_DETECT_SETTERS_DOC);
    config.define(REQUIRE_SETTERS_FOR_GETTERS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.REQUIRE_SETTERS_FOR_GETTERS.enabledByDefault(), ConfigDef.Importance.MEDIUM, REQUIRE_SETTERS_FOR_GETTERS_DOC);
    config.define(ALLOW_FINAL_FIELDS_AS_MUTATORS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS.enabledByDefault(), ConfigDef.Importance.MEDIUM, ALLOW_FINAL_FIELDS_AS_MUTATORS_DOC);
    config.define(INFER_PROPERTY_MUTATORS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.INFER_PROPERTY_MUTATORS.enabledByDefault(), ConfigDef.Importance.MEDIUM, INFER_PROPERTY_MUTATORS_DOC);
    config.define(INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES.enabledByDefault(), ConfigDef.Importance.MEDIUM, INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES_DOC);
    config.define(CAN_OVERRIDE_ACCESS_MODIFIERS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS.enabledByDefault(), ConfigDef.Importance.MEDIUM, CAN_OVERRIDE_ACCESS_MODIFIERS_DOC);
    config.define(OVERRIDE_PUBLIC_ACCESS_MODIFIERS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS.enabledByDefault(), ConfigDef.Importance.MEDIUM, OVERRIDE_PUBLIC_ACCESS_MODIFIERS_DOC);
    config.define(USE_STATIC_TYPING_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.USE_STATIC_TYPING.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_STATIC_TYPING_DOC);
    config.define(DEFAULT_VIEW_INCLUSION_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.DEFAULT_VIEW_INCLUSION.enabledByDefault(), ConfigDef.Importance.MEDIUM, DEFAULT_VIEW_INCLUSION_DOC);
    config.define(SORT_PROPERTIES_ALPHABETICALLY_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.SORT_PROPERTIES_ALPHABETICALLY.enabledByDefault(), ConfigDef.Importance.MEDIUM, SORT_PROPERTIES_ALPHABETICALLY_DOC);
    config.define(ACCEPT_CASE_INSENSITIVE_PROPERTIES_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES.enabledByDefault(), ConfigDef.Importance.MEDIUM, ACCEPT_CASE_INSENSITIVE_PROPERTIES_DOC);
    config.define(ACCEPT_CASE_INSENSITIVE_ENUMS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS.enabledByDefault(), ConfigDef.Importance.MEDIUM, ACCEPT_CASE_INSENSITIVE_ENUMS_DOC);
    config.define(USE_WRAPPER_NAME_AS_PROPERTY_NAME_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_WRAPPER_NAME_AS_PROPERTY_NAME_DOC);
    config.define(USE_STD_BEAN_NAMING_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.USE_STD_BEAN_NAMING.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_STD_BEAN_NAMING_DOC);
    config.define(ALLOW_EXPLICIT_PROPERTY_RENAMING_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING.enabledByDefault(), ConfigDef.Importance.MEDIUM, ALLOW_EXPLICIT_PROPERTY_RENAMING_DOC);
    config.define(ALLOW_COERCION_OF_SCALARS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.ALLOW_COERCION_OF_SCALARS.enabledByDefault(), ConfigDef.Importance.MEDIUM, ALLOW_COERCION_OF_SCALARS_DOC);
    config.define(IGNORE_DUPLICATE_MODULE_REGISTRATIONS_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS.enabledByDefault(), ConfigDef.Importance.MEDIUM, IGNORE_DUPLICATE_MODULE_REGISTRATIONS_DOC);
    config.define(IGNORE_MERGE_FOR_UNMERGEABLE_CONFIG, ConfigDef.Type.BOOLEAN, MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE.enabledByDefault(), ConfigDef.Importance.MEDIUM, IGNORE_MERGE_FOR_UNMERGEABLE_DOC);
    config.define(WRAP_ROOT_VALUE_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRAP_ROOT_VALUE.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRAP_ROOT_VALUE_DOC);
    config.define(INDENT_OUTPUT_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.INDENT_OUTPUT.enabledByDefault(), ConfigDef.Importance.MEDIUM, INDENT_OUTPUT_DOC);
    config.define(FAIL_ON_EMPTY_BEANS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.FAIL_ON_EMPTY_BEANS.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_EMPTY_BEANS_DOC);
    config.define(FAIL_ON_SELF_REFERENCES_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.FAIL_ON_SELF_REFERENCES.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_SELF_REFERENCES_DOC);
    config.define(WRAP_EXCEPTIONS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRAP_EXCEPTIONS.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRAP_EXCEPTIONS_DOC);
    config.define(FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS_DOC);
    config.define(WRITE_DATES_AS_TIMESTAMPS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_DATES_AS_TIMESTAMPS.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_DATES_AS_TIMESTAMPS_DOC);
    config.define(WRITE_DATE_KEYS_AS_TIMESTAMPS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_DATE_KEYS_AS_TIMESTAMPS_DOC);
    config.define(WRITE_DATES_WITH_ZONE_ID_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_DATES_WITH_ZONE_ID.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_DATES_WITH_ZONE_ID_DOC);
    config.define(WRITE_DURATIONS_AS_TIMESTAMPS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_DURATIONS_AS_TIMESTAMPS_DOC);
    config.define(WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS_DOC);
    config.define(WRITE_ENUMS_USING_TO_STRING_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_ENUMS_USING_TO_STRING.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_ENUMS_USING_TO_STRING_DOC);
    config.define(WRITE_ENUMS_USING_INDEX_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_ENUMS_USING_INDEX.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_ENUMS_USING_INDEX_DOC);
    config.define(WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED_DOC);
    config.define(WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS_DOC);
    config.define(ORDER_MAP_ENTRIES_BY_KEYS_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS.enabledByDefault(), ConfigDef.Importance.MEDIUM, ORDER_MAP_ENTRIES_BY_KEYS_DOC);
    config.define(USE_EQUALITY_FOR_OBJECT_ID_CONFIG, ConfigDef.Type.BOOLEAN, SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_EQUALITY_FOR_OBJECT_ID_DOC);
    return config;
  }

  public static Map<String, String> nonDefaultSettings(final ObjectMapper objectMapper) {
    final Map<String, String> result = new LinkedHashMap();
    boolean isEnabled;
    boolean enabledByDefault;
    isEnabled = objectMapper.isEnabled(MapperFeature.USE_ANNOTATIONS);
    enabledByDefault = MapperFeature.USE_ANNOTATIONS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_ANNOTATIONS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS);
    enabledByDefault = MapperFeature.USE_GETTERS_AS_SETTERS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_GETTERS_AS_SETTERS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
    enabledByDefault = MapperFeature.PROPAGATE_TRANSIENT_MARKER.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(PROPAGATE_TRANSIENT_MARKER_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.AUTO_DETECT_CREATORS);
    enabledByDefault = MapperFeature.AUTO_DETECT_CREATORS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(AUTO_DETECT_CREATORS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.AUTO_DETECT_FIELDS);
    enabledByDefault = MapperFeature.AUTO_DETECT_FIELDS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(AUTO_DETECT_FIELDS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.AUTO_DETECT_GETTERS);
    enabledByDefault = MapperFeature.AUTO_DETECT_GETTERS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(AUTO_DETECT_GETTERS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.AUTO_DETECT_IS_GETTERS);
    enabledByDefault = MapperFeature.AUTO_DETECT_IS_GETTERS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(AUTO_DETECT_IS_GETTERS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.AUTO_DETECT_SETTERS);
    enabledByDefault = MapperFeature.AUTO_DETECT_SETTERS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(AUTO_DETECT_SETTERS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
    enabledByDefault = MapperFeature.REQUIRE_SETTERS_FOR_GETTERS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(REQUIRE_SETTERS_FOR_GETTERS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS);
    enabledByDefault = MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ALLOW_FINAL_FIELDS_AS_MUTATORS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS);
    enabledByDefault = MapperFeature.INFER_PROPERTY_MUTATORS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(INFER_PROPERTY_MUTATORS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES);
    enabledByDefault = MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    enabledByDefault = MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(CAN_OVERRIDE_ACCESS_MODIFIERS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    enabledByDefault = MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(OVERRIDE_PUBLIC_ACCESS_MODIFIERS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.USE_STATIC_TYPING);
    enabledByDefault = MapperFeature.USE_STATIC_TYPING.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_STATIC_TYPING_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
    enabledByDefault = MapperFeature.DEFAULT_VIEW_INCLUSION.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(DEFAULT_VIEW_INCLUSION_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
    enabledByDefault = MapperFeature.SORT_PROPERTIES_ALPHABETICALLY.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(SORT_PROPERTIES_ALPHABETICALLY_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
    enabledByDefault = MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ACCEPT_CASE_INSENSITIVE_PROPERTIES_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
    enabledByDefault = MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ACCEPT_CASE_INSENSITIVE_ENUMS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME);
    enabledByDefault = MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_WRAPPER_NAME_AS_PROPERTY_NAME_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
    enabledByDefault = MapperFeature.USE_STD_BEAN_NAMING.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_STD_BEAN_NAMING_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING);
    enabledByDefault = MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ALLOW_EXPLICIT_PROPERTY_RENAMING_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS);
    enabledByDefault = MapperFeature.ALLOW_COERCION_OF_SCALARS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ALLOW_COERCION_OF_SCALARS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS);
    enabledByDefault = MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(IGNORE_DUPLICATE_MODULE_REGISTRATIONS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE);
    enabledByDefault = MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(IGNORE_MERGE_FOR_UNMERGEABLE_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
    enabledByDefault = SerializationFeature.WRAP_ROOT_VALUE.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRAP_ROOT_VALUE_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.INDENT_OUTPUT);
    enabledByDefault = SerializationFeature.INDENT_OUTPUT.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(INDENT_OUTPUT_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    enabledByDefault = SerializationFeature.FAIL_ON_EMPTY_BEANS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_EMPTY_BEANS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.FAIL_ON_SELF_REFERENCES);
    enabledByDefault = SerializationFeature.FAIL_ON_SELF_REFERENCES.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_SELF_REFERENCES_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRAP_EXCEPTIONS);
    enabledByDefault = SerializationFeature.WRAP_EXCEPTIONS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRAP_EXCEPTIONS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
    enabledByDefault = SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    enabledByDefault = SerializationFeature.WRITE_DATES_AS_TIMESTAMPS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_DATES_AS_TIMESTAMPS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
    enabledByDefault = SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_DATE_KEYS_AS_TIMESTAMPS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
    enabledByDefault = SerializationFeature.WRITE_DATES_WITH_ZONE_ID.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_DATES_WITH_ZONE_ID_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS);
    enabledByDefault = SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_DURATIONS_AS_TIMESTAMPS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS);
    enabledByDefault = SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    enabledByDefault = SerializationFeature.WRITE_ENUMS_USING_TO_STRING.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_ENUMS_USING_TO_STRING_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_ENUMS_USING_INDEX);
    enabledByDefault = SerializationFeature.WRITE_ENUMS_USING_INDEX.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_ENUMS_USING_INDEX_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
    enabledByDefault = SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
    enabledByDefault = SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
    enabledByDefault = SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ORDER_MAP_ENTRIES_BY_KEYS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID);
    enabledByDefault = SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_EQUALITY_FOR_OBJECT_ID_CONFIG, Boolean.toString(isEnabled));
    }
    return result;
  }

  public void configure(final ObjectMapper objectMapper) {
    if (javaTimeModuleEnable) {
      objectMapper.registerModule(new JavaTimeModule());
    }
    objectMapper.configure(MapperFeature.USE_ANNOTATIONS, useAnnotations);
    objectMapper.configure(MapperFeature.USE_GETTERS_AS_SETTERS, useGettersAsSetters);
    objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, propagateTransientMarker);
    objectMapper.configure(MapperFeature.AUTO_DETECT_CREATORS, autoDetectCreators);
    objectMapper.configure(MapperFeature.AUTO_DETECT_FIELDS, autoDetectFields);
    objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, autoDetectGetters);
    objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, autoDetectIsGetters);
    objectMapper.configure(MapperFeature.AUTO_DETECT_SETTERS, autoDetectSetters);
    objectMapper.configure(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS, requireSettersForGetters);
    objectMapper.configure(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS, allowFinalFieldsAsMutators);
    objectMapper.configure(MapperFeature.INFER_PROPERTY_MUTATORS, inferPropertyMutators);
    objectMapper.configure(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES, inferCreatorFromConstructorProperties);
    objectMapper.configure(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS, canOverrideAccessModifiers);
    objectMapper.configure(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS, overridePublicAccessModifiers);
    objectMapper.configure(MapperFeature.USE_STATIC_TYPING, useStaticTyping);
    objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, defaultViewInclusion);
    objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, sortPropertiesAlphabetically);
    objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, acceptCaseInsensitiveProperties);
    objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, acceptCaseInsensitiveEnums);
    objectMapper.configure(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME, useWrapperNameAsPropertyName);
    objectMapper.configure(MapperFeature.USE_STD_BEAN_NAMING, useStdBeanNaming);
    objectMapper.configure(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING, allowExplicitPropertyRenaming);
    objectMapper.configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, allowCoercionOfScalars);
    objectMapper.configure(MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS, ignoreDuplicateModuleRegistrations);
    objectMapper.configure(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE, ignoreMergeForUnmergeable);
    objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, wrapRootValue);
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, indentOutput);
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, failOnEmptyBeans);
    objectMapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, failOnSelfReferences);
    objectMapper.configure(SerializationFeature.WRAP_EXCEPTIONS, wrapExceptions);
    objectMapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, failOnUnwrappedTypeIdentifiers);
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, writeDatesAsTimestamps);
    objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, writeDateKeysAsTimestamps);
    objectMapper.configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, writeDatesWithZoneId);
    objectMapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, writeDurationsAsTimestamps);
    objectMapper.configure(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS, writeCharArraysAsJsonArrays);
    objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, writeEnumsUsingToString);
    objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, writeEnumsUsingIndex);
    objectMapper.configure(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED, writeSingleElemArraysUnwrapped);
    objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, writeDateTimestampsAsNanoseconds);
    objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, orderMapEntriesByKeys);
    objectMapper.configure(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID, useEqualityForObjectId);
  }

}
