<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="cn.itcast.chapter05.listener.*"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>��Session���д�������</h1>
	<%
		MyBean2 myBean = new MyBean2();
		myBean.setName("Tom");
		myBean.setAge(20);
		session.setAttribute("myBean", myBean);
	%>
</body>
</html>
