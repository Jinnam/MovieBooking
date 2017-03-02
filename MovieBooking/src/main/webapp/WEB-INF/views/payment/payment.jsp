<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>


<div class="container">
	
	<!-- 결제 폼  -->
	<form id="submitForm" action="payment" method="post">
		<input type="hidden" name="paymentWay" id="paymentWay" />	<!-- 결제방법 -->
		<input type="hidden" name="phone" value="${phone}"/>		<!-- 비회원 전화번호 -->
		<input type="hidden" name="memId" value="${memId}"/>		<!-- 회원 아이디 -->
		<input type="hidden" name="scsCode" 
				value="${bookingSeatSelectDto.scsCode }"/>			<!-- 상영일정 코드 -->
		<input type="hidden" name="pmtTicketNum" 
				value="${bookingSeatSelectDto.personNum}"/>			<!-- 예매 인원 수 -->
		<input type="hidden" name="seatCode1" 
				value="${bookingSeatSelectDto.seatCode1}"/>			<!-- 좌석번호1 -->
		<input type="hidden" name="seatCode2" 
				value="${bookingSeatSelectDto.seatCode2}"/>			<!-- 좌석번호2 -->
		<input type="hidden" name="seatCode3" 
				value="${bookingSeatSelectDto.seatCode3}"/>			<!-- 좌석번호3 -->
		<input type="hidden" name="seatCode4" 
				value="${bookingSeatSelectDto.seatCode4}"/>			<!-- 좌석번호4 -->
		<input type="hidden" name="pmtPrice" id="pmtPrice"/>		<!-- 결제금액 -->
		<input type="hidden" name="useMileage" id="finalMileage"/>	<!-- 사용마일리지 -->
		<c:if test="${bookingInfo.scsTimeDiscount=='조조'}">			<!-- 할인코드 : 조조일때 -->
			<input type="hidden" name="dcinfCode" 
					value="${bookingInfo.dcinfCode}"/>
		</c:if>
		<c:if test="${bookingInfo.scsTimeDiscount=='심야'}">			<!-- 할인코드 : 심야일때 -->
			<input type="hidden" name="dcinfCode" 
					value="${bookingInfo.dcinfCode}"/>
		</c:if>
		<c:if test="${bookingInfo.scsTimeDiscount=='일반'}">			<!-- 할인코드 : 일반일때 -->
			<input type="hidden" name="dcinfCode" id="dcinfCode"/>
		</c:if>
		<input type="hidden" name="sccoCode" 
				value="${bookingInfo.sccoCode }"/>					<!-- 상영 단가 코드 -->
		
	</form>
	<!-- 결제 폼 끝 -->
	
	
		
		
		<div class="col s3">결제 선택	할인수단 적용 후 결제수단을 선택해 주세요.</div>
		
			<!-- 결제 창 시작 -->
			<div class="row card" style="height:600px;">
			
				<!-- 결제 선택 시작 -->
				<div class="col s3 card" style="height:520px">
						<h3 align="center">결제</h3>
						<div style="cursor: pointer;" class="paymentWay">휴대폰결제</div><br/>
						<div style="cursor: pointer;" class="paymentWay">신용/체크</div><br/>
						<div style="cursor: pointer;" class="paymentWay">카카오페이</div><br/>
						<div style="cursor: pointer;" class="paymentWay">무통장입금</div><br/>
				</div>
				<!-- 결제 선택 끝-->
			
				<!-- 할인 선택 시작 -->
				<div class="col s3 card" style="height:520px">
					<h3 align="center">할인</h3>
					
					<!-- <시작> 예매 시간대가 '일반' 일때만 할인정보 나타냄 -->
					<c:if test="${bookingInfo.scsTimeDiscount=='일반'}">				
							<c:forEach var="DiscountInfo" items="${DiscountInfo}" varStatus="status">
							<div>
								<input type="radio" id="discountInfo" class="discountInfo"
									name = "discountInfo" value="${DiscountInfo.dcinfPrice}"/>		<!-- 할인 가격 -->
								<input id="getDcinfCode${status.count}" class="getDcinfCode"
									type="hidden" value="${DiscountInfo.dcinfCode}"/>				<!-- 할인 코드 -->
								&nbsp;${DiscountInfo.dcinfInfo}&emsp;								<!-- 할인 정보 일반/청소년/장애인-->
							</div>
							</c:forEach><br/><br/><br/>
					</c:if>
					<!-- <끝> 예매 시간대가 '일반' 일때만 할인정보 나타냄 -->
					
					<!-- <시작> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					<c:if test="${memMap.memMileage != null}">
						<div>
							<h4>마일리지</h4>
							<h5>보유 마일리지 :</h5> ${memMap.memMileage}<br/>
							<input id="mileage" maxlength="5" size="5" type="text" value="0"/>
							<input id="mileageBtn" type="button" value="사용"/>
							
							
						</div>
					</c:if>
					<!-- <끝> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					
				</div>
				<!-- 할인 선택 끝 -->
				
				<!-- 금액 선택 시작 -->
				<div class="col s3 card" style="height:520px">
					<h3 align="center">금액</h3>
					<div>
						총 결제 금액<br>
						<p id="totalCost">${bookingInfo.finalCost*bookingInfo.personNum}</p>
					</div><br/>
					<div>할인
						<p id="discountCost">0</p><br>
					</div>
					
					<!-- <시작> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					<c:if test="${memMap.memMileage != null}">
						<div>마일리지 사용
							<p id="useMileage">0</p><br/>
						</div>
					</c:if>
					<!-- <끝> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					
					<div>남은 결제 금액
						<p class="finalCost">${bookingInfo.finalCost*bookingInfo.personNum}</p>
					</div><br>
				</div>
				<!-- 금액 선택 끝 -->
				
				<!-- 예매 정보 시작 -->
				<div class="col s3 card" style="height:520px">
					<h3 align="center">예매정보</h3>
					<div>
						<img src="${bookingInfo.movImgPath}" width="250px" height="350"/>	<!-- 영화 이미지 -->
						<div>${bookingInfo.movGrade} 
							${bookingInfo.movKorName}(${bookingInfo.scsScreen})</div>		<!-- 등급, 한글이름 -->
						<div>${bookingInfo.brcLocal} ${bookingInfo.brcName}</div>			<!-- 지역, 지점이름-->
						<div>${bookingInfo.scsDate}</div>									<!-- 상영 날짜 -->
						<div>${bookingInfo.scsStartTime} ~ 									<!-- 영화 시작시간 -->
							${bookingInfo.scsFinishTime}</div>								<!-- 영화 종료시간 -->
						<div>${bookingInfo.personNum}&nbsp;명</div>							<!-- 인원 -->
						<div>
							${bookingInfo.seatCode1}&nbsp;${bookingInfo.seatCode2}
							&nbsp;${bookingInfo.seatCode3}&nbsp;${bookingInfo.seatCode4}	<!-- 좌석 위치 표시 -->
						</div>
						<p id="finalCost" class="finalCost">
							${bookingInfo.finalCost*bookingInfo.personNum}</p>				<!-- 남은 결제 금액 -->
						
					</div>
				</div>
				<!-- 예매 정보 끝 -->
				
				<div align="center">
							<input class="btn white" style="color:black" type="button" value="이전"/>
							<input class="btn blue darken-4" id="submitBtn"type="button" value="결제"/>
						</div>
			</div>
			<!-- 결제 창 끝 -->
		
