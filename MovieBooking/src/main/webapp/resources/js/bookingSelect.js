	
	
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
				importSC(); //상영 시간 가져오는 함수
				return;
			}						
		});		
		
		//지점 선택시
		$(document).on('click','.scBranch',function(){
			$('.scBranch').removeClass('selectBlock');							//속성제거
			$(this).addClass('selectBlock');									//속성추가
			console.log($(this).children().text());								//선택값 출력
			$("#selectBranch").text($(this).children().text());					//값 변경
			$("#brcCode").val($(this).children().attr('value'));
			
			//모든 선택이 완료된 경우
			if($('#movCode').val()!='' && $('#brcCode').val()!='' && $('#Date').val()!='')
			{
				importSC(); //상영 시간 가져오는 함수
				return;
			}				
		});	
		
		//날짜 선택시
		$(document).on('click','.scDate',function(){
			$('.scDate').removeClass('selectBlock');	//속성제거
			$(this).addClass('selectBlock');			//속성추가
			console.log($(this).children().text());						//선택값 출력
			$("#selectDate").text($(this).children().text());				//값 변경
			$("#Date").val($(this).children().text());
			
			//모든 선택이 완료된 경우
			if($('#movCode').val()!='' && $('#brcCode').val()!='' && $('#Date').val()!='')
			{
				importSC(); //상영 시간 가져오는 함수
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
											

	
		// 영화 선택시 지점 / 시간 가져오는 함수
		var importBranchTime = function(){
		    $.ajax({                               
		        url:'searchListBranchTime',                                    
		        type:'post',                                              
		        data:$('#scsInfoForm').serialize(),                              
		        dataType : "json",                                        
		        success:function(data){
		        	
		        	console.log(data[0]);
		        	
		        	//조건에맞는상영일정 존재하지 않는경우
		        	if(data[0]==undefined){
		        		
		        		console.log('데이터없음');
		        		$("#movieSelector").html(''); //movieSelector 영역 초기화
		        		$('#scHelper').text('해당조건 상영중인 영화 없음');  
		        		
		        	//상영일정 존재하는 경우
		        	}else {
		        		
		            	$("#movieSelector").html(''); //movieSelector 영역 초기화
		            	$('#scHelper').text('영화 선택'); //헬퍼 영역 초기화
		            	
		            	var list = data;
		                $.each(list, function(i) {
		                	$("#movieSelector").append('<div id=\"scsDiv'+i+'\" class=\"scTime selectorDiv waves-effect\">');
		                	$("#scsDiv"+i).append(			'<span id=\"scsSpan'+i+'\" value=\"'+list[i].scsCode+'\">');
		                	$("#scsSpan"+i).append(				list[i].scsStartTime+' '+list[i].scsTimeDiscount);
		                	$("#scsDiv"+i).append(			'</span>');
		                	$("#movieSelector").append("</div>");
		                });		            		
		        	}	    
		        } //sucess 블럭 닫기
		    });	//ajax 블럭 닫기	        					
		}
		
		//선택조건 모두 선택시 상영시간 가져오는 함수
		var importSC = function(){
				
		    $.ajax({                               
		        url:'searchListScreenInfo',                                    
		        type:'post',                                              
		        data:$('#scsInfoForm').serialize(),                              
		        dataType : "json",                                        
		        success:function(data){
		        	
		        	console.log(data[0]);
		        	
		        	//조건에맞는상영일정 존재하지 않는경우
		        	if(data[0]==undefined){
		        		
		        		console.log('데이터없음');
		        		$("#movieSelector").html(''); //movieSelector 영역 초기화
		        		$('#scHelper').text('해당조건 상영중인 영화 없음');  
		        		
		        	//상영일정 존재하는 경우
		        	}else {
		        		
		            	$("#movieSelector").html(''); //movieSelector 영역 초기화
		            	$('#scHelper').text('영화 선택'); //헬퍼 영역 초기화
		            	
		            	var list = data;
		                $.each(list, function(i) {
		                	$("#movieSelector").append('<div id=\"scsDiv'+i+'\" class=\"scTime selectorDiv waves-effect\">');
		                	$("#scsDiv"+i).append(			'<span id=\"scsSpan'+i+'\" value=\"'+list[i].scsCode+'\">');
		                	$("#scsSpan"+i).append(				list[i].scsStartTime+' '+list[i].scsTimeDiscount);
		                	$("#scsDiv"+i).append(			'</span>');
		                	$("#movieSelector").append("</div>");
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
