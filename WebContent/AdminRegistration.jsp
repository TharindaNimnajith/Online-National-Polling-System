<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<script> 
function validate()
{ 
	var fname = document.form.fname.value;
	 var lname = document.form. lname.value;
	 var hmadd = document.form.address.value; 
	 var dob = document.form.DoB.value;
	 var gender= document.form.gender.value;
	 var district= document.form.district.value;
	 var province= document.form.province.value;
	 var nic= document.form.nic.value;
	 var username= document.form.username.value;
	 var email= document.form.email.value;
	 var phoneNo= document.form.phoneNo.value;
	 var password= document.form.password.value;
	 var conpassword= document.form.conpassword.value;
	 
	 
	 if (fname==null || fname=="")
	 { 
	 alert("First Name can't be blank"); 
	 return false; 
	 }
	 
	 else if (lname==null || lname=="")
	 { 
	 alert("Last Name can't be blank"); 
	 return false; 
	 }
	 
	 else if (address==null || address=="")
	 { 
	 alert("Home Address can't be blank"); 
	 return false; 
	 }
	 
	 else if (DoB==null || DoB=="")
	 { 
	 alert("Date of Birth can't be blank"); 
	 return false; 
	 }
	 
	 else if (gender==null || gender=="")
	 { 
	 alert("Gender can't be blank"); 
	 return false; 
	 }
	 
	 else if (district==null || district=="")
	 { 
	 alert("District can't be blank"); 
	 return false; 
	 }
	 
	 else if (province==null || province=="")
	 { 
	 alert("Province can't be blank"); 
	 return false; 
	 }
	 
	 else if (nic==null || nic=="")
	 { 
	 alert("National Identity Card Number can't be blank"); 
	 return false; 
	 }
	  
	 else if (username==null || username=="")
	 { 
	 alert("Username can't be blank"); 
	 return false; 
	 }
	 
	 else if (email==null || email=="")
	 { 
	 alert("Email can't be blank"); 
	 return false; 
	 }
	 
	 else if (phoneNo==null || mob=="")
	 { 
	 alert("Phone Number can't be blank"); 
	 return false; 
	 }
	
 } 
</script> 
</head>
<body>
<center><h2>Admin Register Form</h2></center>
<form name="form" action="AdminRegisterServlet" method="post" onsubmit="return validate()">
<table align="center">
 <tr>
<td> First Name </td>
<td><input type = "text" placeholder="Enter First Name "  name = "fname"></td>
</tr>

<tr>
<td> Last Name </td>
<td><input type= "text" placeholder="Enter Last Name" name = "lname"></td>
</tr>

<tr>
<td> Home Address </td>
<td><input type="text" placeholder="Enter Home Address" name = "address"></td>
</tr>

<tr>
<td>Date of Birth </td>
<td><input type="text" placeholder="Date of Birth" name = "DoB"></td>
</tr>

<tr>
<td><label for = "gender">Gender </label></td>
<td><input type = "text" placeholder="Gender" name = "gender"></td>
</tr>

<tr>
<td><label for = "district">District  </label></td>
<td><input type = "text" placeholder="District" name = "district"></td>
</tr>

<tr>
<td><label for = "province">Province</label></td>
<td><input type = "text" placeholder="Province" name = "province"></td>
</tr>

<tr>
<td><label for = "nic">National identity card number(NIC)  </label></td>
<td><input type = "text" placeholder="NIC" name = "nic"></td>
</tr>

<tr>
<td><label for = "username">User name</label></td>
<td><input type = "text" placeholder="username or email" name = "username"></td>
</tr>

<tr>
<td> Email</td>
<td><input type = "text" placeholder="Email" name = "email"></td>
</tr>


<tr>
<td><label for="phoneNo"> Phone Number </label></td>
<td><input type = "text" placeholder="Phone Number" name = "phoneNo"></td>
</tr>


 <tr>
 <td>Password</td>
 <td><input type="password" name="password" /></td>
 </tr>
 <tr>
 <td>Confirm Password</td>
 <td><input type="password" name="conpassword" /></td>
 </tr>
 <tr>
 <td><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></td>
 </tr>
 <tr>
 <td></td>
 <td>
<button type="submit"> Submit </button>

 <input type="reset" value="Reset"></input></td>
 </tr>
</table>
</form>

</body>
</html>