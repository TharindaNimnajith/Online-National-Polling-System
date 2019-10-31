<!--
 * This is the voter home page
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<title>Home - Voter || Online National Polling System</title>
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
		
		<h1>Voter Home</h1>
		
		<form method="post" action="LogoutServlet">
			<input type="submit" value="Logout" />
		</form>
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</body>
</html>
