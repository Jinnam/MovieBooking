<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>좌석 선택</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
<style>
	.seat{
		font-size:11px;
		cursor:pointer;
		width:16px;
		height:16px;
		display:inline-block;
		text-align:center;
		line-height:14px;
	}
	.able{
		background-color: #686868;
		color:white;
	}
	.unable{
		background-color: #D5D5D5;
		color:white;
	}
	.currentSelect{
		background-color: #24468A;
		color:white;
	}	
	.seat-Row{
		font-size:11px;
		cursor:pointer;
		width:16px;
		height:16px;
    	border-top: 1px solid gray;
		margin: 0 5 0 0;
		display:inline-block;
		text-align:center;
		line-height:14px;
	}
	.seatWrapper{
		width:600px;
		height:200px;
		display:table;
	}
	.seatCell{
	  display: table-cell; 
	  vertical-align: middle;
	}	

</style>
</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>


<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>



<script>
    $(document).ready(function(){
		$(".seat").click(function(){
			
			if($(this).hasClass('currentSelect')){
				alert('현재 선택된 좌석입니다.');
			}				
			
			if($(this).hasClass('able')){
				console.log('사용가능');
				//$(this).toggleClass('currentSelect');
				$(this).attr('class','seat currentSelect');
			}

			if($(this).hasClass('unable')){
				alert('이미 예매된 좌석입니다.');
			}
					
			
		});
    });
</script>






	<!-- 선택조건 view div -->
	<div class="grey darken-3" style="height:100px ; margin-top:10px ; color:white ;"><!-- 선택조건 view div 열기 -->
		<div class="container row" ></div>
		
		<!-- 선택조건 form -->
		<div class="container row" style="width:970px;">
			<form action="/bookingSeatSelect" method="post">
				<div class="col s2">
					<input type="text" name="asd">
				</div>
				<div class="col s2">
					<input type="text" name="asddd">
				</div>
				<div class="col s4">
					<input type="text" name="as21d">
				</div>
				<div class="col s2">
					<input type="text" name="asccd">
				</div>		
				<div class="col s2">
				  <button class="btn waves-effect waves-light" 
				  			style="height:60px;"
				  			type="submit" 
				  			name="action">결제
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
			<div class="col s8 grey lighten-5" style="height:400px;text-align:center;">
				<div class="grey lighten-2"><img src="resources/module-img/booking_menu_screen.png"></div>
				<!-- 좌석  -->
				<div class="seatWrapper"> <!-- 좌석 div 열기 -->
					<div class="seatCell">
						<!-- 좌석 행 1 -->
						<div>
							<div class="seat-Row">A</div>
							<div class="seat unable">1</div>
							<div class="seat able">2</div>
							<div class="seat able">3</div>
							<div class="seat able">4</div>
							<div class="seat able">5</div>	
							<div class="seat able">6</div>
							<div class="seat able">7</div>
							<div class="seat able">8</div>
							<div class="seat able">9</div>
							<div class="seat able">10</div>										
						</div>
						<!-- 좌석 행 1 -->
						<div>
							<div class="seat-Row">A</div>
							<div class="seat unable" id="seat">1</div>
							<div class="seat able" id="seat">2</div>
							<div class="seat currentSelect" id="seat">3</div>
							<div class="seat unable" id="seat">4</div>
							<div class="seat unable" id="seat">5</div>	
							<div class="seat unable" id="seat">6</div>
							<div class="seat unable" id="seat">7</div>
							<div class="seat unable" id="seat">8</div>
							<div class="seat unable" id="seat">9</div>
							<div class="seat unable" id="seat">10</div>										
						</div>
						<!-- 좌석 행 1 -->
						<div>
							<div class="seat-Row">A</div>
							<div class="seat unable" id="seat">1</div>
							<div class="seat able" id="seat">2</div>
							<div class="seat currentSelect" id="seat">3</div>
							<div class="seat able" id="seat">4</div>
							<div class="seat able" id="seat">5</div>	
							<div class="seat able" id="seat">6</div>
							<div class="seat able" id="seat">7</div>
							<div class="seat able" id="seat">8</div>
							<div class="seat able" id="seat">9</div>
							<div class="seat able" id="seat">10</div>										
						</div>
						<!-- 좌석 행 1 -->
						<div>
							<div class="seat-Row">A</div>
							<div class="seat unable" id="seat">1</div>
							<div class="seat able" id="seat">2</div>
							<div class="seat currentSelect" id="seat">3</div>
							<div class="seat able" id="seat">4</div>
							<div class="seat able" id="seat">5</div>	
							<div class="seat able" id="seat">6</div>
							<div class="seat able" id="seat">7</div>
							<div class="seat able" id="seat">8</div>
							<div class="seat able" id="seat">9</div>
							<div class="seat able" id="seat">10</div>										
						</div>															
					</div>									
				</div> <!-- 좌석 div 닫기  -->
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