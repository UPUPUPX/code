<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
	fn:substring("welcome to itcast!",3,9)���صĽ��Ϊ��
	${fn:substring("welcome to itcast!",3,9) } <br> 
	fn:substringBefore("mydata.txt",".")���صĽ��Ϊ��
	${fn:substringBefore("mydata.txt",".") } <br> 
	fn:substringAfter("mydata.txt",".")���صĽ��Ϊ��
	${fn:substringAfter("mydata.txt",".") } <br> 
</body>
</html>
