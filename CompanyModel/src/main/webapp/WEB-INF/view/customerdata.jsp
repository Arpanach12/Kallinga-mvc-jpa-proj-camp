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
<form action="showcustomer">
		<div class="form-group">
			<label>Select Customer</label> <select name="customerId" id=customerId
				class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
				<option value="">select customer
					<c:forEach var="pro" items="${customerlists}">
						<option value="${pro.customerId}">${pro.customerName}</option>
					</c:forEach>
			</select><br> <br>
		</div>
		<div class="form-group">

			<input type="submit">
		</div>
	</form>
	<table border="3" width="70%" cellpadding="2" class="table">
		<tr class="success">
			
			<th>customer Name</th>
			<th>customer Email</th>
			<th>customer price</th>
			<th>customer gender</th>
			


		</tr>
		
			<tr class="danger">
				<td>${customerlist.customerName}</td>
				<td>${customerlist.customerEmail}</td>
				<td>${customerlist.totalPrice}</td>
				<td>${customerlist.gender}</td>
				
			</tr>
		
	</table>
</body>
</html>