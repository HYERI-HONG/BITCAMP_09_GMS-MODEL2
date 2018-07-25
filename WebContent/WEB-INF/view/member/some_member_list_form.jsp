<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀 이름으로 회원 검색</title>
</head>
<body>
<form action="${context}/member.do" onsubmit="return sendForm()" id="form-style">
	검색할 팀 이름 입력 :<br>
	<input type="text" name="teamname"/>
	<br><br>
	<input type="submit" value="검색" />
	<input type="hidden" name="page" value="some_member_list_result" />
	<input type="hidden" name="action" value="search"/>
</form>
</body>
</html>