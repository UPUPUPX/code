<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
	fn:contains("www.itcast.cn","it")����ֵΪ��
	${fn:contains("www.itcast.cn","it") } <br> 
	fn:contains("www.itcast.cn","IT")����ֵΪ��
	${fn:contains("www.itcast.cn","IT") } <br> 
	fn:contains("www.itcast.cn","")����ֵΪ��
	${fn:contains("www.itcast.cn","") } <br>
</body>
</html>
