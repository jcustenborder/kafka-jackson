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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class JacksonSerializer<T> implements Serializer<T> {
  private ObjectMapper objectMapper;
  private JacksonSerializerConfig config;

  public JacksonSerializer() {
    this.objectMapper = new ObjectMapper();
  }

  public static Map<String, String> nonDefaultSettings(ObjectMapper objectMapper) {
    return JacksonSerializerConfig.nonDefaultSettings(objectMapper);
  }

  @Override
  public void configure(Map<String, ?> settings, boolean isKey) {
    this.config = new JacksonSerializerConfig(settings);
    this.config.configure(this.objectMapper);
  }

  @Override
  public byte[] serialize(String topic, T message) {
    if (null == message) {
      return null;
    }
    try {
      return this.objectMapper.writeValueAsBytes(message);
    } catch (JsonProcessingException e) {
      throw new SerializationException(e);
    }
  }

  @Override
  public void close() {

  }
}
