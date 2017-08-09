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

<jsp:include page="userHeader.jsp"/>
<form:form action="userApprovedLoans" method="get" modelAttribute="userApprovedLoans">
${userApprovedLoans }
<table style="border:1px">
<thead>
<td>Serial Number</td>
<td>Customer ID</td>
<td>First Name</td>
<td>Last Name</td>
<td>Father Name</td>
<td>Phone Number</td>
<td>Loan Requested Amount</td>
<td>Request</td>
</thead>
<c:forEach items="${userApprovedLoans}" var="item">
<tr>
<td>${item.serialNumber}</td>
<td>${item.customerID}</td>
<td>${item.customerFName}</td>
<td>${item.customerLName}</td>
<td>${item.cutomerFatherName}</td>
<td>${item.customerPhone}</td>
<td>${item.loanAmount}</td>
<td>${item.decision }</td>
</tr>


</c:forEach>
</form:form>
<jsp:include page="footer.jsp"/>
</body>
</html>