<%@include file="../inc/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

div.center {
	text-align: center;
	margin-top: 50px;
}

span#title {
	font-size: 50px;
}
.detailBox {
    width:100%;
    border:1px solid #bbb;
}
.titleBox {
    background-color:#fdfdfd;
    padding:10px;
}
.titleBox label{
  color:#444;
  margin:0;
  display:inline-block;
}

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
			<div class="col-xs-2"></div>
			<!-- 실제 작성되는 레이아웃 -->
			<div class="col-xs-8" style="border:1px solid silver">
				<div class="center">
					<img id="image_section" src="${board.url}"
						style="max-width: 100%; max-height: 500px" />
				</div>
				<div class="center">
					<span id="title">${board.recp_name}</span>
				</div>
				<div class="center" style="padding-left: 20%; padding-right: 20%">
					<h3>
						<span>재료 리스트</span>
					</h3>
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>재료명</th>
								<th>단위</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ingreList}" var="ingre">
							<tr>
								<td>${ingre.ingre}</td>
								<td>${ingre.amount}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="center">
					<h3>
						<span>레시피</span> 
					</h3>
					<div class="recipeArea">
						<!-- ckeditor로 작성된 HTML태그가 들어가야 함 -->
						<div>${board.editor}</div>
					</div>
				</div>
				<div style="text-align: right; margin-top: 25px">
					<a class="btn btn-default" href="recipe?cmd=delete&no=${board.recp_no}">삭제하기</a>
					&nbsp;
					<a class="btn btn-default" href="recipe?cmd=modify&no=${board.recp_no}">수정하기</a>
					&nbsp;
					<a class="btn btn-default" href="recipe">목록으로</a>
					&nbsp;
				</div>
				<div>
					<div class="detailBox">
						<div class="titleBox">
							<label>댓글 상자</label>
						</div>
						<div class="commentBox">

							<p class="taskDescription">Lorem Ipsum is simply dummy text
								of the printing and typesetting industry.</p>
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
			<!-- 실제 작성되는 레이아웃 끝 -->
			<div class="col-xs-2"></div>
		</div>
	</div>
</body>
</html>