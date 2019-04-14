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
<form:form action="processaddtask" modelAttribute="tasks" style="padding:2%">
   <div class="form-group">
    
<label for="names">Fname:</label><form:input  class="form-control" path="names" value="${opp.names}" readonly="true"/> <br/>
<label for="names">Lname:</label><form:input  class="form-control" path="names2" value="${opp.names2}" readonly="true"/> <br/>
<label for="oid">OID:</label><form:input  class="form-control" path="oid" value="${opp.opportunityid}" readonly="true"/> <br/>

<label for="seuser">Sales Executive id:</label> <form:input class="form-control" value="${id}" path="seuser" readonly="true"/><br/>
<label for="dom">Date of Meeting:</label><form:input type="date"  class="form-control" path="dom" /> <br/>
<label for="tom">Time of Meeting:</label><form:input type="time"  class="form-control"  path="tom"/> <br/>
<label for="dor">Date of Reminder:</label><form:input type="date"  class="form-control" path="dor" /> <br/>
<label for="description">Description</label><br/> <form:textarea rows="20" cols="90" path="description"/><br/>

<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Create Task</button>
</div>
</form:form>
</div>
</body>
</html>