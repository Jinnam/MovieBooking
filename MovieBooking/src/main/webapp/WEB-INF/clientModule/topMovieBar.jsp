<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		$(document).ready(function(){
			var requestPath = location.href
			var cutPath = requestPath.substring(requestPath.length-1,requestPath.length);
			
			if(cutPath==1){
				$('#movieNavLiBox').addClass('active');
			}else if(cutPath==2){
				$('#movieNavLiNew').addClass('active');
			}else if(cutPath==3){
				$('#movieNavLiExp').addClass('active');
			}
			
			
		});
	</script>

    <!-- 영화 상단바  -->

    <nav class=" grey lighten-4" style="height:50px ; box-shadow:none ; border-bottom:1px ; border-bottom:solid 3px #0d47a1 ; border-top:solid 0.3px #dedede;">
      <div class="nav-wrapper container  grey lighten-4" style="width:970px;">
        <ul id="nav-mobile" class="left hide-on-med-and-down">
       	  <!-- 박스오피스 -->
          <li id="movieNavLiBox"><a href="clientMovieListBoxoffice1"><img src="resources/module-img/menu_boxoffice.png" style="width:100px;height:40px"></a></li>
          <!-- 최신개봉작 -->
          <li id="movieNavLiNew"><a href="clientMovieListNewMovie2"><img src="resources/module-img/menu_newmovie.png" style="width:100px;height:40px"></a></li>
          <!-- 상영예정작 -->
          <li id="movieNavLiExp"><a href="clientMovieListExpected3"><img src="resources/module-img/menu_expected.png" style="width:100px;height:40px"></a></li>
          <!-- 우측메뉴 -->
          <li class="brand-logo right"><a href="beforeReady"><img src="resources/module-img/menu_boxoffice.png" style="width:100px;height:40px"></a></li>
        </ul>
      </div>
    </nav>

</body>
</html>