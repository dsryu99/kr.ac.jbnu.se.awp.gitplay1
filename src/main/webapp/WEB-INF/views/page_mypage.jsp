<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MyPage</title>
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <style>
    body {
        background: rgb(99, 39, 120)
    }

    .form-control:focus {
        box-shadow: none;
        border-color: #BA68C8
    }

    .profile-button {
        background: rgb(99, 39, 120);
        box-shadow: none;
        border: none
    }

    .profile-button:hover {
        background: #682773
    }

    .profile-button:focus {
        background: #682773;
        box-shadow: none
    }

    .profile-button:active {
        background: #682773;
        box-shadow: none
    }

    .back:hover {
        color: #682773;
        cursor: pointer
    }
    
    .labels {
        font-size: 15px
    }

    .add-experience:hover {
        background: #BA68C8;
        color: #fff;
        cursor: pointer;
        border: solid 1px #BA68C8
    }
    
    .unregister {
    	margin-bottom: 20px;
    }
  </style>
</head>
<body>

  <div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold"></span><span class="text-black-50"></span><span> </span></div>
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">마이페이지</h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-12"><span class="font-weight-bold">이름</span><label class="labels">&nbsp; ${user.userName}</label></div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels"><span class="font-weight-bold">성별</span></label><label class="labels">&nbsp; ${user.userSex}</label></div>
                    <div class="col-md-12"><label class="labels"><span class="font-weight-bold">생년월일</span></label><label class="labels">&nbsp; ${user.userBirthdate}</label></div>
                    <div class="col-md-12"><label class="labels"><span class="font-weight-bold">직업</span></label><label class="labels">&nbsp; ${user.userJob}</label></div>
                    <div class="col-md-12"><label class="labels"><span class="font-weight-bold">주소</span></label><label class="labels">&nbsp; ${user.userAddress}</label></div>
                </div>
                
                <form action = "/sirbay/unRegister" method="get" style = "float:right">
                  <input type = "submit" value = "회원탈퇴"> 
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>