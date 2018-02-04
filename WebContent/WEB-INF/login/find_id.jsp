<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../js/bootstrap.min.js" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>만개의 레시피</title>
</head>
<body>

	<div class="container">
		<div class="row" style="margin-top:100px;">
		<div class="col-md-2 hidden-xs"></div>
		<div class="col-md-8 col-xs-12">
		<% if(request.getAttribute("fail") != null){ %>
			일치하는 닉네임이 없습니다. 다시 입력해주세요.
		<% } %>
			<h2>아이디 찾기</h2>
			<form action="login?cmd=find_id" method="post">
				<input type="text" class="form-control" name="nick" placeholder="닉네임">
				<input type="text" class="form-control" style="margin-top: 15px;" name="birthday" placeholder="생일">
				<button type="submit" class="btn btn-primary btn-block btn-lg" style="margin-top: 15px">아이디 찾기</button>
			</form>
			<p class="help-block"> 가입시 등록한 생일과 닉네임을 입력하세요 </p>
		</div>
		<div class="col-md-2 hidden-xs"></div>
		</div>
	</div>

</body>
</html>