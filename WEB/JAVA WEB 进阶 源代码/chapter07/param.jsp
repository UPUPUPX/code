<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head></head>
<body>
<body style="text-align: center;">
	<form action="${pageContext.request.contextPath}/param.jsp">
		num1��<input type="text" name="num1"><br> 
		num2��<input type="text" name="num"><br> 
		num3��<input type="text" name="num"><br> 
		<input type="submit" value="�ύ" />&nbsp;&nbsp;
		<input type="submit" value="����" /><p><hr>
		num1��${param.num1}<br>
		num2��${paramValues.num[0]}<br>
		num3��${paramValues.num[1]}<br>
	</form>
</body>
</html>
