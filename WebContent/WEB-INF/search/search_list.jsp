<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index.jsp</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/styles.css">
</head>
<style>
/* 코르셀 제목 링크 */
.recipeItems a {
	color: #4caf50;
	text-decoration: none;
}

.recipeItems a:hover {
	color: #4caf50;
	font-weight: bold;
	text-decoration: none;
}
/* 썸네일 효과 */
.thumbnail:hover {
	box-shadow: 10px 10px 5px silver;
	text-decoration: none;
}

a.thumbnail:hover {
	border: 1px solid silver;
	color: silver;
}
</style>
<body>
	<jsp:include page="/WEB-INF/inc/header.jsp" />
	<div class="container-fluid">
		<h2>레시피 검색 리스트</h2>
		<div class="row">
			<div class="table-responsive"
				style="padding-left: 40px; padding-right: 40px">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>소개</th>
							<th>아이디</th>
							<th>날짜</th>
							<th>조회수</th>
							<th>댓글수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${recipeList}" var="recipe">
							<tr>
								<td>${recipe.recp_no}</td>
								<td><a href="/recipe_project/recipe?no=${recipe.recp_no}">${recipe.recp_name}</a></td>
								<td><a href="/recipe_project/recipe?no=${recipe.recp_no}">${recipe.recp_intro}</a></td>
								<td>${recipe.nick}</td>
								<td>${recipe.date}</td>
								<td>${recipe.cnt}</td>
								<td>999</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- end row -->
		<div style="text-align: right">
			<a href="#">더 많은 결과 보기</a>
		</div>
		<h2>커뮤니티 검색 리스트</h2>
		<div class="row">
			<div>
				<div class="table-responsive"
					style="padding-left: 40px; padding-right: 40px">
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
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- end row -->
		<div style="text-align: right">
			<a href="#">더 많은 결과 보기</a>
		</div>
		<h2>강좌 검색 리스트</h2>
		<div class="row">
			<div>
				<div class="table-responsive"
					style="padding-left: 40px; padding-right: 40px">
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
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- end row -->
		<div style="text-align: right">
			<a href="#">더 많은 결과 보기</a>
		</div>
	</div>
	<!-- end container -->
	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>