<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../common/head.jsp"/>
<div id="contentBox">
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
</div>
