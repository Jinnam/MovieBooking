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
	<title>Mega Box Admin - 상영일정 등록</title>
	
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
					<a href="javascript:;">
						<i class="fa fa-film"></i>
						<span>상영관 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="screenList">상영관 목록</a>
						</li>
						<li>
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
					<a class="active" href="javascript:;">
						<i class="fa fa-play-circle"></i>
						<span>상영일정 관리</span>
					</a>
					<ul class="sub">
						<li>
							<a href="screenScheduleList">상영일정 목록</a>
						</li>
						<li class="active">
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
					<h2 class="logo">상영일정 등록</h2>
				</div>
				<div class="col-lg-3"></div>
				<div style="margin:0 auto;">
				
				
					<form action="screenScheduleInsert"  id="scrForm" class="col-lg-12 form-horizontal" method="post">
						<fieldset class="col-lg-5" style="float:left;">
							<legend>add</legend>
							
							<!-- 영화한글이름 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">영화한글이름</label>
								<div class="col-lg-7">
									<input type="text" id="movKorName" name="movKorName" class="form-control" value="공조" placeholder="영화이름을 입력하세요" required="required">
								</div>
								<!-- 영화코드 조회버튼 -->
								<div>
									<input id="selectMovieCode" type="button" class="btn btn-button" value="조회">
								</div>
							</div>
							
							<!-- 영화코드출력 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">영화코드</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="selectViewMovCode" name="movCode" required="required">
									<div id="movComment"></div>
								</div>
							</div>
							
							<!-- 지점이름(한글) -->
							<div class="form-group"> 
								<label class="col-lg-3 control-label">지점이름</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" value="${screenInfo[0].brcName}" readonly="readonly"/>
									<input type="hidden" name="brcCode" value="${screenInfo[0].brcCode}"/>
								</div>
							</div>
							
							<!-- 상영관 선택 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상영관 선택</label>
								<div class="col-lg-9">
									<select class="form-control" id="branchInfo" name="scrCode">
										<option value="noOption">상영관 선택</option>
										<c:forEach items="${screenInfo}" var="screenInfo">
											<option value="${screenInfo.scrCode}">**${screenInfo.scrName}** 
												좌석크기 : ${screenInfo.scrRowSize} X ${screenInfo.scrColSize}
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<!-- 상영날짜 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상영날짜</label>
								<div class="col-lg-9">
									<input type="date" id="screenDate" class="form-control" required="required">
									<input type="hidden" name="scsDate" id="screenDateTostring"/>
								</div>
							</div>							
						</fieldset>
						<fieldset class="col-lg-5" style="float:left;">
							<legend>&nbsp;</legend>
							
							<!-- 상영종류 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상영종류</label>
								<div class="col-lg-9">
									<select id="scsScreen" name="scsScreen" class="form-control">
										<option value="noOption">상영종류</option>
											<c:forEach items="${screenCost}" var="screen">
												<option value="${screen}">${screen}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<!-- 안내 멘트 -->
							<div class="form-group">
								<div class="col-lg-12"><br/>
									<label>&nbsp;
									*** 시작시간을 입력하면 상영 종료시간과 시간할인이 선택됩니다.***</label>
								</div>
							</div>
							
							<!-- 상영시작시간 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상영시작시간</label>
								<div class="col-lg-4" style="margin: 0 auto;width:300px;">
									<!-- <span class="col-lg-1">시</span> -->
									<div style="float:left;">
										<select class="form-control" name="startHour" id="startHour">
										</select>
									</div>
									<div style="float:left;">
										<select class="form-control" name="startMin" id="startMin">
										</select>
									</div>
									<input id="startTimeInput" type="button" class="btn btn-button" value="입력" style="float:left;">
									<input type="hidden" name="scsStartTime" id="scsStartTime"/>
								</div>
							</div>
							
							<!-- 상영종료시간 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">상영종료시간</label>
								<div class="col-lg-9">
									<input type="hidden" id="getHour"/>
									<input type="hidden" id="getMinute"/>
									<input type="text" id="finishTime" class="form-control" placeholder="상영종료시간" readonly="readonly">
									<input type="hidden" id="scsFinishTime" name="scsFinishTime"/>
								</div>
							</div>
							
							<!-- 할인종류 -->
							<div class="form-group">
								<label class="col-lg-3 control-label">시간할인(8~12:조조, 21~7:심야)</label>
								<div class="col-lg-9">
									<input type="text" name="scsTimeDiscount" id="dcInfo" class="form-control" placeholder="시간별 할인" readonly="readonly"">
								</div>
							</div>
							
							<!-- 등록버튼 -->
							<div class="form-group">
								<label class="col-lg-2 control-label"></label>
								<div class="col-lg-8"></div>
								<div>
									<input type="button" id="submitBtn" class="btn btn-button" value="등록">
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
	
