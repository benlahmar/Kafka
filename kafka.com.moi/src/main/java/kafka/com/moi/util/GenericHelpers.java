/**
 * 
 */
package kafka.com.moi.util;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import kafka.com.moi.model.User;

/**
 * @author BEN LAHMAR, EL HABIB
 * @param <K>
 * @param <V>
 *
 */
public class GenericHelpers<K, V> {

	public   KafkaProducer<K, V> CreateProducer(Class c)
	{
		Properties props=new Properties();
	      props.put("bootstrap.servers", IKafkaConstants.Kafka_borker);
	      props.put("group.id", IKafkaConstants.KAFKA_GOUPE_ID);  
	      
	      props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,c.getName());
	      props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
	      
	     
	      KafkaProducer<K, V> producer=new KafkaProducer(props);
	      return producer;
	}
	
}
