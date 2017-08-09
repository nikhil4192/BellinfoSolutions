<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Insert title here</title>

 <style>  
body {	
    background-color: #eee;
    background:url("https://buidln.clipdealer.com/002/494/500//previews/3--2494500-Montage%20of%20doctors%20working%20with%20elderly%20patients.jpg");
}
*[role="form"] {
    width: 200px;
    padding: 15px;
    margin: 0 auto;
    background-color: midnightblue;
    border-radius: 0.3em;
}
*[role="form"] h2 {
    margin-left: 5em;
    margin-bottom: 1em;
}
</style>
<style>
body {	
    background-color: #eee;
    background:url(https://www.squiz.net/__public/Systems/Perspective/FileCache/1-32000/465/prop/header-bg-image.jpg?t=1472431690);
	}
*[role="form"] {
    width: 200px;
    padding: 15px;
    margin: 0 auto;
    background-color: midnightblue;
    border-radius: 0.3em;
}
*[role="form"] h2 {
    margin-left: 5em;
    margin-bottom: 1em;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav navbar-right">
    	 <li><a href="/contact">Contact</a></li>
      <li><a href="$/registeration"><span class="glyphicon glyphicon-user"></span> Register</a></li>
   <li><a href="${pageContext.request.contextPath}/customer"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<div class="container">

	

    <h1 class="well" style="text-align: center">Registration Form</h1>
<form:form action="registration" method="POST" modelAttribute="customer">	
   
	<div class="col-lg-12 well">
	<div class="row">
				
					<div class="col-sm-12">
						
						<div class="row">
						
							<div class="col-sm-6 form-group">
								<label>First Name</label>
								
							<form:input type="text" placeholder="Enter Your First Name.." class="form-control" path="customerFName"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<form:input type="text" placeholder="Enter Your Last Name.." class="form-control" path="customerLName"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Father Name</label>
								<form:input type="text" placeholder="Enter Your Father Name.." class="form-control" path="customerFatherOrHusbandName"></form:input>
							</div>
													
							<div class="col-sm-6 form-group">
								<label>Phone Number</label>
								<form:input type="text" placeholder="Enter your Phone Number Here.." class="form-control" path="customerPhone" ></form:input>
							</div>	
                            
                            <div class="col-sm-6 form-group">
								<label>User Name</label>
								<form:input type="text" placeholder="Enter your username" class="form-control" path="customerUserID" ></form:input>
							</div>	
                            
                            
							<div class="col-sm-6 form-group">
								<label>Password</label>
								<form:input type="Password" placeholder="Enter your password Here.." class="form-control" path="customerPswd" ></form:input>
							</div>	
								
					
					<form:button type="submit" class="btn btn-lg btn-info" Style="position:relative; margin-left:42%;">Submit</form:button>				
					</div>
    			
    			</div></div></form:form></div>
</body>
</html>