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
  <h1 style="text-align:center;">LEADS</h1>
 <table class="table" style="margin-top:3%" >
    <thead>
      <tr class="active">
        <th>Lead id</th>
        <th>Name</th>
        <th>Walking date</th>
        <th>Email id</th>
        <th>Contact number</th>
        <th>City</th>
        <th>Lead agent</th>
        <th></th>
      </tr>
    </thead>
    <tbody>

    <c:forEach var="lead" items="${salesleads}">
    <c:url var="takeopp" value="/salesTakeOpportunity">
    	<c:param name="leadid" value="${lead.leadid}"></c:param>
    </c:url>
      <tr class="active">
        <td>${lead.leadid} </td>
        <td>${lead.names} ${lead.names2}</td>
        <td>${lead.walking_date}</td>
        <td>${lead.emailid}</td>
        <td>${lead.contact_number}</td>
        <td>${lead.city}</td>
        <td>${lead.agentid}</td>
        <td>
        <a href="${takeopp}">Take Opportunity</a>
        </td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <br/>

  </div>

</body>
</html>