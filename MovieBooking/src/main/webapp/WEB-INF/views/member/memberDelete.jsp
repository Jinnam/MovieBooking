<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 탈퇴</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>
<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>

		<!-- 마이페이지 img 컨트롤러 -->
		<br><br>
		<div class = "container" style="width: 970px">
				<div style="width: 900px;" align="center">
					<a href="mileageList"><img src="resources/module-img/mileageList.PNG"></a>
					<a href="bookedMovieList"><img src="resources/module-img/bookedMovieList.PNG"></a>
					<a href="memberModify"><img src="resources/module-img/memberModify.PNG"></a>
				</div>
		<br><br>

			<!-- 회원탈퇴 약관 시작 -->
			<h4>회원탈퇴</h4>
				<p style="color: blue">[주의] 메가박스 회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</p>
					<table style="border-top: 2px solid blue; border-bottom: 2px solid silver;">
						<tr>
							<td>1. 30일간 회원 재가입이 불가능합니다.</td>
						</tr>
						<tr>
							<td>>회원 탈퇴 후, 30일 경과 후 재가입할 수 있습니다.</td>
						</tr>
					</table>
					
					<table style="border-bottom: 2px solid silver;">
						<tr>
							<td>2. 탈퇴 후 삭제 내역 (회원 탈퇴하시면 회원정보와 개인 보유 포인트 등 정보가 삭제되며 데이터는 복구되지 않습니다.)</td>
						</tr>
						<tr>
							<td>> 메가박스 멤버십 포인트 및 적립/차감 내역</td>
						</tr>
						<tr>
							<td>> 관람권 및 쿠폰</td>
						</tr>
						<tr>
							<td>> 영화 관람 내역</td>
						</tr>
					</table>
			<!-- 회원탈퇴 약관 종료 -->
				
			<!-- 회원 탈퇴 input 시작 -->
				<form action="memberDelete" method="post" id="deleteMember">
					<table style="border-bottom: 2px solid silver;">
						<tr>
							<td>3.회원님의 비밀번호를 입력하시고 [탈퇴] 버튼을 클릭해주세요.</td>
						</tr>
						<tr>
							<td>비 밀 번 호 : 
								<input type="password" name = "memPw" id = "memPw">
								<input type="hidden" name="memId" value="${id}"/>
							</td>
						</tr>
					</table>
					<br><br>
									
						<div align="right">
							<input class="btn blue darken-4" type="button" value="회원탈퇴" id="deleteBtn"/>
						<a href="memberProvision">
							<input class="btn white" style="color:black" type="button" value="취소" /></a>
					</div>
					<br><br>
				</form>
			</div>
			<!-- 회원 탈퇴 input 종료 -->
			
	<!-- 비밀번호 중복확인 ajax 시작 -->
	<script>
		$(document).on('click','#deleteBtn',function(){
					console.log("중복확인 체크");
					
					if($('#memPw').val()==null || $('#memPw').val()==""){
						alert("비밀번호를 입력하세요.");
					}else{
				   $.ajax({ 
				      url : "memberOverLapDelete", 
				      type :"post", 
				      data : { id : '${id}', pw:$('#memPw').val()}, 
				      
				      success : function(data){ 
				    	  console.log(data);
				        if(data == 1){ 
				        	alert("탈퇴 하시겠습니까?") 
							$('#deleteMember').submit();
						}else{ 
							alert("비밀번호가 일치하지 않습니다.") 
				         } 
				      } 
				   });
				}
			}) ;
	</script>
		<!-- 비밀번호 중복확인 ajax 종료 -->

<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>