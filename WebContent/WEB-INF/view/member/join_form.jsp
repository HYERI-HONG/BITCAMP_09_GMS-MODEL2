<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<h2 align="center">Join Page</h2>
		<form id ="joinForm" name="joinForm" style = "border:1px solid black">
			아이디 : <br>
			<input type="text" name="userid" />
			<br>
			비밀번호 : <br>
			<input type="text" name="password" />
			<br>
			이름 : <br>
			<input type="text" name="name" />
			<br>
			주민 번호 : <br>
			<input type="text" name ="ssn" />
			<br>
			<input type="hidden" name="page" value="user_login_form"/>
			<input type="hidden" name="action" value="join"/>
			<input type="hidden" name="age"/>
			<input type="hidden" name="gerder"/>
			<br>
			소속팀 : <br>
		    <input type="radio" name="teamid" value="LP" checked="checked" /> 레츠플레이팀
		    <input type="radio" name="teamid" value="GG" /> 지은이랑지은집팀
		    <input type="radio" name="teamid" value="TurtleKing" /> 거북왕팀
		    <input type="radio" name="teamid" value="CodingStar" /> 언프리티코딩스타팀
		    <br>
		         수강과목 :<br>
			<input type="checkbox" name="subject" value ="JAVA" checked="checked"/>JAVA
			<input type="checkbox" name="subject" value ="C" />C
			<input type="checkbox" name="subject" value ="JSP" />JSP
			<input type="checkbox" name="subject" value ="PHP" />PHP
			<input type="checkbox" name="subject" value ="Node.js" />Node.js
			<input type="checkbox" name="subject" value ="Linux"/>Linux
			<input type="checkbox" name="subject" value ="HTML"/>HTML
			<input type="checkbox" name="subject" value ="Spring"/>Spring
    		<br>
  			프로젝트역할 : <br>
		    <select name="roll" id="roll">
		    <option value="팀장">팀장</option>
		    <option value="프론트 담당">프론트개발</option>
		    <option value="백단 담당">백단개발</option>
		    <option value="안드로이드 담당">안드로이드개발</option>
		    <option value="무임승차">무임승차</option>
		    </select>
			<br><br>
			<input id="JoinFormBtn" type="button"  value = "등록" />	
		</form>
	</div>
	
	
	<script>
	document.getElementById('JoinFormBtn').addEventListener('click',function(){
		var x = service.nullChecker([
			document.joinForm.userid.value,
			document.joinForm.password.value,
			document.joinForm.name.value,
			document.joinForm.ssn.value]);
		
		
		if(x.checker){
			var form = document.getElementById('joinForm');
			form.action = "${context}/member.do";
			form.method = "post";
			member.join(form.ssn.value);
			form.age.value = member.getAge();
			form.gerder.value = member.getGender();
			form.submit();	
		}
		else{
			alert(x.text);
		}
		
	});
	</script>	
</body>
</html>
