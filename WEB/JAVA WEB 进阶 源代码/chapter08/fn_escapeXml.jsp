<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	1��${fn:escapeXml("<b>��ʾ������</b>")} <br> 
	2��<c:out value="<b>��ʾ������</b>" escapeXml="true"/> <br>
	3��${"<b>��ʾ������</b>"}
</body>
</html>
