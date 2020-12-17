<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<body>
	<form action="ResultServlet" method="post">
		用户名：<input type="text" name="username"><br> 
		留 言：
		<textarea rows="6" cols="50" name="message"></textarea>
		<br> <input type="submit" value="提交">
	</form>
</body>
</html>
