<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<head>
	<meta charset="UTF-8" />
	<title>Mypage</title>
	<style>
	.tg{
		border:1px solid black;
		border-collapse: collapse
	}
/* 	.tg .tg-sub{font-weight:bold;border-color:black;text-align:center;vertical-align:top} */
	</style>
</head>
<body>
	<table class="tg" id="mypage">
		<tr>
			<td rowspan="3" colspan="2" background="#ff8000"><img src="${img}/mypage/user.png"/></td>
			<td class="tg-sub">아   이   디</td>
			<td>${user.userId}</td>
		</tr>
			
		<tr>
			<td class="tg-sub">비 밀 번 호</td>
			<td>****</td>
		</tr>
		
		<tr>
			<td class="tg-sub">이         름</td>
			<td>${user.name}</td>
		</tr>
		
		<tr>
			<td class="tg-sub">나         이</td>
			<td>${user.age}</td>
			<td class="tg-sub">주 민 번 호</td>
			<td>${user.ssn}</td>
		</tr>
		
		<tr>
			<td class="tg-sub">팀         명</td>
			<td>${user.teamId}</td>
			<td class="tg-sub">역         할</td>
			<td>${user.roll}</td>
		</tr>
	
	</table>	
	
	<a id='myPageMoveToUpdate'>수정</a>

	<script>
	document.getElementById('myPageMoveToUpdate').addEventListener('click',function(){
		router.move({context : '${context}',
			domain : 'member',
			action : 'move',
			page : 'update_form'});
	});
	</script>
</body>
</html>


<%-- 
<h1>아   이   디 : ${user.userId}</h1>
<h1>비 밀 번 호 : ****</h1>
<h1>이         름 : ${user.name}</h1>
<h1>성         별 : ${user.gender}</h1>
<h1>나         이 : ${user.age}</h1>
<h1>주 민 번 호 : ${user.ssn}</h1>
<h1>팀         명 : ${user.teamId}</h1>
<h1>역         할 : ${user.roll}</h1> --%>


<%-- EL -> <%user.getName();%> --%>
<!-- 바꿀수 있는것 : 비번, 팀명, 역할 -->
