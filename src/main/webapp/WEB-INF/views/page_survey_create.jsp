<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:set var="isMultipleChoiceQuestion" value="false" />

<html>
<head>
<meta charset="EUC-KR">
<title>page_survey_create</title>
</head>
<body>
<div id = "wrap">
	<table>
		<div id = "questionBox">
			<div id = "radioBox">
				<td>
					<input type = "radio" name = "subject" value = "객관식" checked> 객관식
					<input type = "radio" name = "multiple" value = "주관식" > 주관식
				</td>
				isMultipleChoiceQuestion = $('input[name = subject]').is(':checked');
				<c:if test = "${isMultipleChoiceQuestion != 'on' }">
				 	<textarea id="content" name="content" rows="3" cols="35"></textarea>
				</c:if>
				
				<c:if test = "${isMultipleChoiceQuestion == 'on' }">
					
				</c:if>
			</div>
		
		</div>
	</table>
	
	
</div>

</body>
</html>