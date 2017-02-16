<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 바 -->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarBlack.jsp" %>


    <!-- 캐러셀 -->
    <div style="position:relative">
      <iframe src="mainCarousel" frameborder='0' scrolling='no' width="100%" height="600px"></iframe>
    </div>



    <!-- 간격 -->
    <div style="height:80px"></div>

    <!-- 메인 -->
    <div class="container"> <!-- 메인컨테이너 시작 -->


      <!-- 메인메뉴바 -->
      <div class="row"> <!-- 메인메뉴바 시작 -->
        <div class="container" style="width:400px"> <!-- 메인메뉴바 container 시작 -->
          <div class="ui three item menu" style="height:50px;box-shadow: none;border-radius: 0em;">
            <a class="item" style ="width:130px"><img src="resources/module-img/menu_boxoffice.png" style="width:100px;height:40px"></a>
            <a class="item" style ="width:130px"><img src="resources/module-img/menu_newmovie.png" style="width:100px;height:40px"></a>
            <a class="item" style ="width:130px"><img src="resources/module-img/menu_expected.png" style="width:100px;height:40px"></a>
          </div>
        </div> <!-- 메인메뉴바 container 끝 -->
      </div> <!-- 메인메뉴바 끝 -->




      <!-- 간격 -->
      <div style="height:80px"></div>

      <!-- 메인 영화이미지 -->
      <div class="row blue-grey lighten-5"> <!-- 메인이미지 시작 -->
        <div class="col s3">
          <div class="card">
            <div class="card-image">
              <div class="ui shape test1" id="test1">
                <div class="sides">
                  <div class="active side">
                    <img src="http://dimg.donga.com/wps/SPORTS/IMAGE/2016/12/08/81730614.1.jpg">
                    <span class="card-title">공조</span>
                  </div>
                  <div class="side black">
                    <img style="opacity: 0.3;" src="http://dimg.donga.com/wps/SPORTS/IMAGE/2016/12/08/81730614.1.jpg">
                    <span class="card-title">
                      <div class="ui star rating" data-rating="3" data-max-rating="5"></div>
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
            <div class="card-content">
              테스트
            </div>
          </div>
        </div>
        <!-- 플립 스크립트 -->
        <script>
          var count= 0;
          $(document).ready(function(){
              $('.test1').hover(function(){
                if(count == 0){
                      $(this).shape('flip over');
                      count++;
                }
              },function(){
                if(count > 0){
                    $(this).shape('flip over');
                    count = 0;
                }
              });
          });
          /*
          $(document).on('mouseover','.test1',function(){
            if(count == 0){
                $('.test1').shape('flip over');
                count++;            }
          });
          $(document).on('mouseout','.test1',function(){
            if(count == 0){
                $('.test1').shape('flip over');
                count = 0;
            }
          });
          */
        </script>

        <div class="col s3">
          <div class="card">
            <div class="card-image">
              <img src="http://image2.megabox.co.kr/mop/poster/2017/27/0D6ACE-EFCD-43FB-AEC4-088933DF4629.medium.jpg">
              <span class="card-title">더킹</span>
            </div>
            <div class="card-content">
              <p>테스트</p>
            </div>
          </div>
        </div>

        <div class="col s3">
          <div class="card">
            <div class="card-image">
              <img src="http://image2.megabox.co.kr/mop/poster/2016/F9/7EC7A1-CC4B-4B2E-BD36-3909369FD017.medium.jpg">
              <span class="card-title">너의이름은</span>
            </div>
            <div class="card-content">
              <p>테스트</p>
            </div>
          </div>
        </div>

        <div class="col s3">
          <div class="card">
            <div class="card-image">
              <img src="http://image2.megabox.co.kr/mop/poster/2017/68/341DCF-319C-4D74-9DDB-DAF0C5ACD838.medium.jpg">
              <span class="card-title">조작된도시</span>
            </div>
            <div class="card-content">
              <p>테스트</p>
            </div>
          </div>
        </div>

      </div> <!-- row 끝 -->
    </div> <!-- container 끝 -->


    <!-- 간격 -->
    <div style="height:80px"></div>


    <!-- parallax 이미지 -->
    <div class="parallax-container">
      <div class="parallax"><img src="resources/module-img/VO-cinema-in-Barcelona.jpg"></div>
    </div>
    <div class="section white">
      <div class="row container">
        <h2 class="header">Parallax</h2>
        <p class="grey-text text-darken-3 lighten-3">Parallax is an effect where the background content or image in this case, is moved at a different speed than the foreground content while scrolling.</p>
      </div>
    </div>
    <div class="parallax-container">
      <div class="parallax"><img src="resources/module-img/VO-cinema-in-Barcelona.jpg"></div>
    </div>
    <script>
      $(document).ready(function(){
        $('.parallax').parallax();
      });
    </script>


    <!-- 간격 -->
    <div style="height:80px"></div>




<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>
</body>
</html>