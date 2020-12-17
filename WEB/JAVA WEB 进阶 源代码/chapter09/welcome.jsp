<%@ page language="java" pageEncoding="GBK"%>
<%@taglib uri="/simpleTag" prefix="itcast"%>
<html>
<head>
<title>Welcome Tag</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		if (username != null) {
			session.setAttribute("user", username);
		}
	%>
	欢迎光临本站!
	<itcast:welcome>
	亲，您的昵称为:${user }
	</itcast:welcome>
</body>
</html>
