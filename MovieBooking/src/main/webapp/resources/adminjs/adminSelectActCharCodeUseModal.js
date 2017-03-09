function ActBtnClick(i) {
	//버튼클릭시 선택한 행의 인물코드와 인물이름 변수에 담음
	var choiceActCharCode = $("#choiceActCharCode"+i);
	var choiceActCharKorName = $("#choiceActCharKorName"+i);
	// log
	console.log(choiceActCharCode.text());
	console.log(choiceActCharKorName.text());
	//화면에 선택한 인물 코드와 인물 이름 추가
	$("#ActCharInfo").append(
			'<label class="col-lg-3 control-label">배우코드</label>'
			+'<div class="col-lg-9">'
			+	'<input type="text" class="form-control"'
			+			'id="charCodeAct" name="charCode"'
			+			'value="'+choiceActCharCode.text()+'"'
			+			'required="required" readonly="readonly">'
			+'</div>'
			+'<label class="col-lg-3 control-label">배우이름</label>'
			+'<div class="col-lg-9">'
			+	'<input type="text" class="form-control"'
			+			'id="charKorNameAct" required="required"'
			+			'value="'+choiceActCharKorName.text()+'" readonly="readonly">'
			+'</div>'
	);
	window.close();
	}
$(document).ready(function() {
	$("#selectCharcodeActor").click(function() {
		$.ajax({
			url 		: "selectCharcodeUseModal",
			data 		: {"charKorName" : $("#ActKorNameUseModal").val()},
			dataType 	: "json",
			type 		: "post",
			success 	: function(data) {
				$("#charNameActor").html('');		//감독이름 들어갈 태그안 초기화 안해주면 중복됨
				var list = data;					//가져온 데이터 변수 list에 담고
				console.log(data);					//log
				$.each(list, function(i) {			//감독이름으로 감독정보 모달에 조회	
					$("#charNameActor").append(
								'<tr>'
									+'<td>'+(i+1)				+'</td>'
									+'<td id="choiceActCharKorName'+i+'">'	+list[i].charKorName	+'</td>'
									+'<td id="choiceActCharCode'+i+'">'		+list[i].charCode		+'</td>'
									+'<td>'+list[i].charNation	+'</td>'
									+'<td>'+list[i].charBirth	+'</td>'
									+'<td>'+list[i].charGender	+'</td>'
									+'<td>'
									+'	<input	type="button"'
									+'			onClick="ActBtnClick('+i+')"'
									+'			id="choiceCharCodeBtn;"'
									+'			class="btn btn-button" value="선택">'
									+'</td>'
								+'</tr>')
				});
			}
		});
	});
});