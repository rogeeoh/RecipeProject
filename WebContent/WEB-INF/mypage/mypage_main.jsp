<%@include file="../inc/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>마이 페이지</title>
<style>
/* tab-content 중앙정렬 */
 .tab-content{
    text-align: center;
 }
/* 드롭다운 메뉴 조절*/
.nav-justified>.dropdown .dropdown-menu {
    top: auto;
    left: auto;
    width: 100%;
    border-radius: 10px;
}
.dropdown-menu>li>a {
   color: #74b243;
   font-weight: bold;
}

.dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover {
   color: #fff;
   text-decoration: none;
   background-color: #4caf50
}

.dropdown-menu>.active>a, .dropdown-menu>.active>a:focus, .dropdown-menu>.active>a:hover
   {
   background-color: #74b243;
   color: #fff;
   outline: 0;
   text-decoration: none;
}
/* nav 색 조절 */
.nav-pills>li.active>a, .nav-pills>li.active>a:focus {
    background-color: #74b243;
    color: #fff;
}
.nav-pills>li>a:hover, .nav-pills>li.active>a:hover {
    background-color: #4caf50;
    color: #fff;
}
.nav-pills>li>a{
   color: #74b243;
   font-weight: bold;
}
/* tab-contens 정렬하기위해 table화 시킴 */
#table{
   display: table;
   width: 100%;
   margin-top: 1%;
   vertical-align: middle;
   text-align: center;
   
}
.rowDiv{
   display: table-row;
}
.cell {
   border-bottom: 1px solid silver;   
   display: table-cell;
   height: 100%;
   text-align: center;
   vertical-align: middle;
   padding-bottom: 8px;
}
/* 버튼 및 페이지 버튼 관련 */
button{
   background-color: #74b243;
   color: #fff;
}
button:hover {
    background-color: #4caf50;
    color: #fff;
}
</style>
</head>
<body>
   <div class="container">
      <div class="row">
         <div class="col-md-12">
            <!-- tab 메뉴 선택 -->
            <ul class="nav nav-pills nav-justified">
               <li class="active"><a data-toggle="pill" href="#myInfo">내 정보</a></li>
               <li><a data-toggle="pill" href="#myRecipe">내 레서피 보기</a></li>
               <li class="dropdown"><a class="dropdown-toggle"
                  data-toggle="dropdown" href="#">내 게시글 보기<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                     <li><a data-toggle="pill" href="#myShowOff">뽐내기 게시글 보기</a></li>
                     <li><a data-toggle="pill" href="#myQnA">Q&amp;A 게시글 보기</a></li>
                  </ul></li>
               <li><a data-toggle="pill" href="#myComment">내 댓글 보기</a></li>
            </ul>
            <!-- tab 메뉴 컨텐츠 -->
            <div class="tab-content">
               <!-- 내 정보 -->
               <div class="tab-pane fade in active" id="myInfo">
                  <div id="table">
                     <div class="rowDiv" id="row1">
                        <div class="cell">
                           <h3>프로필 사진</h3>
                        </div>
                        <div class="cell" style="overflow: hidden;">
                           <img src="./images/bby2.jpg" style="width: 400px; height: 300px; vertical-align: middle; border-radius: 50%;">
                        </div>
                     </div>
                     <div class="rowDiv" id="row2">
                        <div class="cell">
                           <h3>아이디</h3>
                        </div>
                        <div class="cell" id="id">
                           <h3>ohkk0217</h3>
                        </div>
                     </div>
                     <div class="rowDiv" id="row3">
                        <div class="cell">
                           <h3>닉네임</h3>
                        </div>
                        <div class="cell">
                           <h3>옴므과니</h3>
                        </div>
                     </div>
                     <div class="rowDiv" id="row4">
                        <div class="cell">
                           <h3>생년월일</h3>
                        </div>
                        <div class="cell">
                           <h3>2017/02/17</h3>
                        </div>
                     </div>
                     <div class="rowDiv" id="row5">
                        <div class="cell">
                           <h3>연락처</h3>
                        </div>
                        <div class="cell">
                           <h3>010-5505-0142</h3>
                        </div>
                     </div>
                     <div class="rowDiv" id="row6">
                        <div class="cell">
                           <h3>성별</h3>
                        </div>
                        <div class="cell">
                           <h3>남자</h3>
                        </div>
                     </div>
                     <div class="rowDiv" id="row7">
                        <div class="cell">
                           <h3>&nbsp;</h3>
                        </div>
                        <div class="cell">
                           <button class="btn btn-lg btn-block" data-toggle="modal" data-target="#pwCheck" >내 정보 변경하기</button>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- 비밀번호 변경 모달 -->
               <div class="modal fade" id="pwCheck">
                  <div class="modal-dialog">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title">비밀번호 확인</h4>
                        </div>
                        <div class="modal-body">
                           <form class="form-horizontal" method="post" action="myPage_update.jsp" id="pwForm">
                              <div class="form-group">
                                 <div class="control">
                                    <label class="sr-only" for="pw">비밀번호</label> <input
                                       type="password" id="pw" name="pw" class="form-control input-lg"
                                       placeholder="비밀번호" required="required" />
                                 </div>
                              </div>
                           </form>
                        </div>
                        <div class="modal-footer">
                           <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                           <button type="button" class="btn" id="pwCheckBtn">확인</button>
                        </div>
                     </div><!-- /.modal-content -->
                  </div><!-- /.modal-dialog -->
               </div><!-- /.modal -->               
               <div id="myRecipe" class="tab-pane fade">
                  <h3>내 레서피 보기</h3>
                  <p>내 러시피가 들어갈 곳</p>
               </div>
               <div id="myShowOff" class="tab-pane fade">
                  <h3>뽐내기 게시글 보기</h3>
                  <p>뽐내기 게시글이 들어갈 곳</p>
               </div>
               <div id="myQnA" class="tab-pane fade">
                  <h3>Q&amp;A 게시글 보기</h3>
                  <p>Q&amp;A 들어갈 곳</p>
               </div>
               <div id="myComment" class="tab-pane fade">
                  <h3>내 댓글보기</h3>
                  <p>흠..?</p>
               </div>
            </div><!-- end tab-content -->
         </div><!-- end col-md-12 -->
      </div><!-- end row -->
   </div><!-- end container -->
</body>
<script>
   $(document).ready(function(){
      $(".btn").click(function(){
         $("#pwCheck").on("shown.bs.modal", function(){
            $("#pw").focus();
            $("#pwCheckBtn").click(function(){
               /* 비밀번호가 일치한지 검사하는 ajax 코드필요 */               
               $("#pwForm").submit();
            });
         });
      });
   });
</script>
</html>\