<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
       
       <!-- user css -->
       <link rel="stylesheet" href="resources/css/user.css">
              
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
    <div class="ui three item menu" style="height:50px ; margin-top:0px ; margin-bottom:-0 ; box-shadow:none ; border-radius:0em ; position:fixed ; z-index:1000 ; ">
      <div class="container" style="width:970px">
        <a href="movieMain" style="margin-top:8px"><img src="resources/module-img/logo2.png"></a>
        <a class="item" style ="width:20px"></a> <!-- 시작선 -->
        <!-- 영화 -->
        <a href="clientMovieListBoxoffice1" class="item" style ="width:130px"><img src="resources/module-img/menu_movie.png" style="width:100px;height:40px"></a>	
        <!-- 극장 -->		
        <a href="#" class="item" style ="width:130px"><img src="resources/module-img/menu_theater.png" style="width:100px;height:40px"></a>			
        <!-- 예매 -->				
        <a href="bookingSelect" class="item" style ="width:130px"><img src="resources/module-img/menu_ticket.png" style="width:100px;height:40px"></a>		
        <!-- 스토어 -->					
        <a href="#" class="item" style ="width:130px"><img src="resources/module-img/menu_store.png" style="width:100px;height:40px"></a>       
        <!-- 이벤트 -->							
        <a href="#" class="item" style ="width:130px"><img src="resources/module-img/menu_event.png" style="width:100px;height:40px"></a> 								
        
        <!-- 로그인 전 -->
        <c:if test="${id == null }">
	        <!-- 로그인 드랍다운 -->
	        <div class="item ui floating dropdown" style="width:130px">
	          <div id="loginDropDown" style="width:100%; padding:15px 0;">
	            <img src="resources/module-img/menu_login.png" style="width:100px;height:40px">
	          </div>
	          <div class="menu" style="width:350px ; position:absolute; left:-220px;">
	            <form style="width:300px;margin: 10px 10px 10px 10px;" action="memberLogin" method="post" id="loginForm">
	              <!-- 로그인 폼시작 -->
	              <div class="item" data-value="drop">
	                <table>
	                  <tr>
							<td><p style="text-align: center;"><img src="resources/module-img/loginLogo.PNG"><p><br></td>
	                  </tr>
	                  
	                  <tr>
	                    	<td><input type="text" name="memId" id="memId" value="id001" style ="width:300px"></td>
	                  </tr>
	                  <tr>
	                    	<td><input type="text" name="memPw" id="memPw" value="pw001" style ="width:300px"></td>
	                  </tr>
	                  
	                  <tr>
	                  		<td><br><span style="float:right"><input class="btn blue darken-4" type="button" id="btnLogin" value="로그인"></span></td>
	                  </tr>
	                  
	                </table>
	                <br>
	                <div>
	                  <a href="memberFind"><img src="resources/module-img/memberFind.PNG"></a>
	                  <a href="memberProvision"><img src="resources/module-img/memberInserts.PNG"></a>
	                  <a href="nonMemberLogin"><img src="resources/module-img/nonmemberReserve.png"></a>
	                </div>
	              </div>
	              <!-- 로그인 폼 끝 -->
	            </form>
	          </div>
	        </div>
        </c:if>
        
        <!-- 로그인 후 -->
        
        <c:if test="${id !=null }">
        <div class="item ui floating dropdown" style="width:130px">
          <div id="loginDropDown" style="width:100%; padding:15px 0;">
          <label style="text-align: right;">${name}님 환영합니다</label>
            <!-- <img src="resources/module-img/menu_login.png" style="width:100px;height:40px"> -->
          </div>
          <div class="menu" style="position:absolute; left:-200px;">
            <form style="width:300px;margin: 10px 10px 10px 10px;" action="memberLogin" method="post" id="loginForm">
            
              <!-- 로그인 후 폼시작 -->
              <div class="item" data-value="drop">
                <table style="border-bottom: 2px solid #E5E5E5">
                  <tr style="border-bottom: 2px solid #E5E5E5">
                	<td><p style="text-align: center;"><img src="resources/module-img/loginLogo.PNG"><p></td>
                	<td>${id}님.</td>
                  </tr>
                  <tr>
                    <td>총 마일리지  :</td>
                    <td align="right">${mileages}P</td>
                  </tr>
                   <tr>
                    <td>가입일  : </td>
                    <td > ${joinday}</td>
                  </tr>
                  
                </table>
                <br><br>
                <div>
                  <a href="mileageList"><img src="resources/module-img/mypage.PNG" align="left"></a>
                </div>
                <br>
                <div>
                  <a href="logout"><img src="resources/module-img/logout.PNG" align="right"></a>
                </div>
              </div>
              <!-- 로그인 후 폼 끝 -->
            </form>
          </div>
        </div>
        </c:if>
        
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
        	<script>
			$(document).on('click','#btnLogin',function(){
					console.log("로그인 체크");
					if($('#memId').val()==null || $('#memId').val()==""){
						alert("로그인정보를 입력하세요");
					}else{
				   $.ajax({ 
				      url : "memberLogin", 
				      type :"post", 
				      data : { "memId" : $("#memId").val(),"memPw" : $("#memPw").val(),}, 
				      success : function(data){ 
				    	  console.log(data);
				          if(data != ""){ 
				        	 alert("어서오세요!") 
				        	 location.reload();
				          }else{ 
				        	  alert("로그인 정보가 잘못되었습니다.") 
				            
				         } 
				      },error:function(){
				          alert("에러임");
				       }
				   }) ;
					}
				});
		</script>
        <script>
        
        
        
        </script>
        
        
        <a class="item" style ="width:1px"></a>  <!-- 메뉴 끝선 -->
      </div> <!-- 상단바 container 끝 -->
    </div> <!-- 상단바 끝 -->

</body>
</html>