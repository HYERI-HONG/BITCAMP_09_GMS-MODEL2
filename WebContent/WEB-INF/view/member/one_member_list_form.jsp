<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ID로 회원 검색</title>
</head>
<body>
<form action="<%=ctx%>/member.do" id="form-style">
	검색할 ID 입력 :<br>
	<input type="text" name="userid"/>
	<br><br>
	<input type="hidden" name="page" value="one_member_list_result" />
	<input type="hidden" name="action" value="retrieve" />
	<input type="submit" value="검색" />
</form>
</body>
</html>