<!--
 * This is the get admin page
-->

<%@ page import="com.onps.model.Admin" %>

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
		
		<% Admin admin = (Admin)request.getAttribute("admin"); %>
		
		<title><%=admin.getUsername() %> || Online National Polling System</title>
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
				
		<center><h1>Admin Details of <%=admin.getUsername() %></h1></center>

		
			<div class="wrapper fadeInDown">
	  			<div id="formContent">
					<form method="post" action="UpdateAdminServlet">
						<table>			
							<tr>
								<td>Admin ID</td>
								<td><input type="text" name="id" disabled="disabled" value="<%=admin.getId() %>" /></td>
							</tr>
							
							<tr>
								<td>Username</td>
								<td><input type="text" name="username" value="<%=admin.getUsername() %>" /></td>
							</tr>
							
							<tr>
								<td>NIC</td>
								<td><input type="text" name="nic" value="<%=admin.getNic() %>" /></td>
							</tr>
							
							<tr>
								<td>Password</td>
								<td><input type="text" name="password" value="<%=admin.getPassword() %>" /></td>
							</tr>
							
							<tr>
								<td>E-mail</td>
								<td><input type="text" name="email" value="<%=admin.getEmail() %>" /></td>
							</tr>
							
							<tr>
								<td>User Type</td>					
								<td>
									<select name="userType" required>
										<option value="<%=admin.getUserType() %>"><%=admin.getUserType() %></option>
						   				<option value="candidate" disabled>Candidate</option>
						    			<option value="voter" disabled>Voter</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td>First Name</td>
								<td><input type="text" name="fname" value="<%=admin.getFname() %>" /></td>
							</tr>
							
							<tr>
								<td>Last Name</td>
								<td><input type="text" name="lname" value="<%=admin.getLname() %>" /></td>
							</tr>
							
							<tr>
								<td>Address</td>
								<td><input type="text" name="address" value="<%=admin.getAddress() %>" /></td>
							</tr>
							
							<tr>
								<td>District</td>
								<td><input type="text" name="district" value="<%=admin.getDistrict() %>" /></td>
							</tr>
							
							<tr>
								<td>Province</td>
								<td><input type="text" name="province" value="<%=admin.getProvince() %>" /></td>
							</tr>
							
							<tr>
								<td>Gender</td>
								<td><input type="text" name="gender" value="<%=admin.getGender() %>" /></td>
							</tr>
							
							<tr>
								<td>Date of Birth</td>
								<td><input type="text" name="DoB" value="<%=admin.getDoB() %>" /></td>
							</tr>
							
							<tr>
								<td>Phone No</td>
								<td><input type="text" name="phoneNo" value="<%=admin.getPhoneNo() %>" /></td>
							</tr>
							
							<tr>
								<td>
									<input type="hidden" name="id" value="<%=admin.getId() %>" /> 
									<input type="submit" value="Update Admin" />
								</td>
							</tr>				
						</table>
					</form>			
				</div>
			</div>
		
			
		<form method="post" action="DeleteAdminServlet">
			<input type="hidden" name="id" value="<%=admin.getId() %>" /> 
			<div class="list">
				<input type="submit" id="list1" value="Delete Admin" />
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
