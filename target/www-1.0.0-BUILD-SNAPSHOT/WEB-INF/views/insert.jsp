<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>add board</title>
</head>
<body>
	<form action="doAddContent" method="post">
		제목 : <input type="text" name="u_name"/>
		<br>
		비밀번호 : <input type="password" name="u_pw"/>(숫자만 입력)
		<br>
		내용
		<br>
		<textarea name="u_contents" rows="10" cols="50"></textarea>
		<br>
		<input type="submit"/>
		<input type="button" value="cancel" onclick="cancel()"/>
	</form>
	<script>
		function cancel(){
			location.href="list";
		}
	</script>
</body>
</html>