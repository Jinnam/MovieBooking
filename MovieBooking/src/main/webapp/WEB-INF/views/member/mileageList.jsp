<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마일리지 내역 리스트</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>
<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>
<br><br>

		<!-- 마이페이지 img 컨트롤러 -->
		<div class = "container" style="width: 970px">
				<div style="width: 900px;" align="center">
					<a href="mileageList"><img src="resources/module-img/mileageList.PNG"></a>
					<a href="bookedMovieList"><img src="resources/module-img/bookedMovieList.PNG"></a>
					<a href="memberModify"><img src="resources/module-img/memberModify.PNG"></a>
				</div>

		<!-- 마일리지 내역 조회 시작 -->
		<h3>마일리지 내역 조회</h3>
		
			<h3 align="right" style="color: blue;">${name}<label>님의 사용내역입니다.</label></h3>
			<h5 align="right">현재 보유 포인트는 ${mileages}p 입니다</h5>
				<table class = "striped" style="border-top: 2px solid blue; text-align: center; border-bottom: 2px solid blue" >
					<thead>
						<tr>
							<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">사용 마일리지</td>
							<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">적립 마일리지</td>
							<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">날짜</td>
						</tr>
					</thead>
			
					<tbody>	
						<c:forEach items="${mlieagelist}" var="memberMil">
							<tr>
								<td>${memberMil.milUse}</td>
								<td>${memberMil.milSave}</td>
								<td>${memberMil.milDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br><br>
		<!-- 마일리지 내역 조회 종료 -->
		</div>
		
<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>