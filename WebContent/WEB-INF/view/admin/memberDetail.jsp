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
		<h3 align="center">회원 상세 정보</h3>
			<table id="mypage">
			<tr>
				<td rowspan="3" colspan="2" background="#ff8000"><img src="${img}/mypage/user.png"/></td>
				<td>아   이   디</td>
				<td>${retrive.userId}</td>
			</tr>
				
			<tr>
				<td>비 밀 번 호</td>
				<td>****</td>
			</tr>
			
			<tr>
				<td>이         름</td>
				<td>${retrive.name}</td>
			</tr>
			
			<tr>
				<td>나         이</td>
				<td>${retrive.age}</td>
				<td>주 민 번 호</td>
				<td>${retrive.ssn}</td>
			</tr>
			
			<tr>
				<td>팀         명</td>
				<td>${retrive.teamId}</td>
				<td>역         할</td>
				<td>${retrive.roll}</td>
			</tr>
		
			</table>	
		</div>
	
		<div id="mypage_footer">
			<jsp:include page="../common/footerBox.jsp"/>
		</div>	
	</div>
	
	<script>
	</script>
</body>
</html>