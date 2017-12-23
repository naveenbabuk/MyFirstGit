package com.javagain.kafka;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class SupplierProducer {
	
	public static void main(String[] args) throws Exception {
		
		String topicName = "SupplierTopic";
		
		Properties prop = new Properties();
		
		prop.put("bootstrap.servers", "localhost:9092, localhost:9093");
		prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		prop.put("value.serializer", "SuplierSerializer");
		
		Producer<String, Supplier> producer = new KafkaProducer <String, Supplier>(prop);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Supplier sup1 = new Supplier(101, "xyz pvt ltd", df.parse("2001-05-08"));
		Supplier sup2 = new Supplier(102, "abc pvt ltd", df.parse("1999-07-08"));
		
		producer.send(new ProducerRecord<String, Supplier>(topicName, "SUP", sup1));
		producer.send(new ProducerRecord<String, Supplier>(topicName, "SUP", sup2));
		producer.close();
		System.out.println("SupplierProducer Completed.");
		
	}

}
