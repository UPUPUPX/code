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
	��ӭ���ٱ�վ!
	<itcast:welcome>
	�ף������ǳ�Ϊ:${user }
	</itcast:welcome>
</body>
</html>
