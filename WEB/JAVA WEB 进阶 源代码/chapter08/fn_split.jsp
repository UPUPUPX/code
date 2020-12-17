<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	使用fn:split函数将" welcome to china"字符串进行分割：<br>
	<c:set value='${fn:split("welcome to china"," ")}' var="strs" />
	<c:forEach var="token" items="${strs}">
	  	${token}<br>
	</c:forEach>
</body>
</html>
