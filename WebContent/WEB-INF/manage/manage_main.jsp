<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>
<style>
/* 왼쪽 사이드메뉴 색 */
.nav-pills>li.active>a, .nav-pills>li.active>a:focus {
	color: #fff;
	background-color: #74b243;
}

.nav-pills>li.active>a:hover {
	color: #fff;
	background-color: #4caf50;
}

a {
	color: #74b243;
	text-decoration: none;
}
</style>
<style>
/* 버튼 및 페이지 버튼 관련 */
.btn {
	color: #fff;
	background-color: #74b243;
}

.btn-default:hover {
	color: #fff;
	background-color: #4caf50;
	border-color: #4caf50;
}

.pagination {
	display: inline-block;
	padding-left: 0;
	margin: 0;
	border-radius: 4px
}

.pagination>li>a {
	color: #74b243;
	background-color: #fff;
	border-color: #ddd;
}

.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,
	.pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover
	{
	z-index: 3;
	color: #fff;
	cursor: default;
	background-color: #74b243;
	border-color: #74b243
}

.pagination>li>a:focus, .pagination>li>a:hover, .pagination>li>span:focus,
	.pagination>li>span:hover {
	z-index: 2;
	color: #23527c;
	background-color: #eee;
	border-color: #ddd;
}
/* table css */
.table>thead>tr:hover, .table>tbody>tr:hover {
	color: #333;
	background-color: #e6e6e6;
	border-color: #adadad;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 사이드 메뉴 -->
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="manage">회원관리</a></li>
					<li><a href="manage?cmd=board">게시물관리</a></li>
					<li><a href="manage?cmd=lecture">강좌관리</a></li>
				</ul>
			</div>
			<!-- 메인 컨텐츠 -->
			<div class="col-md-9">
				<!--게시판 -->
				<div>
					<div id="jsGrid"></div>
				</div>
				<!-- 페이지 -->
				<div>
					<nav class="text-center">
						<a class="btn btn-default pull-right">글쓰기</a>
						
						<a class="btn btn-default pull-left">처음으로</a>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
<script> 
    var myRend = function(value) {
        var result = "<td>";
        var arrs = value.split(',');
        for (var i in arrs) {
            var item = arrs[i];
            result = result + item + "<br>";
        }
        result = result + "</td>";
        return result;
    }
    
    $("#jsGrid").jsGrid({
        width: "100%",
        height: "800px",
 		/* 데이터 추가 여부 */
        inserting: true,
        /* 데이터 수정 여부 */
        editing: true,
        /* 정렬 가능 여부 */
        sorting: true,
        /* 페이지 구분 여부 */
        paging: true,
        /* 자동으로 데이터가 처음에 로드될거인지 확인
         * controller의 loadData를 실행시키기 위해 필수로 true로 설정해야함 */
        autoload: true,
        /* 삭제시 confirm을 받을때 뜨는 메시지 */
        deleteConfirm: "정말 삭제합니까?",
        controller: {
        	/* 맨 처음 브라우저가 로드되는 시점에 호출  
        	 * autoload 속성이 true여야지만 실행 */
        	 loadData: function(filter) {
                var d = $.Deferred();
             	$.ajax({
				    type: "GET",
				    url: "ZZZ.jsp",
				}).done(function(result){
                    d.resolve(result);
                });
				return d.promise(); 
             },
            /* +버튼이 눌리는 시점에 호출 */
            insertItem: function(item) {
            	alert('insertItem');
                return $.ajax({
                    type: "POST",
                    url: "jsonTest",
                    data: item
                });
            },
            /* 수정 후 체크버튼을 누르는 시점에 호출
             * 수정된 값이 클라이언트에서 보여야하기 때문에 Json return이 필요함 */
            updateItem: function(item) {
            	alert('updateItem');
                return $.ajax({
                    type: "POST",
                    url: "jsonTest",
                    data: item
                });
            },
            /* 삭제 후 confirm되는 시점에 호출
             * 클라이언트에서 삭제가 바로 되기 때문에 Json return이 필요 없음 */
            deleteItem: function(item) {
            	alert('deleteItem');
                return true;/*$.ajax({
                    type: "POST",
                    url: "delete_item",
                    data: item
                });*/
            },
        },
        /* 테이블 필드명과 데이터 속성을 설정해주는 곳 */
        fields: [
                {
                    align: "center",
                    width: "auto",
                    name: "team1",
                    title: "본부사역팀",
                    type: "text"
                },
                {
                    align: "center",
                    width: "auto",
                    name: "team2",
                    title: "사역팀",
                    type: "text"
                },
                {
                    align: "center",
                    width: "auto",
                    name: "pastor",
                    title: "교역자",
                    type: "text",
                },
                {
                    align: "center",
                    width: "auto",
                    name: "elder",
                    title: "장로",
                    type: "text",
                },
                {
                    align: "center",
                    width: "auto",
                    name: "cheif",
                    title: "팀장",
                    type: "text",
                },
                {
                    align: "center",
                    width: "auto",
                    name: "manager",
                    title: "총무",
                    type: "text",
                },
                {
                    align: "center",
                    width: "auto",
                    type: "control"
                }
            ]
    });
</script>
</html>