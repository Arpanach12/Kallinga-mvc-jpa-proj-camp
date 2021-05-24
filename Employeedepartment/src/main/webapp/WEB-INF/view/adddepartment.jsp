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
<h1>Department Management System</h1>

	
	
<form action="insertdepartment" id="userform" method="post">
            <div class="form-group">
                <label for="departmentId" class="control-label col-sm-2">Department Id:</label>
                <div class="col-sm-10">
                    <input type="text"
                    class="form-control" id="departmentId" placeholder="Enter Department Id"
                    name="departmentId" required="required"><br><br>
                 </div>
            </div>
            <div class="form-group">
                    <label for="departmentName" class="control-label col-sm-2">Department Name:</label>
                    <div class="col-sm-10">
                        <input type="text"
                        class="form-control" id="departmentName" placeholder="Enter Department Name"
                        name="departmentName" required="required"><br><br>
                     </div>
            </div>
           
            <div class="form-group">
                   
                        <input type="submit">
                     </div>
            </div>
            
            
        </form>
</body>
</html>