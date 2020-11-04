/**
 * 
 */
package kafka2.com.tps;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class Tp01_producer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties props = new Properties();
	      props.put("bootstrap.servers", "localhost:9092");
	      props.put("acks", "all");
	      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

	    final  KafkaProducer<String, String> producer = new KafkaProducer<>(props);
	    ProducerRecord<String, String> record=new ProducerRecord<String, String>("topic-test", "key1", "valeur1");
		producer.send(record);
		producer.close();
	}

}
