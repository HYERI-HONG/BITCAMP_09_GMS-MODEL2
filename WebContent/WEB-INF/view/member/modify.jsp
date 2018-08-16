<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/head.jsp"/>

	<div id="contentBox">
		<div id="update_content">
			<h2 align="center">회원 정보 변경</h2>
			<form id ="updateForm" name="updateForm">
			<h4>아이디 : ${user.userId}</h4>
			 <br>
			기존 비밀번호 : <br>
			<input type="text" name="before_pass"/>
			 <br>
			변경할 비밀번호 : <br>
			<input type="text" name="after_pass" placeholder="${user.password}"/>
			
			<br>
			소속팀 : <br>
			<select name="teamId" id="teamId" class="${user.teamId}">
			<option class="team-opt" value="GG">지은이랑지은집팀</option>
			<option class="team-opt" value="LP">레츠플레이팀</option>
			<option class="team-opt" value="TurtleKing">거북왕팀</option>
			<option class="team-opt" value="CodingStar">언프리티코딩스타팀</option>
			</select>
			
			<br>
			프로젝트역할 : <br>
			<select name="roll" id="roll" class="${user.roll}">
			<option class="roll-opt" value="프론트 담당">프론트개발</option>
			<option class="roll-opt" value="팀장">팀장</option>
			<option class="roll-opt" value="백단 담당">백단개발</option>
			<option class="roll-opt" value="안드로이드 담당">안드로이드개발</option>
			<option class="roll-opt" value="무임승차">무임승차</option>
			</select>
			<br><br>
			<input type="button" id=updateConfirmBtn value ="변경" />
			</form>
		</div>
	</div>
	
	<form method="POST" enctype="multipart/form-data" action="${context}/member.do?action=fileupload&page=retrieve">
	  파일 업로드: <input type="file" name="upfile"><br/>
 	<input type="submit" value="파일 업로드">
	</form>





