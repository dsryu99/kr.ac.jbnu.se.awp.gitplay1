<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MyPage</title>
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <link rel="stylesheet" type="text/css" href="resources/style.css">
    <!-- as -->
</head>
<body>

<div id="logoArea" align="center" style="width: 100%; height: auto">
		<!-- 리다이렉트 -->
		<a href="${pageContext.request.contextPath}"> <img
			src="resources/logo.png" alt="logo" width="200px" height="80px">
		</a>
	</div>

<div id = "logoLine" ></div>

  <div class="container rounded bg-white mt-5 mb-5">
    <div class="row input-form-mypage">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold"></span><span class="text-black-50"></span><span> </span></div>
        </div>
        <div class="col-md-7 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h2 class="text-right">마이페이지</h2>
                </div>
                <div class="row mt-3">
                	<div class="col-md-12"><label class="labels"><span class="font-weight-bold">이름</span></label>
                	<label class="labels">&nbsp; ${user.userName}</label></div>
                    <div class="col-md-12"><label class="labels"><span class="font-weight-bold">성별</span></label>
                    <label class="labels">&nbsp; ${user.userSex}</label></div>
                    <div class="col-md-12"><label class="labels"><span class="font-weight-bold">생년월일</span></label>
                    <label class="labels">&nbsp; ${user.userBirthdate}</label></div>
                    <div class="col-md-12"><label class="labels"><span class="font-weight-bold">직업</span></label>
                    <label class="labels">&nbsp; ${user.userJob}</label></div>
                    <div class="col-md-12"><label class="labels"><span class="font-weight-bold">주소</span></label>
                    <label class="labels">&nbsp; ${user.userAddress}</label></div>
                </div>
                <form action = "/sirbay/unRegister" method="get" style = "float:right">
                  <button type="button" class="btn btn-warning">회원탈퇴</button>
                </form>
            </div>
        </div>
      </div>
	</div>
</body>
</html>