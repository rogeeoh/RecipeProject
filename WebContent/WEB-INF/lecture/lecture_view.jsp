<%@include file="../inc/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
}

div.center {
	text-align: center;
	margin-top: 50px;
}

span#title {
	font-size: 50px;
}
.detailBox {
    width:640px;
    border:1px solid #bbb;
    margin:50px;
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
			<div class="col-xs-8">
				<div class="center">
					<img id="image_section" src="./images/간장계란밥.jpg"
						style="max-width: 100%; max-height: 500px" />
				</div>
				<div class="center">
					<span id="title">간장계란밥 강의 제목</span>
				</div>
				
				<div class="center">
					<h3>
						<span>간장계란밥</span> 강의
					</h3>
					<div class="recipeArea">
						<!-- ckeditor로 작성된 HTML태그가 들어가야 함 -->
						<textarea cols="100" rows="20">
크게 두 가지로 나뉘는데 바로 달걀을 풀어서 넣느냐 그냥 넣느냐이다.부먹이냐 찍먹이냐 애초에 요리인지도 애매하기 때문에 제대로 된 조리법 같은 것은 존재하지 않는다.[5] 일본 요리 블로그 등에 레시피가 올라와있기는 하지만 그건 그냥 그렇게 먹었더니 맛있더라 수준의 이야기고 그냥 밥 위에 계란을 얹으면 그게 바로 타마고 카케 고항. 냉장고에 있던 차가운 계란을 얹더라도 보온 정도의 따뜻한 밥이면 약간 식는것 뿐이지 먹는데는 지장이 없다.
그러나 그냥 날달걀만 넣으면 비리기 때문에[6] 간장이나 소금을 넣어서 간을 하는 경우도 있고, 김치, 야채절임, 김, 낫토와 함께 먹는 경우가 있으며 이것들을 밥에 섞느냐 아니면 그냥 따로 먹느냐도 취향 문제. 계란을 얹을 때도 밥에 홈을 파놓고 거기에 계랸을 넣기도 하지만 그렇게 하면 밥이 뜨거울 경우 계란이 반숙상태가 되는 경우가 있고 그것을 싫어하여, 혹은 그냥 귀찮아서(...) 그냥 바로 얹는 경우가 있다. 일단 얹은 다음에는 밥과 잘섞는 것이 보통이지만 처음부터 조미료를 넣어서 섞어놓은 계란을 밥 위에 타기도 한다.
넣는 것도 소금, 간장, 우스터 소스, 고추장, 마요네즈[7] 등으로 다양하다. 결국 개인의 입맛에 맞춰먹을 수 있다는 점도 인기요인 중에 하나일 것이다. 참고로 달걀을 넣을 때 전부 넣는 경우과 노른자만을 넣는 경우가 있다. 정말로 밥에 날달걀을 얹기만 하면 달걀밥인 셈.
한국에서는 역시 간장 치고 참기름 조금 넣어서 간과 냄새를 잡고 김치와 함께 먹는 것이 메이저. 이때 간장은 왜간장(진간장)을 넣는다. 참기름과 간장, 김치에 의한 간이 좋은 조화를 이루어 비린 맛을 잡아주는 점 역시 기여한다. 번들거리며 살짝 미끈거리는 듯한 느낌이 싫다면 이 상태에서 전자레인지에 30초~1분 정도 돌려주자. 계란이 익어서 식감이 살짝 달라진다.
또 다른 방법으로는 뚜껑 있는 그릇을 뜨겁게 달궈[8] 뜨거운 밥을 넣은 다음 그 위에 날계란을 얹은 다음 섞지 말고 뚜껑을 덮고 보자기 등에 싸서 30분 가량 기다린다. 그 다음 그릇을 열어보면 계란이 완전히 익은 것처럼 굳지는 않았는데, 날것 냄새도 나지 않는 적절한 상태가 되어 있다. 여기에 간장 이나 양념 등으로 간을 한 다음 먹으면 새로운 맛이 난다.
한편, 이걸 기름 두른 웍에다가 넣고 열나게(!!) 볶아주면 황금 볶음밥이 된다.[9]
밥위에 참치와 케첩을 섞어먹으면 매우 맛있다. 들기름대신 참치기름을 이용하는게 포인트. 케첩이 없다면 베이크드빈즈를 넣어 먹어보자. 케첩이 없을 확률보다 베이크드빈즈가 없을 가능성이 훨씬 큰건 안비밀
						</textarea>
					</div>
				</div>
				<div style="text-align: right; margin-top: 25px">
					<button class="btn btn-default">좋아요</button>
					&nbsp;
					<button class="btn btn-default">수정</button>
					&nbsp;
					<button class="btn btn-default">목록</button>
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