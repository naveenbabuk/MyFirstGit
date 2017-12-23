package com.javagain.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SupplierConsumer {
	
	public static void main(String[] args) {
		
		String topicName = "SupplierTopic";
		String consumerGroupName = "ConsuerGroup1";
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092, localhost:9093");
		props.put("group.id", consumerGroupName);
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "com.javagain.kafka.SuplierDeSerializer");
		
		KafkaConsumer<String, Supplier> consumer = new KafkaConsumer<String, Supplier>(props);
		
		consumer.subscribe(Arrays.asList(topicName));
		
		while (true) {
			
			ConsumerRecords<String, Supplier> records = consumer.poll(100);
			for (ConsumerRecord<String, Supplier> record : records) {
				System.out.println("**************Supperlier Consumer***************");
				System.out.println("Supplier id : " + String.valueOf(record.value().getSupplierId()));
				System.out.println("Supplier Name : " + record.value().getSupplierName());
				System.out.println("Supplier Start Date : " + record.value().getSupplierStartDate().toString());
				System.out.println();
				System.out.println();
				
			}
		}
		
	}

}
