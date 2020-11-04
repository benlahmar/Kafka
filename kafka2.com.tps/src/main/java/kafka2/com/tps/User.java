package kafka2.com.tps;

import java.io.Serializable;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class User implements Serializable{

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
