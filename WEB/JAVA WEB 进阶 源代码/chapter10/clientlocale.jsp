<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" import="java.util.*"%>
<html>
<head></head>
<body>
	<%
		Locale perferlocale = request.getLocale();
		out.println("�ͻ�����ѡ�ı�����ϢΪ��" + perferlocale);
	%><br>
	<br> �ͻ���֧�ֵ����б�����Ϣ�б������ȼ��Ľ������У�
	<br>
	<br>
	<%
		Enumeration locales = request.getLocales();
	%>
	<li>������Ϣ &nbsp;&nbsp;������Ϣ����ʾ����</li>
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
