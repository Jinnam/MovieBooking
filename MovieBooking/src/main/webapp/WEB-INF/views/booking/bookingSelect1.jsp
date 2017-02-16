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

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>

<!-- 영화 메뉴 바-->
<%@ include file="/WEB-INF/clientModule/topMovieBar.jsp" %>


    <div class="container row" style="width:970px;">

      <div class="col s3 card">
        <div> 영화관</div>
        <div></div>
      </div>

      <div class="col s2 card">
        날짜
      </div>

      <div class="col s3 card">
        영화
      </div>

      <div class="col s4 card">
        시간
      </div>

    </div>
    <div class="ui grid">
      <div class="four wide column">
        <div class="ui vertical fluid tabular menu">
          <a class="item">
            Bio
          </a>
          <a class="item">
            Pics
          </a>
          <a class="item active">
            Companies
          </a>
          <a class="item">
            Links
          </a>
        </div>
      </div>
      <div class="twelve wide stretched column">
        <div class="ui segment">
          This is an stretched grid column. This segment will always match the tab height
        </div>
      </div>
    </div>


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>