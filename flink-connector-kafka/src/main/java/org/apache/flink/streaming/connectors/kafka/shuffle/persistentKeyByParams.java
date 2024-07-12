package org.apache.flink.streaming.connectors.kafka.shuffle;

import org.apache.flink.streaming.api.datastream.DataStream;

import java.util.Properties;

public class persistentKeyByParams<T> {
    private final DataStream<T> dataStream;
    private final String topic;
    private final int producerParallelism;
    private final int numberOfPartitions;
    private final Properties properties;

    public persistentKeyByParams(DataStream<T> dataStream, String topic, int producerParallelism, int numberOfPartitions, Properties properties) {
        this.dataStream = dataStream;
        this.topic = topic;
        this.producerParallelism = producerParallelism;
        this.numberOfPartitions = numberOfPartitions;
        this.properties = properties;
    }

    public DataStream<T> getDataStream() {
        return dataStream;
    }

    public String getTopic() {
        return topic;
    }

    public int getProducerParallelism() {
        return producerParallelism;
    }

    public int getNumberOfPartitions() {
        return numberOfPartitions;
    }

    public Properties getProperties() {
        return properties;
    }
}
