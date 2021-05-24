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
<form action="setuserandhospital" id="userform12" method="post">

                <div class="form-group">
				<label for="hospitalName" class="control-label col-sm-2">Hospital:</label>
				<table>
				<tr>
					<td><select name="hospitalName">
							<c:forEach var="str1" items="${hospitalslist}">
								<option >${str1.hospitalName}</option> 
							</c:forEach>
							
				</select>
				</td>
				</tr>
				</table>
				</div>
                <div class="form-group">
                <label for="doctorList" class="control-label col-sm-2">Doctors:</label>
                   <table>  <tr>
					<td><select name="doctorList" multiple="multiple">
							<c:forEach var="pro" items="${doctorslist}">
								<option value="${pro.doctorId}">${pro.doctorName}</option> 
							</c:forEach>
				</select>
				</td>
				</tr>
				</table>
				</div>
				
				
            <div class="form-group">
                   
                        <input type="submit">
                     </div>
            </div>
            
            
        </form>
</body>
</html>