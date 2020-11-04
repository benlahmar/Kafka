/**
 * 
 */
package kafka2.com.tps.streams.streams;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Named;
import org.apache.kafka.streams.kstream.Predicate;

import kafka2.com.tps.User;

/**
 * @author moi
 *
 */
public class Tp1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Properties cf = conf();
		
		
		StreamsBuilder builder = new StreamsBuilder();

		KStream<String, User> wordCounts = builder.stream(
		    "topic-test01");
		
		
		    
		
		KStream<String, User> ks = wordCounts.filter( (x,y) ->  y.getId().length()>4);
		
		ks.foreach( (k,v) -> System.out.println(k+"------"+v));
		
		
		KafkaStreams app = new KafkaStreams(builder.build(), cf);
		app.start();
		
		Thread.sleep(30000);
		app.close();
	}
	public static Properties conf()
	{
		Properties config = new Properties();

		config.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "MY.APP_ID");
		config.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		config.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		return config;
	}

}
