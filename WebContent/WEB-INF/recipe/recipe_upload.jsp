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
			<!-- 업로드 하는 form 시작 -->
			<form action="board_upload?board=recipe" method="post" enctype="multipart/form-data">
				<input type="hidden" name="mem_no" value="${sessionScope.mem_no}"/>
				<div style="text-align: center">
					<img id="image_section" src="./images/alterRecipeImg.gif"
						style="max-width: 100%; max-height: 200px" />
					<input type="file" id="imgInput" name="image"/>
				</div>
				<div class="form-group" style="margin-top: 20px">
					<label> 레시피 제목 </label><br> <input type="text"
						class="form-control" name="title">
				</div>
				<div class="form-group">
					<label> 요리 간단 소개 </label><br> <input type="text"
						class="form-control" name="intro">
				</div>
				<br> <br>
				<div id="inputRecipeDiv">
					<div class="row">
						<div class="col-xs-7" style="text-align: center">
							<label> 재료 </label>
						</div>
						<div class="col-xs-3" style="text-align: center">
							<label> 중량 </label>
						</div>
						<div class="col-xs-2"></div>
					</div>
					<div class="row" style="margin-top: 10px;" id="0">
						<div class="col-xs-7">
							<input type="text" class="form-control" name="ingre">
						</div>
						<div class="col-xs-3">
							<input type="text" class="form-control" name="ingre_amount">
						</div>
						<div class="col-xs-2">
							<input type="button" class="btn btn-default" value="삭제"
								onclick="delIngredient('0')" />
						</div>
					</div>

					<div class="row" style="margin-top: 10px" id="1">
						<div class="col-xs-7">
							<input type="text" class="form-control" name="ingre">
						</div>
						<div class="col-xs-3">
							<input type="text" class="form-control" name="ingre_amount">
						</div>
						<div class="col-xs-2">
							<input type="button" class="btn btn-default" value="삭제"
								onclick="delIngredient('1')" />
						</div>
					</div>

					<div class="row" style="margin-top: 10px" id="2">
						<div class="col-xs-7">
							<input type="text" class="form-control" name="ingre">
						</div>
						<div class="col-xs-3">
							<input type="text" class="form-control" name="ingre_amount">
						</div>
						<div class="col-xs-2">
							<input type="button" class="btn btn-default" value="삭제"
								onclick="delIngredient('2')" />
						</div>
					</div>
				</div>
				<br> <input type="button" class="btn btn-default"
					onclick="fnAddRecipe()" value="추가" /> <br> <br> <br>
				<div class="form-group">
					<label> 내용 상세 </label><br>
					<p class="help-block">상세한 조리법을 적어주세요</p>
					<textarea name="editor" id="editor" row
						justify-content-centers="10" cols="80">
          			    	레시피를 적어주세요!
        			 	</textarea>
					<script>
						CKEDITOR.replace('editor', {
							'filebrowserUploadUrl' : 'imageupload?'
									+ 'realUrl=/recipe_project/images/recipe/'
									+ '&realDir=images/recipe/'
						});
					</script>
				</div>

				<div style="text-align: center; margin-top: 20px">
					<button type="submit" class="btn btn-default">Submit</button>
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
			newItem.innerHTML =
				"<div class='row justify-content-center' style='margin-top: 10px'>" +
					"<div class='col-xs-7'>" +
						"<input type='text' class='form-control' name='ingre'>" +
					"</div>" +
					"<div class='col-xs-3'>" +
						"<input type='text' class='form-control' id='intro' name='ingre_amount'>" +
					"</div>" +
					"<div class='col-xs-2'>" +
						"<input type='button' class='btn btn-default' value='삭제' onclick='delIngredient("+ count + ")'>" +
					"</div>" +
				"</div>";

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