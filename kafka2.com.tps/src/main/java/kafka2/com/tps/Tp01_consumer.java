/**
 * 
 */
package kafka2.com.tps;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;



/**
 * @author BEN LAHMAR ELHABIB
 *
 */
public class Tp01_consumer {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final Properties props = new Properties();
		  props.setProperty("bootstrap.servers", "localhost:9092");
	      props.setProperty("group.id", "test");
	      
	      props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	      props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	      
	    final  KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
	      
		
		consumer.subscribe(Collections.singletonList("topic-test"));//consumer.subscribe(Arrays.asList(topics));
		
		
		ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(20));
		records.forEach(x-> System.out.println(x.key()+" : "+x.value()));
		Thread.sleep(4000);
		consumer.close();
	}

}
