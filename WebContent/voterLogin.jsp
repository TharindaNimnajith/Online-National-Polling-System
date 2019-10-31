<!--
 * This is the voter login page
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="stylesheet" type="text/css" href="Stylesheets/login.css" />
		
		<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" /> -->
		<link rel="stylesheet" type="text/css" href="Stylesheets/bootstrap1.css" id="bootstrap-css" />
		
		<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
		<script src="JavaScript/bootstrap.js" type="text/javascript"></script>
		
		<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
		<script src="JavaScript/jquery.js" type="text/javascript"></script>
		
	    <script src="JavaScript/LoginValidation.js" type="text/javascript"></script>
        
		<title>Voter Login || Online National Polling System</title>
	</head>
	
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0
			response.setHeader("Expires", "0"); //Proxies
			
			if(session.getAttribute("id") != null) {
				if(session.getAttribute("userType") == "admin")
					response.sendRedirect("adminHome.jsp");
				
				if(session.getAttribute("userType") == "candidate")
					response.sendRedirect("candidateHome.jsp");
				
				if(session.getAttribute("userType") == "voter")
					response.sendRedirect("voterHome.jsp");
			}
		%>
		
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
		
		<div align="center">
			<label>${message}</label>
		</div>
		
		<center><h1>Voter Login</h1></center>	
		
		<div class="wrapper fadeInDown">
  			<div id="formContent">
				<form name="form" method="post" onsubmit="return validateLogin(this);" action="VoterLoginServlet">	
					<div>
						<input type="text" name="username" class="fadeIn first" placeholder="Enter Username" />
						<br />
					</div>
	
					<div>
						<input type="text" name="nic" class="fadeIn second" placeholder="Enter NIC" />
						<br/>
					</div>
					
					<div>
						<input type="password" name="password" class="fadeIn third" placeholder="Enter Password" /> <br />
					</div>
					
					<div>
						<input type="submit"  class="fadeIn fourth" value="Login" />
					</div>
					
					<div>
						<input type="reset"  class="fadeIn fourth" value="Reset" />
					</div>			
				</form>
				
				<div id="formFooter">
					<label>Forgot password? Click <a href="voterReset.jsp">here</a> to reset password</label>
					<label>Don't have an account? Click <a href="voterRegistration.jsp">here</a> to register</label>
				</div>
		  	</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</body>
</html>
