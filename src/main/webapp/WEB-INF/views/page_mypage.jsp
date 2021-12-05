<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
	#profileArea{
		box-sizing: border-box;
		width: 800px;
		height: auto;
		margin: 20px;
		border-right: solid 2px black;
  		border-left: solid 2px black;
		padding: 3%;
		display: inline-block;
	}
	#contentsArea{
		width: auto;
		height: auto;
		text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>마이 페이지</title>
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
			<font size = 5 style = "font-weight:bold">마이페이지</font> 
		</div>	
	</div>

	<hr id = "logoLine" >
	
	<div id = contentsArea>
		<!-- 이름, 성별, 나이, 직업, 거주지역 가져오는 기능 -->
		<div id = profileArea style = "text-align: left">
			<table>
				<tr>
					<td>이름</td>
					<td style = "color:blue" align = 'center'>${user.userName}</td>
				</tr>
				<tr>
					<td>성별</td>
					<td style = "color:blue" align = 'center'>${user.userSex}</td>
				</tr>
				<tr>
					<td>나이</td>
					<td style = "color:blue" align = 'center'>${user.birthDate}</td>
				</tr>
				<tr>
					<td>직업</td>
					<td style = "color:blue" align = 'center'>${user.userJob}</td>
				</tr>
				<tr>
					<td>거주지역</td>
					<td style = "color:blue" align = 'center'>${user.userAddress}</td>
				</tr>
			</table>
			
			<!-- 회원 탈퇴 + 메인페이지로 이동 action -->
			<form action = "/sirbay/unRegister" method="get" style = "float:right">
				<input type = "submit" value = "회원탈퇴"> 
			</form>
		</div>
	</div>
	
	
</body>
</html>