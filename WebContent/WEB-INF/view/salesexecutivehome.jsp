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
 background-repeat:no-repeat;

  background-size:cover;
  
}
</style>
<script type="text/javascript">
function loadFrame (url){
    var frame1 = document.getElementById('frame1');
    frame1.src = url;
}
function resizeIframe(iframeID) 
{       
    var iframe = window.parent.document.getElementById(iframeID);
    var container = document.getElementById('content');
    iframe.style.height = container.offsetHeight + 'px';            
}
</script>
</head>
<body background="<c:url value='/resources/wallpaper3.jpg' />">
<div class="container-fluid" style="background-color:rgb(255, 165, 20,0.8)">
<h1>logo</h1>
</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">CRM systems</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="javascript:loadFrame('salesexReminders')">Home</a></li>
      <li><a href="javascript:loadFrame('salesexMyOpportunities')">Prospective Customers</a></li>
     
      <li><a href="javascript:loadFrame('customer')">My Customers</a></li>
      
      <li><a href="javascript:loadFrame('salesexTasks')">Tasks</a></li>
      
      <li><a href="javascript:loadFrame('salesexMyTasks')">My Tasks</a></li>
      <li><a href="javascript:loadFrame('sendEmail')">Send Email</a></li>
     
	  <li><a href="#">Reports</a></li>
	  	
    </ul>
    <ul class="nav navbar-nav navbar-right">
      
      <li><a href="http://localhost:8080/spring-crm/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<div class="container-fluid">
<div class="col-sm-2"></div><div class="col-sm-8">
<div class="embed-responsive embed-responsive-16by9">
  
 <iframe id="frame1" class="embed-responsive-item" scrolling="yes" frameborder="0"
   allowfullscreen ></iframe></div>
</div></div><div class="col-sm-2"></div>
</body>
</html>