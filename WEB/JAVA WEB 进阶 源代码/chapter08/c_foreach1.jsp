<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<%
		String [] fruits={"apple","orange","grape","banana"};
	%>
	String数组中的元素：<br>
	<c:forEach var="name" items="<%=fruits%>">
		${name}<br>
	</c:forEach>
</body>
</html>
