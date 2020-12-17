<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
	fn:toLowerCase函数将字符串ITCAST转换为小写 <br> 
	${fn:toLowerCase("ITCAST") } <br><hr>
	fn:toUpperCase函数将字符串itcast转换为大写 <br> 
	${fn:toUpperCase("ITCAST") }
</body>
</html>
