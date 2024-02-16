package insuranceDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import insuranceModel.PolicyPojo;

@Component
public class PolicyPojoDao {
	
	 @Autowired
		private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public PolicyPojoDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PolicyPojoDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
 public  void insertNewAccount(PolicyPojo policyPojo) {
		 hibernateTemplate.save(policyPojo);
		
		
	}

	
	@Transactional
	public  PolicyPojo getAccount(String contact) {
		return hibernateTemplate.get(PolicyPojo.class, contact);
	}

	 @Transactional
	public void deleteCustomer(int accno1) {
		 PolicyPojo accounts = hibernateTemplate.get(PolicyPojo.class, accno1); 
			hibernateTemplate.delete(accounts);
		
	}
	 
	 @Transactional
	    public List<PolicyPojo> getAllAccounts() {
	    	return hibernateTemplate.loadAll( PolicyPojo.class);
		}
	  

	 @Transactional
	public void updateCustomer(PolicyPojo policyHolder) {
		 hibernateTemplate.update(policyHolder);
		
	}

	public void update(PolicyPojo policyPojo) {
		 hibernateTemplate.update(policyPojo);
		
	}

	
	

}
