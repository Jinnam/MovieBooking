<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예매 조건 선택</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">

    <!-- jquery cdn -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			
			//날짜 선택시
			$(".scDate").click(function(){
				
				$('.scDate').parent().removeClass('selectBlock');	//속성제거
				$(this).parent().addClass('selectBlock');			//속성추가
				console.log($(this).text());						//선택값 출력
				$("#selectDate").val($(this).text());				//값 변경
			});		
			
			//극장 선택시
			$(".scBranch").click(function(){
				
				$('.scBranch').parent().removeClass('selectBlock');		//속성제거
				$(this).parent().addClass('selectBlock');				//속성추가
				console.log($(this).text());							//선택값 출력
				$("#selectBranch").val($(this).text());					//값 변경
				
			});	
			
			//영화 선택시
			$(".scMovie").click(function(){
				
				$('.scMovie').parent().removeClass('selectBlock');		//속성제거
				$(this).parent().addClass('selectBlock');				//속성추가
				console.log($(this).text());							//선택값출력	
				$("#selectMovie").val($(this).text());					//값변경
				
			});				
		});
	</script>
	
	
	<style>
		.selectBlock {
			background-color : #424242;
			color:white;
		}
		
		.scDate , .scBranch , .scMovie{
			cursor:pointer;
		}
	</style>

</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>



	<!-- 선택조건 view div -->
	<div class="grey darken-3" style="height:100px ; margin-top:10px ; color:white ;"><!-- 선택조건 view div 열기 -->
		<div class="container row" ></div>
		
		<!-- 선택조건 form -->
		<div class="container row" style=width:970px; >
			<form action="bookingSeatSelect" method="post">
				<div class="col s2">
					<input type="text" name="" id="selectDate">
				</div>
				<div class="col s2">
					<input type="text" name="" id="selectBranch">
				</div>
				<div class="col s3">
					<input type="text" name="" id="selectMovie">
				</div>
				<div class="col s2">
					<input type="text" name="" id="selectScreen">
				</div>		
				<div class="col s2">
				  <button class="btn waves-effect waves-light" 
				  			style="height:60px;"
				  			type="submit" 
				  			name="action">좌석선택
				  </button>
				</div>											
			</form>
		</div>	
			
	</div> <!-- 선택조건 view div 닫기 -->
	
	


	<!-- 상영정보 div -->
    <div class="container row" style="width:970px;"> <!-- 상영정보 div 열기 -->
    
    
	  <!-- 날짜 -->
      <div class="col s2 card grey lighten-4" style="height:500px ; margin_bottom:10px;">      
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_date.png">
        </div>
        <div style="height:450px ; overflow:scroll;">
        	<c:forEach var="date" items="${date}">
	        	<div style="height:30px;margin-left:10px;">
		        	<span class="scDate" style="line-height:30px">${date}</span>
	        	</div>        	
        	</c:forEach>       	
        </div>
      </div>

	  <!-- 극장 -->
      <div class="col s3 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_theater.png">
        </div>
        <div style="height:450px ; overflow:scroll;">
        	<c:forEach var="branch" items="${branch}">
	        	<div style="height:30px;margin-left:10px;">
		        	<span class="scBranch" style="line-height:30px">${branch.brcName}</span>
	        	</div>        	
        	</c:forEach>         
        </div>
      </div>
      
	  <!-- 영화 -->
      <div class="col s3 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_movie.png">
        </div>
        
        <div style="height:450px ; overflow:scroll;">
        	<c:forEach var="movie" items="${movie}">
	        	<div style="height:30px;margin-left:10px;">
		        	<span class="scMovie"style="line-height:30px">${movie.movKorName}</span>
	        	</div>        	
        	</c:forEach>   
        </div>        
      </div>

	  <!-- 시간 -->
      <div class="col s3 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_time.png">
        </div>
        <div style="height:450px ; overflow:scroll;">
        	<div style="height:30px;margin-left:10px;">
	        	<span style="line-height:30px">14:00 디지털</span>
        	</div>
        	<div style="height:30px;margin-left:10px;">
	        	<span style="line-height:30px">17:00 3D</span>
        	</div> 	
        </div>        
      </div>

    </div> <!-- 상영정보 div 닫기 -->


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>