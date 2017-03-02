<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 상세페이지</title>
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
                <img class="materialboxed responsive-img" src="${movie.movImgPath}">
              </div>

              <!-- 상세설명 -->
              <div class="col s9">
                <h2>
                	<i class="grade24_${movie.movGrade}" style="position:relative;top:5px;"></i>
                	 ${movie.movKorName}
                </h2>
                <span class="col s9" style="color:#8C8C8C;">
                  <sapn style="position:relative ; top:10px;">${movie.movEngName}</span>
                  <span>${movie.movStatus} </span>
                  <span style="text-align:right;"><a class="waves-effect waves-light btn" style="border-radius:0em ;">예매하기</a></span>
                  <!-- 간격 --><div style="height:10px;"></div>
                </span>
                <div class="divider"></div>
                <div><b>평점 : </b> <span>8.0</span></div>
                <div><b>감독 : </b> <span><a href="${movie.charCode}">${movie.producer}</a></span></div>
                <div><b>출연진 : </b> 
                	<span>
						<c:forEach var="charInfo" items="${charList}"> 
							<a href="${charInfo.charCode}">${charInfo.charKorName}</a>
						</c:forEach>
                	</span>
                </div>
                <div><b>장르 : </b> <span>${movie.movGenre} / ${movie.movRunningTime}분/${movie.movNation}</span></div>
                <div><b>개봉일 : </b> <span>${movie.movOpenDate}</span></div>
                <div style="height:40px;"></div>
                <div>
                  <i class="medium material-icons">thumb_up</i>
                  <div class="ui large label" style="position:relative ; top:-15px;">
                    ${movie.likeTotalCount}
                  </div>
                </div>
              </div>

              <!-- 줄거리 -->
              <div class="col s12" style="font-size:11px ; color:#4C4C4C;">
                <h3>줄거리</h3>
                <pre>${movie.movInfoDetail}</pre>
              </div>

              <!-- 스틸컷 이미지 -->
              <div class="col s12">
                <h3>스틸컷</h3>
                <!-- 캐러셀 -->
                <div class="carousel" style="z-index:1;">
                  <a class="carousel-item " href="#one!"><img class="materialboxed" src="http://image2.megabox.co.kr/mop/still/2017/A0/530E53-D9D5-4E72-AB92-6D570FFAEB79.large.jpg"></a>
                  <a class="carousel-item " href="#two!"><img class="materialboxed" src="http://image2.megabox.co.kr/mop/still/2017/79/A851FA-89A2-4F21-84FA-1145E1B5A923.large.jpg"></a>
                  <a class="carousel-item " href="#three!"><img class="materialboxed" src="http://image2.megabox.co.kr/mop/still/2017/39/CE2549-9A79-4E6E-9194-30D5B9741FD9.large.jpg"></a>
                  <a class="carousel-item " href="#four!"><img class="materialboxed" src="http://image2.megabox.co.kr/mop/still/2017/6E/00C691-D828-4768-9EB5-F64BF524F1F8.large.jpg"></a>
                  <a class="carousel-item " href="#five!"><img class="materialboxed" src="http://image2.megabox.co.kr/mop/still/2017/BE/7FB7E8-D5CB-412C-98EA-DCD10C47D9FE.large.jpg"></a>
                </div>
              </div>
              <!-- 캐러셀 스크립트 -->
              <script>
                // 캐러셀
                $(document).ready(function(){
                  $('.materialboxed').materialbox();
                  $('.carousel').carousel();
                });

              </script>

            </div>
          </div>

          <!-- 리뷰 영역 -->

          <div class="card-action">
            <div class="ui comments">
              <h3 class="ui dividing header">댓글</h3>

              <div class="comment">
                <a class="avatar">
                  <img src="./img/default-profile-img.jpg">
                </a>
                <div class="content">
                  <a class="author">김진남</a>
                  <div class="metadata">
                    <span class="date">Today at 5:42PM</span>
                  </div>
                  <div class="text">
                    쓰레기네
                  </div>
                  <div class="actions">
                    <a class="reply">Reply</a>
                  </div>
                </div>
              </div>


              <div class="comment">
                <a class="avatar">
                  <img src="./img/default-profile-img.jpg">
                </a>
                <div class="content">
                  <a class="author">조봉연</a>
                  <div class="metadata">
                    <span class="date">Yesterday at 12:30AM</span>
                  </div>
                  <div class="text">
                    <p>↑????</p>
                  </div>
                  <div class="actions">
                    <a class="reply">Reply</a>
                  </div>
                </div>


                <div class="comments">
                  <div class="comment">
                    <a class="avatar">
                      <img src="./img/default-profile-img.jpg">
                    </a>
                    <div class="content">
                      <a class="author">조민국</a>
                      <div class="metadata">
                        <span class="date">Just now</span>
                      </div>
                      <div class="text">
                        22
                      </div>
                      <div class="actions">
                        <a class="reply">Reply</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>


              <div class="comment">
                <a class="avatar">
                  <img src="./img/default-profile-img.jpg">
                </a>
                <div class="content">
                  <a class="author">김정빈</a>
                  <div class="metadata">
                    <span class="date">5 days ago</span>
                  </div>
                  <div class="text">
                    ??
                  </div>
                  <div class="actions">
                    <a class="reply">Reply</a>
                  </div>
                </div>
              </div>

              <!-- 댓글 쓰기 창 -->
              <form class="ui reply form">
                <div class="field">
                  <textarea></textarea>
                </div>
                <div class="ui blue labeled submit icon button">
                  <i class="icon edit"></i> Add Reply
                </div>
              </form>

            </div>
          </div>




        </div>
      </div>
    </div> <!-- 메인 div -->




<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>