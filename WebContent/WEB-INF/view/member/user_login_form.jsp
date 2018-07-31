<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>

<div id="wrapper">
	<div id="menu_header">
		<jsp:include page="../common/titleBox.jsp" />
		<jsp:include page="../common/menuBox.jsp" />
	</div>
	
	<div id = "login_content">
		<h3 align="center">로그인</h3>
		<form id = "loginForm" name = "loginForm">
			ID :<br>
			<input type="text" name="userid"/>
			<br>
			Password :<br>
			<input type="text" name="password"/>
			<br><br>
			<input id="LoginFormBtn" type="button" value="전송" />
		</form>
	</div>
	<div id="menu_footer">
		<jsp:include page="../common/footerBox.jsp"/>
	</div>
</div>
	
	<script>
	document.getElementById('LoginFormBtn').addEventListener('click',function(){
		var x = service.nullChecker([
			document.loginForm.userid.value,
			document.loginForm.password.value]);
		var form = document.getElementById('loginForm');
		
		var node = document.createElement('input');
		node.innerHTML='<input type="hidden" name="action" value="login"/>';
		form.appendChild(node);
		
		if(x.checker){
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