</div>

<script>
	$(document).ready(function(){
		var finalCost = ${bookingInfo.finalCost*bookingInfo.personNum};		/* 최종 결제 금액 */
		var personNum = ${bookingInfo.personNum};							/* 인원 수 */
		var mileage= ${memMap.memMileage};									/* 회원 마일리지 */
		console.log("회원 마일리지 : "+mileage);
		if(mileage != undefined){											/* 비회원이라서 마일리지 정보가 없으면 */
			var mileageCost = $('#mileage').val();
		}else{
			var mileageCost = 0;
		}
		
		console.log("사용 마일리지 cost : "+mileageCost);
		var returnDcCost=0;													/* 할인 금액 */
		
		/* <할인>에서 일반/청소년/장애인 클릭시 <금액>에 할인 값을 집어넣는 스크립트 */
		$('.discountInfo').click(function(){
	    	switch ($(this).val()){
	    		case "0" :
	    			console.log('val 0 들어옴 ');
	    			returnDcCost=$(this).val()*personNum;
	    			$('#discountCost').text(returnDcCost);									/* 할인 금액 표시 */
	    			console.log("할인 금액 : "+returnDcCost);
	    			$('.finalCost').text(finalCost-$(this).val()*personNum-mileageCost);	/* 최종 금액 */
	    			var getDcinfCode = $('#getDcinfCode1').val();
	    			console.log("할인코드 : "+getDcinfCode);
	    			$('#dcinfCode').val(getDcinfCode);										/* 할인 코드 셋팅 */
	    			break;
	    		case "1000" :
	    			console.log('val 1000 들어옴 ');
	    			returnDcCost=$(this).val()*personNum;
	    			$('#discountCost').text(returnDcCost);									/* 할인 금액 표시 */
	    			console.log("할인 금액 : "+returnDcCost);
	    			$('.finalCost').text(finalCost-$(this).val()*personNum-mileageCost);	/* 최종 금액 */
	    			var getDcinfCode = $('#getDcinfCode2').val();
	    			console.log("할인코드 : "+getDcinfCode);
	    			$('#dcinfCode').val(getDcinfCode);										/* 할인 코드 셋팅 */
	    			break;
	    		case "2000" :
	    			console.log('val 2000 들어옴 ');
	    			returnDcCost=$(this).val()*personNum;
	    			$('#discountCost').text(returnDcCost);									/* 할인 금액 표시 */
	    			console.log("할인 금액 : "+returnDcCost);
	    			$('.finalCost').text(finalCost-$(this).val()*personNum-mileageCost);	/* 최종 금액 */
	    			var getDcinfCode = $('#getDcinfCode3').val();
	    			console.log("할인코드 : "+getDcinfCode);
	    			$('#dcinfCode').val(getDcinfCode);										/* 할인 코드 셋팅 */
	    			break;
		    	default :
		    		break;	
	    	}
	    });
		
		/* <할인>에서 입력한 마일리지 값을 <금액>의 마일리지사용에 넣는 스크립트  */
	    $('#mileageBtn').click(function(){
	    	$('#useMileage').text($('#mileage').val());
	    	$('.finalCost').text(finalCost-returnDcCost-$('#mileage').val());
	    })
	    
	    /* 결제 방법 선택 */
	     $('.paymentWay').click(function(){
	    	$('#paymentWay').val($(this).text());
	    	console.log($('#paymentWay').val())
	    })
	    
	    /* submit : 최종 금액, 사용 마일리지 값 셋팅 후 제출 */
	    $('#submitBtn').click(function(){
	    	$('#pmtPrice').val($('#finalCost').text());
	    	$('#finalMileage').val($('#useMileage').text());
	    	alert("예매 하겠습니까?");
	    	$('#submitForm').submit();
	    })
	});
</script>



<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>