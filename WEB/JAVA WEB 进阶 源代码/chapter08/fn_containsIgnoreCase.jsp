<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
	fn:containsIgnoreCase("www.itcast.cn","it")返回值为：
	${fn:containsIgnoreCase("www.itcast.cn","it") } <br> 
	fn:containsIgnoreCase("www.itcast.cn","IT")返回值为：
	${fn:containsIgnoreCase("www.itcast.cn","IT") } <br> 
</body>
</html>
