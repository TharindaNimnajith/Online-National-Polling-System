<!--
 * This is the candidates list page
-->

<%@ page import="java.util.ArrayList" %>

<%@ page import="com.onps.model.Candidate" %>

<%@ page import="com.onps.service.CandidateServiceImpl" %>
<%@ page import="com.onps.service.ICandidateService" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="stylesheet" type="text/css" href="Stylesheets/list.css" />
		
		<title>Candidates List || Online National Polling System</title>
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
				
		<center><h1>List of Candidates</h1></center>
	
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
		            ICandidateService iCandidateService = new CandidateServiceImpl();
		            
					ArrayList<Candidate> arrayList = iCandidateService.getCandidates();
					
					for(Candidate candidate : arrayList) {
				%>
							
						<tr>
							<td><%=candidate.getId() %></td>
							<td><%=candidate.getUsername() %></td>
							<td><%=candidate.getNic() %></td>
							<td><%=candidate.getPassword() %></td>
							<td><%=candidate.getEmail() %></td>
							<td><%=candidate.getUserType() %></td>
							<td><%=candidate.getFname() %></td>
							<td><%=candidate.getLname() %></td>
							<td><%=candidate.getAddress() %></td>
							<td><%=candidate.getDistrict() %></td>
							<td><%=candidate.getProvince() %></td>
							<td><%=candidate.getGender() %></td>
							<td><%=candidate.getDoB() %></td>
							<td><%=candidate.getPhoneNo() %></td>	
							
							<td> 
								<form method="post" action="GetCandidateServlet">
									<!-- The hidden input field is not shown to the user, but the data i
									s sent when the form is submitted -->
									<input type="hidden" name="id" value="<%=candidate.getId() %>" />
									
								 	<input type="submit" value="Select Candidate" /> 
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
