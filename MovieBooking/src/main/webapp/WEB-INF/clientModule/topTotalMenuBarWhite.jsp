<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div class="container" style="position:relative">
      <!-- 전체메뉴 absolute -->
      <div class="container row" style="height:60px; width:970px; position:relative ; left:110px;">  <!--전체메뉴 div -->

          <!-- 전체메뉴 버튼 -->
          <a class="waves-effect col btn s1 white"
             style="height:30px ; width:80px ; border:1px solid #353535; box-shadow:none ; margin-top:20px ; margin-right:20px ; border-radius: 0em ; "
             href="#modal1">
             <span style=" text-decoration:none ; color:#353535; font-size:12px; position:relative; top:-5px;">
               전체메뉴
             </span>
           </a>

           <!--  빠른예매 버튼-->
           <span style="float:right">
             <a class="waves-effect waves-light btn  purple darken-4"
                style=" height:40px ;  border:1px solid #3F0099 ;
                       box-shadow:none ; margin-top:20px ; margin-right:20px ; margin-left:10px ; border-radius: 0em ;">
             <span style=" text-decoration:none ; color:white ;">
               <b>빠른예매</b>
             </span>
            </a>
           </span>

           <!-- 상영시간표 버튼 -->
           <span style="float:right">
             <a class="waves-effect waves-light btn white"
                style="opacity: 0.7 ; height:40px ;  border:1px solid #3F0099 ;
                       box-shadow:none ; margin-top:20px ; margin-left:20px ; border-radius: 0em ;">
             <span style="opacity: none ; text-decoration:none ; color:#3F0099 ;">
               <b>상영시간표</b>
             </span>
            </a>
           </span>


           <!-- 리스트 메뉴 -->
           <span class="waves-effect" style="margin-top:25px ; ">
             <div class="ui mini horizontal divided list">

               <div class="item">
                 <div class="content">
                   <div class="header" style="font-size:14px ; ">필름 소사이어티</div>
                 </div>
               </div>

               <div class="item">
                 <div class="content">
                   <div class="header" style="font-size:14px ; ">클래식 소사이어티</div>
                 </div>
               </div>

             </div>
           </span>

           <!-- 고객센터/멤버십/vip -->
           <span class="waves-effect" style="margin-top:25px ; float:right ;">
             <div class="ui mini horizontal divided list" style="float:right;">

               <div class="item">
                 <div class="content">
                   <div class="header" style="font-size:14px ; ">고객센터</div>
                 </div>
               </div>

               <div class="item">
                 <div class="content">
                   <div class="header" style="font-size:14px ; ">멤버십</div>
                 </div>
               </div>

               <div class="item">
                 <div class="content">
                   <div class="header" style="font-size:14px ;  ">VIP</div>
                 </div>
               </div>

             </div>
           </span>


      </div> <!--전체메뉴 목록 div 끝-->

      <!-- 전체메뉴 modal  -->
      <div id="modal1" class="modal bottom-sheet">
        <div class="modal-content">
          <h4>Modal Header</h4>
          <p>A bunch of text</p>
        </div>
      </div>

      <!-- 전체메뉴 modal script -->
      <script>
        $(document).ready(function(){
          // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
          $('#modal1').modal();
        });
      </script>

    </div>
    
</body>
</html>