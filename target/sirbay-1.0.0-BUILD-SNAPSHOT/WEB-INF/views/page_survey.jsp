<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<!-- 만료 여부, 질문 갯수, 질문들, 질문들 별 답변타입 -->

<html>
<head>
<meta charset="UTF-8">
	<title>
		<!-- 만료 여부 -->
		<c:set var="isExpired" value="false" />
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
	<!-- 질문 갯수, 질문들 별 답변 타입 -->
	<script type="text/javascript">
		function add_question(){
			var hr = document.createElement('hr');
			document.getElementById('questionForm').appendChild(hr);
			var div = document.createElement('div');
    		div.innerHTML = document.getElementById('questionForm').innerHTML;
  			document.getElementById('questionForm').appendChild(div);
		}
	</script>
	
	<input type=button onclick="add_question()">
	
	
	<table border = "1" cellpadding = 5 cellspacing = 0 width = 1000>
		<tr>
			<td id = questionForm>
			<div id = question>
				질문
				<br>
				<br>
				<input type = text name = question size = 100>
				<HR>
				답변
				<br>
				<br>
				<!-- 답변 타입 -->
				<c:set var="questionType" value="choice " />
				<c:choose>
					<c:when test="${questionType == 'choice'}">
						객관식
					</c:when>
					<c:otherwise>
						주관식
					</c:otherwise>
				</c:choose>
				</div>
			</td>
		</tr>
	</table>

</body>
</html>