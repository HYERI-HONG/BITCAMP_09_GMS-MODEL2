<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a id="oneMemberList">회원검색</a></li>
		<li><a id="memberList">회원목록</a></li>
		<li><a id="goHome">홈으로가기</a></li>
	</ul>
</div>

<script>
document.getElementById("oneMemberList").addEventListener('click',function(){ //콜백함수
	router.move({context : '${context}',
		domain : 'member',
		action : 'move',
		page : 'one_member_list_form'});
});
document.getElementById("memberList").addEventListener('click',function(){ //콜백함수
	router.move({context : '${context}',
		domain : 'member',
		action : 'list',
		page : 'memberlist'});
});
document.getElementById("goHome").addEventListener('click',function(){ //콜백함수
	router.move({context : '${context}',
		domain : 'common'}
		);
});


</script>
