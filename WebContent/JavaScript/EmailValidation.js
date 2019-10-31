/**
 * 
 */
function validateEmail() {
	var email  = document.getElementById("email");
	var pEmail = document.getElementById("pEmail");
	
	var val = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	   if(!email.value.match(val)) {
		   pEmail.innerHTML = "*Please enter a valid email address*";
		   email.focus();
		   
		   return false;
	   }
	   else {
		   pEmail.innerHTML = "";
	   }
}
