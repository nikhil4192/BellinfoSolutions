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
<body>
<jsp:include page="userHeader.jsp"></jsp:include>
<div id="content" style="position:absolute; top:70px; bottom:170px; left:0px; right:0px; overflow:auto;"> 
   
<div class="container">
		<div style="border: 2px">
			<h1 class="well">Payment Page</h1>
			<div class="col-lg-12 well">
				<div class="row">
					<form:form action="${pageContext.request.contextPath}/payment" method="POST" modelAttribute="payment">
						<div class="row">
							<div class="col-lg-6 form-group">
								<span><strong>Serial Number</strong></span>
								<form:input path="serialNumber" cssClass="form-control" />
							</div>
							<div class="col-lg-6 form-group">
								<span><strong>ID</strong></span>
								<form:input path="customerID" cssClass="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>First Name</strong></span>
								<form:input path="customerFName" cssClass="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>Last Name</strong></span>
								<form:input path="customerLName" cssClass="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>Father Name</strong></span>
								<form:input path="cutomerFatherName" cssClass="form-control" />
							</div>

							<div class="col-sm-6 form-group">
								<span><strong>Phone Number</strong></span>
								<form:input path="customerPhone" cssClass="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>Loan Amount</strong></span>
								<form:input path="loanAmount" cssClass="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>Status</strong></span>
								<form:input path="status" cssClass="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>Approved Date</strong></span>
								<form:input path="approveddate" cssClass="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>Payment</strong></span>
								<form:input path="payment" cssClass="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<span><strong>Intrest Amount</strong></span>
								<form:input path="intrestamount" cssClass="form-control" />
							</div>
							
							</div>
							<input type="submit" class="btn btn-primary btn-pad"
								style="margin-left: 45%" />
					</form:form>
				</div>
			</div>
		</div>
	</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>