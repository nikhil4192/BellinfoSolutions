<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<style>
@import "font-awesome.min.css";
@import "font-awesome-ie7.min.css";
/* Space out content a bit */
body {
  padding-top: 20px;
  padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header,
.marketing,
.footer {
  padding-right: 15px;
  padding-left: 15px;
}

/* Custom page header */
.header {
  border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
  padding-bottom: 19px;
  margin-top: 0;
  margin-bottom: 0;
  line-height: 40px;
}

/* Custom page footer */
.footer {
  padding-top: 19px;
  color: #777;
  border-top: 1px solid #e5e5e5;
}

/* Customize container */
@media (min-width: 768px) {
  .container {
    max-width: 730px;
  }
}
.container-narrow > hr {
  margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
  text-align: center;
  border-bottom: 1px solid #e5e5e5;
}
.jumbotron .btn {
  padding: 14px 24px;
  font-size: 21px;
}

/* Supporting marketing content */
.marketing {
  margin: 40px 0;
}
.marketing p + h4 {
  margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
  /* Remove the padding we set earlier */
  .header,
  .marketing,
  .footer {
    padding-right: 0;
    padding-left: 0;
  }
  /* Space out the masthead */
  .header {
    margin-bottom: 30px;
  }
  /* Remove the bottom border on the jumbotron for visual effect */
  .jumbotron {
    border-bottom: 0;
  }
}
</style>
<body>
<jsp:include page="userHeader.jsp"></jsp:include>
<div class="container" >
	<div style="border: 2px">
    <h1 class="well">Loan Registration Form</h1>
	<div class="col-lg-12 well">
	<div class="row">
					<form:form action="/loanRegistration" method="Post"
						modelAttribute="loanRegistration">
						<div class="row">
                        <div class="col-lg-6 form-group">
								<span><strong>ID</strong></span>
								<form:input path="customerID" cssClass="form-control"/>
							</div>	
							<div class="col-sm-6 form-group">
								<span><strong>First Name</strong></span>
								<form:input path="customerFName" cssClass="form-control"/>
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>Last Name</strong></span>
								<form:input path="customerLName" cssClass="form-control"/>
							</div>
						
							<div class="col-sm-6 form-group">
								<span><strong>Father Name</strong></span>
								<form:input path="cutomerFatherName" cssClass="form-control"/>
							</div>		
							
												
					<div class="col-sm-6 form-group">
						<span><strong>Phone Number</strong></span>
						<form:input path="customerPhone" cssClass="form-control"/>
					</div>		
					<div class="col-sm-6 form-group">
						<span><strong>Amount</strong></span>
						<form:input path="loanAmount" cssClass="form-control"/>
					</div>	
					</div>
					<input type="submit" class="btn btn-primary btn-pad"
									style="margin-left: 45%"/>
									
					</form:form>
				</div>
	</div>
	</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html> 