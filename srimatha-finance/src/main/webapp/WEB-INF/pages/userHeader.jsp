<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="header" style="position:absolute; top:0px; left:0px; height:200px; right:0px;overflow:hidden;"> 
    
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/uhome">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/payment">Payment</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="${pageContext.request.contextPath}/userHistory">Loans History</a></li>
    
      <li><a href="${pageContext.request.contextPath}/loanRegistration"><span class="glyphicon glyphicon-user"></span> Loan Form</a></li>
    
      <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
       
    </ul>
  </div>
  </div> 
</nav>
</html>