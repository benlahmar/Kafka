package kafka2.com.tps.serialize;


import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import kafka2.com.tps.User;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class CustomSerializer implements Serializer<User> {

	public byte[] serialize(String topic, User data) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception exception) {
			System.out.println("Error in serializing object" + data);
		}
		return retVal;
	}

	

	

}