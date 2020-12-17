<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" import="java.util.*,java.text.*"%>
<html>
<%
	Locale locale = request.getLocale();
	ResourceBundle bundle = ResourceBundle.getBundle("applicationRes",
			locale);
%>
<head>
<title><%=bundle.getString("title")%></title>
</head>
<body>
	<%=bundle.getString("heading")%><br>
	<br>
	<%
		String message = bundle.getString("message");
		MessageFormat msgFmt = new MessageFormat(message, locale);
		Date dateTime = new Date();
		Object[] msgArgs = { dateTime, new Integer(10), new Double(550.8) };
	%>
	<%=msgFmt.format(msgArgs)%>
</body>
</html>
