<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
	fn:startsWith("www.itcast.cn","www")����ֵΪ��
	${fn:startsWith("www.itcast.cn","www") } <br> 
	fn:startsWith("welcome","www")����ֵΪ��
	${fn:startsWith("welcome","www") } <br> 
	fn:endsWith("www.itcast.cn","cn")����ֵΪ��
	${fn:endsWith("www.itcast.cn","cn") } <br> 
	fn:endsWith("welcome","cn")����ֵΪ��
	${fn:endsWith("welcome","cn") } <br> 
</body>
</html>
