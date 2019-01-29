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
	$("#result").on("click", "tr", function(){
		var address = $("td:eq(1)", this).text()+ " " +
					  $("td:eq(2)", this).text()+ " " +
					  $("td:eq(3)", this).text()+ " " +
					  $("td:eq(4)", this).text()+ " " 
		$(opener.document).find("#zipcode").val($("td:eq(0)",this).text());
		$(opener.document).find("#addr").val(address);
	})
})


function zipSearch(){
	$.ajax({
		type : "get",
		url : "zipSearch",
		data : {"dong" :$("#dong").val()},
		success : function(data){
			data = $.parseJSON(data);
			var htmlStr = "";
			htmlStr += "<table border=1>";
			htmlStr += "<tr>";
			htmlStr += "<td width='100'>우편번호</td>";
			htmlStr += "<td width='50'>시/도</td>";
			htmlStr += "<td width='50'>구/군</td>";
			htmlStr += "<td width='50'>동</td>";
			htmlStr += "<td width='50'>번지</td>";
			htmlStr += "</tr>";
			for(var i=0;i<data.length;i++){
				htmlStr += "<tr class='addr'>"
				htmlStr += "<td>" + data[i].zipcode+"</td>";
				htmlStr += "<td>" + data[i].sido+"</td>";
				htmlStr += "<td>" + data[i].gugun+"</td>";
				htmlStr += "<td>" + data[i].dong+"</td>";
				htmlStr += "<td>" + data[i].bunji+"</td>";
				htmlStr += "</tr>"
			}
			htmlStr += "</table>";
			$("#result").html(htmlStr);
		},
		error:function(e){
			alert("error:" +e);
		}
	})
}
</script>
</head>

<body>
<form>
<table>
	<tr>
		<td>동이름 입력<input type="text" name="dong" id="dong">
		<input type="button" id="send" value="검색" onclick="zipSearch()">
</table>
</form>
<div id="result"></div>

</body>
</html>