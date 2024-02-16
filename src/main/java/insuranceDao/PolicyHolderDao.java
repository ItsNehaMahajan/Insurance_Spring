package insuranceDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import insuranceModel.PolicyHolder;
import insuranceModel.PolicyPojo;

@Component
public class PolicyHolderDao {
	
	 @Autowired
		private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public PolicyHolderDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PolicyHolderDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
 public  void insertNewAccount(PolicyHolder policyHolder) {
		 hibernateTemplate.save(policyHolder);
		
		
	}

	@Transactional
	public  PolicyHolder getAccount(String email) {
		return hibernateTemplate.get(PolicyHolder.class, email);
	}

	
	
	@Transactional
	public  PolicyHolder getAccount(int id) {
		return hibernateTemplate.get(PolicyHolder.class, id);
	}

	 @Transactional
	public void deleteCustomer(int accno1) {
		 PolicyHolder accounts = hibernateTemplate.get(PolicyHolder.class, accno1); 
			hibernateTemplate.delete(accounts);
		
	}
	 
	 @Transactional
	    public List<PolicyHolder> getAllAccounts() {
	    	return hibernateTemplate.loadAll( PolicyHolder.class);
		}
	  

	 @Transactional
	public void update(PolicyHolder policyHolder) {
		 hibernateTemplate.update(policyHolder);
		
	}
	
	
	

	

}
