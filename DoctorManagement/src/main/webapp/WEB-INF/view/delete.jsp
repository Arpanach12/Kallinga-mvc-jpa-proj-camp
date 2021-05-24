<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="deletedoctor" id="userform" method="post">
            <div class="form-group">
                <label for="hospitalName" class="control-label col-sm-2">Hospital Name:</label>
                <div class="col-sm-10">
                    <input type="text"
                    class="form-control" id="hospitalName" placeholder="Hospital Name"
                    name="hospitalName" required="required"><br><br>
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
                   
                        <input type="submit">
                     </div>
            </div>
            </form>
</body>
</html>