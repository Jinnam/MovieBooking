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

<!-- 전체메뉴 black -->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarBlack.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>

	<div class="container">
		<p><h3>결제 선택</h3><h5>할인수단 적용 후 결제수단을 선택해 주세요.</h5></p>

		<div>
			<c:forEach var="DiscountInfo" items="${DiscountInfo}">
				<input type="radio" name = "discountInfo" value="${DiscountInfo.dcinfCode }"/>${DiscountInfo.dcinfInfo}  
			</c:forEach>
		</div>
	
	</div>




<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>