<%@ page language="java" contentType="text/html; 
charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<%--��1��out��ǩ --%>
	userName���Ե�ֵΪ��
	<c:out value="${param.username}" default="unknown"/><br>
	<%--��2��out��ǩ --%>
	userName���Ե�ֵΪ��
	<c:out value="${param.username}">
       unknown
    </c:out>
</body>
</html>
