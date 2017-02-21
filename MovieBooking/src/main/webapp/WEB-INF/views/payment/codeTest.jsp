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
	<div style="align:center">
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
		<label>생성된 코드</label>
		<span>${resultCode}</span>
	</div>
</body>
</html>