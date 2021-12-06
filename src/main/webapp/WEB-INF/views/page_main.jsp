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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	
<link rel="stylesheet" type="text/css" href="resources/style.css">


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
						<form method = "post" action = "/sirbay/login" name="login_form">
							<div class="mx-auto id-bar input-group mb-3">
						        <input type="text" name = "id" class="form-control" placeholder="아이디" aria-label="아이디" aria-describedby="button-addon2">
						    </div>
						
						    <div class="mx-auto password-bar input-group mb-3">
						        <input type="password" name = "pwd" class=" form-control" placeholder="비밀번호" aria-label="비밀번호" aria-describedby="button-addon2">
						    </div>
						
						    <div class="login-Button input-group mb-3" style = "left: 173px;">
						        <button type="submit" class="btn btn-light">로그인</button>
						    </div>
					    </form>
					    
					    <form method = post action = "/sirbay/register">
					    	<div class="register-Button input-group mb-3" style = "bottom: 53px; left: 73px;">
						        <button type="submit" class="btn btn-light">회원가입</button>
						    </div>
						</form>
						
					</div>
					
				</c:when>
				<c:otherwise>
				<!-- 로그인 시 -->
					<div id = "donelogin">
						${username} 님
						
						<form method = "post" action = ""> <!-- 액션 넣어주세요 응기잇 -->
						 	<div class="myPage-Button input-group mb-3" style="top: 23px;" >
							      <button type="submit" class="btn btn-light">마이페이지</button>
							</div>
						</form>
						<!-- 로그아웃 -->
						<form method = "post" action = "/sirbay/logout" >
							<div class="logout-Button input-group mb-3" style="top: 26px;">
						        <button type="submit" class="btn btn-light">로그아웃</button>
						    </div>
						</form>
						
					</div>
				</c:otherwise>
			</c:choose>
		</div>	
	</div>
	
	<br>

	<!-- 본문 -->
	<div id = surveyArea>
		<c:forEach var="survey" items="${surveys}"  varStatus="surveyStatus">
			<!-- 화면 보여주는 거 수정 필요(이름...) -->
			${survey.surveyTitle}
			<input type="button" onclick="location.href='/sirbay/survey/join?id=${survey.surveyID}&&title=${survey.surveyTitle}'" value="설문참여"/>
			<input type="button" onclick="location.href='/sirbay/survey/result?id=${survey.surveyID}&&title=${survey.surveyTitle}'" value="결과보기"/>
			<br>
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
