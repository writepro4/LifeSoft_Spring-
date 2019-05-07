<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>한줄 메모장</h2>
<table border="1" style="width:500px";>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>메모</th>
		<th>날짜</th>
	</tr>
<c:forEach var="row" items="${list}"> <!--  forEach로 반복해서 돌리고  -->
<tr>
	<td>${row.idx}</td>
	<td>${row.writer}</td>
	<td>${row.memo}</td>
	<td><fmt:formatDate value="${row.post_date}" 
			pattern="yyyy-mm-dd HH:mm:ss" /></td>
	</tr>
</c:forEach>
</table>
</body>
</html>