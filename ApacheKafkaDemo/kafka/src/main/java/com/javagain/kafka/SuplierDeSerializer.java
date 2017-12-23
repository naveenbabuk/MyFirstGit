package com.javagain.kafka;

import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class SuplierDeSerializer implements Deserializer<Supplier> {
	
	private String encoding = "UTF8";

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	public Supplier deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		
		try {
			
			if (data != null) {
				ByteBuffer buff = ByteBuffer.wrap(data);
				
				int id = buff.getInt();
				int sizeOfName = buff.getInt();
				byte[] nameBytes = new byte[sizeOfName];
				buff.get(nameBytes);
				String desserializeName = new String(nameBytes, encoding);
				
				int sizeOfDate = buff.getInt();
				byte[] dateBytes = new byte[sizeOfDate];
				buff.get(dateBytes);
				String dateString = new String(dateBytes, encoding);
				DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
				
				return new Supplier(id, desserializeName, df.parse(dateString));
				
			}
			
		} catch(Exception e) {
			throw new SerializationException("Error when deserializing byte[] to Supplier");
		}
		
		return null;
	}
	
	

}
