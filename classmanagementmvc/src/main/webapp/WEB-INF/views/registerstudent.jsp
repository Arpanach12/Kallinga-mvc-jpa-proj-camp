<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Add Student</title>
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
</style>
</head>



<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/">Kalinga Classes</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<div class="container">
		<form action="/insertstudent" method="post"
			onsubmit="return checkDOB()">
			<h2>${error.message}</h2>
			<div class="form-group">
				<label for="studentName">Name :</label> <input type="text"
					class="form-control" placeholder="Enter Student Name"
					id="studentName" name="studentName">
			</div>

			<div class="form-group">
				<label for="studentdDob">Date Of Birth :</label> <input type="date"
					class="form-control" placeholder="Enter DOB " id="studentdDob"
					name="studentdDob">
			</div>

			<div class="form-group">
				<label for="studentAge">Age :</label> <input type="text"
					class="form-control" placeholder="Enter age" id="studentAge"
					name="studentAge">
			</div>

			<div class="form-group">
				<label for="block">Assign Section : </label> <select name="classId">
					<option value="TypeNotSelected">---------------Section-----------------</option>
					<c:forEach var="clas" items="${classes}">
						<option value="${clas.classId}">${clas.classSection}</option>
					</c:forEach>
				</select>

			</div>

			<button type="submit" class="btn btn-outline-success">Submit</button>
			<button type="reset" class="btn btn-outline-danger">Reset</button>
		</form>
	</div>





	<script type="text/javascript">
		/* function checkDOB() {
			var dateString = document.getElementById('studentdDob').value;
			var myDate = new Date(dateString);
			var today = new Date();
			if (myDate > today) {
				$('#studentdDob').after(
						'<p>Entered date is more than the current date!.</p>');
				return false;
			}
			return true;
		} */

		$.validator.addMethod("alphabetsnspace", function(value, element) {

			return this.optional(element) || /^[a-zA-Z ]*$/.test(value);
		});

		$.validator.addMethod("datavalid", function(value, element) {

			var curDate = new Date();
			var inputDate = new Date($('#studentdDob').val());
			if (inputDate < curDate) {
				return true;
			} else {
				return false;
			}

		}, "Enter past date");

		$(document).ready(function() {
			$('form').validate({
				rules : {
					studentName : {
						required : true,
						alphabetsnspace : true,
					},

					studentAge : {
						required : true,
						digits : true,
						range : [ 18, 99 ]
					},

					studentdDob : {
						required : true,
						datavalid : true
					}
				},

				messages : {

					"studentName" : {
						required : "Please enter the user name",
						alphabetsnspace : "Please enter only letters"
					}
				}

			});

		});
	</script>

</body>
</html>