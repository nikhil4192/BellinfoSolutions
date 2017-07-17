<%@page import="java.util.ArrayList"%>
<%@page import="telephoneModel.TelePayment"%>
<%@page import="java.util.List"%>
<%@page import="telephoneRepository.TelePayRepo"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="bill.do" method="get">
<% 
List<TelePayment> ltp = new ArrayList<TelePayment>();
try{
	System.out.println("nikhil");
	TelePayRepo tpr = new TelePayRepo();
	tpr.selectAllData(ltp);
	System.out.println("kumar");
	
		System.out.println("third");
		%>
		<table>
		<thead><tr>
		<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Phone</th>
	    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name</th>
	    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Card Num</th>
	    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Month</th>
	    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Year</th>
	    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cvv</th>
	    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Amount</th></tr></thead>
		</table> 
		      
	<%	  System.out.println();//Move to the next line to print the next row.  
	for(TelePayment t:ltp){ 
		%>
		     <table>
            <tr>
                <td><%=t.getPhone() %></td>
                <td><%=t.getName()%></td>
                <td><%=t.getCardNum() %></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;<%=t.getMm()%></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=t.getYy() %></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=t.getCvv() %></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=t.getAmount() %></td>
            </tr>
    </table>
	<%	  System.out.println();//Move to the next line to print the next row.  
	
	}
}
catch(Exception e)
{
	  e.printStackTrace();
}
	%>





<!--  <button type="submit">Click Me</button>
<c:if test="${list not empty }">
    <table>
        <c:forEach items="${list}" var="record">
            <tr>
                <td>"${record. }"</td>
                <td>"${record.name }"</td>
                <td>"${record.cardNum }"</td>
                <td>"${record.mm }"</td>
                <td>"${record.yy }"</td>
                <td>"${record.cvv }"</td>
                <td>"${record.amount }"</td>
            </tr>
        </c:forEach>
    </table>
</c:if>-->
</form>
</body>
</html>