<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>회원가입</title>
<link href="./css/bootstrapValidator.css" rel="stylesheet">
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>

<link href="./css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<style>.form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    color: #555;
    font-size: 18px;
    font-weight: 400;
    display: block;
}
.profile-img
{
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}
.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
}
</style>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
        	<% if(request.getAttribute("loginFail") == null){ %>
            <h1 class="text-center login-title">로그인해주세요</h1>
        <%  }else{  %>
        		<h1 class="text-center login-title" style="color: red;">아이디나 패스워드가 틀렸습니다.</h1>
        <%  }  %>
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="">
                <form class="form-signin" method="post" action="login?cmd=login_try">
	                <input type="text" class="form-control" placeholder="Email" name="email" required autofocus>
	                <input type="password" class="form-control" placeholder="Password" name="password" required>
	                <button class="btn btn-lg btn-primary btn-block" type="submit">
	                    Sign in</button>
	                <a href="login?cmd=find_id_page" class="pull-right need-help">forgot ID? </a><span class="clearfix"></span>
	                <a href="login?cmd=find_pw_page" class="pull-right need-help">forgot Password? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="login?cmd=create_account_page" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
</body>
</html>