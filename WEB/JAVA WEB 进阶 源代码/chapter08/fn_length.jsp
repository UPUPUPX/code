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
	fn:length函数获取数组、集合中元素的个数以及字符串长度 <br>
	数组中元素的个数：${fn:length(array)} <br> 
	集合中元素的个数：${fn:length(list)}	<br> 
	字符串长度：${fn:length("Tomcat")} <br>
</body>
</html>
