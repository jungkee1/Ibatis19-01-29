<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> 
<script>
$(document).ready(function(){
	$("#btnZip").click(function(){
		window.open("zipAction","","width=700 height=500");
	})
})
</script>


</head>
<body>
<form action="insertAction" method="post">
<table>
	<tr>
		<td colspan="2">주소록 등록하기 </td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			 <input type="text" name="name" id="name">
		</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>
			<input type="text" name="zipcode" id="zipcode"> <input type="button" value="검색" id="btnZip" name="btnZip">
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="addr" id="addr" size=80>
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			 <input type="text" name="tel" id="tel">
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="등록" id="btnSubmit" name="btnSubmit"> <input type="button" value="취소" name="btnCancel" id="btnCancel"> </td>
	</tr>
		
	
</table>
</form>









	

</body>
</html>