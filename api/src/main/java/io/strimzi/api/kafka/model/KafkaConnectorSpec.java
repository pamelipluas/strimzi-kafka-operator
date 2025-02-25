/*
 * Copyright 2019, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.strimzi.crdgenerator.annotations.Description;
import io.strimzi.crdgenerator.annotations.Minimum;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;

@Buildable(
        editableEnabled = false,
        generateBuilderPackage = false,
        builderPackage = "io.fabric8.kubernetes.api.builder"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"connectCluster", "class", "tasksMax", "topics", "config"})
@EqualsAndHashCode
public class KafkaConnectorSpec implements Serializable, UnknownPropertyPreserving {
    private static final long serialVersionUID = 1L;

    private KafkaConnectorSpecCluster connectCluster;
    private String className;
    private Integer tasksMax;
    private List<String> topics;
    private List<KafkaConnectorConfig> config;
    private Map<String, Object> additionalProperties;

    @Description("The Kafka Connect cluster within which to create the connector.")
    public KafkaConnectorSpecCluster getConnectCluster() {
        return connectCluster;
    }

    @Description("The Class for the Kafka Connector")
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    @Description("The maximum number of tasks for the Kafka Connector")
    @Minimum(1)
    public Integer getTasksMax() {
        return tasksMax;
    }

    @Description("A list of topics to use as input for the Kafka Connector")
    public List<String> getTopics() {
        return topics;
    }

    @Description("The Config for the Kafka Connector Spec.")
    public List<KafkaConnectorConfig> getConfig() {
        return config;
    }

    public void setConfig(List<KafkaConnectorConfig> config) {
        this.config = config;
    }

    public void setConnectCluster(KafkaConnectorSpecCluster connectCluster) {
        this.connectCluster = connectCluster;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setTasksMax(Integer tasksMax) {
        this.tasksMax = tasksMax;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    @Override
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties != null ? this.additionalProperties : emptyMap();
    }

    @Override
    public void setAdditionalProperty(String name, Object value) {
        if (this.additionalProperties == null) {
            this.additionalProperties = new HashMap<>();
        }
        this.additionalProperties.put(name, value);
    }
}
