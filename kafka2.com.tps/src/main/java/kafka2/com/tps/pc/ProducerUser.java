package kafka2.com.tps.pc;


import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;

import kafka2.com.tps.User;
import kafka2.com.tps.IKafkaConstants;
import kafka2.com.tps.serialize.CustomSerializer;

/**
 * @author BEN LAHMAR ELHABIB
 *
 */
public class ProducerUser {

	public static Producer<Long, User> createProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, IKafkaConstants.CLIENT_ID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class.getName());
		return new KafkaProducer<Long, User>(props);
	}
}