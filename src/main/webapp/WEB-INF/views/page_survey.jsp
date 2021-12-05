<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<!-- 만료 여부, 질문 갯수, 질문들, 질문들 별 답변타입, 설문 제목-->

<!-- 임시 변수 -->
<c:set var="isExpired" value="true" />
<c:set var="questionDesc" value="기말고사 목표 점수는 몇 점인가요?" />
<c:set var="isMultipleChoiceQuestion" value="false" />
<c:set var="surveyName" value="소프트웨어공학과 3학년 설문조사" />

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
	
	<!-- 설문 제목 -->
	<div id = "surbeyTitle">
		주제 : ${surveyName}
	</div>
	
	<hr style="border: solid 2px blue;">
	
	<!-- 만료 여부 -->
	<c:if test="${isExpired == 'true'}">
		<!-- 결과 확인 페이지 -->
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
		
		<hr style="border: solid 2px blue;">
			
	</c:if>
	
	
	<c:if test="${isExpired == 'false'}">
		<!-- 설문 참여 페이지 -->
		
	<!-- 설문 내용 DB 저장 + 메인 페이지로 이동 action -->	
	<form action = "/sirbay/survey/join" method="post" name = " ">
		
		<c:forEach var="question" items="questionList" varStatus="questionStatus">
			<br>
			<hr style="border: solid 2px blue;">
			<!-- 질문 제목 -->
			<%-- 질문 ${questionStatus.count} --%>
			질문 2
			<br>
			<br>
			${questionDesc}
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
					<input type = checkbox value = "${multipleChoiseQuestionItem.itemContent}" name = "multipleAnswer" required>
				</c:forEach>
			</c:if>
			<c:if test="${isMultipleChoiceQuestion == 'false'}">
				<!-- 주관식 -->
				<c:forEach var="surveyAnswer" items="surveyAnswerList" varStatus="answerStatus">
					<input type = text size = 100 required> 
				</c:forEach>
			</c:if>
		</c:forEach>
		
		<hr style="border: solid 2px blue;">
		
		<input type = "submit" value = "작성완료"/>
		
		</form>
		
	</c:if>
</body>
</html>