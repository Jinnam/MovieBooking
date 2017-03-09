function DirBtnClick(i) {
	var choiceCharCode = $("#choiceCharCode"+i)
	var charKorName = $("#charKorName"+i)
	console.log(choiceCharCode.text())
	console.log(charKorName.text())
	$("#charCodeDir").val(choiceCharCode.text())
	$("#charKorNameDir").val(charKorName.text())
}
$(document).ready(function() {
	$("#selectCharcodeUseModalBtn").click(function() {
		$.ajax({
			url 		: "selectCharcodeUseModal",
			data 		: {"charKorName" : $("#charKorNameUseModal").val()},
			dataType 	: "json",
			type 		: "post",
			success 	: function(data) {
				$("#charName").html('');		//감독이름 들어갈 태그안 초기화 안해주면 중복됨
				var list = data;
				console.log(data);
				$.each(list, function(i) {		//감독이름으로 감독정보 모달에 조회	
					$("#charName").append(
								'<tr>'
									+'<td>'+(i+1)				+'</td>'
									+'<td id="charKorName'+i+'">'		+list[i].charKorName	+'</td>'
									+'<td id="choiceCharCode'+i+'">'	+list[i].charCode		+'</td>'
									+'<td>'+list[i].charNation	+'</td>'
									+'<td>'+list[i].charBirth	+'</td>'
									+'<td>'+list[i].charGender	+'</td>'
									+'<td>'
									+'	<input	type="button"'
									+'			onClick="DirBtnClick('+i+')"'
									+'			id="choiceCharCodeBtn"'
									+'			class="btn btn-button" value="선택">'
									+'</td>'
								+'</tr>')
				});
			}
		});
	});
});