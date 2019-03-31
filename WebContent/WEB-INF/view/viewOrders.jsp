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
<table class="table" style="margin-top:15%" >
    <thead>
      <tr class="active">
        <th>Order Id</th>
        <th>Product ID</th>
        <th>Billing date</th>
        <th>Due Date</th>
        <th>Payment Status</th>
      </tr>
    </thead>
    <tbody>

   
   
    <c:forEach var="orders" items="${orders}">
      <tr class="active">
        <td>${orders.idorder} </td>
        <td>${orders.pid}</td>
        <td>${orders.billdate}</td>
        <td>${orders.duedate}</td>
      	<td>${orders.payment}</td>
        
        

      </tr>
     </c:forEach>
    </tbody>
  </table>
  <br/>

  </div>
	<script>
function myFunction() {
  var txt;
  if (confirm("are you sure to drop opportunity?!")) {
  
  } else {
	return false;
  }
  
 

}

</script>
</body>
</html>