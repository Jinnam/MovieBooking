<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
		<!-- 주소 api script 시작 -->
		<script>
		    function getDaumPostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		            	console.log(data);
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
		
		                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var fullAddr = ''; // 최종 주소 변수
		                var extraAddr = ''; // 조합형 주소 변수
		
		                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
		                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
		                    fullAddr = data.roadAddress;
		
		                } else { // 사용자가 지번 주소를 선택했을 경우(J)
		                    fullAddr = data.jibunAddress;
		                }
		
		                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
		                if(data.userSelectedType === 'R'){
		                    //법정동명이 있을 경우 추가한다.
		                    if(data.bname !== ''){
		                        extraAddr += data.bname;
		                    }
		                    // 건물명이 있을 경우 추가한다.
		                    if(data.buildingName !== ''){
		                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                    }
		                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
		                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
		                }
		
		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
		                document.getElementById('sample6_address').value = fullAddr;
		
		                // 커서를 주소 필드로 이동한다.
		                document.getElementById('sample6_address').focus();
		            }
		        }).open();
		    }
		</script>
		<!-- 주소 api script 종료 -->
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
		
<br><br>
		
		<!-- 개인정보 수정 시작 -->
		<h2>개인정보 수정</h2>
			<a href="memberDelete">
				<img src="resources/module-img/memberDelete.PNG" align="right"></a>
			
			
			<form action="memberModify" method="post" id="modifyForm">
				<table style="border-top: 2px solid blue; border-bottom: 2px solid blue;">
						<!-- 아이디 값을 불러온다(길이가 안늘어남)-->
						<tr>
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*아이디</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" style="width: 300px"  name="memId" 
															value="${memberModify.memId}" readonly="readonly"/>&nbsp;
								<span id="spn"></span>
						</tr>
						
						<!-- 비밀번호 수정 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*비밀번호</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="password" style="width: 300px" name="memPw" 
															value="${memberModify.memPw}"/></td>
						</tr>
						<!-- 비밀번호 수정 종료 -->
						
						<!-- 휴대폰번호 수정 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*휴대폰번호</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memPhone" 
															value="${memberModify.memPhone}" style ="width:300px"/></td>
						</tr>		
						<!-- 휴대폰번호 수정 종료 -->		
								
						<!-- 이름 수정 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*이름</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memName" 
														value="${memberModify.memName}" style ="width:300px"/></td>
						</tr>
						<!-- 이름 수정 종료-->
						
						<!-- 성별 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*성별</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memGender" 
													value="${memberModify.memGender}" style ="width:300px"/></td> <!-- select 가 안먹힘; -->
						</tr>
						<!-- 성별 수정 종료-->
						
						<!-- 생년월일 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*생년월일</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
									<input type="text" name="memBirth" 
															value="${memberModify.memBirth}" style ="width:300px"/></td>
						</tr>
						<!-- 생년월일 수정 종료-->
						
						<!-- 주소 api 수정 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*주소</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memPostNo" id="sample6_postcode" placeholder="우편번호" readonly="readonly" value="${memberModify.memPostNo}" style ="width:300px"/>&nbsp;
								<input type="button" onclick="getDaumPostcode()" value="우편번호 찾기"/><br/>&nbsp;
								<input type="text" name="memAddr" id="sample6_address" placeholder="주소" readonly="readonly" value="${memberModify.memAddr}" style ="width:300px"/>&nbsp;
							</td>
						</tr>
						<!-- 주소 api 수정 종료-->

						<!-- 이메일 수정 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 2px solid #DCDCDC;">*이메일</td>
							<td style="border-bottom: 2px solid #DCDCDC;">&nbsp;
							<input type="text" name="memMail" 
														value="${memberModify.memMail}" style ="width:300px"/></td>
						</tr>
						<!-- 이메일 수정 종료-->
					</table>
					<br><br>
					
				<table>
					<tr>
						<td>
						<!-- 개인정보 수정 시작 -->
						<div align="right">
							<input class="btn blue darken-4" type="button" value="수정" id="modifyBtn"/>
						<a href="bookedMovieList">
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

<!-- modifyBtn submit하는  스크립트 -->
<script>
	$(document).ready(function(){
		$('#modifyBtn').click(function(){
			alert("수정되었습니다.");
			$('#modifyForm').submit();
		})
	})
</script>

<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>


</body>
</html>