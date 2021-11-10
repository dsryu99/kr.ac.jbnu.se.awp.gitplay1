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
		<div id = "surbeyTitle">
			���� ���� : <input type = "text" name ="title"><br><br>
		</div>
	
		<div id = "questionBox">
			<div id = "radioBox">
				<input type = "radio" name = "subject" value = "������" onclick='(checkRadioButton(event))'> ������
				<input type = "radio" name = "subject" value = "�ְ���" onclick='(checkRadioButton(event))'> �ְ���
				
					<div id = 'textarea'>
					���� : <input type = "text" name ="title"><br><br>
						<textarea id="content" name="content" rows="3" cols="35"></textarea>
					</div>
					
					<div id = 'sub'>
					���� : <input type = "text" name ="title"><br><br>
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
						
						if(event.target.value == "������"){
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
		
		<%-- ���� �ۼ��Ѱ� ���� --%>
		
		<input type = submit name = "submit" value = "submit">
	</form>
</div>

</body>
</html>