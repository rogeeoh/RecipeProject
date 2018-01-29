<%@include file="../inc/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뽐내기 게시판</title>
<style>
/* 왼쪽 사이드메뉴 색 */
.nav-pills>li.active>a, .nav-pills>li.active>a:focus
	{
	color: #fff;
	background-color: #74b243;
}
 .nav-pills>li.active>a:hover{
 	color: #fff;
	background-color: #4caf50;
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
	width: 100%;
	height: 100px;
}
#imgDiv{
	display: block;
	max-width: 100%;
	height: 400px;
	overflow: hidden;
}
/* 사이드 메뉴 크기 */
#sideMenu{
	max-height: 100%;
}
/* 좋아요, 댓글 위치 조절 */
#likeDiv, #replyDiv{
	text-align: center;
	color : #74b243;
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
					<li class="active"><a href="#">뽐내기</a></li>
					<li><a href="#">리뷰</a></li>
					<li><a href="#">문의</a></li>
					<li><a href="#">자유게시판</a></li>
				</ul>
			</div>
			<!-- showList -->
			<div class="showList col-md-9">
				<!-- showListItems -->
		        <div class="row">
		            <div class="col-md-2 col-sm-2 col-xs-2" id="info"><img src="./images/bby1.jpg" class="img-circle"></div>
		            <div class="col-md-10">
		                <div class="row">
		                    <div class="col-md-8" id="nickNameDiv"><h3>작성자 닉네임</h3><p>1분전</p></div>
		                    <div class="col-md-2" id="likeDiv">
		                    	<h3><span id="likeCnt"><i class="glyphicon glyphicon-thumbs-up"></i>0</span></h3>
		                    </div>
		                    <div class="col-md-2" id="replyDiv">
		                    	<h3><span id="replyCnt"><i class="glyphicon glyphicon-comment"></i>0</span></h3>
		                    </div>
		                    <div class="col-md-12" id="summaryDiv">
		                    	<a href="#">
			                    	<span>여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 
			                    	간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 
			                    	들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 
			                    	간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 
			                    	들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 
			                    	간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳</span>
			                    </a>
		                    </div>
		                    <div class="col-md-12" id="imgDiv">
		                    	<a href="#"><img src="./images/bby1.jpg"></a>
		                    </div>
		                </div>
		            </div>
		        </div>
		        <!-- showListItems -->
		        <div class="row">
		            <div class="col-md-2" id="info"><img src="./images/bby1.jpg" class="img-circle"></div>
		            <div class="col-md-10">
		                <div class="row">
		                    <div class="col-md-8" id="nickNameDiv"><h3>작성자 닉네임</h3><p>1분전</p></div>
		                    <div class="col-md-2" id="likeDiv">
		                    	<h3><span id="likeCnt"><i class="glyphicon glyphicon-thumbs-up"></i>0</span></h3>
		                    </div>
		                    <div class="col-md-2" id="replyDiv">
		                    	<h3><span id="replyCnt"><i class="glyphicon glyphicon-comment"></i>0</span></h3>
		                    </div>
		                    <div class="col-md-12" id="summaryDiv">
		                    	<a href="#">
			                    	<span>여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 
			                    	간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 
			                    	들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 
			                    	간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 
			                    	들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 
			                    	간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳여기는 간단한 요약글이 들어갈 곳</span>
			                    </a>
		                    </div>
		                    <div class="col-md-12" id="imgDiv">
		                    	<a href="#"><img src="./images/bby1.jpg"></a>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div><!-- end row -->
	</div><!-- end container -->
</body>
</html>