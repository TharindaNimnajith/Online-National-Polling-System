<!--
 * This is the get candidate page
-->

<%@ page import="com.onps.model.Candidate" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="stylesheet" type="text/css" href="Stylesheets/get.css" />
		
		<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" /> -->
		<link rel="stylesheet" type="text/css" href="Stylesheets/bootstrap1.css" id="bootstrap-css" />
		
		<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
		<script src="JavaScript/bootstrap.js" type="text/javascript"></script>
		
		<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
		<script src="JavaScript/jquery.js" type="text/javascript"></script>
		
		<% Candidate candidate = (Candidate)request.getAttribute("candidate"); %>
		
		<title><%=candidate.getUsername() %> || Online National Polling System</title>
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
				
		<center><h1>Candidate Details of <%=candidate.getUsername() %></h1></center>

		<div class="wrapper fadeInDown">
	  			<div id="formContent">
				<form method="post" action="UpdateCandidateServlet">
					<table>			
						<tr>
							<td>Candidate ID</td>
							<td><input type="text" name="id" disabled="disabled" value="<%=candidate.getId() %>" /></td>
						</tr>
						
						<tr>
							<td>Username</td>
							<td><input type="text" name="username" value="<%=candidate.getUsername() %>" /></td>
						</tr>
						
						<tr>
							<td>NIC</td>
							<td><input type="text" name="nic" value="<%=candidate.getNic() %>" /></td>
						</tr>
						
						<tr>
							<td>Password</td>
							<td><input type="text" name="password" value="<%=candidate.getPassword() %>" /></td>
						</tr>
						
						<tr>
							<td>E-mail</td>
							<td><input type="text" name="email" value="<%=candidate.getEmail() %>" /></td>
						</tr>
						
						<tr>
							<td>User Type</td>					
							<td>
								<select name="userType" required>
									<option value="<%=candidate.getUserType() %>"><%=candidate.getUserType() %></option>
					   				<option value="voter" disabled>Voter</option>
					    			<option value="admin" disabled>Administrator</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>First Name</td>
							<td><input type="text" name="fname" value="<%=candidate.getFname() %>" /></td>
						</tr>
						
						<tr>
							<td>Last Name</td>
							<td><input type="text" name="lname" value="<%=candidate.getLname() %>" /></td>
						</tr>
						
						<tr>
							<td>Address</td>
							<td><input type="text" name="address" value="<%=candidate.getAddress() %>" /></td>
						</tr>
						
						<tr>
							<td>District</td>
							<td><input type="text" name="district" value="<%=candidate.getDistrict() %>" /></td>
						</tr>
						
						<tr>
							<td>Province</td>
							<td><input type="text" name="province" value="<%=candidate.getProvince() %>" /></td>
						</tr>
						
						<tr>
							<td>Gender</td>
							<td><input type="text" name="gender" value="<%=candidate.getGender() %>" /></td>
						</tr>
						
						<tr>
							<td>Date of Birth</td>
							<td><input type="text" name="DoB" value="<%=candidate.getDoB() %>" /></td>
						</tr>
						
						<tr>
							<td>Phone No</td>
							<td><input type="text" name="phoneNo" value="<%=candidate.getPhoneNo() %>" /></td>
						</tr>
						
						<tr>
							<td>
								<input type="hidden" name="id" value="<%=candidate.getId() %>" /> 
								<input type="submit" value="Update Candidate" />
							</td>
						</tr>				
					</table>
				</form>			
			</div>
		</div>
			
		<form method="post" action="DeleteCandidateServlet">
			<input type="hidden" name="id" value="<%=candidate.getId() %>" /> 
			<div class="list">
				<input type="submit" id="list1" value="Delete Candidate" />
			</div>	
		</form>

		<form method="post" action="LogoutServlet">
			<div class="logout">
				<input type="submit" id="signout" value="Logout" />
			</div>
		</form>
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</body>
</html>
