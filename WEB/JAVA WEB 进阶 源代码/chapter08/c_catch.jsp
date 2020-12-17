<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<c:catch var="myex">
		<%
			int i = 10;
			int j = 0;
			System.out.print(i + "/" + j + "=" + i / j);
		%>
	</c:catch>
	异常：<c:out value="${myex}" /> <br /> 
	异常 myex.getMessage：<c:out value="${myex.message}" /> <br /> 
	异常 myex.getCause：<c:out value="${myex.cause}" /> <br /> 
	异常 myex.getStackTrace：<c:out value="${myex.stackTrace}" />
</body>
</html>
