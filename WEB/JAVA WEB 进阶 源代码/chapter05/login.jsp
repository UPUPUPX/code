<%@ page language="java" contentType="text/html; 
charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>�û���¼</h3>
	</center>
	<form 
     action="${pageContext.request.contextPath }/LoginServlet"
		method="post">
		<table border="1" width="550px" cellpadding="0" 
          cellspacing="0" align="center">
			<tr>
				<td height="35" align="center">�û�����</td>
				<td>&nbsp;&nbsp;&nbsp;
                   	<input type="text" name="username" />
                   </td>
			</tr>
			<tr>
				<td height="35" align="center">�� &nbsp; �룺</td>
				<td>&nbsp;&nbsp;&nbsp;
					<input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td height="35" colspan="2" align="center">
                   	<input type="submit" value="��¼" />
                   	&nbsp;&nbsp;&nbsp;&nbsp;
                   	<input type="reset" value="����" />
                   </td>
			</tr>
		</table>
	</form>
</body>
</html>
