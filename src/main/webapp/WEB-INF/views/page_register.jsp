<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	#logoLine{
		border: 0px;
		height: 30px;
		background-color: black;
		border-radius: 5px;
	}
	#logoArea{
		text-align: center;
	}
	#formArea{
		box-sizing: border-box;
		width: auto;
		height: auto;
		margin: 20px;
		border-right: solid 2px black;
  		border-left: solid 2px black;
		padding: 3%;
		display: inline-block;
		text-align: left;
	}
	#contentsArea{
		width: auto;
		height: auto;
		text-align: center;
	}
	input[type=text], input[type=password]{
		width:350px; height:10px;
		padding:15px;
		font-size:16px;
		color:#aaa;
	}
	
	select{
		width:70px; 
		height:44px;
		font-size:16px;
		color:#aaa;
	}
	a[class=text]{
		font-weight:bold;
	}
	
	input[name=registerBtn]{
		width: 100px; 
		font-size:16px; 
		color:#bbb; 
		background-color:black; 
		font-weight:bold;
		float:right;
	}
	
</style>
<head>

<title>회원가입 화면</title>
</head>
<body>
	<div id = "logoArea">
		<!-- 로고 -->
		<div id = "logo" style = "width: auto; height: auto; display: inline-block; float:left">
			<!-- 리다이렉트 -->
			<form method = "get" action="">
				<!-- 이미지 로고 출력 -->
				<input type = "image" src = "" alt = "logo">
			</form>
		</div>
		
		<div id = "myPage" style = "display: inline-block;">
			<font size = 5 style = "font-weight:bold">회원가입</font> 
		</div>
	</div>

	<hr id = "logoLine" >
	
    <div id="contentsArea">
        
        <div id = "formArea">
        
        	<form action="/sirbay/addUser" method="post">    	
            	<table style = "border-spacing:5px">
               		<tr>
               			<td>
               				<a class = "text">아이디</a>
               			</td>
                	</tr>
                	
                	<tr>
                		<td>
                       		<input type="text" name="id" maxlength="20">
                        	   
                    	</td>
                	</tr>
                	
                	<tr>
                		<td><input type="button" value="중복확인" style = "float:right"></td>
                	</tr>
                        
                	<tr>
                   		<td>
							<a class = "text">비밀번호</a>
						</td>
                	</tr>
                	<tr>
                		<td>
                      		<input type="password" name="password" maxlength="15">
                    	</td>
                	</tr>
                
                	<tr>
                    	<td>
							<a class = "text">비밀번호 재확인</a>
						</td>
                	</tr>
                	<tr>
                		<td>
                      		<input type="password" name="password" maxlength="15">
                    	</td>
                	</tr>
                    
	                <tr>
    	                <td>
							<a class = "text">이름</a>
						</td>
                	</tr>
                	
                	<tr>
                		<td>
            	            <input type="text" name="name" maxlength="40">
                	    </td>
                	</tr>
                    
                	<tr>
                   		<td>
							<a class = "text">성별</a>
						</td>
                	</tr>
                	
                	<tr>
                		<td>
                        	<input type="radio" name="gender" value="남" checked>남
                        	<input type="radio" name="gender" value="여" checked>여
                    	</td>
                	</tr>
                    
                	<tr>
                    	<td>
							<a class = "text">생일</a>
						</td>
                	</tr>
                	
                	<tr>
                		<td>
                        	<input type="text" name="birth_yy" maxlength="4" placeholder="년(4자)" size="6" style = "width: 26%">
                        	<select name="birth_mm" style = "width: 26%">
                            	<option value="">월</option>
                            	<option value="01" >1월</option>
                            	<option value="02" >2월</option>
                            	<option value="03" >3월</option>
                            	<option value="04" >4월</option>
                            	<option value="05" >5월</option>
                            	<option value="06" >6월</option>
                            	<option value="07" >7월</option>
                            	<option value="08" >8월</option>
                            	<option value="09" >9월</option>
                            	<option value="10" >10월</option>
                            	<option value="11" >11월</option>
                            	<option value="12" >12월</option>
                        	</select>
                        	<input type="text" name="birth_dd" maxlength="2" placeholder="일" size="4" style = "width: 26%">
                    	</td>
                	</tr>
                    
                	<tr>
                    	<td>
							<a class = "text">이메일</a>
						</td>
                	</tr>
                	
                	<tr>
                    	<td>
                        	<input type="text" name="email_1" maxlength="30" style = "width: 41.5%"> @
                        	<select name="email_2" style = "width: 41.5%">
                            	<option>naver.com</option>
                            	<option>daum.net</option>
                            	<option>gmail.com</option>
                            	<option>nate.com</option>                        
                        	</select>
                    	</td>
                	</tr>
                    
                	<tr>
                    	<td>
							<a class = "text">휴대전화</a>
						</td>
                	</tr>
                	<tr>
                    	<td>
                        	<input type="text" name="phone" />
                    	</td>
                	</tr>
                	<tr>
                    	<td>
							<a class = "text">주소</a>
						</td>
                	</tr>
                	<tr>
                    	<td>
                        	<input type="text" size="30" name="address"/>
                    	</td>
                	</tr>
            	</table>
            	<br>
            	<input name = "registerBtn" type="submit" value="가입"/>  
        	</form>
        </div>      
    </div>
</body>
</html>