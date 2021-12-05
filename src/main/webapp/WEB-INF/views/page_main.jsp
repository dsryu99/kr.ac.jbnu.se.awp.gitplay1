<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="isLogin" value="false" />
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
	

	function getNumList(){
		
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
	
	var thisPageMax = getNumList();
</script>

<style>
	#logoLine{
		border: 0px;
		height: 30px;
		background-color: black;
		border-radius: 5px;
	}
 	#contentsArea{
		width: auto;
		height: auto;
		text-align: center;
	}
	
	#upperArea{
		width: auto;
		height: auto;
		display: inline-block;
	}

	#loginArea{
		box-sizing: border-box;
		width: 300px;
		height: 200px;
		margin: 20px;
		border: 2px solid black;
		border-radius: 10px;
		padding: 2%;
		float: left;
		text-align: left;
	}
	#NoticeArea{
		box-sizing: border-box;
 		width: 800px;
		height: 200px;
		margin: 20px;
		border: 2px solid black;
		border-radius: 10px;
		padding: 2%;
		float: left;
	}
	
	#surveyArea{
		box-sizing: border-box;
		width: 800px;
		height: auto;
		margin: 20px;
		border-right: solid 2px black;
  		border-left: solid 2px black;
		padding: 3%;
		display: inline-block;
	}
</style>

<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>


<!-- 로고 -->
<div id = "logoArea" align = "center" style = "width: 100%; height: 50px">
	<!-- 리다이렉트 -->
	<form method = "get" action="">
		<!-- 이미지 로고 출력 -->
		<input type = "image" src = "" alt = "logo">
	</form>
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
				<c:when test="${isLogin == 'false'}">
				<!-- 미 로그인 시 -->
					<div id = "login">
					<!-- 로그인 버튼 -->
						<form method = "post" action = "/sirbay/login">
							<input type = "submit" value = "로그인" style = "float:right; height = 50px">
							<input type = "text" name = "id" placeholder = "아이디" size = 20>
						<br>
						<br>
							<input type = "text" name = "pwd" placeholder = "비밀번호" size = 20> 
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
						<a href="javascript:void(0);" onClick = "log(this);">
							<font size = 2em>
							내정보
							</font>
						</a> 				
						<br>
						<br>
						
						<!-- 로그아웃 -->
						<form method = "get" action = "/sirbay/logout" style = "float:bottom">
							<input type = "submit" value = "로그아웃">
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		</div>	
	</div>

	<!-- 본문 -->
	<div id = surveyArea style = "float: center">
<%-- 		<c:forEach var="question" items="questionList" varStatus="questionStatus">
			질문 ${questionStatus.count}
			<br>
			<br>
			<!-- 질문 제목 -->
			${questionDesc}
			<HR>
			답변
			<br>
			<br>
			<!-- 질문 답변 타입 -->
			<c:if test="${isMultipleChoiceQuestion == 'true'}">
				<!-- 객관식 -->
				<c:forEach var="multipleChoiseQuestionItem" items="multipleChoiseQuestionItemList" varStatus="answerStatus">
					<!-- 객관식 문항, 객관식 문항 별 선택 횟수-->
					${answerStatus.count}번 ${multipleChoiseQuestionItem.itemContent} <!-- 몇 번 선택됨 -->
				</c:forEach>
			</c:if>
			<c:if test="${isMultipleChoiceQuestion == 'false'}">
				<!-- 주관식 -->
				<c:forEach var="surveyAnswer" items="surveyAnswerList" varStatus="answerStatus">
					<!-- 주관식 문항-->
					${status.count}. ${surveyAnswer.answer} 
				</c:forEach>
			</c:if>
		</c:forEach> --%>
	
		<ul style = "list-style: none;">
			<li><a href ="${pageContext.request.contextPath}/survey">소프트웨어공학과 3학년 설문조사</a><br></li>
			<li><a href ="${pageContext.request.contextPath}/survey">소프트웨어공학과 2학년 설문조사</a><br></li>
			<li><a href ="${pageContext.request.contextPath}/survey">소프트웨어공학과 1학년 설문조사</a><br></li>
		</ul>
	</div>
	
	<div id = buttonArea>
		<input type = button onClick = "" value = "< 이전">
		<c:forEach var="index" begin="${thisMinPage}" end = "10" step = "1">
			${index}
			<!-- <a value = "${index}" onClick = "" id = "${i}"></a> -->
		</c:forEach>
		<input type = button onClick = "" value = "다음 >">
	</div>
</div>
	
</body>
</html>
