<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div id = "user-login-layout">
		<h2 align="center">UserLogin Page</h2>
		<form id = "loginForm" style = "border:1px solid black">
			ID :<br>
			<input type="text" name="userid"/>
			<br>
			Password :<br>
			<input type="text" name="password"/>
			<br><br>
			<input type="hidden" name="page" />
			<input type="hidden" name="action"/>
			<input id="LoginFormBtn" type="button" value="전송" />
		</form>
	</div>
	<script>
	document.getElementById('LoginFormBtn').addEventListener('click',function(){
		var member = new Member();
		var form = document.getElementById('loginForm');
		form.action = "${context}/member.do";
		form.method = "post";
		
		member.setUserid(form.userid.value);
		member.setPassword(form.password.value);
		
		if(service.loginValidation(member)){
			form.page.value="mypage";
			form.action.value="login";
			form.submit();		
		}
	});
	</script>
	</body>
</html>