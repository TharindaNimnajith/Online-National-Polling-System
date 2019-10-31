<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register || Online National Polling System</title>
		<link rel = "stylesheet" type = "text/css" href ="CSS/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       
        <script src="JavaS/java.js" type="text/javascript"></script>
        
        
<style>
* {
    box-sizing: border-box;
}

input[type=text], select, textarea {
    width: 60%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: vertical;
}

label {
    padding-left: 105px;
    padding-bottom: 12px;
    padding-top: 12px;
    display: inline-block;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: right;
}

input[type=submit]:hover {
    background-color:darkorange;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}

.col-25 {
    float: left;
    width: 25%;
    margin-top: 6px;
}

.col-75 {
    float: left;
    width: 75%;
    margin-top: 6px;
}

.row:after {
    content: "";
    display: table;
    clear: both;
}

    .rad{
        float: left;
        margin-top: 0px;
    }

    
    .sub{
        float: right;
        margin-top:-5%;
    }
    @media screen and (max-width: 600px) {
    .col-25, .col-75, input[type=submit] {
        width: 100%;
        margin-top: 0;
    }
}
</style>
	</head>
	
	<body>
	
	<nav>
                
                
        </nav>
            
             <h2 style="text-align: center; padding-top: 30px; padding-bottom: 30px">Registration</h2>
         

        
<div class="container">
  <form name="myform"  mehod = "POST" action="RegisterCandidateServelet">
  
    <div class="row">
    
      <div class="col-25">
        <label for="fname">ID Number</label>
        
      </div>
      <div class="col-75">
        <input type="text" id="idname" name="id" placeholder="Your ID number.." required>
            <p id="pidname" class="reset"></p>
      </div>
    </div>
      
    <div class="row">
      <div class="col-25">
        <label for="lname">User Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="uname" name="username" placeholder="Your user name.." required>
            <p id="uname" class="reset"></p>
      </div>
    </div>
    
      <div class="row">
      <div class="col-25">
        <label for="nic">NIC Number</label>
      </div>
      <div class="col-75">
        <input type="text" id="nic" name="nic" placeholder="Your nic number.." required>
            <p id="pnic" class="reset"></p>
      </div>
    </div>
    
   
      
      <div class="row">
      <div class="col-25">
        <label for="Password">Password</label>
      </div>
      <div class="col-75">
         <input type="password" id="Password" name="Password" placeholder="Your Password.." required>
            <p id="pPassword" class="reset"></p>
      </div>   
    </div>  
      
      
    <div class="row">
      <div class="col-25">
        <label for="Confirm Password">Confirm Password</label>
      </div>
      <div class="col-75">
       <input type="password" id="ConfirmPassword" name="Confirm Password" placeholder="Type your Password again.." required> 
            <p id="pConfirmPassword" class="reset"></p>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="E mail">E mail</label>
      </div>
      <div class="col-75">
         <input type="email" id="Email" name="Email" placeholder="Your E mail.." required>
          <p id="pemal" class="reset"></p>
      </div>   
    </div>  
    
    
     <div class="row">
      <div class="col-25">
        <label for="isvoted">Is Voted?</label>
      </div>
      <div class="col-75">
         <input type="text" id="isvoted" name="isvoted" required>
          <p id="pisvoted" class="reset"></p>
      </div>   
    </div> 
    
     <div class="row">
      <div class="col-25">
        <label for="fname">Full Name</label>
      </div>
      <div class="col-75">
         <input type="text" id="fname" name="fname" placeholder="Your last name.." required>
          <p id="pfname" class="reset"></p>
      </div>   
    </div> 
    
   
    <div class="row">
      <div class="col-25">
        <label for="lname">Last Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="lname" name="lastname" placeholder="Your last name.." required>
            <p id="plname" class="reset"></p>
      </div>
    </div>
    
      
      
      <div class="row">
      <div class="col-25">
        <label for="Address">Address</label>
      </div>
      <div class="col-75">
         <input type="text" id="Address" name="Address" placeholder="Your Address.." required>
            <p id="pAddress" class="reset"></p>
      </div>   
    </div> 
      
          <div class="row">
      <div class="col-25">
        <label for="District">District</label>
      </div>
      <div class="col-75">
         <input type="text" id="district" name="district" placeholder="Your District.." required>
            <p id="pdistrict" class="reset"></p>
      </div>   
    </div>  
      
      <div class="row">
      <div class="col-25">
        <label for="Province">Province</label>
      </div>
      <div class="col-75">
         <input type="text" id="Province" name="Province" placeholder="Your Province.." required>
            <p id="pProvince" class="reset"></p>
      </div>   
    </div>  
      
      <div class="row">
      <div class="col-25">
        <label for="Gender">Gender</label>
      </div>
      <div class="col-75">
         <input type="text" id="Gender" name="Gender" placeholder="Your Gender F or M.." required>
          <p id="pGender" class="reset"></p>
      </div>   
    </div>  
      

         

  <div class="row">
      <div class="col-25">
        <label for="tel">Date of Birth</label>
      </div>
      <div class="col-75">
         <input type="text" id="DoB" name="Dob" placeholder="Your Birthday.." required>
          <p id="pDob" class="reset"></p>
      </div>   
    </div>  
    
    <div class="row">
      <div class="col-25">
        <label for="Telephone Number">Telephone Number</label>
      </div>
      <div class="col-75">
         <input type="text" id="phoneNo" name="TelephoneNumber" placeholder="Your Telephone Number.." required>
            <p id="pTNumber" class="reset"></p>
      </div>   
    </div>
      

      
     
      
    <div class="sub">
      <input type="submit" value="Register">
    </div>
  </form>
</div>
    
    
                      
	
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0
			response.setHeader("Expires", "0"); //Proxies
			
			if(session.getAttribute("id") != null)
				response.sendRedirect("home.jsp");
		%>
		
		
	</body>
</html>

