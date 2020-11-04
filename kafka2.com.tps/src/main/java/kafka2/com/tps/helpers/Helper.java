package kafka2.com.tps.helpers;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class Helper {
  public static final String BROKERS = "localhost:9092";

  public static KafkaProducer createProducer() {
      Properties props = new Properties();
      props.put("bootstrap.servers", BROKERS);
      props.put("acks", "all");
      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      return new KafkaProducer<>(props);
  }

  public static KafkaConsumer<String, String> createConsumer(String topicName) {
      Properties props = new Properties();
      props.setProperty("bootstrap.servers", BROKERS);
      props.setProperty("group.id", "testGroup");
      props.setProperty("enable.auto.commit", "false");
      props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
      consumer.subscribe(Arrays.asList(topicName));
      return consumer;
  }
}