<%@include file="../inc/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 아이템즈</title>
<style>
/* 썸네일의 크기를 고정하기 위한 설정 */
.carousel-inner>.item>a>img, .carousel-inner>.item>img, .img-responsive,
	.thumbnail a>img, .thumbnail>img {
	display: block;
	max-width: 100%;
	height: 300px;
}
/* pagination 색 설정 */
.pagination>li>a {
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

.pagination>li>a:focus, .pagination>li>a:hover, .pagination>li>span:focus,
	.pagination>li>span:hover {
	z-index: 2;
	color: #23527c;
	background-color: #eee;
	border-color: #ddd;
}
/* paginationDiv 가운데 정렬 */
#paginationDiv {
	text-align: center;
}
/* 제목링크 밑줄 삭제 */
a, a:focus, a:hover {
	text-decoration: none;
	overflow: visible;
}
/* 이미지 제목이 2줄을 넘어가면 짜름 */
h3 {
	height: 26px;
	overflow: hidden;
}
/* p태그의 내용이 2줄을 넘어가면 짜름 */
p {
	height: 43px;
	overflow: hidden;
}
</style>
</head>
<body id="body">
<div id="content">
	<div class="container">
		<div class="row">
			<c:forEach items="${boardList}" var="board">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="/recipe_project/recipe?no=${board.recp_no}"><img src="${board.url}"></a>
					<div class="caption">
						<h3>
							<a href="/recipe_project/recipe?cmd=${board.recp_no }">${board.recp_name}</a>
						</h3>
						<p>${board.recp_intro}</p>
					</div>
				</div>
			</div>
			</c:forEach>
		<div id="paginationDiv"></div>
		</div>
	</div>
</div>
	<div id="page-selection">
		<nav class="text-center">
			<a class="btn btn-default pull-left">처음으로</a>
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"><span
						aria-hidden="true">«</span></a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"><span
						aria-hidden="true">»</span></a></li>
			</ul>
			<a class="btn btn-default pull-right" href="recipe?cmd=write">글쓰기</a>
		</nav>
	</div>
	<script>
		// 스크립트 참조 -> http://botmonster.com/jquery-bootpag/#.WmckQ65l-70
		// init bootpag
		$('#paginationDiv').bootpag({
			total : 50,
			page : 1,
			maxVisible : 5,
			leaps : true,
			firstLastUse : true,
			first : '시작 ',
			last : '끝',
			wrapClass : 'pagination',
			activeClass : 'active',
			disabledClass : 'disabled',
			nextClass : 'next',
			prevClass : 'prev',
			lastClass : 'last',
			firstClass : 'first'

		}).on("page", function(event, num) {
			/* 여기부터 수정해서 페이지 내용을 추가하면 된다.*/
			$("#content").html($(".container").html());
		});
	</script>
</body>
</html>