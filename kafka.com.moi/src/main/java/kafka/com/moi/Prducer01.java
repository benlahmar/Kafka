/**
 * 
 */
package kafka.com.moi;



import org.apache.kafka.clients.producer.KafkaProducer;

import org.apache.kafka.clients.producer.ProducerRecord;

import kafka.com.moi.util.Helpers;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class Prducer01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 KafkaProducer<String, String> producer = Helpers.CreateProducer();
	      for(int i=10;i<20;i++)
	      {
		      ProducerRecord<String, String> record=new ProducerRecord<String, String>("topic001", "key0"+i, "valeur0"+i);
		      producer.send(record);
	      }
	      
	      producer.close();

	}

}
