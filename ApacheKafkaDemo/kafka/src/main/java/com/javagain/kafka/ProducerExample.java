package com.javagain.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.*;



public class ProducerExample {
	
	public static void main (String [] args) {
		
		String topicName = "ProducerTopicTest1";
		String key = "key1";
		String value = "value1";
		
		Properties prop = new Properties();
		
		prop.put("bootstrap.servers", "localhost:9092, localhost:9093");
		prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<String, String> (prop);
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, value);
		producer.send(record);
		producer.close();
		
		System.out.println("Producer successfully completed.");
		
	}

}
