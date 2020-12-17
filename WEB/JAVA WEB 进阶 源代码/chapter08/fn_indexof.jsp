<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
	fn:indexOf("www.itcastit.cn","it")返回值为：
	${fn:indexOf("www.itcastit.cn","it") } <br> 
	fn:indexOf("www.itcast.cn","aaa")返回值为：
	${fn:indexOf("www.itcast.cn","aaa") } <br> 
	fn:indexOf("www.itcast.cn","")返回值为：
	${fn:indexOf("www.itcast.cn","") } <br>
</body>
</html>
