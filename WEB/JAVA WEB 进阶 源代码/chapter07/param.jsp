<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head></head>
<body>
<body style="text-align: center;">
	<form action="${pageContext.request.contextPath}/param.jsp">
		num1£º<input type="text" name="num1"><br> 
		num2£º<input type="text" name="num"><br> 
		num3£º<input type="text" name="num"><br> 
		<input type="submit" value="Ìá½»" />&nbsp;&nbsp;
		<input type="submit" value="ÖØÖÃ" /><p><hr>
		num1£º${param.num1}<br>
		num2£º${paramValues.num[0]}<br>
		num3£º${paramValues.num[1]}<br>
	</form>
</body>
</html>
