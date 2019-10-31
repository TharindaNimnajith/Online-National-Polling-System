<%@ page import="eVote.DAO" import="java.sql.ResultSet,java.util.*"
	import="javax.servlet.http.HttpSession" session="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote Card</title>

<style type="text/css">
tr, td {
	border: none;
	padding: 10px;
	padding-right: 20px;
}

img:hover {
	border: 2px solid blue;
	hight: 110px;
	width: 130px;
}
</style>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/main1.css" />
<link rel="shortcut icon" href="image/icon.jpg" />
</head>
<body style="background-image: url(image/back.png)">
</head>


<body>

	<div id="trav">
		<header>
			<div style="float: left;">
				<span
					style="margin-left: 20px; margin-top: 10px; margin-bottom: 5px;"><img
					src="image/logo.png" width="120" height="50"></span>
			</div>
			<div align="right" id="right" style="float: right;">
				<span style="font-size: 14px; padding: 5px;"> </span>
			</div>
	</div>

	<nav id="menu" style="background: url(image/navBg.png repeat-x;)">
		<ul id="submenu">
			<li><a href="home.jsp" style="background-color: orange;">Home</a></li>
			<li><a href="voter.jsp" style="background-color: orange;">eVoter
					Card</a></li>
			<li><a href="details.jsp?clas=a"
				style="background-color: orange;">Election Details</a></li>
			<li><a href="cast.jsp" style="background-color: orange;">Cast
					Vote</a></li>
			<li><a href="electionresults.jsp"
				style="background-color: orange;">Election Result</a></li>
		</ul>
	</nav>
	</header>

	<form method="post" action="Addvoter">

		<center>
			<h2 color="red">Voter Id</h2>
			<table style="border: 1px solid #d4d4d4;">
				<caption>Election Commission of Srilanka</caption>
				<tr>
					<td>VoterID</td>
					<td><input type="text" name="VoterID" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>

				</tr>
				<tr>
					<td
						style="font-size: 12px; background-color: #008CBA; direction: rtl;"
						colspan="2"><input type="submit" value="Add Voter"
						class="add-button" /></td>
				</tr>
				<tr>
					<td
						style="font-size: 12px; background-color: #008CBA; direction: rtl;"
						colspan="2"><input type="reset" value="Reset"
						class="reset-button" /></td>
				</tr>
			</table>
</body>
</html>