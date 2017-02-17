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
	<div class="grey darken-3" style="height:100px ; margin-top:10px ; color:white ;">
		<div class="container row">
			<div class="col s3">
				asddasdasds
			</div>
		</div>
		
	<!-- 선택조건 form -->
	<div class="container row" >
		<form>
			<div class="col s3">
				<input type="text">
			</div>
			<div class="col s3">
				<input type="text">
			</div>
			<div class="col s3">
				<input type="text">
			</div>
			<div class="col s3">
				<input type="text">
			</div>								
		</form>
	</div>	
			
	</div>
	
	



    <div class="container row">
    
    
	  <!-- 날짜 -->
      <div class="col s2 card blue-grey lighten-5" style="height:500px ; margin_bottom:10px;">      
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
      <div class="col s3 card blue-grey lighten-5" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_theater.png">
        </div>
        <div style="height:450px ; overflow:scroll;">
        </div>
      </div>
      
	  <!-- 영화 -->
      <div class="col s3 card blue-grey lighten-5" style="height:500px ; margin_bottom:10px;">
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
      <div class="col s3 card blue-grey lighten-5" style="height:500px ; margin_bottom:10px;">
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

    </div>


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>