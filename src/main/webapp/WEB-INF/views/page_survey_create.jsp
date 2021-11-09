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
	<form action = "/sirbay/survey/create/complete" method="post">
	<div id = "questionBox">
		<div id = "radioBox">
				<input type = "radio" name = "subject" value = "객관식" onclick='(checkRadioButton(event))'> 객관식
				<input type = "radio" name = "subject" value = "주관식" onclick='(checkRadioButton(event))'> 주관식
				<div id = 'textarea'>
					<textarea id="content" name="content" rows="3" cols="35"></textarea>
				</div>
				<div id = 'sub'>
					<input type = "text" />
					<input type = "text" />
					<input type = "text" />
					<input type = "text" />
					<input type = "text" />
				</div>
				
				
		</div>
		
		<script>
				document.getElementById("textarea").style.display = "none";
				document.getElementById("sub").style.display = "none";
				
				function checkRadioButton(event){
					if(event.target.value == "객관식"){
						document.getElementById("textarea").style.display = "none";
						document.getElementById("sub").style.display = "block";
					}
					else{
						document.getElementById("sub").style.display = "none";
						document.getElementById("textarea").style.display = "block";
					}
				}
				
				function add_div(){
					var div = document.createElement('div');
					
					div.innerHTML = document.getElementById('questionBox').innerHTML;
					document.getElementById('result').appendChild(div);
				}
		</script>
		
	</div>
	
	<div id = 'result'></div>
	<input type ="button" value = "plus" onclick = "add_div()">
	
	<%-- 설문 작성한거 제출 --%>
	
		<input type = submit name = "submit" value = "submit">
	</form>
</div>

</body>
</html>