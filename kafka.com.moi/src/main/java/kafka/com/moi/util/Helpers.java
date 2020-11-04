/**
 * 
 */
package kafka.com.moi.util;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class Helpers {

	public static KafkaProducer<String, String> CreateProducer()
	{
		 Properties props=new Properties();
	      props.put("bootstrap.servers", IKafkaConstants.Kafka_borker);
	      props.put("group.id", IKafkaConstants.KAFKA_GOUPE_ID);  
	      props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
	      props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
	      
	      KafkaProducer<String, String> producer=new KafkaProducer<String, String>(props);
	      return producer;
		
	}
	
	public static KafkaConsumer<String, String> createConsomuer(String topic)
	{
		Properties props=new Properties();
	      props.put("bootstrap.servers", IKafkaConstants.Kafka_borker);
	      props.put("group.id", IKafkaConstants.KAFKA_GOUPE_ID);  
	      props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
	      props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
	      
	      KafkaConsumer<String, String> consumer=new KafkaConsumer<String, String>(props);
	      	      
		 consumer.subscribe(Collections.singletonList(topic));
		 return consumer;
	}
}
