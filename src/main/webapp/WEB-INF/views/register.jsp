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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/088b1a9afe.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
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
            border-radius: 10px;
        }
        #main-name{
            margin-bottom: 0;
            margin-top: 10px;
            font-size: 50px;
            text-align: center;
        }
        #main-slogan{
            margin-top: 0;
            font-size: 20px;
            color: #DDDDDD;
            text-align: center;
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
        }

        .register-button{
            width:100px;
        }
    </style>
</head>
<body>
<div id="register-main-container">
    <div id="register-sub-container">
        <div id="register-header-container">
            <h1 id="main-name">회원가입</h1>
            <h5 id="main-slogan">Sign Up</h5>
        </div>
        <form id="register-box-container" action="member" method="post">
            <div class="register-box-row">
                <label>ID</label><input type="text" name="id" class="form-control" required>
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
                <button class="btn btn-default register-button" onclick="register()">가입</button>
                <button class="btn btn-default register-button"  onclick="location='login'">취소</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>