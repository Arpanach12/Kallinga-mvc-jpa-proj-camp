<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
<title>Login Page</title>

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
</head>

<body>
<h2 align="center">LOGIN PAGE</h2>
<div class="container">
		<form action="/validateuser">
			<div class="form-group">
				<label for="personName">Name :</label> <input type="text"
					class="form-control" placeholder="Enter Name" id="personName"
					name="personName">
			</div>

			<div class="form-group">
				<label for="password">Password :</label> <input type="password"
					class="form-control" placeholder="Enter Password"
					id="personPassword" name="personPassword">
			</div>

			<button type="submit" class="btn btn-outline-success">Login</button>
			<br>
			<br>
			
		</form>
		<div align="center">
		<button type="button" class="btn btn-outline-danger" onclick="location.href='/registeruser'">Register</button>
		</div>
	</div>

<body>

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