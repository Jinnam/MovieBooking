<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디/비밀번호 찾기 </title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">

		<!-- 약관 스타일 시작 -->
		<style type="text/css">
               div, input, label { font-size:12px; }	/* 폰트크기 조절 */
               #div1 { width:970px; margin:12px; }		/* text틀 가로조정 */
               #div1 {
                      height:150px;						/* 화면에 보여지는 text틀 세로조정 */
                      overflow:auto;					/* text 틀 스크롤바 */
                      border:1px solid black;			/* text 테이블 선 */
                      padding:10px;						/* 여백 공간 */
                    }               
        </style>
        <!-- 약관 스타일 종료 -->
</head>

<body>
<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>

<br><br>

	<!-- 아이디찾기 ajax 시작 -->
		<script>
			$(document).ready(function(){
				$('#btnId').click(function(){
					console.log("아이디 찾기 체크");
					
					if($('#memName').val()==null || $('#memName').val()==""){
						alert("이름  입력하세요");
					}else{
						$.ajax({
								url : "memberFindId", 
								type :"post", 
								data : { "memName" : $('#memName').val(),
										"memBirth" : $('#memBirth').val(),
										"memPhone" : $('#memPhone').val(), }, 						
										
						   		success : function(data){ 
							    	console.log(data);
							    	if(data==0){
							    		alert("가입된 회원이 아닙니다.");
							  	  }else{
							    	alert("아이디는 "+data+" 입니다.");
							    }		
							 }
						});
					}
				});
			});
		</script>
		<!-- 아이디찾기 ajax 종료 -->
		
		<!-- 비밀번호 찾기 ajax 시작 -->
		<script>
			$(document).ready(function(){
				$('#btnPw').click(function(){
					console.log("비밀번호 체크");
					
					if($('#memId').val()==null || $('#memId').val()==""){
						alert("아이디  입력하세요");
					}else{
					
					$.ajax({
							url : "memberFindPw", 
							type :"post", 
							data : { "memId" : $('#memId').val(), 
									"memName" : $('#memNamePw').val(),
									"memPhone" : $('#memPhonePw').val(),},
																 						
					   		success : function(data){ 
						    	console.log(data);
						    	if(data==0){
						    		alert("해당 정보로 가입된 사용자를 찾을 수 없습니다.");
						  	 	}else{
						    		alert("비밀번호는 "+data+" 입니다.");
						    	}		
							 }
						});
					}
				});
			});
		</script>
		<!-- 비밀번호 찾기 ajax 시작 -->
		
		
		<!-- 아이디 비밀번호 찾기 약관 시작 -->
		<div class="container" style="width:970px; text-align: left;">
			<div class="row">
			
				<h3>아이디 / 비밀번호 찾기</h3>
			
				<div id="div1">
					<br>
					<p>
						아이핀을 이용하여 회원에 가입하신 경우에는 회사가 회원님의 주민등록번호를 보유하고 있지 않은 관계로, 아이핀 등록기관의 실명확인 및 본인인증 서비스와 연계하여 아이디 및 패스워드 찾기 서비스가 제공되오니 참고하여 주시기 바랍니다. (실명확인 및 본인인증서비스 제공 기관 : 나이스신용평가정보㈜)
						본인인증 시 제공되는 정보는 해당 인증기관에서 직접 수집 하며, 인증 이외의 용도로 이용 또는 저장하지 않습니다.
					</p>
					<p>
						* 이용안내 고객센터 > 1:1문의 또는 ARS 1544-0070 (09:00~21:00)
					</p>
					<br><br>
				</div>
		<!-- 아이디 비밀번호 찾기 약관 종료 -->		
		
		
		<!-- 아이디  찾기 table 시작 -->
		<div class="col s6" align="center">
			<h3>아이디찾기</h3>
				<form action="memberFind" method="post" name = "findId">
					<table style="width: 200px">
							<tr>
								<td>
									<p>이름<p>
										<input type="text" style ="width:200px" id="memName" name="memName">
								</td>
							</tr>
							<tr>
								<td>
									<p>생년 월일<p>
										<input type="text" style ="width:200px" id="memBirth" name="memBirth">
								</td>
							</tr>
							<tr>
  								<td>
  									<p>휴대폰 번호<p>
  										<input type="text" style ="width:200px" id="memPhone" name="memPhone">
  								</td>
                			</tr>
               		 </table>
               		 
               		 <br>
                			<div>
								<input class="btn blue darken-4" type="button" value="아이디찾기" id="btnId"/>
							</div>
				</form>
		</div>
		<!-- 아이디 찾기 table 종료-->
		
		
		<!-- 비밀번호  찾기 table 시작 -->
		<div class="col s6" align="center">
			<h3>비밀번호찾기</h3>
				<form action="memberFind" method="post" name = "findPw">
					<table style="width: 150px">
						<tr>
							<td>
								<p>아이디<p>
									<input type="text" style ="width:200px" id="memId" name="memId">
							</td>
						</tr>
						<tr>
							<td>
								<p>이름<p>
									<input type="text" style ="width:200px" id="memNamePw" name="memName">
							</td>
						</tr>
						<tr>
							<td>
								<p>휴대폰 번호<p>
									<input type="text" style ="width:200px" id="memPhonePw" name="memPhone">
							</td>
                 	 	</tr>
                	</table>
                	
                	<br>
                			<div align="center">
                 	 				<input class="btn blue darken-4" type="button" value="비밀번호찾기" id="btnPw"/>
                 	 		</div>
				</form>
			</div>
		</div>
	</div>
		<!-- 비밀번호  찾기 table 종료 -->
	
<br><br>
		

<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>