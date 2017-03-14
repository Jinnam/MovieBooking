<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비회원 예매 확인</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>
<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>

	<!-- 비회원 예매확인 취소 시작 -->
	<div class = "container" style="width: 970px"><br>
	<h3>비회원 예매 확인/취소  </h3><h3 align="right"><label>예매하신 영화 내역과 취소 내역을 확인할 수 있습니다.</label></h3>
		<table class = "striped" style="border-top: 2px solid blue; border-bottom: 2px solid blue">
			<tr>
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">예매번호</td>
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">영화명</td>
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">영화관</td>
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">상영일자</td>
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">예매일</td>
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">예매취소</td>
			</tr>
				<c:forEach items="${list}" var="non">
			<tr>
				<td>${non.pmtCode}</td>			
				<td>${non.movKorName}</td>	
				<td>${non.brcName}</td>	
				<td>${non.scsDate}</td>	
				<td>${non.pmtDate}</td>	
				<td><a href="cancelpayment?pmtCode=${non.pmtCode}">취소</a></td>
			</tr>
			</c:forEach>
		</table>
	</div><br>
	<!-- 비회원 예매확인 취소 종료 -->

<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>