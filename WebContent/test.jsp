<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String sid = session.getId();
out.print(sid);
String id = (String)session.getAttribute("ID");
out.print(id);
String pw = (String)session.getAttribute("PW");
out.print(pw);
%>
</body>
</html>