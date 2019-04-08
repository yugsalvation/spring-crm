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
 background-repeat:no-repeat;

  background-size:cover;
  
}
</style>
</head>

<body background="<c:url value='/resources/wallpaper2.jpg' />">
<div class="container-fluid">

  <div class="col-sm-4"></div>
  <div class="col-sm-4">
<div class="page-header">
 
 <h1 style="background-color:rgb(240, 255, 255,0.8);text-align:center;">CRM Systems</h1></div> </div>

  <div class="col-sm-4"></div>
 </div>
  <div class="container-fluid" >
   <div class="col-sm-4"></div>
 <div class="col-sm-4">
 
<form:form action="SalesExecutivePage" modelAttribute="salesexeuser" style="background-color:rgb(220,220,220,0.8);padding:10%;">
   <div class="form-group">
<label for="username">username:</label> <form:input class="form-control" path="username"/><br/>
<label for="password">password:</label><form:input type="password" class="form-control" path="password"/> <br/>
<div class="row" align="center">
<p style="color:red">${message}</p>
<button type="submit" class="btn">submit</button>
<button type="button" onclick="window.location.href='salesexForgotPassword'" class="btn">Forgot Password</button>

</div>

</div>
</form:form>

</div>


  <div class="col-sm-4"></div>
</div>
</body>
</html>