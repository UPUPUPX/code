<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
	fn:contains("www.itcast.cn","it")返回值为：
	${fn:contains("www.itcast.cn","it") } <br> 
	fn:contains("www.itcast.cn","IT")返回值为：
	${fn:contains("www.itcast.cn","IT") } <br> 
	fn:contains("www.itcast.cn","")返回值为：
	${fn:contains("www.itcast.cn","") } <br>
</body>
</html>
