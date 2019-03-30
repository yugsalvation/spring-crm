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
<form:form action="processupdateopportunity" modelAttribute="newopportunity" style="padding:2%">
   <div class="form-group">
 
<label for="names">First Name:</label> <form:input class="form-control" path="names" readonly="true"/> 
<label for="names2">Last Name:</label> <form:input class="form-control" path="names2" readonly="true"/> 
<label for="opportunityid">oid:</label> <form:input class="form-control" path="opportunityid" readonly="true"/> <br/>
<label for="description">

Description</label><br/><form:textarea rows="20" cols="90" path="description"/><br/>

<br/>

<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Done</button>
 <c:url var="back" value="/salesexMyOpportunities">
    	
    </c:url>
&emsp; <a href="${back}" class="btn" role="button" style="background-color:rgb(0,0,0,0.8); color:white">Back</a>



</div>
</form:form>
</div>
</body>
</html>