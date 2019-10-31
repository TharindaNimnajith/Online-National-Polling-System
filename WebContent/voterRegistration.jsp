<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<title>Voter Registration || Online National Polling System</title>
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
		
		<h1>Voter Registration</h1>
		
		<label>Already have an account? Click <a href="voterLogin.jsp">here</a> to login.</label>
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</body>
</html>
