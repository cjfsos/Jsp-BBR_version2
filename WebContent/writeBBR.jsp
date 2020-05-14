<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>writeBBR</title>
<style>
body {
	width: 560px;
	margin: 0 0 0 20px;
}

div {
	margin: 10px 0;
}

#title {
	width: 100%;
}

textarea {
	width: 100%;
	height: 400px;
	resize: none;
}
</style>
</head>
<body>
	<%
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		Date dt = new Date();
		String nID = (String)session.getAttribute("ID");
		out.print(" 작성자 : "+nID);
	%>
	<form action="writeBBR" method="post">
		<p>
			제목 : <input type="text" id="title" name="title"> <input
				type="hidden" name="writer" value=<%=nID %>></input>
		</p>
		<p>
			내용 <br>
			<textarea name="contents" id="ct"></textarea>			
		</p>
		<p>
			<input type="submit" value="작성완료"> <input type="reset"
				value="다시쓰기">
		</p>
	</form>
</body>
</html>