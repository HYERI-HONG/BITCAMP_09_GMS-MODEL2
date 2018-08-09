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
	
	
	<div id="delete_content">
		<h3 align="center">회원 탈퇴</h3>
		<form id='deleteForm'>
		<br>
		비밀번호 확인: <br>
		<input id="password" type="password" name="password"/>
		<br><br>
		<input id="deleteConfirmBtn" type="button" value ="탈퇴" />
		</form>
	</div>
	
	<div id="menu_footer">
		<jsp:include page="../common/footerBox.jsp"/>
	</div>
</div>

<script>
	document.getElementById('deleteConfirmBtn').addEventListener('click',function(){
		var form = document.getElementById('deleteForm');
		if(service.nullChecker([form.password.value]).checker){
			form.action = "${context}/member.do";
			form.method = "post";
			
			var node = document.createElement('input');
			node.innerHTML = '<input type="hidden" name="action" value="delete"/>';
			form.appendChild(node); //동적코딩(메소드에의한 처리)
			form.submit();
		}
		else{
			alert("비밀번호를 입력하세요.");
		}
	});
</script>

</body>
</html>