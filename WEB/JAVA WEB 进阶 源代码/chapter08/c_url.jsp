<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	ʹ�þ���·������URL:<br>
	<c:url var="myURL" 
     value="http://localhost:8080/chapter08/register.jsp">
		<c:param name="username" value="����" />
		<c:param name="country" value="�й�" />
	</c:url>
	<a href="${myURL}">register.jsp</a><br>
	ʹ�����·������URL:<br>
	<c:url var="myURL" 
     value="register.jsp?username=Tom&country=France" />
	<a href="${ myURL}">register.jsp</a>
</body>
</html>
