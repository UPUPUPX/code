<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="itcast" uri="http://www.itcast.cn" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
      用户名:${name}<br />
      留言内容:${itcast:filter(message)}
</body>
</html>
