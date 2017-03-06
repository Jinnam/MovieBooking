<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>       
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>좌석 선택</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="resources/js/bookingSeatSelect.js"></script>
</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>


<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

	<!-- 좌석정보 -->
	<div class="container" style="width:970px; display:none;"> <!-- 좌석정보 div 열기-->
		<form action="payment" method="get" id="realForm"><!-- 좌석정보 폼 열기-->
			<div>
			
				<div style="display:inline-block; width:200px;">
					상영코드 <input type="text" class="" name="scsCode" id="scsCode" value="${scsCode}">				
				</div>
				
				<div style="display:inline-block; width:200px;">
					인원정보 <input type="text" class="" name="personNum" id="personNum">				
				</div>	
				
				<div>
					<div style="display:inline-block; width:200px;">
						좌석코드1<input type="text" class="" name="seatCode1" id="seatCode1"> 			
					</div>
					
					<div style="display:inline-block; width:200px;">
						좌석코드2<input type="text" class="" name="seatCode2" id="seatCode2"> 				
					</div>
					
					<div style="display:inline-block; width:200px;">
						좌석코드3<input type="text" class="" name="seatCode3" id="seatCode3"> 				
					</div>
					
					<div style="display:inline-block; width:200px;">
						좌석코드4<input type="text" class="" name="seatCode4" id="seatCode4"> 			
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
					<div id="selectSeats">
					</div>
				</div>
				
				<!-- 리셋버튼 -->
				<div style="margin-top:10px;">
					<a class="waves-effect waves-light btn blue darken-3" id="reset">좌석 재선택</a>
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
						<!--  -->
						
						<c:forEach var="cnt" begin="0" step="${map.scrColSize}" end="${map.scrRowSize*map.scrColSize-map.scrColSize}">
							<div>
								<div class="seat-Row">${seat[cnt].seatRow}</div>
								<c:forEach var="num" begin="0" end="${map.scrColSize-1}">
 								     <div class="seat ${seat[num+cnt].seatUseStatus}" 
										    row="${seat[num+cnt].seatRow}" 
										    col="${seat[num+cnt].seatCol}" 
										    seatCode="${seat[num+cnt].seatCode}"
								    >
								    	${seat[num].seatCol} 
								    </div> 
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
					<img class="responsive-img" src="${map.movImgPath}">
				</div>
			
				<!-- 상영정보 -->
				<div>
					<!-- 등급 / 이름 -->
					<div>
						 <i class="grade16_${map.movGrade}" style="position:relative;top:2px;"></i>
						 ${map.movKorName} 			
					</div>
					<!-- 할인정보 -->
					<div>
						${map.scsScreen}
						${map.scsTimeDiscount}
					</div>
					<!-- 지점 -->
					<div>
						${map.brcName}
					</div>
					<!-- 날짜 -->
					<div>
						${map.scsDate}
					</div>
					<!-- 시작시간 -->
					<div>
						${map.scsStartTime }
					</div>
				</div>
			
				<!-- 결제버튼 -->
				<div style="margin-top:10px;">
					<a class="waves-effect waves-light btn-large blue darken-3" id="submit">결제하기</a>
				</div>				
			</div> <!-- 상영정보 및 결제버튼 div 닫기 -->
			
		</div>
	</div> <!-- 좌석선택 div 닫기-->



<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>