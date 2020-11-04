/**
 * 
 */
package kafka.com.moi;

import java.time.Duration;
import java.util.Collections;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;

import kafka.com.moi.model.User;
import kafka.com.moi.util.HelperUser;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class Tp002 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		 final int PARTITION_COUNT=4;
		
		User u=new User();
		u.setNom("habib"); u.setAge(42);
		KafkaProducer<String, User> producer = HelperUser.CreateProducer();
		for(int i=0;i<PARTITION_COUNT;i++) {
			u.setId(i);
			ProducerRecord<String, User>  record1=new ProducerRecord<String, User>("topic003",  "__user__"+i, u);
			producer.send(record1);
		}
		
//		ProducerRecord<String, User> record=new ProducerRecord<String, User>("topic002","user03", u);
//		producer.send(record);
		
		
		KafkaConsumer<String, User> consumer = HelperUser.createConsomuer("topic003");
		//assign a ne pa utiliser avec subscibe
		consumer.assign(Collections.singleton(new TopicPartition("topic003", 1)));
		
		ConsumerRecords<String, User> records = consumer.poll(Duration.ofSeconds(4));
		
		records.forEach(x-> System.out.println(x.key()+"   :   "+ x.value().toString()+",  partition: "+ x.partition()+"   offset:"+x.offset()));
		
		consumer.commitAsync();
		

		
		producer.close();
		consumer.close();
	}

}
