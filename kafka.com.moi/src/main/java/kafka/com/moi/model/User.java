/**
 * 
 */
package kafka.com.moi.model;

/**
 * @author BEN LAHMAR, EL HABIB
 *
 */
public class User {

	int id;
	String nom;
	int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", age=" + age + "]";
	}
	
}
