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

<script type="text/javascript" src="<c:url value='/resources/jspdf.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/from_html.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/jspdf.debug.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/jquery.table2excel.js'/>"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
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
 <h1 style="text-align:center;">MY REMINDERS</h1>
 <table class="table" style="margin-top:3%" >
    <thead>
      <tr class="active">
        <th>Opportunity id</th>
        <th>Fname</th>
         <th>Lname</th>
        <th>DOC</th>
     
        <th>DOM</th>
        <th>TOM</th>
        <th></th>
        <th></th>
       	
      </tr>
    </thead>
    <tbody>

    <c:forEach var="reminders" items="${reminders}">
    <c:url var="send" value="/addCustomer">
    	<c:param name="oppid" value="${reminders.oid}"></c:param>
    	<c:param name="taskid" value="${reminders.idtasks}">
    	</c:param>
    	
    </c:url>
      <c:url var="drop" value="/dropRemindersalesexTasks">
    	<c:param name="taskid" value="${tasks.idtasks}"></c:param>
    </c:url>

    
      <tr class="active">
      	<td>${reminders.oid}</td>
        <td>${reminders.names} </td>
        <td>${reminders.names2} </td>
        <td>${reminders.doc}</td>
    
        <td>${reminders.dom}</td>
        <td>${reminders.tom}</td>
      
        
        
        <td>
        <a href="${send}">Add Customer</a>
        </td>
         <td> <a href="${drop}" onclick="return myFunction()">Drop</a></td>
      
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <br/>

  </div>
<script>
function myFunction() {
  var txt;
  if (confirm("are you sure to drop Task?!")) {
  
  } else {
	return false;
  }

}
</script>
</body>
</html>