<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="showoffDiv col-md-9">
	<div class="row">
		<!-- 게시글 등록하기 -->
		<a class="btn btn-block" href="/recipe_project/community/showoff?cmd=write"><h1>게시글 등록하기</h1></a>
		<!-- 게시글 리스트 -->
		<c:forEach var="showoff" items="${showoffList}">
			<div class="col-md-2 col-sm-2 col-xs-2" id="info">
				<!-- 프로필 사진 -->
				<img src="/recipe_project/images/bby1.jpg" class="img-circle">
			</div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12" id="titleDiv">
						<h2>${showoff.title}</h2>
					</div>
					<div class="col-md-8" id="nickNameDiv">
						<h3>${showoff.mem_no}</h3>
						<p>${showoff.date}</p>
					</div>
					<div class="col-md-2" id="viewDiv">
						<h3>
							<span id="viewCnt"><i class="glyphicon glyphicon-eye-open"></i>${showoff.cnt}</span>
						</h3>
					</div>
					<div class="col-md-2" id="likeDiv">
						<h3>
							<span id="likeCnt"><i
								class="glyphicon glyphicon-thumbs-up"></i>${showoff.likes}</span>
						</h3>
					</div>
					<div class="col-md-12" id="summaryDiv">
						<span>${showoff.photo_intro}</span>
					</div>
					<div class="col-md-12" id="imgDiv">
						<!-- /recipe_project/images/bby1.jpg -->
						<a href="#"><img src="${showoff.photo_url}"></a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>