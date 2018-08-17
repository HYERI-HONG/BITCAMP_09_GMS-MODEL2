<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="titleBox.jsp"/>
		</div>
		
		<div id="content">
			<c:choose>
	            <c:when test="${pagename eq 'search'}">
	                <jsp:include page="../member/search.jsp"/>
	            </c:when>
	        </c:choose>
		</div>
		<div id="footer">
			<jsp:include page="../common/footerBox.jsp"/>
		</div>
	</div>
	
	<script>
		admin.main('${context}')
	</script>
</body>
</html>
