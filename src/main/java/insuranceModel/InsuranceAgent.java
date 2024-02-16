package insuranceModel;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class InsuranceAgent {
	
	@Id
	private int id;
	private String name;
	private String contact;
	private String address;
	private String email;
	private String password;
	
	
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassward(String password) {
		this.password = password;
	}
	public InsuranceAgent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InsuranceAgent(int id, String name, String contact, String address, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "InsuranceAgent [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address
				+ ", email=" + email + ", passward=" + password + "]";
	}
	
	
	
	

}
