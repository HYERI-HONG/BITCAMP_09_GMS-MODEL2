<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="contentBox">
		<div id="menu_header">
			<jsp:include page="../common/titleBox.jsp" />
			<jsp:include page="../common/menuBox.jsp" />
		</div>
		
		<div id="menu_content">
		<h2 align="center">회원 가입</h2>
		<form id ="joinForm" name="joinForm">
			아이디 : <br>
			<input type="text" name="userid" />
			<br>
			비밀번호 : <br>
			<input type="text" name="password" />
			<br>
			이름 : <br>
			<input type="text" name="name" />
			<br>
			주민 번호 : <br>
			<input type="text" name ="ssn" />
			<br>
			소속팀 : <br>
		    <input type="radio" name="teamid" value="LP" checked="checked" /> 레츠플레이팀
		    <input type="radio" name="teamid" value="GG" /> 지은이랑지은집팀
		    <input type="radio" name="teamid" value="TurtleKing" /> 거북왕팀
		    <input type="radio" name="teamid" value="CodingStar" /> 언프리티코딩스타팀
		    <br>
		         수강과목 :<br>
			<input type="checkbox" name="subject" value ="JAVA" checked="checked"/>JAVA
			<input type="checkbox" name="subject" value ="C" />C
			<input type="checkbox" name="subject" value ="JSP" />JSP
			<input type="checkbox" name="subject" value ="PHP" />PHP
			<input type="checkbox" name="subject" value ="Node.js" />Node.js
			<input type="checkbox" name="subject" value ="Linux"/>Linux
			<input type="checkbox" name="subject" value ="HTML"/>HTML
			<input type="checkbox" name="subject" value ="Spring"/>Spring
    		<br>
  			프로젝트역할 : <br>
		    <select name="roll" id="roll">
		    <option value="팀장">팀장</option>
		    <option value="프론트 담당">프론트개발</option>
		    <option value="백단 담당">백단개발</option>
		    <option value="안드로이드 담당">안드로이드개발</option>
		    <option value="무임승차">무임승차</option>
		    </select>
			<br><br>
			<input id="JoinFormBtn" type="button"  value = "등록" />	
		</form>
		</div>
		
		<div id="menu_footer">
			<jsp:include page="../common/footerBox.jsp"/>
		</div>	
</div>

