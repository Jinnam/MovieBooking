<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인물 상세페이지</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>



    <!-- 메인 -->

    <div class="row container" style="width:970px ; text-align:center; ">
      <div class="col s12" style="text-align:left;">
        <div class="card">

          <!-- 영화 상세 내용 영역 -->
          <div class="card-content">
            <div class="row">

              <!-- 이미지 -->
              <div class="col s3">
                <img class="materialboxed responsive-img" style="display:block ; height:300px;width:200px; "src="http://img.theqoo.net/img/rBOBZ.png">
              </div>


              <!-- 상세설명 -->
              <div class="col s9">
                <h2>임윤아</h2>
                <span class="col s12" style="color:#8C8C8C;">
                  <sapn style="position:relative ; top:10px;">Lim YoonA</span>
                  <sapn>　</span>
                </span>
                <div class="divider"></div>
                <div><b>출생 : </b> <span>1990.05.30</span></div>
                <div><b>국적 : </b> <span>대한민국</span></div>
                <!-- 간격 --><div style="height:200px"></div>
              </div>

              <!-- 바이오그래피 -->
              <div class="col s12" style="font-size:12px ; color:#4C4C4C;">
                <h3>바이오그래피</h3>
                <p>CF모델로 활동. 9인조 10대 걸그룹 '소녀시대'의 멤버.
                  소녀시대 데뷔에 즈음해 오디션을 통해 MBC ‘9회말 2아웃'의 신주영 역할을 따내 첫 데뷔했으며,
                  KBS 2TV 일일시트콤 '못말리는 결혼'에서 불광동 칠공주의 일원으로 카메오 출연, 깜찍한 여자 깡패로 분하기도.</p>
                  <!-- 간격 --><div style="height:50px"></div>
              </div>





              <!-- 필모그래피 -->
              <div class="col s12">
                <h3>필모그래피</h3>
                <div class="row">

                  <div class=col s1>
                    <div><img class = "responsive-img" src="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000079/79416/79416_185.jpg"></div>
                    <div style="text-align:center">공조</div>
                  </div>

                  <div class=col s1>
                    <div><img class = "responsive-img" src="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000079/79416/79416_185.jpg"></div>
                    <div style="text-align:center">공조</div>
                  </div>

                </div>
              </div>



            </div>
          </div>






        </div>
      </div>
    </div> <!-- 메인 div -->




<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>