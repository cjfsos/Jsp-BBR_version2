<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<style>
.box1 {
	border-radius: 10px;
	border: 2px solid blue;
	background-color: cadetblue;
	padding: 10px;
	margin: 10px;
	height: 20px;
	width: 400px;
	color: white;
	text-align: center;
}

.box2 {
	padding: 10px;
	margin: 10px;
	width: 400px;
}

input[type=text], input[type=password] {
	width: 100%;
	height: 30px;
	border: 1px solid brown;
	box-sizing: border-box;
	padding: 5px;
}

input[type=submit], input[type=reset] {
	background-color: burlywood;
	width: 45%;
	border: none;
	padding: 10px;
	margin: 5px;
	color: darkblue;
}

#txt_email {
	width: 60%;
	height: 30px;
}

p {
	font-size: smaller;
	font-weight: bold;
}

label {
	color: blue;
}
</style>

<script>
        function formchk() {
            let id = form1.txt_id.value;
            let returnID = chkString("id", id);
            if (returnID < 4) {
                form1.txt_id.focus();
                return;
            }
            let pwd1 = form1.txt_pwd.value;
            let pwd2 = form1.txt_pwdc.value;
            if (pwd1 != pwd2) {
                alert("비빌번호와 비밀번호 확인이 서로 다릅니다.");
                form1.txt_pwd.focus();
                return;
            }
            let returnpwd = chkString("비밀번호", pwd1);
            if (returnID < 4) {
                form1.txt_id.focus();
                return;
            } else {
                form1.pwd_chk.value = 2;
            }
            if (form1.pwd_chk.value == 2) {
                alert("비밀번호 확인함 ");
            }

            let adultChk = form1.who_g.value;
            let usermsg = form1.text_intro.value;

            alert(adultChk);
            alert(usermsg);

        }
        function chkString(type, nowString) {
            let resultString = stringchk(nowString);
            if (resultString == 1) {
                alert(type + " 4글자 이상 입니다.");
            } else if (resultString == 2) {
                alert("특수문자는 하나이상 포함되어야 합니다.");
            } else if (resultString == 3) {
                alert("알파벳 소문자만 사용가능합니다.");
            }
            return resultString;
        }
        function stringchk(nowString) {

            if (nowString.length < 4) {
                return 1;    // 글자수 틀림
            }

            let signCnt = 0;
            let signString = "!@#$%^&*";
            for (i = 0; i < nowString.length; i++) {
                if (signString.indexOf(nowString.charAt(i)) != -1) {
                    signCnt++;
                    break;
                }
            }
            if (signCnt == 0) {
                return 2;  // 특수문자 포함 안됨.
            }

            for (i = 0; i < nowString.length; i++) {
                let asciiNum = nowString.charCodeAt(i);
                if (asciiNum < 97 || asciiNum > 121) {  //97-121까지 소문자
                    if (asciiNum < 48 || asciiNum > 57) {  // 49-56까지 숫자 숫자가 아닐 경우
                        let chksign = String.fromCharCode(asciiNum);
                        if (signString.indexOf(chksign) == -1) {
                            return 3;   // 소문자 아닌 것이 있음.
                        }
                    }
                }
            }
        }
    </script>
<body>
	<div class="box1">
		<!--  id는 유니크하다, class는 여러개 사용할 수 있다.-->
		회원가입
	</div>
	<form name="form" method="post" action="singup">
		<div class="box2">
			<p>
				<label for="txt_id">아이디</label>
				<!-- 라벨이 연결된(for) 라벨만 클릭해서 연결된 창이 활성화-->
				<input type="text" name="txt_id" id="txt_id" placeholder="아이디를 입력">
			</p>

			<p>
				<label for="txt_pwd">비밀번호</label> <input type="password"
					name="txt_pwd" id="txt_pwd" placeholder="비밀번호입력">
			</p>
			<p>
				<label for="txt_pwdc">비밀번호확인</label> <input type="password"
					name="txt_pwdc" id="txt_pwdc" placeholder="비밀번호입력"> <input
					type="hidden" name="pwd_chk" value="1"></input>
			</p>

			<p>
				<label for="txt_name">이름</label> <input type="text" name="txt_name"
					id="txt_name" placeholder="이름 입력">
			</p>

			<p>
				<label for="txt_email">이메일 </label> <input type="text"
					name="txt_email" id="txt_email" placeholder="이메일입력"> <input
					type="checkbox" name="ck_recv"> <label for="ck_recv">수신희망</label>
			</p>

			<p>
				<input type="submit" value="신청"> <input type="reset"
					value="다시쓰기">
			</p>
		</div>
	</form>

</body>
</html>