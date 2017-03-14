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

	<div class = "container" style="width: 970px">
		<table style="border-top: 2px solid blue; border-bottom: 2px solid blue">
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
				<td>${non.pmtCode}</td>	
				<td>${non.pmtCode}</td>	
				<td>${non.pmtCode}</td>	
				<td>${non.pmtCode}</td>	
				<td><a href="#">취소</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>