<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div id="wrapper">
	
		<div id="menu_header">
			<jsp:include page="../common/titleBox.jsp" />
			<jsp:include page="../common/menuBox.jsp" />
		</div>
		
		<div id="update_content">
			<h2 align="center">회원 정보 변경</h2>
			<form id ="updateForm" name="updateForm">
			<h4>아이디 : ${user.userId}</h4>
			 <br>
			기존 비밀번호 : <br>
			<input type="text" name="before_pass"/>
			 <br>
			변경할 비밀번호 : <br>
			<input type="text" name="after_pass" />
			
			<br>
			소속팀 : <br>
			<select name="teamId" id="teamId">
			<option value="GG">지은이랑지은집팀</option>
			<option value="LP">레츠플레이팀</option>
			<option value="TurtleKing">거북왕팀</option>
			<option value="CodingStar">언프리티코딩스타팀</option>
			</select>
			
			<br>
			프로젝트역할 : <br>
			<select name="roll" id="roll">
			<option value="프론트 담당">프론트개발</option>
			<option value="팀장">팀장</option>
			<option value="백단 담당">백단개발</option>
			<option value="안드로이드 담당">안드로이드개발</option>
			<option value="무임승차">무임승차</option>
			</select>
			<br><br>
			<input type="button" id=updateConfirmBtn value ="변경" />
			</form>
		</div>
		
		<div id="menu_footer">
			<jsp:include page="../common/footerBox.jsp"/>
		</div>	
	</div>
	
	<script>
	var roll = document.getElementById('roll');
	var teamId = document.getElementById('teamId');
	
	for(var i=0; i<roll.options.length; i++){
		if(roll.options[i].value==='${user.roll}'){
			roll.options[i].setAttribute("selected","selected");
		}
	}
	for(var j=0; j<teamId.options.length; j++){
		if(teamId.options[j].value==='${user.teamId}'){
			teamId.options[j].setAttribute("selected","selected");
		}
	}
	
	document.getElementById('updateConfirmBtn').addEventListener('click',function(){
		
		var form = document.getElementById('updateForm');
		form.action = "${context}/member.do";
		form.method = "post";
		
		var node = document.createElement('input');
		node.innerHTML='<input type="hidden" name="action" value=update />';
		form.appendChild(node);
		
		if(service.nullChecker([
			document.updateForm.before_pass.value]).checker){
			if(service.nullChecker([
				document.updateForm.after_pass.value]).checker){
				form.submit();
			}
			else{
				form.after_pass.value = "${user.password}"
			}	
		}else{
			alert("비밀번호를 입력하세요.");
		} 
		
	});
	</script>
</body>
</html>




