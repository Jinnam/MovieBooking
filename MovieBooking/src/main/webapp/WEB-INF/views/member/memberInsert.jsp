<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 등록</title>
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

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
<!-- 주소 api script 종료 -->

<script type="text/javascript">
function checkfield(){
	/* 아이디 alert 시작 */
	if(document.addjoin.memId.value==""){
		alert("아이디를 입력하세요");
		document.addjoin.memId.focus();
		exit;
	/* 아이디 alert 종료 */
		
	/* 비밀번호 alert 시작 */
	}else if(document.addjoin.memPw.value==""){
		alert("비밀번호를 입력하세요");
		document.addjoin.memPw.focus();
		exit;
	/* 비밀번호 alert 종료	 */
		
	/* 휴대폰번호 alert 시작 */
	}else if(document.addjoin.memPhone.value==""){
		alert("휴대폰번호를 입력하세요");
		document.addjoin.memPhone.focus();
		exit;
	/* 휴대폰번호 alert 종료 */
		
	/* 이름 alert 시작 */
	}else if(document.addjoin.memName.value==""){
		alert("이름을 입력하세요");
		document.addjoin.memName.focus();
		exit;
	/* 이름 alert 종료 */
		
	/* 성별 alert 시작 */
	}else if(document.addjoin.memGender.value==""){
		alert("성별을 입력하세요");
		document.addjoin.memGender.focus();
		exit;
	/*성별 alert 종료 */
		
	/* 생년월일 alert 시작 */
	}else if(document.addjoin.memBirth.value==""){
		alert("생년월일을 입력하세요");
		document.addjoin.memBirth.focus();
		exit;
	/* 생년월일 alert 종료 */
		
	/* 주소 alert 시작 */
	 }else if(document.addjoin.memAddr.value==""){
		alert("주소를 입력하세요");
		document.addjoin.memAddr.focus();
		exit; 
	/* 주소 alert 종료 */
		
	/* 이메일 alert 시작 */
	}else if(document.addjoin.memMail.value==""){
		alert("이메일을 입력하세요");
		document.addjoin.memMail.focus();
		exit;
	/* 이메일 alert 종료 */
	}
	
}




</script>
</head>

<body>
<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>

<!-- 회원가입 폼 시작 -->
<div class="container" style="width:800px">
<br><br>
	<form action="memberInsert" method="post" name="addjoin">
		<h3>가입정보입력</h3>
		<table>
			<tr>
				<td>
					<!-- 아이디 입력 및 중복 시작-->
					<table style="text-align: center;">
						<tr>
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*아이디</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" style="width: 200xp" name="memId" id="memId"/>&nbsp;<input type="button" value="중복확인" />&nbsp;
									<label>영문이나 숫자 혹은 그 조합 8~12자리</label></td>
						</tr>
						<!-- 아이디 입력 및 중복 종료-->
						
						<!-- 비밀번호 작성 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*비밀번호</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;&nbsp;
								<input type="password" style="width: 200xp" name="memPw"/></td>
						</tr>
						<!-- 비밀번호 작성 종료 -->
						
						<!-- 휴대폰번호 작성 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*휴대폰번호</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memPhone"/></td>
						</tr>		
						<!-- 휴대폰번호 작성 종료 -->		
								
						<!-- 이름 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*이름</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memName"/></td>
						</tr>
						<!-- 이름 작성 종료-->
						
						<!-- 성별 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*성별</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memGender"/></td>
						</tr>
						<!-- 성별 작성 종료-->
						
						<!-- 생년월일 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*생년월일</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
									<input type="text" name="memBirth"/></td>
						</tr>
						<!-- 생년월일 작성 종료-->
						
						<!-- 주소 api 입력 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*주소</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memPostNo" id="sample6_postcode" placeholder="우편번호" readonly="readonly"/>&nbsp;
								<input type="button" onclick="getDaumPostcode()" value="우편번호 찾기"/><br/>&nbsp;
								<input type="text" name="memAddr" id="sample6_address" placeholder="주소" readonly="readonly"/>&nbsp;
								<input type="text" id="sample6_address2" placeholder="상세주소">
							</td>
						</tr>
						<!-- 주소 api 입력 종료-->

						<!-- 이메일 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 2px solid #DCDCDC;">*이메일</td>
							<td style="border-bottom: 2px solid #DCDCDC;">&nbsp;
							<input type="text" name="memMail"/></td>
						</tr>
						<!-- 이메일 작성 종료-->
						
					</table>
				</td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td>
						<!-- 회원가입 신청버튼 및 취소 시작 -->
						<div align="right">
							<input class="btn blue darken-4" type="button" value="회원가입" onclick="checkfield()"/>
						<a href="memberProvision">
							<input class="btn white" style="color:black" type="button" value="이전" /></a>
						</div>
						<!-- 회원가입 신청버튼 및 취소 종료 -->
				</td>
			</tr>
						
		</table>
	</form>
	<!-- 회원가입 폼 종료 -->
</div>
<br>
<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>