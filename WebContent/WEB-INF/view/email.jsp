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
<form:form action="processemail" modelAttribute="emails" style="padding:2%">
   <div class="form-group">
 <label for="taskid">Taskid:</label> <form:input class="form-control" path="taskid" type="hidden"/>    
<label for="to">To:</label><form:input  class="form-control" value='${emails.to1}'  path="to1" /> <br/>
<label for="subject">subject:</label><form:input  class="form-control" path="subject"/> <br/>

<label for="message">Message</label><br/><form:textarea rows="20" cols="90" path="message"/><br/><br/>


<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Send email</button>
</div>
</form:form>
</div>
</body>
</html>