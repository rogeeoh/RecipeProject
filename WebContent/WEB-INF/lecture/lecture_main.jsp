<%@include file="../inc/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby1.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목여기는 제목여기는 제목여기는 제목여기는 제목여기는 제목여기는 제목여기는
								제목여기는 제목여기는 제목여기는 제목여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~
							블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby2.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby3.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby4.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby5.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby6.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby1.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby2.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby3.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby4.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby5.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"><img src="./images/bby6.jpg"></a>
					<div class="caption">
						<h3>
							<a href="#">여기는 제목</a>
						</h3>
						<p>여기는 내용을 설명하는 곳이랑게~ 블라블라블라블라블라블라블라블라</p>
					</div>
				</div>
			</div>
		</div>
		<div id="paginationDiv"></div>
	</div>
	<div id="content">Dynamic Content goes here</div>
	<div id="page-selection">Pagination goes here</div>
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