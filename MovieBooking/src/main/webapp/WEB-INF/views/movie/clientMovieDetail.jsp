<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 상세페이지</title>
<link rel="SHORTCUT ICON" href="resources/module-img/titleIcon.png">

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>    
<script type="text/javascript">
   
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart1);
	google.charts.setOnLoadCallback(drawChart2);	

       
	function drawChart1() {
	
		// Create the data table.
		var data1 = new google.visualization.DataTable();
		data1.addColumn('string', 'Topping');
		data1.addColumn('number', 'Slices');
		data1.addRows([
		  ['남성', ${ticketCount.manCnt}],
		  ['여성', ${ticketCount.womanCnt}],
		]);
		
		// Set chart options
		var options1 = {'title':'성별 예매 분포',
		               'width':400,
		               'height':300};
		
		// Instantiate and draw our chart, passing in some options.
		
		var chart1 = new google.visualization.PieChart(document.getElementById('chart_div1'));
		chart1.draw(data1, options1);
	} 
	        	
	function drawChart2() {
	
		// Create the data table.
		var data2 = new google.visualization.DataTable();
		data2.addColumn('string', 'Topping');
		data2.addColumn('number', 'Slices');
		data2.addRows([
		  ['10대', ${ticketCount.teenCnt}],
		  ['20대', ${ticketCount.twentyCnt}],
		  ['30대', ${ticketCount.thirtyCnt}],
		  ['40대', ${ticketCount.fortyCnt}],
		  ['50대이상',${ticketCount.overCnt}],
		]);
		
		// Set chart options
		var options2 = {'title':'연령별 예매 분포',
		               'width':400,
		               'height':300,
		               'pieHole': 0.4,};
		
		// Instantiate and draw our chart, passing in some options.
		
		var chart2 = new google.visualization.PieChart(document.getElementById('chart_div2'));
		chart2.draw(data2, options2);
	}          
 	         	     
</script>


</head>
<body>

<!-- 네비게이션 바 -->
<%@ include file="/WEB-INF/clientModule/topNavBar.jsp" %>

<!-- 전체메뉴 white-->
<%@ include file="/WEB-INF/clientModule/topTotalMenuBarWhite.jsp" %>



    <!-- 메인 -->

    <div class="row container" style="width:970px ; text-align:center; ">
      <div class="col s12" style="text-align:left;">
        <div class="card grey lighten-4">

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
                  <c:if test="${movie.movStatus == '상영중' || movie.movStatus == '상영예정'}">
                 	 <span style="text-align:right;"><a class="waves-effect waves-light btn" style="border-radius:0em ;">예매하기</a></span>
                  </c:if>
                  <!-- 간격 --><div style="height:10px;"></div>
                </span>
                <div class="divider"></div>
                <div><b>평점 : </b> <span>8.0</span></div>
                <div><b>감독 : </b> <span><a href="clientCharDetail?charCode=${movie.charCode}">${movie.producer}</a></span></div>
                <div><b>출연진 : </b> 
                	<span>
						<c:forEach var="charInfo" items="${charList}"> 
							<a href="clientCharDetail?charCode=${charInfo.charCode}">${charInfo.charKorName}</a>
						</c:forEach>
                	</span>
                </div>
                <div><b>장르 : </b> <span>${movie.movGenre} / 러닝타임 : ${movie.movRunningTime}/${movie.movNation}</span></div>
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


			 
			 <!-- 차트2  -->
			 <div class="col s6 card" id="chart_div1"></div>
			 
			 <!-- 차트1  -->
			 <div class="col s6 card" id="chart_div2"></div>		 
			 
			 <div class="col s2"><h3>예고편</h3></div>
			 <div class="col s8" style="text-algin:center;">			
			 	${movie.movVideoPath}
			 </div>
			 <div class="col s2"></div>
              <!-- 스틸컷 이미지 -->
              <div class="col s12">
                <h3>스틸컷</h3>
                <!-- 캐러셀 -->
                	<div class="carousel" style="z-index:1;">
                		<c:forEach var="stcImg" items="${stcImgList}"> 		            
		                  <a class="carousel-item " href="#one!">
		                  	<img class="materialboxed" src="${stcImg}">
		                  </a>         
		            	</c:forEach>
		            </div>
              </div>
              <!-- 캐러셀 스크립트 -->
              <script>
                // 캐러셀
                $(document).ready(function(){
                  $('.materialboxed').materialbox();
                  $('.carousel').carousel();
                })

              </script>

            </div>
          </div>

          <!-- 리뷰 영역 -->

			<div class="card-action">
				<h3>한줄평</h3>
			    <ul class="collection">
			      <li class="collection-item">Alvin</li>
			      <li class="collection-item">Alvin</li>
			      <li class="collection-item">Alvin</li>
			      <li class="collection-item">Alvin</li>
			    </ul>
			</div>




        </div>
      </div>
    </div> <!-- 메인 div -->




<!-- 하단바 -->
<%@ include file="/WEB-INF/clientModule/footer.jsp" %>

</body>
</html>