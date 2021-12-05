<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 설문 내용 DB 저장 + 메인 페이지로 이동 action -->	
	<form action = "/sirbay/survey/join" method="post" name = " ">
		
		<c:forEach var="question" items="questionList" varStatus="questionStatus">
			<br>
			<hr style="border: solid 2px blue;">
			<!-- 질문 제목 -->
			<!-- 질문 1, 2, 3 -->
			질문 ${question.~~ }
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
</body>
</html>