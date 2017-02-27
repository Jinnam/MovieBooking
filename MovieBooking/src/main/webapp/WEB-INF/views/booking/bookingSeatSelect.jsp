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
					$(this).attr('class','seat currentSelect'); //현재선택좌석으로 변경
					currentSeatCount=currentSeatCount*1+1; //현재선택좌석수 증가
					
					if(currentSeatCount==1){ 			//현재좌석선택수 1인경우
						$('#seatCode1').val($(this).attr('seatCode'));
					}else if(currentSeatCount==2){		//현재좌석선택수 2인경우
						$('#seatCode2').val($(this).attr('seatCode'));
					}else if(currentSeatCount==3){		//현재좌석선택수 3인경우
						$('#seatCode3').val($(this).attr('seatCode'));
					}else if(currentSeatCount==4){		//현재좌석선택수 4인경우
						$('#seatCode4').val($(this).attr('seatCode'));
					}
					//선택좌석화면에 추가
					$('#selectSeats').append('<div class=\"seatInfo\">'+$(this).attr('row')+$(this).attr('col')+'</div>');
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
		
    	//예매 인원 변경시 
    	$('#ticketNum').change(function(){
    		seatReset();
    	});		
    	
    	//리셋버튼 클릭시
    	$('#reset').click(function(){
    		seatReset();
    	});
    	
    	//결제버튼 클릭시
    	$('#submit').click(function(){
    		if(maxSeatCount==currentSeatCount){
        		$('#realForm').submit();    			
    		}else{
    			alert('좌석선택이 완료되지 않았습니다.');	
    		}
    	});
    	
    	//좌석 초기화 함수
    	var seatReset = function() {
    		$('#personNum').val($('#ticketNum').val()); //인원정보 변경
    		maxSeatCount = $('#ticketNum').val(); //선택가능인원수 변경 
    		currentSeatCount = 0;	//현재선택인원 0으로 초기화
    		$('.currentSelect').attr('class','seat able'); //선택좌석속성 초기화
    		$('#selectSeats').html(''); //선택좌석화면 초기화
    		
    		//선택 폼 초기화
    		$('#seatCode1').val('');
    		$('#seatCode2').val('');
    		$('#seatCode3').val('');
    		$('#seatCode4').val('');
    		
    	}
    });
</script>


	<!-- 좌석정보 -->
	<div class="container" style="width:970px; display:none;"> <!-- 좌석정보 div 열기-->
		<form action="#진남이형여기" method="post" id="realForm"><!-- 좌석정보 폼 열기-->
			<div>
			
				<div style="display:inline-block; width:200px;">
					상영코드 <input type="text" class="" name="" id="scsCode" value="${scsCode}">				
				</div>
				
				<div style="display:inline-block; width:200px;">
					인원정보 <input type="text" class="" name="" id="personNum">				
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
					<a class="waves-effect waves-light btn" id="reset">좌석 재선택</a>
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
					<a class="waves-effect waves-light btn-large" id="submit">결제하기</a>
				</div>				
			</div> <!-- 상영정보 및 결제버튼 div 닫기 -->
			
		</div>
	</div> <!-- 좌석선택 div 닫기-->



<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>