<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<!-- 만료 여부, 질문 갯수, 질문들, 질문들 별 답변타입 -->

<!-- 임시 변수 -->
<c:set var="isExpired" value="false" />
<c:set var="questionDesc" value="truetest" />
<c:set var="isMultipleChoiceQuestion" value="false" />


<html>
<head>
<meta charset="UTF-8">
	<title>
		<c:choose>
			<c:when test="${isExpired == 'true'}">
				<c:out value="결과 확인" />
			</c:when>
			<c:otherwise>
				<c:out value="설문 참여" />
			</c:otherwise>
		</c:choose>
	</title>
</head>
<body>
	<H1>설문</H1>
	<HR>
	
	<!-- 만료 여부 -->
	<c:if test="${isExpired == 'true'}">
		<!-- 결과 확인 페이지 -->
		<c:forEach var="question" items="questionList" varStatus="qestionStatus">
			<br>
			<hr style="border: solid 2px blue;">
		
			질문 ${qestionStatus.count}
			<br>
			<br>
			<!-- 질문 제목 -->
			${qestionDesc}
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
		<hr style="border: solid 2px blue;">
	</c:if>
	
	
	<c:if test="${isExpired == 'false'}">
		<!-- 설문 참여 페이지 -->
		<c:forEach var="question" items="questionList" varStatus="qestionStatus">
			<br>
			<hr style="border: solid 2px blue;">
			<!-- 질문 제목 -->
			질문 ${qestionStatus.count} ${qestionDesc}
			<br>
			<br>
			<HR>
			답변
			<br>
			<br>
			<!-- 질문 답변 타입 -->
			<!-- 답변 이름 정해야함 -->
			<c:if test="${isMultipleChoiceQuestion == 'true'}">
				<!-- 객관식 -->
				<c:forEach var="multipleChoiseQuestionItem" items="multipleChoiseQuestionItemList" varStatus="answerStatus">
					<!-- 객관식 문항, 객관식 문항 별 선택 횟수-->
					<input type = checkbox  value = "${multipleChoiseQuestionItem.itemContent}">
				</c:forEach>
			</c:if>
			<c:if test="${isMultipleChoiceQuestion == 'false'}">
				<!-- 주관식 -->
				<c:forEach var="surveyAnswer" items="surveyAnswerList" varStatus="answerStatus">
					<input type = text size = 100> 
				</c:forEach>
			</c:if>
		</c:forEach>
		<hr style="border: solid 2px blue;">
	</c:if>
</body>
</html>