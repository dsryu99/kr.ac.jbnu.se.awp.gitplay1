<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<div id = "login">
	<%-- 로그인에 대한 정보 빈칸 있어야됨 --%>
		<form method = "post" action = "/sirbay/login" name="login_form">
			<h1>로그인</h1>
			<div id = "id_area">
				<input type = "text" name = "id" placeholder = "아이디">
				
			</div>
			<div id = "pwd_area">
				<input type = "password" name = "pwd" placeholder = "비밀번호"> 
			</div>
			<input type = "submit" value = "로그인" >
			
		</form>
	</div>

</body>
</html>