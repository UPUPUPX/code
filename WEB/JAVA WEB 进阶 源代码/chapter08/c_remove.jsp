<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<c:set value="���ǲ���" var="company" scope="request" />
	<c:set value="www.itcast.cn" var="url" scope="request" />
	Company��<c:out value="${company}" /><br> 
	URL��<c:out value="${url}" /><br><hr>
	ʹ�ñ�ǩ�Ƴ����Ժ�<br>
	<c:remove var="company" scope="request" />
	<c:remove var="url" scope="request" />
	Company��<c:out value="${company}" /><br> 
	URL��<c:out value="${url}" /><br>
</body>
</html>
