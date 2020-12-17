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
	<h3>default��ʾ����ʱ�䣺${date}</h3>
	<fmt:formatDate value="${dateref}" type="both"
		pattern="yyyy��MM��dd�� HHʱmm��ss��SSS����" var="date" />
	<h3>�Զ����ʽ��ʾ����ʱ�䣺${date}</h3>
	<fmt:parseDate value="3/24/15" pattern="MM/dd/yy" var="parsed" />
	<h3>��ʽ�����ַ�����ʾ�����ڣ�<fmt:formatDate value="${dateref}"/></h3>

	<fmt:timeZone value="GMT+1:00">
		<fmt:formatDate value="${dateref}" type="both" dateStyle="full"
			timeStyle="full" var="date" />
		<h3>ʹ�á�GMT+1:00��ʱ����${date}</h3>
	</fmt:timeZone>
	
	<fmt:formatNumber value="351989.356789" maxIntegerDigits="7"
		maxFractionDigits="3" groupingUsed="true" var="num" />
	<h3>��ʽ�����֣�${num}</h3>
	<fmt:formatNumber value="351989.356789" pattern="##.###E0" var="num" />
	<h3>��ѧ��������${num}</h3>
	<fmt:parseNumber value="��351,989.356.00" type="currency" 
         var="num" parseLocale="zh_CN"/>
	<h3>�����ַ�������351,989.356.00����${num}</h3>
	
</body>
</html>
