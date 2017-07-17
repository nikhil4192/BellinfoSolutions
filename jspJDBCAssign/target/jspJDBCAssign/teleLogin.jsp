<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form action="log.do" method="post">
<label>E-Mail Id:</label>
<input type="email" placeholder="Enter your mail Id" name="email" /><br>
<label>Password:</label>
<input type="password" placeholder="Enter your password" name="pwd" /><br>
<button type="submit" class="btn btn-primary">Login</button>
</form>
</div>
</body>
</html>