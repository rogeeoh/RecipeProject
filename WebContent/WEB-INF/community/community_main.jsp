<%@include file="../inc/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 메인</title>
<style>
/* 왼쪽 사이드메뉴 색 */
.nav-pills>li.active>a, .nav-pills>li.active>a:focus
	{
	background-color: #4caf50;
	color: #fff;
	font-weight: bold;
}
 .nav-pills>li.active>a:hover{
	background-color: #4caf50;
 	color: #fff;
 	font-weight: bold;
}
li a {
    color: #74b243;
    text-decoration: none;
}
/* 이미지 크기조절 */
img {
    vertical-align: middle;
    width: 100%;
}
.img-circle{
	height: 100px;
	width: 100%;
}
#imgDiv{
	display: block;
	height: 400px;
	max-width: 100%;
	overflow: hidden;
}
/* 사이드 메뉴 크기 */
#sideMenu{
	max-height: 100%;
}
/* 좋아요, 댓글 위치 조절 */
#likeDiv, #viewDiv{
	color : #74b243;
	text-align: center;
}
/* summary 관련 css */
#summaryDiv a{
	text-decoration: none;
	color: black;
}
#nickNameDiv h3{
	color: #de4830;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 사이드 메뉴 -->
			<div class="col-md-3" id="sideMenu">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a data-toggle="pill" href="#showOffList">뽐내기</a></li>
					<li><a data-toggle="pill" href="#freeList">자유게시판</a></li>
				</ul>
			</div>
			<!-- 사이드 메뉴 컨텐츠 -->
			<div class="tab-content">
				<div class="tab-pane fade in active" id="showOffList">
					<jsp:include page="/WEB-INF/community/showoff/showoff_main.jsp"></jsp:include>
				</div>
				<div class="tab-pane fade" id="freeList">
					<jsp:include page="./free/free_main.jsp"></jsp:include>
				</div>
			</div>
		</div><!-- end row -->
	</div><!-- end container -->
</body>
</html>