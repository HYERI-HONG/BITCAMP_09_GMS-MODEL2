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
		
		<div id="mypage_content">
		<h3 align="center">마이페이지</h3>
			<table id="mypage">
			<tr>
				<td rowspan="3" colspan="2" background="#ff8000"><img src="${img}/mypage/user.png"/></td>
				<td>아   이   디</td>
				<td>${user.userId}</td>
			</tr>
				
			<tr>
				<td>비 밀 번 호</td>
				<td>****</td>
			</tr>
			
			<tr>
				<td>이         름</td>
				<td>${user.name}</td>
			</tr>
			
			<tr>
				<td>나         이</td>
				<td>${user.age}</td>
				<td>주 민 번 호</td>
				<td>${user.ssn}</td>
			</tr>
			
			<tr>
				<td>팀         명</td>
				<td>${user.teamId}</td>
				<td>역         할</td>
				<td>${user.roll}</td>
			</tr>
		
			</table>	
			<h4 align="center"><a id='myPageMoveToUpdate'>회원 정보 수정  </a>/<a id='myPageMoveToDelete'>  회원 탈퇴</a></h4>
		</div>
	
		<div id="mypage_footer">
			<jsp:include page="../common/footerBox.jsp"/>
		</div>	
	</div>
	
	<script>
	document.getElementById('myPageMoveToUpdate').addEventListener('click',function(){
		router.move({context : '${context}',
			domain : 'member',
			action : 'move',
			page : 'update_form'});
	});
	document.getElementById('myPageMoveToDelete').addEventListener('click',function(){
		router.move({context : '${context}',
			domain : 'member',
			action : 'move',
			page : 'delete_form'});
	});
	</script>
</body>
</html>