<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="menu-box">
	<ul	id="menu">
		<c:if test="${user ne null}">
			<li><a id="goMypage">MYPAGE</a></li>
		</c:if>
			<li><a id="goHome">HOME</a></li>
			<li><a id="goAdmin">ADMIN</a></li>
	</ul>
</div> 




