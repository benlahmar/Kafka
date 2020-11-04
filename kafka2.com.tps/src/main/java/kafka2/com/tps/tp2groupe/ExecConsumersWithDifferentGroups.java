package kafka2.com.tps.tp2groupe;

public class ExecConsumersWithDifferentGroups {
	  public static void main(String[] args) throws Exception {
	      String[] consumerGroups = new String[3];
	      for (int i = 0; i < consumerGroups.length; i++) {
	          consumerGroups[i] ="test-consumer-group-"+i;
	      }
	      ConsumerGroupExample.run(3, consumerGroups);
	  }
	}