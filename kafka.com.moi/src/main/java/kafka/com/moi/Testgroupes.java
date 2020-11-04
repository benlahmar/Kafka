/**
 * 
 */
package kafka.com.moi;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import kafka.com.moi.conf.Getconf;
import kafka.com.moi.model.User;
import kafka.com.moi.util.HelperUser;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class Testgroupes {

	private static final int PARTITION_COUNT = 4;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		  Properties props = Getconf.getproducerconfig();
		KafkaProducer<String, User> producer=new KafkaProducer<String, User>(props);
		User u=new User();
		u.setNom("habib"); u.setAge(42);
		
		for(int i=0;i<PARTITION_COUNT;i++) {
			u.setId(i);
			ProducerRecord<String, User>  record1=new ProducerRecord<String, User>("topic003",  i,"__user__"+i, u);
			producer.send(record1);
		}
		
		
		 Properties props2 = Getconf.getconconsumerconfig("groupe1");
		 
		 KafkaConsumer<String, User> consumer=new KafkaConsumer<String, User>(props2);
		 consumer.subscribe(Collections.singletonList("topic003"));
	 	 
		 ConsumerRecords<String, User> records = consumer.poll(Duration.ofSeconds(4));
		  records.forEach(x-> System.out.println(x.key()+"   :   "+ x.value().toString()+",  partition: "+ x.partition()+"   offset:"+x.offset()));
			consumer.commitAsync();
		 
		System.out.println("*****************************");
		Properties props3 = Getconf.getconconsumerconfig("groupe2");
		 KafkaConsumer<String, User> consumer2=new KafkaConsumer<String, User>(props3);
		 consumer2.subscribe(Collections.singletonList("topic003"));
		 
		 ConsumerRecords<String, User> records2 = consumer2.poll(Duration.ofSeconds(4));
		  records2.forEach(x-> System.out.println(x.key()+"   :   "+ x.value().toString()+",  partition: "+ x.partition()+"   offset:"+x.offset()));
			consumer2.commitAsync();

	}

}
