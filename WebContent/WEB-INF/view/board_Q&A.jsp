<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A게시판</title>
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
a {
    color: #74b243;
    text-decoration: none;
}
</style>
<style>
/* 버튼 및 페이지 버튼 관련 */
.btn{
	color: #fff;
	background-color: #74b243;
}
.btn-default:hover {
    color: #fff;
    background-color: #4caf50;
    border-color: #4caf50;
}
.pagination {
	display: inline-block;
	padding-left: 0;
	margin: 0;
	border-radius: 4px
}
.pagination>li>a{
    color: #74b243;
    background-color: #fff;
    border-color: #ddd;
}
.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,
	.pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover
	{
	z-index: 3;
	color: #fff;
	cursor: default;
	background-color: #74b243;
	border-color: #74b243
}
.pagination>li>a:focus, .pagination>li>a:hover, .pagination>li>span:focus, .pagination>li>span:hover {
    z-index: 2;
    color: #23527c;
    background-color: #eee;
    border-color: #ddd;
}
/* table css */
.table>thead>tr:hover, .table>tbody>tr:hover{
	color: #333;
	background-color: #e6e6e6;
	border-color: #adadad;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#">뽐내기</a></li>
					<li><a href="#">리뷰</a></li>
					<li class="active"><a href="#">문의</a></li>
					<li><a href="#">자유게시판</a></li>
				</ul>
			</div>
			<div class="col-md-9">

				<!--검색폼-->
				<form class="form-horizontal">
					<div class="input-group col-md-offset-7">
						<input type="text" class="form-control" placeholder="검색">
						<div class="input-group-btn">
							<button type="submit" class="btn btn-default">확인</button>
						</div>
					</div>
				</form>


				<!--게시판-->
				<div>
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>아이디</th>
									<th>날짜</th>
									<th>조회수</th>
									<th>댓글수</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>제모옥</td>
									<td>아뒤</td>
									<td>2018.1.xx</td>
									<td>5</td>
									<td>1</td>
								</tr>
								<tr>
									<td>1</td>
									<td>제모옥</td>
									<td>아뒤</td>
									<td>2018.1.xx</td>
									<td>5</td>
									<td>1</td>
								</tr>
								<tr>
									<td>1</td>
									<td>제모옥</td>
									<td>아뒤</td>
									<td>2018.1.xx</td>
									<td>5</td>
									<td>1</td>
								</tr>
								<tr>
									<td>1</td>
									<td>제모옥</td>
									<td>아뒤</td>
									<td>2018.1.xx</td>
									<td>5</td>
									<td>1</td>
								</tr>
								<tr>
									<td>1</td>
									<td>제모옥</td>
									<td>아뒤</td>
									<td>2018.1.xx</td>
									<td>5</td>
									<td>1</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div>
					<nav>
						<a class="btn btn-default pull-right">글쓰기</a> <a
							class="btn btn-default pull-left">처음으로</a>
					</nav>
					<nav class="text-center">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
</html>