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
        <th>Cid</th>
        <th>Name</th>
        <th>Signup date</th>
        <th>Email id</th>
        <th>Contact number</th>
        <th>City</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>

    <c:forEach var="customers" items="${mycustomers}">
   <c:url var="addOrder" value="/addOrder">
    	<c:param name="cid" value="${customers.cid}"></c:param>
    </c:url>
     <c:url var="vieworders" value="/viewOrders">
    	<c:param name="cid" value="${customers.cid}"></c:param></c:url>
    
    <c:url var="uploadFile" value="/uploadFile">
    	<c:param name="cid" value="${customers.cid}"></c:param></c:url>	
    <c:url var="dropopp" value="/dropopportunity">
    	<c:param name="opportunityid" value="${customers.cid}"></c:param>
    </c:url>
    
   
    
      <tr class="active">
        <td>${customers.cid} </td>
        <td>${customers.fname} ${customers.lname}</td>
        <td>${customers.signupdate}</td>
        <td>${customers.emailid}</td>
        <td>${customers.contact_number}</td>
        <td>${customers.city}</td>
     
        <td> <a href="${uploadFile}">uploadFile</a></td>

      	<td> <a href="${addOrder}">add order</a></td>
       
        <td> <a href="${dropopp}" onclick="return myFunction()">drop</a></td>
      	<td><a href="${vieworders}">Order History</a></td>
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