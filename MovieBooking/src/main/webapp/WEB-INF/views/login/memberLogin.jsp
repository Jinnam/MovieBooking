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

<div class="container" style="width:970px">

	<form action="payment" id="paymentForm">
		<input type="hidden" name="scsCode" value="${bookingSeatSelectDto.scsCode}"/>
		<input type="hidden" name="personNum" value="${bookingSeatSelectDto.personNum}"/>
		<input type="hidden" name="seatCode1" value="${bookingSeatSelectDto.seatCode1}"/>
		<input type="hidden" name="seatCode2" value="${bookingSeatSelectDto.seatCode2}"/>
		<input type="hidden" name="seatCode3" value="${bookingSeatSelectDto.seatCode3}"/>
		<input type="hidden" name="seatCode4" value="${bookingSeatSelectDto.seatCode4}"/>
	</form>
	<div class="row">
	<div class="col s4"></div>
	<div class="col s8">
		<h2>회원 로그인</h2>
		<h3>아이디와 비밀번호를 입력하세요.</h3>
		<table>
			<tr>
				<td>
					아이디 : 
				</td>
	 			<td>
	 				<input type="text" name="memId" id="memId" value="id001" style ="width:200px">
	 			</td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td>
					<input type="text" name="memPw" id="memPw" value="pw001" style ="width:200px">
				</td>
			</tr>
		</table>
			<div class="col s1"></div>
			<div class="col s11" align="left">
				<br/><br/>
				<div class="btn blue darken-4" id="btnLogin">로그인</div>
				<div class="btn" id="nmemBooking">비회원 예매</div> 
			</div>
			
		
	</div>
	</div>
</div>
<script>
$(document).ready(function(){
	$('#nmemBooking').click(function(){
		console.log("클릭되나?");
		$('#paymentForm').attr({action:'nonMemberInsert', method:'get'}).submit();
	})
})



$(document).on('click','#btnLogin',function(){
	console.log("아이디 비번 체크");
	   $.ajax({ 
	      url : "memberLogin", 
	      type :"post", 
	      data : { "memId" : $("#memId").val(),"memPw" : $("#memPw").val()}, 
	      success : function(data){ 
	    	  console.log(data);
	         if(data.memId == null){ 
	            alert("로그인 정보가 잘못되었습니다.") 
	          }else{ 
	            $('#paymentForm').submit();
	         }
	      },error:function(){
	          alert("error");
	       }
	   }) ;	
});

</script>

<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>