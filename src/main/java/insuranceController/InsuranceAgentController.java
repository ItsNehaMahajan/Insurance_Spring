package insuranceController;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import insuranceDao.*;

import insuranceModel.*;

@Controller
public class InsuranceAgentController
{
	
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    InsuranceAgent insuranceAgent = (InsuranceAgent) context.getBean("insuranceAgent");
    InsuranceAgentDao insuranceAgentDao = (InsuranceAgentDao) context.getBean("insuranceAgentDao");
   
    PolicyHolder policyHolder = (PolicyHolder) context.getBean("policyHolder");
    PolicyHolderDao policyHolderDao = (PolicyHolderDao) context.getBean("policyHolderDao");
    

    Admin admin = (Admin) context.getBean("admin");
    AdminDao adminDao = (AdminDao) context.getBean("adminDao");

    PolicyPojo policyPojo=(PolicyPojo)context.getBean("policyPojo");
    PolicyPojoDao policyPojoDao=(PolicyPojoDao)context.getBean("policyPojoDao");
    
    Appointment appointment=(Appointment) context.getBean("appointment");
    AppointmentDao appointmentDao = (AppointmentDao) context.getBean("appointmentDao");

	@RequestMapping("/")
	public String open()
	{
		return "index";
	}
	
	
	@RequestMapping("/index")
	public String openHome()
	{
		return "index";
	}
	
	
	@RequestMapping("/about")
	public String openabout()
	{
		return "about";
	}
	
	
	@RequestMapping("/service")
	public String openservice()
	{
		return "service";
	}
	
	
	@RequestMapping("/agentLogin")
	public String loginagent()
	{
		return "agentLogin";
	}
	
	
	@RequestMapping("/agentsignup")
	public String  signupagent()
	{
		return "agentsignup";
	}
	
	
	@RequestMapping("/Agent")
	public String  agent(Model model)
	{   
		 List<Appointment> appointment = appointmentDao.getAllAccounts();
		 model.addAttribute("Appointment", appointment);
		return "Agent";
	}
	
	
	
	@RequestMapping(path = "/afterAgentLoginSubmit", method = RequestMethod.POST)
	public String checkAgentLogin(HttpServletRequest request,Model model) {
	   
		int id = Integer.parseInt(request.getParameter("id"));
	    String password = request.getParameter("password");

	    insuranceAgent = insuranceAgentDao.getAccount(id);
     
	    try{
	    // Check if the retrieved account exists and has the correct email and password
	    if (insuranceAgent != null && insuranceAgent.getId()==id && insuranceAgent.getPassword().equals(password)) {
	        
	    	 List<Appointment> appointment = appointmentDao.getAllAccounts();
			 model.addAttribute("Appointment", appointment);
	    	return "Agent";
	    } 
	    else {
	        return "error";
	    }
      }
    catch(Exception e)
    {
	System.out.println(e);
    }

      return "error";
	    
	}
	

	
	@RequestMapping(path = "/afteragentsignupsubmit", method = RequestMethod.POST)
	public String checkAgentsignupH(HttpServletRequest request) {
	    
		int id = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
	    String contact = request.getParameter("contact");
	    String address = request.getParameter("address");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    
	    InsuranceAgent insuranceAgent = new InsuranceAgent(id, name, contact, address, email, password);
	    insuranceAgentDao.insertNewAccount(insuranceAgent);

	    return "agentLogin";
	}
	



@RequestMapping(path = "/afteraddpolicyholder", method = RequestMethod.POST)
public String afteraddpolicy(HttpServletRequest request,Model model) {

	    int id = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
	    String dob = request.getParameter("dob");
	    String contact = request.getParameter("contact");
	    String address = request.getParameter("address");
        String email = request.getParameter("email");
	    String password = request.getParameter("password");
	  
	    
	    policyHolder.setId(id);
	    policyHolder.setName(name);
	    policyHolder.setDob(dob);
	    policyHolder.setContact(contact);
	    policyHolder.setAddress(address);
	    policyHolder.setEmail(email);
	    policyHolder.setPassword(password);
	    
	    
	    policyHolderDao.insertNewAccount(policyHolder);
    
    List<PolicyHolder> policyHolder = policyHolderDao.getAllAccounts();
    model.addAttribute("policyHolder", policyHolder);

    return "ViewPolicyHolder";
}



@RequestMapping(path = "/afterdeletepolicyholder", method = RequestMethod.POST)
public String afterdeletepolicyholder(HttpServletRequest request,Model model) {


	int id = Integer.parseInt(request.getParameter("id"));
	
	policyHolderDao.deleteCustomer(id);
	
    
    List<PolicyHolder> policyHolder = policyHolderDao.getAllAccounts();
    model.addAttribute("policyHolder", policyHolder);

    return "ViewPolicyHolder";
}



@RequestMapping(path = "/afterupdatepolicyholder", method = RequestMethod.POST)	
public String afterupdatepolicyholder(HttpServletRequest request,Model model) {

	
	 int id = Integer.parseInt(request.getParameter("id"));
	 String contact = request.getParameter("contact");
    	
	 policyHolder = policyHolderDao.getAccount(id);

if (policyHolder != null ) {
	
	policyHolder.setContact(contact);
    policyHolderDao.update(policyHolder);
    
    List<PolicyHolder> policyHolder = policyHolderDao.getAllAccounts();
    model.addAttribute("policyHolder", policyHolder);
    
    return "ViewPolicyHolder";
} 
else {

return "errorPage";
}
}

    
    
    




@RequestMapping(path="/approve/{contact}", method=RequestMethod.GET)

public RedirectView approve(@PathVariable("contact") String contact, HttpServletRequest request,Model model) {
	
	 List<Appointment> appointment = appointmentDao.getAllAccounts();
	 model.addAttribute("Appointment", appointment);
	 
RedirectView redirectview = new RedirectView();
redirectview.setUrl(request.getContextPath() + "/Agent");
return redirectview;

}
@RequestMapping(path="/disapprove/{contact}", method=RequestMethod.GET)

public RedirectView disapprove(@PathVariable("contact") String contact, HttpServletRequest request,Model model) {
	
	
	 List<Appointment> appointment = appointmentDao.getAllAccounts();
	 model.addAttribute("Appointment", appointment);
     appointmentDao.deleteCustomer(contact);

RedirectView redirectview = new RedirectView();
redirectview.setUrl(request.getContextPath() + "/Agent");
return redirectview;

}



}


	
