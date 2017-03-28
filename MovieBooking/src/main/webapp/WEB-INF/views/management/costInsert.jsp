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
	<title>Mega Box Admin - 단가 등록</title>
	
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
	<!-- 지점별 영화매출 통계 -->
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	
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
					<a href="adminMain">
						<img src="resources/assets/img/megaboxlogo.JPG" class="img-circle" width="60">
					</a>
				</p>
				<!-- 사이드 바 원형로고 아래 텍스트 -->
				<h5 class="centered">Mega Box Admin Page</h5>
				<!-- 사이드 바 메인 메뉴 -->
				<li class="mt">
					<a href="adminMain">
						<i class="fa fa-home"></i>
						<span>H O M E</span>
					</a>
				</li>
				<!-- 지점, 지점관리자 사이드 메뉴-->
				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-desktop"></i>
						<span>지점/관리자 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="branchList">지점 목록</a>
						</li>
						<li>
							<a href="branchInsert">지점 등록</a>
						</li>
						<!-- 수정페이지는 목록에서 진입 -->
						<!-- <li>
							<a href="branchModify">지점 수정</a>
						</li> -->
						<!-- <li>
							<a href="branchDelete">지점 탈퇴</a>
						</li> -->
						<li>
							<a href="adminList">지점 관리자 목록</a>
						</li>
						<li>
							<a href="adminInsert">지점 관리자 등록</a>
						</li>
						<!-- 수정페이지는 목록에서 진입 -->
						<!-- <li>
							<a href="adminModify">지점 관리자 수정</a>
						</li> -->
						<!-- <li>
							<a href="adminDelete">지점 관리자 삭제</a>
						</li> -->
					</ul>
				</li>
				<!-- 회원 사이드 메뉴 -->
				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-list"></i>
						<span>회원 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="memberList">회원 목록</a>
						</li>
					</ul>
				</li>
				<!-- 영화 사이드 메뉴 -->
				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-tasks"></i>
						<span>영화 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="adminMovieList">영화 목록</a>
						</li>
						<li>
							<a href="movieInsert">영화 등록</a>
						</li>
						<!-- 수정페이지는 목록에서 진입 -->
						<!-- <li>
							<a href="adminModify">영화 수정</a>
						</li> -->
					</ul>
				</li>
				<!-- 인물 사이드 메뉴 -->
				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-user"></i>
						<span>인물 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="characterList">인물 목록</a>
						</li>
						<li>
							<a href="characterInsert">인물 등록</a>
						</li>
						<!-- 수정페이지는 목록에서 진입 -->
						<!-- <li>
							<a href="characterModify">인물 수정</a>
						</li> -->
					</ul>
				</li>
				<!-- 단가/할인정보 사이드 메뉴 -->
				<li class="sub-menu">
					<a class="active" href="javascript:;">
						<i class="glyphicon glyphicon-credit-card"></i>
						<span>단가/할인 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="costList">단가 목록</a>
						</li>
						<li class="active">
							<a href="costInsert">단가 등록</a>
						</li>
						<!-- <li>
							<a href="costModify">단가 수정</a>
						</li> -->
						<li>
							<a href="discountInfoList">할인정보 목록</a>
						</li>
						<li>
							<a href="discountInfoInsert">할인정보 등록</a>
						</li>
						<!-- <li>
							<a href="discountInfoModify">할인정보 수정</a>
						</li> -->
					</ul>
				</li>
				<!-- 통계 사이드 메뉴 -->
				<li class="sub-menu"><a href="javascript:;">
					<i class=" fa fa-bar-chart-o"></i>
					<span>통계 관리</span>
				</a>
					<ul class="sub">
						<li>
							<a href="analisysByMovie">영화별 예매/매출 </a>
						</li>
						<li>
							<a href="analisysByBranch">지점별 예매/매출 </a>
						</li>
						<li>
							<a href="analisysByDate">날짜별 예매/매출 </a>
						</li>
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
			<div class="container" style="margin: 0 auto;">
				<div class="jumbotron">
					<h2 class="logo">단가 등록</h2>
				</div>
				<div class="col-lg-3"></div>
				<div class="col-lg-6" style="float: left: ;">
					<form action="costInsert" class="form-horizontal" method="post">
						<fieldset>
							<legend>add</legend>
							<!-- 상영종류 -->
							<div class="form-group">
								<label class="col-lg-2 control-label">상영종류</label>
								<div class="col-lg-8">
									<select name="sccoScreen" class="form-control">
										<option>2D</option>
										<option>3D</option>
										<option>IMAX</option>
									</select>
								</div>
							</div>
							<!-- 가격 -->
							<div class="row form-group">
								<label class="col-lg-2 control-label">가격</label>
								<div class="col-lg-8">
									<input type="text" name="sccoPrice" class="form-control" placeholder="가격을 입력하세요" required="required">
								</div>
							</div>
							<!-- 적용연도 -->
							<div class="form-group">
								<label class="col-lg-2 control-label">적용연도</label>
								<div class="col-lg-8">
									<input type="text" name="sccoApplyYear" class="form-control" placeholder="적용연도를 입력하세요" required="required">
								</div>
							</div>
							<!-- 적용상태 -->
							<div class="form-group">
								<label class="col-lg-2 control-label">적용상태</label>
								<div class="col-lg-8">
									<select name="sccoStatus" class="form-control">
										<option>적용</option>
										<option>미적용</option>
									</select>
								</div>
							</div>
							<!-- 등록버튼 -->
							<div class="form-group">
								<label class="col-lg-2 control-label"></label>
								<div class="col-lg-8 ">
									<div class="col-lg-8 col-lg-offset-10 ">
										<input type="submit" class="btn btn-button" value="등록">
									</div>
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