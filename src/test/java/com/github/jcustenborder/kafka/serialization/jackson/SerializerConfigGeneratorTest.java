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

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ConfigFeature;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SerializerConfigGeneratorTest extends ConfigGeneratorTest {

  @Override
  protected Set<ConfigFeature> skip() {
    return ImmutableSet.of(
        SerializationFeature.CLOSE_CLOSEABLE,
        SerializationFeature.FLUSH_AFTER_WRITE_VALUE,
        SerializationFeature.EAGER_SERIALIZER_FETCH,
        SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN,
        SerializationFeature.WRITE_EMPTY_JSON_ARRAYS,
        SerializationFeature.WRITE_NULL_MAP_VALUES
    );
  }

  @Override
  protected List<ConfigFeature> features() {
    List<ConfigFeature> features = new ArrayList<>();
    Arrays.stream(MapperFeature.values()).forEach(features::add);
    Arrays.stream(SerializationFeature.values()).forEach(features::add);
    return features;
  }

  @Override
  protected String fullyQualifiedClassName() {
    return JacksonSerializerConfig.class.getName();
  }

  @Override
  protected void after() {

  }
}
