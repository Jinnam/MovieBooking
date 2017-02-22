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
			
			
			//선택조건 선택시 상영시간 가져오는 함수
			var importSC = function(){
				
				
				
		        $.ajax({                               
		            url:'searchListScreenInfo',                                    
		            type:'post',                                              
		            data:$('#scsInfoForm').serialize(),                              
		            dataType : "json",                                        
		            success:function(data){       
		            	$("#movieSelector").html(''); //movieSelector 영역 초기화
		            	var list = data;
		                $.each(list, function(i) {
		                	$("#movieSelector").append('<div id=\"scsDiv'+i+'\">');
		                	$("#scsDiv"+i).append(			'<span id=\"scsSpan'+i+'\">');
		                	$("#scsSpan"+i).append(				list[i].scsStartTime);
		                	$("#scsDiv"+i).append(			'</span>');
		                	$("#movieSelector").append("</div>");
		                });
		            }
		        });
		        
				//$('#scHelper').text('해당조건 상영중인 영화 없음');
				
			}
			
			
			//영화 선택시
			$(".scMovie").click(function(){
								
				$('.scMovie').removeClass('selectBlock');							//속성제거
				$(this).addClass('selectBlock');									//속성추가
				console.log($(this).children().text());								//선택값출력	
				$("#selectMovie").val($(this).children().text());					//값변경
				$("#movCode").val($(this).children().attr('value'));
				
				//날짜 극장 영화 선택완료시
				if($('#selectDate').val()!='' && $('#selectMovie').val()!='' && $('#selectBranch').val()!='')
				{
					importSC(); //상영 시간 가져오는 함수
					return;
				}					
							
			});			
			
	
			
			//극장 선택시
			$(".scBranch").click(function(){
				
				$('.scBranch').removeClass('selectBlock');							//속성제거
				$(this).addClass('selectBlock');									//속성추가
				console.log($(this).children().text());								//선택값 출력
				$("#selectBranch").val($(this).children().text());					//값 변경
				$("#brcCode").val($(this).children().attr('value'));
				
				//모든 선택이 완료된 경우
				if($('#selectDate').val()!='' && $('#selectMovie').val()!='' && $('#selectBranch').val()!='')
				{
					importSC(); //상영 시간 가져오는 함수
					return;
				}				
				
			});	
			
			//날짜 선택시
			$(".scDate").click(function(){
					
				$('.scDate').removeClass('selectBlock');	//속성제거
				$(this).addClass('selectBlock');			//속성추가
				console.log($(this).children().text());						//선택값 출력
				$("#selectDate").val($(this).children().text());				//값 변경
				$("#Date").val($(this).children().text());
				
				//모든 선택이 완료된 경우
				if($('#selectDate').val()!='' && $('#selectMovie').val()!='' && $('#selectBranch').val()!='')
				{
					importSC(); //상영 시간 가져오는 함수
					return;
				}				
				
			});	
			
			
			//시간 선택시
			$(".scTime").click(function(){
								
				$('.scTime').removeClass('selectBlock');								//속성제거
				$(this).addClass('selectBlock');										//속성추가
				console.log($(this).children().attr('value'));							//선택값출력	
				$("#selectScreen").val($(this).children().text());						//값변경							
			});			
									
		});
	</script>
	
	
	<style>
		.selectBlock {
			background-color : #757575;
			color:white;
		}
		
		.scDate , .scBranch , .scMovie , .scTime{
			cursor:pointer;
		}
	</style>

</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>



	<div class="container row"> <!-- 실제 값이 전송될 폼 -->
		<form action="bookingSeatSelect" method="post" id="scsInfoForm">
		
			<!-- 영화코드 -->
			<div class="col s3">
				<input type="text" id="movCode" name="movCode">
			</div>
			
			<!-- 지점코드 -->
			<div class="col s3">
				<input type="text" id="brcCode" name="brcCode">
			</div>
			
			<!-- 날짜 -->
			<div class="col s3">
				<input type="text" id="Date" name="Date">
			</div>
			
			<!-- 상영정보 코드 -->
			<div class="col s3">
				<input type="text" id="scsCode" name="scsCode">			
			</div>
			
		</form>
	</div>



	<!-- 선택조건 view div -->
	<div class="grey darken-3" style="height:100px ; margin-top:10px ; color:white ;"><!-- 선택조건 view div 열기 -->
		<div class="container row" ></div>
		
		<!-- 선택조건 form -->
		<div class="container row" style="width:970px;" >
		
			<form action="bookingSeatSelect" method="post" id="selectForm">

				<!-- 영화 선택 폼 -->
				<div class="col s3">
					<input type="text" name="" id="selectMovie">
				</div>			
				<!-- 지점 선택 폼 -->
				<div class="col s2">
					<input type="text" name="" id="selectBranch">
				</div>
				<!-- 날짜 선택 폼 -->
				<div class="col s2">
					<input type="text" name="" id="selectDate">
				</div>				
				<!-- 상영시간 선택 폼 -->
				<div class="col s2">
					<input type="text" name="" id="selectScreen">
				</div>		
				<!-- 선택 버튼 -->
				<div class="col s2">
					<a class="waves-effect waves-light btn" id="seatSelectBtn">좌석 선택</a>					  
				</div>											
			</form>
		</div>	
			
	</div> <!-- 선택조건 view div 닫기 -->
	
	


	<!-- 상영정보 div -->
    <div class="container row" style="width:970px;"> <!-- 상영정보 div 열기 -->
    
    
	  <!-- 영화 -->
      <div class="col s3 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_movie.png">
        </div>
        
        <div style="height:450px ; overflow:scroll;">
        	<c:forEach var="movie" items="${movie}">
	        	<div class="scMovie" style="height:30px;margin-left:10px;">
		        	<span style="line-height:30px" value="${movie.movCode}" >${movie.movKorName}</span>
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
	        	<div class="scBranch" style="height:30px;margin-left:10px;">
		        	<span style="line-height:30px" value="${branch.brcCode}">${branch.brcName}</span>
	        	</div>        	
        	</c:forEach>         
        </div>
      </div>
      
	  <!-- 날짜 -->
      <div class="col s2 card grey lighten-4" style="height:500px ; margin_bottom:10px;">      
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_date.png">
        </div>
        <div style="height:450px ; overflow:scroll;">
        	<c:forEach var="date" items="${date}">
	        	<div class="scDate" style="height:30px;margin-left:10px;">
		        	<span style="line-height:30px">${date}</span>
	        	</div>        	
        	</c:forEach>       	
        </div>
      </div>      

	  <!-- 시간 -->
      <div class="col s4 card grey lighten-4" style="height:500px ; margin_bottom:10px;">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_time.png">
        </div>
        <!-- 헬퍼 -->
       	<div style="height:30px;margin-left:10px;">
        	<span style="line-height:30px" id="scHelper">상영날짜 / 극장 / 영화 선택</span>
       	</div>  
       	      
        <div style="height:450px ; overflow:scroll;" id="movieSelector">
			<!-- ajax 데이터 들어올 영역 -->
        </div>    
            
      </div>

    </div> <!-- 상영정보 div 닫기 -->


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>