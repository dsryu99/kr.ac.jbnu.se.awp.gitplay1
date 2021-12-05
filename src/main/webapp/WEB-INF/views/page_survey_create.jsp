<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:set var="isMultipleChoiceQuestion" value="false" />

<html>
<head>
<style>
	#logoLine{
		border: 0px;
		height: 30px;
		background-color: black;
		border-radius: 5px;
	}
	 #contentsArea{
		width: auto;
		height: auto;
		text-align: center;
	}
	#surveysArea{
		box-sizing: border-box;
		width: 800px;
		height: auto;
		margin: 20px;
		border-right: solid 2px black;
  		border-left: solid 2px black;
		padding: 3%;
		display: inline-block;
	}
	#surveyArea{
		box-sizing: border-box;
		width: auto;
		height: 200px;
		margin: 20px;
		border: 2px solid black;
		border-radius: 10px;
		padding: 2%;
		display: inline-block;
	}
	a[class=text]{
		font-weight:bold;
	}
</style>
<meta charset="EUC-KR">
<title>page_survey_create</title>
</head>
<body>
<!-- �ΰ� -->
<div id = "logoArea" align = "center" style = "width: 100%; height: 50px">
	<!-- �����̷�Ʈ -->
	<form method = "get" action="">
		<!-- �̹��� �ΰ� ��� -->
		<input type = "image" src = "" alt = "logo">
	</form>
</div>

<hr id = "logoLine" >

<div id = "surveysArea">

	<div id = "surveyArea">
		<!-- �ۼ� �Ϸ� -->
		<form action = "/sirbay/survey/create" method="post">
	
			<div id = "surbeyTitle">
				<a class = "text">���� ����</a>
				<input type = "text" name ="title" size = 70><br><br>
			</div>
			
			<hr>
	
			<div id = "questionBox">
			
				<br>
				<div id = "qusetion">
					���� : <input type = "text" name ="title" size = 70><br><br>
				</div>	

				<br>

				<div id = "radioBox">
					<input type = "checkBox" name = "subject + ${cnt}" value = "������" onclick='(checkRadioButton(event))'> ������
					<input type = "checkBox" name = "subject" value = "�ְ���" onclick='(checkRadioButton(event))'> �ְ���
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
			<input type ="button" value = "���� �߰�" onclick = "add_div()">
		
			<%-- ���� �ۼ��Ѱ� ���� --%>
		
			<input type = submit name = "submit" value = "�ۼ� �Ϸ�">
		</form>
	</div>
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
		//div ����
		var div = document.createElement('div');
		
		//questionBox ����
		add_cnt();
		var questionBox = document.createElement('questionBox');
		
		
		div.innerHTML = document.getElementById('questionBox').innerHTML;
		
		document.getElementById('result').appendChild(div);
	}
	var cnt = 1;
	
	function add_cnt(){
		cnt++;
	}
</script>


</body>
</html>