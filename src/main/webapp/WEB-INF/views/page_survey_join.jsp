<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 설문 내용 DB 저장 + 메인 페이지로 이동 action -->	
	<p>${surveyTitle}</p>
	<form action = "/sirbay/survey/join/complete" method="post">
		<input type="hidden" value="${surveyId}" name="surveyId"/>
		<c:forEach var="question" items="${questions}" varStatus="questionStatus">
			<br>
			<hr style="border: solid 2px blue;">
			<!-- 질문 제목 -->
			<!-- 질문 1, 2, 3 -->
			질문 ${question.questionNum}
			<br>
			<br>
			${question.questionDesc}
			<HR>
			답변
			<br>
			<br>
			<!-- 질문 답변 타입 -->
			<!-- 답변 이름 정해야함 -->
			<c:if test="${question.isMultipleChoiceQuestion == true}">
				<!-- 객관식 -->
				<c:forEach var="multipleQuestion" items="${multipleQuestions}" varStatus="answerStatus">
					<c:forEach var="Question" items="${multipleQuestion}" varStatus="answerStatus">
						<c:if test="${Question.questionNum == question.questionNum}">
							<input type = radio value = "${Question.itemContent}" name = "multipleAnswer${question.questionNum}" required>${Question.itemContent}</input>
						</c:if>
					</c:forEach>
				</c:forEach>
			</c:if>
			<c:if test="${question.isMultipleChoiceQuestion == false}">
				<!-- 주관식 -->
				<input type = text size = 100 name="subjectiveAnswer${question.questionNum}" required> 
			</c:if>
		</c:forEach>
		
		<hr style="border: solid 2px blue;">
		
		<input type = "submit" value = "작성완료"/>
		
		</form>
</body>
</html>