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
              ��¼
       </a>
	  <br>
		</c:when>
		<c:otherwise>
  			��ӭ�㣬${sessionScope.user.username }!
	   <a href="${pageContext.request.contextPath}/LogoutServlet">
              �˳� 
       </a>
		</c:otherwise>
	</c:choose>
	<hr>
	�����û��б�
	<br>
	<c:forEach var="user" items="${requestScope.users }">
   		${user.value }
   </c:forEach>
</body>
</html>
