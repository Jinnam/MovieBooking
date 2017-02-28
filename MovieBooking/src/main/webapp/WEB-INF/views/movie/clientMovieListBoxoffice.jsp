<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

        <!-- 플립 스크립트 -->
        <script>
        
        var setting={duration:'300'}
        
          $(document).ready(function(){
              $('.test1').hover(function(){               
              	$(this).shape('flip over');                       
              },function(){               
              	$(this).shape('flip back');           
              });
          });

        </script>

   <!-- 메인 -->
  <br>

    <div class="container" style="width:970px"> <!-- 메인컨테이너 시작 -->
		
	
      <div class="row"> <!-- 메인이미지 시작 -->
      
      
      
        <div class="col s3">
          <div class="card">
          
            <!-- 카드 이미지 영역 -->
            <div class="card-image">
              <div class="ui shape test1">
                <div class="sides">
                
                  <!-- 카드 앞면 -->
                  <div class="active side">
                    <img src="http://dimg.donga.com/wps/SPORTS/IMAGE/2016/12/08/81730614.1.jpg">
                  </div>
                  
                  <!-- 카드 뒷면 -->
                  <div class="side black">
                    <img style="opacity: 0.3;" src="http://dimg.donga.com/wps/SPORTS/IMAGE/2016/12/08/81730614.1.jpg">
  
                    <span class="card-title">
                      <div class="ui star rating" data-rating="5" data-max-rating="5"></div>
                      <script>
                        $('.ui.rating')
                        .rating()
                        ;
                      </script>
                    </span>
                  </div>
                  
                </div>
              </div>
            </div>
            
            <!-- 카드 컨텐츠 영역 -->
            <div class="card-content">
              	<div style="color:#424242;font-size:18px;">
              		<i class="grade16_15" style="position:relative;top:2px;"></i>
              		<b>공조</b>
              	</div>
            </div>
            
          </div>
        </div>



 

      </div> <!-- row 끝 -->
    </div> <!-- container 끝 -->


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>