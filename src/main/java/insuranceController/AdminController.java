package insuranceController;

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
public class AdminController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    InsuranceAgent insuranceAgent = (InsuranceAgent) context.getBean("insuranceAgent");
    InsuranceAgentDao insuranceAgentDao = (InsuranceAgentDao) context.getBean("insuranceAgentDao");
   
    PolicyHolder policyHolder = (PolicyHolder) context.getBean("policyHolder");
    PolicyHolderDao policyHolderDao = (PolicyHolderDao) context.getBean("policyHolderDao");
    

    Admin admin = (Admin) context.getBean("admin");
    AdminDao adminDao = (AdminDao) context.getBean("adminDao");



	@RequestMapping("/AdminLogin")
	public String openAdmin()
	{
		return "AdminLogin";
	}
	

	@RequestMapping("/AdminHome")
	public String AdminDashboard(Model model){
		
		List<InsuranceAgent> InsuranceAgent = insuranceAgentDao.getAllAccounts();
        model.addAttribute("InsuranceAgent", InsuranceAgent);
	  		  return "AdminHome";
	}

	
	
	
	@RequestMapping(path="/afterAdminLoginSubmit",method=RequestMethod.POST)
	public String checkadminLogin(HttpServletRequest request,Model model)
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equals("admin@gmail.com") && password.equals("admin"))
		{  
			
			List<InsuranceAgent> InsuranceAgent = insuranceAgentDao.getAllAccounts();
	        model.addAttribute("InsuranceAgent", InsuranceAgent);
		 
	        return "AdminHome";
			
		}
		else
		{
			
	        return "error";
		}
		
	}


	@RequestMapping(path="/approved/{id}", method=RequestMethod.GET)

	public RedirectView approved(@PathVariable("id") int id, HttpServletRequest request,Model model) {
		
		 List<InsuranceAgent> insuranceAgent = insuranceAgentDao.getAllAccounts();
		 model.addAttribute("insuranceAgent", insuranceAgent);
		
	RedirectView redirectview = new RedirectView();
	redirectview.setUrl(request.getContextPath() + "/AdminHome");
	return redirectview;

	}
	@RequestMapping(path="/disapproved/{id}", method=RequestMethod.GET)

	public RedirectView disapproved(@PathVariable("id") int id, HttpServletRequest request,Model model) {
		
		 List<InsuranceAgent> insuranceAgent = insuranceAgentDao.getAllAccounts();
		 model.addAttribute("insuranceAgent", insuranceAgent);
		
	insuranceAgentDao.deleteCustomer(id);
	
	RedirectView redirectview = new RedirectView();
	redirectview.setUrl(request.getContextPath() + "/AdminHome");
	return redirectview;

	}


	


}
