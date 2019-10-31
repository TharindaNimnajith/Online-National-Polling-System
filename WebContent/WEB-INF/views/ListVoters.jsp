<!--
 * This is the voters list page
-->

<%@ page import="java.util.ArrayList" %>

<%@ page import="com.onps.model.Voter" %>

<%@ page import="com.onps.service.VoterServiceImpl" %>
<%@ page import="com.onps.service.IVoterService" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="stylesheet" type="text/css" href="Stylesheets/list.css" />
		
		<title>Voters List || Online National Polling System</title>
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
				
		<center><h1>List of Voters</h1></center>
	
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
		            IVoterService iVoterService = new VoterServiceImpl();
		            
					ArrayList<Voter> arrayList = iVoterService.getVoters();
					
					for(Voter voter : arrayList) {
				%>
							
						<tr>
							<td><%=voter.getId() %></td>
							<td><%=voter.getUsername() %></td>
							<td><%=voter.getNic() %></td>
							<td><%=voter.getPassword() %></td>
							<td><%=voter.getEmail() %></td>
							<td><%=voter.getUserType() %></td>
							<td><%=voter.getFname() %></td>
							<td><%=voter.getLname() %></td>
							<td><%=voter.getAddress() %></td>
							<td><%=voter.getDistrict() %></td>
							<td><%=voter.getProvince() %></td>
							<td><%=voter.getGender() %></td>
							<td><%=voter.getDoB() %></td>
							<td><%=voter.getPhoneNo() %></td>	
							
							<td> 
								<form method="post" action="GetVoterServlet">
									<!-- The hidden input field is not shown to the user, but the data is sent when the form is submitted -->
									<input type="hidden" name="id" value="<%=voter.getId() %>" />
								 	<input type="submit" value= "Select Voter" /> 
								</form>
							</td>	
						</tr>
							
				<%	
					}
	            %>     
			</table>
		</div>
		
		<a href="AddVoter.jsp" class=600>
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
