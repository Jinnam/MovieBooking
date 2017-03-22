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
	<br/><br/><br/>
	<div class="row">
		<div class="col s2"></div>
			<div class="col s8">
				<h2> 예매해 주셔서 감사합니다.</h2><br/>
				<h2>${payment.paymentWay} (으)로 결제 되었습니다.</h2><br/><br/><br/>
			</div>
			<div class="col s12" align="center">
				<div class="btn indigo darken-3" onclick="location.href='movieMain'">홈으로 이동</div>				
			</div>
	</div>

</div>

<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>