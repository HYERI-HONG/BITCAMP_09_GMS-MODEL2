/**
 * 
 */
	var router=(()=>{
		return {move : x=>{
			location.href = x[0]+"/"+x[1]+".do?action="+x[2]+"&page="+x[3]
		}};
	})();
	
	var service = (()=>{
		return{
			loginValidation : x=>{
				
				if(x.getPassword()===''&&x.getUserid()===''){
					alert("ID와 비밀번호 입력하세요");
					return false;
				}else if(x.getUserid()===''){
					alert("ID를 입력하세요");
					return false;
				}else if(x.getPassword()===''){
					alert("비밀번호를 입력하세요");
					return false;
				}
				return true;
			},
			joinValidation : x=>{
				return true;
			}
		};
	})();
	
	function Member(){
		var userid, ssn, password,name;
		this.setUserid = function(x){
			this.userid = x;
		}
		this.setName = function(x){
			this.name = x;
		}
		this.setSsn = function(x){
			this.ssn = x;
		}
		this.setPassword = function(x){
			this.password = x;
		}
		this.getName = function(){
			return this.name;
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
	};
	
	
	
	
	
	
	
	
	