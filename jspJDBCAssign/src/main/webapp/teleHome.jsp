<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Mobile Payment</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/jspJDBCAssign/teleLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<h2 style="text-align:center">Welcome to the Mobile Payment Portal</h2>
<div class="panel panel-default">
<div class="panel-heading col-sm-6" style="text-align:center"> <a href="/jspJDBCAssign/teleBills.jsp" class="btn btn-success" style="width:100px">Bills</a></div>
<div class="panel-heading col-sm-6" style="text-align:center"> <a href="/jspJDBCAssign/telePay.jsp" class="btn btn-success" style="width:100px">Payment</a></div>
</div>
<br><br>
<div style="text-align:center"><h4>
<%
   String info = request.getAttribute("status").toString();
   out.println(info);
 %>
</h4> </div>



</body>
</html>