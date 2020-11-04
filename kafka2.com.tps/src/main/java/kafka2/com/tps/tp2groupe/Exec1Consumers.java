package kafka2.com.tps.tp2groupe;

public class Exec1Consumers {
	  public static void main(String[] args) throws Exception {
	      ConsumerGroupExample.run(1, new String[]{"test-consumer-group"});
	  }
	}