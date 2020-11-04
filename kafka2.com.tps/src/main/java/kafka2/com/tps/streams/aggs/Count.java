package kafka2.com.tps.streams.aggs;

public class Count {

    private String key;
    private Integer count;

    public Count(String key, Integer count) {
        this.key = key;
        this.count = count;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getCount() {
        return this.count;
    }
   
}