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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.apache.kafka.common.errors.SerializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JacksonDeserializerTest {

  ObjectMapper mapper;

  @BeforeEach
  public void beforeEach() {
    this.mapper = new ObjectMapper();
  }

  @Test
  public void deserialize() throws JsonProcessingException {
    Map<String, String> input = ImmutableMap.of("foo", "bar");
    byte[] buffer = this.mapper.writeValueAsBytes(input);
    JacksonDeserializer<JsonNode> deserializer = new JacksonDeserializer<>();
    deserializer.configure(ImmutableMap.of(), false);
    JsonNode actual = deserializer.deserialize("dummy", buffer);
    assertNotNull(actual);
    assertTrue(actual.isObject());
    JsonNode converted = this.mapper.convertValue(input, JsonNode.class);
    assertEquals(converted, actual);
  }

  @Test
  public void classAlreadyDefined() {
    JacksonDeserializer<String> deserializer = new JacksonDeserializer<>(String.class);
    deserializer.configure(ImmutableMap.of(), false);
    assertEquals(String.class, deserializer.cls);
  }

  @Test
  public void deserializeNull() {
    JacksonDeserializer<JsonNode> deserializer = new JacksonDeserializer<>();
    assertNull(deserializer.deserialize("dummy", null));
  }

  @Test
  public void deserializeBadJson() {
    JacksonDeserializer<JsonNode> deserializer = new JacksonDeserializer<>();
    deserializer.configure(ImmutableMap.of(), false);

    assertThrows(SerializationException.class, () -> {
      deserializer.deserialize("dummy", "{".getBytes());
    });
  }

  @TestFactory
  public Stream<DynamicTest> nonDefaultSettings() {
    return JacksonDeserializerConfig.CONFIG_TO_CONFIGFEATURE.entrySet()
        .stream()
        .map(e -> dynamicTest(e.getKey(), () -> {
          boolean flipped = !e.getValue().enabledByDefault();
          ObjectMapper objectMapper = new ObjectMapper();

          if (e.getValue() instanceof DeserializationFeature) {
            objectMapper.configure((DeserializationFeature) e.getValue(), flipped);
          } else if (e.getValue() instanceof MapperFeature) {
            objectMapper.configure((MapperFeature) e.getValue(), flipped);
          }

          Map<String, String> expected = ImmutableMap.of(e.getKey(), Boolean.toString(flipped));
          Map<String, String> actual = JacksonDeserializer.nonDefaultSettings(objectMapper);
          assertEquals(expected, actual);
        }));
  }

  @Test
  public void toMarkdown() {
    System.out.println(
        MarkdownFormatter.toMarkdown(JacksonDeserializerConfig.config())
    );
  }

}
