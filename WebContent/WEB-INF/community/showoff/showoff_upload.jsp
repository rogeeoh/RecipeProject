<%@include file="../../inc/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>뽐내기 게시판 글쓰기</title>
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
			<form class="form-horizontal col-xs-8 col-xs-offset-2" action="board_upload?board=showoff" method="post" enctype="multipart/form-data">
				<div class="form-group" style="text-align: center">
					<img id="image_section" src="/recipe_project/images/alterRecipeImg.gif"
						style="max-width: 100%; max-height: 200px" /> <input type="file"
						id="imgInput" name="pic_url"/>
				</div>
				<div class="form-group" style="margin-top: 20px">
					<label for="title"> 뽐내기 제목 </label>
					<input type="text" class="form-control" id="title" name="title">
				</div>
				<div class="form-group">
					<label for="content"> 뽐내기 내용 </label>
					<input type="text" class="form-control" id="content" name="content">
				</div>
				<div class="form-group">
					<label> 뽐내기 상세내용 </label><br>
					<textarea name="editor" id="editor" placeholder="사진을 추가해서 작성하실 수 있습니다."  rowjustify-content-centers="10" cols="80"></textarea>
					<script>
						CKEDITOR.replace('editor', {
							'filebrowserUploadUrl' : 'imageupload?'
									+ 'realUrl=/recipe_project/images/showoff/'
									+ '&realDir=images/showoff/'
						});
					</script>
				</div>
				<div style="text-align: center; margin-top: 20px">
					<button type="submit" class="btn btn-block">등록하기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>