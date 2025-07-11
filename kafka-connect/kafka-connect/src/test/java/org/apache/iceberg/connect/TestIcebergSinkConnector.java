/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iceberg.connect;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.apache.iceberg.relocated.com.google.common.collect.ImmutableMap;
import org.apache.kafka.connect.sink.SinkConnector;
import org.junit.jupiter.api.Test;

public class TestIcebergSinkConnector {

  @Test
  public void testTaskConfigs() {
    SinkConnector connector = new IcebergSinkConnector();
    connector.start(ImmutableMap.of());
    List<Map<String, String>> configs = connector.taskConfigs(3);
    assertThat(configs).hasSize(3);
    configs.forEach(
        map -> assertThat(map).containsKey(IcebergSinkConfig.INTERNAL_TRANSACTIONAL_SUFFIX_PROP));
  }
}
