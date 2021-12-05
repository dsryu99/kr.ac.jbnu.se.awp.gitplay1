<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:set var="isMultipleChoiceQuestion" value="false" />

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

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
		width: 100%;
		height: auto;
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
<div id = "logoArea" align = "center" style = "width: 200xp; height: 50px">
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
		<form action = "/sirbay/survey/create/complete" method="post">
	
			<div id = "surbeyTitle">
				<a class = "text">���� ����</a>
				<input type = "text" name ="title" size = 70><br><br>
			</div>
			
			<hr>
			
			<a class = "text">���� ����</a>
			<input type = button value = "�˻�" onClick = "" style = "float:right">
			<br>
			<br>
			
			<hr>
			
			<div id = "simularArea">
			</div>
	
			<div id = "questionBox">
				<br>
				<div id = "qusetion">
					<a class = "text">����</a>
					<br>
					<br> 
					<input type = "text" name ="title" size = 80>
					<br>
					<br>
				</div>
				<br>
				<div id = "radioBox">
					<input type = "radio" name = "subject" value = "������" onclick="checkRadioButton(event)">
					������
					<input type = "radio" name = "subject" value = "�ְ���" onclick="checkRadioButton(event)" checked>
					�ְ���
				</div>
				<br>
				<div id = "answer">
					<div id = 'sub'>
						1 <input type = "text" size = 80/><br><br>
						2 <input type = "text" size = 80/><br><br>
						3 <input type = "text" size = 80/><br><br>
						4 <input type = "text" size = 80/><br><br>
						5 <input type = "text" size = 80/><br>
					</div>
				</div>
				<br>
				<hr>
				<br>
			</div>
		
			<div id = 'result'></div>
			<input type ="button" value = "���� �߰�" onclick = "add_div()">
		
			<%-- ���� �ۼ��Ѱ� ���� --%>
		
			<input type = submit name = "submit" value = "�ۼ� �Ϸ�">
		</form>
	</div>
</div>

<script>
	var cnt = 1;
	document.getElementById("answer").style.display = "none";
	function checkRadioButton(event){
		console.log(event.target.value);
		var selection = event.target.parentElement.parentElement.getElementsByTagName("div")[2];
		if(event.target.value == "������"){
			selection.style.display = "block";
		}
					
		else{
			selection.style.display = "none";
		}
	}

	function add_div(){
		var div = document.createElement('div');
			
		//questionBox ����
		var questionBox = document.createElement('questionBox');
		
		div.innerHTML = document.getElementById('questionBox').innerHTML;
		div.getElementsByTagName("div")[2].id = "answer" + cnt;
		div.getElementsByTagName("div")[1].children[0].name = "radio" + cnt;
		div.getElementsByTagName("div")[1].children[1].name = "radio" + cnt++;
		
		document.getElementById('result').appendChild(div);
	}

</script>

</body>
</html>