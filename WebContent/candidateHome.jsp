
<!DOCTYPE html >
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>eVote::Home</title>
<link rel="stylesheet" type="text/css" href="Stylesheets/style.css"/>
<link rel="stylesheet" type="text/css" href="Stylesheets/main1.css"/>
<link rel="shortcut icon" href=image/icon.jpg"/>
</head>

<body style="background-image:url(image/back.png)">
<div id="trav">
<header>
     <div style="float:left;"><span style="margin-left:20px; margin-top:10px; margin-bottom:5px;"><img src="image/logo.png" width="120" height="50"></span> </div>
       
    
    <div align="right" id="right" style="float:right;">
	<span style="font-size:14px; padding:5px;">
	<select class="user" onchange="location = this.options[this.selectedIndex].value;">
                <option selected>
	
		        </option>
                <option value="profile.jsp">Profile</option>
                <option value="pass.jsp">Change Password</option>
                <option value="reg.jsp?choice=12&logout=true">Log Out</option>
            </select>
            |<a href="index.jsp">About eVote</a>  | <a href="home.jsp">Home</a></span>
	<br>
	  <form action="results.jsp">
    Search:<input type="text" style="width:110px;" name="textinput">
    <button type="submit" class="heading">Go</button></form>
</div>
        <div id="clr"></div>
    </header>
</div>

            
   <nav id="menu" style="background:url(/image/navBg.png repeat-x;)">
    	<ul id="submenu">
        	<li><a href="home.jsp" style="background-color:orange;" >Home</a></li>
            <li><a href="Viewcandfrparty.jsp?clas=c" >View Candidate Partywise</a></li>
            <li><a href="details.jsp?clas=b">Election Details</a></li>
            <li><a href="viewcandidate.jsp?clas=b">Candidate Details</a></li>
            <li><a href="electionresults.jsp">Election Result</a></li>
            <li><a href="viewparty.jsp?clas=b">Party Details</a></li>
         </ul>
    </nav>
   
   
   <div id="whole" style=" padding-top: 20px; padding-bottom:20px">
    <section id="sec">
    <center><b><p style="font-family: sans-serif;font-size: 40px;color:red;">Candidate List</p></b></center>
    	<div id="cont" style="padding-left :150px ; padding-top: 20px; padding-bottom:20px">
    	<table border="1" >
    	<tr><td><b>Party</b></td><td><b>Candidate</b></td><td><b>Constituency</b></td></tr>

<form method="post" >
<tr >
	<td>SLFP</td>
	<td>Maithreepala Sirisena</td>
	<td>Constituency</td>
<tr>

<tr >
	<td>UNP</td>
	<td>Ranil Wickramainghe</td>
	<td>Constituency</td>
<tr>

<tr >
	<td>JVP</td>
	<td>Tilvin Silva</td>
	<td>Constituency</td>
<tr>

<tr >
	<td>SLMC</td>
	<td>Mohommed Shafraz</td>
	<td>Constituency</td>
<tr>

	<%--<td><input type="submit" id="submit" value="Add"> </input></td></tr></form>--%>

</table>


    	</div>
    </section>
    <aside id="ad">
    <div="news>
    <table border="1" width="100px" bgcolor="#ffffff">
            <tr bordercolor="#FFFFFF"><td><center><img src="image/splWeekHeading.png"></center></td></tr>
   			<tr><td><marquee direction="up"><center><h3 style="color:red">Important Dates</h3><br><h5 style="color:blue">Party Registration Last Day&nbsp; &nbsp; &nbsp;06/15/2015</h5>
<br><h5 style="color:blue">Candidate Registration Last Day&nbsp; &nbsp; &nbsp;06/15/2015</h5>
<br><h5 style="color:blue">Voter ID Req  Last Day&nbsp; &nbsp; &nbsp;06/15/2019</h5>

<br><h5 style="color:blue">Voting Starts From&nbsp; &nbsp; &nbsp;06/15/2019</h5>
</center></marquee></td>
    	</tr></table>
        <div style="position:relative; right:-300px; top:-30px; margin-top:0px; width:40px;"><a href="#"><img src="/image/viewAll.png"></a></div>
            <img src="image/add2.jpg">
</div>
    </aside>
    </div>
<div class="footer">	
	<div class="subFooter">
		<a href="#" class="back2Top" id="toTop"><img src="image/bk2Top.png" width="196px" height="40px" alt="" title="" /></a>
    	<div class="footerMenu marginRigh40">
        <h1>Quick Links</h1>
        	<ul>
            	<li><a href="home.jsp">Home</a></li>
                <li><a href="http://eci.nic.in/m/faqs.html">FAQ</a></li>
                <li><a href="contact.jsp">Contact Us</a></li>
            </ul>
        </div>
        <div class="footerMenu footerMenu2">
        <br>
        	<ul>
				<li><a href="https://en.m.wikipedia.org/wiki/Government_of_Sri Lanka">Govt. of Sri Lanka</a>
              
                <li><a href="https://en.m.wikipedia.org/wiki/Election_Commission_of_Sri Lanka">Election Commission</a></li> 
            </ul>
            <div class="clear"></div>
        </div>
        <div class="footerSocialIcon">
        <h1>Find us</h1>
        <a href="https://www.facebook.com"><img src="image/f_connect.png" alt="Connect to Facebook" title="Connect to Facebook" /></a>
        <a href="https://twitter.com"><img src="image/t_follow.png" alt="Follow on Twitter" title="Follow on Twitter" /></a>
        <a href="https://www.linkedin.com"><img src="image/l_connect.png" alt="Connect on LinkedIn" title="Connect on LinkedIn" /></a>
        </div>
        <div class="clear">&nbsp;</div><br>
        <div id="last"> <center><sup color="red">&copy;</sup> Election Commission Of Sri Lanka </center>
</div>
    </div>
    </div>
   
</body>
</html>


            