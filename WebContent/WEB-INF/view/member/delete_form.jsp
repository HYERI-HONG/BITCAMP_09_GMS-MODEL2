<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원 탈퇴</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<h3>회원 탈퇴</h3>
	<form action="${context}/member.do" onsubmit="return sendForm()" id="form-style">
	아이디 확인 : <br>
	<input type="text" name="userid"/>
	<br>
	비밀번호 확인: <br>
	<input type="text" name="password"/>
	<br><br>
	<input type="hidden" name="action" value="delete" />
	<input type="hidden" name="page" value="delete_result" />
	<input type="submit" value ="탈퇴" />
	</form>
	
</body>
</html>