<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디/비밀번호 찾기 </title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
			<style type="text/css">
                    div, input, label { font-size:12px; }	/* 폰트크기 조절 */
                    #div1 { width:815px; margin:12px; }		/* text틀 가로조정 */
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


		<div class="container" style="width:970px">
			<h3>아이디 / 비밀번호 찾기</h3>
			<form action="" method="post">
					<div id="div1">
					<br>
					<p>
						아이핀을 이용하여 회원에 가입하신 경우에는 회사가 회원님의 주민등록번호를 보유하고 있지 않은 관계로, 아이핀 등록기관의 실명확인 및 본인인증 서비스와 연계하여 아이디 및 패스워드 찾기 서비스가 제공되오니 참고하여 주시기 바랍니다. (실명확인 및 본인인증서비스 제공 기관 : 나이스신용평가정보㈜)
						본인인증 시 제공되는 정보는 해당 인증기관에서 직접 수집 하며, 인증 이외의 용도로 이용 또는 저장하지 않습니다.
					</p>
					<p>
						* 이용안내 고객센터 > 1:1문의 또는 ARS 1544-0070 (09:00~21:00)
					</p>
					</div>
					<div class="ui top attached tabular menu">
  <a class="active item">
    Bio
  </a>
  
</div>
				<table>
                  <tr>
                    <td><input type="text" placeholder="id001" style ="width:200px"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="pw001" style ="width:200px"></td>
                  </tr>
                    <tr>
                    <td><input type="text" placeholder="pw001" style ="width:200px"></td>
                  </tr>
					</table>
					
					<table>
                  <tr>
                    <td><input type="text" placeholder="id001" style ="width:200px"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="pw001" style ="width:200px"></td>
                  </tr>
                    <tr>
                    <td><input type="text" placeholder="pw001" style ="width:200px"></td>
                  </tr>
					</table>
	
					
					
					
					
</form>
</div>


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>