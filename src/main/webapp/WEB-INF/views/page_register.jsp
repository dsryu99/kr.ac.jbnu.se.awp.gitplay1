<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입 화면</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <style>
    .input-form {
      max-width: 680px;

      margin-top: 80px;
      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
    
    .radio-Button{
        padding-bottom: 10px;
    }
  </style>
</head>
<body>
  <div id="aontentsArea">
  	<div id = "formArea">
	  <form action="/sirbay/addUser" method="post">    
	    <div class="input-form-backgroud row">
	      <div class="input-form col-md-12 mx-auto">
	        <h4 class="mb-3">회원가입</h4>
	        
	          <div class="row">
	            <div class="col-md-6 mb-3">
	              <label for="name">이름</label>
	              <input type="text" class="form-control" name="name" id="name" placeholder="" value="" required>
	            </div>
	            <div class="col-md-6 mb-3">
	              <label for="nickname">아이디</label>
	              <input type="text" class="form-control" name="id" id="nickname" placeholder="" value="" required>
	            </div>
	          </div>
	          
	          <div class="row">
	            <div class="col-md-6 mb-3">
	              <label for="password">비밀번호</label>
	              <input type="password" class="form-control" name="password" id="passWord" placeholder="" value="" required>
	            </div>
	            <div class="col-md-6 mb-3">
	              <label for="passwordConfirm">비밀번호 확인</label>
	              <input type="password" class="form-control" id="pawwWordConfirm" placeholder="" value="" required>
	            </div>
	          </div>
	
	          <div class="mb-3">
	            <label for="email">직업</label> <!-- 직업 추가 -->
	            <input type="text" class="form-control" name="job" id="email" placeholder="" required>
	          </div>
	          
	          <div class = "radio-Button">
	            <div class="form-check form-check-inline">
	                <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="man">남
	            </div>
	            <div class="form-check form-check-inline">
	                <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="male">여
	            </div>
	         </div>
	          
	          <div class="mb-3"> 
	          	<label for="birthday">생년월일</label><!--이거 date로 바꿧는데 name은 그냥 birth-yy로 해놓음 -->
	          	<input type="date" class="form-control" name="birthday" placeholder="">
	          </div>
	
	          <div class="mb-3">
	            <label for="address">주소</label> <!-- 주소 추가 -->
	            <input type="text" class="form-control" name="address" id="address" placeholder="서울특별시 강남구" required>
	          </div>
	          <hr class="mb-4">
	          	<button class="btn btn-primary btn-lg btn-block" name="registerBtn" type="submit">가입 완료</button>
	      </div>
	    </div>
	    </form>
    </div>
  </div>
</body>
</html>