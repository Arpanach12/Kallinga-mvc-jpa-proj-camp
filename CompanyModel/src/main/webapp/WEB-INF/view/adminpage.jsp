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
  <style>
/* unvisited link */
a:link {
  color: green;
}

/* visited link */
a:visited {
  color: green;
}

/* mouse over link */
a:hover {
  color: blue;
}

/* selected link */
a:active {
  color: yellow;
} 
</style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		
	</nav>
	<div class="container">
		<h1>Logged in</h1>                           <a href="login" class="pull-right">logout</a>

		<table class="table table-hover">
			
			<tbody>
				<tr>
					<th>2.</th>
					<th><a class="nav-link" href="buybike">Buy A Bike</a></th>
				</tr>
			</tbody>
			
			<tbody>
				<tr>
					<th>2.</th>
					<th><a class="nav-link" href="customerdata">Customer Data</a></th>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<th>2.</th>
					<th><a class="nav-link" href="modeldata">Model Data</a></th>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<th>2.</th>
					<th><a class="nav-link" href="surveydata">Survey Data</a></th>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>