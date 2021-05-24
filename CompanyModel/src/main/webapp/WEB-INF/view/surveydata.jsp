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
<script type="text/javascript">
	function getgrevenue(companyName) {
		window.location.href = '/getallrevenue?companyId='+ companyName;
	}
</script>
<style>
div {
	width: 300px;
	height: 100px;
	background-color: yellow;
	border: 1px solid black;
}

div#myDiv {
	-ms-transform: rotate(20deg); /* IE 9 */
	-webkit-transform: rotate(20deg); /* Safari prior 9.0 */
	transform: rotate(20deg); /* Standard syntax */
}
</style>
</head>
<body>
	<div>
		<form id="form1" action="/showtotalrevenue" methods="post">
			Select Company <select name="companyId" id="companyId"
				class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
				onchange="getgrevenue(this.value)
				size="1">
				<option value="">select the company
					<c:forEach var="companys" items="${companylists}">
						<option value="${companys.companyId}">${companys.companyName}
						</option>
					</c:forEach>
			</select><br> <br>
			<div class="checkbox-inline">
				<label>
					<button type="submit"
						class="btn btn-primary btn-block create-account" id="button">Submit</button>
			</div>
		</form>
	</div>
	<br>
		<br>
		<br>
		<br>
		<br>
	<div id="myDiv">
		<h2>Revenue</h2>
		<h2>${revenue}</h2>
	</div>

</body>
</html>