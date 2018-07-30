<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
		<a id="moveLoginForm">LOGIN</a>
		&nbsp;&nbsp;&nbsp; <!-- 공백 -->
		<a id="moveJoinForm">JOIN</a>
</div>	
<script>
	document.getElementById("moveLoginForm").addEventListener('click',function(){ //콜백함수
		router.move({context : '${context}',
			domain : 'member',
			action : 'move',
			page : 'user_login_form'});
	});

	document.getElementById("moveJoinForm").addEventListener('click',function(){ 
		router.move({context : '${context}',
					domain : 'member',
					action : 'move',
					page : 'join_form'});
	});
</script>
