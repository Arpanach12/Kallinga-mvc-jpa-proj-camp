<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"
	integrity="sha256-vb+6VObiUIaoRuSusdLRWtXs/ewuz62LgVXg2f1ZXGo="
	crossorigin="anonymous"></script>

<style>
.container {
    padding: 50px 0;
}

 

.container form {
    margin: auto;
    max-width: 500px;
    padding: 50px 70px;
    border-radius: 10px;
    box-shadow: 4px 4px 15px rgba(0, 0, 0, 0.2);
    background-color: darksalmon;
}

div {
  position: relative;
  -webkit-animation: mymove 3s;  /* Safari 4.0 - 8.0 */
  -webkit-animation-fill-mode: forwards; /* Safari 4.0 - 8.0 */
  animation: mymove 3s;
  animation-fill-mode: forwards;
}

 

/* Safari 4.0 - 8.0 */
@-webkit-keyframes mymove {
  from {top: 0px;}
  to {top: 200px;}
  
}

 

@keyframes mymove {
  from {top: 200px;}
  to {top: 0px;}
}
</style>
<title>Register User</title>
</head>
<body>


<h2 align="center" > REGISTER USER</h2>
<div class="container">
		<form action="/insertuser" method="post">
			
			<div class="form-group">
				<label for="personName">Name :</label> <input type="text"
					class="form-control" placeholder="Enter User  Name"
					id="personName" name="personName">
			</div>

			<div class="form-group">
				<label for="personAge">Age :</label> <input type="text"
					class="form-control" placeholder="Enter age" id="personAge"
					name="personAge">
			</div>
			
			<div class="form-group">
				<label for="password">Password :</label> <input type="password"
					class="form-control" placeholder="Enter Password"
					id="personPassword" name="personPassword">
			</div>

			<div class="form-group">
				<label for="roles">Assign Role : </label> <select name="personRole">
					<option value="TypeNotSelected">---------------Role-----------------</option>
					
						<option value="ADMIN">ADMIN</option>
						<option value="USER">USER</option>
					
				</select>

			</div>

			<button type="submit" class="btn btn-outline-success">Submit</button>
			<button type="reset" class="btn btn-outline-danger">Reset</button>
		</form>
	</div>
	
<script type="text/javascript">
$.validator.addMethod("alphabetsnspace", function(value, element) {

			return this.optional(element) || /^[a-zA-Z ]*$/.test(value);
		});


		$(document).ready(function() {
			$('form').validate({
				rules : {
					personName : {
						required : true,
						alphabetsnspace : true,
					},

					personAge : {
						required : true,
						digits : true,
						range : [ 18, 99 ]
					}

				},

				messages : {

					"personName" : {
						required : "Please enter the user name",
						alphabetsnspace : "Please enter only letters"
					}
				}

			});

		});
</script>
</body>
</html>