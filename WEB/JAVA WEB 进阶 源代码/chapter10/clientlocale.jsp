<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" import="java.util.*"%>
<html>
<head></head>
<body>
	<%
		Locale perferlocale = request.getLocale();
		out.println("客户端首选的本地信息为：" + perferlocale);
	%><br>
	<br> 客户端支持的所有本地信息列表，按优先级的降序排列：
	<br>
	<br>
	<%
		Enumeration locales = request.getLocales();
	%>
	<li>本地信息 &nbsp;&nbsp;本性信息的显示名称</li>
	<%
		while (locales.hasMoreElements()) {
			Locale locale = (Locale) locales.nextElement();
	%>
	<li>
		<%=locale%>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<%=locale.getDisplayName()%>
	</li>
	<%
		}
	%>
</body>
</html>
