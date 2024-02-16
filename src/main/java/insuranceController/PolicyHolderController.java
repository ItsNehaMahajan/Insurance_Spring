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
import org.springframework.web.servlet.view.RedirectView;



import insuranceDao.*;

import insuranceModel.*;

@Controller
public class PolicyHolderController {
  
	 
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    InsuranceAgent insuranceAgent = (InsuranceAgent) context.getBean("insuranceAgent");
    InsuranceAgentDao insuranceAgentDao = (InsuranceAgentDao) context.getBean("insuranceAgentDao");
   
    PolicyHolder policyHolder = (PolicyHolder) context.getBean("policyHolder");
    PolicyHolderDao policyHolderDao = (PolicyHolderDao) context.getBean("policyHolderDao");
    
    PolicyPojo policyPojo = (PolicyPojo) context.getBean("policyPojo");
    PolicyPojoDao policyPojoDao = (PolicyPojoDao) context.getBean("policyPojoDao");
    
    Admin admin = (Admin) context.getBean("admin");
    AdminDao adminDao = (AdminDao) context.getBean("adminDao");
    
    Appointment appointment=(Appointment) context.getBean("appointment");
    AppointmentDao appointmentDao = (AppointmentDao) context.getBean("appointmentDao");
	
    
@RequestMapping("/AddPolicyHolder")
public String AddPolicyHolder() {
    return "AddPolicyHolder";
}



@RequestMapping("/ViewPolicyHolder")
public String ViewPolicyHolder(Model model,HttpServletRequest request) {
   
	
	 List<PolicyHolder> policyHolder = policyHolderDao.getAllAccounts();
	 model.addAttribute("policyHolder", policyHolder);

    return "ViewPolicyHolder";
}



@RequestMapping("/UpdatePolicyHolder")
public String UpdatePolicyHolder(Model model) {
	
	
	 model.addAttribute("policyHolder", policyHolder);
    return "UpdatePolicyHolder";
}



@RequestMapping("/DeletePolicyHolder")
public String DeletePolicyHolder() {
    return "DeletePolicyHolder";
}

   
    

@RequestMapping("/Holder")
public String Holder(Model model){

    return "Holder";
}
   

@RequestMapping("/Policy")
public String Policy(Model model){

    return "Policy";
}




@RequestMapping("/Appointment")
public String Appointment(Model model){


		 model.addAttribute("Appointment", appointment);
	 
    return "Appointment";
}


@RequestMapping("/Status")
public String Status(Model model){

    return "Status";
}


@RequestMapping("/StatusAll")
public String StatusAll(Model model){

	List<Appointment> appointment= appointmentDao.getAllAccounts();
    model.addAttribute("Appointment", appointment);
    return "StatusAll";
}


	@RequestMapping("/PolicyHolderLogin")
	public String loginCustomer()
	{
		return "PolicyHolderLogin";
	}

	@RequestMapping(path = "/afterLoginSubmitHolder", method = RequestMethod.POST)
	public String afterLoginSubmitHolder(HttpServletRequest request, Model model) {
		
		    int id = Integer.parseInt(request.getParameter("id"));
		    String password = request.getParameter("password");

		    policyHolder = policyHolderDao.getAccount(id);
	     try{
		    // Check if the retrieved account exists and has the correct email and password
		    if (policyHolder != null && policyHolder.getId()==id && policyHolder.getPassword().equals(password)) {
		        return "Holder";
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


	
	@RequestMapping(path="/viewAppointmentsubmit",method=RequestMethod.POST)
	public String  viewAppointmentsubmit(Model model,HttpServletRequest request)
	{   
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
	
		model.addAttribute("Appointment", appointment);
		 
		    appointment.setName(name);
		    appointment.setEmail(email);
		    appointment.setContact(contact);
		    appointment.setAddress(address);
		    
		 appointmentDao.insertNewAccount(appointment);
		
		
		 model.addAttribute("Appointment", appointment);
		

		return  "Status";
		
		
	}

	


}
