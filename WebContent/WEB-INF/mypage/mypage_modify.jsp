<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 수정</title>
<link href="./css/toggle-switch.css" rel="stylesheet">
<link href="./css/bootstrapValidator.css" rel="stylesheet">
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="./js/bootstrapValidator.js"></script>

<link href="./css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body>
	<div style="text-align: center"><h1><b>내정보 수정</b></h1></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" id="registerForm" method="post"
					action="#">
					<div class="form-group form-group-lg">
						<div class="col-md-6 col-md-offset-3 control">
							<label class="sr-only" for="email">이메일</label> <input
								type="email" id="email" name="email" class="form-control"
								placeholder="email@email.com" required="required" />
						</div>
					</div>
					<div class="form-group form-group-lg">
						<div class="col-md-6 col-md-offset-3 control">
							<label class="sr-only" for="pw">비밀번호</label> <input
								type="password" id="pw" name="pw" class="form-control"
								placeholder="비밀번호" required="required" />
						</div>
					</div>
					<div class="form-group form-group-lg">
						<div class="col-md-6 col-md-offset-3 control">
							<label class="sr-only" for="pwCheck">비밀번호 확인</label> <input
								type="password" id="pwCheck" name="pwCheck" class="form-control"
								placeholder="비밀번호" required="required" />
						</div>
					</div>
					<div class="form-group form-group-lg">
						<div class="col-md-6 col-md-offset-3 control">
							<label class="sr-only" for="nickName">닉네임</label> <input
								type="text" id="nickName" name="nickName" class="form-control"
								placeholder="닉네임" required="required" />
						</div>
					</div>
					<div class="form-group form-group-lg">
						<div class="col-md-6 col-md-offset-3 control">
							<label class="sr-only" for="birth">생년월일</label> <input
								type="date" id="birth" name="birth" class="form-control"
								placeholder="1992-02-17" required="required" />
						</div>
					</div>
					<div class="form-group form-group-lg">
						<div class="col-md-6 col-md-offset-3 control">
							<label class="sr-only" for="tel">연락처</label> <input type="tel"
								id="tel" name="tel" class="form-control"
								placeholder="01055050142" required="required" />
						</div>
					</div>
					<div class="form-group form-group-lg">
						<div class="col-md-2 col-md-offset-3" id="imgManDiv">
							<img class="imgMan" src="./images/man.png"></img><span
								id="spanMan">남자</span>
						</div>
						<div class="col-md-2" id="switchDiv">
							<input type="checkbox" id="switch" /><label for="switch">토글</label>
						</div>
						<div class="col-md-2">
							<img class="imgWoman" src="./images/woman.png"
								style="display: none" /></img><span id="spanWoman"
								style="display: none">여자</span>
						</div>
					</div>
					<div class="form-group form-group-lg" id="imgWomanDiv">
						<div class="col-md-6 col-md-offset-3 control">
							<button class="btn btn-primary btn-lg btn-block" type="submit">수정하기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#switch").on("click", function() {
				$(".imgMan").toggle();
				$(".imgWoman").toggle();
				$("#spanMan").toggle();
				$("#spanWoman").toggle();
			});
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#registerForm').bootstrapValidator({
				message : '정확히 입력해 주세요',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					email : {
						validators : {
							notEmpty : {
								message : '반드시 이메일을 입력해 주세요'
							},
							emailAddress : {
								message : '유효하지 않은 이메일입니다.'
							}
						}
					},
					pw : {
						validators : {
							notEmpty : {
								message : '반드시 비밀번호를 입력해 주세요.'
							},
							stringLength : {
								min : 8,
								max : 16,
								message : '비밀번호는 최소 8글자, 최대16글자까지 됩니다.'
							},
							identical : {
								field : 'pwCheck',
								message : '비밀번호 확인과 일치하지 않습니다.'
							}
						}
					},
					pwCheck : {
						validators : {
							notEmpty : {
								message : '반드시 비밀번호 확인을 입력해 주세요.'
							},
							stringLength : {
								min : 8,
								max : 16,
								message : '비밀번호는 최소 8글자, 최대16글자까지 됩니다.'
							},
							identical : {
								field : 'pw',
								message : '비밀번호와 일치하지 않습니다.'
							}
						}
					},
					nickName : {
						message : '유효하지 않은 닉네임 입니다.',
						validators : {
							notEmpty : {
								message : '반드시 닉네임을 입력해주세요.'
							},
							stringLength : {
								min : 2,
								max : 8,
								message : '닉네임은 최소 2글자, 최대8글자까지 됩니다.'
							},
							regexp : {
								regexp : /^[a-zA-Z0-9_\.]+$/,
								message : '닉네임은 문자, 숫자, 점 그리고 언더바로만 이루어져야합니다.'
							}
						}
					},
					tel : {
						validators : {
							notEmpty : {
								message : '반드시 전화번호를 입력해주세요.'
							},
							phone : {
								message : '유효하지 않은 핸드폰 번호입니다. 숫자만 입력하세요.'
							}
						}
					},
					birth : {
						validators : {
							notEmpty : {
								message : '반드시 생일을 입력해주세요.'
							},
							date : {
								message : '정확한 날짜를 입력하세요.'
							}
						}
					},
				}
			});
		});
	</script>
</body>
</html>