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
<form:form action="processPage" modelAttribute="newpayment" style="padding:2%">
   <div class="form-group">
<label for="paymentMode">Payment Mode:</label> <form:input class="form-control" path="paymentMode"/><br/>
<label for="paymentDate">Payment Date:</label> <form:input type="date" class="form-control" path="paymentDate"/><br/>
<label for="previousPaid">Previous Paid:</label><form:input  class="form-control" path="previousPaid"/> <br/>
<label for="paid">Paid:</label> <form:input class="form-control" path="paid"/><br/>
<label for="balance">Balance:</label> <form:input class="form-control" path="balance"/><br/>
<label for="discount">Discount:</label> <form:input class="form-control" path="discount"/><br/>
<label for="total">Total:</label> <form:input class="form-control" path="total"/><br/>

<button type="submit" class="btn" style="background-color:rgb(0,0,0,0.8); color:white">Create Payment</button>
</div>
</form:form>
</div>
</body>
</html>