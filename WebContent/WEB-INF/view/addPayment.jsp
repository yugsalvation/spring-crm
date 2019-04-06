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
<label for="idorder">Order Id:</label><form:input  class="form-control" path="idorder" value="${order.idorder}" readonly="true"/> <br/>
<label for="custoid">Customerid:</label><form:input  class="form-control" path="custoid" value="${order.custoid}" readonly="true"/> <br/>
<label for="pid">Product:</label><form:input  class="form-control" path="pid" value="pid" readonly="true"/>
<br/>

<label for="billdate">Bill Date:</label><form:input  class="form-control" path="billdate" value="${order.billdate}" readonly="true"/> <br/>
<label for="duedate">Due Date:</label><form:input   class="form-control" path="duedate" value="${order.duedate}" readonly="true" /> <br/>
<label for="amount">Amount:</label><form:input  class="form-control" path="amount" value="${order.amount}"/> <br/>
<label for="referencenumber">Reference Number:</label><form:input  class="form-control" path="referencenumber"/> <br/>
<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Add Payment</button>
</div>
</form:form>
</div>
</body>
</html>