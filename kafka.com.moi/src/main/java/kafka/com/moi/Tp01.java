/**
 * 
 */
package kafka.com.moi;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;


import kafka.com.moi.util.Helpers;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class Tp01 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService exec=Executors.newFixedThreadPool(3);
		
		exec.execute(()-> {
			KafkaConsumer<String, String> consumer = Helpers.createConsomuer("topic001");
			 ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(2));
			 records.forEach(x-> System.out.println(x.key()+"  :  "+x.value() +"     "+x.timestamp()+ "      "+x.offset()));
		});
		 
		 
		 
		 
		exec.execute(()-> {
		 KafkaProducer<String, String> producer = Helpers.CreateProducer();
		 ProducerRecord<String, String> record=new ProducerRecord<String, String>("topic001", "key0001", "valeur0001");
	     producer.send(record);
		});
		
	     exec.shutdown();
	     exec.awaitTermination(3, TimeUnit.MINUTES);
	}

}
