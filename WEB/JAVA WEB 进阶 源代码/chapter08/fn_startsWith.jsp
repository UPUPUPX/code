<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head></head>
<body>
	fn:startsWith("www.itcast.cn","www")返回值为：
	${fn:startsWith("www.itcast.cn","www") } <br> 
	fn:startsWith("welcome","www")返回值为：
	${fn:startsWith("welcome","www") } <br> 
	fn:endsWith("www.itcast.cn","cn")返回值为：
	${fn:endsWith("www.itcast.cn","cn") } <br> 
	fn:endsWith("welcome","cn")返回值为：
	${fn:endsWith("welcome","cn") } <br> 
</body>
</html>
