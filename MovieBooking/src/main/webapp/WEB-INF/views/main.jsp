<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인덱스 페이지</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">
</head>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>

  </head>
  <body class="grey lighten-3">

    <!-- 네비게이션 바 -->
    <div class="navbar-fixed">
      <nav class="light-blue darken-4">
        <div class="nav-wrapper container">
          <a href="#" class="brand-logo">1Team Portfolio Index</a>
          <ul id="nav-mobile" class="right hide-on-med-and-down">
          </ul>
        </div>
      </nav>
    </div>


    <div class="container">
      <div class="row">
      
	        <a href="movieMain" style=" text-decoration:none; color:#000000 ">
	        
	          <div class="col s6">
	            <div class="card">
	              <div class="card-image">
	                <img src="resources/index_img/1team_movieMain.jpg" style="height:auto;">
	              </div>
	              <div class="card-content">
	                <p>클라이언트</p>
	              </div>
	            </div>
	          </div>
	          
	        </a>
	
	        <a href="adminMain" style=" text-decoration:none; color:#000000">
	        
	          <div class="col s6">
	            <div class="card">
	              <div class="card-image">
	                <img src="resources/index_img/1team_adminMain.jpg" style="height:auto;">
	              </div>
	              <div class="card-content">
	                <p>관리자</p>
	              </div>
	            </div>
	          </div>
	          
	        </a>
	        
	      </div>
      </div>
  



    <!-- 영화관리 modal -->
    <div id="modal1" class="modal">
      <div class="modal-content">
        <h4>Modal 1</h4>
        <p>A bunch of text</p>
      </div>
      <div class="modal-footer">
        <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
      </div>
    </div>


    <!-- 도서관리 modal -->
    <div id="modal2" class="modal">
      <div class="modal-content">
        <h4>Modal 2</h4>
        <p>A bunch of text</p>
      </div>
      <div class="modal-footer">
        <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
      </div>
    </div>


    <!-- 여백 -->
    <div style="height:100px"></div>




  </body>
</html>

</html>