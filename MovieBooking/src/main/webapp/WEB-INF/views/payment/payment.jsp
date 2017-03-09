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
		<input type="hidden" name="paymentWay" id="paymentWay" />		<!-- 결제방법 -->
		<c:if test="${memId !=null }">
			<input type="hidden" name="memId" value="${memId}"/>		<!-- 회원 아이디 -->
		</c:if>
		<input type="hidden" name="scsCode" 
				value="${bookingSeatSelectDto.scsCode }"/>				<!-- 상영일정 코드 -->
		<input type="hidden" name="pmtTicketNum" 
				value="${bookingSeatSelectDto.personNum}"/>				<!-- 예매 인원 수 -->
		<input type="hidden" name="seatCode1" 
				value="${bookingSeatSelectDto.seatCode1}"/>				<!-- 좌석번호1 -->
		<input type="hidden" name="seatCode2" 
				value="${bookingSeatSelectDto.seatCode2}"/>				<!-- 좌석번호2 -->
		<input type="hidden" name="seatCode3" 
				value="${bookingSeatSelectDto.seatCode3}"/>				<!-- 좌석번호3 -->
		<input type="hidden" name="seatCode4" 
				value="${bookingSeatSelectDto.seatCode4}"/>				<!-- 좌석번호4 -->
		<input type="hidden" name="pmtPrice" id="pmtPrice"/>			<!-- 결제금액 -->
		<c:if test="${memId !=null }">
			<input type="hidden" name="useMileage" id="finalMileage"/>	<!-- 사용마일리지 -->
		</c:if>
		<c:if test="${bookingInfo.scsTimeDiscount=='조조'}">				<!-- 할인코드 : 조조일때 -->
			<input type="hidden" name="dcinfCode" 
					value="${bookingInfo.dcinfCode}"/>
		</c:if>
		<c:if test="${bookingInfo.scsTimeDiscount=='심야'}">				<!-- 할인코드 : 심야일때 -->
			<input type="hidden" name="dcinfCode" 	
					value="${bookingInfo.dcinfCode}"/>
		</c:if>
		<c:if test="${bookingInfo.scsTimeDiscount=='일반'}">				<!-- 할인코드 : 일반일때 -->
			<input type="hidden" name="dcinfCode" id="dcinfCode"/>
		</c:if>
		<input type="hidden" name="sccoCode" 
				value="${bookingInfo.sccoCode }"/>						<!-- 상영 단가 코드 -->
		
	</form>
	<!-- 결제 폼 끝 -->
	
	
		
		
		<h2 align="center">결제 수단과 할인수단을 선택해 주세요.</h2>
		
			<!-- 결제 창 시작 -->
			<div class="row card" style="height:600px;">
			
				<!-- 결제 방법 선택 시작 -->
				<div class="col s3 card" style="height:530px;" align="center">
						<h3 align="center">결제 수단</h3><br/><br/>
						
						<div style="cursor: pointer;" class="paymentWay">휴대폰결제</div><br/>
						<div style="cursor: pointer;" class="paymentWay">신용/체크</div><br/>
						<div style="cursor: pointer;" class="paymentWay">카카오페이</div><br/>
						<div style="cursor: pointer;" class="paymentWay">무통장입금</div><br/>
				</div>
				<!-- 결제 방법 선택 끝-->
			
				<!-- 할인 선택 시작 -->
				<div class="col s3 card" style="height:530px">
					<h3 align="center">할인</h3><br/><br/>
					
					<!-- <시작> 예매 시간대가 '일반' 일때만 할인정보 나타냄 -->
					<c:if test="${bookingInfo.scsTimeDiscount=='일반'}">				
							<c:forEach var="DiscountInfo" items="${DiscountInfo}">
							<div>
								<input type="radio" id="discountInfo" class="discountInfo"
									name="discountInfo" value="${DiscountInfo.dcinfPrice}"/>		<!-- 할인 가격 -->
								<input id="getDcinfCode" class="getDcinfCode"
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
				<div class="col s3 card" style="height:530px">
					<h3 align="center">금액</h3><br/><br/>
					<div>
						총 결제 금액<br>
						<span id="totalCost">${bookingInfo.finalCost*bookingInfo.personNum}</span>원
					</div><br/>
					<div>할인
						<p id="discountCost"></p><br>
					</div>
					
					<!-- <시작> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					<c:if test="${memMap.memMileage != null}">
						<div>마일리지 사용
							<p id="useMileage">0</p><br/>
						</div>
					</c:if>
					<!-- <끝> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					
					<div>남은 결제 금액<br/>
						<span class="finalCost">${bookingInfo.finalCost*bookingInfo.personNum}</span> 원
					</div><br>
				</div>
				<!-- 금액 선택 끝 -->
				
				<!-- 예매 정보 시작 -->
				<div class="col s3 card" style="height:530px">
					<h3 align="center">예매정보</h3>
					<div align="center">
						<div style="width:80%; height:80%;" align="left">
							<div>
								<img src="${bookingInfo.movImgPath}"width="100%" height="100%"/>	<!-- 영화 이미지 -->
							</div>
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
							<span id="finalCost" class="finalCost">
								${bookingInfo.finalCost*bookingInfo.personNum}</span> 원			<!-- 남은 결제 금액 -->
						</div>
					</div>
				</div>
				<!-- 예매 정보 끝 -->
				
				<div align="center">
							<input class="btn indigo darken-3" id="submitBtn" type="button" value="결제"/>
						</div>
			</div>
			<!-- 결제 창 끝 -->
			
