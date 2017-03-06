<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 예매 리스트</title>
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
		<div class = "container" style="width: 970px">
			<form action="">
				<div style="width: 900px;" align="center">
					<a href="mileageList"><img src="resources/module-img/mileageList.PNG"></a>
					<a href="bookedMovieList"><img src="resources/module-img/bookedMovieList.PNG"></a>
					<a href="memberMovieStory"><img src="resources/module-img/memberMovieStory.PNG"></a>
					<a href="memberModify"><img src="resources/module-img/memberModify.PNG"></a>
				</div>
			</form>
	

	<h3>예매 확인/취소  </h3>

		
		<h5 align="right" style="color: blue;">${name}<label>님의 예매내역입니다.</label></h5>
		
		<table style="border-top: 2px solid blue;">
		<thead>
			<tr >
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;"></td>
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;"></td>
				<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;"></td>
			</tr>
			</thead>
			
			<tbody>	
			<tr>
				<td></td>
				<td>2</td>
				<td>3</td>
			</tr>
			</tbody>
			
		
		
		
		</table>
		



	</div>
<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>