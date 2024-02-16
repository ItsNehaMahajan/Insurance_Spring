package insuranceModel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class PolicyPojo {
	
	@Id
	private int id;
	private String name;
	private String dob;
	private String contact;
	private String email;
	private String policyTitle;
	private String details;
	private String dueDate;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPolicyTitle() {
		return policyTitle;
	}
	public void setPolicyTitle(String policyTitle) {
		this.policyTitle = policyTitle;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public PolicyPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PolicyPojo(int id, String name, String dob, String contact, String email, String policyTitle, String details,
			String dueDate) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.contact = contact;
		this.email = email;
		this.policyTitle = policyTitle;
		this.details = details;
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "PolicyPojo [id=" + id + ", name=" + name + ", dob=" + dob + ", contact=" + contact + ", email=" + email
				+ ", policyTitle=" + policyTitle + ", details=" + details + ", dueDate=" + dueDate + "]";
	}	
	
	
	

	

	}
