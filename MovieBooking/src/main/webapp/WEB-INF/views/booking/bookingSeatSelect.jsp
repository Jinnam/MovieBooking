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
	.use{
		background-color: #D5D5D5;
		color:white;
		background-image: url('resources/module-img/seat_use.png');
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
				$(this).attr('class','seat currentSelect');
			}

			if($(this).hasClass('use')){
				alert('이미 예매된 좌석입니다.');
			}

			if($(this).hasClass('unable')){
				alert('선택불가 좌석입니다..');
			}
			
		});
    });
</script>



	<!-- 좌석정보 -->
	<div class="container"> <!-- 좌석정보 div 열기-->
		<form><!-- 좌석정보 폼 열기-->
			<div>
			
				<div style="width:200px;">
					상영코드 <input type="text" class="" name="" id="scsCode">				
				</div>
				<div style="display:inline-block; width:200px;">
					좌석코드1<input type="text" class="" name="" id=""> 			
				</div>
				<div style="display:inline-block; width:200px;">
					좌석코드2<input type="text" class="" name="" id=""> 				
				</div>
				<div style="display:inline-block; width:200px;">
					좌석코드3<input type="text" class="" name="" id=""> 				
				</div>
				<div style="display:inline-block; width:200px;">
					좌석코드4<input type="text" class="" name="" id=""> 			
				</div>	
																			
			</div>
		</form><!-- 좌석정보 폼 닫기-->
	</div> <!-- 좌석정보 div 닫기-->

	<!-- 좌석선택 div -->
	<div class ="container row" style="width:970px;"> <!-- 좌석선택 div 열기 -->
		
		<div class="col s12 grey darken-3" style="text-align:center;">
			<img src="resources/module-img/booking_menu_seatnum.png">
		</div>
		
		
		<div class="col s12 grey lighten-3">
			<div class="col s2">
				<!-- 인원 -->
				<div style="width:100px" style="display:inline-block;"> 
					<br>
					<div style="display:inline-block;">인원</div>
				     <select class="ui fluid dropdown" style="width:50px;display:inline-block !important;">
				        <option value="1">1</option>
				        <option value="2">2</option>
				        <option value="3">3</option>
				        <option value="4">4</option>
				     </select>
				</div>	
				<!-- 좌석정보 -->	
				<div>
					<div>a1</div>
					<div>a1</div>
					<div>a1</div>
					<div>a1</div>
				</div>
				<!-- 리셋버튼 -->
				<div>
					<input type="button">
				</div>		
			</div>
			<div class="col s8 grey lighten-5" style="height:400px;text-align:center;">
				<div class="grey lighten-2"><img src="resources/module-img/booking_menu_screen.png"></div>
				<!-- 좌석  -->
				<div class="seatWrapper"> <!-- 좌석 div 열기 -->
					<div class="seatCell">
						<!-- 좌석 행 1 -->
						<div>
							<div class="seat-Row">A</div>
							<div class="seat currentSelect">1</div>
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
							<div class="seat able" id="seat">1</div>
							<div class="seat use" id="seat">2</div>
							<div class="seat use" id="seat">3</div>
							<div class="seat use" id="seat">4</div>
							<div class="seat use" id="seat">5</div>	
							<div class="seat use" id="seat">6</div>
							<div class="seat use" id="seat">7</div>
							<div class="seat use" id="seat">8</div>
							<div class="seat use" id="seat">9</div>
							<div class="seat use" id="seat">10</div>										
						</div>
						<!-- 좌석 행 1 -->
						<div>
							<div class="seat-Row">A</div>
							<div class="seat use" id="seat">1</div>
							<div class="seat unable" id="seat">2</div>
							<div class="seat unable" id="seat">3</div>
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
							<div class="seat currentSelect" id="seat">2</div>
							<div class="seat currentSelect" id="seat">3</div>
							<div class="seat currentSelect" id="seat">4</div>
							<div class="seat currentSelect" id="seat">5</div>	
							<div class="seat currentSelect" id="seat">6</div>
							<div class="seat currentSelect" id="seat">7</div>
							<div class="seat currentSelect" id="seat">8</div>
							<div class="seat currentSelect" id="seat">9</div>
							<div class="seat currentSelect" id="seat">10</div>										
						</div>	
																	
					</div>									
				</div> <!-- 좌석 div 닫기  -->
				<img src="resources/module-img/seat_info.png" style="position:relative;left:250px;bottom:180px;">	
			</div>
			<div class="col s2">
			
			</div>
		</div>
							
		
	</div> <!-- 좌석선택 div 닫기-->



<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>