<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>��ʾ��¼���û���Ϣ</title>
</head>
<body>
	<br>
	<center>
		<h3>��ӭ����</h3>
	</center>
	<br>
	<br>
	<c:choose>
		<c:when test="${sessionScope.user==null }">
			<a href="${pageContext.request.contextPath }/login.jsp">
                 �û���¼</a>
		</c:when>
		<c:otherwise>
  	  ��ӭ�㣬${sessionScope.user.username }!
  	  <a href="${pageContext.request.contextPath }/LogoutServlet">ע��</a>
		</c:otherwise>
	</c:choose>
	<hr>
</body>
</html>
