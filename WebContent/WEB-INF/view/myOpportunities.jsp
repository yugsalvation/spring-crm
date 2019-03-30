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
 <table class="table" style="margin-top:15%" >
    <thead>
      <tr class="active">
        <th>oid</th>
        <th>Name</th>
        <th>Walking date</th>
        <th>Email id</th>
        <th>Contact number</th>
        <th>City</th>
        <th>Description</th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>

    <c:forEach var="opp" items="${myopp}">
    <c:url var="takeopp" value="/updateopportunity">
    	<c:param name="opportunityid" value="${opp.opportunityid}"></c:param>
    </c:url>
    <c:url var="dropopp" value="/dropopportunity">
    	<c:param name="opportunityid" value="${opp.opportunityid}"></c:param>
    </c:url>
    
      <c:url var="sendopp" value="/sendopportunity">
    	<c:param name="opportunityid" value="${opp.opportunityid}"></c:param>
    </c:url>
    
      <tr class="active">
        <td>${opp.opportunityid} </td>
        <td>${opp.names} ${opp.names2}</td>
        <td>${opp.walking_date}</td>
        <td>${opp.emailid}</td>
        <td>${opp.contact_number}</td>
        <td>${opp.city}</td>
        
        
        <td>
        <a href="${takeopp}">Add/View</a>
        </td>
        <td> <a href="${dropopp}" onclick="return myFunction()">drop</a></td>
      	<td><a href="${sendopp}">Send</a></td>
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