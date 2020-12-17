<%@ page language="java" contentType="text/html; 
charset=utf-8" pageEncoding="utf-8" 
import="cn.itcast.chapter05.listener.MyBean"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		session.setAttribute("myBean", new MyBean());
	%>
</body>
</html>
