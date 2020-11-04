/**
 * 
 */
package kafka.com.moi.conf;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

import kafka.com.moi.util.IKafkaConstants;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class Getconf {

	
	public static Properties getconconsumerconfig(String groupe)
	{
		Properties props=new Properties();
	      props.put("bootstrap.servers", IKafkaConstants.Kafka_borker);
	      props.put("group.id", groupe);  
	      
	      props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,UserDeserializer.class.getName());
	      props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
	      return props;
	}
	
	public static Properties getproducerconfig()
	{
		 Properties props=new Properties();
	      props.put("bootstrap.servers", IKafkaConstants.Kafka_borker);
	      props.put("acks", "all");  
	      
	      props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,UserSerializer.class.getName());
	      props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
	      return props;
	}
}
