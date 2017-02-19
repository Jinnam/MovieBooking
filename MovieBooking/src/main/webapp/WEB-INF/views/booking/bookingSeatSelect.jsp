<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>좌석 선택</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>


<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>


	<!-- 선택조건 view div -->
	<div class="grey darken-3" style="height:100px ; margin-top:10px ; color:white ;"><!-- 선택조건 view div 열기 -->
		<div class="container row" ></div>
		
		<!-- 선택조건 form -->
		<div class="container row" >
			<form action="/bookingSeatSelect" method="post">
				<div class="col s2">
					<input type="text" name="asd">
				</div>
				<div class="col s2">
					<input type="text" name="asddd">
				</div>
				<div class="col s3">
					<input type="text" name="as21d">
				</div>
				<div class="col s2">
					<input type="text" name="asccd">
				</div>		
				<div class="col s2">
				  <button class="btn waves-effect waves-light" 
				  			style="height:60px;"
				  			type="submit" 
				  			name="action">좌석선택
				  </button>
				</div>											
			</form>
		</div>
	</div> <!-- 선택조건 view div 닫기 -->
	<div style="height:10px"></div><!-- 간격 -->

	<!-- 좌석선택 div -->
	<div class ="container row" style="width:970px;"> <!-- 좌석선택 div 열기 -->
		
		<div class="col s12 grey darken-3" style="text-align:center;">
			<img src="resources/module-img/booking_menu_seatnum.png">
		</div>
		
		<div style="height:100px">
			티켓 정보 영역
		</div>	
		
		<div class="col s12 grey lighten-3">
			<div class="col s2">
				티켓 정보 영역
			</div>
			<div class="col s8 grey lighten-5" style="height:400px">
				<div class="grey lighten-2" style="text-align:center"><img src="resources/module-img/booking_menu_screen.png"></div>
				좌석 영역
			</div>
			<div class="col s2">
				안내 영역
			</div>
		</div>
							
		
	</div> <!-- 좌석선택 div 닫기-->



<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>