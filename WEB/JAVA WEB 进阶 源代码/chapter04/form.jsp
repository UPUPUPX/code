<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="java.util.*"
%>
<html>
<head></head>
<center>
	<h3>�û���¼</h3>
</center>
<body style="text-align: center;">
 	<a href="<%=request.getContextPath()%>/CharacterServlet?name=
                ���ǲ���&password=123456">��������ӵ�¼</a>
	<form action="<%=request.getContextPath()%>/CharacterServlet"
		method="post">
		<table border="1" width="600px" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td height="30" align="center">�û�����</td>
				<td>&nbsp;<input type="text" name="name" /></td>
			</tr>
			<tr>
				<td height="30" align="center">�� &nbsp; �룺</td>
				<td>&nbsp;<input type="password" name="password" /></td>
			</tr>
			<tr>
				<td height="30" colspan="2" align="center">
                 <input type="submit"value="��¼" />&nbsp;&nbsp;&nbsp;&nbsp; 
                  <input type="reset"value="����" /></td>
			</tr>
		</table>
	</form>
</body>
<html>
