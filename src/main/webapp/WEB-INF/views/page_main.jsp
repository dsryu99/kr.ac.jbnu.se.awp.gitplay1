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
	<div id = "login">
		<div id = "left">
			<c:import url = "page_login.jsp" charEncoding="UTF-8">
			</c:import>
		</div>
	</div>
	
	<div id = "donelogin" style = "display:none">
		<c:import url = "page_done_login.jsp" charEncoding = "UTF-8">
		</c:import>
	</div>
	
	<div id = "signUp">
		<%--회원가입 페이지로 가는 버튼 --%>
		<form method = post action = '<%--signUp.jsp --%>'>
			<input type = "button" value = "signUp">
			<br>
		</form>
	</div>
	
	<div id = "myPage">
		<%-- 마이페이지로 가는 버튼 --%>
		<form method = post action=''<%--page_myProflie.jsp --%>'>
			<input type = "button" value = "MyPage">
			<br>
		</form>
	</div>
	
	<div id ="createSurvey">
		<form method = post action = '<%--page_survey_create--%>'>
			<input type = "submit" value = "createSurvey">
			<br>
		</form>
	</div>
	
	<ul>
		<li><a href ="<%--page_survey--%>">aaa</a><br></li>
		<li><a href ="<%--page_survey--%>">bbb</a><br></li>
		<li><a href ="<%--page_survey--%>">ccc</a><br></li>
	</ul>
</div>
</body>
</html>
