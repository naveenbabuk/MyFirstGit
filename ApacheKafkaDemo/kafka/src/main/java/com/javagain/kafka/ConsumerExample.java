package com.javagain.kafka;

import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerExample {
	
	public static void main(String[] args) {
		
		String topicName = "ProducerTopicTest1";
		String groupName = "ConsumerGroup1";
		
		Properties props = new Properties();
		
		props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("group.id", groupName);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "SupplierDeserializer");
        
		
	}

}
