<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<div id = "wrap">
	<div id = "header">
		<center>
		<H2>Sir,bay</H2>
		<hr>
	</div>
	<c:choose>
		<c:when test="${isLogin == 'false'}">
			<div id = "login">
				<div id = "left">
				<c:import url = "page_login.jsp" charEncoding="UTF-8" />
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div id = "donelogin">
				<c:import url = "page_done_login.jsp" charEncoding = "UTF-8" />
			</div>
		</c:otherwise>
	</c:choose>
	
	<div id = "signUp">
		<%--회원가입 페이지로 가는 버튼 --%>
		<form method = post action = "/sirbay/register">
			<input type = "submit" value = "signUp">
			<br>
		</form>
	</div>
	
	<div id = "myPage">
		<%-- 마이페이지로 가는 버튼 --%>
		<form method = post action='/sirbay/myPage'>
			<input type = "submit" value = "MyPage">
			<br>
		</form>
	</div>
	
	<div id ="createSurvey">
		<form method = post action = '/sirbay/survey/create'>
			<input type = "submit" value = "createSurvey">
			<br>
		</form>
	</div>
	
	<ul>
		<li><a href ="${pageContext.request.contextPath}/survey">aaa</a><br></li>
		<li><a href ="${pageContext.request.contextPath}/survey">bbb</a><br></li>
		<li><a href ="${pageContext.request.contextPath}/survey">ccc</a><br></li>
	</ul>
</div>
</body>
</html>
