<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:set var="isMultipleChoiceQuestion" value="false" />

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../resources/style.css">
<!-- private double similarity(String s1, String s2) {
    	String longer = s1, shorter = s2;
    
    	if (s1.length() < s2.length()) {
      		longer = s2; 
        	shorter = s1;
    	}
    
    	int longerLength = longer.length();
    	if (longerLength == 0) return 1.0;
    	return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
	}
	private int editDistance(String s1, String s2) {
    	s1 = s1.toLowerCase();
    	s2 = s2.toLowerCase();
    	int[] costs = new int[s2.length() + 1];
    
    	for (int i = 0; i <= s1.length(); i++) {
        	int lastValue = i;
        	for (int j = 0; j <= s2.length(); j++) {
            	if (i == 0) {
             	   costs[j] = j;
            	} else {
                	if (j > 0) {
                    	int newValue = costs[j - 1];
                    	
                    	if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                        	newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                    	}
                    
                    	costs[j - 1] = lastValue;
                    	lastValue = newValue;
                	}
            	}
        	}
        	if (i > 0) costs[s2.length()] = lastValue;
    	}
    	return costs[s2.length()];
	} -->
	
<style>
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

<hr id = "logoLine">

	<div id="contentsArea">
		<div id="surveysArea" class="input-form main" style = "display:inline-block">

			<div id="surveyListArea" style = "text-align:left;display:inline-block">
				<!-- 작성 완료 -->
				<form action="/sirbay/survey/create/complete" method="post">

					<div id="surbeyTitle">
						<a class="text">설문 제목</a> 
						<input type="text" class="form-control" name="title" placeholder="" value="" required size=80>
						<!-- <input type="text" name="title" size=70> --><br>
						<br>
					</div>

					<hr>

					<a class="text">유사 설문</a> 
					<input class = "btn btn-light" type=button value="검색" onClick=""
						style="float: right"> <br> <br>

					<hr>

					<div id="simularArea"></div>

					<div id="questionBox">
						<br>
						<div id="qusetion">
							<a class="text">질문</a> <br> <br> 
							<!-- <input class="title" type="text" name="title1" size=80>  -->
							<input type="text" class="form-control" name="title1" placeholder="" value="" required>
							
							<br>
						</div>
						<br>
						<div id="radioBox">
							<input type="radio" name="subject" value="choice"
								onclick="checkRadioButton(event)"> 객관식 <input
								type="radio" name="subject" value="subjective"
								onclick="checkRadioButton(event)" checked> 주관식
						</div>
						<br>
						<div id="answer1" class="1">
							<div id='sub'>
								<!-- 1 
								<input class="selection1" name="selection1" type="text"size=80 />
								<br><br> 
								2 
								<input class="selection1" name="selection1" type="text" size=80 />
								<br><br> -->
								1 
								<input class="form-control" name="selection1" type="text"size=80 />
								
								2 
								<input class="form-control" name="selection1" type="text" size=80 />
								
								<div id="addSelectionArea" class="addSelectionArea"></div>
								
								<br>
								
								<div id = "buttonArea" style = "">
								
								</div>
								<input class = "btn btn-light" id="plusButton" type=button value="+"
									onClick="add_selection(event)"> <input id="minusButton"
									class="btn btn-light" type=button value="-"
									onClick="remove_selection(event)">
							</div>
						</div>
						<hr>
					</div>

					<div id='addQuestionArea'></div>
					<input class="btn btn-light" type="button" value="질문 추가" onclick="add_div()" style = "display: inline-block; float: center" >
					<input class="btn btn-light" type= submit name="submit" value="작성 완료">
				</form>
			</div>
		</div>

	</div>


	<script>
	var cnt = 2;
	document.getElementById("answer1").style.display = "none";
 	document.getElementById("minusButton").style.display = "none";
	function checkRadioButton(event){
		console.log(event.target.value);
		var selection = event.target.parentElement.parentElement.getElementsByTagName("div")[2];
		if(event.target.value == "choice"){
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
		test = questionBox;
		
		questionBox.class = cnt;
		
		div.innerHTML = document.getElementById('questionBox').innerHTML;
		
		div.getElementsByTagName("div")[0].getElementsByClassName('form-control')[0].name = "title" + cnt;
		div.getElementsByTagName("div")[2].id = "answer" + cnt;
		div.getElementsByTagName("div")[2].setAttribute("class", cnt);
		div.getElementsByTagName("div")[2].children[0].children[0].name = "selection" + cnt;
		div.getElementsByTagName("div")[2].children[0].children[1].name = "selection" + cnt;
		
		var selection = div.getElementsByTagName('div')[2].children[0].getElementsByClassName('form-control');
		
		div.getElementsByTagName("div")[2].children[0].getElementsByClassName('btn btn-light')[1].style.display = "none";
		
		var addSelectionArea = div.getElementsByTagName("div")[2].children[0].getElementsByClassName('addSelectionArea')[0];
		
		while(addSelectionArea.hasChildNodes()){
			addSelectionArea.removeChild(addSelectionArea.firstChild);
		}
		
		div.getElementsByTagName("div")[2].style.display = "none";
		
		div.getElementsByTagName("div")[1].children[0].name = "radio" + cnt;
		div.getElementsByTagName("div")[1].children[1].name = "radio" + cnt++;
		
		document.getElementById('addQuestionArea').appendChild(div);
	}
	
	var test;
	
	function add_selection(event){
		var questionNum = event.target.parentElement.parentElement.className;
		console.log(questionNum);
		var addSelectionArea = event.target.parentElement.getElementsByClassName('addSelectionArea')[0];
		var length = 2 + addSelectionArea.children.length + 1;
		
		if(length == 5) event.target.parentElement.getElementsByClassName('btn btn-light')[0].style.display = "none";
		if(length > 2) event.target.parentElement.getElementsByClassName('btn btn-light')[1].style.display = "inline-block";
		
/* 		var selection = document.createElement('selection_input');
		selection.type = "text";
		selection.class = "form-control";
		selection.name = "selection" + questionNum;
		selection.size = 80; */
		
 		var selection = document.createElement('input');
		selection.type = "text";
		selection.setAttribute("class", "form-control");
		/* selection.class = "form-control"; */
		selection.name = "selection" + questionNum;

		
		addSelectionArea.append(length + " ");
		addSelectionArea.appendChild(selection);
		
		console.log(length);
	}
	
	
	function remove_selection(event){
		var addSelectionArea = event.target.parentElement.getElementsByClassName('addSelectionArea')[0];
		var length = 2 + addSelectionArea.children.length - 1;
		
		addSelectionArea.removeChild(addSelectionArea.lastChild);
		addSelectionArea.removeChild(addSelectionArea.lastChild);
		
		if(length == 2) event.target.parentElement.getElementsByClassName('btn btn-light')[1].style.display = "none";
		if(length < 5) event.target.parentElement.getElementsByClassName('btn btn-light')[0].style.display = "inline-block";
		console.log(length);
	}
	

</script>

</body>
</html>