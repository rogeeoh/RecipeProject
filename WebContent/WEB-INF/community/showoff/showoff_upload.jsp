<%@include file="../../inc/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>뽐내기 게시판 수정페이지</title>
<script src="/recipe_project/ckeditor/ckeditor.js"></script>
<script src="/recipe_project/js/jquery.min.js"></script>
<script>
	$(function() {
		$("#imgInput").on('change', function() {
			readURL(this);
		});
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#image_section').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<form class="form-horizontal col-xs-8 col-xs-offset-2" action="/recipe_project/community/showoff?cmd=post" method="post" enctype="multipart/form-data">
				<div class="form-group" style="text-align: center">
					<img id="image_section" src="/recipe_project/images/alterRecipeImg.gif"
						style="max-width: 100%; max-height: 200px" /> <input type="file"
						id="imgInput" name="photo_url"/>
				</div>
				<div class="form-group" style="margin-top: 20px">
					<label for="title"> 뽐내기 제목 </label>
					<input type="text" class="form-control" id="title" name="title">
				</div>
				<div class="form-group">
					<label for="summary"> 요리 간단 소개 </label>
					<input type="text" class="form-control" id="summary" name="intro">
				</div>
				<div style="text-align: center; margin-top: 20px">
					<button type="submit" class="btn btn-block">등록하기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>