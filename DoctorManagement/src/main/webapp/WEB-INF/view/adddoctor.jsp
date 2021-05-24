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

<form action="insertdoctor" id="userform" method="post">
            <div class="form-group">
                <label for="doctorId" class="control-label col-sm-2">Doctor Id:</label>
                <div class="col-sm-10">
                    <input type="text"
                    class="form-control" id="doctorId" placeholder="Doctor Id"
                    name="doctorId" required="required"><br><br>
                 </div>
            </div>
            <div class="form-group">
                    <label for="doctorName" class="control-label col-sm-2">Doctor Name:</label>
                    <div class="col-sm-10">
                        <input type="text"
                        class="form-control" id="doctorName" placeholder="Enter Doctor Name"
                        name="doctorName" required="required"><br><br>
                     </div>
            </div>
            
             <div class="form-group">
                    <label for="doctorSalary" class="control-label col-sm-2">Doctor Salary:</label>
                    <div class="col-sm-10">
                        <input type="text"
                        class="form-control" id="doctorSalary" placeholder="Enter Doctor Salary"
                        name="doctorSalary" required="required"><br><br>
                     </div>
            </div>
           
            <div class="form-group">
                    <label for="specialist" class="control-label col-sm-2">Select Specialist:</label>
                    <div class="col-sm-10">
                        <select
                        name="specialist">
                    <option value="pediatric">Pediatric
                    <option value="cardialogy">Cardialogy
                    <option value="neurology">Neurology
                    <option value="medicine">Medicine
                    </select><br>
                     </div>
            </div>
           
        
            <div class="form-group">
                   
                        <input type="submit">
                     </div>
            </div>
            
            
        </form>
</body>
</html>