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
<link rel="stylesheet" type="text/css" href="resources/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "logoArea" align = "center" style = "width: 100%; height: 50px">
	<!-- 리다이렉트 -->
		<a href = "${pageContext.request.contextPath}">
			<img src = "../resources/logo.png" alt = "logo" width = "100px" height = "50px" >
		</a>
	</div>
	
	<div id = "logoLine" ></div>

	<div id="contentsArea">
		<div id="surveysArea" class="input-form main"
			style="display: inline-block; text-align:left">
			<!-- 설문 내용 DB 저장 + 메인 페이지로 이동 action -->
			<p>${surveyTitle}</p>
			<form action="/sirbay/survey/join/complete" method="post">
				<input type="hidden" value="${surveyId}" name="surveyId" />
				<c:forEach var="question" items="${questions}"
					varStatus="questionStatus">
					<br>
					<hr>
					<!-- 질문 제목 -->
					<!-- 질문 1, 2, 3 -->
					질문 ${question.questionNum}. ${question.questionDesc}
					<br>
					<br>
					<!-- 질문 답변 타입 -->
					<!-- 답변 이름 정해야함 -->
					<c:if test="${question.isMultipleChoiceQuestion == true}">
						<!-- 객관식 -->
						<c:forEach var="multipleQuestion" items="${multipleQuestions}"
							varStatus="answerStatus">
							<c:forEach var="Question" items="${multipleQuestion}"
								varStatus="answerStatus">
								<c:if test="${Question.questionNum == question.questionNum}">
									<input  type=radio value="${Question.itemContent}"
										name="multipleAnswer${question.questionNum}" required> ${Question.itemContent}</input>
										<br>
								</c:if>
							</c:forEach>
						</c:forEach>
					</c:if>
					<c:if test="${question.isMultipleChoiceQuestion == false}">
						<!-- 주관식 -->
						<input class="form-control" type=text size=100
							name="subjectiveAnswer${question.questionNum}" required>
					</c:if>
				</c:forEach>

				<hr>

				<input class = "btn btn-light" type="submit" value="작성완료" style = "float: right"/>

			</form>

		</div>


	</div>


</body>
</html>