package insuranceDao;
import java.util.List;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import insuranceModel.InsuranceAgent;



@Component
public class InsuranceAgentDao {
	
	         @Autowired
			private HibernateTemplate hibernateTemplate;

		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
		
		public InsuranceAgentDao() {
			super();
			// TODO Auto-generated constructor stub
		}

		public InsuranceAgentDao(HibernateTemplate hibernateTemplate) {
			super();
			this.hibernateTemplate = hibernateTemplate;
		}

		@Transactional
	    public  void insertNewAccount(InsuranceAgent insuranceAgent) {
			 hibernateTemplate.save(insuranceAgent);
			
			
		}
	  
		@Transactional
		public  InsuranceAgent getAccount(int id) {
			return hibernateTemplate.get(InsuranceAgent.class, id);
		}

		 @Transactional
		public void deleteCustomer(int id) {
			 InsuranceAgent accounts = hibernateTemplate.get(InsuranceAgent.class, id); 
				hibernateTemplate.delete(accounts);
			
		}
		 
		 @Transactional
		    public List<InsuranceAgent> getAllAccounts() {
		    	return hibernateTemplate.loadAll( InsuranceAgent.class);
			}
		  

		 @Transactional
		public  void updateCustomer(InsuranceAgent accountsObj) {
			 hibernateTemplate.update(accountsObj);
			
		}

		public void update(String id) {
			 hibernateTemplate.update(id);
			
		}

		public void updateToDisapproved(String id) {
			 hibernateTemplate.update(id);
			
		}

		
}
