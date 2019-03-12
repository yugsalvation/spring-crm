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
<form:form action="processPage" modelAttribute="newcustomer" style="padding:2%">
   <div class="form-group">
<label for="fname">First Name:</label> <form:input class="form-control" path="fname"/><br/>
<label for="lname">Last Name:</label> <form:input class="form-control" path="lname"/><br/>
<label for="signupdate">Sign Up Date:</label><form:input type="date" class="form-control" path="signUpDate"/> <br/>
<label for="phone">Phone Number:</label> <form:input class="form-control" path="phone"/><br/>
<label for="address">Address:</label> <form:input class="form-control" path="address"/><br/>
<label for="branch">Branch:</label> <form:input class="form-control" path="branch"/><br/>
<label for="customeragent">Customer Agent:</label> <form:input class="form-control" path="customerAgent"/><br/>
<label for="offercode">Name:</label> <form:input class="form-control" path="offerCode"/><br/>
<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Create Customer</button>
</div>
</form:form>
</div>
</body>
</html>