<script>


	$(document).ready(function() {
		
	// 현재 날짜 구하기 시작
		var date = new Date(); 
		var year = date.getFullYear(); 
		var month = new String(date.getMonth()+1); 
		var day = new String(date.getDate()); 

		// 한자리수일 경우 0을 채워준다. 
		if(month.length == 1){ 
		  month = "0" + month; 
		} 
		if(day.length == 1){ 
		  day = "0" + day; 
		} 
		$("#screenDate").val(year+"-"+month+"-"+ day);
	// 현재 날짜 구하기 끝
		
		//영화이름으로 영화 코드 조회하기
		$("#selectMovieCode").click(function() {
			$.ajax({
				url 	: "selectMovieCode",
				data 	: {"movKorName" : $("#movKorName").val()},
				type 	: "post",
				success : function(data) {
					console.log(data);
					$("#selectViewMovCode").val(data.movCode);	// 영화코드 삽입
					// 영화 RunningTime 가져오기
					getHour=data.getHour;
					getMinute=data.getMinute;
					console.log(getHour+' : '+getMinute)
					$('#getHour').val(data.getHour);
					$('#getMinute').val(data.getMinute);
				}
			});
		});

	
	// 상영 시작시간

		$('#startHour').append('<option>시간 입력</option');
		$('#startMin').append('<option>분 입력</option');
		for(i=1;i<25;i++){
			if(i<10){
				$('#startHour').append('<option value='+i+'>0'+i+'</option');
			}else{
				$('#startHour').append('<option value='+i+'>'+i+'</option');	
			}
		}
		for(i=0;i<60;i++){
			if(i<10){
				$('#startMin').append('<option value='+i+'>0'+i+'</option');
			}else{
				$('#startMin').append('<option value='+i+'>'+i+'</option');
			}
		}
		
		// 시작시간 입력 후 종료시간/시간별할인 구하는 스크립트
		$('#startTimeInput').click(function(){
			console.log(getHour+' : '+getMinute);
			if($("#selectViewMovCode").val()==""){
				alert("영화를 선택하세요.")
			}else{
				if($('#startHour').val()=="시간 입력") {
					alert("시간을 선택하세요");
				}else if($('#startMin').val()=="분 입력"){
					alert("분을 선택하세요");	
				
				}else{	// 상영 종료 시간
					var finishHour = Number($('#startHour').val())+Number($('#getHour').val());
					var finishMinute =Number($('#startMin').val())+Number($('#getMinute').val());
					if(finishMinute>59){
						finishHour+=1;
						finishMinute-=60;
					}
					$('#finishTime').val( finishHour+'시'+finishMinute+'분')
					
					var startHour = Number($('#startHour').val());
					console.log(startHour);
					if(startHour>7 && startHour<12){
						$('#dcInfo').val("조조");
					}else if(startHour>20 || startHour<8){
						$('#dcInfo').val("심야");
					}else{
						$('#dcInfo').val("일반");
					}
				}
			}


		
	})
	
	
	// 제출
	$('#submitBtn').click(function(){
		console.log("제출버튼 클릭")
		if($('#selectViewMovCode').val()==""){
			alert("영화를 선택하세요")		
		}else if($('#branchInfo').val()=="noOption"){
			alert("상영관을 선택하세요.")
		}else if($('#startHour').val()=="시간 입력") {
			alert("시간을 선택하세요");
		}else if($('#startMin').val()=="분 입력"){
			alert("분을 선택하세요");
		}else if($('#scsScreen').val()=="noOption"){
			alert("상영종류를 선택하세요.");
		}else{
			// 상영날짜 String으로 바꾸기
			$('#screenDateTostring').val($('#screenDate').val());
			// 시작시간 셋팅
			var submitStartTime = $('#startHour').val() +"시"+ $('#startMin').val() +"분";
			$('#scsStartTime').val(submitStartTime);
			// 종료시간 셋팅
			$('#scsFinishTime').val($('#finishTime').val());
			// 스크린 종류
			$('#scsScreen').val()
			// 제출
			alert('제출합니다~~');
			$('#scrForm').submit();
		}
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