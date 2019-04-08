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
<form:form action="processAddCustomer" modelAttribute="newcustomer" style="padding:2%">
   <div class="form-group">
    
<label for="fname">First Name:</label> <form:input class="form-control" path="fname" value='${newcustomer.fname}' required="required" /><br/>
<label for="lname">Last Name:</label> <form:input class="form-control" path="lname" value='${newcustomer.lname}' required="required"/><br/>
<label for="signup_date">Signup date:</label><form:input type="date"  class="form-control" path="signupdate" value='${newcustomer.signupdate}' required="required"/> <br/>
<label for="emailid">Email id:</label> <form:input class="form-control" path="emailid" value='${newcustomer.emailid}' required="required"/><br/>
<label for="address1">address line 1:</label> <form:input class="form-control" path="address1" required="required"/><br/>
<label for="address2">address line 2:</label> <form:input class="form-control" path="address2" required="required"/><br/>
<label for="city">City:</label> <form:input class="form-control" path="city"/><br/>
<label for="contact_number">Contact number:</label> <form:input class="form-control" type="tel" path="contact_number" value='${newcustomer.contact_number}' required="required"/><br/>
 <form:input class="form-control" path="salesuserid" type="hidden" value='${newcustomer.salesuserid}'/><br/>
 <form:input class="form-control" path="seuserid" type="hidden" value='${newcustomer.seuserid}'/><br/>
  <form:input class="form-control" path="oppid" type="hidden" value='${newcustomer.oppid}'/><br/>
 <input type="hidden" name="tid" value="${tid}">


<br/>

<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Create Lead</button>
</div>
</form:form>
</div>
</body>
</html>