<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<%
		int[] array = { 1, 2, 3, 4 };
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
	%>
	<c:set value="<%=array%>" var="array" />
	<c:set value="<%=list%>" var="list" />
	fn:length������ȡ���顢������Ԫ�صĸ����Լ��ַ������� <br>
	������Ԫ�صĸ�����${fn:length(array)} <br> 
	������Ԫ�صĸ�����${fn:length(list)}	<br> 
	�ַ������ȣ�${fn:length("Tomcat")} <br>
</body>
</html>
