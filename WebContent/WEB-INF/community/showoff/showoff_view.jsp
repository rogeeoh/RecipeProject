<%@include file="../../inc/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뽐내기 ${showoff.showoff_no}번째 글</title>
<style>
/* 이미지 크기조절 */
#info img {
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

/* 댓글 */
.commentBox {
    padding:10px;
    border-top:1px dotted #bbb;
}
.commentBox .form-group:first-child, .actionBox .form-group:first-child {
    width:80%;
}
.commentBox .form-group:nth-child(2), .actionBox .form-group:nth-child(2) {
    width:18%;
}
.actionBox .form-group * {
    width:100%;
}
.taskDescription {
    margin-top:10px 0;
}
.commentList {
    padding:0;
    list-style:none;
    max-height:200px;
    overflow:auto;
}
.commentList li {
    margin:0;
    margin-top:10px;
}
.commentList li > div {
    display:table-cell;
}
.commenterImage {
    width:30px;
    margin-right:5px;
    float:left;
}
.commenterImage img {
    width:100%;
    border-radius:50%;
}
.commentText p {
    margin:0;
}
.sub-text {
    color:#aaa;
    font-family:verdana;
    font-size:11px;
}
.actionBox {
    border-top:1px dotted #bbb;
    padding:10px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 실제 작성되는 레이아웃 -->
			<div class="col-md-8 col-md-offset-2" style="border:1px solid silver">
				<!-- 프로필 사진 -->
				<div class="col-md-2 col-sm-2 col-xs-2" id="profile" style="margin-bottom: 2%">
					<img src="/recipe_project/images/bby1.jpg" class="img-circle">
				</div>
				<!-- 컨텐츠 -->
				<div class="col-md-10" style="margin-bottom: 2%">
					<div class="row">
						<!-- 제목 -->
						<div class="col-md-12" id="titleDiv">
							<h2>${showoff.title}</h2>
						</div>
						<!-- 작성자(수정필요), 작성시간 -->
						<div class="col-md-8" id="nickNameDiv">
							<h3>${showoff.mem_no}</h3>
							<p>${showoff.date}</p>
						</div>
						<!-- 조회수 -->
						<div class="col-md-2" id="viewDiv">
							<h3>
								<span id="viewCnt"><i class="glyphicon glyphicon-eye-open"></i>${showoff.cnt}</span>
							</h3>
						</div>
						<!-- 좋아요 -->
						<div class="col-md-2" id="likeDiv">
							<h3>
								<span id="likeCnt"><i class="glyphicon glyphicon-thumbs-up"></i>${showoff.likes}</span>
							</h3>
						</div>
						<!-- 글내용 -->
						<div class="col-md-12" id="introDiv">
							<span>${showoff.content}</span>
						</div>
						<!-- 대표사진 -->
						<div class="col-md-12" id="imgDiv">
							<img src="${showoff.pic_url}">
						</div>
						<!-- ck editor에서 추가한 내용 -->
						<div class="col-md-12" id="editorDiv">
							<span>${showoff.editor}</span>
						</div>
					</div>
				</div>
				<!-- 삭제, 수정, 목록 버튼 -->
				<div style="text-align: right; margin-top: 25px">
					<input type="button" class="btn btn-default" value="삭제하기" id="delete"/>
					&nbsp;
					<a class="btn btn-default" href="community_showoff?cmd=modify&no=${showoff.showoff_no}">수정하기</a>
					&nbsp;
					<a class="btn btn-default" href="community_showoff">목록으로</a>
					&nbsp;
				</div>
				<!-- 댓글 -->
				<div>
					<div class="detailBox">
						<div class="titleBox">
							<label>댓글 상자</label>
						</div>
						<div class="commentBox">
							<p class="taskDescription">Lorem Ipsum is simply dummy text	of the printing and typesetting industry.</p>
						</div>
						<div class="actionBox">
							<ul class="commentList">
								<li>
									<div class="commenterImage">
										<img src="http://placekitten.com/45/45" />
									</div>
									<div class="commentText">
										<p class="">Hello this is a test comment.</p>
										<span class="date sub-text">on March 5th, 2014</span>
									</div>
								</li>
								<li>
									<div class="commenterImage">
										<img src="http://placekitten.com/45/45" />
									</div>
									<div class="commentText">
										<p class="">Hello this is a test comment and this comment
											is particularly very long and it goes on and on and on.</p>
										<span class="date sub-text">on March 5th, 2014</span>

									</div>
								</li>
								<li>
									<div class="commenterImage">
										<img src="http://placekitten.com/45/45" />
									</div>
									<div class="commentText">
										<p class="">Hello this is a test comment.</p>
										<span class="date sub-text">on March 5th, 2014</span>

									</div>
								</li>
							</ul>
							<form class="form-inline" role="form">
								<div class="form-group">
									<input class="form-control" type="text"
										placeholder="Your comments" />
								</div>
								<div class="form-group">
									<button class="btn btn-default">Add</button>
								</div>
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 실제 작성되는 레이아웃 끝 -->
		</div>
<script>
$("#delete").on("click", function(){
	$.ajax({
		url: "ajax?cmd=chk_session"
		/*data: $("#email")*/
	}).done(function(session) {
		session = session.trim();
		console.log('session : ' + session);
		if(session != "true"){
			alert("로그인후 이용해주세요");
			/*$("#email").val("");*/
			return;
		}
		if(confirm("정말 삭제하시겠습니까?") == true)
			location.href = "board_delete?board=showoff&no=${showoff.showoff_no}";
	});
});
</script>
</body>
</html>