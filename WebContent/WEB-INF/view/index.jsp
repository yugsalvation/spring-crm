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

<body background="<c:url value='/resources/wallpaper4.jpeg' />">
<div class="container-fluid">

  <div class="col-sm-4"></div>
  <div class="col-sm-4">
<div class="page-header">
 
 <h1 style="background-color:rgb(240, 255, 255,0.8);text-align:center;">CRM Systems</h1></div> </div>

  <div class="col-sm-4"></div>
 </div>
 <div class="row">
  <div class="container-fluid" >
   <div class="col-sm-4"></div>
 <div class="col-sm-4">
 <a href="saleslogin"> <h2 style="background-color:rgb(240, 255, 255,0.8);text-align:center;padding:10%;">Sales Employee</h2></a>
</div>


  <div class="col-sm-4"></div>
</div></div>
<br/>
 <div class="row">
  <div class="container-fluid" >
   <div class="col-sm-4"></div>
 <div class="col-sm-4">
  <a href="saleslogin"><h2 style="background-color:rgb(240, 255, 255,0.8);text-align:center;padding:10%">Sales Executive</h2>
</a>
</div>


  <div class="col-sm-4"></div>
</div></div><br/>
 <div class="row">
  <div class="container-fluid" >
   <div class="col-sm-4"></div>
 <div class="col-sm-4">
 <a href="leadagentlogin"> <h2 style="background-color:rgb(240, 255, 255,0.8);text-align:center;padding:10%">Lead Agent</h2>
</a>
</div>


  <div class="col-sm-4"></div>
</div></div>
</body>
</html>