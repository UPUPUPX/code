<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head></head>
<body>
	<% response.addCookie(new Cookie("userName", "itcast")); %>
	Cookie�������Ϣ��<br> 
	${cookie.userName } <br> 
	Cookie��������ƺ�ֵ��<br> 
	${cookie.userName.name }=${cookie.userName.value }
</body>
</html>
