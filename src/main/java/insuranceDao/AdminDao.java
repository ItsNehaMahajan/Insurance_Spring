package insuranceDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import insuranceModel.Admin;



@Component
public class AdminDao {

	
	 @Autowired
		private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public AdminDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
 public  void insertNewAccount(Admin admin) {
		 hibernateTemplate.save(admin);
		
		
	}

	@Transactional
	public  Admin getAccount(int deposit) {
		return hibernateTemplate.get(Admin.class, deposit);
	}

	 @Transactional
	public void deleteCustomer(int accno1) {
		 Admin accounts = hibernateTemplate.get(Admin.class, accno1); 
			hibernateTemplate.delete(accounts);
		
	}
	 
	 @Transactional
	    public List<Admin> getAllAccounts() {
	    	return hibernateTemplate.loadAll( Admin.class);
		}
	  

	 @Transactional
	public  void updateCustomer(Admin accountsObj) {
		 hibernateTemplate.update(accountsObj);
		
	}
}