</div>

<script>
	$(document).ready(function(){
		var finalCost = ${bookingInfo.finalCost*bookingInfo.personNum};		// 최종 결제 금액
		var personNum = ${bookingInfo.personNum};							// 인원 수
		var mileageCost = 0;
		var returnDcCost=0;													// 할인 금액
		
		$("input[name=discountInfo]").eq(0).attr("checked", true);			// 첫번째 라디오버튼 체크하기
		$('#discountCost').text(0);											// 초기 할인 값 0으로 설정
		var getDcinfCode = $('.getDcinfCode').eq(0).val();					// 첫번째 라디오버튼 의 값
		console.log("할인코드 : "+getDcinfCode);						
		$('#dcinfCode').val(getDcinfCode);									// 할인 코드에 첫번째 라디오버튼의 값 셋팅
		
		/* <할인>에서 일반/청소년/장애인 클릭시 <금액>에 할인 값을 집어넣는 스크립트 */
		$('.discountInfo').click(function(){
	    	switch ($(this).val()){
	    		case "0" :
	    			console.log('val 0 들어옴 ');
	    			returnDcCost=$(this).val()*personNum;
	    			$('#discountCost').text(returnDcCost);									// 할인 금액 표시
	    			console.log("할인 금액 : "+returnDcCost);
	    			$('.finalCost').text(finalCost-$(this).val()*personNum-mileageCost);	// 최종 금액
	    			var getDcinfCode = $('.getDcinfCode').eq(0).val();
	    			console.log("할인코드 : "+getDcinfCode);
	    			$('#dcinfCode').val(getDcinfCode);										// 할인 코드 셋팅
	    			break;
	    		case "1000" :
	    			console.log('val 1000 들어옴 ');
	    			returnDcCost=$(this).val()*personNum;
	    			$('#discountCost').text(returnDcCost);									// 할인 금액 표시
	    			console.log("할인 금액 : "+returnDcCost);
	    			$('.finalCost').text(finalCost-$(this).val()*personNum-mileageCost);	// 최종 금액
	    			var getDcinfCode = $('.getDcinfCode').eq(1).val();
	    			console.log("할인코드 : "+getDcinfCode);
	    			$('#dcinfCode').val(getDcinfCode);										// 할인 코드 셋팅
	    			break;
	    		case "2000" :
	    			console.log('val 2000 들어옴 ');
	    			returnDcCost=$(this).val()*personNum;
	    			$('#discountCost').text(returnDcCost);									// 할인 금액 표시
	    			console.log("할인 금액 : "+returnDcCost);
	    			$('.finalCost').text(finalCost-$(this).val()*personNum-mileageCost);	// 최종 금액
	    			var getDcinfCode = $('.getDcinfCode').eq(2).val();
	    			console.log("할인코드 : "+getDcinfCode);
	    			$('#dcinfCode').val(getDcinfCode);										// 할인 코드 셋팅
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
	    	$('.paymentWay').removeClass('selectBlock');						/* 속성제거 */
			$(this).addClass('selectBlock');									/* 속성추가 */
	    	$('#paymentWay').val($(this).text());								/* 값 추가 */
	    	console.log($('#paymentWay').val())
	    })
	    
	    /* submit : 최종 금액, 사용 마일리지 값 셋팅 후 제출 */
	    $('#submitBtn').click(function(){
	    	$('#pmtPrice').val($('#finalCost').text());						/* 최종 금액 Form에 셋팅 */
	    	$('#finalMileage').val($('#useMileage').text());				/* 사용 마일리지 Form에 셋팅 */
	    	if($('#paymentWay').val() ==""){								/* 결제 수단 선택해야 결제 할수 있음 */
	    		alert("결제 수단을 선택해 주시기 바랍니다.")
	    	}else{
	    		alert("예매 하겠습니까?");	    		
			 	$('#submitForm').submit();	
	    	}
	    	
	    })
	});
</script>



<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>