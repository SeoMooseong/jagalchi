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
alert("ID/PW를 다시 확인하세요.");
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
    <link href="https://fonts.googleapis.com/css?family=Song+Myung|Sunflower:300&display=swap" rel="stylesheet">
    <script>
    </script>
    <style>
        #login-main-container{
            width: 100%;
            height: 100vh;
            background-color: cornflowerblue;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #login-sub-container{
            width: 400px;
            height: 310px;
            display:flex;
            flex-direction: column;
            align-items: center;
            background-color: rgba(255, 255, 255, 0.85);
            /*border-radius: 10px;*/
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        #main-name{
            margin-bottom: 0;
            margin-top: 10px;
            font-size: 65px;
            text-align: center;
            font-family: 'Song Myung', serif;
        }
        #main-slogan{
            margin-top: 0;
            font-size: 15px;
            color: #c2c2c2;
            text-align: center;
            font-family: 'Sunflower', sans-serif;
        }
        #login-header-container, #login-box-container{
            width:60%
        }
        .login-box-row{
            margin-bottom: 10px;
            width: 100%;
        }

        .login-button-group{
            text-align: center;
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .login-button{
            width: 100%;
            background-color: cornflowerblue;
            color: white;
            border: rgba(0, 0, 0, 0);
            margin-bottom: 5px;
        }
        .login-button:hover{
            background-color: rgba(100, 149, 237, 0.8);
            border: rgba(0, 0, 0, 0) !important;
            color: white;
        }

        .login-button:active{
            background-color: rgba(100, 149, 237, 0.6) !important;
            color: white !important ;
        }

        .login-button:focus{
            background-color: rgba(100, 149, 237, 0.6) !important;
            color: white !important ;
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

        #login-register-text{
            color: #c2c2c2;
        }
        #login-register-btn{
            color: #54dc59;
            cursor: pointer;
        }
        #login-register-text{
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div id="login-main-container">
    <div id="login-sub-container">
        <div id="login-header-container">
            <h1 id="main-name">자갈취</h1>
            <h5 id="main-slogan">자격증 따러 갈 취준생</h5>
        </div>
        <form id="login-box-container" action="login" method="post">
            <div class="login-box-row">
                <label>ID</label><input type="text" name="id" class="form-control">
            </div>
            <div class="login-box-row">
                <label>PASSWORD</label><input type="password" name="password" class="form-control">
            </div>
            <div class="login-box-row login-button-group">
                <input type="submit" class="btn btn-default login-button" value="로그인">
                <div><span id="login-register-text">Not registered?</span><span id="login-register-btn" onclick="location='register'">Create an account</span></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>