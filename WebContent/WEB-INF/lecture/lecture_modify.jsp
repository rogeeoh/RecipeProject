<%@include file="../inc/header.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bootstrap 3, from LayoutIt!</title>
<script src="./ckeditor/ckeditor.js"></script>
<script src="./js/jquery.min.js"></script>
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
		<div class="col-xs-2"></div>
		<div class="col-xs-8">
			<form>
				<div style="text-align: center">
					<img id="image_section" src="./images/alterRecipeImg.gif"
						style="max-width: 100%; max-height: 200px" /> <input type="file"
						id="imgInput" />
				</div>
				<div class="form-group" style="margin-top: 20px">
					<label> 강좌 제목 </label><br> <input type="text"
						class="form-control">
				</div>
				<div class="form-group">
					<label> 간단 소개 </label><br> <input type="text"
						class="form-control">
				</div>
				<br> <br>
				
				<br> <input type="button" class="btn btn-default"
					onclick="fnAddRecipe()" value="추가" /> <br> <br> <br>
				<div class="form-group">
					<label> 강좌 내용 상세 </label><br>
					<p class="help-block">수정할 강좌내용을 적어주세요</p>
					<textarea name="editor1" id="editor1" row
						justify-content-centers="10" cols="80">
          			    	강좌내용을 적어주세요!
        			 	</textarea>
					<script>
						CKEDITOR.replace('editor1', {
							'filebrowserUploadUrl' : 'upload.jsp?'
									+ 'realUrl=/Recipe_Project/upload_img/'
									+ '&realDir=upload_img'
						});
					</script>
				</div>

				<div style="text-align: center; margin-top: 20px">
					<button type="submit" class="btn btn-default">수정완료</button>
					<button class="btn btn-default">취소</button>
				</div>
			</form>
		</div>
		<div class="col-xs-2"></div>
	</div>
	<script>
		var count = 3;

		function fnAddRecipe() {
			var newItem = document.createElement("div");
			newItem.setAttribute("id", count);
			//			newItem.setAttribute("onclick", "delIngredient('recipe" + count + "')");
			newItem.innerHTML = "<div class='row justify-content-center' style='margin-top: 10px'><div class='col-xs-7'>"
					+ "<input type='text' class='form-control'></div><div class='col-xs-3'>"
					+ "<input type='text' class='form-control' id='intro'></div><div class='col-xs-2'>"
					+ "<input type='button' class='btn btn-default' value='삭제' onclick='delIngredient("
					+ count + ")'></div></div>";

			var div = document.getElementById("inputRecipeDiv");
			div.appendChild(newItem);
			count++;
		}

		function delIngredient(rm) {
			var element = document.getElementById(rm);
			element.parentNode.removeChild(element);
		}
	</script>
</body>
</html>