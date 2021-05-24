<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript">
	function getground(companymodelName) {
		window.location.href = '/getthemodelprice?companymodelName='+ companymodelName;
	}
</script>
</head>
<body>
<div class="container">

		<h2 align="center">CAR FORM</h2>
		<form id="form1" action="/purchasebike" methods="post">
			Select Company <select name="companyId" id="companyId"
				class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
				size="1">
				<option value="">select the company
					<c:forEach var="companys" items="${companylists}">
						<option value="${companys.companyId}">${companys.companyName}

						</option>
					</c:forEach>
			</select><br> <br> Select Model <select name="
"
				id="companymodelName" class="btn btn-primary dropdown-toggle" 
				data-toggle="dropdown" size="1">

			</select><br> <br> 
			<div class="form-group">
				<label for="modelPrice">Model Price:</label> <input type="text"
					class="form-control item" id="modelPrice" name="modelPrice" value="modelPrice">
			</div>
			<div class="form-group">
				<label for="quantity">Quantity:</label> <input type="text"
					class="form-control item" id="quantity" name="quantity" >
			</div>
			
			<div class="form-group">
				<label for="totalPrice">Total Price:</label> <input type="text"
					class="form-control item" id="totalPrice" name="totalPrice">
			</div>
			
			<div class="form-group">
				<label for="orderdate">Order Date:</label> <input type="date"
					class="form-control item" id="orderdate" name="orderdate" >
			</div>
			
			<div class="form-group">
				<label for="deliverydate">Delivery Date:</label> <input type="date"
					class="form-control item" id="deliverydate" name="deliverydate" >
			</div>
			<div class="checkbox-inline">
				<label>
					<button type="submit"
						class="btn btn-primary btn-block create-account" id="button">Submit</button>
			</div>
		</form>
	</div>
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
		    			//here we are taking #companymodelName that is int id
		    			console.log(companyId)
		   			    $('#companymodelName').html(s);
		    		}
    		  });
    });
   });
    </script>
    
    <script>
    /* <script type="text/javascipt"> */
    $(document).ready(function(){
    	
    $('#companymodelName').change(function()
    		{
   		 debugger;
    	 var modelId= $(this).val();
    	 $.ajax({
		    		type: 'GET',
		    	    url: window.location.origin+'/rest/loadprice/'+modelId,
		        		
		    		success:function(result)
		    		{
		    			
		   			    $('#modelPrice').val(result);
		    		}
    		  });
    });
   });
    </script>
    
     <script>
    /* <script type="text/javascipt"> */
    $(document).ready(function(){
    	
    $('#quantity').change(function()
    		{
   		 debugger;
    	 var customerQuantitiesPurchased= $(this).val();
    	 $.ajax({
		    		type: 'GET',
		    	    url: window.location.origin+'/rest/loadtotalprice/'+customerQuantitiesPurchased,
		        		
		    		success:function(result)
		    		{
		    			
		   			    $('#totalPrice').val(result);
		    		}
    		  });
    });
   });
    </script>
    
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"
        integrity="sha256-vb+6VObiUIaoRuSusdLRWtXs/ewuz62LgVXg2f1ZXGo=" crossorigin="anonymous"></script>
<script>
$.validator.addMethod("datavalidation", function (value, element) {
    
    var inputDate1 = new Date($('#orderdate').val());
    var inputDate2=  new Date($('#deliverydate').val());
    if (inputDate1 < inputDate2) {
        return true;
    } else {
        return false;
    }
}, "Enter deliver date should be greater than present...!");

$("form").validate({
    rules: {
    	orderdate: {
            required: true,
            datavalidation: true
        },
        deliverydate: {
            required: true,
            datavalidation: true
        }



    }
})

</script>
</body>
</html>