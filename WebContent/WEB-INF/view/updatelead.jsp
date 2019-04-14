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
<form:form action="processupdatelead" modelAttribute="newlead" style="padding:2%">
   <div class="form-group">
    
<label for="names">First Name:</label> <form:input class="form-control" path="names" onkeydown="upperCaseF(this)" required="required"/><br/>
<label for="names2">Last Name:</label> <form:input class="form-control" path="names2" onkeydown="upperCaseF(this)" required="required"/><br/>
<label for="walking_date">Walking date:</label><form:input type="date"  class="form-control" path="walking_date" required="required" /> <br/>
<label for="emailid">Email id:</label> <form:input class="form-control" path="emailid"  required="required"/><br/>
<label for="contact_number">Contact number:</label> <form:input class="form-control" type="tel" path="contact_number" onkeydown="upperCaseF(this)" required="required"/><br/>
<label for="leadsource">Lead Source:</label> <form:input class="form-control" path="leadsource" onkeydown="upperCaseF(this)" required="required"/><br/>

<label for="city">City:</label> <form:input class="form-control" path="city" onkeydown="upperCaseF(this)" required="required"/><br/>
<label for="leadid">Leadid:</label><form:input class="form-control" path="leadid" value="${newlead.leadid}"/><br/>
<label for="agentid">Agentid:</label><form:input class="form-control" path="agentid" value="${newlead.agentid}"/><br/>

<br/>

<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Update Lead</button>
</div>
</form:form>
</div>
<script>
function upperCaseF(a){
    setTimeout(function(){
        a.value = a.value.toUpperCase();
    }, 1);
}
</script>
</body>
</html>