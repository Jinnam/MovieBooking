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
	</div> <!-- 선택조건 view div 닫기 -->
	
	

	<!--  div -->
    <div class="container row" style="width:970px;"> <!-- 상영정보 div 열기 -->
    
    
	  <!-- 지역 선택자 -->
      <div class="col s4 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;color:white;">
        	지역
        </div>

        <div style="height:450px ; overflow:auto;" align="center">
		<ul>
			<c:forEach items="${branchLocal}" var="branchLocal">
				<li class="branchLocal" style="cursor: pointer;">${branchLocal}</li>
			</c:forEach>
		</ul>
        </div>        
      </div>
          
	  <!-- 지점 선택자 -->
      <div class="col s4 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;color:white;">
        	지점
        </div>
        <div style="height:450px ; overflow:auto;" align="center">
			<ul id="branchName">
			</ul>
        </div>
      </div>
      
      <!-- 극장 정보 -->
      <div class="col s4 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;color:white;">
        	극장 정보
        </div>
        <div style="height:450px ; overflow:auto;" id="branchSelector" align="center">
        </div>
      </div>
      

    </div> <!-- 상영정보 div 닫기 -->


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

<script>
$(document).ready(function(){
	
	// 지역 선택
	$('.branchLocal').click(function(){
		$('#branchName').children().remove();				// 표시될부분 초기화
		
    	$('.branchLocal').removeClass('selectBlock');		// 속성제거 
		$(this).addClass('selectBlock');					// 속성추가 
		branchLocal = $(this).text();
		// Ajax
		$.ajax({
			url : "clientMovieAddr", 
		      type :"post", 
		      data : { "branchLocal" : branchLocal},
		      success : function(data){
		    	  console.log(data);
		    	  
		    	  $(data).each(function(i){
		    		  $('#branchName').append('<li class="brcName" style="cursor: pointer;">'+data[i]+'</li>')
		    	  })
		    	 
		      }
		})

	})
	
	// 지점 선택
	$(document).on('click','.brcName',function(){
		console.log("지점 눌러지냐?");
		$('#branchSelector').children().remove();				// 표시될부분 초기화
    	$('.brcName').removeClass('selectBlock');				// 속성제거 
		$(this).addClass('selectBlock');						// 속성추가 
		brcName = $(this).text();
		
	 	$.ajax({
			url : "clientBranchInfo", 
		      type :"post", 
		      data : { "branchName" : brcName},
		      success : function(data){
		    	  console.log(data);
		    		  $('#branchSelector').append('<ul></ul>'
							+'<div><img src="'+data.brcImgPath+'"width="100%" height="50%"/></div>'
							+'<div>'+data.brcAddr+'</div>'
							+'<div>'+data.brcInfoDetail+'</div>');

		      }
		}) 
	})
	
})
</script>

</body>
</html>