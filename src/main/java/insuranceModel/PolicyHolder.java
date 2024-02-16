package insuranceModel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class PolicyHolder {
	
	
	@Id
	
	private int id;
	private String name;
	private String dob;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public void setPassword(String password) {
		this.password = password;
	}
	
    public PolicyHolder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PolicyHolder(int id, String name, String dob, String contact, String address, String email,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.contact = contact;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "PolicyHolder [id=" + id + ", name=" + name + ", dob=" + dob + ", contact=" + contact + ", address="
				+ address + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	

}
