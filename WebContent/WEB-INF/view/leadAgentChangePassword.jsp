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
<div class="col-sm-4"></div>
<div class="col-sm-4">
<div class="container-fluid" style="margin-top:35%">
<form:form action="processLeadAgentChangePassword" method="POST">
  <div class="form-group">
    <label for="old">old password:</label>
    <input type="password" class="form-control" name="old">
  </div>
   <div class="form-group">
    <label for="new">new password:</label>
    <input type="password" class="form-control" name="new">
  </div>
  
  <div class="form-group">
    <label for="renew">re-enter new password:</label>
    <input type="password" class="form-control" name="renew">
  </div>
  <div class="row" align="center">
  <p style="color:red">${message}</p>
  <button type="submit" class="btn btn-default">Submit</button></div>
</form:form>

  </div>
</div>
<div class="col-sm-4"></div>

</body>
</html>