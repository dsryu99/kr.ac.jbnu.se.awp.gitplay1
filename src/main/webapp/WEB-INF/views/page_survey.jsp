<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%!
	boolean isExpired = false;
%>


<html>
<head>
<meta charset="UTF-8">
	<title>
		<c:choose>
			<c:when test="${isExpired}">
				<c:out value="결과 확인" />
			</c:when>
			<c:otherwise>
				<c:out value="설문 참여" />
			</c:otherwise>
		</c:choose>
	
	</title>
</head>
<body>

</body>
</html>