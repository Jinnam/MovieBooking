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


    <div class="container row">

      <div class="col s3 card blue-grey lighten-5" style="height:500px">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_date.png">
        </div>
      </div>

      <div class="col s3 card blue-grey lighten-5" style="height:500px">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_theater.png">
        </div>
      </div>

      <div class="col s3 card blue-grey lighten-5" style="height:500px">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_movie.png">
        </div>
      </div>

      <div class="col s3 card blue-grey lighten-5" style="height:500px">
      	<div class="grey darken-3" style="text-align:center;">
        	<img src="resources/module-img/booking_menu_time.png">
        </div>
      </div>

    </div>


<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>