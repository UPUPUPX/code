<%@ page language="java" pageEncoding="GBK"%>
<%@taglib prefix="itcast" uri="/simpleTag"%>
<html>
	<head>
		<title>choose when otherwise tag</title>
	</head>
	<body>
		<itcast:choose>
			<itcast:when test="${param.hobby=='badminton' }">
        		你的爱好是羽毛球
			</itcast:when>
			<itcast:when test="${param.hobby=='football' }">
       		你的爱好是足球
			</itcast:when>
			<itcast:when test="${param.hobby=='basketball' }">
        		你的爱好是篮球
        	    </itcast:when>
			<itcast:otherwise>
        		要加强体育锻炼哦
			</itcast:otherwise>
		</itcast:choose>
	</body>
</html>
