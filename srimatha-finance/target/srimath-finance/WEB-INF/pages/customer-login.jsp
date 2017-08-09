<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<style>
.login-screen {
	background-image:
		url(https://www.squiz.net/__public/Systems/Perspective/FileCache/1-32000/465/prop/header-bg-image.jpg?t=1472431690);
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	-moz-background-size: cover;
	-webkit-background-size: cover;
	position: fixed;
	
	top: 0;
	bottom: 0;
	right: 0;
	left: 0;
}

.login-screen:before {
	content: "";
	background: rgba(0, 0, 0, 0.5);
	position: absolute;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
}

.pad {
	padding: 12px;
	margin-right: 10px;
}

.btn-pad {
	position: relative;
	margin-top: 7px;
	margin-right: 30px;
	margin-left: 50px;
}
</style>
<body>
	<div class="container">
		<div class="login-screen">
			<div class="login-center">
				<form:form action="customer" method="POST" modelAttribute="customer">
				<nav class="navbar navbar-inverse">
					
						
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${pageContext.request.contextPath}/registration"><span class="glyphicon glyphicon-user pad"></span> <span
								style="color: white"><strong>Sign Up</strong></span></a></li>
							<li><span style="margin-top: 35px"><span class="glyphicon glyphicon-user pad"></span> <span
								style="color: white"><strong>User Id : </strong> <form:input
									path="customerUserID" /></span></li>
							<li><span class="glyphicon glyphicon-log-in pad"></span> <span
								style="color: white"><strong>Password : </strong></span> <form:password
									path="customerPswd" /></li>
							<li><input type="submit" class="btn btn-primary btn-pad"
								style="margin-left: 15px" /></li>
								
						</ul>
						
						
						
						</nav>
						<h1 style="text-align: center; color:white">Welcome To Login Page</h1>
				</form:form>
			</div>

		</div>
	</div>

</body>
</html>