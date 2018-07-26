<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<h2 align="center">Join Page</h2>
		<form id ="joinForm" style = "border:1px solid black">
			ID : <br>
			<input type="text" name="userid" />
			<br>
			Password : <br>
			<input type="text" name="password" />
			<br>
			Name : <br>
			<input type="text" name="name" />
			<br>
			SSN : <br>
			<input type="text" name ="ssn" />
			<br><br>
			<input type="hidden" name="page" />
			<input type="hidden" name="action" />
			<input id="JoinFormBtn" type="button"  value = "등록" />	
		</form>
	</div>
	<script>
	document.getElementById('JoinFormBtn').addEventListener('click',function(){
		var member = new Member();
		var form = document.getElementById('joinForm');
		form.action = "${context}/member.do";
		form.method = "post";
		
		member.setUserid(form.userid.value);
		member.setPassword(form.password.value);
		member.setName(form.name.value);
		member.setSsn(form.ssn.value);
		
		if(service.joinValidation(member)){
			form.page.value="user_login_form";
			form.action.value="join";
			form.submit();	
		}
		
	});
	</script>	
</body>
</html>
