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
<br/>
<br/>
 
<div class="col-sm-2"></div>
<div class="col-sm-8">
<div class=row>
 <h1 style="text-align:center;">Opportunity Report</h1>
<form:form action="getOppReports" class="form-inline">


  <div class="form-group">
    <label for="from">From:</label>
    <input type="date" class="form-control" name="from" required="required">
  </div>
  <div class="form-group">
   <label for="to">To:</label>
    <input type="date" class="form-control" name="to" required="required">
  </div>
  
  <button type="submit" class="btn btn-default">Get Report</button>

</form:form>

  </div>
  <br/>
  <br/>
  <br/>
  <div class=row>
 <h1 style="text-align:center;">Customer Report</h1>
<form:form action="getCustReports" class="form-inline">


  <div class="form-group">
    <label for="from">From:</label>
    <input type="date" class="form-control" name="from" required="required">
  </div>
  <div class="form-group">
   <label for="to">To:</label>
    <input type="date" class="form-control" name="to" required="required">
  </div>
  
  <button type="submit" class="btn btn-default">Get Report</button>

</form:form>

  </div>
  </div>
  </div>
  <div class="col-sm-2"></div>

</div>
</body>
</html>