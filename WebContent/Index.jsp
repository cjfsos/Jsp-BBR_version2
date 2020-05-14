<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<script type="text/javascript">

</script>
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
	margin: 0 0 0 70px;
}

#lb {
	margin: 15px;
	color: blue;
}

input[type="text"] {
	width: 120px;
}

a {
	text-decoration: none;
	a: hover{text-decoration: red
}

}
</style>
<body>
	<div id="log">
		<form action="login" method="post">
			ID: <input type="text" name="ID"> &nbsp; &nbsp; PW: <input
				type="text" name="PW"> <input type="submit" name="signIN"
				value="로그인">
		<input type="button" name="signUP" value="회원가입"
			onclick="location.href='./singup.jsp'"> <input type="button"
			name="newWT" value="글작성" onclick="alert('로그인 후 사용해주십시오')"><label id="lb">guest로 접속중</label>
		</form>
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
				<td><a href="#" onclick="alert('로그인 후 사용해주십시오')">${i.title }</a></td>
				<td>${i.id }</td>
				<td>${i.ndate }</td>
				<td><a href="#" onclick="alert('로그인 후 사용해주십시오')">수정</a></td>
				<td><a href="#" onclick="alert('로그인 후 사용해주십시오')">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>




