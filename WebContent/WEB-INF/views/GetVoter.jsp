<!--
 * This is the get voter page
-->

<%@ page import="com.onps.model.Voter" %>

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
		
		<% Voter voter = (Voter)request.getAttribute("voter"); %>
		
		<title><%=voter.getUsername() %> || Online National Polling System</title>
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
				
		<center><h1>Voter Details of <%=voter.getUsername() %></h1></center>
		
		<div class="wrapper fadeInDown">
	  			<div id="formContent">
				<form method="post" action="UpdateVoterServlet">
					<table>			
						<tr>
							<td>Voter ID</td>
							<td><input type="text" name="id" disabled="disabled" value="<%=voter.getId() %>" /></td>
						</tr>
						
						<tr>
							<td>Username</td>
							<td><input type="text" name="username" value="<%=voter.getUsername() %>" /></td>
						</tr>
						
						<tr>
							<td>NIC</td>
							<td><input type="text" name="nic" value="<%=voter.getNic() %>" /></td>
						</tr>
						
						<tr>
							<td>Password</td>
							<td><input type="text" name="password" value="<%=voter.getPassword() %>" /></td>
						</tr>
						
						<tr>
							<td>E-mail</td>
							<td><input type="text" name="email" value="<%=voter.getEmail() %>" /></td>
						</tr>
						
						<tr>
							<td>User Type</td>					
							<td>
								<select name="userType" required>
									<option value="<%=voter.getUserType() %>"><%=voter.getUserType() %></option>
					   				<option value="candidate" disabled>Candidate</option>
					    			<option value="admin" disabled>Administrator</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>First Name</td>
							<td><input type="text" name="fname" value="<%=voter.getFname() %>" /></td>
						</tr>
						
						<tr>
							<td>Last Name</td>
							<td><input type="text" name="lname" value="<%=voter.getLname() %>" /></td>
						</tr>
						
						<tr>
							<td>Address</td>
							<td><input type="text" name="address" value="<%=voter.getAddress() %>" /></td>
						</tr>
						
						<tr>
							<td>District</td>
							<td><input type="text" name="district" value="<%=voter.getDistrict() %>" /></td>
						</tr>
						
						<tr>
							<td>Province</td>
							<td><input type="text" name="province" value="<%=voter.getProvince() %>" /></td>
						</tr>
						
						<tr>
							<td>Gender</td>
							<td><input type="text" name="gender" value="<%=voter.getGender() %>" /></td>
						</tr>
						
						<tr>
							<td>Date of Birth</td>
							<td><input type="text" name="DoB" value="<%=voter.getDoB() %>" /></td>
						</tr>
						
						<tr>
							<td>Phone No</td>
							<td><input type="text" name="phoneNo" value="<%=voter.getPhoneNo() %>" /></td>
						</tr>
						
						<tr>
							<td>
								<input type="hidden" name="id" value="<%=voter.getId() %>" /> 
								<input type="submit" value="Update Voter" />
							</td>
						</tr>				
					</table>
				</form>			
			</div>
		</div>
			
		<form method="post" action="DeleteVoterServlet">
			<input type="hidden" name="id" value="<%=voter.getId() %>" /> 
			<div class="list">
				<input type="submit" id="list1" value="Delete Voter" />
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
