<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>read_BBR</title>
<style>
    body
    {
        width: 800px;
        margin: 0 auto;
    }
   
    #ucontents
    {
        border: solid;
    }
</style>
</head>
<body>
<p id="utitle">
        제목 :&nbsp ${contents.title }       
    </p>

    <p>
        내용
        <div id="ucontents">
            ${contents.contents }
        </div>
    </p>

    <p>
        작성자 : &nbsp ${contents.id }     
    </p>
</body>
</html>