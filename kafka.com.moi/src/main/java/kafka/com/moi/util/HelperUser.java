package kafka.com.moi.util;


import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import kafka.com.moi.conf.UserDeserializer;
import kafka.com.moi.conf.UserSerializer;
import kafka.com.moi.model.User;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class HelperUser {

	public static KafkaProducer<String, User> CreateProducer()
	{
		 Properties props=new Properties();
	      props.put("bootstrap.servers", IKafkaConstants.Kafka_borker);
	      props.put("group.id", IKafkaConstants.KAFKA_GOUPE_ID);  
	      
	      props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,UserSerializer.class.getName());
	      props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
	      
	      KafkaProducer<String, User> producer=new KafkaProducer<String, User>(props);
	      return producer;
		
	}
	
	public static KafkaConsumer<String, User> createConsomuer(String topic)
	{ 
		Properties props=new Properties();
	      props.put("bootstrap.servers", IKafkaConstants.Kafka_borker);
	      props.put("group.id", IKafkaConstants.KAFKA_GOUPE_ID);  
	      
	      props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,UserDeserializer.class.getName());
	      props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
	      
	      KafkaConsumer<String, User> consumer=new KafkaConsumer<String, User>(props);
	      	      
		// consumer.subscribe(Collections.singletonList(topic));
		 return consumer;
	}
}
