<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>	
	ʹ��fn:join�������ַ�������ϲ���<br>
	<%
		String strs[] = { "www", "itcast", "cn" };
	%>
	<c:set value="<%=strs%>" var="strs" />
	${fn:join(strs,".")}
</body>
</html>
