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
		
		                // 커서를 주소 필드로 이동한다.
		                document.getElementById('sample6_address').focus();
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
					return
					/* exit; */
				/* 아이디 alert 종료 */
						
				/* 비밀번호 alert 시작 */
				}else if(document.addjoin.memPw.value==""){
					alert("비밀번호를 입력하세요");
					document.addjoin.memPw.focus();
					return
					/* exit; */
				/* 비밀번호 alert 종료	 */
					
				/* 휴대폰번호 alert 시작 */
				}else if(document.addjoin.memPhone.value==""){
					alert("휴대폰번호를 입력하세요");
					document.addjoin.memPhone.focus();
					return
					/* exit; */
				/* 휴대폰번호 alert 종료 */
					
				/* 이름 alert 시작 */
				}else if(document.addjoin.memName.value==""){
					alert("이름을 입력하세요");
					document.addjoin.memName.focus();
					return
					/* exit; */
				/* 이름 alert 종료 */
					
				/* 성별 alert 시작 */
				}else if(document.addjoin.memGender.value==""){
					alert("성별을 입력하세요");
					document.addjoin.memGender.focus();
					return
					/* exit; */
				/*성별 alert 종료 */
					
				/* 생년월일 alert 시작 */
				}else if(document.addjoin.memBirth.value==""){
					alert("생년월일을 입력하세요");
					document.addjoin.memBirth.focus();
					return
					/* exit; */
				/* 생년월일 alert 종료 */
					
				/* 주소 alert 시작 */
				 }else if(document.addjoin.memAddr.value==""){
					alert("주소를 입력하세요");
					document.addjoin.memAddr.focus();
					return
					/* exit; */ 
				/* 주소 alert 종료 */
					
				/* 이메일 alert 시작 */
				}else if(document.addjoin.memMail.value==""){
					alert("이메일을 입력하세요");
					document.addjoin.memMail.focus();
					return
					/* exit; */ 
				/* 이메일 alert 종료 */
				}
				
				/* 버튼을 sumbit 하게하는 script */
				alert("정상가입되셨습니다.")
				document.addjoin.submit();
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
		
		<!-- 중복확인 ajax 시작 -->
		<script>
			$(document).on('click','#btn',function(){
					console.log("중복확인 체크");
					var memId =$("#memId1").val()
				   $.ajax({ 
				      url : "memeberOverlap", 
				      type :"post", 
				      data : {  id : memId }, 
				      success : function(data){ 
				    	  console.log(data);
				        if(data == ""){ 
				        	 $("#spn").text("사용 가능한 아이디 입니다."); 
				        }else{ 
				            $("#spn").text("사용 불가능한 아이디 입니다.") 
				        } 
				      } 
				   }) ;
				});
		</script>
		<!-- 중복확인 ajax 종료 -->

		<!-- 비밀번호 확인 시작 -->
	   <script type="text/javascript">
        $(document).ready(function() {
            //[1] lblError 레이어 클리어
            $('#memPw1').keyup(function() {
                //$('#lblError').remove(); // 제거
                $('#lblError').text(''); // 제거가 아니라 클리어
            });
            //[2] 암호 확인 기능 구현
            $('#memPw2').keyup(function() {
                if ($('#memPw1').val() != $('#memPw2').val()) {
                    $('#lblError').text(''); // 클리어
                    $('#lblError').html("<b>비밀번호 확인하십시오.</b>"); //레이어에 HTML 출력
                }
                else {
                    $('#lblError').text(''); // 클리어
                    $('#lblError').html("<b>비밀번호가 맞습니다.</b>");
                }
            });
        });
   	 	</script>
		<!-- 비밀번호 확인 종료 -->



		<form action="memberInsert" method="post" name="addjoin" id="checkForm">
			<h3>가입정보입력</h3>
					<!-- 아이디 입력 및 중복 시작-->
					<table class = "bordered" style="border-top: 2px solid blue; border-bottom: 2px solid blue;" >
						<tr>
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;"><p style="text-align: center;">*아이디<p></td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" id="memId1" placeholder="아이디" style="width: 300px">&nbsp;
								<input type="button" value="중복확인" id="btn"/>&nbsp;
								<span id="spn"></span>		
							</td>
						</tr>
						<!-- 아이디 입력 및 중복 종료-->
						
						<!-- 비밀번호 작성 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;"><p style="text-align: center;">*비밀번호<p></td>
							<td style="border-bottom: 1px solid #DCDCDC; ">&nbsp;
								<input type="password" style="width: 300px" name="memPw" id="memPw1" placeholder="비밀번호" /></td>
						</tr>
						<!-- 비밀번호 작성 종료 -->
						
						<!-- 비밀번호확인 작성 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;"><p style="text-align: center;">*비밀번호 확인<p></td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="password" style="width: 300px" id="memPw2" placeholder="비밀번호확인"/><div id="lblError"></div></td>
								
						</tr>
						<!-- 비밀번호 작성 종료 -->
						
						<!-- 휴대폰번호 작성 시작 -->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;"><p style="text-align: center;">*휴대폰번호<p></td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memPhone" style="width: 300px" placeholder="휴대폰번호"/></td>
						</tr>		
						<!-- 휴대폰번호 작성 종료 -->		
								
						<!-- 이름 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;"><p style="text-align: center;">*이름<p></td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memName" placeholder="이름" style="width: 300px"/></td>
						</tr>
						<!-- 이름 작성 종료-->
						
						<!-- 성별 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;"><p style="text-align: center;">*성별<p></td>
							<td>&nbsp;	
								<!-- <input type="radio" id = "memGender">
								<input type="radio" value="여"> -->
								<select class = "browser-default" style="width: 300px" name="memGender">
							    	<option value="" >성별을 선택하세요.</option>
							    	<option value="남">남</option>
							    	<option value="여">여</option>
							  	</select>
							</td>
						</tr>
						<!-- 성별 작성 종료-->
						
						<!-- 생년월일 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;"><p style="text-align: center;">*생년월일<p></td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
									<input type="text" name="memBirth" placeholder="생년월일" style="width: 300px"/></td>
						</tr>
						<!-- 생년월일 작성 종료-->
						
						<!-- 주소 api 입력 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 1px solid #DCDCDC;"><p style="text-align: center;">*주소<p></td>
							<td style="border-bottom: 1px solid #DCDCDC;">&nbsp;
								<input type="text" name="memPostNo" id="sample6_postcode" placeholder="우편번호" readonly="readonly" style="width: 300px"/>&nbsp;
								<input type="button" onclick="getDaumPostcode()" value="우편번호 찾기"/><br/>&nbsp;
								<input type="text" name="memAddr" id="sample6_address" placeholder="주소" readonly="readonly" style="width: 300px"/>&nbsp;
							</td>
						</tr>
						<!-- 주소 api 입력 종료-->
						
						<!-- 이메일 작성 시작-->
						<tr bgcolor="ffffff">
							<td bgcolor="f5f5f5" align="center" style="border-bottom: 2px solid #DCDCDC;"><p style="text-align: center;">*이메일<p></td>
							<td style="border-bottom: 2px solid #DCDCDC;">&nbsp;
							<input type="text" name="memMail" placeholder="이메일" style="width: 300px"/></td>
						</tr>
						<!-- 이메일 작성 종료-->
					</table>
					<br><br>
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