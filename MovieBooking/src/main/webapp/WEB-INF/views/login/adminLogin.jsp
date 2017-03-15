<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Mega Box Admin - Admin Main</title>

<!-- JQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Bootstrap core CSS -->
<link href="resources/assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="resources/assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="resources/assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css"
	href="resources/assets/lineicons/style.css">

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
<script>
	$(document).on('click', '#loginBtn', function() {
		console.log("아이디 비번 체크");
		$.ajax({
			url : "adminLogin",
			type : "post",
			dataType : "text",
			data : {
				"adminId" : $("#adminId").val(),
				"adminPw" : $("#adminPw").val()
			},
			success : function(data) {
				console.log(data);
				switch (data) {
				case "noId":
					console.log("아이디불일치");
					$("#adminId").val("").focus();
					break;
				case "noPw":
					console.log("비밀번호불일치");
					$("#adminPw").val("").focus();
					break;
				case "success":
					console.log("로그인성공");
					$(location).attr('href', 'adminMain');
					break;
				}
			},
			error : function() {
				alert("error");
			}
		});
	});
</script>
<body>
	<section id="main-content">
		<section class="wrapper">
			<div class="row">
				<!-- 페이지 강제 줄임 -->
				<div class="col-lg-10 main-chart" align="center">
				</div>
			</div>
			<div class="col-lg-12 container" style="margin: 0 auto;">
				<div class="jumbotron">
					<h2 class="logo">로그인</h2>
				</div>
				<div class="col-lg-3" style="float: left;"></div>
				<div class="col-lg-4" style="float: left;">
					<!-- <시작> 로그인 테이블 -->
					<table class="table">
						<tr>
							<td>아이디</td>
							<td><input type="text" id="adminId" value="admin01"
								placeholder="아이디" /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" id="adminPw" value="123"
								placeholder="비밀번호" /></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><input type="button"
								id="loginBtn" value="로그인" /></td>
						</tr>
					</table>
				</div>
			</div>
			<!-- <끝> 로그인 테이블  -->

				
			
		</section>
	</section>




	<!-- 하단 -->
	<%@include file="/WEB-INF/adminModule/footer.jsp"%>

</body>
</html>