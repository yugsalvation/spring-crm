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
<form:form action="processUploadFile" enctype="multipart/form-data">
  <div class="form-group">
    <label for="cid">Customer Id::</label>
    <input type="text" class="form-control" name="cid" value="${cid}">
  </div>
  <div class="form-group">
    <label for="customeridproof">ID proof:</label>
    <input type="file" class="form-control" name="idproof">
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form:form>

  </div>

</body>
</html>