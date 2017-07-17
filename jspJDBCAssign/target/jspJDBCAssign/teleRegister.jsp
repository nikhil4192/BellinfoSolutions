<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
crossorigin="anonymous">

</head>
<body>
 
<div class="container">
<div class="panel panel-default">
<div class="panel-heading">Registration Page</div>

<div class="panel-body">
<form action="reg.do" method="post">
<div class="form" >
<label>name:</label>
<input type="text" placeholder="Enter your name" name="name"/><br>
 	<label>Phone Number:</label>
<input type="number" placeholder="Enter your number" name="num"/><br>
<label>E-Mail Id:</label>
<input type="email" placeholder="Enter your mail Id" name="email" /><br>
<label>Password:</label>
<input type="password" placeholder="Enter your password" name="pwd" /><br>
<label>DOB:</label>
<input type="date" name="date"/><br>
<label>Gender:</label><br>
<input type="radio" name="gender" value="male" checked> Male<br>
<input type="radio" name="gender" value="female"> Female<br>
<label>Select Carrier:</label>
<select name="carrier">
<option value="select">Select Carrier</option>
  <option value="at&t">AT&T</option>
  <option value="sprint">Sprint</option>
  <option value="tmobile">T-Mobile</option>
  <option value="verizon">Verizon</option>
</select><br>
<label>Billing Zip Code:</label>
<input type="number" placeholder="Enter your zipcode" name="zip" /><br>

<input type="checkbox" name="agree" value="Agree">Accept all the terms and conditions<br>
<button type="submit" class="btn btn-primary">Submit</button>
<a href="/jspJDBCAssign/teleLogin.jsp"> login</a>

</div>
  
</form></div>
</div></div>
</body>
</html>