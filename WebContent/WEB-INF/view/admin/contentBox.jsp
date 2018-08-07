<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action=""></form>
<a href=""></a>


<jsp:include page="../common/head.jsp"/>
<div id="admin_content_box">
	<div id="content_search">
		    <select name="serch" id="searchOption">
		    <option value="none">검색조건</option>
		    <option value="userId">아이디로 검색</option>
		    <option value="name">이름으로 검색</option>
		    <option value="teamId">팀명으로 검색</option>
		    </select>
		<input id ="searchWord" type="text" placeholder="검색어 입력"/>
		<input type="button" id="searchButton" value="검색" />
	</div>
	<table id="memberlist">
		<tr>
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
			"location.href="${context}/admin.do?action=retrieve&page=memberDetail&userid=${member.userid}">${member.name}</a></td> --%>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.roll}</td>
			<td>${member.teamId}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<h4>전체 회원 수 : ${count}</h4>
				<ul class="pageBox">
					<c:forEach begin="${beginPage}" end="${endPage}" step="1" varStatus="i">
						<li>
							<a class="changePage" id="${i.index}">${i.index}</a>
						</li>
					</c:forEach>
					<c:if test="${existNext}">
						<li><a id="nextPgaeList">다음▶</a></li>
					</c:if>
					
				</ul>
				
			</td>
		</tr>
	</table>
</div>

<script>
	admin.main('${context}');
	admin.page({context : '${context}',
		endPage : '${endPage}',
		beginPage : '${beginPage}'});
	
	
</script>