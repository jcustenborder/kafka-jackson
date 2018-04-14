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
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import org.apache.kafka.common.serialization.Serializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JacksonSerializerTest {

  Serializer serializer;

  @BeforeEach
  public void before() {
    this.serializer = new JacksonSerializer();
    Map<String, String> settings = ImmutableMap.of(
        JacksonSerializerConfig.INDENT_OUTPUT_CONFIG, "false"
    );

    this.serializer.configure(settings, true);
  }

  @Test
  public void serializeNull() {
    assertNull(this.serializer.serialize("dummy", null));
  }

  @TestFactory
  public Stream<DynamicTest> serialize() {
    Map<String, Object> tests = ImmutableMap.of(
        "{\"foo\":\"bar\"}", ImmutableMap.of("foo", "bar")
    );

    return tests.entrySet().stream().map(p -> dynamicTest(p.getKey(), () -> {
      byte[] buffer = this.serializer.serialize("topic", p.getValue());
      String actual = new String(buffer, Charsets.UTF_8);
      assertEquals(p.getKey(), actual);
    }));
  }

  @TestFactory
  public Stream<DynamicTest> nonDefaultSettings() {
    return JacksonSerializerConfig.CONFIG_TO_CONFIGFEATURE.entrySet()
        .stream()
        .map(e -> dynamicTest(e.getKey(), () -> {
          boolean flipped = !e.getValue().enabledByDefault();
          ObjectMapper objectMapper = new ObjectMapper();

          if (e.getValue() instanceof SerializationFeature) {
            objectMapper.configure((SerializationFeature) e.getValue(), flipped);
          } else if (e.getValue() instanceof MapperFeature) {
            objectMapper.configure((MapperFeature) e.getValue(), flipped);
          }

          Map<String, String> expected = ImmutableMap.of(e.getKey(), Boolean.toString(flipped));
          Map<String, String> actual = JacksonSerializer.nonDefaultSettings(objectMapper);
          assertEquals(expected, actual);
        }));
  }

  @Test
  public void toMarkdown() {
    System.out.println(
        MarkdownFormatter.toMarkdown(JacksonSerializerConfig.config())
    );
  }
}
