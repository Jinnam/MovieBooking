<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<label>코드 생성</label>
		<form action="/codeTest" method="post">
		<select name="kind">
			<option value="nonMember">nonMember</option>
			<option value="mileage">mileage</option>
			<option value="reply">reply</option>
			<option value="replyRecommend">replyRecommend</option>
			<option value="seats">seats</option>
		</select>
		<input type="submit" value="코드생성"/>
		</form>
		<label>생성된 코드@ : </label>
		<span>${resultCode}</span><br/>
		<label>상영 코드 : </label>
		<span>${returnScreenCode}</span><br/>
		<label>지점별 예매.매출 코드 : </label>
		<span>${returnBDCCode}</span><br/>
		<label>상영 일정 코드 : </label>
		<span>${returnSCSCCode}</span><br/>
		<label>좌석 코드 : </label>
		<span>${resultCode}</span><br/>
		<label>결제 코드 : </label>
		<span>${resultCode}</span><br/>
	</div>
</body>
</html>