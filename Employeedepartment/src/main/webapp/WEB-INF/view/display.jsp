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
<form action="displayemployee" id="userform" method="post">
 <div class="form-group">
				<label for="departmentsName" class="control-label col-sm-2">Department:</label>
				<table>
				<tr>
					<td><select name="departmentsName">
							<c:forEach var="str2" items="${deplist12}">
								<option >${str2.departmentName}</option> 
							</c:forEach>
							
				</select>
				</td>
				</tr>
				</table>
				</div>
           
        
            <div class="form-group">
                   
                        <input type="submit">
                     </div>
            </form>
            
            <table border="3" width="70%" cellpadding="2" class="table">
    <tr class="success">
       <th>employeeId</th>
        <th>employee First Name</th> 
        <th>employeeLastName</th>
       
        
    </tr>
    <c:forEach var="emp" items="${employeeslists}">
        <tr class="danger">
        <td>${emp.employeeId}</td>
            <td>${emp.employeeFirstName}</td>
            <td>${emp.employeeLastName}</td>
        </tr>
        </c:forEach>
</table>




 
</body>
</html>