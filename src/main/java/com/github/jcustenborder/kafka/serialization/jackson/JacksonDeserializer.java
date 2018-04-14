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
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class JacksonDeserializer<T> implements Deserializer<T> {
  private static final Logger log = LoggerFactory.getLogger(JacksonDeserializer.class);
  private final ObjectMapper objectMapper;
  Class<T> cls;
  private JacksonDeserializerConfig config;


  public JacksonDeserializer() {
    this.objectMapper = new ObjectMapper();
  }

  public JacksonDeserializer(Class<T> cls) {
    this();
    this.cls = cls;
  }


  public static Map<String, String> nonDefaultSettings(ObjectMapper objectMapper) {
    return JacksonDeserializerConfig.nonDefaultSettings(objectMapper);
  }

  @Override
  public void configure(Map<String, ?> settings, boolean isKey) {
    this.config = new JacksonDeserializerConfig(settings);
    this.config.configure(this.objectMapper);
    if (null != this.cls) {
      log.trace("cls is already configured to {}", this.cls.getName());
    } else {
      this.cls = this.config.outputClass;
    }
  }

  @Override
  public T deserialize(String topic, byte[] bytes) {
    if (null == bytes) {
      return null;
    }

    try {
      return this.objectMapper.readValue(bytes, this.cls);
    } catch (IOException e) {
      throw new SerializationException(e);
    }
  }

  @Override
  public void close() {

  }
}
