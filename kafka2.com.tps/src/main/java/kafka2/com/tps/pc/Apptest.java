/**
 * 
 */
package kafka2.com.tps.pc;

import java.util.Collections;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import kafka2.com.tps.User;

/**
 * @author moi
 *
 */
public class Apptest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ruproducer("topic1");
		runconsumer("topic1");
	}

	public static void ruproducer(String topic)
	{
		try (Producer<Long, User> producer = ProducerUser.createProducer()) {
			   User user=new User();
			   user.setId("id1");
			   user.setName("name 1");
			producer.send(new ProducerRecord<Long, User>(topic, user));
			   System.out.println("Message " + user.toString() + " sent !!");
			} catch (Exception e) {
			   e.printStackTrace();
			}
	}
	
	public static void runconsumer(String topic)
	{
		try (Consumer<Long, User> consumer =ConsumerUser.createConsumer()) {
		    consumer.subscribe(Collections.singletonList(topic));
		    while (true) {
		        ConsumerRecords<Long, User> messages = consumer.poll(100);
		        for (ConsumerRecord<Long, User> message : messages) {
		          System.out.println("Message received " + message.value().toString());
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
