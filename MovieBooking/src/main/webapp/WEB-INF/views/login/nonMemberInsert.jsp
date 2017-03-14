<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비회원 예매</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
<style type="text/css">
                    div, input, label { font-size:12px; }	/* 폰트크기 조절 */
                    #div1 { width:970px; margin:12px; }		/* text틀 가로조정 */
                    #div1 {
                           height:150px;					/* 화면에 보여지는 text틀 세로조정 */
                           overflow:auto;					/* text 틀 스크롤바 */
                           border:1px solid black;			/* text 테이블 선 */
                           padding:10px;					/* 여백 공간 */
                    }               
             </style>

</head>

<body>
<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>

<br><br>

		<!-- 아이디 비밀번호 찾기 약관 시작 -->
		<div class="container" style="width:970px">
			<h3>비회원 예매</h3>
			
					<div id="div1">
					<br>
					<p>
						메가박스㈜(이하 ‘회사’)은(는) 개인정보보호법에 따라 이용자의 개인정보 보호 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 처리방침을 두고 있습니다. 회사는 개인정보 처리방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것 입니다. 
					</p>
					
					<p>
						[개인정보의 수집 및 이용목적]
  						<p>(1) 비회원 예매서비스 제공</p>
 						<p>(2) 이용자 식별</p>
 						<p>(3) 서비스 제공에 따른 요금 정산</p>
   							<p>1) 콘텐트 제공, 이벤트/경품 당첨 결과 안내</p>
    						<p>2) 구매 및 요금 결제</p>
  						<p>(4) 마케팅 및 광고 활용</p>
   							<p>1) 신규서비스 개발 및 특화</p>
    						<p>2) 접속 빈도 파악</p>
    						<p>3) 정기 간행물 발송, 새로운 상품 또는 서비스 안내</p>
						   	<p>4) 고객 설문 조사</p>
						   	<p>5) 콘텐트 제공</p>
					
					<p>
						[수집하는 개인정보의 항목]
						-필수입력사항 : 개인 식별 정보
						-입력정보 : 이름, 법정 생일 앞 6자리, 휴대폰 번호, 비밀번호, 결제 정보 
					</p>	
						
					<p>
						[개인정보의 보유 및 이용기간]
						개인정보의 수집목적 또는 제공 받은 목적이 달성되면 즉시 파기합니다. 다만, 상법 등 관련 법령의 규정에 의하여 거래관련
						관리 의무 관계의 확인 등을 이유로 대금 결제 및 재화들의 공급에 관한 기록에 의거 5년간 보유합니다. 
					</p>
						
					<p>	* 개인정보 제공에 동의하지 않을 경우 비회원 서비스는 제공되지 않습니다.</p>
					<p>	* 비회원의 경우에도, 위 내용 이외의 사항은 개인정보 처리방침의 규정이 적용됩니다.</p>
					
		</div>
		<br><br>


		<form action="nonMemberInsert" method="post" id="nmemForm">
		<table style="width: 60px; margin: auto;">
          <tr>
               <td><p>이름<p><input type="text" id = "nmemName" name = "nmemName" style ="width:200px"></td>
          </tr>
          <tr>
               <td><p>생년월일<p><input type="text" id = "nmemBirth" name = "nmemBirth" style ="width:200px"></td>
          </tr>
          <tr>
               <td><p>휴대폰번호<p><input type="text" id = "nmemPhone" name = "nmemPhone" style ="width:200px"></td>
          </tr>
          <tr>
               <td><p>비밀번호<p><input type="password" id = "nmemPw" name = "nmemPw" style ="width:200px"></td>
          </tr>
          <tr>
          	<td>
          		<input type="hidden" name="scsCode" value="${bookingSeatSelectDto.scsCode}"/>
				<input type="hidden" name="personNum" value="${bookingSeatSelectDto.personNum}"/>
				<input type="hidden" name="seatCode1" value="${bookingSeatSelectDto.seatCode1}"/>
				<input type="hidden" name="seatCode2" value="${bookingSeatSelectDto.seatCode2}"/>
				<input type="hidden" name="seatCode3" value="${bookingSeatSelectDto.seatCode3}"/>
				<input type="hidden" name="seatCode4" value="${bookingSeatSelectDto.seatCode4}"/>
          	</td>
          </tr>
      </table>
      <br><br>
     	 <div align="right">
			<input class="btn blue darken-4" type="button" value="확인" id="nmemBtn"/>
			<a href="movieMain">
				<input class="btn white" style="color:black" type="button" value="취소"/></a>
		</div>
      <br><br>
</form>
</div>
<script>
	$(document).ready(function(){
		$('#nmemBtn').click(function(){
			$('#nmemForm').submit();
		})
	})
</script>

<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>