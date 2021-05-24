<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<style>
body {
	background-image:
		url('https://cssauthor.com/wp-content/uploads/2019/05/Oswan-Free-eCommerce-Bike-Store-Template.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	background-size: 100% 100%;
}
</style>
<body>
	<div class="container">
	<c:if test="${errormsg!=null}">
						<p class="ex">${errormsg}</p>
					</c:if>
<form action="adminpage" method="post" id="myform">
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-user"></i></span> <input id="adminId"
				type="text" class="form-control" name="adminId" placeholder="Email">
		</div>
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-lock"></i></span> <input id="adminPassword"
				type="password" class="form-control" name="adminPassword"
				placeholder="Password">
		</div>
		<br>
		<div class="input-group">
			<span class="input-group-addon">Text</span> <input id="msg"
				type="text" class="form-control" name="msg"
				placeholder="Additional Info">
		</div>

		<div class="checkbox-inline">
			<label>
				<button type="submit"
					class="btn btn-primary btn-block create-account" id="button">Submit</button>
		</div>


		<a class="nav-link" href="customerregister">Register</a>


		</form>
	</div>

</body>
</html>







<%-- <form action="adminpage" method="post" id="myform">
			<h2>Login Page</h2>
			<hr />
			<div class="form-group">
				<label for="fname">Email:</label> <input type="text"
					class="form-control item" id="adminId" name="adminId">
			</div>
			<div class="form-group">
				<label for="adminName">Password:</label> <input type="password"
					class="form-control item" id="adminPassword" name="adminPassword">
			</div>
			<div class="checkbox-inline">
				<label>
					<button type="submit"
						class="btn btn-primary btn-block create-account" id="button">Submit</button>
			</div>
			
			
			<a class="nav-link" href="customerregister">Register</a>

		</form>
	</div>
	 --%>