<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8" />
	<title>MAIN</title>
	<link rel="stylesheet" href="${css}/style.css" />
	<script>
	var common = new (function(){
		this.move = function(domain,action,page){
			location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
		}
	});
	var member = new (function(){
		var userid, ssn, password;
		this.setUserid = function(x){
			this.userid = x;
		}
		this.setSsn = function(x){
			this.ssn = x;
		}
		this.setPassword = function(x){
			this.password = x;
		}
		this.getUserid = function(){
			return this.userid;
		}
		this.getSsn = function(){
			return this.ssn;
		}
		this.getPassword = function(){
			return this.password;
		}
		this.loginValidation = function(){
			var check =true;
			if(this.password===''&&this.userid===''){
				alert("ID와 비밀번호 입력하세요");
				check = false
			}else if(this.userid===''){
				alert("ID를 입력하세요");
				check = false;
			}else if(this.password===''){
				alert("비밀번호를 입력하세요");
				check = false;
			}
			return check;
		};
	});
	</script>
</head>