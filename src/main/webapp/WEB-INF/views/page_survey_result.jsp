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
	<c:forEach var="question" items="questionList" varStatus="questionStatus">
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
	</c:forEach>
</body>
</html>