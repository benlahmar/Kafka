/**
 * 
 */
package kafka.com.moi.conf;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kafka.com.moi.model.User;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class UserDeserializer implements Deserializer<User>{

	ObjectMapper mapper=new ObjectMapper();
	@Override
	public User deserialize(String topic, byte[] data) {
		
		User u = null;
		try {
			u = mapper.readValue(data, User.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
