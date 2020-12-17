<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" import="java.util.*,java.text.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title></title>
</head>
<body>
	<%
		pageContext.setAttribute("dateref", new Date());
	%>
	<fmt:formatDate value="${dateref}" type="both" dateStyle="default"
		timeStyle="default" var="date" />
	<h3>default显示日期时间：${date}</h3>
	<fmt:formatDate value="${dateref}" type="both"
		pattern="yyyy年MM月dd日 HH时mm分ss秒SSS毫秒" var="date" />
	<h3>自定义格式显示日期时间：${date}</h3>
	<fmt:parseDate value="3/24/15" pattern="MM/dd/yy" var="parsed" />
	<h3>格式化用字符串表示的日期：<fmt:formatDate value="${dateref}"/></h3>

	<fmt:timeZone value="GMT+1:00">
		<fmt:formatDate value="${dateref}" type="both" dateStyle="full"
			timeStyle="full" var="date" />
		<h3>使用“GMT+1:00”时区：${date}</h3>
	</fmt:timeZone>
	
	<fmt:formatNumber value="351989.356789" maxIntegerDigits="7"
		maxFractionDigits="3" groupingUsed="true" var="num" />
	<h3>格式化数字：${num}</h3>
	<fmt:formatNumber value="351989.356789" pattern="##.###E0" var="num" />
	<h3>科学计数法：${num}</h3>
	<fmt:parseNumber value="￥351,989.356.00" type="currency" 
         var="num" parseLocale="zh_CN"/>
	<h3>解析字符串“￥351,989.356.00”：${num}</h3>
	
</body>
</html>
