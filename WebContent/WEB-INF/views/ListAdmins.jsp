<!--
 * This is the admins list page
-->

<%@ page import="java.util.ArrayList" %>

<%@ page import="com.onps.model.Admin" %>

<%@ page import="com.onps.service.AdminServiceImpl" %>
<%@ page import="com.onps.service.IAdminService" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="stylesheet" type="text/css" href="Stylesheets/list.css" />
		
		<title>Admins List || Online National Polling System</title>
	</head>
	
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0
			response.setHeader("Expires", "0"); //Proxies
			
			if(session.getAttribute("id") == null)
				response.sendRedirect("Home.jsp");
		%>
		
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
				
		<center><h1>List of Admins</h1></center>
	
	  	<div>
			<table border="1" id="user">			 	
			  	<tr>
	                <th>Employee ID</th>
	                <th>Username</th>
	                <th>NIC</th>
	                <th>Password</th>
	                <th>E-mail</th>
	                <th>User Type</th>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>Address</th>
	                <th>District</th>
	                <th>Province</th>
	                <th>Gender</th>
	                <th>Date of Birth</th>
	                <th>Phone No</th>
	                <th>Select</th>
	            </tr>
	            
	            <%
		            IAdminService iAdminService = new AdminServiceImpl();
		            
					ArrayList<Admin> arrayList = iAdminService.getAdmins();
					
					for(Admin admin : arrayList) {
				%>
							
						<tr>
							<td><%=admin.getId() %></td>
							<td><%=admin.getUsername() %></td>
							<td><%=admin.getNic() %></td>
							<td><%=admin.getPassword() %></td>
							<td><%=admin.getEmail() %></td>
							<td><%=admin.getUserType() %></td>
							<td><%=admin.getFname() %></td>
							<td><%=admin.getLname() %></td>
							<td><%=admin.getAddress() %></td>
							<td><%=admin.getDistrict() %></td>
							<td><%=admin.getProvince() %></td>
							<td><%=admin.getGender() %></td>
							<td><%=admin.getDoB() %></td>
							<td><%=admin.getPhoneNo() %></td>	
							
							<td> 
								<form method="post" action="GetAdminServlet">
								
									<!-- The hidden input field is not shown to the user, but the data is sent when 
									the form is submitted -->
									<input type="hidden" name="id" value="<%=admin.getId() %>" />
									
								 	<input type="submit" value= "Select Admin" /> 
								</form>
							</td>	
						</tr>
							
				<%	
					}
	            %>     
			</table>
		</div>
		
		<a href="AddVoter.jsp">
			<button>Add Voter</button>
		</a>
		
		<a href="AddAdmin.jsp">
			<button>Add Admin</button>
		</a>
		
		<a href="AddCandidate.jsp">
			<button>Add Candidate</button>
		</a>
		
		<form method="post" action="LogoutServlet">
			<input type="submit" value="Logout" />
		</form>
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</body>
</html>
