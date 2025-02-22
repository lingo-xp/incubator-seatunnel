/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.connectors.seatunnel.file.source.reader;

import org.apache.seatunnel.api.source.Collector;
import org.apache.seatunnel.api.table.type.SeaTunnelRow;
import org.apache.seatunnel.api.table.type.SeaTunnelRowType;
import org.apache.seatunnel.connectors.seatunnel.file.config.HadoopConf;
import org.apache.seatunnel.connectors.seatunnel.file.exception.FilePluginException;

import org.apache.seatunnel.shade.com.typesafe.config.Config;

import org.apache.hadoop.conf.Configuration;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface ReadStrategy extends Serializable {
    void init(HadoopConf conf);

    Configuration getConfiguration(HadoopConf conf);

    void read(String path, Collector<SeaTunnelRow> output) throws Exception;

    SeaTunnelRowType getSeaTunnelRowTypeInfo(HadoopConf hadoopConf, String path) throws FilePluginException;

    void setSeaTunnelRowTypeInfo(SeaTunnelRowType seaTunnelRowType);

    List<String> getFileNamesByPath(HadoopConf hadoopConf, String path) throws IOException;

    void setPluginConfig(Config pluginConfig);

    SeaTunnelRowType getActualSeaTunnelRowTypeInfo();
}
