package insuranceController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


import insuranceDao.*;

import insuranceModel.*;

@Controller
public class PolicyPojoController {
  
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    InsuranceAgent insuranceAgent = (InsuranceAgent) context.getBean("insuranceAgent");
    InsuranceAgentDao insuranceAgentDao = (InsuranceAgentDao) context.getBean("insuranceAgentDao");
   
    PolicyHolder policyHolder = (PolicyHolder) context.getBean("policyHolder");
    PolicyHolderDao policyHolderDao = (PolicyHolderDao) context.getBean("policyHolderDao");
    

    Admin admin = (Admin) context.getBean("admin");
    AdminDao adminDao = (AdminDao) context.getBean("adminDao");
    
    PolicyPojo policyPojo = (PolicyPojo) context.getBean("policyPojo");
    PolicyPojoDao policyPojoDao = (PolicyPojoDao) context.getBean("policyPojoDao");
	
    Appointment appointment=(Appointment) context.getBean("appointment");
    AppointmentDao appointmentDao = (AppointmentDao) context.getBean("appointmentDao");
    

@RequestMapping("/AddPolicy")
public String AddPolicy() {
    return "AddPolicy";
}


@RequestMapping("/ViewPolicy")
public String ViewPolicy(Model model) {
	
	 List<PolicyPojo> policyPojo1= policyPojoDao.getAllAccounts();
	 model.addAttribute("PolicyPojo", policyPojo1);
    return "ViewPolicy";
}



@RequestMapping("/View")
public String View(Model model){

	model.addAttribute("policyPojo", policyPojo);
    return "View";
}


    @RequestMapping(path = "/afteraddpolicy", method = RequestMethod.POST)
	public String afteraddpolicy(@ModelAttribute PolicyPojo policyPojo,Model model)
	{
    	try
		{   
			policyPojoDao.insertNewAccount(policyPojo);
			model.addAttribute(policyPojo);
			

			 List<PolicyPojo> policyPojo1= policyPojoDao.getAllAccounts();
			 model.addAttribute("PolicyPojo", policyPojo1);
		     return "ViewPolicy";
		}
		catch(Exception e)
		{
			System.out.println("Failed to add..!!");
			e.printStackTrace();
			return "error";
		}
		
    }



@RequestMapping("/ExpiredPolicy")
public String ExpiredPolicy(Model model) {
	 
	
	    List<PolicyPojo> policyPojoList = policyPojoDao.getAllAccounts();
	    List<PolicyPojo> table = new ArrayList<PolicyPojo>();
	    LocalDate currentDate = LocalDate.now();
	    System.out.println(currentDate);
	    for(PolicyPojo pj : policyPojoList)
	    {
	    	String dueDate = pj.getDueDate();
	    	LocalDate newDueDate = LocalDate.parse(dueDate);
	    	int result = currentDate.compareTo(newDueDate);
	    	
	    	if(result > 0)
	    	{
	    		table.add(pj);
	    	}
	    }
	    model.addAttribute("table",table);
		return "ExpiredPolicy";
}



@RequestMapping("/NearbyPolicy")
public String NearbyPolicy(Model model) {
	 

    List<PolicyPojo> policyPojoList = policyPojoDao.getAllAccounts();
    List<PolicyPojo> table = new ArrayList<PolicyPojo>();
    LocalDate currentDate = LocalDate.now();
    System.out.println(currentDate);
    for(PolicyPojo pj : policyPojoList)
    {
    	String dueDate = pj.getDueDate();
    	LocalDate newDueDate = LocalDate.parse(dueDate);
    	int result = currentDate.compareTo(newDueDate);
    	
    	if(result > 0)
    	{
    		table.add(pj);
    	}
    }
    model.addAttribute("table",table);
	return "NearbyPolicy";
}


@RequestMapping("/UpdatePolicy")
public String UpdatePolicy(Model model) {
	 
    
    model.addAttribute("policyPojo", policyPojo);
	return "UpdatePolicy";
}




@RequestMapping(path = "/afterupdatepolicy", method = RequestMethod.POST)	
public String afterupdatepolicyholder(HttpServletRequest request,Model model) {

	
	String contact =request.getParameter("contact");
	String dueDate = request.getParameter("dueDate");
    	
	 policyPojo = policyPojoDao.getAccount(contact);
try{
if (policyPojo != null ) {
	
	policyPojo.setDueDate(dueDate);
	policyPojoDao.update(policyPojo);
	 List<PolicyPojo> policyPojo1= policyPojoDao.getAllAccounts();
	 model.addAttribute("PolicyPojo", policyPojo1);
     return "ViewPolicy";

} }
catch(Exception e)
{System.out.println(e);}
//else {
//
//return "errorPage";
//}
return contact;
}


@RequestMapping(path="/viewAccountsubmit",method=RequestMethod.POST)
public String  view(Model model,HttpServletRequest request)
{ 
	try
	{  int id=Integer.parseInt(request.getParameter("id"));
	String contact=(request.getParameter("contact"));
	List<PolicyPojo> listPolicyPojo = policyPojoDao.getAllAccounts(); //all policies
	List<PolicyPojo> myPolicyPojo = new ArrayList<PolicyPojo>(); // new blank list -->> my policies
	for(PolicyPojo pp : listPolicyPojo)
	{
		if(pp.getContact().equals(contact)&& pp.getId()==id)
		{
			myPolicyPojo.add(pp);             // filtered data of my policies
		}
	}
	
	System.out.println(contact);
	

	
	model.addAttribute("PolicyPojo", myPolicyPojo);
	return  "View";
		
		 
	}
	catch(Exception e)
	{
		System.out.println("Failed to view..!!");
		e.printStackTrace();
		return "error";
	}
	
}


}


