<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Login Page</title>

<style>
.container {
    padding: 50px 0;
}

 

.container form {
    margin: auto;
    max-width: 500px;
    padding: 50px 70px;
    border-radius: 10px;
    box-shadow: 4px 4px 15px rgba(0, 0, 0, 0.2);
    background-color: darksalmon;
}

div {
  position: relative;
  -webkit-animation: mymove 3s;  /* Safari 4.0 - 8.0 */
  -webkit-animation-fill-mode: forwards; /* Safari 4.0 - 8.0 */
  animation: mymove 3s;
  animation-fill-mode: forwards;
}

 

/* Safari 4.0 - 8.0 */
@-webkit-keyframes mymove {
  from {top: 0px;}
  to {top: 200px;}
  
}

 

@keyframes mymove {
  from {top: 200px;}
  to {top: 0px;}
}
</style>
</head>

<body>
<h2 align="center">LOGIN PAGE</h2>
<div class="container">

		<form action="/">
			
			<p>Message : ${error.message}</p>
			<p>Body : ${error.body}</p>
			<p>Time Stamp : ${error.timestamp}</p>
			<p>Http Status : ${error.httpStatus}</p>
			
			<button type="submit" class="btn btn-outline-danger">Back To Login Page</button>
		</form>
	</div>



</head>
<body>

</body>
</html>