<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
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
		
<br><br>

		<h2>개인정보 수정</h2><a href="">
			<img src="resources/module-img/memberDelete.PNG" align="right"></a>
			
			<!-- 개인정보 수정 시작 -->
			<form action="memberInsert" method="post" name="addjoin" id="checkForm">
				<table style="border-top: 2px solid blue; border-bottom: 2px solid blue;">
						<!-- 아이디 값을 불러온다-->
						<tr>
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*아이디</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" style="width: 200xp" name="memId" id="memId" value="${memId}" />&nbsp;
								<span id="spn"></span>
						</tr>
						
						<!-- 비밀번호 수정 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*비밀번호</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="password" style="width: 200xp" name="memPw"/></td>
						</tr>
						<!-- 비밀번호 수정 종료 -->
						
						<!-- 휴대폰번호 작성 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*휴대폰번호</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memPhone"/></td>
						</tr>		
						<!-- 휴대폰번호 수정 종료 -->		
								
						<!-- 이름 수정 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*이름</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memName" placeholder="이름"/></td>
						</tr>
						<!-- 이름 수정 종료-->
						
						<!-- 성별 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*성별</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memGender"/></td> <!-- select 가 안먹힘; -->
						</tr>
						<!-- 성별 수정 종료-->
						
						<!-- 생년월일 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*생년월일</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
									<input type="text" name="memBirth"/></td>
						</tr>
						<!-- 생년월일 수정 종료-->
						
						<!-- 주소 api 수정 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*주소</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memPostNo" id="sample6_postcode" placeholder="우편번호" readonly="readonly"/>&nbsp;
								<input type="button" onclick="getDaumPostcode()" value="우편번호 찾기"/><br/>&nbsp;
								<input type="text" name="memAddr" id="sample6_address" placeholder="주소" readonly="readonly"/>&nbsp;
							</td>
						</tr>
						<!-- 주소 api 수정 종료-->

						<!-- 이메일 수정 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 2px solid #DCDCDC;">*이메일</td>
							<td style="border-bottom: 2px solid #DCDCDC;">&nbsp;
							<input type="text" name="memMail"/></td>
						</tr>
						<!-- 이메일 수정 종료-->
					</table>
					<br><br>
				<table>
					<tr>
						<td>
						<!-- 개인정보 수정 시작 -->
						<div align="right">
							<input class="btn blue darken-4" type="button" value="수정" onclick="checkfield()"/>
						<a href="memberProvision">
							<input class="btn white" style="color:black" type="button" value="취소" /></a>
						</div>
						<!-- 개인정보 수정 종료 -->
						</td>
					</tr>
				</table>
		</form>
	<!-- 개인정보 수정 종료 -->
</div>
<br>


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>


</body>
</html>