package kafka2.com.tps.pc;


import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import kafka2.com.tps.User;
import kafka2.com.tps.IKafkaConstants;



public class App {
	public static void main(String[] args) {
	
		//runProducer();
		runConsumer();
	}

	static void runConsumer() {
		Consumer<Long, User> consumer = ConsumerUser.createConsumer();

		int noMessageToFetch = 0;

		while (true) {
			final ConsumerRecords<Long, User> consumerRecords = consumer.poll(1000);
			if (consumerRecords.count() == 0) {
				noMessageToFetch++;
				if (noMessageToFetch > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
					break;
				else
					continue;
			}

			consumerRecords.forEach(record -> {
				System.out.println("Record Key " + record.key());
				System.out.println("Record value " + record.value().toString());
				System.out.println("Record partition " + record.partition());
				System.out.println("Record offset " + record.offset());
			});
			consumer.commitAsync();
		}
		consumer.close();
	}

	static void runProducer() {
		Producer<Long, User> producer = ProducerUser.createProducer();

		for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
			
			User user=new User();
			user.setId(index+"");
			user.setName("user "+index);
			final ProducerRecord<Long, User> record = new ProducerRecord<Long, User>(IKafkaConstants.TOPIC_NAME,user);
			try {
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
						+ " with offset " + metadata.offset());
			} catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
		}
	}
}