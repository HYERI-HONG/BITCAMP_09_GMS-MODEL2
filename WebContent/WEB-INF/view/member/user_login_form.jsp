<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String ctx = application.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>사용자 로그인</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>

<h2 align="center">UserLogin Page</h2>
<form action="<%=ctx%>/member.do" id="form-style">
	ID :<br>
	<input type="text" name="userid"/>
	<br>
	Password :<br>
	<input type="text" name="password"/>
	<br><br>
	<input type="hidden" name="page" value="user_login_result" />
	<input type="hidden" name="action" value="login" />
	<input type="submit" value="전송" />
</form>
</body>
</html>