<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>

<style>
body {
	width: 800px;
	margin: 0 auto;
}

table {
	margin: 0 auto;
}

th {
	background-color: aqua;
	border-radius: 10px;
	text-align: center;
}

td {
	background-color: greenyellow;
	border-radius: 10px;
	text-align: center;
}

#no {
	width: 40px;
}

#title {
	width: 463px;
}

#who {
	width: 100px;
}

#nowDate {
	width: 100px;
	font-size: 12px;
}

#DM {
	width: 60px;
}

#newWT {
	float: right;
}

#log {
	margin: 0 0 0 460px;
}

a {
	text-decoration: none;
	a: hover{text-decoration: red
}

#lb {
	color: pink;
}
}
</style>
<body>
	<div id="log">
		<label id="lb">
			<%
				out.print(session.getAttribute("ID"));
			%> 님 접속중
		</label>
	 	<input type="button" name="logout" value="로그아웃" onclick="location.href='logout'">
		 <input type="button" name="newWT" value="글작성" onclick="location.href='writeBBR.jsp'">
	</div>
	<table>
		<tr>
			<th id="no">번호</th>
			<th id="title">제목</th>
			<th id="who">작성자</th>
			<th id="Ndate">작성일</th>
			<th colspan="2" id="DM">기능</th>
		</tr>
		<c:forEach items="${list }" var="i">
			<tr>
				<td>${i.no }</td>
				<td><a href="readBBR?no=${i.no}">${i.title }</a></td>
				<td>${i.id }</td>
				<td>${i.ndate }</td>
				<td><a href="modBBR?no=${i.no}">수정</a></td>
				<td><a href="delBBR?no=${i.no}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>




