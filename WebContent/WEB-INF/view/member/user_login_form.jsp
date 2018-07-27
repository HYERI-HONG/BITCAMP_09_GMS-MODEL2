<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div id = "user-login-layout">
		<h2 align="center">UserLogin Page</h2>
		<form id = "loginForm" name = "loginForm" style = "border:1px solid black">
			ID :<br>
			<input type="text" name="userid"/>
			<br>
			Password :<br>
			<input type="text" name="password"/>
			<br><br>
			<input type="hidden" name="page" value ="mypage"/>
			<input type="hidden" name="action" value="login"/>
			<input id="LoginFormBtn" type="button" value="전송" />
		</form>
	</div>
	<script>
	document.getElementById('LoginFormBtn').addEventListener('click',function(){
		var x = service.nullChecker([
			document.loginForm.userid.value,
			document.loginForm.password.value]);
		if(x.checker){
			var form = document.getElementById('loginForm');
			form.action = "${context}/member.do";
			form.method = "post";
			form.submit();		
		}
		else{
			alert(x.text);
		}
	});
	</script>
	</body>
</html>