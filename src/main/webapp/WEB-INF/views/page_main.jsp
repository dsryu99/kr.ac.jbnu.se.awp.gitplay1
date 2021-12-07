<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page
	import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">


<link rel="stylesheet" type="text/css" href="resources/style.css">


<meta charset="UTF-8">
<title>Home</title>
</head>
<body>


	<!-- 로고 -->
	<div id="logoArea" align="center" style="width: 100%; height: 50px">
		<!-- 리다이렉트 -->
		<a href="${pageContext.request.contextPath}"> <img
			src="resources/logo.png" alt="logo" width="100px" height="50px">
		</a>
	</div>

	<div id="logoLine"></div>

	<div id="contentsArea">

		<div id="upperArea">

			<div id="noticeArea"
				style="text-align: left;">

				<h3>
					<공지사항>
				</h3>
				<br> 페이지가 개설되었습니다.<br> 결과가 항상 누적되고, 언제든 누구나 참여할 수 있는 설문조사
				사이트 입니다.<br> <br> * 설문 생성을 위해서는 로그인이 필요합니다. <br> * 기타
				문의 사항은 ljr0683@gmail.com를 이용해 주세요.<br>

			</div>

			<div id="loginArea" style="float: left">
				<font size=5px style="">로그인</font> <br> <br>
				<c:choose>
					<c:when test="${isLogin == false}">
						<!-- 미 로그인 시 -->
						<div id="login">
							<form method="post" action="/sirbay/login" name="login_form">
								<div class="mx-auto id-bar input-group mb-3">
									<input type="text" name="id" class="form-control"
										placeholder="아이디" aria-label="아이디"
										aria-describedby="button-addon2">
								</div>

								<div class="mx-auto password-bar input-group mb-3">
									<input type="password" name="pwd" class=" form-control"
										placeholder="비밀번호" aria-label="비밀번호"
										aria-describedby="button-addon2">
								</div>

								<div class="login-Button input-group mb-3" style="left: 173px;">
									<button type="submit" class="btn btn-light">로그인</button>
								</div>
							</form>

							<form method=post action="/sirbay/register">
								<div class="register-Button input-group mb-3"
									style="bottom: 53px; left: 73px;">
									<button type="submit" class="btn btn-light">회원가입</button>
								</div>
							</form>
						</div>
					</c:when>
					<c:otherwise>
						<!-- 로그인 시 -->
						<div id="donelogin">
							${username} 님

							<form method="get" action="/sirbay/myPage">
								<div class="myPage-Button input-group mb-3" style="top: 23px;">
									<button type="submit" class="btn btn-light">마이페이지</button>
								</div>
							</form>
							<!-- 로그아웃 -->
							<form method="post" action="/sirbay/logout">
								<div class="logout-Button input-group mb-3" style="top: 26px;">
									<button type="submit" class="btn btn-light">로그아웃</button>
								</div>
							</form>

						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div style="clear: both:"></div>


		<br>

		<!-- 본문 -->
		<div id=surveyArea style="text-align: left">
			<table class="table">
				<thead class="thead-dark">
					<th scope="col">#</th>
					<th scope="col" width="50%" style="text-align: center">제목</th>
					<th scope="col" style="text-align: center">생성일</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</thead>
				<tbody>
					<c:forEach var="survey" items="${surveys}" varStatus="surveyStatus">
						<tr>
							<td>${surveyStatus.index + 1}</td>
							<td><a>${survey.surveyTitle}</a></td>
							<td style="text-align: center">${survey.surveyCreatedTime}</td>
							<td><input style="float: right" type="button"
								class="btn btn-light btn-sm"
								onclick="location.href='/sirbay/survey/join?id=${survey.surveyID}&&title=${survey.surveyTitle}'"
								value="설문참여" /> &nbsp; <input style="float: right"
								type="button" class="btn btn-light btn-sm"
								onclick="location.href='/sirbay/survey/result?id=${survey.surveyID}&&title=${survey.surveyTitle}'"
								value="결과보기" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<br>
			<form method="post" action="/sirbay/survey/create">
				<button type="submit" class="btn btn-primary" style="float: right;">설문
					생성</button>
			</form>
		</div>

		<br>

		<!-- 버튼 기능 추가해야함 -->
		<div id=buttonArea style="display: inline-block">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href=" "> < </a></li>
					<c:forEach var="index" begin="${min}" end="${max}" step="1">
						<li class="page-item"><a class="page-link" id="${index+1}"
							href="${pageContext.request.contextPath}">${index+1}</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link" href=" "> > </a></li>
				</ul>
			</nav>
		</div>

	</div>

</body>
</html>
