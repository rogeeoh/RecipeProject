<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/recipe_project/js/jquery-3.2.1.min.js"></script>
<link href="/recipe_project/css/bootstrap.min.css" rel="stylesheet">
<link href="/recipe_project/js/bootstrap.min.js" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>비밀번호 찾기</title>
</head>
<body>

<div class="container">
	<div class="row" style="margin-top:100px;">
	<div class="col-md-2 hidden-xs"></div>
	<div class="col-md-8 col-xs-12">
	<% if(request.getAttribute("fail") != null){ %>
		아이디 혹은 생일이 다릅니다.
	<% } %>
		<h2>비밀번호 찾기</h2>
		<form action="login?cmd=find_pw" method="post" id="findPwForm">
			<input type="text" class="form-control" name="email" id ="email" placeholder="아이디(이메일)">
			<input type="text" class="form-control" style="margin-top: 15px;" name="birthday" id="birthday" placeholder="YYYY-MM-DD형식">
			<button type="submit" class="btn btn-primary btn-block btn-lg" style="margin-top: 15px">비밀번호 찾기</button>
		</form>
		<p class="help-block"> 가입한 아이디(이메일)와 생일을 입력하세요 </p>
	</div>
	<div class="col-md-2 hidden-xs"></div>
	</div>
</div>
<script>

$("form").submit(function(event) {
	var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(!emailRegExp.test($("#email").val())){
		alert('이메일을 다시 입력해주세요');
		event.preventDefault();
	}
	var birthdayRegExp = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
	if(!birthdayRegExp.test($("#birthday").val())){
		alert('생일 형식을 다시 입력해주세요.');
		event.preventDefault();
	}
	return;
});
</script>
</body>
</html>