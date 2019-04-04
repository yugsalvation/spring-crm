<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body{
 
  background-color:rgb(240,255,240,0.8)
}
</style>
</head>
<body >
<div class="container-fluid">
<form:form action="javascript:history.go(-1)" modelAttribute="customer" style="padding:2%">
   <div class="form-group">
 
<label for="cid">Cid:</label> <form:input class="form-control" path="cid" readonly="true"/> <br/>
<label for="fname">First Name:</label> <form:input class="form-control" path="fname" readonly="true"/> <br/>
<label for="lname">Last Name:</label> <form:input class="form-control" path="lname" readonly="true"/> <br/>
<label for="signupdate">Sign up Date:</label> <form:input class="form-control" path="signupdate" readonly="true"/><br/>
<label for="emailid">Emailid:</label> <form:input class="form-control" path="emailid" readonly="true"/> <br/>
<label for="contact_number">Contact Number:</label> <form:input class="form-control" path="contact_number" readonly="true"/> <br/>
<label for="city">City:</label> <form:input class="form-control" path="city" readonly="true"/><br/>
<br/>

<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Done</button>
</div>
</form:form>



  </div>
	
</body>
</html>