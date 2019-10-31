/**
 * 
 */
function validateLogin(form) {    
    var errors = [];
    
    var alphabeticExpression = /^[A-Za-z]+$/;
    var numericExpression = /^[0-9]+$/;

    if(form.username.value == "")
        errors.push("Please enter the username!");

    if(form.nic.value == "")
    	errors.push("Please enter the NIC!");

    if(form.password.value == "")
        errors.push("Please enter the password!");

    if (form.username.value != "" && !username.value.match(alphabeticExpression))
        errors.push("Please use letters only for your username!");
   
    if (errors.length > 0) {
        var message = "ERRORS: \n\n";

        for(var i = 0; i < errors.length; i++)
            message += errors[i] + "\n";

        alert(message);

        return false;
    }

    return true;
}
