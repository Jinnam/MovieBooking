<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>박스오피스</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">



</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>

		<script>
			//좋아요 클릭시
			$(document).on('click','.like',function(){
				console.log('click like');
				alert('좋아요에 반영됩니다.');
			});			
			$(document).on('click','.likeNoLogin',function(){
				console.log('click nologin');
				alert('좋아요 기능은 로그인후 이용 가능합니다.');
			});
		</script>


        <!-- 플립 스크립트 -->
        <script>
        
          $(document).ready(function(){
              $('.test1').hover(function(){               
              	$(this).shape({duration:550}).shape('flip over');                       
              },function(){               
              	$(this).shape('flip back');           
              });
          });

        </script>

   <!-- 메인 -->
  <br>

    <div class="container" style="max-width:100%;width:1580px"> <!-- 메인컨테이너 시작 -->
      <div class="row"> <!-- 메인row 시작 -->
      
      
      	<c:forEach var="map" items="${boxList}" varStatus="status"> 
	        <div class="col s2">
	          <div class="card">
	          
	            <!-- 카드 이미지 영역 -->
	            <div class="card-image">
	              <div class="ui shape test1">
	                <div class="sides">
	                
	                  <!-- 카드 앞면 -->
	                  <div class="active side">	                  
	                  	
	                    <img style="max-height:310px;" src="${map.movImgPath}">
	                    	<!-- 순위 -->
	                    	<c:if test="${status.count < 6}">
				              	<div style="display:inline-block;position:absolute;top:0px;left:-5px;">					                         		
				              		<div class="light-blue darken-4"style="text-align:center;color:#FFFFFF;width:30;height:30px;font-size:20;line-height:30px;opacity: 0.95;">${status.count}</div>
				              	</div>
			              	</c:if>		                    
	                  </div>
	                  
	                  <!-- 카드 뒷면 -->
	                  <div class="side black">
	                    <img style="opacity: 0.3; max-height:310px;" src="${map.movImgPath}">
	  						
		              	<a href="clientMovieDetail?movCode=${map.movCode}">
			              	<div style="display:inline-block;position:absolute;top:70%;left:20%;">
			              		<div style="color:#eeeeee ;"><i class="huge Film icon"></i></div>
			              		<div style="color:#eeeeee;text-align:center;">상세보기</div>
			              	</div>		              	

		              	</a>
		              	<a href="#">
		              	
		              	<!-- 로그인시 좋아요 -->
						<c:if test="${sessionScope.id != null}">
							<a href="addlikeMovie?movCode=${map.movCode}">
			              	<div class="like" style="display:inline-block;position:absolute;top:70%;left:50%;">
			              		<div style="color:#eeeeee;"><i class="huge heart icon"></i></div>
			              		<div style="color:#eeeeee;text-align:center;">좋아요</div>
			              	</div>								
							</a>
						</c:if>		
						
						<!-- 비 로그인시 좋아요 -->
						<c:if test="${sessionScope.id == null}">
			              	<div class="likeNoLogin" style="display:inline-block;position:absolute;top:70%;left:50%;">
			              		<div style="color:#eeeeee;"><i class="huge heart icon"></i></div>
			              		<div style="color:#eeeeee;text-align:center;">좋아요</div>
			              	</div>	
						</c:if>										              	
	              	
		              	</a>
	                  </div>
	                  
	                </div>
	              </div>
	            </div>
	            
	            <!-- 카드 컨텐츠 영역 -->
	            <div>
	              	<div style="text-align:center; position:relative;top:10px;right:10px;">
	              		  <div style="color:#757575; display:inline-block">평점 ${map.grade*2}</div>
	                      <div class="ui large star rating" data-rating="${map.starGrade}" data-max-rating="5"></div>
	                      <script>
	                        $('.ui.rating')
	                        .rating()
	                        ;
	                      </script>
	              	</div>
	            </div>            
	            <div class="card-content">	            
	              	<div style="color:#424242;font-size:18px;">
	              		<i class="grade16_${map.movGrade}" style="position:relative;top:2px;"></i>
						<c:choose>
							<c:when test="${fn:length(map.movKorName) > 8}">
								<c:out value="${fn:substring(map.movKorName,0,7)}"/>....
							</c:when>
							<c:otherwise>
								<c:out value="${map.movKorName}"/>
							</c:otherwise> 
						</c:choose>
	              	</div>
	            </div>            
	            
	          </div>
	        </div>
		   
		</c:forEach>

      </div> <!-- row 끝 -->
    </div> <!-- container 끝 -->





<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>