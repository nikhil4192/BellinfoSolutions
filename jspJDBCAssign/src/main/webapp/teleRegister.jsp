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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Mobile Payment</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/jspJDBCAssign/"><span class="glyphicon glyphicon-user"></span> Register</a></li>
      <li><a href="/jspJDBCAssign/teleLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<form action="reg.do" method="post">

   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style>
body {
    background-color: #eee;
}

*[role="form"] {
    max-width: 530px;
    padding: 15px;
    margin: 0 auto;
    background-color: #fff;
    border-radius: 0.3em;
}

*[role="form"] h2 {
    margin-left: 5em;
    margin-bottom: 1em;
}

</style><div class="container">
    <h1 class="well" style="text-align: center">Registration Form</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form>
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-12 form-group">
								<label>First Name</label>
								<input type="text" placeholder="Enter Your Name Here.." class="form-control" name="name">
							</div>
							
						</div>					
						<div class="form-group">
							<label>Phone Number</label>
							<input type="number" placeholder="Enter your Mobile number" rows="3" class="form-control" name="num"></textarea>
						</div>	
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>E-mail Id</label>
								<input type="text" placeholder="Enter your E-mail Id Here.." class="form-control" name="email">
							</div>	
							<div class="col-sm-6 form-group">
								<label>Password</label>
								<input type="Password" placeholder="Enter your password Here.." class="form-control" name="pwd">
							</div>	
                            </div>
                            <div class="row">
							<div class="col-sm-6 form-group">
								<label>DOB</label>
								<input type="date"  class="form-control" name="date">
							</div>	
                            <div class="col-sm-6 form-group">
						<label>Zip Code</label>
						<input type="number" placeholder="Enter your Zip Code Here.." class="form-control" name="zip">
					</div>	
						</div>
						
  <div class="row">
  <div class="col-sm-6">
  <label>Gender</label>
    <div class="radio">
      <label><input type="radio" name="gender" checked>Male</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="gender">Female</label>
    </div>
    
  </div>						
  <div class="col-sm-6">
  <label>Select Carrier</label>
                                        
  <div class="dropdown">
 
    
    <select button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"name="carrier">
    <span class="caret"></span></button>
<option value="select">Select Carrier : </option>
  <option value="at&t">AT&T</option>
  <option value="sprint">Sprint</option>
  <option value="tmobile">T-Mobile</option>
  <option value="verizon">Verizon</option>
</select>
 </div>
</div>
		</div>	<br>			
					
					<button type="submit" class="btn btn-lg btn-info" Style="position:relative; margin-left:42%;">Submit</button>					
					</div>
				</form> 
				</div>
                
	</div>
	</div>
</form>

</body>
</html>