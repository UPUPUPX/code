<%@ page language="java" pageEncoding="GBK"%>
<%@taglib prefix="itcast" uri="/simpleTag"%>
<html>
	<head>
		<title>choose when otherwise tag</title>
	</head>
	<body>
		<itcast:choose>
			<itcast:when test="${param.hobby=='badminton' }">
        		��İ�������ë��
			</itcast:when>
			<itcast:when test="${param.hobby=='football' }">
       		��İ���������
			</itcast:when>
			<itcast:when test="${param.hobby=='basketball' }">
        		��İ���������
        	    </itcast:when>
			<itcast:otherwise>
        		Ҫ��ǿ��������Ŷ
			</itcast:otherwise>
		</itcast:choose>
	</body>
</html>
