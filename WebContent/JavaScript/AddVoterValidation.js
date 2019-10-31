/**
 * 
 */
function validateAddVoter(form) {    
    var errors = [];
    var alphabeticExpression = /^[A-Za-z]+$/;
    var numericExpression = /^[0-9]+$/;
    var val = /^[a-zA-Z._%]+@[a-zA-Z]+.[a-zA-Z]{2-}$/gm;
    
    if(form.username.value == "")
        errors.push("Please enter the username!");

    if(form.nic.value == "")
        errors.push("Please enter the NIC!");

    if(form.password.value == "")
        errors.push("Please enter the password!");

    if(form.email.value == "")
        errors.push("Please enter the email!");

    if(form.fname.value == "")
        errors.push("Please enter the first name!");
    
    if(form.lname.value == "")
        errors.push("Please enter the last name!");
    
    if(form.address.value == "")
        errors.push("Please enter the address!");

    if(form.district.value == "")
        errors.push("Please enter the district!");

    if(form.province.value == "")
        errors.push("Please enter the province!");
    
    if(form.DoB.value == "")
        errors.push("Please enter the date of birth!");
    
    if(form.phoneNo.value == "")
        errors.push("Please enter the phone number!");

    if(form.username.value != "" && !username.value.match(alphabeticExpression))
        errors.push("Please use letters only for your username!");

    if(form.fname.value != "" && !fname.value.match(alphabeticExpression))
        errors.push("Please use letters only for your first name!");
    
    if(form.lname.value != "" && !lname.value.match(alphabeticExpression))
        errors.push("Please use letters only for your last name!");
    
    if(form.district.value != "" && !district.value.match(alphabeticExpression))
        errors.push("Please use letters only for your district!");
    
    if(form.province.value != "" && !province.value.match(alphabeticExpression))
        errors.push("Please use letters only for your province!");

    if(form.phoneNo.value != "" && !phoneNo.value.match(numericExpression))
        errors.push("Please use numbers only for the phone number!");

    if(form.email.value != "" && !email.value.match(val))
        errors.push("Please enter a valid e-mail address!");
   
    if(form.password.value != "" && password.length < 8)
        errors.push("Please enter a password with at least 8 characters!");
    
    if (errors.length > 0) {
        var message = "ERRORS: \n\n";

        for (var i = 0; i < errors.length; i++)
            message += errors[i] + "\n";

        alert(message);

        return false;
    }

    return true;
}
