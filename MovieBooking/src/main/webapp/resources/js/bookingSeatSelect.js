//---------------------------- booking Seat select start ---------------------------------------	
	
    $(document).ready(function(){
    	$('#personNum').val($('#ticketNum').val()); //초기 선택가능 좌석 값
    	var maxSeatCount=$('#ticketNum').val(); //선택가능한 좌석 수
		var currentSeatCount = 0; //현재 선택 좌석 수    	
    	
    	
    	//시트 선택시
		$(".seat").click(function(){
			
			//현재선택된 좌석인경우
			if($(this).hasClass('currentSelect')){
				alert('현재 선택된 좌석입니다.');
			}				
			
			//사용가능 좌석인 경우
			if($(this).hasClass('able')){
				
				//선택가능 좌석수가 현재 선택 좌석 수보다 작은 경우
				if(currentSeatCount<maxSeatCount){
					$(this).attr('class','seat currentSelect'); //현재선택좌석으로 변경
					currentSeatCount=currentSeatCount*1+1; //현재선택좌석수 증가
					
					if(currentSeatCount==1){ 			//현재좌석선택수 1인경우
						$('#seatCode1').val($(this).attr('seatCode'));
					}else if(currentSeatCount==2){		//현재좌석선택수 2인경우
						$('#seatCode2').val($(this).attr('seatCode'));
					}else if(currentSeatCount==3){		//현재좌석선택수 3인경우
						$('#seatCode3').val($(this).attr('seatCode'));
					}else if(currentSeatCount==4){		//현재좌석선택수 4인경우
						$('#seatCode4').val($(this).attr('seatCode'));
					}
					//선택좌석화면에 추가
					$('#selectSeats').append('<div class=\"seatInfo\">'+$(this).attr('row')+$(this).attr('col')+'</div>');
				} else {
					alert('선택 좌석 수를 초과하였습니다.');
				}

			}

			//사용중 좌석인경우
			if($(this).hasClass('use')){
				alert('이미 예매된 좌석입니다.');
			}
			
			//선택불가능 좌석인경우
			if($(this).hasClass('unable')){
				alert('선택불가 좌석입니다..');
			}
			
		});
		
    	//예매 인원 변경시 
    	$('#ticketNum').change(function(){
    		seatReset();
    	});		
    	
    	//리셋버튼 클릭시
    	$('#reset').click(function(){
    		seatReset();
    	});
    	
    	//결제버튼 클릭시
    	$('#submit').click(function(){
    		if(maxSeatCount==currentSeatCount){
        		$('#realForm').submit();    			
    		}else{
    			alert('좌석선택이 완료되지 않았습니다.');	
    		}
    	});
    	
    	//좌석 초기화 함수
    	var seatReset = function() {
    		$('#personNum').val($('#ticketNum').val()); //인원정보 변경
    		maxSeatCount = $('#ticketNum').val(); //선택가능인원수 변경 
    		currentSeatCount = 0;	//현재선택인원 0으로 초기화
    		$('.currentSelect').attr('class','seat able'); //선택좌석속성 초기화
    		$('#selectSeats').html(''); //선택좌석화면 초기화
    		
    		//선택 폼 초기화
    		$('#seatCode1').val('');
    		$('#seatCode2').val('');
    		$('#seatCode3').val('');
    		$('#seatCode4').val('');
    		
    	}    	
    });

//---------------------------- booking Seat select end ---------------------------------------	