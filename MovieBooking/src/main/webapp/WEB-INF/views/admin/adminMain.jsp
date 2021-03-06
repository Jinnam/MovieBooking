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
	<title>Mega Box Admin - Admin Main</title>
	
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

	<!-- 상단부분 import -->
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
					<a class="active" href="adminMain">
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
	<!--여기까지 사이드바-->
	<!--여기부터 메인-->
	<section id="main-content">
		<section class="wrapper">
			<div class="row">
				<!-- 페이지 강제 줄임 -->
				<div class="col-lg-9 main-chart" align="center"></div>
			</div>
			
			<!-- 메인 그래프 지점별 영화 매출-->
			<div id="branchGraph" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
			<!-- 메인 그래프 지점별 영화 매출-->
			<br/>
			
			<!-- 월 매출 라인그래프 -->
			<div class="col-md-6 col-sm-4 mb">
				<div class="darkblue-panel pn">
					<div class="darkblue-header">
						<h5>월 매출</h5>
					</div>
					<div class="chart mt">
						<div class="sparkline" data-type="line" data-resize="true"
							data-height="75" data-width="90%" data-line-width="1"
							data-line-color="#fff" data-spot-color="#fff"
							data-fill-color="" data-highlight-line-color="#fff"
							data-spot-radius="4"
							data-data="[
								<c:forEach var="selectMonthBranchCount" items="${selectMonthBranchCount}" varStatus="status">
									${selectMonthBranchCount.brcCntSaleTotal}
									<c:if test="${not status.last}">,</c:if>
								</c:forEach>]">
						</div>
					</div>
					<div class="mt">
						<b>&#8361; ${selectBranchCount}</b>
						<br />월 매출액
					</div>
				</div>
			</div>
			<!-- 월 매출 라인그래프 -->
			
			<!-- 하단 우측 예매율 순위 차트 -->
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">예매율 순위 (1위부터 4위까지)</div>
					<div class="panel-body">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>순위</th>
									<th>제목</th>
									<th>개봉일</th>
									<th>누적관객수(천명)</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="clientCount" varStatus="status" items="${selectClientCount}">
									<tr>
										<td>${status.count}</td>
										<td>${clientCount.movKorName}</td>
										<td>${clientCount.movOpenDate}</td>
										<td>${clientCount.brcCntClientCount}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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
	<script type="application/javascript">
		/* $(document).ready(function () {
			$("#date-popover").popover({html: true, trigger: "manual"});
			$("#date-popover").hide();
			$("#date-popover").click(function (e) {
				$(this).hide();
			});
			$("#my-calendar").zabuto_calendar({
				action: function () {
					return myDateFunction(this.id, false);
				},
				action_nav: function () {
					return myNavFunction(this.id);
				},
				ajax: {
					url: "show_data.php?action=1",
					modal: true
				},
				legend: [
					{type: "text", label: "Special event", badge: "00"},
					{type: "block", label: "Regular event", }
				]
			});
		});
		function myNavFunction(id) {
			$("#date-popover").hide();
			var nav = $("#" + id).data("navigation");
			var to = $("#" + id).data("to");
			console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
		} */
	</script>
	
	<script src="resources/adminjs/highChart.js"></script>
	<!-- 메인화면 상단 바 그래프 자바 스크립트 -->
	<script type="text/javascript">
	//표에 어떻게 뿌리는지 모르겠다...
	//배열 객체 생성
	var BranchNameGraphList = new Array();											//지점이름 값 담을 객체 생성
	var BranchCodeGraphList = new Array();											//지점코드 값 담을 객체 생성
	var MovieNameGraphList = new Array();											//영화이름 값 담을 객체 생성
	var MovieCodeGraphList = new Array();											//영화코드 값 담을 객체 생성
	var SaleGraphList = new Array();												//영화매출 값 담을 객체 생성
	//매출 탑 5지점
	<c:forEach	var = "selectBranchForBarGraph"
				items = "${selectBranchForBarGraph}">
				BranchNameGraphList.push('${selectBranchForBarGraph.brcName}')		//BranchNameGraphList에 push메서드로 값 넣기
				BranchCodeGraphList.push('${selectBranchForBarGraph.brcCode}')		//BranchCodeGraphList에 push메서드로 값 넣기
				SaleGraphList.push('${selectBranchForBarGraph.brcCntSaleTotal}')	//SaleGraphList에 push메서드로 값 넣기
	</c:forEach>

	//매출 탑 3영화
	<c:forEach	var = "MovieCodeForCircleGraph"
				varStatus = "status"
				items = "${MovieCodeForCircleGraph}">
				MovieNameGraphList.push('${MovieCodeForCircleGraph.movKorName}')	//MovieNameGraphList에 push메서드로 값 넣기
				MovieCodeGraphList.push('${MovieCodeForCircleGraph.movCode}')		//MovieCodeGraphList에 push메서드로 값 넣기
	</c:forEach>

	//log
	
	console.log("******************************영화/지점매출순위********************************")
	console.log("영화매출3순위 이름 배열(top3) : "+MovieNameGraphList)
	console.log("영화매출3순위 이름 코드(top3) : "+MovieCodeGraphList)
	console.log("지점매출5순위 이름 배열(top5) : "+BranchNameGraphList)
	console.log("지점매출5순위 이름 코드(top5) : "+BranchCodeGraphList)
	console.log("******************************영화/지점매출순위********************************")
	console.log("")
	
	//data배열로 넘기는 ajax세팅
	jQuery.ajaxSettings.traditional = true;
	
	$(document).ready(function(){
		$.ajax({
			url 		: "selectBranchCntSaleTatal",
			data 		: {"movCode" : MovieCodeGraphList},
			dataType 	: "json",
			type 		: "get",
			success 	: function(data) {
				
				//사용할 맵의 키, 값 분리 변수선언
				var key = Object.keys(data);
				var value = Object.values(data);
				
				//test log
				console.log("key : "+key);
				console.log("vlaue : "+value);
				for(var i in key) {
					console.log("key : "+key[i]+", value : "+data[key[i]] )
				}

				//여기부터 차트 시작
				Highcharts
				.chart(
					'branchGraph', {
						title: {
							text: '지점별 영화 매출(단위 월)'			//상단 타이틀
						},
						xAxis: {
							categories: BranchNameGraphList		//하단 지점 이름 상위 5개점
						},
						labels: {
							items: [{
								html: '', 		//원 그래프 타이틀
								style: {
									left: '50px',
									top: '18px',
									color: (Highcharts.theme && Highcharts.theme.textColor) ||
										'black'
								}
							}]
						},
						series: [
							{
								type: 'column',					//첫번째 하늘색 바 내용
								name: MovieNameGraphList[0],	//매출1위점 영화이름
								data: data[key[0]]				//[1위지점1위영화매출, 2위지점1위영화매출, 3위지점1위영화매출, 4위지점1위영화매출, 5위지점1위영화매출]
							},
							{
								type: 'column',					//두번째 검은색 바 내용
								name: MovieNameGraphList[1],	//매출2위점 영화이름
								data: data[key[2]]				//매출2위지점 영화매출 [1위지점2위영화매출, 2위지점2위영화매출,  3위지점2위영화매출,  4위지점2위영화매출,  5위지점2위영화매출]
							},
							{
								type: 'column',					//세번째 초록색 바 내용
								name: MovieNameGraphList[2],	//매출3위점 영화이름
								data: data[key[1]]				//매출3위지점 영화매출 [1위지점3위영화매출, 2위지점3위영화매출,  3위지점3위영화매출,  4위지점3위영화매출,  5위지점3위영화매출]
							},
							{
								type: 'spline',					//평균치 곡선 그래프 내용
								name: 'Average',
								data: [0, 0, 0, 0, 0],
								marker: {
									lineWidth: 0,
									lineColor: Highcharts.getOptions().colors[3],
									fillColor: 'white'
								}
							},
							{
								type: 'pie', //원그래프 내용
								name: 'Total consumption',
								data: [{
									name: MovieNameGraphList[0],
									y: 12840000,
									color: Highcharts
										.getOptions().colors[0]
									// 조작된도시 색상 하늘색
									},
									{
									name: MovieNameGraphList[1],
									y: 7246000,
									color: Highcharts
										.getOptions().colors[1]
									// 공조 색상 검은색
									},
									{
									name: MovieNameGraphList[2],
									y: 4440000,
									color: Highcharts
										.getOptions().colors[2]
									// 재심 색상 녹색
									}
								],
								//위치
								center: [100, 80],
								//사이즈
								size: 1,
								showInLegend: false,
								dataLabels: {
									//원그래프 목록
									enabled: false
								}
							}
						]
				});
			}
		})
});
	</script>
</body>
</html>