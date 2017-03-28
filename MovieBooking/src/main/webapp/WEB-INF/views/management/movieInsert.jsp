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
	<title>Mega Box Admin - 영화 등록</title>
	
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
					<a class="active" href="javascript:;">
						<i class="fa fa-tasks"></i>
						<span>영화 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="adminMovieList">영화 목록</a>
						</li>
						<li class="active">
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
					<a href="javascript:;">
						<i class="glyphicon glyphicon-credit-card"></i>
						<span>단가/할인 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="costList">단가 목록</a>
						</li>
						<li>
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
			<!-- 지점등록 폼 이름/지역/주소/상세설명/이미지경로-->
			<div class="container" style="margin: 0 auto;">
				<div class="jumbotron">
					<h2 class="logo">영화 등록</h2>
				</div>
				<div class="col-lg-3"></div>
				<div style="margin:0 auto;">
					<form action="movieInsert" enctype="multipart/form-data" class="col-lg-12 form-horizontal" method="post">
						<!-- 첫번째 필드셋 -->
						<fieldset class="col-lg-5" style="float:left;">
							<legend>add</legend>
							
							<!-- 영화한글이름 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">영화한글이름</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" name="movKorName" placeholder="영화이름을 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 영화영문이름 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">영화영문이름</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" name="movEngName" placeholder="영화이름을 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 감독이름(한글) -->
							<div class="form-group"> 
								<label class="col-lg-3 control-label">감독이름조회</label>
								<div class="col-lg-7">
									<input type="text" class="form-control" id="charKorNameUseModal" name="charKorName" placeholder="감독이름을 입력하세요" required="required">
								</div>
								<!-- 감독이름으로 인물코드를 인물테이블에서 조회 ajax -->
								<div>
									<input type="button" id="selectCharcodeUseModalBtn" class="btn btn-button" data-toggle="modal" data-target="#DirModal" value="조회">
								</div>
							</div>
							
							<!-- 감독코드 출력 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">감독정보</label>
								<!-- 여기에 감독 코드 조회됨 -->
								<div class="col-lg-9">
									<input type="text" class="form-control" id="charCodeDir" name="charCode" required="required" readonly="readonly">
								</div>
								<div class="col-lg-3"></div>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="charKorNameDir" required="required" readonly="readonly">
								</div>
							</div>
							
							<!-- Modal -->
							<div class="modal fade" id="DirModal" role="dialog">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header">
											<!-- X버튼 -->
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">감독 검색</h4>
										</div>
										<div class="modal-body">
											<p>감독을 선택하세요</p>
											<table class="table table-striped table-hover">
												<thead>
													<tr>
														<th class="col-lg-2">&nbsp;</th>
														<th class="col-lg-2">감독이름</th>
														<th class="col-lg-2">감독코드</th>
														<th class="col-lg-2">국적</th>
														<th class="col-lg-2">생년월일</th>
														<th class="col-lg-2">성별</th>
														<th class="col-lg-2">선택</th>
													</tr>
												</thead>
												<tbody id="charName">
												<!-- 여기에 조회한 감독의 정보가 들어감 -->
												</tbody>
											</table>
										</div>
										<!-- Modal하단 닫기버튼 -->
										<div class="modal-footer">
											<input type="button" class="btn btn-default" data-dismiss="modal" value="Close">
										</div>
									</div>
								</div>
							</div>
							
							<!-- 주연배우이름(한글) -->
							<div class="form-group">
								<label class="col-lg-3 control-label">배우이름조회</label>
								<div class="col-lg-7">
									<input type="text" class="form-control" id="ActKorNameUseModal" name="charKorName" placeholder="주연배우를 입력하세요" required="required">
								</div>
								<!-- 주연배우이름으로 인물코드를 인물테이블에서 조회 ajax-->
								<div>
									<input id="selectCharcodeActor" type="button" class="btn btn-button"  data-toggle="modal" data-target="#ActModal" value="조회">
								</div>
							</div>

							<!-- 배우코드 출력 -->
							<div class="form-group" id="ActCharInfo">
							</div>

							<!-- Modal -->
							<div class="modal fade" id="ActModal" role="dialog">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header">
											<!-- X버튼 -->
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">배우 검색</h4>
										</div>
										<div class="modal-body">
											<p>배우를 선택하세요</p>
											<table class="table table-striped table-hover">
												<thead>
													<tr>
														<th class="col-lg-2">&nbsp;</th>
														<th class="col-lg-2">배우이름</th>
														<th class="col-lg-2">배우코드</th>
														<th class="col-lg-2">국적</th>
														<th class="col-lg-2">생년월일</th>
														<th class="col-lg-2">성별</th>
														<th class="col-lg-2">선택</th>
													</tr>
												</thead>
												<tbody id="charNameActor">
												<!-- 여기에 조회한 감독의 정보가 들어감 -->
												</tbody>
											</table>
										</div>
										<!-- Modal하단 닫기버튼 -->
										<div class="modal-footer">
											<input type="button" class="btn btn-default" data-dismiss="modal" value="Close">
										</div>
									</div>
								</div>
							</div>
							<!-- 국가이름 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">국가</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" name="movNation" placeholder="국가를 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 등급 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">등급</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" name="movGrade" placeholder="영화등급을 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 장르 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">장르</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" name="movGenre" placeholder="영화장르를 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 상세설명 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상세설명</label>
								<div class="col-lg-9">
									<textarea class="form-control" rows="3" name="movInfoDetail" required="required"></textarea>
								</div>
							</div>
						</fieldset>
						
						<!-- 두번째 필드셋 -->
						<fieldset class="col-lg-5" style="float:left;">
							<legend>&nbsp;</legend>
							
							<!-- 제작사 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">제작사</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" name="movMaker" placeholder="제작사를 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 상영시간 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상영시간</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" name="movRunningTime" placeholder="00:00:00 형식으로 입력해주세요" required="required">
								</div>
							</div>
							
							<!-- 개봉일 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">개봉일</label>
								<div class="col-lg-9">
									<input type="date" class="form-control" name="movOpenDate" placeholder="개봉일을 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 상영상태 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상영상태</label>
								<div class="col-lg-9">
									<select name="movStatus" class="form-control">
										<option>개봉전</option>
										<option>상영중</option>
										<option>종영</option>
									</select>
								</div>
							</div>
							
							<!-- 영상경로 영상경로는 유투브-영상선택-공유-소스코드 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">영상경로</label>
								<div class="col-lg-9">
									<input type="text" name="movVideoPath" class="form-control" placeholder="영상 경로를 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 포스터이미지 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">포스터이미지</label>
								<div class="col-lg-9">
									<input type="text" name="movImgPath" class="form-control" placeholder="이미지 경로를 입력하세요" required="required">
								</div>
							</div>
							
							<!-- 스틸컷이미지 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">스틸컷이미지</label>
								<div class="col-lg-7" id="steelCutImg">
									<input type="text" name="stcImgPath" class="form-control" placeholder="이미지 경로를 입력하세요" required="required">
								</div>
								<div class="col-lg-1">
									<input type="button" id="steelCutAddBtn" class="btn btn-button" value="추가">
								</div>
							</div>
							
							<!-- 포스터이미지 단일파일 미구현 & 파일크기때문에 사용 x-->
							<!-- <div class="form-group">
								<label class="col-lg-3 control-label">포스터이미지</label>
								<div class="col-lg-9">
									<input type="file" name="movImgPath" class="btn btn-button" placeholder="이미지 경로를 입력하세요" required="required">
								</div>
							</div> -->
							
							<!-- 스틸컷이미지 다중파일 업로드  미구현 & 파일크기때문에 사용 x-->
							<!-- <div class="form-group">
								<label class="col-lg-3 control-label">스틸컷이미지</label>
								<div class="col-lg-9">
									<input type="file" name="movImgPath" class="btn btn-button" placeholder="이미지 경로를 입력하세요" required="required">
								</div>
							</div> -->
							
							<!-- 등록버튼 -->
							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-10">
									<input type="submit" class="btn btn-button" value="입력">
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
	
	<!-- 인물(감독)코드 조회하기 modal-->
	<script src="resources/adminjs/adminSelectDirCharCodeUseModal.js"></script>
	<!-- 인물(배우)코드 조회하기 modal-->
	<script src="resources/adminjs/adminSelectActCharCodeUseModal.js"></script>

	<!-- 스틸컷추가  -->
	<script>
	$(function() {
		$("#steelCutAddBtn").click(function(){
			$("#steelCutImg").append(
					'<input class="form-control"'
					+'type="text" name="stcImgPath"'
					+'placeholder="이미지 경로를 입력하세요" required="required">'
				)
		})
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