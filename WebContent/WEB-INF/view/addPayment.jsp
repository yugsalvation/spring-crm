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
<form:form action="processAddPayment" modelAttribute="order" style="padding:2%">
   <div class="form-group">
<label for="idorder">Order Id:</label><form:input  class="form-control" path="idorder" value="idorder" readonly="true"/> <br/>
<label for="custoid">Customerid:</label><form:input  class="form-control" path="custoid" value="custoid" readonly="true"/> <br/>
<label for="pid">Product:</label><form:input  class="form-control" path="pid" value="pid" readonly="true"/>
<br/>

<label for="billdate">Bill Date:</label><form:input type="date"  class="form-control" path="billdate" value="billdate" readonly="true"/> <br/>
<label for="duedate">Due Date:</label><form:input type="date"  class="form-control" path="duedate" value="duedate" readonly="true" /> <br/>
<label for="amount">Amount:</label><form:input  class="form-control" path="amount" value="amount" readonly="true"/> <br/>
<label for="referencenumber">Reference Number:</label><form:input  class="form-control" path="referencenumber" value="referencenumber" readonly="true"/> <br/>
<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Add Order</button>
</div>
</form:form>
</div>
</body>
</html>