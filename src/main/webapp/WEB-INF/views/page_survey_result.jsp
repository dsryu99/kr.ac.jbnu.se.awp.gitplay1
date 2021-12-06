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

	<p>${title}</p>
	<div id="contentsArea">
		<div id="surveysArea" class="input-form main">
			<c:forEach var="question" items="${questions}" varStatus="questionStatus">
				<br>
				질문 ${question.questionNum}. ${question.questionDesc}
				<HR>
				답변
				<br>
				<!-- 질문 답변 타입 -->
				<c:if test="${question.isMultipleChoiceQuestion == true}">
					<!-- 객관식 -->
					<c:forEach var="multipleQuestion" items="${multipleQuestions}"
							varStatus="answerStatus">
							<c:forEach var="Question" items="${multipleQuestion}"
								varStatus="answerStatus">
								<c:if test="${Question.questionNum == question.questionNum}">
									${Question.itemNum}. ${Question.itemContent}
									<c:forEach var="answer" items="${answers}" varStatus="answerStatus">
										<c:if test="${Question.itemContent == answer.answer}">
											${answer.answer} - 응답수: ${answer.count}
										</c:if>
									</c:forEach>
									<br>
								</c:if>
							</c:forEach>
						</c:forEach>
				</c:if>
				<c:if test="${question.isMultipleChoiceQuestion == false}">
					<!-- 주관식 -->
					<c:forEach var="answer" items="${answers}" varStatus="answerStatus">
						<!-- 주관식 문항-->
						<c:if test="${question.questionNum == answer.questionNum}">
							${answer.answer} - 응답수: ${answer.count}
							<br>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>