/**
 * 
 */
	function Common(){
		this.move = function(path,domain,action,page){
			location.href = path+"/"+domain+".do?action="+action+"&page="+page;
		}
	};
	function Member(){
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
	};