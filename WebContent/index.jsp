<%@page contentType="text/html; charset=UTF-8"%>
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
.recipeItems a{
	color: #4caf50;
	text-decoration: none;
}
.recipeItems a:hover{
	color: #4caf50;
	font-weight: bold;
	text-decoration: none;
}
/* 썸네일 효과 */
.thumbnail:hover{
	box-shadow: 10px 10px 5px silver;
	text-decoration: none;
}
a.thumbnail:hover {
	border: 1px solid silver;
	color: silver;
}
</style>
<body>
	<jsp:include page="WEB-INF/inc/header.jsp"/>
    <div class="container-fluid">
        <div class="row">	
			<!-- 레시피 -->			
            <div class="col-sm-12">				
				<h3 class="recipeItems"><a href="#">레시피 </a></h3>						
				<div class="carousel slide" data-ride="carousel" id="carousel-1">
					<div class="carousel-inner" role="listbox">
						<!-- 첫 번째 케러셀 화면 -->
						<div class="item active">
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
							<div class="col-sm-2">
								<a class="thumbnail" href="#"><img src="./images/0fca5de1b17ae318422e8e1b5830900b1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</a>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/1b0e820676844e8ca16ba1fd83c160c91_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/1f1290750a53e195bb298fb675d3731f1_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/2cb510dc6f8852c06bf732ffde2db62b1_f.jpg"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/3a1f556a5c6dc4289b635a596c5e150c1_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
						</div>
						<!-- 두 번째 케러셀 화면 -->
						<div class="item">
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/0fca5de1b17ae318422e8e1b5830900b1_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/1b0e820676844e8ca16ba1fd83c160c91_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/1f1290750a53e195bb298fb675d3731f1_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/2cb510dc6f8852c06bf732ffde2db62b1_f.jpg"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/3a1f556a5c6dc4289b635a596c5e150c1_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
						</div>
						<!-- 세 번째 케러셀 화면 -->
						<div class="item">
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/0fca5de1b17ae318422e8e1b5830900b1_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/1b0e820676844e8ca16ba1fd83c160c91_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/1f1290750a53e195bb298fb675d3731f1_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/2cb510dc6f8852c06bf732ffde2db62b1_f.jpg"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><a href="#"><img src="./images/3a1f556a5c6dc4289b635a596c5e150c1_f.png"></a>
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div>
						<a class="left carousel-control" href="#carousel-1" role="button" data-slide="prev">
							<i class="glyphicon glyphicon-chevron-left"></i>
							<span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#carousel-1" role="button" data-slide="next">
							<i class="glyphicon glyphicon-chevron-right"></i>
							<span class="sr-only">Next</span>
						</a>
					</div>
					<ol class="carousel-indicators">
						<li data-target="#carousel-1" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-2" data-slide-to="1"></li>
						<li data-target="#carousel-3" data-slide-to="2"></li>
					</ol>
				</div>				
            </div><!-- end 레시피 -->
			
			<!-- 강좌 -->			
            <div class="col-sm-12">				
				<h3 class="recipeItems"><a href="#">강좌 </a></h3>						
				<div class="carousel slide" data-ride="carousel" id="carousel-2">
					<div class="carousel-inner" role="listbox">
					
						<!-- 첫 번째 케러셀 화면 -->
						<div class="item active">
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/0fca5de1b17ae318422e8e1b5830900b1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/1b0e820676844e8ca16ba1fd83c160c91_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/1f1290750a53e195bb298fb675d3731f1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/2cb510dc6f8852c06bf732ffde2db62b1_f.jpg">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/3a1f556a5c6dc4289b635a596c5e150c1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
						</div>
						<!-- 두 번째 케러셀 화면 -->
						<div class="item">
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/0fca5de1b17ae318422e8e1b5830900b1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/1b0e820676844e8ca16ba1fd83c160c91_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/1f1290750a53e195bb298fb675d3731f1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/2cb510dc6f8852c06bf732ffde2db62b1_f.jpg">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/3a1f556a5c6dc4289b635a596c5e150c1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
						</div>
						<!-- 세 번째 케러셀 화면 -->
						<div class="item">
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/0fca5de1b17ae318422e8e1b5830900b1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/1b0e820676844e8ca16ba1fd83c160c91_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/1f1290750a53e195bb298fb675d3731f1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/2cb510dc6f8852c06bf732ffde2db62b1_f.jpg">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="thumbnail"><img src="./images/3a1f556a5c6dc4289b635a596c5e150c1_f.png">
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
									</div>
								</div>
							</div>
							<div class="col-sm-1">
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div>
						<a class="left carousel-control" href="#carousel-2" role="button" data-slide="prev">
							<i class="glyphicon glyphicon-chevron-left"></i>
							<span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#carousel-2" role="button" data-slide="next">
							<i class="glyphicon glyphicon-chevron-right"></i>
							<span class="sr-only">Next</span>
						</a>
					</div>
					<ol class="carousel-indicators">
						<li data-target="#carousel-1" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-2" data-slide-to="1"></li>
						<li data-target="#carousel-3" data-slide-to="2"></li>
					</ol>
				</div>				
            </div><!-- end 강좌 -->   			
        </div><!-- end row -->
    </div><!-- end container -->
    <script src="./js/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
</body>
</html>