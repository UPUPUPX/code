<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head></head>
<body>
	<% pageContext.setAttribute("userName", "itcast"); %>
	<% request.setAttribute("bookName", "Java Web"); %>
	<% session.setAttribute("userName", "itheima"); %>
	<% application.setAttribute("bookName", "Java ����"); %>
	���ʽ\${pageScope.userName}��ֵΪ��${pageScope.userName} <br> 
	���ʽ\${requestScope.bookName}��ֵΪ��${requestScope.bookName} <br> 
	���ʽ\${sessionScope.userName}��ֵΪ��${sessionScope.userName} <br>
	���ʽ\${applicationScope.bookName}��ֵΪ��${applicationScope.bookName} 
     <br> 
	���ʽ\${userName}��ֵΪ��${userName}
</body>
</html>
