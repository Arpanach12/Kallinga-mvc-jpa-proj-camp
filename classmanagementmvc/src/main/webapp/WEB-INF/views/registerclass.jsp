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
<title>Add Class</title>
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
		<form action="/insertclass" method="post">
			<div class="form-group">
				<label for="section">Section :</label> <input type="text"
					class="form-control" placeholder="Enter Section" id="classSection"
					name="classSection">
			</div>

			<div class="form-group">
				<label for="teacherName">Teacher Name :</label> <input type="text"
					class="form-control" placeholder="Enter Teacher Name"
					id="teacherName" name="teacherName">
			</div>

			<div class="form-group">
				<label for="noOfStudents">No. of Students :</label> <input
					type="text" class="form-control"
					placeholder="Enter No. of Students" id="noOfStudents"
					name="noOfStudents">
			</div>

			<button type="submit" class="btn btn-outline-success">Submit</button>
			<button type="submit" class="btn btn-outline-danger">Reset</button>
		</form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('form').validate({
				rules : {
					classSection : {
						required : true,
						lettersonly : true,
						minlength : 1,
						maxlength : 1
					},

					teacherName : {
						required : true,
						lettersonly : true
					},
					noOfStudents : {
						required : true,
						digits : true
					}
				}

			});

		});
	</script>

</body>
</html>