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
			<form class="form-horizontal col-xs-8 col-xs-offset-2">
				<div class="form-group" style="text-align: center">
					<img id="image_section" src="/recipe_project/images/alterRecipeImg.gif"
						style="max-width: 100%; max-height: 200px" /> <input type="file"
						id="imgInput" />
				</div>
				<div class="form-group" style="margin-top: 20px">
					<label for="title"> 뽐내기 제목 </label>
					<input type="text" class="form-control" id="title">
				</div>
				<div class="form-group">
					<label for="summary"> 요리 간단 소개 </label>
					<input type="text" class="form-control" id="summary">
				</div>
				<br> <br>
				<div class="form-group">
					<label> 내용 상세 </label><br>
					<p class="help-block">뽐내기를 적어주세요</p>
					<textarea name="editor1" id="editor1" row
						justify-content-centers="10" cols="80">
          			    	자랑할 내용을 적어주세요!
        			 	</textarea>
					<script>
						CKEDITOR.replace('editor1', {
							'filebrowserUploadUrl' : '/imageupload?'
									+ 'realUrl=/recipe_project/images/'
									+ '&realDir=images'
						});
					</script>
				</div>

				<div style="text-align: center; margin-top: 20px">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>