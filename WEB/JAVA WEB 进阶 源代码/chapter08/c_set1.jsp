<%@ page language="java" contentType="text/html; 
charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	session域中userName属性的值为：
	<c:set var="userName" value="itcast" scope="session" />
	<c:out value="${userName}" /><hr>
	session域中bookName属性的值为：
	<c:set var="bookName" scope="session">
		Java Web
	</c:set>
	<c:out value="${bookName}" />
</body>
</html>
