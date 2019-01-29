<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체보기</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> 

<script>
$(document).ready(function(){
	$("#btnSearch").click(function(){
		if($("#word").val() == ""){
			alert("검색어를 입력하세요");
			return false;
		}
		$.get("searchAction",
			{"field" : $("#field").val(), "word" : $("#word").val()},
			function(data){
				var htmlStr = "<table>";
				htmlStr += "<tr><th>이름</th><th>주소</th>";
				htmlStr += "<th>우편번호</th><th>전화번호</th></tr>";
				htmlStr += data;
				htmlStr += "</table>";
				$("#area").html(htmlStr);
			}
		);// get
	})
})
</script>
</head>
<body>
등록된 주소록 수 : ${count }
<br><br>
<table border="1">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>우편번호</td>
		<td>주소</td>
		<td>전화번호</td>
	</tr>
<c:forEach var = "ad" items="${lists}" varStatus="status"> <!-- var 해줘야함 forEach 문법이다  -->
	<tr>
		<td><a href="viewAction?number=${ad.num} ">${status.index+1}</a></td> <!-- 수로 받아오기 때문에 +1 하면 0부터 시작을 1부터 시작으로 바꿀 수 있음  -->
		<td>${ad.name} </td>
		<td>${ad.addr} </td>
		<td>${ad.zipcode} </td>
		<td>${ad.tel} </td>
	</tr>
	
</c:forEach>
</table>
<br><br>
<form name="search" id="search">
<select name="field" id="field">
	<option value="name">이름</option>
	<option value="tel"> 전화번호</option>
</select>
<input type="text" name="word" id="word">
<input type="button" value="찾기" id="btnSearch">
</form>
<div id="area">
</div>



</body>
</html>