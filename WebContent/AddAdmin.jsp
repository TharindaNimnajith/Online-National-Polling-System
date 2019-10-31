<!--
 * This is the add admins page
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="stylesheet" type="text/css" href="Stylesheets/add.css" />
		
		<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" /> -->
		<link rel="stylesheet" type="text/css" href="Stylesheets/bootstrap1.css" id="bootstrap-css" />
		
		<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
		<script src="JavaScript/bootstrap.js" type="text/javascript"></script>
		
		<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
		<script src="JavaScript/jquery.js" type="text/javascript"></script>
		
        <script src="JavaScript/AddVoterValidation.js" type="text/javascript"></script>
        
		<title>Add Admin || Online National Polling System</title>
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
				
		<center><h1>Add Admins</h1></center>
		
		<div class="wrapper fadeInDown">
  			<div id="formContent">
				<form method="post" name="form" onsubmit="return validateAddVoter(this);" action="AddAdminServlet">
					<table>
						<tr>
							<td>Username</td>
							<td><input type="text" name="username" /></td>
						</tr>
						
						<tr>
							<td>NIC</td>
							<td><input type="text" name="nic" /></td>
						</tr>
						
						<tr>
							<td>Password</td>
							<td><input type="text" name="password" /></td>
						</tr>
						
						<tr>
							<td>E-mail</td>
							<td><input type="text" name="email" /></td>
							
						</tr>
						
						<tr>
							<td>User Type</td>
							<td>
								<select name="userType">
					    			<option value="admin">Admin</option>
					   				<option value="candidate" disabled>Candidate</option>
					    			<option value="voter" disabled>Voter</option>
								</select>
							</td>
						</tr>

						<tr>
							<td>First Name</td>
							<td><input type="text" name="fname" /></td>
						</tr>
						
						<tr>
							<td>Last Name</td>
							<td><input type="text" name="lname" /></td>
						</tr>
						
						<tr>
							<td>Address</td>
							<td><input type="text" name="address" /></td>
						</tr>
						
						<tr>
							<td>District</td>
							<td><input type="text" name="district" /></td>
						</tr>
						
						<tr>
							<td>Province</td>
							<td><input type="text" name="province" /></td>
						</tr>
						
						<tr>
							<td>Gender</td>
							<td><input type="radio" name="gender" value="M" checked="checked" tabindex="1" />Male</td>
						</tr>		
						<tr>
							<td></td>
							<td><input type="radio" name="gender" value="F" tabindex="2" />Female</td>
						</tr>
						
						<tr>
							<td>Date of Birth</td>
							<td><input type="text" name="DoB" /></td>
						</tr>
						
						<tr>
							<td>Phone No</td>
							<td><input type="text" name="phoneNo" /></td>
						</tr>
									
						<tr>
							<td colspan="2">
								<input type="submit" value="Add Admin" /> 
							</td>
						</tr>
						
						<tr>	
							<td colspan="2">
								<input type="reset" value="Reset" />
							</td>
						</tr>			
					</table>
				</form>
			</div>
		</div>
		
		
		<form method="post" action="ListAdminServlet">
			<div class="list">
				<input type="submit" id="list1" value="List All Admins" />
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
