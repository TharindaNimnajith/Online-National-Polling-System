<!-- 
 * This is the forgot password reset page 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="stylesheet" type="text/css" href="Stylesheets/reset.css" />
		
		<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" /> -->
		<link rel="stylesheet" type="text/css" href="Stylesheets/bootstrap1.css" id="bootstrap-css" />
		
		<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
		<script src="JavaScript/bootstrap.js" type="text/javascript"></script>
		
		<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
		<script src="JavaScript/jquery.js" type="text/javascript"></script>
		
        <script src="JavaScript/EmailValidation.js" type="text/javascript"></script>
        
		<title>Candidate Password Reset || Online National Polling System</title>
	</head>
	
	<body>	
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0
			response.setHeader("Expires", "0"); //Proxies
			
			if(session.getAttribute("id") != null) {				
				if(session.getAttribute("userType") == "admin") 
					response.sendRedirect("adminHome.jsp");
				
				if(session.getAttribute("userType") == "voter")
					response.sendRedirect("voterHome.jsp");
				
				if(session.getAttribute("userType") == "candidate")
					response.sendRedirect("candidateHome.jsp");
			}
		%>
		
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>		
		
		<center><h1>Reset Your Password - Candidate</h1></center>
		
		<form method="post" name="form" onsubmit="return validateEmail();" action="ForgotCandidatePasswordServlet">
			<label>E-mail Address</label>
			<input type="text" id="email" name="Email" placeholder="Enter E-mail Address" required />
			<p id="pEmail" class="reset"></p>
			<br /><br />
			
			<input type="submit" value="Reset Password" />
			<br /><br />
		</form>
		
		<label>We will send a randomly generated password to your e-mail inbox.</label>
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</body>
</html>