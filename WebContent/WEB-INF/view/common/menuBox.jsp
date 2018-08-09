<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="menu-box">
		<ul	id="menu">
			<li><a id="goHome">HOME</a></li>
			<li><a href="">ABOUT</a></li>
			<li><a id="moveToAdminMain">ADMIN</a></li>
		</ul>
</div> 
<script>

document.getElementById("goHome").addEventListener('click',function(){ //콜백함수
	router.move({context : '${context}',
		domain : 'common'}
		);
});
</script>


