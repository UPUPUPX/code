<%@ page language="java" pageEncoding="GBK"
import="cn.itcast.chapter09.domain.User"%>
<%@taglib uri="/simpleTag" prefix="itcast"%>
<html>
<head>
<title>showtime Tag</title>
</head>
<body>
<%--��User�����д�ֵ--%>
	<%
		User user = new User();
		user.setName("Conca");
		session.setAttribute("user", user);
	%>
	<itcast:showtime user="${user }" />
</body>
</html>
