<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<form action="insertemployee" id="userform" method="post">
            <div class="form-group">
                <label for="employeeId" class="control-label col-sm-2">Employee Id:</label>
                <div class="col-sm-10">
                    <input type="text"
                    class="form-control" id="employeeId" placeholder="Employee Id"
                    name="employeeId" required="required"><br><br>
                 </div>
            </div>
            <div class="form-group">
                    <label for="employeeFirstName" class="control-label col-sm-2">Employee First Name:</label>
                    <div class="col-sm-10">
                        <input type="text"
                        class="form-control" id="employeeFirstName" placeholder="Enter First Name"
                        name="employeeFirstName" required="required"><br><br>
                     </div>
            </div>
            
             <div class="form-group">
                    <label for="employeeLastName" class="control-label col-sm-2">Employee Last Name:</label>
                    <div class="col-sm-10">
                        <input type="text"
                        class="form-control" id="employeeLastName" placeholder="Enter Last Name"
                        name="employeeLastName" required="required"><br><br>
                     </div>
            </div>
             <div class="form-group">
                    <label for="DateOfBirth" class="control-label col-sm-2">Date Of Birth:</label>
                    <div class="col-sm-10">
                        <input type="date"
                        class="form-control" id="DateOfBirth" placeholder="Enter Date Of Birth"
                        name="DateOfBirth" required="required"><br><br>
                     </div>
            </div>
           
            <div class="form-group">
				<label for="departmentsName" class="control-label col-sm-2">Department:</label>
				<table>
				<tr>
					<td><select name="departmentsName">
							<c:forEach var="str1" items="${deplist}">
								<option >${str1.departmentName}</option> 
							</c:forEach>
							
				</select>
				</td>
				</tr>
				</table>
				</div>
           
        
            <div class="form-group">
                   
                        <button type="submit" id="button">Submit</button> 
                     </div>
            
            
            
        </form>
        <script>
            $(document).ready(function(){
                jQuery('#button').click(function(){
                var username=$('#employeeFirstName').val();
                if(username.length<1)
                {
                    alert("username feild cannot empty")
                    return false;
                }
                var userchk=/^[A-Za-z]{12,20}$/;
               
                var validUser=userchk.test(username);
                if(!validUser){
                    alert("Username not valid");
                    return false;
                }
               
            });
        });
            </script>
</body>
</html>