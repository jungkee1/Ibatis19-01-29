<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기 페이지</title>
</head>
<body>
<form action="updateAction">
<table>
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>주소</td>
		<td>전화번호</td>
		<td>우편번호</td>
	</tr>
	<tr>
		<td><input type="hidden" name="num" value= "${vo.num }"></td>
		<td>${vo.num }</td>
		<td><input type="text" name="name" value="${vo.name }"></td>
		<td><input type="text" name="addr"value="${vo.addr }"></td>
		<td><input type="text" name="tel" value="${vo.tel }"></td>
		<td><input type="text" name="zipcoe" value="${vo.zipcode }"></td>
	</tr>	
</table>
<input type="submit" value="수정"> <input type="button" value="삭제" onclick="location.href='deleteAction?num=${vo.num}'"/>
</form>
</body>
</html>