<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
 	fn:replace("www.itcast.cn",".","-")���滻���Ϊ��
	${fn:replace("www.itcast.cn",".","-") } <br> 
	fn:replace("2013/11/28","/","-")���滻���Ϊ��
	${fn:replace("2013/11/28","/","-") } <br> 
</body>
</html>
