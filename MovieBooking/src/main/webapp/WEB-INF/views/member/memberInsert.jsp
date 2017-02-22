<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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

</head>
<body>
<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>

<div class="container" style="width:970px">
<br><br>
<form action="">

		<h3>가입정보입력</h3>
		<table width="700" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<!-- 아이디 입력 및 중복 -->
					<table width="700" bgcolor="#d0d4dd" border="0" cellpadding="5" cellspacing="0" style="border-top: 2px solid blue;">
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*아이디</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" style="height: 30xp" size="40" value=""/>&nbsp;<input type="button" value="중복확인" />&nbsp;
									<label>영문이나 숫자 혹은 그 조합 8~12자리</label></td>
						</tr>
						
						<!-- 비밀번호 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*비밀번호</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;&nbsp;<input type="password" /></td>
						</tr>
						
						<!-- 비밀번호 확인 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*비밀번호 확인</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="password" /></td>
						</tr>
						
						<!-- 이름 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*이름</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" /></td>
						</tr>
						
						<!-- 생년월일 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*생년월일</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
									<input type="text" /></td>
						</tr>
						
						<!-- 주소 api -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;">*주소</td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" id="sample6_postcode" placeholder="우편번호"/>&nbsp;
								<input type="button" onclick="getDaumPostcode()" value="우편번호 찾기"/><br/>&nbsp;
								<input type="text" id="sample6_address" placeholder="주소"/>&nbsp;
								<input type="text" id="sample6_address2" placeholder="상세주소"/>
							</td>
						</tr>

						<!-- 이메일 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 2px solid #DCDCDC;">*이메일</td>
							<td style="border-bottom: 2px solid #DCDCDC;">&nbsp;
							<input type="text" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</div>




<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>