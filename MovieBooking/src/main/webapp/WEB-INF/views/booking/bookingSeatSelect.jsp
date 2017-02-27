<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>       
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



<script>
    $(document).ready(function(){
    	
    	$('#personNum').val($('#ticketNum').val()); //초기 선택가능 좌석 값
    	var maxSeatCount=$('#ticketNum').val(); //선택가능한 좌석 수
		var currentSeatCount = 0; //현재 선택 좌석 수    	
    	
    	//예매 인원 변경시 
    	$('#ticketNum').change(function(){
    		console.log('예매인원 변경');
    		$('#personNum').val($('#ticketNum').val());
    	});
    	
    	//시트 선택시
		$(".seat").click(function(){
			
			//현재선택된 좌석인경우
			if($(this).hasClass('currentSelect')){
				alert('현재 선택된 좌석입니다.');
			}				
			
			//사용가능 좌석인 경우
			if($(this).hasClass('able')){
				
				//선택가능 좌석수가 현재 선택 좌석 수보다 작은 경우
				if(currentSeatCount<maxSeatCount){
					$(this).attr('class','seat currentSelect');
					currentSeatCount=currentSeatCount*1+1;
					console.log(currentSeatCount);					
				} else {
					alert('선택 좌석 수를 초과하였습니다.');
				}

			}

			//사용중 좌석인경우
			if($(this).hasClass('use')){
				alert('이미 예매된 좌석입니다.');
			}
			
			//선택불가능 좌석인경우
			if($(this).hasClass('unable')){
				alert('선택불가 좌석입니다..');
			}
			
		});
    	
    	//좌석 초기화 함수
    	var seatReset = function() {
    		
    	}
    });
</script>


	<!-- 좌석정보 -->
	<div class="container" style="width:970px;"> <!-- 좌석정보 div 열기-->
		<form><!-- 좌석정보 폼 열기-->
			<div>
			
				<div style="display:inline-block; width:200px;">
					상영코드 <input type="text" class="" name="" id="scsCode" value="${scsCode}">				
				</div>
				
				<div style="display:inline-block; width:200px;">
					인원정보 <input type="text" class="" name="" id="personNum">				
				</div>	
				
				<div>
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
			</div>
		</form><!-- 좌석정보 폼 닫기-->
	</div> <!-- 좌석정보 div 닫기-->

	<!-- 좌석선택 div -->
	<div class ="container row" style="width:970px;"> <!-- 좌석선택 div 열기 -->
		
		<div class="col s12 grey darken-3" style="text-align:center;">
			<img src="resources/module-img/booking_menu_seatnum.png">
		</div>
		
		
		<div class="col s12 grey lighten-3">
		
			<div class="col s2"> <!-- 인원및좌석정보 div 열기 -->			
				<!-- 인원 -->
				<div style="width:100px" style="display:inline-block;"> 
					<br>
					<div style="display:inline-block;">인원</div>
				     <select class="ui fluid dropdown" style="width:50px;display:inline-block;" id="ticketNum">
				        <option value="1">1</option>
				        <option value="2">2</option>
				        <option value="3">3</option>
				        <option value="4">4</option>
				     </select>
				</div>	
				
				<!-- 좌석정보 -->	
				<div style="margin-top:10px;">
					<div>선택한 좌석 정보</div>
					<div class="seatInfo">A1</div>
					<div class="seatInfo">D1</div>
					<div class="seatInfo">B3</div>
					<div class="seatInfo">F2</div>
				</div>
				
				<!-- 리셋버튼 -->
				<div style="margin-top:10px;">
					<a class="waves-effect waves-light btn">좌석 재선택</a>
				</div>		
			</div> <!-- 인원및좌석정보 div 닫기 -->		
			
			<div class="col s8 grey lighten-5" style="height:400px;text-align:center;">
				
				<!-- 스크린 이미지 -->
				<div class="grey lighten-2">
					<img src="resources/module-img/booking_menu_screen.png">
				</div>
				
				<!-- 좌석  -->
				<div class="seatWrapper"> <!-- 좌석 div 열기 -->
					<div class="seatCell">
							<c:forEach var="cnt" begin="${map.scrColSize-1}" end="${map.scrRowSize*map.scrColSize-map.scrColSize}" step="${map.scrColSize}">
								<div>현재:${cnt}  마지막:${map.scrRowSize*map.scrColSize-map.scrColSize}</div>
								<div>
									<div class="seat-Row">${seat[cnt].seatRow}</div>
									<c:forEach var="num" begin="0" end="${map.scrColSize-1}">
									    <div class="seat ${seat[num].seatUseStatus}">${seat[num].seatCol}</div>
									</c:forEach>																
								</div>	
							</c:forEach>														
					</div>									
				</div> <!-- 좌석 div 닫기  -->
				
				<img src="resources/module-img/seat_info.png" style="position:relative;left:250px;bottom:180px;">	
				
			</div>

							
			<div class="col s2"> <!-- 상영정보 및 결제버튼 div 열기 -->
				<!-- 이미지 -->
				<div style="width:155px;">
					<img class="responsive-img" src="http://image2.megabox.co.kr/mop/poster/2017/AF/71961E-4237-49AF-8AA0-C8E67FEC2E6E.medium.jpg">
				</div>
			
				<!-- 상영정보 -->
				<div>
					<div>15 공조 디지털</div>
					<div>전주 금암점</div>
					<div>2017.03.10</div>
					<div>17:00</div>
				</div>
			
				<!-- 결제버튼 -->
				<div style="margin-top:10px;">
					<a class="waves-effect waves-light btn-large">결제하기</a>
				</div>				
			</div> <!-- 상영정보 및 결제버튼 div 닫기 -->
			
		</div>
	</div> <!-- 좌석선택 div 닫기-->



<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>