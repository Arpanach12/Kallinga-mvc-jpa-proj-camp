<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Display Students</title>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
 <a class="navbar-brand" href="/">Kalinga Classes</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
</nav>

<br>
<form  id="form1" action="/showstudents" method="post" >
    
     <div class="form-group">
      <label for="block">Section : </label>
      
    <select name="classId">
    <option value="TypeNotSelected">---------------Section-----------------</option>
    <c:forEach var="clas" items="${classes}">
    <option value="${clas.classId}">${clas.classSection}</option>
     </c:forEach>
  	</select>
   
    </div>
    
    <button type="submit" class="btn btn-outline-success">Submit</button>
  </form>


<div>
			<h2>ALL STUDENTS</h2>
			<table class="table">
				<thead>
					<tr>
						<th>NAME</th>
						<th>DOB</th>
						<th>AGE</th>
						<th>SECTION</th>
					</tr>
				</thead>
				<c:forEach var="student" items="${students}">

					<tbody>
						<tr>

							<td>${student.studentName}</td>
							<td>${student.studentdDob}</td>
							<td>${student.studentAge}</td>
							<td>${student.studentSection}</td>
						</tr>

					</tbody>

				</c:forEach>
			</table>
		</div>

</body>
</html>