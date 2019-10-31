<!--
 * This is the admin home page
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="stylesheet" type="text/css" href="Stylesheets/adminhome.css" />
		
		<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" /> -->
		<link rel="stylesheet" type="text/css" href="Stylesheets/bootstrap1.css" id="bootstrap-css" />
		
		<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
		<script src="JavaScript/bootstrap.js" type="text/javascript"></script>
		
		<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
		<script src="JavaScript/jquery.js" type="text/javascript"></script>
		
		<title>Home - Administrator || Online National Polling System</title>
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
		
		<center>
			<h1>Admin Home</h1>
			
			<br /> <br />
			
			<a href="AddVoter.jsp">Add Voters</a>
			<br /><br />
			
			<a href="AddAdmin.jsp">Add Administrators</a>
			<br /><br />
			
			<a href="AddCandidate.jsp">Add Candidates</a>
			<br /><br />
			
			<form method="post" action="LogoutServlet">
				<input type="submit" value="Logout" />
			</form>
		</center>
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</body>
</html>
