<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>


       <!-- jquery cdn -->
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

       <!-- materialize css -->
       <link rel="stylesheet" href="resources/css/mate/materialize.css">
       <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
       <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>

        <!-- semantic ui -->
        <link rel="stylesheet" href="resources/css/semantic/semantic.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.7/components/icon.min.css"/>
        <script src="resources/css/semantic/shape.min.js"></script>
        <script src="resources/css/semantic/rating.min.js"></script>


</head>
<body>
    <!-- 상단바 -->
    <div class="ui three item menu" style="height:50px ; margin-top:0px ; margin-bottom:-0 ; box-shadow:none ; border-radius:0em ;">
      <div class="container" style="width:970px">
        <a style="margin-top:8px"><img src="resources/module-img/logo.png"></a>
        <a class="item" style ="width:20px"></a> <!-- 시작선 -->
        <a class="item" style ="width:130px"><img src="resources/module-img/menu_movie.png" style="width:100px;height:40px"></a>
        <a class="item" style ="width:130px"><img src="resources/module-img/menu_theater.png" style="width:100px;height:40px"></a>
        <a class="item" style ="width:130px"><img src="resources/module-img/menu_ticket.png" style="width:100px;height:40px"></a>
        <a class="item" style ="width:130px"><img src="resources/module-img/menu_store.png" style="width:100px;height:40px"></a>
        <a class="item" style ="width:130px"><img src="resources/module-img/menu_event.png" style="width:100px;height:40px"></a>
        <!-- 드랍다운 -->
        <div class="item ui floating dropdown" style="width:130px">
          <div id="loginDropDown" style="width:100%; padding:15px 0;">
            <img src="resources/module-img/menu_login.png" style="width:100px;height:40px">
          </div>
          <div class="menu" style="width:350px">
            <form style="width:300px;margin: 10px 10px 10px 10px;">
              <!-- 로그인 폼시작 -->
              <div class="item" data-value="drop">
                <table>
                  <tr>
                    <td><input type="text" placeholder="아이디" style ="width:200px"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="비밀번호" style ="width:200px"></td>
                  </tr>
                </table>
              </div>
              <!-- 로그인 폼 끝 -->
            <form>
          </div>
        </div>
        <!-- 드랍다운 스크립트 -->
        <script>
            $(document).ready(function(){
              $('#loginDropDown').click(function(){
                var isOnClick =   $(this).data('isOnClick');
                if(isOnClick == undefined){
                  isOnClick = false;
                }
                if(!isOnClick){
                  $(this).data('isOnClick',true);
                  $(this).parent().find('.menu').slideDown();
                }else{
                  $(this).data('isOnClick',false);
                  $(this).parent().find('.menu').slideUp();
                }
              });
            });

            /*
            $('.dropdown').dropdown({
                // you can use any ui transition
                transition: 'drop'
            });
            */
        </script>
        <a class="item" style ="width:1px"></a>  <!-- 메뉴 끝선 -->
      </div> <!-- 상단바 container 끝 -->
    </div> <!-- 상단바 끝 -->

</body>
</html>