<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<body>
	<H2>마이 페이지</H2>
	
	<!-- 회원 탈퇴 + 메인페이지로 이동 action -->
	<form action = "/sirbay/unRegister" method="get"><input type = "submit" value = "회원탈퇴"> </form>
	
	<HR>
<!-- 		이름, 성별, 나이, 직업, 거주지역 가져오는 기능 -->
	
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
				<td style = "color:blue" align = 'center'>${user.userBirthdate}</td>
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
	<HR>

	<!-- 메인페이지로 이동 action -->
	<input type = "button" onClick="javascript:history.back();" value = "이전으로">
	
</body>
</html>