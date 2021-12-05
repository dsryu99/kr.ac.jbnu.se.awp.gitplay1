<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="nowPage" value="10" />
<c:set var="maxPage" value="11" />

<script type="text/javascript">

	function getThisMinPage(){
		var tmp;
		if(${nowPage} % 5 == 0){
			tmp = ${nowPage} - 4;	
		}
		else{
			tmp = ${nowPage} - (${nowPage} % 5) + 1;	
		}
		console.log(tmp);
		return tmp;
	}

	var thisMinPage = getThisMinPage(); 
	

	function getThisMaxPage(){
		
		if(thisMinPage + 4 <= ${maxPage}){
			return thisMinPage + 4;
		}
		else{
			return ${maxPage};
		}
		
		/* if(tmp + 4 <= ${maxPage}){
			console.log([tmp, tmp + 1, tmp+2, tmp+3, tmp+4]);
			return [tmp, tmp + 1, tmp+2, tmp+3, tmp+4];
		}
		else{
			var tmp2 = ${maxPage} - tmp;
			var list = [];
			for(i = 0;i <= tmp2;i++){
				list[i] = tmp + i;
				console.log(list[i]);
			}
			return list;
		} */
	}
	
	var thisPageMax = getThisMaxPage();
</script>



<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel='stylesheet' href='resources/Style.css'>

<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>


<!-- 로고 -->
<div id = "logoArea" align = "center" style = "width: 100%; height: 50px">
	<!-- 리다이렉트 -->
	<a href = "${pageContext.request.contextPath}">
		<img src = "resources/logo.png" alt = "logo" width = "100px" height = "50px" >
	</a>
</div>

<hr id = "logoLine" >

<div id = "contentsArea">

	<div id = "upperArea">
	
		<!-- 공지사항 -->
		<div id = NoticeArea></div>

		<!-- 로그인 -->
		<div id = "loginArea">
			<font size = 5px style = "bold" >로그인</font>
			<br>
			<br>
			<c:choose>
				<c:when test="${isLogin == false}">
				<!-- 미 로그인 시 -->
					<div id = "login">
					<!-- 로그인 버튼 -->
						<form method = "post" action = "/sirbay/login">
							<input type = "submit" value = "로그인" style = "float:right; height = 50px">
							<input type = "text" name = "id" placeholder = "아이디" size = 20>
						<br>
						<br>
							<input type = "password" name = "pwd" placeholder = "비밀번호" size = 20> 
						</form>
					<!-- 회원가입 버튼 -->
						<form method = post action = "/sirbay/register" >
							<input type = "submit" value = "회원 가입">
						</form>
					</div>
				</c:when>
				<c:otherwise>
				<!-- 로그인 시 -->
					<div id = "donelogin">
						${id} 님
					 
						<!-- 마이페이지 -->
						<a href="${pageContext.request.contextPath}/myPage" onClick = "log(this);">
							<font size = 2em>
							내정보
							</font>
						</a> 				
						<br>
						<br>
						
						<!-- 로그아웃 -->
						<form method = "post" action = "/sirbay/logout" style = "float:bottom">
							<input type = "submit" value = "로그아웃">
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		</div>	
	</div>
	
	<br>

	<!-- 본문 -->
	<div id = surveyArea>
		<c:forEach var="survey" items="surveyList" varStatus="surveyStatus">
			<a id = "${surveyStatus.current}" href = "${pageContext.request.contextPath}">
				<!-- 화면 보여주는 거 수정 필요(이름...) -->
				${survey}
			</a>
		</c:forEach>

<%-- 		<ul style = "list-style: none;">
			<li><a href ="${pageContext.request.contextPath}/survey">소프트웨어공학과 3학년 설문조사</a><br></li>
			<li><a href ="${pageContext.request.contextPath}/survey">소프트웨어공학과 2학년 설문조사</a><br></li>
			<li><a href ="${pageContext.request.contextPath}/survey">소프트웨어공학과 1학년 설문조사</a><br></li>
		</ul> --%>
		
		<br>
		<form method = "post" action = "/sirbay/survey/create"><input type = submit value = "설문 생성" style = "float: right"></form>
	</div>
	
	<div id = buttonArea>
		<input type = button onClick = "" value = "< 이전">
		<!-- 페이지 수 불러오기 -->
		<c:forEach var="index" begin= "${min}" end = "${max}" step = "1">
			<a id = "${index}" href = "${pageContext.request.contextPath}">
				${index}
			</a>
		</c:forEach>
		<input type = button onClick = "" value = "다음 >">
	</div>
</div>
	
</body>
</html>
