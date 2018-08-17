<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="login-box">
	<c:choose>
	<c:when test="${user eq null}">
		<a id="moveLogin">LOGIN</a>
		&nbsp;&nbsp;&nbsp;
		<a id="moveJoin">JOIN</a>
	</c:when>
		<c:otherwise>
		<a id="moveLogout">LOGOUT</a>
		</c:otherwise>
	</c:choose>		
</div>	
