package insuranceDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import insuranceModel.Appointment;



@Component
public class AppointmentDao {

	  @Autowired
		private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public AppointmentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppointmentDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
  public  void insertNewAccount(Appointment appointment) {
		 hibernateTemplate.save(appointment);
		
		
	}

	@Transactional
	public  Appointment getAccount(String name) {
		return hibernateTemplate.get(Appointment.class, name);
	}

	 @Transactional
	public void deleteCustomer(String contact) {
		 Appointment accounts = hibernateTemplate.get(Appointment.class, contact); 
			hibernateTemplate.delete(accounts);
		
	}
	 
	 @Transactional
	    public List<Appointment> getAllAccounts() {
	    	return hibernateTemplate.loadAll( Appointment.class);
		}
	  

	 @Transactional
	public  void updateCustomer(Appointment accountsObj) {
		 hibernateTemplate.update(accountsObj);
		
	}

	
	}

	

