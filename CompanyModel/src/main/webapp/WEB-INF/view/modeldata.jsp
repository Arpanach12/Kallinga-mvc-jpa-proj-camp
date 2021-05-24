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
<div>
<form id="form1" action="/showcustomerofmodel" methods="post">
			Select Company <select name="companyId" id="companyId"
				class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
				size="1">
				<option value="">select the company
					<c:forEach var="companys" items="${companylists}">
						<option value="${companys.companyId}">${companys.companyName}

						</option>
					</c:forEach>
			</select><br> <br> Select Model <select name="companymodelName"
				id="companymodelName" class="btn btn-primary dropdown-toggle" 
				data-toggle="dropdown" size="1">

			</select><br> <br> 
			<div class="checkbox-inline">
				<label>
					<button type="submit"
						class="btn btn-primary btn-block create-account" id="button">Submit</button>
			</div>
		</form>
	</div>
	<table border="3" width="70%" cellpadding="2" class="table">
		<tr class="success">
			
			<th>customer Name</th>
			<th>customer Email</th>
			<th>customer price</th>
			<th>customer gender</th>

		</tr>
		<c:forEach var="passenger" items="${customerlists}">
			<tr class="danger">
				<td>${passenger.customerName}</td>
				<td>${passenger.customerEmail}</td>
				<td>${passenger.totalPrice}</td>
				<td>${passenger.gender}</td>
			</tr>
		</c:forEach>
		
	</table>
	<script>
    /* <script type="text/javascipt"> */
    $(document).ready(function(){
    	
    $('#companyId').change(function()
    		{
   		 debugger;
    	 var companyId= $(this).val();
    	 $.ajax({
		    		type: 'GET',
		    	    url: window.location.origin+'/rest/loadModelByCompany/'+companyId,
		        		
		    		success:function(result)
		    		{
		    			var s='';
		    			s+='<option>Select Model</option>'
		   			    for(var i=0;i<result.length;i++)
		   			    {
		   					 s+='<option value="' + result[i].companymodelId +'">' +result[i].companymodelName +'</option>'
		       	   	    }
		    			console.log(companyId)
		   			    $('#companymodelName').html(s);
		    		}
    		  });
    });
   });
    </script>
</body>
</html>