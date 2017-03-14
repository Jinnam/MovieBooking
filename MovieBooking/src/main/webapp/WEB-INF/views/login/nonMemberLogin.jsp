<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비회원 예매 확인</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>


		<!-- 비회원 예매 확인 시작 -->
		<div class="container" style="width:970px">
		<h3>비회원 예매 확인</h3>
		<form action="nonMemberLogin" method="post" id="nonForm" name="btnForm">
		<table	style="border-top: 2px solid #E8E7E7; border-bottom: 2px solid #E8E7E7;">
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
		</table>
		
			<br><br>
     	 	<div align="right">
				<input class="btn blue darken-4" type="button" value="로그인" onclick="nonBtn()"/>
				<input class="btn white" style="color:black" type="reset" value="취소"/>
			</div>
		</form>
		
			<p> > 비회원 예매 확인/취소 서비스는 비회원 예매 시 입력하셨던 개인정보를 동일하게 입력하셔야 이용 가능합니다.<p>
			<p> > 비회원 로그인 시 비회원 예매 확인/취소 메뉴만 이용 가능합니다.<p>
			<p> > 이외의 서비스는 회원 가입 후 이용 가능합니다.<p>
		
			<br>
		</div>
		<!-- 비회원 예매 확인 종료 -->
		
		<!-- <script>
			$(document).ready(function(){
				$('#nonBtn').click(function(){
					$('#nonForm').submit();
				})
			})
		</script> -->
		
		<!-- 유효성 검사 -->
		<script type="text/javascript">
			function nonBtn(){
				if(document.btnForm.nmemName.value==""){
					alert("아이디를 입력하세요");
					document.btnForm.nmemName.focus();
					return
				}
				
				if(document.btnForm.nmemBirth.value==""){
					alert("생년월일을 입력하세요");
					document.btnForm.nmemBirth.focus();
					return
				}
				
				if(document.btnForm.nmemPhone.value==""){
					alert("휴대폰번호를 입력하세요");
					document.btnForm.nmemPhone.focus();
					return
				}
				
				if(document.btnForm.nmemPw.value==""){
					alert("비밀번호를 입력하세요");
					document.btnForm.nmemPw.focus();
					return
				}
				
				document.btnForm.submit()
			}
		</script>
		<!-- 유효성 검사 -->
		
<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>