<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


개수 : ${count } <!-- servlet 에서 이미 갯수 구하고 넘어옴   -->
개수 : ${slists.size()}
<c:forEach items="${slists }" var="dto">
<tr>
	<td>${dto.name }</td>
	<td>${dto.addr }</td>
	<td>${dto.zipcode }</td>
	<td>${dto.tel }</td>
</tr>
</c:forEach>