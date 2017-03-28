<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>극장</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">

    <!-- jquery cdn -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="resources/js/bookingSelect.js"></script>
	
</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>


	<div class="container row" style="display:none;"> <!-- 실제 값이 전송될 폼 -->
		<form action="bookingSeatSelect" method="post" id="scsInfoForm">
		
			<!-- 영화코드 -->
			<div class="col s3">
				<input type="text" id="movCode" name="movCode" value="0">
			</div>
			
			<!-- 지점코드 -->
			<div class="col s3">
				<input type="text" id="brcCode" name="brcCode" value="0">
			</div>
			
		</form>
	</div>


	<!-- 선택조건 view div -->
	<div class="grey darken-3 container" style="height:60px ; width:970px; margin-top:10px ; color:white ;"><!-- 선택조건 view div 열기 -->
		<div class="container row" ></div>
		
		<!-- 선택조건 div -->
		<div class="container row" style="width:970px;" >

				<!-- 영화 선택 div -->
				<div class="col s3" style="margin-left:20px;">
					<div id="selectMovie"> </div>
				</div>			
				<!-- 지점 선택 div -->
				<div class="col s2">
					<div id="selectBranch"> </div>
				</div>
				<!-- 날짜 선택 div -->
				<div class="col s2">
					<div id="selectDate"> </div>
				</div>				
				<!-- 상영시간 선택 div -->
				<div class="col s2">
					<div id="selectScreen"> </div>
				</div>		
		</div>	
			
	</div> <!-- 선택조건 view div 닫기 -->
	
	

	<!-- 상영정보 div -->
    <div class="container row" style="width:970px;"> <!-- 상영정보 div 열기 -->
    
    
	  <!-- 영화 선택자 -->
      <div class="col s6 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_movie.png">
        </div>

        <div style="height:450px ; overflow:auto;" id="movieSelector" >
         
        	<c:forEach var="Br" items="${BRANCH}">
	        	<div class="scSelector scMovie selectorDiv waves-effect">
		        	<div value="${movie.movCode}" style="display:inline-block;" >
		        		<i class="grade16_${movie.movGrade}" style="position:relative;top:2px;"></i>
		        		<div style="display:inline-block">${Br.brcocal}</div>
		        	</div> 
	        	</div>        	
        	</c:forEach>   
        </div>        
      </div>
          
	  <!-- 극장 선택자 -->
      <div class="col s6 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_theater.png">
        </div>
        <div style="height:450px ; overflow:auto;" id="branchSelector">
        	<c:forEach var="branch" items="${branch}">
	        	<div class="scSelector scBranch selectorDiv waves-effect">
		        	<span value="${branch.brcCode}">${branch.brcName}</span>
	        	</div>        	
        	</c:forEach>          	
        </div>
      </div>

    </div> <!-- 상영정보 div 닫기 -->


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>