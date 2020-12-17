<%@page import="cn.itcast.domain.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'show.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<body>
	<table border="1" align="center" width="50%">
		<tr>
			<th>图书名称</th>
			<th>图书单价</th>
			<th>图书分类</th>
		</tr>
		<%
			List<Book> list = (List) request.getAttribute("bookList");
			for (Book b : list) {
		%>
		<tr>
			<td><%=b.getBname()%></td>
			<td><%=b.getPrice()%></td>
			<td>
				<%	if (b.getCategory() == 1) {%>
					<p style="color: red;">JavaSE分类</p> 
				<%} else if (b.getCategory() == 2) {%>
					<p style="color: blue;">JavaEE分类</p> 
                   <%} else {%>
					<p style="color: green;">Java框架分类</p> 
                   <%}%>
			</td>
		</tr>
		<%}%>
	</table>
</body>
</html>
