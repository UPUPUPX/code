<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<%
		Map userMap = new HashMap();
		userMap.put("Tom", "123");
		userMap.put("Make","123");
		userMap.put("Lina","123");
	%>
	HashMap集合中的元素：<br>
	<c:forEach var="entry" items="<%=userMap%>">
		${entry.key}&nbsp;${entry.value}<br>
	</c:forEach>
</body>
</html>
