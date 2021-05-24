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
<form action="inserthospital" id="userform" method="post">
            <div class="form-group">
                <label for="hospitalId" class="control-label col-sm-2">Hospital Id:</label>
                <div class="col-sm-10">
                    <input type="text"
                    class="form-control" id="hospitalId" placeholder="Enter Id"
                    name="hospitalId" required="required"><br><br>
                 </div>
            </div>
            <div class="form-group">
                    <label for="hospitalName" class="control-label col-sm-2">Hospital Name:</label>
                    <div class="col-sm-10">
                        <input type="text"
                        class="form-control" id="hospitalName" placeholder="Enter Number"
                        name="hospitalName" required="required"><br><br>
                     </div>
            </div>
            <div class="form-group">
                    <label for="hospitalLocation"  class="control-label col-sm-2">Hospital Location:</label>
                    <div class="col-sm-10">
                        <input type="text"
                        class="form-control" id="hospitalLocation" placeholder="Enter Hospital Location"
                        name="hospitalLocation" required="required"><br><br>
                     </div>
            </div>
           
            <div class="form-group">
                   
                        <input type="submit">
                     </div>
            
            
            
        </form>
</body>
</html>