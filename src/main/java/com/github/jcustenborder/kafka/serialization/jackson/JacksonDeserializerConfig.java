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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.ConfigFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class JacksonDeserializerConfig extends AbstractConfig {

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
  public final static String USE_BIG_DECIMAL_FOR_FLOATS_CONFIG = "use.big.decimal.for.floats.enable";
  public final static String USE_BIG_INTEGER_FOR_INTS_CONFIG = "use.big.integer.for.ints.enable";
  public final static String USE_LONG_FOR_INTS_CONFIG = "use.long.for.ints.enable";
  public final static String USE_JAVA_ARRAY_FOR_JSON_ARRAY_CONFIG = "use.java.array.for.json.array.enable";
  public final static String FAIL_ON_UNKNOWN_PROPERTIES_CONFIG = "fail.on.unknown.properties.enable";
  public final static String FAIL_ON_NULL_FOR_PRIMITIVES_CONFIG = "fail.on.null.for.primitives.enable";
  public final static String FAIL_ON_NUMBERS_FOR_ENUMS_CONFIG = "fail.on.numbers.for.enums.enable";
  public final static String FAIL_ON_INVALID_SUBTYPE_CONFIG = "fail.on.invalid.subtype.enable";
  public final static String FAIL_ON_READING_DUP_TREE_KEY_CONFIG = "fail.on.reading.dup.tree.key.enable";
  public final static String FAIL_ON_IGNORED_PROPERTIES_CONFIG = "fail.on.ignored.properties.enable";
  public final static String FAIL_ON_UNRESOLVED_OBJECT_IDS_CONFIG = "fail.on.unresolved.object.ids.enable";
  public final static String FAIL_ON_MISSING_CREATOR_PROPERTIES_CONFIG = "fail.on.missing.creator.properties.enable";
  public final static String FAIL_ON_NULL_CREATOR_PROPERTIES_CONFIG = "fail.on.null.creator.properties.enable";
  public final static String FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY_CONFIG = "fail.on.missing.external.type.id.property.enable";
  public final static String FAIL_ON_TRAILING_TOKENS_CONFIG = "fail.on.trailing.tokens.enable";
  public final static String WRAP_EXCEPTIONS_CONFIG = "wrap.exceptions.enable";
  public final static String ACCEPT_SINGLE_VALUE_AS_ARRAY_CONFIG = "accept.single.value.as.array.enable";
  public final static String UNWRAP_SINGLE_VALUE_ARRAYS_CONFIG = "unwrap.single.value.arrays.enable";
  public final static String UNWRAP_ROOT_VALUE_CONFIG = "unwrap.root.value.enable";
  public final static String ACCEPT_EMPTY_STRING_AS_NULL_OBJECT_CONFIG = "accept.empty.string.as.null.object.enable";
  public final static String ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT_CONFIG = "accept.empty.array.as.null.object.enable";
  public final static String ACCEPT_FLOAT_AS_INT_CONFIG = "accept.float.as.int.enable";
  public final static String READ_ENUMS_USING_TO_STRING_CONFIG = "read.enums.using.to.string.enable";
  public final static String READ_UNKNOWN_ENUM_VALUES_AS_NULL_CONFIG = "read.unknown.enum.values.as.null.enable";
  public final static String READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE_CONFIG = "read.unknown.enum.values.using.default.value.enable";
  public final static String READ_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG = "read.date.timestamps.as.nanoseconds.enable";
  public final static String ADJUST_DATES_TO_CONTEXT_TIME_ZONE_CONFIG = "adjust.dates.to.context.time.zone.enable";
  public final static String EAGER_DESERIALIZER_FETCH_CONFIG = "eager.deserializer.fetch.enable";
  public final static String OUTPUT_CLASS_CONFIG = "output.class";
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
  final static String USE_BIG_DECIMAL_FOR_FLOATS_DOC = "See [USE_BIG_DECIMAL_FOR_FLOATS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#USE_BIG_DECIMAL_FOR_FLOATS)";
  final static String USE_BIG_INTEGER_FOR_INTS_DOC = "See [USE_BIG_INTEGER_FOR_INTS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#USE_BIG_INTEGER_FOR_INTS)";
  final static String USE_LONG_FOR_INTS_DOC = "See [USE_LONG_FOR_INTS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#USE_LONG_FOR_INTS)";
  final static String USE_JAVA_ARRAY_FOR_JSON_ARRAY_DOC = "See [USE_JAVA_ARRAY_FOR_JSON_ARRAY](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#USE_JAVA_ARRAY_FOR_JSON_ARRAY)";
  final static String FAIL_ON_UNKNOWN_PROPERTIES_DOC = "See [FAIL_ON_UNKNOWN_PROPERTIES](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_UNKNOWN_PROPERTIES)";
  final static String FAIL_ON_NULL_FOR_PRIMITIVES_DOC = "See [FAIL_ON_NULL_FOR_PRIMITIVES](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_NULL_FOR_PRIMITIVES)";
  final static String FAIL_ON_NUMBERS_FOR_ENUMS_DOC = "See [FAIL_ON_NUMBERS_FOR_ENUMS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_NUMBERS_FOR_ENUMS)";
  final static String FAIL_ON_INVALID_SUBTYPE_DOC = "See [FAIL_ON_INVALID_SUBTYPE](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_INVALID_SUBTYPE)";
  final static String FAIL_ON_READING_DUP_TREE_KEY_DOC = "See [FAIL_ON_READING_DUP_TREE_KEY](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_READING_DUP_TREE_KEY)";
  final static String FAIL_ON_IGNORED_PROPERTIES_DOC = "See [FAIL_ON_IGNORED_PROPERTIES](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_IGNORED_PROPERTIES)";
  final static String FAIL_ON_UNRESOLVED_OBJECT_IDS_DOC = "See [FAIL_ON_UNRESOLVED_OBJECT_IDS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_UNRESOLVED_OBJECT_IDS)";
  final static String FAIL_ON_MISSING_CREATOR_PROPERTIES_DOC = "See [FAIL_ON_MISSING_CREATOR_PROPERTIES](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_MISSING_CREATOR_PROPERTIES)";
  final static String FAIL_ON_NULL_CREATOR_PROPERTIES_DOC = "See [FAIL_ON_NULL_CREATOR_PROPERTIES](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_NULL_CREATOR_PROPERTIES)";
  final static String FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY_DOC = "See [FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)";
  final static String FAIL_ON_TRAILING_TOKENS_DOC = "See [FAIL_ON_TRAILING_TOKENS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#FAIL_ON_TRAILING_TOKENS)";
  final static String WRAP_EXCEPTIONS_DOC = "See [WRAP_EXCEPTIONS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#WRAP_EXCEPTIONS)";
  final static String ACCEPT_SINGLE_VALUE_AS_ARRAY_DOC = "See [ACCEPT_SINGLE_VALUE_AS_ARRAY](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#ACCEPT_SINGLE_VALUE_AS_ARRAY)";
  final static String UNWRAP_SINGLE_VALUE_ARRAYS_DOC = "See [UNWRAP_SINGLE_VALUE_ARRAYS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#UNWRAP_SINGLE_VALUE_ARRAYS)";
  final static String UNWRAP_ROOT_VALUE_DOC = "See [UNWRAP_ROOT_VALUE](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#UNWRAP_ROOT_VALUE)";
  final static String ACCEPT_EMPTY_STRING_AS_NULL_OBJECT_DOC = "See [ACCEPT_EMPTY_STRING_AS_NULL_OBJECT](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)";
  final static String ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT_DOC = "See [ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)";
  final static String ACCEPT_FLOAT_AS_INT_DOC = "See [ACCEPT_FLOAT_AS_INT](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#ACCEPT_FLOAT_AS_INT)";
  final static String READ_ENUMS_USING_TO_STRING_DOC = "See [READ_ENUMS_USING_TO_STRING](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#READ_ENUMS_USING_TO_STRING)";
  final static String READ_UNKNOWN_ENUM_VALUES_AS_NULL_DOC = "See [READ_UNKNOWN_ENUM_VALUES_AS_NULL](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#READ_UNKNOWN_ENUM_VALUES_AS_NULL)";
  final static String READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE_DOC = "See [READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)";
  final static String READ_DATE_TIMESTAMPS_AS_NANOSECONDS_DOC = "See [READ_DATE_TIMESTAMPS_AS_NANOSECONDS](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#READ_DATE_TIMESTAMPS_AS_NANOSECONDS)";
  final static String ADJUST_DATES_TO_CONTEXT_TIME_ZONE_DOC = "See [ADJUST_DATES_TO_CONTEXT_TIME_ZONE](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#ADJUST_DATES_TO_CONTEXT_TIME_ZONE)";
  final static String EAGER_DESERIALIZER_FETCH_DOC = "See [EAGER_DESERIALIZER_FETCH](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/DeserializationFeature.html#EAGER_DESERIALIZER_FETCH)";
  final static String OUTPUT_CLASS_DOC = "The java class to deserialize to.";

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
    configFeatureToConfig.put(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, USE_BIG_DECIMAL_FOR_FLOATS_CONFIG);
    configToConfigFeature.put(USE_BIG_DECIMAL_FOR_FLOATS_CONFIG, DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
    configFeatureToConfig.put(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS, USE_BIG_INTEGER_FOR_INTS_CONFIG);
    configToConfigFeature.put(USE_BIG_INTEGER_FOR_INTS_CONFIG, DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
    configFeatureToConfig.put(DeserializationFeature.USE_LONG_FOR_INTS, USE_LONG_FOR_INTS_CONFIG);
    configToConfigFeature.put(USE_LONG_FOR_INTS_CONFIG, DeserializationFeature.USE_LONG_FOR_INTS);
    configFeatureToConfig.put(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, USE_JAVA_ARRAY_FOR_JSON_ARRAY_CONFIG);
    configToConfigFeature.put(USE_JAVA_ARRAY_FOR_JSON_ARRAY_CONFIG, DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, FAIL_ON_UNKNOWN_PROPERTIES_CONFIG);
    configToConfigFeature.put(FAIL_ON_UNKNOWN_PROPERTIES_CONFIG, DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, FAIL_ON_NULL_FOR_PRIMITIVES_CONFIG);
    configToConfigFeature.put(FAIL_ON_NULL_FOR_PRIMITIVES_CONFIG, DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, FAIL_ON_NUMBERS_FOR_ENUMS_CONFIG);
    configToConfigFeature.put(FAIL_ON_NUMBERS_FOR_ENUMS_CONFIG, DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, FAIL_ON_INVALID_SUBTYPE_CONFIG);
    configToConfigFeature.put(FAIL_ON_INVALID_SUBTYPE_CONFIG, DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY, FAIL_ON_READING_DUP_TREE_KEY_CONFIG);
    configToConfigFeature.put(FAIL_ON_READING_DUP_TREE_KEY_CONFIG, DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, FAIL_ON_IGNORED_PROPERTIES_CONFIG);
    configToConfigFeature.put(FAIL_ON_IGNORED_PROPERTIES_CONFIG, DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, FAIL_ON_UNRESOLVED_OBJECT_IDS_CONFIG);
    configToConfigFeature.put(FAIL_ON_UNRESOLVED_OBJECT_IDS_CONFIG, DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, FAIL_ON_MISSING_CREATOR_PROPERTIES_CONFIG);
    configToConfigFeature.put(FAIL_ON_MISSING_CREATOR_PROPERTIES_CONFIG, DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, FAIL_ON_NULL_CREATOR_PROPERTIES_CONFIG);
    configToConfigFeature.put(FAIL_ON_NULL_CREATOR_PROPERTIES_CONFIG, DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY, FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY_CONFIG);
    configToConfigFeature.put(FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY_CONFIG, DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY);
    configFeatureToConfig.put(DeserializationFeature.FAIL_ON_TRAILING_TOKENS, FAIL_ON_TRAILING_TOKENS_CONFIG);
    configToConfigFeature.put(FAIL_ON_TRAILING_TOKENS_CONFIG, DeserializationFeature.FAIL_ON_TRAILING_TOKENS);
    configFeatureToConfig.put(DeserializationFeature.WRAP_EXCEPTIONS, WRAP_EXCEPTIONS_CONFIG);
    configToConfigFeature.put(WRAP_EXCEPTIONS_CONFIG, DeserializationFeature.WRAP_EXCEPTIONS);
    configFeatureToConfig.put(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, ACCEPT_SINGLE_VALUE_AS_ARRAY_CONFIG);
    configToConfigFeature.put(ACCEPT_SINGLE_VALUE_AS_ARRAY_CONFIG, DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    configFeatureToConfig.put(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, UNWRAP_SINGLE_VALUE_ARRAYS_CONFIG);
    configToConfigFeature.put(UNWRAP_SINGLE_VALUE_ARRAYS_CONFIG, DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
    configFeatureToConfig.put(DeserializationFeature.UNWRAP_ROOT_VALUE, UNWRAP_ROOT_VALUE_CONFIG);
    configToConfigFeature.put(UNWRAP_ROOT_VALUE_CONFIG, DeserializationFeature.UNWRAP_ROOT_VALUE);
    configFeatureToConfig.put(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, ACCEPT_EMPTY_STRING_AS_NULL_OBJECT_CONFIG);
    configToConfigFeature.put(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT_CONFIG, DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    configFeatureToConfig.put(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT_CONFIG);
    configToConfigFeature.put(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT_CONFIG, DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
    configFeatureToConfig.put(DeserializationFeature.ACCEPT_FLOAT_AS_INT, ACCEPT_FLOAT_AS_INT_CONFIG);
    configToConfigFeature.put(ACCEPT_FLOAT_AS_INT_CONFIG, DeserializationFeature.ACCEPT_FLOAT_AS_INT);
    configFeatureToConfig.put(DeserializationFeature.READ_ENUMS_USING_TO_STRING, READ_ENUMS_USING_TO_STRING_CONFIG);
    configToConfigFeature.put(READ_ENUMS_USING_TO_STRING_CONFIG, DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    configFeatureToConfig.put(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, READ_UNKNOWN_ENUM_VALUES_AS_NULL_CONFIG);
    configToConfigFeature.put(READ_UNKNOWN_ENUM_VALUES_AS_NULL_CONFIG, DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    configFeatureToConfig.put(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE_CONFIG);
    configToConfigFeature.put(READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE_CONFIG, DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
    configFeatureToConfig.put(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, READ_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG);
    configToConfigFeature.put(READ_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG, DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
    configFeatureToConfig.put(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, ADJUST_DATES_TO_CONTEXT_TIME_ZONE_CONFIG);
    configToConfigFeature.put(ADJUST_DATES_TO_CONTEXT_TIME_ZONE_CONFIG, DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
    configFeatureToConfig.put(DeserializationFeature.EAGER_DESERIALIZER_FETCH, EAGER_DESERIALIZER_FETCH_CONFIG);
    configToConfigFeature.put(EAGER_DESERIALIZER_FETCH_CONFIG, DeserializationFeature.EAGER_DESERIALIZER_FETCH);
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
  public final Boolean useBigDecimalForFloats;
  public final Boolean useBigIntegerForInts;
  public final Boolean useLongForInts;
  public final Boolean useJavaArrayForJsonArray;
  public final Boolean failOnUnknownProperties;
  public final Boolean failOnNullForPrimitives;
  public final Boolean failOnNumbersForEnums;
  public final Boolean failOnInvalidSubtype;
  public final Boolean failOnReadingDupTreeKey;
  public final Boolean failOnIgnoredProperties;
  public final Boolean failOnUnresolvedObjectIds;
  public final Boolean failOnMissingCreatorProperties;
  public final Boolean failOnNullCreatorProperties;
  public final Boolean failOnMissingExternalTypeIdProperty;
  public final Boolean failOnTrailingTokens;
  public final Boolean wrapExceptions;
  public final Boolean acceptSingleValueAsArray;
  public final Boolean unwrapSingleValueArrays;
  public final Boolean unwrapRootValue;
  public final Boolean acceptEmptyStringAsNullObject;
  public final Boolean acceptEmptyArrayAsNullObject;
  public final Boolean acceptFloatAsInt;
  public final Boolean readEnumsUsingToString;
  public final Boolean readUnknownEnumValuesAsNull;
  public final Boolean readUnknownEnumValuesUsingDefaultValue;
  public final Boolean readDateTimestampsAsNanoseconds;
  public final Boolean adjustDatesToContextTimeZone;
  public final Boolean eagerDeserializerFetch;
  public final Class outputClass;

  public JacksonDeserializerConfig(Map<String, ?> settings) {
    super(JacksonDeserializerConfig.config(), settings);
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
    useBigDecimalForFloats = super.getBoolean(USE_BIG_DECIMAL_FOR_FLOATS_CONFIG);
    useBigIntegerForInts = super.getBoolean(USE_BIG_INTEGER_FOR_INTS_CONFIG);
    useLongForInts = super.getBoolean(USE_LONG_FOR_INTS_CONFIG);
    useJavaArrayForJsonArray = super.getBoolean(USE_JAVA_ARRAY_FOR_JSON_ARRAY_CONFIG);
    failOnUnknownProperties = super.getBoolean(FAIL_ON_UNKNOWN_PROPERTIES_CONFIG);
    failOnNullForPrimitives = super.getBoolean(FAIL_ON_NULL_FOR_PRIMITIVES_CONFIG);
    failOnNumbersForEnums = super.getBoolean(FAIL_ON_NUMBERS_FOR_ENUMS_CONFIG);
    failOnInvalidSubtype = super.getBoolean(FAIL_ON_INVALID_SUBTYPE_CONFIG);
    failOnReadingDupTreeKey = super.getBoolean(FAIL_ON_READING_DUP_TREE_KEY_CONFIG);
    failOnIgnoredProperties = super.getBoolean(FAIL_ON_IGNORED_PROPERTIES_CONFIG);
    failOnUnresolvedObjectIds = super.getBoolean(FAIL_ON_UNRESOLVED_OBJECT_IDS_CONFIG);
    failOnMissingCreatorProperties = super.getBoolean(FAIL_ON_MISSING_CREATOR_PROPERTIES_CONFIG);
    failOnNullCreatorProperties = super.getBoolean(FAIL_ON_NULL_CREATOR_PROPERTIES_CONFIG);
    failOnMissingExternalTypeIdProperty = super.getBoolean(FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY_CONFIG);
    failOnTrailingTokens = super.getBoolean(FAIL_ON_TRAILING_TOKENS_CONFIG);
    wrapExceptions = super.getBoolean(WRAP_EXCEPTIONS_CONFIG);
    acceptSingleValueAsArray = super.getBoolean(ACCEPT_SINGLE_VALUE_AS_ARRAY_CONFIG);
    unwrapSingleValueArrays = super.getBoolean(UNWRAP_SINGLE_VALUE_ARRAYS_CONFIG);
    unwrapRootValue = super.getBoolean(UNWRAP_ROOT_VALUE_CONFIG);
    acceptEmptyStringAsNullObject = super.getBoolean(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT_CONFIG);
    acceptEmptyArrayAsNullObject = super.getBoolean(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT_CONFIG);
    acceptFloatAsInt = super.getBoolean(ACCEPT_FLOAT_AS_INT_CONFIG);
    readEnumsUsingToString = super.getBoolean(READ_ENUMS_USING_TO_STRING_CONFIG);
    readUnknownEnumValuesAsNull = super.getBoolean(READ_UNKNOWN_ENUM_VALUES_AS_NULL_CONFIG);
    readUnknownEnumValuesUsingDefaultValue = super.getBoolean(READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE_CONFIG);
    readDateTimestampsAsNanoseconds = super.getBoolean(READ_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG);
    adjustDatesToContextTimeZone = super.getBoolean(ADJUST_DATES_TO_CONTEXT_TIME_ZONE_CONFIG);
    eagerDeserializerFetch = super.getBoolean(EAGER_DESERIALIZER_FETCH_CONFIG);
    outputClass = super.getClass(OUTPUT_CLASS_CONFIG);
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
    config.define(USE_BIG_DECIMAL_FOR_FLOATS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_BIG_DECIMAL_FOR_FLOATS_DOC);
    config.define(USE_BIG_INTEGER_FOR_INTS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_BIG_INTEGER_FOR_INTS_DOC);
    config.define(USE_LONG_FOR_INTS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.USE_LONG_FOR_INTS.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_LONG_FOR_INTS_DOC);
    config.define(USE_JAVA_ARRAY_FOR_JSON_ARRAY_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY.enabledByDefault(), ConfigDef.Importance.MEDIUM, USE_JAVA_ARRAY_FOR_JSON_ARRAY_DOC);
    config.define(FAIL_ON_UNKNOWN_PROPERTIES_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_UNKNOWN_PROPERTIES_DOC);
    config.define(FAIL_ON_NULL_FOR_PRIMITIVES_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_NULL_FOR_PRIMITIVES_DOC);
    config.define(FAIL_ON_NUMBERS_FOR_ENUMS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_NUMBERS_FOR_ENUMS_DOC);
    config.define(FAIL_ON_INVALID_SUBTYPE_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_INVALID_SUBTYPE.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_INVALID_SUBTYPE_DOC);
    config.define(FAIL_ON_READING_DUP_TREE_KEY_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_READING_DUP_TREE_KEY_DOC);
    config.define(FAIL_ON_IGNORED_PROPERTIES_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_IGNORED_PROPERTIES_DOC);
    config.define(FAIL_ON_UNRESOLVED_OBJECT_IDS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_UNRESOLVED_OBJECT_IDS_DOC);
    config.define(FAIL_ON_MISSING_CREATOR_PROPERTIES_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_MISSING_CREATOR_PROPERTIES_DOC);
    config.define(FAIL_ON_NULL_CREATOR_PROPERTIES_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_NULL_CREATOR_PROPERTIES_DOC);
    config.define(FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY_DOC);
    config.define(FAIL_ON_TRAILING_TOKENS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.FAIL_ON_TRAILING_TOKENS.enabledByDefault(), ConfigDef.Importance.MEDIUM, FAIL_ON_TRAILING_TOKENS_DOC);
    config.define(WRAP_EXCEPTIONS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.WRAP_EXCEPTIONS.enabledByDefault(), ConfigDef.Importance.MEDIUM, WRAP_EXCEPTIONS_DOC);
    config.define(ACCEPT_SINGLE_VALUE_AS_ARRAY_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY.enabledByDefault(), ConfigDef.Importance.MEDIUM, ACCEPT_SINGLE_VALUE_AS_ARRAY_DOC);
    config.define(UNWRAP_SINGLE_VALUE_ARRAYS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS.enabledByDefault(), ConfigDef.Importance.MEDIUM, UNWRAP_SINGLE_VALUE_ARRAYS_DOC);
    config.define(UNWRAP_ROOT_VALUE_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.UNWRAP_ROOT_VALUE.enabledByDefault(), ConfigDef.Importance.MEDIUM, UNWRAP_ROOT_VALUE_DOC);
    config.define(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT.enabledByDefault(), ConfigDef.Importance.MEDIUM, ACCEPT_EMPTY_STRING_AS_NULL_OBJECT_DOC);
    config.define(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.enabledByDefault(), ConfigDef.Importance.MEDIUM, ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT_DOC);
    config.define(ACCEPT_FLOAT_AS_INT_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.ACCEPT_FLOAT_AS_INT.enabledByDefault(), ConfigDef.Importance.MEDIUM, ACCEPT_FLOAT_AS_INT_DOC);
    config.define(READ_ENUMS_USING_TO_STRING_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.READ_ENUMS_USING_TO_STRING.enabledByDefault(), ConfigDef.Importance.MEDIUM, READ_ENUMS_USING_TO_STRING_DOC);
    config.define(READ_UNKNOWN_ENUM_VALUES_AS_NULL_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL.enabledByDefault(), ConfigDef.Importance.MEDIUM, READ_UNKNOWN_ENUM_VALUES_AS_NULL_DOC);
    config.define(READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE.enabledByDefault(), ConfigDef.Importance.MEDIUM, READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE_DOC);
    config.define(READ_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS.enabledByDefault(), ConfigDef.Importance.MEDIUM, READ_DATE_TIMESTAMPS_AS_NANOSECONDS_DOC);
    config.define(ADJUST_DATES_TO_CONTEXT_TIME_ZONE_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE.enabledByDefault(), ConfigDef.Importance.MEDIUM, ADJUST_DATES_TO_CONTEXT_TIME_ZONE_DOC);
    config.define(EAGER_DESERIALIZER_FETCH_CONFIG, ConfigDef.Type.BOOLEAN, DeserializationFeature.EAGER_DESERIALIZER_FETCH.enabledByDefault(), ConfigDef.Importance.MEDIUM, EAGER_DESERIALIZER_FETCH_DOC);
    config.define(OUTPUT_CLASS_CONFIG, ConfigDef.Type.CLASS, JsonNode.class.getName(), ConfigDef.Importance.HIGH, OUTPUT_CLASS_DOC);
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
    isEnabled = objectMapper.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
    enabledByDefault = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_BIG_DECIMAL_FOR_FLOATS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
    enabledByDefault = DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_BIG_INTEGER_FOR_INTS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS);
    enabledByDefault = DeserializationFeature.USE_LONG_FOR_INTS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_LONG_FOR_INTS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY);
    enabledByDefault = DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(USE_JAVA_ARRAY_FOR_JSON_ARRAY_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    enabledByDefault = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_UNKNOWN_PROPERTIES_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
    enabledByDefault = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_NULL_FOR_PRIMITIVES_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
    enabledByDefault = DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_NUMBERS_FOR_ENUMS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
    enabledByDefault = DeserializationFeature.FAIL_ON_INVALID_SUBTYPE.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_INVALID_SUBTYPE_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
    enabledByDefault = DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_READING_DUP_TREE_KEY_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    enabledByDefault = DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_IGNORED_PROPERTIES_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS);
    enabledByDefault = DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_UNRESOLVED_OBJECT_IDS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES);
    enabledByDefault = DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_MISSING_CREATOR_PROPERTIES_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES);
    enabledByDefault = DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_NULL_CREATOR_PROPERTIES_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY);
    enabledByDefault = DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS);
    enabledByDefault = DeserializationFeature.FAIL_ON_TRAILING_TOKENS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(FAIL_ON_TRAILING_TOKENS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS);
    enabledByDefault = DeserializationFeature.WRAP_EXCEPTIONS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(WRAP_EXCEPTIONS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    enabledByDefault = DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ACCEPT_SINGLE_VALUE_AS_ARRAY_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
    enabledByDefault = DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(UNWRAP_SINGLE_VALUE_ARRAYS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.UNWRAP_ROOT_VALUE);
    enabledByDefault = DeserializationFeature.UNWRAP_ROOT_VALUE.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(UNWRAP_ROOT_VALUE_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    enabledByDefault = DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
    enabledByDefault = DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT);
    enabledByDefault = DeserializationFeature.ACCEPT_FLOAT_AS_INT.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ACCEPT_FLOAT_AS_INT_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    enabledByDefault = DeserializationFeature.READ_ENUMS_USING_TO_STRING.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(READ_ENUMS_USING_TO_STRING_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    enabledByDefault = DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(READ_UNKNOWN_ENUM_VALUES_AS_NULL_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
    enabledByDefault = DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
    enabledByDefault = DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(READ_DATE_TIMESTAMPS_AS_NANOSECONDS_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
    enabledByDefault = DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(ADJUST_DATES_TO_CONTEXT_TIME_ZONE_CONFIG, Boolean.toString(isEnabled));
    }
    isEnabled = objectMapper.isEnabled(DeserializationFeature.EAGER_DESERIALIZER_FETCH);
    enabledByDefault = DeserializationFeature.EAGER_DESERIALIZER_FETCH.enabledByDefault();
    if (enabledByDefault != isEnabled) {
      result.put(EAGER_DESERIALIZER_FETCH_CONFIG, Boolean.toString(isEnabled));
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
    objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, useBigDecimalForFloats);
    objectMapper.configure(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS, useBigIntegerForInts);
    objectMapper.configure(DeserializationFeature.USE_LONG_FOR_INTS, useLongForInts);
    objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, useJavaArrayForJsonArray);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties);
    objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, failOnNullForPrimitives);
    objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, failOnNumbersForEnums);
    objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, failOnInvalidSubtype);
    objectMapper.configure(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY, failOnReadingDupTreeKey);
    objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, failOnIgnoredProperties);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, failOnUnresolvedObjectIds);
    objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, failOnMissingCreatorProperties);
    objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, failOnNullCreatorProperties);
    objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY, failOnMissingExternalTypeIdProperty);
    objectMapper.configure(DeserializationFeature.FAIL_ON_TRAILING_TOKENS, failOnTrailingTokens);
    objectMapper.configure(DeserializationFeature.WRAP_EXCEPTIONS, wrapExceptions);
    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, acceptSingleValueAsArray);
    objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, unwrapSingleValueArrays);
    objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, unwrapRootValue);
    objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, acceptEmptyStringAsNullObject);
    objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, acceptEmptyArrayAsNullObject);
    objectMapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, acceptFloatAsInt);
    objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, readEnumsUsingToString);
    objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, readUnknownEnumValuesAsNull);
    objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, readUnknownEnumValuesUsingDefaultValue);
    objectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, readDateTimestampsAsNanoseconds);
    objectMapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, adjustDatesToContextTimeZone);
    objectMapper.configure(DeserializationFeature.EAGER_DESERIALIZER_FETCH, eagerDeserializerFetch);
  }

}
