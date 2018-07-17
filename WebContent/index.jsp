<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//설정값이 있는 경로를 가져오는것
	String ctx = application.getContextPath();
%>


<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Test</title>
	<link rel="stylesheet" href="css/style.css" />
</head>
<body id="color-background">  
	<h3>현재 회원수 : 22명</h3>
	
	<table class="width-full  height-full margin-auto">
		<tr class="color-top">
			<th  colspan ="2">홈 화면</th>
		</tr>
		<tr class="color-bottom">
			<td ><img src="img/home/user1.jpg" id="img-size" /></td>
			<td class="width-part" >
			<ul>
				<li><a href="<%=ctx%>/member.do?action=move&page=join_form">회원가입</a></li>
				<li><a href="<%=ctx%>/member.do?action=move&page=user_login_form">사용자 로그인</a></li>
				<li><a href="">관리자 로그인</a></li>
				
				<li><a href="<%=ctx%>/member.do?action=move&page=memberlist">전체 회원 목록</a></li>
				<li><a href="<%=ctx%>/member.do?action=move&page=some_member_list_form">팀이름으로 회원검색</a></li>
				<li><a href="<%=ctx%>/member.do?action=move&page=one_member_list_form">ID로 회원검색</a></li>
			</ul>
			</td>
		</tr>
		<tr class="color-bottom">
			<td colspan ="2">ADDRESS</td>
		</tr>
	</table>
</body>
</html>
