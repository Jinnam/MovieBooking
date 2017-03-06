<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마일리지 내역 리스트</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>
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
		



<h3>마일리지 내역 조회</h3>

<table style="border-top: 2px solid blue;">
	<tr >
		<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">사용 마일리지</td>
		<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">적립 마일리지</td>
		<td bgcolor="#F2F2F2" align="center" style="border-bottom: 1px solid #DCDCDC;">날짜</td>
	</tr>
	<tr>
		<td>1</td>
		<td>2</td>
		<td>3</td>
	</tr>



</table>



</div>
<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>