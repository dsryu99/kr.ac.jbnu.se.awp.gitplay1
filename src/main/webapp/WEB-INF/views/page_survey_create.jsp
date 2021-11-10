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
<H1>��������</H1>
<HR>

<div id = "wrap">

	<form action = "/sirbay/survey/create/complete" method="post">
	
		<div id = "surbeyTitle">
			���� ���� : <input type = "text" name ="title" size = 100><br><br>
		</div>
		
		<hr style="border: solid 2px blue;">
	
		<div id = "questionBox">
			
			<br>
			<div id = "qusetion">
				���� : <input type = "text" name ="title" size = 100><br><br>
			</div>
			
			<br>
		
			<div id = "radioBox">
				<input type = "radio" name = "subject" value = "������" onclick='(checkRadioButton(event))'> ������
				<input type = "radio" name = "subject" value = "�ְ���" onclick='(checkRadioButton(event))'> �ְ���
			</div>

			<div id = "answer">
									
				<div id = 'sub'>
					1 <input type = "text" size = 100/>
					<br>
					<br>
					2 <input type = "text" size = 100/>
					<br>
					<br>
					3 <input type = "text" size = 100/>
					<br>
					<br>
					4 <input type = "text" size = 100/>
					<br>
					<br>
					5 <input type = "text" size = 100/>
					<br>
				</div>
			</div>
			<hr style="border: solid 2px blue;">
		</div>
		
		<div id = 'result'></div>
		<input type ="button" value = "plus" onclick = "add_div()">
		
		<%-- ���� �ۼ��Ѱ� ���� --%>
		
		<input type = submit name = "submit" value = "submit">
	</form>
</div>

<script>
	document.getElementById("sub").style.display = "none";
					
	function checkRadioButton(event){
				
		if(event.target.value == "������"){
			document.getElementById("sub").style.display = "block";
		}
					
		else{
			document.getElementById("sub").style.display = "none";
		}
	}
				
	function add_div(){
		var div = document.createElement('div');
			
		var questionBox = document.createElement('questionBox');
		
		
		div.innerHTML = document.getElementById('questionBox').innerHTML;
		
		document.getElementById('result').appendChild(div);
	}
</script>


</body>
</html>