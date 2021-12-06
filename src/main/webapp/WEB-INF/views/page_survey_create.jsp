<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>page_survey_create</title>
</head>
<body>
<!-- 로고 -->
<div id = "logoArea" align = "center" style = "width: 200xp; height: 50px">
	<!-- 리다이렉트 -->
	<form method = "get" action="">
		<!-- 이미지 로고 출력 -->
		<input type = "image" src = "" alt = "logo">
	</form>
</div>

<hr id = "logoLine" >

<div id = "surveysArea">

	<div id = "surveyArea">
		<!-- 작성 완료 -->
		<form action = "/sirbay/survey/create/complete" method="post">
	
			<div id = "surbeyTitle">
				<a class = "text">설문 제목</a>
				<input type = "text" name ="title" size = 70><br><br>
			</div>
			
			<hr>
			
			<a class = "text">유사 설문</a>
			<input type = button value = "검색" onClick = "" style = "float:right">
			<br>
			<br>
			
			<hr>
			
			<div id = "simularArea">
			</div>
	
			<div id = "questionBox">
				<br>
				<div id = "qusetion">
					<a class = "text">질문</a>
					<br>
					<br> 
					<input type = "text" name ="title" size = 80>
					<br>
					<br>
				</div>
				<br>
				<div id = "radioBox">
					<input type = "radio" name = "subject" value = "객관식" onclick="checkRadioButton(event)">
					객관식
					<input type = "radio" name = "subject" value = "주관식" onclick="checkRadioButton(event)" checked>
					주관식
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
			<input type ="button" value = "질문 추가" onclick = "add_div()">
		
			<%-- 설문 작성한거 제출 --%>
		
			<input type = submit name = "submit" value = "작성 완료">
		</form>
	</div>
</div>

<script>
	var cnt = 1;
	document.getElementById("answer").style.display = "none";
	function checkRadioButton(event){
		console.log(event.target.value);
		var selection = event.target.parentElement.parentElement.getElementsByTagName("div")[2];
		if(event.target.value == "객관식"){
			selection.style.display = "block";
		}
					
		else{
			selection.style.display = "none";
		}
	}

	function add_div(){
		var div = document.createElement('div');
			
		//questionBox 생성
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