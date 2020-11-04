package kafka2.com.tps.serialize;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import kafka2.com.tps.User;
/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class CustomDeserializer implements Deserializer<User> {

	public User deserialize(String topic, byte[] data) {
		
		ObjectMapper mapper = new ObjectMapper();
		User object = null;
		try {
			object = mapper.readValue(data, User.class);
		} catch (Exception exception) {
			System.out.println("Error in deserializing bytes " + exception);
		}
		return object;
	}

}
