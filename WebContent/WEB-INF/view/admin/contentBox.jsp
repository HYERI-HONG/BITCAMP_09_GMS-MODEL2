<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/head.jsp"/>
<div id="admin_content_box">
	<table id="memberlist">
		<tr id = "memberlistMeta">
			<th>아 이 디</th>
			<th>이     름</th>
			<th>나     이</th>
			<th>성     별</th>
			<th>역     할</th>
			<th>팀     명</th>
		</tr>
		<c:forEach items='${list}' var='member'>
		<tr>
			<td>${member.userId}</td>
			<td><a class="username" id="${member.userId}">${member.name}</a></td>
			<%-- <td><a style="cursor: pointer; 
			"href="${context}/admin.do?action=retrieve&page=memberDetail&userid=${member.userId}">${member.name}</a></td> --%>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.roll}</td>
			<td>${member.teamId}</td>
		</tr>
		</c:forEach>
	</table>
</div>

<script>
document.getElementById('memberlistMeta').className='bgColorisYello';
	var x = document.querySelectorAll('.username');
	for(i in x){
		x[i].style.color = 'blue';
		x[i].style.cursor = 'pointer';
		x[i].addEventListener('click',function(){
			location.href ="${context}/admin.do?action=retrieve&page=memberDetail&userid="+this.getAttribute('id');
		});
		
	}
</script>