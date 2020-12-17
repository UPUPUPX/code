<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.user==null }">
	  <a href="${pageContext.request.contextPath}/login.jsp">
              登录
       </a>
	  <br>
		</c:when>
		<c:otherwise>
  			欢迎你，${sessionScope.user.username }!
	   <a href="${pageContext.request.contextPath}/LogoutServlet">
              退出 
       </a>
		</c:otherwise>
	</c:choose>
	<hr>
	在线用户列表
	<br>
	<c:forEach var="user" items="${requestScope.users }">
   		${user.value }
   </c:forEach>
</body>
</html>
