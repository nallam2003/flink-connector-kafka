package org.apache.flink.streaming.connectors.kafka.testutils;

import org.apache.flink.streaming.connectors.kafka.KafkaTestEnvironment;

import java.util.Properties;

public abstract class KafkaTestEnvironmentBase {
    protected static final String KAFKA_HOST = "localhost";

    public abstract void prepare(KafkaTestEnvironment.Config config) throws Exception;

    public void shutdown() throws Exception {}

    public abstract void deleteTestTopic(String topic);

    public abstract void createTestTopic(
            String topic, int numberOfPartitions, int replicationFactor, Properties properties);

    public void createTestTopic(String topic, int numberOfPartitions, int replicationFactor) {
        this.createTestTopic(topic, numberOfPartitions, replicationFactor, new Properties());
    }

    public abstract Properties getStandardProperties();

    public abstract Properties getSecureProperties();

    public abstract String getBrokerConnectionString();

    public Properties getIdempotentProducerConfig() {
        Properties props = new Properties();
        props.put("enable.idempotence", "true");
        props.put("acks", "all");
        props.put("retries", "3");
        return props;
    }

    public abstract String getVersion();
}
