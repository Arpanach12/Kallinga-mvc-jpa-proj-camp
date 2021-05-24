<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	
 <h1>Registration Form</h1>
    <div class="container">
    <c:if test="${errormsg!=null}">
						<p class="ex">${errormsg}</p>
					</c:if>
        <form action="insertcustomer" id="options" method="post" onsubmit="return validate()">
            <div class="form-group">
                <label for="customerName" class="control-label col-sm-2">Customer Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerName" placeholder="Enter Name" name="customerName"
                        required="required">
                </div>

 <div class="form-group">
				<label id="g">Hobbies:
					<div class="form-check">
						<input type="checkbox" class="form-check-input" name="hobby"
							id="Swimming" value="Swimming">Swimming
					</div>

					<div class="form-check">
						<input type="checkbox" class="form-check-input" name="hobby"
							id="reading" value="reading">Reading
					</div>

					<div class="form-check">
						<input type="checkbox" class="form-check-input" name="hobby"
							id="Programming" value="Programming">Programming
					</div>

					<div class="form-check">
						<input type="checkbox" class="form-check-input" name="hobby"
							id="Cooking" value="Cooking">Cooking
					</div>
				</label>
			</div>
 

            </div>
            <div class="form-group">
                <label for="password" class="control-label col-sm-2"> User Password:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" placeholder="Enter Password"
                     name="password"
                        required="required">
                </div>

 

            </div>

 

<div class="form-group">
                <label for="conuserpassword" class="control-label col-sm-2">Confirm Password:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="conuserpassword" placeholder="Enter Password"
                     name="conuserpassword"
                        required="required">
                </div>

 <h5>
				<label>Gender:</label>
			</h5>
			<div class="radio-inline">
				<label> <input type="radio" name="gender" id="gender" value="male">Male
				</label>
			</div>
			<div class="radio-inline">
				<label> <input type="radio" name="gender" id="gender" value="female">Female
				</label>
			</div>

            </div>
            
            <div class="form-group">
                <label for="phone" class="control-label col-sm-2">Customer Phone:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" placeholder="Enter Phone Number" name="phone"
                        required="required">
                </div>
            </div>
            
            <div class="form-group">
                <label for="customerEmail" class="control-label col-sm-2">Customer Email:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerEmail" placeholder="Enter Email" name="customerEmail"
                        required="required">
                </div>
            </div>
            
            <div class="form-group">
                <label for="userRegistration" class="control-label col-sm-2"> User Registration Date :</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="userRegistration" placeholder="Enter userCheckIn"
                        name="userRegistration" required="required">
                </div>
            </div>
    <div>
        <input type="checkbox" name="terms" id="terms" >Agreed Terms & Conditions
    </div>

 

        <div >
            <input type="submit"  value="register">
        </div>

 


    
    </form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"
        integrity="sha256-vb+6VObiUIaoRuSusdLRWtXs/ewuz62LgVXg2f1ZXGo=" crossorigin="anonymous"></script>

 

    <script>
        $.validator.addMethod("datavalida", function (value, element) {
            var curDate = new Date();
            var inputDate = new Date($('#userRegistration').val());
            if (inputDate > curDate) {
                return true;
            } else {
                return false;
            }
        }, "Enter present and future date only...!");
        
        
        $.validator.addMethod("passval", function (value, element) {
            
             var pass_regex=/^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%*&~])[A-Za-z0-9!@~#$%^*]{7,15}$/;
                var conpass=$('#password').val();
                var validPass=pass_regex.test(conpass);
                
                if(!validPass)
                {
                  return false;
                 
                }
            return true;
        }, "Enter the valid password ");
        
        
        $.validator.addMethod("emailval", function (value, element) {
            
            var email_pattern=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            if(!($('#customerEmail').val().match(email_pattern)))
            {
               return false;
            }
            return true;
        }, "Enter the valid email ");
        
        
$.validator.addMethod("confirmpassval", function (value, element) {        
     var conpass=$('#password').val();
     var confpass=$('#conuserpassword').val();
     if(confpass!=conpass)
     {
    return false;
     }
     return true;
     
        }, "password and confirm password is not matched");

 


        $("form").validate({
            rules: {
            	customerName: {
                    required: true,
                    minlength: 10,
                    lettersonly: true
                },
                userPhone: {
                    required: true,
                    number: true,
                    maxlength: 10,
                    minlength:10
                },
                customerEmail:{
                    required: true,
                    emailval:true
                },
                gender:{
                    required:true
                     },
                  hobby:{
                    required:true,
                    minlength:2   
                 },
                terms: {
                    required: true
                },
                userRegistration: {
                    required: true,
                    datavalida: true

 

                },
                password:{
                    required:true,
                    passval:true
                },
                conuserpassword:{
                    required:true,
                    confirmpassval:true
                }

 

            }
        })
    </script>
    
</body>
</html>