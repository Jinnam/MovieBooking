<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
<script>

</script>
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
						<div style="cursor: pointer;" onclick="location.href='#';">휴대폰 결제</div>
						<div style="cursor: pointer;" onclick="location.href='#';">신용/체크</div>
						<div style="cursor: pointer;" onclick="location.href='#';">카카오페이</div>
						<div style="cursor: pointer;" onclick="location.href='#';">무통장입금</div>
				</div>
				<!-- 결제 선택 끝-->
			
				<!-- 할인 선택 시작 -->
				<div class="col s3 card" style="height:520px">
					<h3 align="center">할인</h3>
					<div>
						<c:forEach var="DiscountInfo" items="${DiscountInfo}">
							<input type="radio" name = "discountInfo" value="${DiscountInfo.dcinfCode }"/>
							&nbsp;${DiscountInfo.dcinfInfo}&emsp;
						</c:forEach>
					</div>
					<div></div>
					<div>
						<h4>마일리지</h4>
						보유 마일리지 : <br/>
						사용 : <input type="text"/>
					</div>
				</div>
				<!-- 할인 선택 끝 -->
				
				<!-- 금액 선택 시작 -->
				<div class="col s3 card" style="height:520px">
					<h3 align="center">금액</h3>
					<div>
						총 결제 금액<br>
						${bookingInfo.finalCost }
					</div>
					<div>할인</div>
					<div>남은 결제 금액</div>
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
						<div></div>	<!-- 남은 결제 금액 -->
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




<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>