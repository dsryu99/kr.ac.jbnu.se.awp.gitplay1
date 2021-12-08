<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
a[class=text] {
	font-weight: bold;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../resources/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="logoArea" align="center" style="width: 100%; height: auto">
		<!-- 리다이렉트 -->
		<a href="${pageContext.request.contextPath}"> <img
			src="../resources/logo.png" alt="logo" width="200px" height="80px">
		</a>
	</div>

	<div id="logoLine"></div>

	<div id="contentsArea">
		<div id="surveysArea" class="input-form main"
			style="display: inline-block; text-align:left; width: 800px">
			<p>
				<a class="text" style="font-size: 24px">${title}</a>
			</p>
			<c:forEach var="question" items="${questions}"
				varStatus="questionStatus">
				<hr style="margin-top:40px;">
				<br>
				<a class="text" style="font-size: 18px">질문 ${question.questionNum}.
					<span style="font-size: 16px;font-weight: normal;">${question.questionDesc}</span></a>

				<br>
				<br>
				
				<p><a class="text">답변</a></p>
				<!-- 질문 답변 타입 -->
				<c:if test="${question.isMultipleChoiceQuestion == true}">
					<!-- 객관식 -->
					<c:forEach var="multipleQuestion" items="${multipleQuestions}" varStatus="answerStatus">
						<c:forEach var="Question" items="${multipleQuestion}" varStatus="answerStatus">
							<c:if test="${Question.questionNum == question.questionNum}">
									${Question.itemNum}. ${Question.itemContent}
									<c:forEach var="answer" items="${answers}"
									varStatus="answerStatus">
									<c:if test="${Question.itemContent == answer.answer}">
										<span style="font-size:12px; font-weight: 700"> - 응답수: ${answer.count}</span>
									</c:if>
									<br>
								</c:forEach>
							</c:if>
						</c:forEach>
					</c:forEach>
				</c:if>
				<c:if test="${question.isMultipleChoiceQuestion == false}">
					<!-- 주관식 -->
					<c:forEach var="answer" items="${answers}" varStatus="answerStatus">
						<!-- 주관식 문항-->
						<c:if test="${question.questionNum == answer.questionNum}">
							● ${answer.answer}<br><div style="font-size:12px; font-weight: 700; margin-bottom: 10px;"> - 응답수: ${answer.count}</div>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>