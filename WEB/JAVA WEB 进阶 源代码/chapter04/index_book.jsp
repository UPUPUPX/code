<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+
":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index_book.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
	<a href="<%=request.getContextPath()%>/BookServlet">ȫ��ͼ��</a><br/>
	<a href="<%=request.getContextPath()%>/BookServlet?category=1">
         JavaSE����</a><br/>
	<a href="<%=request.getContextPath()%>/BookServlet?category=2">
         JavaEE����</a><br/>
     <a href="<%=request.getContextPath()%>/BookServlet?category=3">
         Java��ܷ���</a><br/>
  </body>
</html>
