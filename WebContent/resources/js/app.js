/**
 * 
 */
	var router=(()=>{
		return {move : x=>{
			location.href = x[0]+"/"+x[1]+".do?action="+x[2]+"&page="+x[3]
		}};
	})();
	
	var service =(()=>{
		return{
			nullChecker:x=>{
				var i=0;
				var j = {
					checker : true,
					text : '필수 입력값이 없습니다.'
				};

				for(i in x){
					if(x[i]===''){
						j.checker = false;
						break;
					}
				}	
				return j;
			}
		}
	})();
	
	var member =(()=>{
		var _userid, _ssn, _password, _name, _age, _gender;
		
		var setUserid = (userid)=>{this._userid=userid;}
		var setName = (name)=>{this._name=name;}
		var setSsn = (ssn)=>{this._ssn=ssn;}
		var setPassword = (password)=>{this._password=password;}
		var setAge = x=>{	
			
			var date= new Date();
			var toMonth =date.getMonth()+1;
			var toDay = date.getDate();
			var toYear= date.getFullYear();
			
			var birYear =x.substring(0,2);
			var birMonth = x.substring(2,4);
			var birDay = x.substring(4,6);
			
			if(parseInt(birYear)>18&&parseInt(birYear)<=99) {
				birYear = "19"+birYear;
			}else {
				birYear = "20"+birYear;
			}

			var age =parseInt(toYear)-parseInt(birYear);
			
			if((parseInt(birMonth)*100+parseInt(birDay))>(parseInt(toMonth)*100+parseInt(toDay))){
				age--;
			}
			this._age= age;
		}
		var setGender = x=>{
			
			var genderNum = x.charAt(7);
			var gender = '';
			
			if(genderNum==='1'||genderNum==='3'){
				gender="남자";
			}else if(genderNum==='2'||genderNum==='4'){
				gender="여자";
			}else if(genderNum==='5'||genderNum==='6'){
				gender="외국인";
			}
			this._gender=gender;
		}
		
		var getUserid = ()=>{return this._userid;}
		var getName = ()=>{return this._name;}
		var getSsn = ()=>{return this._ssn;}
		var getPassword = ()=>{return this._password;}
		var getAge = ()=>{return this._age;}
		var getGender = ()=>{return this._gender;}
		
		return{
			setUserid : setUserid,
			setName : setName,
			setSsn : setSsn,
			setPassword : setPassword,
			setAge : setAge,
			setGender : setGender,
			
			getName : getName,
			getUserid : getUserid, 
			getSsn : getSsn,
			getPassword : getPassword,
			getAge : getAge,
			getGender : getGender,
			join : x=>{
				member.setAge(x);
				member.setGender(x);
			}
			
		}
	})();
		
	
	
	
	
	
	
	
	
	
	