package insuranceModel;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Appointment {

	
	private String name;
    @Id
	private String contact;
	private String address;
	private String email;
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
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(String name, String contact, String address, String email) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Appointment [name=" + name + ", contact=" + contact + ", address=" + address + ", email=" + email + "]";
	}
	
	

}
