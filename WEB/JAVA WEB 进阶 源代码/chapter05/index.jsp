<%@ page language="java" contentType="text/html; charset=utf-8"  
pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h3>
		当前在线人数为：
		<%=application.getAttribute("count")%>
	</h3>
	<a href="<%=response.encodeUrl("logout.jsp")%>">退出登录</a>
</body>
</html>
