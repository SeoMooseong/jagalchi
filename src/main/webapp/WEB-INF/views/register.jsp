<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${isLogin != null }">
<script language="javascript">
window.location.href = 'calendar';
</script>
</c:if>
<c:if test="${isError == true }">
<script language="javascript">
alert("다시 확인 후 시도하세요.");
</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>자갈취-자격증 따러 갈 취준생</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Song+Myung|Sunflower:300&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/088b1a9afe.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        window.onload = function () {
            $('#id').change(function () {
                var btn = $('#id-check-btn');
                btn.text("중복체크");
                btn.removeClass("disabled");
                btn.removeClass("btn-danger");
                btn.addClass("btn-info");
                $('.username_input').attr("check_result", "fail");
            })
        }

    function idCheck(){
        var id = $('#id').val();
        $.get('idCheck', {
            "id" : id
        },function(data){
            var btn = $('#id-check-btn')
            btn.addClass("disabled");
            btn.removeClass("btn-info");
            if(data){
                btn.addClass("btn-success");
                btn.text("사용가능");
                $('.username_input').attr("check_result", "success");
            }else{
                btn.addClass("btn-danger");
                btn.text("사용불가");
                $('.username_input').attr("check_result", "fail");
            }
        })
    }

    function isSubmit(){
        if ($('#id').attr("check_result") == "success") {
            return true;
        } else {
            alert("아이디 중복체크를 해주세요.");
            return false;
        }
    }
    </script>
    <style>
        #register-main-container{
            width: 100%;
            height: 100vh;
            background-color: cornflowerblue;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #register-sub-container{
            width: 400px;
            height: 525px;
            display:flex;
            flex-direction: column;
            align-items: center;
            background-color: rgba(255, 255, 255, 0.85);
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        #main-name{
            margin-bottom: 15px;
            margin-top: 20px;
            font-size: 65px;
            text-align: center;
            font-family: 'Song Myung', serif;
        }
        #register-header-container{
            width:70%
        }
        #register-box-container{
            width:60%
        }
        .register-box-row{
            margin-bottom: 10px;
            width: 100%;
        }

        .register-button-group{
            display: flex;
            justify-content: space-around;
            margin-top: 20px;
        }

        .register-button{
            width:100px;
        }

        .btn:active{
            border: rgba(0, 0, 0, 0) !important;
            outline: none !important;
            box-shadow: none !important;
        }

        .btn:focus{
            border: rgba(0, 0, 0, 0) !important;
            outline: none !important;
            box-shadow: none !important;
        }
        .register-box-row-id{
        	display:flex;
        	justify-content: space-between;
        }
        #id-check-btn{
        	height: 21px;
        }
    </style>
</head>
<body>
<div id="register-main-container">
    <div id="register-sub-container">
        <div id="login-header-container">
            <h1 id="main-name">회원가입</h1>
        </div>
        <form id="register-box-container" action="member" method="post" onSubmit="isSubmit();return false">
            <div class="register-box-row">
            	<div class="register-box-row-id">
                	<label>ID</label><button type="button" id="id-check-btn" class="btn btn-xs btn-info" onclick="idCheck()">중복체크</button>
                </div>
                <input type="text" id="id" name="id" class="form-control" check_result="fail" required>
            </div>
            <div class="register-box-row">
                <label>PASSWORD</label><input type="password" name="password" class="form-control" required>
            </div>
            <div class="register-box-row">
                <label>NAME</label><input type="text" name="name" class="form-control" required>
            </div>
            <div class="register-box-row">
                <label>MAJOR</label><input type="text" name="major" class="form-control">
            </div>
            <div class="register-box-row">
                <label>AGE</label><input type="number" name="age" min="0" max="150" class="form-control">
            </div>
            <div class="register-box-row register-button-group">
                <input type="submit" class="btn btn-default register-button btn-success" value="가입">
                <button type="button" class="btn btn-default register-button btn-danger"  onclick="location='login'">취소</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>