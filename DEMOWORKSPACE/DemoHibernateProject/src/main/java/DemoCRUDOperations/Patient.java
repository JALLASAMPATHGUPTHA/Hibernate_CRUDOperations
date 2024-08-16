package DemoCRUDOperations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="patient_table")
public class Patient 
{
	@Id
	@Column(name="pid")
	private int id;
	@Column(name="pname",length= 50, nullable = false)
	private String name;
	@Column(name="pgender",length= 10, nullable = false)
	private String gender;
	@Column(name = "page")
	private float age;
	@Column(name ="pemail",nullable=false,length = 50,unique = true)
	private String email;
	@Column(name="plocation",length= 50, nullable = false)
	private String location;
	@Column(name="pcontactno",length= 20, nullable = false,unique=true)
	private String contactno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
}