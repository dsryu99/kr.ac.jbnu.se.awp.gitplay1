<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="logoArea" align="center">
		<!-- 리다이렉트 -->
		<form method="get" action="">
			<!-- 이미지 로고 출력 -->
			<input type="image" src="../resources/logo.png" alt="logo"
				style="width: 200xp; height: 50px">
		</form>
	</div>

	<hr id="logoLine">

	<div id="contentsArea">
		<div id="surveysArea" class="input-form main">
			<c:forEach var="question" items="questionList"
				varStatus="questionStatus">
				<br>
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
					<c:forEach var="multipleChoiseQuestionItem"
						items="multipleChoiseQuestionItemList" varStatus="answerStatus">
						<!-- 객관식 문항, 객관식 문항 별 선택 횟수-->
				${answerStatus.count}번 ${multipleChoiseQuestionItem.itemContent} <!-- 몇 번 선택됨 -->
					</c:forEach>
				</c:if>
				<c:if test="${isMultipleChoiceQuestion == 'false'}">
					<!-- 주관식 -->
					<c:forEach var="surveyAnswer" items="surveyAnswerList"
						varStatus="answerStatus">
						<!-- 주관식 문항-->
				${status.count}. ${surveyAnswer.answer} 
			</c:forEach>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>