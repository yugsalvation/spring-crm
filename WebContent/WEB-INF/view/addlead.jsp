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
<form:form action="processlead" modelAttribute="newlead" style="padding:2%">
   <div class="form-group">
    
<label for="names">Name:</label> <form:input class="form-control" path="names"/><br/>
<label for="walking_date">Walking date:</label><form:input type="date"  class="form-control" path="walking_date" /> <br/>
<label for="emailid">Email id:</label> <form:input class="form-control" path="emailid"/><br/>
<label for="contact_number">Contact number:</label> <form:input class="form-control" type="tel" path="contact_number"/><br/>
<label for="leadsource">Lead Source:</label> <form:input class="form-control" path="leadsource"/><br/>
<label for="agentid">Lead Agent:</label> <form:input class="form-control" value= "${id}" path="agentid" readonly="true"/><br/>
<label for="city">City:</label> <form:input class="form-control" path="city"/><br/>



<br/>

<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Create Lead</button>
</div>
</form:form>
</div>
</body>
</html>