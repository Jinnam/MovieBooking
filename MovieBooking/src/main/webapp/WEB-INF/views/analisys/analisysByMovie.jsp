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
	
	<!--jQuery  -->
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
	
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
						<li>
							<a href="adminList">지점 관리자 목록</a>
						</li>
						<li>
							<a href="adminInsert">지점 관리자 등록</a>
						</li>
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
						<li>
							<a href="discountInfoList">할인정보 목록</a>
						</li>
						<li>
							<a href="discountInfoInsert">할인정보 등록</a>
						</li>
					</ul>
				</li>
				<!-- 통계 사이드 메뉴 -->
				<li class="sub-menu"><a class="active" href="javascript:;">
					<i class=" fa fa-bar-chart-o"></i>
					<span>통계 관리</span>
				</a>
					<ul class="sub">
						<li class="active">
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
	
	<!-- ******************************************************************************************************* -->
	<!-- 여기부터 메인 -->
	<section id="main-content">
		<section class="wrapper">
			<div class="row">
				<!-- 페이지 강제 줄임 -->
				<div class="col-lg-12 main-chart" align="center">
				
				<fieldset class="col-lg-4" style="float:left;">
					<legend>영화별 통계</legend>
					
				
					<!-- 영화 검색 -->
					<div class="form-group">
						<label class="col-lg-4 control-label">영화 검색</label>
						<div class="col-lg-6">
							<input type="text" id="movKorName" name="movKorName" class="form-control" value="공조" placeholder="영화이름을 입력하세요" required="required"/>
						</div>
						<!-- 영화코드 조회버튼 -->
						<div>
							<input id="selectMovieCode" type="button" class="btn btn-button" value="찾기">
						</div>
					</div>
					
					<!-- 영화 검색 결과 -->
					<div class="form-group" id="findCondition">
						<label class="col-lg-4 control-label">선택한 영화</label>
						<div class="col-lg-8">
							<input type="text" id="selectedMovie" class="form-control" readonly="readonly" value="공조"/>
						</div>
					</div>
					
					<!-- 지점 선택 -->
					<div class="form-group">
						<label class="col-lg-4 control-label">지점 선택</label>
						<div class="col-lg-8">
							<select class="form-control" id="brcName" name="brcName">
								<option value="전체">지점 전체</option>
								<c:forEach items="${branchInfo}" var="branchInfo">
									<option value="${branchInfo.brcName}">${branchInfo.brcName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<!-- 예매/매출 선택 -->
					<div class="form-group"> 
						<label class="col-lg-4 control-label">예매/매출 선택</label>
						<div class="col-lg-8">
							<select name="cntKind" id="cntKind" class="form-control">
								<option value="전체">전체</option>
								<option value="예매">예매</option>
								<option value="매출">매출</option>
							</select>	
						</div>
					</div>
					
					<!-- 통계 검색 버튼 -->
					<div class="form-group">
						<div class="col-lg-12" align="right">
							<input type="button" id="analBtn" class="btn" value="검색"/>
						</div>
					</div>

					
				</fieldset>
				<fieldset class="col-lg-8" style="float:left;">
					<legend>&nbsp;</legend>
					
					
					<!-- 선택 결과-->
					<div class="form-group">
							<div id="movSelectResult" class="col-lg-9"></div>
					</div>

			</fieldset>
						
		</div>
	</div>
	</section>
	<section class="wrapper">
		<div class="container">
			<div id="ajaxResult"></div>
		</div>
	</section>
</section>
	
	<!-- 여기까지 메인 -->
	
	<script>
	// 테이블 클릭 함수
		function selectFunction(value){
			$('#selectedMovie').val("");
			$('#selectedMovie').val(value);
			$('#movSelectResult').contents().remove();
		}
		$(document).ready(function(){
			
			// 영화이름으로 영화 목록 가져오기
			$('#selectMovieCode').click(function(){
				//ajax 시작
				$.ajax({
					url : "selectMovInfo", 
				      type :"post", 
				      data : { "movName" : $('#movKorName').val()},
				      success : function(data){ 
				    	  console.log(data);
							$('#movSelectResult').contents().remove();
							$('#movSelectResult')
							.append('<div class="col-lg-12">'+
										'<table class="table table-striped table-hover">'+
											'<thead>'+
												'<tr>'+
													'<td>번호</td>'+
													'<td>영화이름</td>'+
													'<td>장르</td>'+
													'<td>감독</td>'+
												'</tr>'+
											'</thead>'+
											'<tbody  id="resultInfo">'+
											'</tbody>'+
										'</table>'+
									'</div>');
				        $(data).each(function(i){
				        		$('#resultInfo')
				        		.append('<tr onclick="selectFunction(&quot;'+data[i].movKorName+'&quot;)">'+
											'<td>'+i+'</td>'+
											'<td>'+data[i].movKorName+'</td>'+
											'<td>'+data[i].movGenre+'</td>'+
											'<td>'+data[i].charKorName+'</td>'+
											'<td colspan="4">'+
											'</td>'+
										'</tr>')
				        })
				      },error:function(){
				          alert("error");
				       }
				   })
				// ajax 끝
			})
			// 영화 이름으로 영화찾기 끝
			
			var movKorName = 
			// 통계 정보 가져오기
			$('#analBtn').click(function(){
				$('#movSelectResult').contents().remove();
				$('#movSelectResult')
				.append('<div class="col-lg-12">'+
							'<label class="col-lg-4 control-label">검색 조건</label>'+
							'<input type="button" class="btn" value="영화 : '+$('#selectedMovie').val()+'"/>&nbsp;'+
							'<input type="button" class="btn" value="지점 : '+$('#brcName option:selected').text()+'"/>&nbsp;'+
							'<input type="button" class="btn" value="예매/매출 : '+$('#cntKind option:selected').text()+'"/>'+
						'</div>');
				var brcName = $('#brcName option:selected').val();
				var cntKind = $('#cntKind option:selected').val();
				var selectedMovie = $('#selectedMovie').val();
				console.log(brcName+', '+cntKind+', '+selectedMovie);
				// ajax 시작
				$.ajax({
					url : "analisysByMovie", 
					type :"post", 
					data : {"brcName":brcName,
				    	 	 "cntKind":cntKind, 
				    	 	 "selectedMovie" :selectedMovie},
					success : function(data){ 
						
						console.log(data);
						$('#ajaxResult').contents().remove();
						
						if(cntKind=="매출"){
							$('#ajaxResult')
							.append('<table class="table table-striped table-hover">'+
										'<thead>'+
											'<tr>'+
												'<td>영화</td>'+
												'<td>지점</td>'+
												'<td>매출액</td>'+
											'</tr>'+
										'</thead>'+
										'<tbody id="ajaxResultBody">'+
										'</tbody>'+
									'</table>')
						}else if(cntKind=="예매"){
							$('#ajaxResult')
							.append('<table class="table table-striped table-hover">'+
										'<thead>'+
											'<tr>'+
												'<td>영화</td>'+
												'<td>지점</td>'+
												'<td>예매수</td>'+
											'</tr>'+
										'</thead>'+
										'<tbody id="ajaxResultBody">'+
										'</tbody>'+
									'</table>')
						}else{
							$('#ajaxResult')
							.append('<table class="table table-striped table-hover">'+
										'<thead>'+
											'<tr>'+
												'<td>영화</td>'+
												'<td>지점</td>'+
												'<td>예매수</td>'+
												'<td>매출액</td>'+
											'</tr>'+
										'</thead>'+
										'<tbody id="ajaxResultBody">'+
										'</tbody>'+
									'</table>')
						}
						
						
						$(data).each(function(i){
							if(cntKind=="매출"){
								$('#ajaxResultBody')
								.append(
										'<tr>'+
											'<td>'+data[i].movKorName+'</td>'+
											'<td>'+data[i].brcName+'</td>'+
											'<td>'+data[i].brcCntSaleTotal+'</td>'+
										'</tr>')
							}else if(cntKind=="예매"){
								$('#ajaxResultBody')
									.append(
										'<tr>'+
											'<td>'+data[i].movKorName+'</td>'+
											'<td>'+data[i].brcName+'</td>'+
											'<td>'+data[i].brcCntClientCount+'</td>'+
										'</tr>')
							}else{
								$('#ajaxResultBody')
								.append(
									'<tr>'+
										'<td>'+data[i].movKorName+'</td>'+
										'<td>'+data[i].brcName+'</td>'+
										'<td>'+data[i].brcCntClientCount+'</td>'+	
										'<td>'+data[i].brcCntSaleTotal+'</td>'+
									'</tr>')
							}
							
						})
						
					}
				}) 
				// ajax 끝
			})
			
		})
	</script>
	
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