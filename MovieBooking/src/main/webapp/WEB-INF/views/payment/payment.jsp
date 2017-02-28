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
	<form>
		<div class="col s3">결제 선택	할인수단 적용 후 결제수단을 선택해 주세요.</div>
		
			
			<div class="row card" style="height:600px;">
			
				<!-- 결제 선택 시작 -->
				<div class="col s3 card" style="height:520px">
						<h3 align="center">결제</h3>
						<div style="cursor: pointer;" onclick="location.href='#';">휴대폰 결제</div><br/>
						<div style="cursor: pointer;" onclick="location.href='#';">신용/체크</div><br/>
						<div style="cursor: pointer;" onclick="location.href='#';">카카오페이</div><br/>
						<div style="cursor: pointer;" onclick="location.href='#';">무통장입금</div><br/>
				</div>
				<!-- 결제 선택 끝-->
			
				<!-- 할인 선택 시작 -->
				<div class="col s3 card" style="height:520px">
					<h3 align="center">할인</h3>
					
					<!-- <시작> 예매 시간대가 '일반' 일때만 할인정보 나타냄 -->
					<c:if test="${bookingInfo.scsTimeDiscount=='일반'}">				
						<div>
							<c:forEach var="DiscountInfo" items="${DiscountInfo}">
								<input type="radio" id="discountInfo" class="discountInfo"
									name = "discountInfo" value="${DiscountInfo.dcinfPrice}"/>
								&nbsp;${DiscountInfo.dcinfInfo}&emsp;
							</c:forEach><br/><br/><br/>
						</div>
					</c:if>
					<!-- <끝> 예매 시간대가 '일반' 일때만 할인정보 나타냄 -->
					
					<!-- <시작> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					<c:if test="${memMileage.memMileage != null}">
						<div>
							<h4>마일리지</h4>
							<h5>보유 마일리지 :</h5> ${memMileage.memMileage}<br/>
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
						<p id="totalCost">${bookingInfo.finalCost }</p>
					</div><br/>
					<div>할인
						<p id="discountCost">0</p><br>
					</div>
					
					<!-- <시작> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					<c:if test="${memMileage.memMileage != null}">
						<div>마일리지 사용
							<p id="useMileage">0</p><br/>
						</div>
					</c:if>
					<!-- <끝> 회원만 마일리지 나타냄--세션 아이디로 마일리지 정보 가져옴 -->
					
					<div>남은 결제 금액
						<p id="finalCost">${bookingInfo.finalCost}</p>
					</div><br>
				</div>
				<!-- 금액 선택 끝 -->
				
				<!-- 예매 정보 시작 -->
				<div class="col s3 card" style="height:520px">
					<h3 align="center">예매정보</h3>
					<div>
						<img src="${bookingInfo.movImgPath}" width="250px" height="350"/>	<!-- 영화 이미지 -->
						<div>${bookingInfo.movGrade} ${bookingInfo.movKorName}</div>		<!-- 등급, 한글이름 -->
						<div>${bookingInfo.brcLocal} ${bookingInfo.brcName}</div>			<!-- 지역, 지점이름-->
						<div>${bookingInfo.scsDate} ${bookingInfo.scsStartTime}</div>		<!-- 상영 날짜, 영화 시작시간 -->
						<div>${bookingInfo.personNum}&nbsp;명</div>
						<div id="finalCost"></div>	<!-- 남은 결제 금액 -->
					</div>
				</div>
				<!-- 예매 정보 끝 -->
				<div align="center">
							<input class="btn white" style="color:black" type="button" value="이전"/>
							<input class="btn blue darken-4" type="button" value="결제"/>
						</div>
			</div>
			<!-- 결제 창 끝 -->
		</form>
	</div>

<script>
	$(document).ready(function(){
		var finalCost = '${bookingInfo.finalCost}';
		var discountCost = $('#discountInfo').val();
		console.log(discountCost);
		var mileageCost = $('#mileage').val();
		console.log(mileageCost);
		var returnDcCost=0;
		
		/* <할인>에서 일반/청소년/장애인 클릭시 <금액>에 할인 값을 집어넣는 스크립트 */
		$('.discountInfo').click(function(){
	    	switch (discountCost){
	    		case "0" :
	    			console.log('val 0 들어옴');
	    			$('#discountCost').text($(this).val());
	    			$('#finalCost').text(finalCost-$(this).val()-mileageCost);
	    			returnDcCost=$(this).val();
	    			console.log("returnDcCost"+returnDcCost);
	    			break;
	    		case "1000" :
	    			console.log('val 1000 들어옴');
		    		$('#discountCost').text($(this).val());
		    		$('#finalCost').text(finalCost-$(this).val()-mileageCost);
		    		returnDcCost=$(this).val();
		    		console.log("returnDcCost"+returnDcCost);
		    		break;
	    		case "2000" :
	    			console.log('val 2000 들어옴');
		    		$('#discountCost').text($(this).val());
		    		$('#finalCost').text(finalCost-$(this).val()-mileageCost);
		    		returnDcCost=$(this).val();
		    		console.log("returnDcCost"+returnDcCost);
		    		break;
		    	default :
		    		break;	
	    	}
	    });
		
		/* <할인>에서 입력한 마일리지 값을 <금액>의 마일리지사용에 넣는 스크립트  */
		
	    $('#mileageBtn').click(function(){
	    	console.log("returnDcCost"+returnDcCost);
	    	$('#useMileage').text($('#mileage').val());
	    	$('#finalCost').text(finalCost-returnDcCost-$('#mileage').val());
	    }) 	
	});
</script>



<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>