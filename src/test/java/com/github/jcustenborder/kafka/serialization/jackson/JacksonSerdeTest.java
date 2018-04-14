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

import com.google.common.collect.ImmutableMap;
import org.apache.kafka.common.serialization.Serde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JacksonSerdeTest {

  @Test
  public void of() {
    Serde<TestPojo> serde = JacksonSerde.of(TestPojo.class);
    serde.configure(ImmutableMap.of(), false);

    TestPojo expected = new TestPojo();
    expected.firstName = "first";
    expected.lastName = "last";
    byte[] buffer = serde.serializer().serialize("topic", expected);
    TestPojo actual = serde.deserializer().deserialize("topic", buffer);
    assertNotNull(actual);
    assertEquals(expected.firstName, expected.firstName);
    assertEquals(expected.lastName, expected.lastName);
    serde.close();
  }

  @Test
  public void configured() {
    Serde<TestPojo> serde = new JacksonSerde<>();
    serde.configure(ImmutableMap.of(
        JacksonDeserializerConfig.OUTPUT_CLASS_CONFIG, TestPojo.class.getName()
    ), false);

    TestPojo expected = new TestPojo();
    expected.firstName = "first";
    expected.lastName = "last";
    byte[] buffer = serde.serializer().serialize("topic", expected);
    TestPojo actual = serde.deserializer().deserialize("topic", buffer);
    assertNotNull(actual);
    assertEquals(expected.firstName, expected.firstName);
    assertEquals(expected.lastName, expected.lastName);

    serde.close();
  }

}
