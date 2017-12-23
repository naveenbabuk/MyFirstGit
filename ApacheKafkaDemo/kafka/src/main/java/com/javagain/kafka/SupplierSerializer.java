package com.javagain.kafka;

import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class SupplierSerializer implements Serializer<Supplier> {

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	public byte[] serialize(String topicName, Supplier data) {
		
		int sizeOfName;
		int sizeOfDate;
		byte[] serializeName;
		byte[] serializeDate;
		
		try {
			
			if (data != null) {
				serializeName = data.getSupplierName().getBytes();
				serializeDate = data.getSupplierStartDate().toString().getBytes();
				
				sizeOfName = serializeName.length;
				sizeOfDate = serializeDate.length;
				
				ByteBuffer buff = ByteBuffer.allocate(4+4+sizeOfName+4+sizeOfDate);
				
				buff.putInt(data.getSupplierId());
				buff.putInt(sizeOfName);
				buff.put(serializeName);
				buff.putInt(sizeOfDate);
				buff.put(serializeDate);
				
				return buff.array();
				
				
			}
		} catch (Exception e) {
			throw new SerializationException("Error when serializing");
			
		}
		
		return null;
	}

}
