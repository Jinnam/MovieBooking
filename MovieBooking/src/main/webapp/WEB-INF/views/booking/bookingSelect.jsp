<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예매 조건 선택</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
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
		<div class="container row" >
			<form action="/bookingSeatSelect" method="post">
				<div class="col s2">
					<input type="text" name="asd">
				</div>
				<div class="col s2">
					<input type="text" name="asddd">
				</div>
				<div class="col s3">
					<input type="text" name="as21d">
				</div>
				<div class="col s2">
					<input type="text" name="asccd">
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
    <div class="container row"> <!-- 상영정보 div 열기 -->
    
    
	  <!-- 날짜 -->
      <div class="col s2 card grey lighten-4" style="height:500px ; margin_bottom:10px;">      
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_date.png">
        </div>
        <div style="height:450px ; overflow:scroll;">
        	<div style="height:30px;margin-left:10px;">
	        	<span style="line-height:30px">2017-02-06</span>
        	</div>
        	<div style="height:30px;margin-left:10px;">
	        	<span style="line-height:30px">2017-02-06</span>
        	</div> 	        	
        </div>
      </div>

	  <!-- 극장 -->
      <div class="col s3 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_theater.png">
        </div>
        <div style="height:450px ; overflow:scroll;">
        </div>
      </div>
      
	  <!-- 영화 -->
      <div class="col s3 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_movie.png">
        </div>
        
        <div style="height:450px ; overflow:scroll;">
        	<div style="height:30px;margin-left:10px;">
	        	<span style="line-height:30px">공조</span>
        	</div>
        	<div style="height:30px;margin-left:10px;">
	        	<span style="line-height:30px">조작된도시</span>
        	</div> 
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