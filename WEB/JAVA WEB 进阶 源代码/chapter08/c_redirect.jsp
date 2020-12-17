<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<c:url var="myURL" value="register.jsp">
		<c:param name="username" value="张三" />
		<c:param name="country" value="中国" />
	</c:url>
	<c:redirect url="${myURL }" />
</body>
</html>
