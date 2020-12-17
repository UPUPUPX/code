<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head></head>
<body>
	<% session.setAttribute("pageContext", "itcast");	%>
	输出表达式\${pageContext}的值：<br> 
    ${pageContext}
</body>
</html>
