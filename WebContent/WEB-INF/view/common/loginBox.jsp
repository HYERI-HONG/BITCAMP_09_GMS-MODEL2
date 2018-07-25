<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
		<a id="moveLoginForm">LOGIN</a>
		&nbsp;&nbsp;&nbsp; <!-- 공백 -->
		<a onclick="new Common().move('member','move','join_form')">JOIN</a>
</div>	
<script>
	/* var common = new Common(); */
	document.getElementById("moveLoginForm").addEventListener('click',function(){ //콜백함수
	common.move('member','move','user_login_form');
	});
</script>
