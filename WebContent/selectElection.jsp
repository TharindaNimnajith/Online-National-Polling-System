<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}

.myLink {
	display: none
}

* {
	box-sizing: border-box;
}

body {
	font-family: Verdana, sans-serif;
}

.mySlides {
	display: none;
}

img {
	vertical-align: middle;
}

/* Slideshow container */
.slideshow-container {
	max-width: 2000px;
	position: relative;
	margin: auto;
}

/* Caption text */
.text {
	color: #f2f2f2;
	font-size: 15px;
	padding: 8px 12px;
	position: absolute;
	bottom: 8px;
	width: 100%;
	text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

/* The dots/bullets/indicators */
.dot {
	height: 15px;
	width: 15px;
	margin: 0 2px;
	background-color: #bbb;
	border-radius: 50%;
	display: inline-block;
	transition: background-color 0.6s ease;
}

.active {
	background-color: #717171;
}

/* Fading animation */
.fade {
	-webkit-animation-name: fade;
	-webkit-animation-duration: 1.5s;
	animation-name: fade;
	animation-duration: 1.5s;
}

@
-webkit-keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}
@
keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
	.text {
		font-size: 11px
	}
}

<
style type ="text/css">tr, td {
	border: none;
	padding: 10px;
	padding-right: 20px;
}
</style>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/main1.css" />
<link rel="shortcut icon" href="image/icon.jpg" />
</head>
<body style="background-image: url(image/header.jpg)">

	<h1 style="font: bold 20px Algerian; color: black; direction: ltr;">
		Welcome , Select Your Election</h1>


	<p>
	<p>
	<form method="post" action="SelectElection">

		<center>

			<table style="border: 1px solid #d4d4d4; padding: 8px 100px">
				<caption>Select your Election</caption>

				<tr>
					<td>Presidential Election<br>
					<input type="radio" name="vp" value="p" id="p" title="select" />
					<P>
						<p>
							Vice Presidential Election<br>
							<input type="radio" name="vp" value="vp" id="vp" title="select" /></td>

				</tr>
			</table>


			<tr>

			</tr>
			<tr>
				<td
					style="font-size: 12px; background-color: #f2f2f2; padding: 8px 12px;"
					colspan="2"><input type="submit" value="Select Election"
					class="add-button" /></td>
			</tr>

			</table>
</body>
</html>