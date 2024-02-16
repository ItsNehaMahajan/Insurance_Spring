<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@page import="insuranceModel.PolicyPojo"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins&display=swap">
<title>Home Page</title>
<style>
/* Your existing styles */

/* ... (Keep the existing styles) ... */

/* New styles for the navbar */
body {
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	align-items: left;
	height: 100vh;
	background: linear-gradient(45deg, rgb(3, 3, 6),
		rgba(21, 26, 194, 0.973));
	font-family: "Sans-serif";
}

nav {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 15px;
	background-color: rgba(255, 255, 255, 0.13);
	border-bottom: 2px solid rgba(255, 255, 255, 0.1);
}

nav .logo {
	display: flex;
	align-items: center;
}

nav ul {
	list-style: none;
	display: flex;
	margin-left: auto; /* Align the menu to the right */
}

nav li {
	margin-right: 20px;
	position: relative;
	/* Set position to relative for dropdown positioning */
}

nav a {
	text-decoration: none;
	color: #ffffff;
	font-size: 20px;
	font-weight: 500;
}

.logo h1 {
	font-size: 25px;
	font-weight: 800;
	color: #ffffff;
}

/* New styles for the dropdown menus */
.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: rgba(255, 255, 255, 0.9);
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	min-width: 160px; /* Adjust as needed */
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown-content a {
	color: #000000;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.table-container {
	margin-top: 20px;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

table {
	width: 100%;
	border-collapse: collapse;
	background-color: #fff;
	border: 2px solid #000;
}

th, td {
	border: 2px solid #000;
	padding: 8px;
	text-align: left;
}

thead {
	background-color: #343a40;
	color: #fff;
}
</style>
</head>
<body>
<nav>
        <div class="logo">
            <!-- Replace with the actual path and dimensions of your logo -->
            <h1>Insurance</h1>
        </div>
        <ul>
            <li><a href="Agent">Home</a></li>
            <li class="dropdown"><a href="Agent" class="dropbtn">Policy
                    Holder</a>
                <div class="dropdown-content">
                    <a href="AddPolicyHolder">Add Policy Holder</a> <a
                        href="ViewPolicyHolder">View Policy Holder</a> <a
                        href="DeletePolicyHolder">Delete Policy Holder</a> <a
                        href="UpdatePolicyHolder">Update Policy Holder</a>
                </div></li>
            <li class="dropdown"><a href="#" class="dropbtn">Policy</a>
                <div class="dropdown-content">
                    <a href="AddPolicy">Add Policy</a>
                     <a href="ViewPolicy">View Policy</a>
                    <a href="ExpiredPolicy">Expired Policy</a>
                     <a href="NearbyPolicy">View Nearby Policy</a>
                      <a href="UpdatePolicy">Update Due date Policy</a>
                     
                </div></li>
            <li><a href="index">Logout</a></li>
        </ul>
    </nav>

	<div class="table-container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Date Of Birth</th>
					<th scope="col">Contact</th>
					<th scope="col">email</th>
					<th scope="col">Policy Title</th>
					<th scope="col">Policy Details</th>
					<th scope="col">Due Date</th>
					

				</tr>
			</thead>
			
			
			<tbody>
				<%
				List<PolicyPojo> listPolicyPojo =(List<PolicyPojo>)request.getAttribute("PolicyPojo");
				for(PolicyPojo policyPojo : listPolicyPojo)
				{
				%>
				<tr>
					<td><%=policyPojo.getId() %></td>
					<td><%=policyPojo.getName() %></td>
					<td><%=policyPojo.getDob() %></td>
					<td><%=policyPojo.getContact() %></td>
					<td><%=policyPojo.getEmail() %></td>
					<td><%=policyPojo.getPolicyTitle() %></td>
					<td><%=policyPojo.getDetails() %></td>
					<td><%=policyPojo.getDueDate() %></td>
					
					
				</tr>
				<%
}
%>
				
				
				
				
				
			</tbody>
		</table>
</body>
</html>
