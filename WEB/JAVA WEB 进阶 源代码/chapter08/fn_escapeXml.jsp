<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	1：${fn:escapeXml("<b>表示粗体字</b>")} <br> 
	2：<c:out value="<b>表示粗体字</b>" escapeXml="true"/> <br>
	3：${"<b>表示粗体字</b>"}
</body>
</html>
