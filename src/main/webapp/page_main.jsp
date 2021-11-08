<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String id = (String)session.getAttribute("id");
	String log_jsp = "";
	if(id==null)
		log_jsp = "login.jsp";
	else
		log_jsp = "logout.jsp";
%>
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
	<div id = "container">
		<div id = "left">
			<jsp:include page = "<%=log_jsp %>"></jsp:include>
		</div>
		
	</div>
	
	<div id = "right">
		<div id = "left">
		<form method = post action = 'signUp.jsp'>
			<input type = "submit" value = "signUp">
		</form>
		</div>
	</div>

</div>
</body>
</html>
