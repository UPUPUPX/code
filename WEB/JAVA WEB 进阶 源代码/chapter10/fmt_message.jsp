<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" import="java.util.*,java.text.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<fmt:setBundle basename="applicationRes" var="applicationRes" />
<head>
<title><fmt:message bundle="${applicationRes}" key="title" /></title>
</head>
<body>
	<fmt:message bundle="${applicationRes}" key="heading" />
	<br>
	<jsp:useBean id="now" class="java.util.Date" />
	<%
		session.setAttribute("nm", new Integer(10));
		session.setAttribute("number", new Double(550.8));
	%>
	<fmt:message bundle="${applicationRes}" key="message">
		<fmt:param value="${now}" />
		<fmt:param value="${nm}" />
		<fmt:param value="${number}" />
	</fmt:message>
	<br>
</body>
</html>
