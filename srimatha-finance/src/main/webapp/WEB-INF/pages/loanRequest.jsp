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

<jsp:include page="adminHeader.jsp"></jsp:include>
<div id="content" style="position:absolute; top:70px; bottom:170px; left:0px; right:0px; overflow:auto;"> 
 
<form:form action="/request" method="POST" modelAttribute="list">
<div class= "container">
<table class="table table-striped">
<tr>
<th>Serial Number</th>
<th>Customer ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Father Name</th>
<th>Phone Number</th>
<th>Loan Requested Amount</th>
<th>Request</th>
</thead>
<c:forEach items="${list}" var="item">
<c:url var="approval" value="/request/approve">
<c:param name="serialID" value="${item.serialNumber }"/>
</c:url>
<tr>
<td>${item.serialNumber}</td>
<td>${item.customerID}</td>
<td>${item.customerFName}</td>
<td>${item.customerLName}</td>
<td>${item.cutomerFatherName}</td>
<td>${item.customerPhone}</td>
<td>${item.loanAmount}</td>
<td><a href="${approval}">Approve OR Reject</td>
</tr>
</c:forEach>
</table>
</div>
<!--  <input type="submit" class="btn btn-primary btn-pad"
									style="margin-left: 15px"/>-->

</form:form>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>