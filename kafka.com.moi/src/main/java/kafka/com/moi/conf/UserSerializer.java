/**
 * 
 */
package kafka.com.moi.conf;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kafka.com.moi.model.User;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class UserSerializer implements Serializer<User>{

	ObjectMapper mapper=new ObjectMapper();
	@Override
	public byte[] serialize(String topic, User data) {
		byte[] res = null;
		try {
			res = mapper.writeValueAsString(data).getBytes();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
