<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="Dashboard">
	<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<title>Mega Box Admin - 상영관 등록</title>
	
	<!-- Bootstrap core CSS -->
	<link href="resources/assets/css/bootstrap.css" rel="stylesheet">
	<!--external css-->
	<link href="resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="resources/assets/css/zabuto_calendar.css">
	<link rel="stylesheet" type="text/css" href="resources/assets/js/gritter/css/jquery.gritter.css" />
	<link rel="stylesheet" type="text/css" href="resources/assets/lineicons/style.css">
	
	<!-- Custom styles for this template -->
	<link href="resources/assets/css/style.css" rel="stylesheet">
	<link href="resources/assets/css/style-responsive.css" rel="stylesheet">
	
	<script src="resources/assets/js/chart-master/Chart.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<!-- 상단 -->
	<%@include file="/WEB-INF/adminModule/header.jsp"%>
	
	<!--여기부터 사이드 바 -->
	<aside>
		<div id="sidebar" class="nav-collapse ">
			<ul class="sidebar-menu" id="nav-accordion">
				<p class="centered">
					<!-- 상단원형로고 -->
					<a href="branchMain">
						<img src="resources/assets/img/megaboxlogo.JPG" class="img-circle" width="60">
					</a>
				</p>
				<!-- 사이드 바 원형로고 아래 텍스트 -->
				<h5 class="centered">Mega Box Branch Page</h5>
				<!-- 사이드 바 메인 메뉴 -->
				<li class="mt">
					<a href="branchMain">
						<i class="fa fa-home"></i>
						<span>H O M E</span>
					</a>
				</li>
				
				<!-- 극장 사이드 메뉴 -->
				<li class="sub-menu">
					<a class="active" href="javascript:;">
						<i class="fa fa-film"></i>
						<span>상영관 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="screenList">상영관 목록</a>
						</li>
						<li class="active">
							<a href="screenInsert">상영관 등록</a>
						</li>
						<!-- 수정페이지는 목록에서 진입 -->
						<!-- <li>
							<a href="screenModify">상영관 수정</a>
						</li> -->
						<!-- <li>
							<a href="screenDelete">상영관 삭제</a>
						</li> -->
					</ul>
				</li>
				<!-- 상영일정 사이드 메뉴 -->
				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-play-circle"></i>
						<span>상영일정 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="screenScheduleList">상영일정 목록</a>
						</li>
						<li>
							<a href="screenScheduleInsert">상영일정 등록</a>
						</li>
						<!-- 수정페이지는 목록에서 진입 -->
						<!-- <li>
							<a href="screenScheduleModify">상영일정 수정</a>
						</li> -->
					</ul>
				</li>
			</ul>
		</div>
	</aside>
	<!-- 여기까지 사이드바-->
	
	<!-- 여기부터 메인 -->
	<section id="main-content">
		<section class="wrapper">
			<div class="row">
				<!-- 페이지 강제 줄임 -->
				<div class="col-lg-9 main-chart" align="center"></div>
			</div>
			<!-- 지점등록 폼 이름/지역/주소/상세설명/이미지경로-->
			<div class="container" style="margin: 0 auto;">
				<div class="jumbotron">
					<h2 class="logo">상영관 등록</h2>
				</div>
				<div class="col-lg-3"></div>
				<div class="col-lg-6" style="float: left: ;">
					<form action="screenInsert" class="col-lg-12 form-horizontal" method="post">
						<fieldset>
							<legend>add</legend>
							<!-- 지점이름 -->
							<div class="form-group"> 
								<label class="col-lg-3 control-label">지점이름</label>
								<div class="col-lg-5">
									<input type="text" id="brcName" name="brcName" class="form-control" placeholder="지점이름을 입력하세요" required="required">
								</div>
								<!-- 지점이름으로 지점코드를 지점테이블에서 조회 ajax-->
								<div class="col-lg-2">
									<input id="selectBrcCode" type="button" class="btn btn-button" value="조회"><span id="warningText"></span>
								</div>
							</div>
							<!-- 지점코드 출력 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">지점코드</label>
								<div class="col-lg-7">
									<input type="text" id="selectViewBrcCode" name="brcCode" class="form-control" required="required">
								</div>
							</div>
							<!-- 상영관이름 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상영관이름</label>
								<div class="col-lg-7">
									<input type="text" name="scrName" class="form-control" placeholder="상영관이름을 입력하세요 ex) 1관,2관,3관,4관" required="required">
								</div>
							</div>
							<!-- 행수 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">행</label>
								<div class="col-lg-7">
									<input type="text" name="scrRowSize" class="form-control" placeholder="행을 입력하세요" required="required">
								</div>
							</div>
							<!-- 열수 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">열</label>
								<div class="col-lg-7">
									<input type="text" name="scrColSize" class="form-control" placeholder="열을 입력하세요" required="required">
								</div>
							</div>
							<!-- 등록버튼 -->
							<div class="form-group">
								<label class="col-lg-2 control-label"></label>
								<div class="col-lg-8 col-lg-offset-8">
									<input type="submit" class="btn btn-button" value="등록">
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</section>
	</section>
	<!-- 여기까지 메인 -->
	
	<!-- 하단 -->
	<%@include file="/WEB-INF/adminModule/footer.jsp" %>
	
	<!-- 스크립트 -->
	<!-- 지점이름으로 지점코드 조회하기 -->
	<script>
		$(document).ready(function() {
			$("#selectBrcCode").click(function() {
				$.ajax({
					url : "selectBrcCode",
					data : {"brcName" : $("#brcName").val()},
					type : "post",
					success : function(data) {
						console.log(data)
						$("#selectViewBrcCode").val("")
						if(data==""){
							$("#selectViewBrcCode").val("존재하지 않는 지점입니다.");
							$("#brcName").val("").focus();
						}else{
							$("#selectViewBrcCode").val(data)	
						}
						
					}
				});
			});
		});
	</script>
	
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/assets/js/jquery.js"></script>
	<script src="resources/assets/js/jquery-1.8.3.min.js"></script>
	<script src="resources/assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/assets/js/jquery.scrollTo.min.js"></script>
	<script src="resources/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="resources/assets/js/jquery.sparkline.js"></script>

	<!--common script for all pages-->
	<script src="resources/assets/js/common-scripts.js"></script>
	<script type="text/javascript" src="resources/assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="resources/assets/js/gritter-conf.js"></script>

	<!--script for this page-->
	<script src="resources/assets/js/sparkline-chart.js"></script>
	<script src="resources/assets/js/zabuto_calendar.js"></script>
</body>
</html>