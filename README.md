Insurance Application

This is an insurance application designed to manage insurance agents, policy holders, and policies. It provides functionalities for different types of users including Insurance Agents and Policy Holders.
 
Features

Admin(Admin id, password)
- Login
-	View Approved Insurance Agents
-	View Disapproved Insurance Agents
 
Insurance Agent: (id, name, dob, contact, address, email, password)
-	Login
-	Register
-	Add/View/Delete Policy Holders
-	Update Policy Holder (Mobile, email)
-	Add Policy (policy table specified below)
-	View Policy
-	View nearBy(1 month) expiry policies
-	View expired policies
-	Update due date of policy	
-	View Approved Policy Holder
-	View Disapproved Policy Holder

  
Policy Holder: (id(AI), name, dob, contact, address, email, password)
-	Login
-	View Own Policy
-	Book Appointment
-	View Status of Appointment

policy_tbl : holderName, dob, contact, email, policyTitle, policyDetails.
dueDate

 Technologies Used

- Java(jre 1.8)
- Spring Framework (Spring Boot, Spring MVC)
- Maven
- MySQL (or any preferred database)

