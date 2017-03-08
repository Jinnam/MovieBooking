	
	
//---------------------------- booking select start ---------------------------------------
	
	$(document).ready(function(){		
		
		//영화 선택시
		$(document).on('click','.scMovie',function(){
			$('.scMovie').removeClass('selectBlock');							//속성제거
			$(this).addClass('selectBlock');									//속성추가
			console.log($(this).children().text());								//선택값출력	
			$("#selectMovie").text($(this).children().text());					//값변경
			$("#movCode").val($(this).children().attr('value'));
			
			//모든 선택이 완료된 경우
			if($('#movCode').val()!='' && $('#brcCode').val()!='' && $('#Date').val()!='')
			{
				selectAll(); //상영 시간 가져오는 함수
				return;
			}						
		});		
		
		//지점 선택시
		$(document).on('click','.scBranch',function(){
			$('.scBranch').removeClass('selectBlock');							//속성제거
			$(this).addClass('selectBlock');									//속성추가
			console.log($(this).children().text());								//선택값 출력
			$("#selectBranch").text($(this).text());					//값 변경
			$("#brcCode").val($(this).children().attr('value'));
			
			//모든 선택이 완료된 경우
			if($('#movCode').val()!='' && $('#brcCode').val()!='' && $('#Date').val()!='')
			{
				selectAll(); //상영 시간 가져오는 함수
				return;
			}				
		});	
		
		//날짜 선택시
		$(document).on('click','.scDate',function(){
			$('.scDate').removeClass('selectBlock');	//속성제거
			$(this).addClass('selectBlock');			//속성추가
			console.log($(this).children().text());						//선택값 출력
			$("#selectDate").text($(this).text());				//값 변경
			$("#Date").val($(this).text());
			
			//모든 선택이 완료된 경우
			if($('#movCode').val()!='' && $('#brcCode').val()!='' && $('#Date').val()!='')
			{
				selectAll(); //상영 시간 가져오는 함수
				return;
			}					
		});	


		//시간 선택시
		$(document).on('click','.scTime',function(){
			
			$('.scTime').removeClass('selectBlock');								//속성제거
			$(this).addClass('selectBlock');										//속성추가
			console.log($(this).children().attr('value'));							//선택값출력	
			$("#selectScreen").text($(this).children().text());						//값변경			
			$("#scsCode").val($(this).children().attr('value'));
		});			
		
		//선택 블록 선택시에 영화 / 지점 / 날짜 가져오기
		$(document).on('click','.scSelector',function(){
			selectOne();
		});
											

		//선택조건  선택시 조건에 따른  영화 지점 날짜 가져오는 함수
		var selectOne = function() {
		    $.ajax({                               
		        url:'searchListBookingSelect',                                    
		        type:'GET',                                              
		        data:{brcCode:$('#brcCode').val() , movCode:$('#movCode').val() , Date:$('#Date').val()},                              
		        dataType : "json",                                        
		        success:function(data){
		        	console.log(data.movie);	
		        	console.log(data.branch);	
		        	console.log(data.date);	
		        	if(data.branch && data.date){ 		//조건 선택 1개 영화만 선택해 지점 , 날짜 가져온경우
		        		
		        		console.log('영화만선택');
		        		
		        		//지점 세팅
		        		$('.scBranch').remove();
		        		$.each(data.branch, function(i){
			        		$('#branchSelector').append('<div class="scSelector scBranch selectorDiv waves-effect" id="scBranch'+i+'">');
			        		$('#scBranch'+i).append('<span value="'+data.branch[i].brcCode+'">');
			        		$('#scBranch'+i).append(data.branch[i].brcName);
			        		$('#scBranch'+i).append('</span>');
			        		$('#branchSelector').append('</div>');		        			
		        		});
		        		//날짜 세팅
		        		$('.scDate').remove();
		        		$.each(data.date, function(i){
			        		$('#dateSelector').append('<div class="scSelector scDate selectorDiv waves-effect" id="scDate'+i+'">');
			        		$('#scDate'+i).append(data.date[i].scsDate);
			        		$('#dateSelector').append('</div>');		        			
		        		});		        		
		        		
		        	}else if(data.movie && data.date){		//조건 선택 1개 지점만 선택해 영화 , 날짜 가져온경우

		        		console.log('지점만선택');
		        		//영화 세팅
		        		$('.scMovie').remove();
		        		$.each(data.movie, function(i){
			        		$('#movieSelector').append('<div class="scSelector scMovie selectorDiv waves-effect" id="scMovie'+i+'">');
			        		$('#scMovie'+i).append('<span value="'+data.movie[i].movCode+'">');
			        		$('#scMovie'+i).append('<i class="grade16_'+data.movie[i].movGrade+'" style="position:relative;top:2px;"></i>');
			        		$('#scMovie'+i).append(data.movie[i].movKorName);
			        		$('#scMovie'+i).append('</span>');
			        		$('#movieSelector').append('</div>');			        			
		        		});
		        		
		        		//날짜 세팅
		        		$('.scDate').remove();
		        		$.each(data.date, function(i){
			        		$('#dateSelector').append('<div class="scSelector scDate selectorDiv waves-effect" id="scDate'+i+'">');
			        		$('#scDate'+i).append(data.date[i].scsDate);
			        		$('#dateSelector').append('</div>');		        			
		        		});			        		
		        		
		        	}else if(data.movie && data.branch){		//조건 선택 1개 날짜만 선택해 영화 , 지점 가져온경우
		        		console.log('날짜만선택');
		        		
		        		//영화 세팅
		        		$('.scMovie').remove();
		        		$.each(data.movie, function(i){
			        		$('#movieSelector').append('<div class="scSelector scMovie selectorDiv waves-effect" id="scMovie'+i+'">');
			        		$('#scMovie'+i).append('<span value="'+data.movie[i].movCode+'">');
			        		$('#scMovie'+i).append('<i class="grade16_'+data.movie[i].movGrade+'" style="position:relative;top:2px;"></i>');
			        		$('#scMovie'+i).append(data.movie[i].movKorName);
			        		$('#scMovie'+i).append('</span>');
			        		$('#movieSelector').append('</div>');			        			
		        		});		     
		        		//지점 세팅
		        		$('.scBranch').remove();
		        		$.each(data.branch, function(i){
			        		$('#branchSelector').append('<div class="scSelector scBranch selectorDiv waves-effect" id="scBranch'+i+'">');
			        		$('#scBranch'+i).append('<span value="'+data.branch[i].brcCode+'">');
			        		$('#scBranch'+i).append(data.branch[i].brcName);
			        		$('#scBranch'+i).append('</span>');
			        		$('#branchSelector').append('</div>');		        			
		        		});		        		
		        	}else if(data.date){ //조건선택 2개 영화 지점 선택한경우 날짜 세팅
		        		console.log('영화 지점 선택');
		        		//초기화
		        		$('.scDate').remove();
		        		//날짜 추가
		        		$.each(data.date, function(i){
			        		$('#dateSelector').append('<div class="scSelector scDate selectorDiv waves-effect" id="scDate'+i+'">');
			        		$('#scDate'+i).append(data.date[i].scsDate);
			        		$('#dateSelector').append('</div>');		        			
		        		});			        		
		        	}else{
		        		console.log('예외')
		        	}
		        } //sucess 블럭 닫기
		    });	//ajax 블럭 닫기	        			
		}
		
		
		//선택조건 모두 선택시 상영시간 가져오는 함수
		var selectAll = function(){
				
		    $.ajax({                               
		        url:'searchListScreenInfo',                                    
		        type:'GET',                                              
		        data:$('#scsInfoForm').serialize(),                              
		        dataType : "json",                                        
		        success:function(data){
		        	
		        	console.log(data[0]);
		        	
		        	//조건에맞는상영일정 존재하지 않는경우
		        	if(data[0]==undefined){
		        		
		        		console.log('데이터없음');
		        		$("#ScreenSchaduleSelector").html(''); //ScreenSchaduleSelector 영역 초기화
		        		$('#scHelper').text('해당조건 상영중인 영화 없음');  
		        		
		        	//상영일정 존재하는 경우
		        	}else {
		        		
		            	$("#ScreenSchaduleSelector").html(''); //ScreenSchaduleSelector 영역 초기화
		            	$('#scHelper').text('영화 선택'); //헬퍼 영역 초기화
		            	
		            	var list = data;
		                $.each(list, function(i) {
		                	$("#ScreenSchaduleSelector").append('<div id=\"scsDiv'+i+'\" class=\"scTime selectorDiv waves-effect\">');
		                	$("#scsDiv"+i).append(			'<span id=\"scsSpan'+i+'\" value=\"'+list[i].scsCode+'\">');
		                	$("#scsSpan"+i).append(				list[i].scsStartTime+' '+list[i].scsTimeDiscount);
		                	$("#scsDiv"+i).append(			'</span>');
		                	$("#ScreenSchaduleSelector").append("</div>");
		                });		            		
		        	}	    
		        } //sucess 블럭 닫기
		    });	//ajax 블럭 닫기	        			
		}		
	
		//좌석 선택 버튼 클릭시 
		$('#seatSelectBtn').click(function(){
			if($('#scsCode').val()!=""){
				$('#scsInfoForm').submit();
			}else {
				alert('상영시간을 선택하세요');
				}
			});
			
		});
	
//---------------------------- booking select end ---------------------------------------
