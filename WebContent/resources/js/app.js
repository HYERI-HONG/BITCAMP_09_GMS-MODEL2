
	var router=(()=>{
		return {move : x=>{
			location.href = x.context+"/"+x.domain+".do?action="+x.action+"&page="+x.page
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
			},
			addClass : (dom,cName)=>{
				var arr = cName.split(" ");
				if(arr.indexOf(cName)== -1){
					dom.className += " "+cName;
				}
			}
		}
	})();
	
	var common = (()=>{
		return {
			main : x=>{
				document.getElementById('goAdmin').addEventListener('click',function(){
					var isAdmin = confirm("관리자 입니까?");
					if(isAdmin){
						var password = prompt("관리자 비밀번호를 입력하세요.");
						if(password== 1){
							router.move({
								context : x,
								domain : 'admin',
								action:'search',
								page : 'main',
							});
						}else{
							alert('관리자 외에 접근이 불가합니다.');
						}
					}
				});
				document.getElementById("goHome").addEventListener('click',function(){ //콜백함수
					router.move({context : x,
						domain : 'common'}
						);
				});	
				if(document.getElementById("moveLogin")!=null){
					document.getElementById("moveLogin").addEventListener('click',function(){ //콜백함수
						router.move({context : x,
							domain : 'member',
							action : 'move',
							page : 'login'});
					});
				}
				if(document.getElementById("moveJoin")!=null){
					document.getElementById("moveJoin").addEventListener('click',function(){ 
						router.move({context : x,
									domain : 'member',
									action : 'move',
									page : 'add'});
					});
				}
				if(document.getElementById("goMypage")!=null){
					document.getElementById("goMypage").addEventListener('click',function(){ 
						router.move({context : x,
									domain : 'member',
									action : 'retrieve',
									page : 'retrieve'});
					});
				}
				
			}					
		};
	})();
	var admin = (()=>{
		return {
			check : x=>{
				router.move({
					context : x,
					domain : 'admin',
					action:'search',
					page : 'main',
				});
			},
			search : x=>{
				service.addClass(
						document.getElementById('content_search'),
						'search_content '
						);
				service.addClass(
						document.getElementById('memberlist'),
						'memberlist '
						);
				service.addClass(
						document.getElementById('searchButton'),
						'search_button '
						);
					
				//아이디를 입력하면 retrieve로, 팀아이디를 입력하면 search로
				document.getElementById('searchButton').addEventListener('click',function(){
					location.href = (document.getElementById('searchOption').value==='userId')? 
							x+"/admin.do?action=retrieve&page=main&searchid="
									+document.getElementById('searchWord').value
							: 
							x+"/admin.do?action=search&page=main&searchWord="+document.getElementById('searchWord').value
									+"&searchOption="+document.getElementById('searchOption').value;
				});
				//이름을 누르면 retrieve로 이동
				for(var i of document.querySelectorAll('.username')){
					service.addClass(
							i,'cursor fontColorBlue'
					);
					i.addEventListener('click',function(){
						location.href =x+"/member.do?action=retrieve&page=main&clickid="+this.getAttribute('id');
					});
					
				}
				
				//페이지네이션
				for(var j of document.querySelectorAll('.changePage')){
					service.addClass(
							j,'cursor fontColorBlue'
					);
					j.addEventListener('click',function(){
						location.href =x+"/admin.do?action=search&page=main&pageNum="+this.getAttribute('id');
					});
				}
				
			},
			main : x=>{
				document.getElementById("goHome").addEventListener('click',function(){ //콜백함수
					router.move({context : x,
						domain : 'common'}
						);
				});		
			}
		};	
	})();
	
	var member =(()=>{
		var _userid, _ssn, _password, _name, _age, _gender;
		
		var setUserid = (userid)=>{this._userid=userid;}
		var setName = (name)=>{this._name=name;}
		var setSsn = (ssn)=>{this._ssn=ssn;}
		var setPassword = (password)=>{this._password=password;}
		var setAge = (x)=>{	
			
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
		var setGender = (x)=>{
			
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
				
			},
			main : x=>{
				//login
				if(document.getElementById('LoginFormBtn')!=null){
					document.getElementById('LoginFormBtn').addEventListener('click',function(){
						var a = service.nullChecker([
							document.loginForm.userid.value,
							document.loginForm.password.value]);
						var form = document.getElementById('loginForm');
						
						var node = document.createElement('input');
						node.innerHTML='<input type="hidden" name="action" value="login"/>';
						form.appendChild(node);
						
						if(a.checker){
							form.action = x+"/member.do";
							form.method = "post";
							form.submit();		
						}
						else{
							alert(a.text);
						}
					});
				}
				//logout
				if(document.getElementById('moveLogout')!=null){
					document.getElementById('moveLogout').addEventListener('click',function(){
						router.move({context : x,
							domain : 'member',
							action : 'logout',
							page : 'main'});
					});
				}
				
				//join
				if(document.getElementById('JoinFormBtn')!=null){
					document.getElementById('JoinFormBtn').addEventListener('click',function(){
						var a = service.nullChecker([
							document.joinForm.userid.value,
							document.joinForm.password.value,
							document.joinForm.name.value,
							document.joinForm.ssn.value]);
						
						var form = document.getElementById('joinForm');
						
						if(a.checker){
							member.join(form.ssn.value);
								
							var arr =[
								{'name' : 'action','value':'add'},
								{'name':'age', 'value':member.getAge()},
								{'name' : 'gender' ,'value' : member.getGender()}
								];
							for(var i in arr){
								var node = document.createElement('input');	
								node.setAttribute('type', 'hidden');
								node.setAttribute('name',arr[i].name);
								node.setAttribute('value',arr[i].value);
								form.appendChild(node);
							}
							form.action = x+"/member.do";
							form.method = "post";
							form.submit();	
						}
						else{
							alert(x.text);
						}
						
					});
				}
				document.getElementById('myPageMoveToUpdate').addEventListener('click',function(){
					router.move({context : x,
						domain : 'member',
						action : 'move',
						page : 'modify'});
				});
				document.getElementById('myPageMoveToDelete').addEventListener('click',function(){
					router.move({context : x,
						domain : 'member',
						action : 'move',
						page : 'remove'});
				});
				//update
				var roll = document.getElementById('roll');
				var teamId = document.getElementById('teamId');
				
				for(var i of document.querySelectorAll('.roll-opt')){
					if(i.getAttribute('value')===roll.getAttribute('class')){
						i.setAttribute("selected","selected");
					}
				}
				for(var i of document.querySelectorAll('.team-opt')){
					if(i.getAttribute('value')===teamId.getAttribute('class')){
						i.setAttribute("selected","selected");
					}
				}
				
				if(document.getElementById('updateConfirmBtn')!=null){
					document.getElementById('updateConfirmBtn').addEventListener('click',function(){
						
						var form = document.getElementById('updateForm');
						form.action = x+"/member.do";
						form.method = "post";
						
						var node = document.createElement('input');
						node.innerHTML='<input type="hidden" name="action" value="modify"/>';
						form.appendChild(node);
						
						if(service.nullChecker([
							document.updateForm.before_pass.value]).checker){
							if(service.nullChecker([
								document.updateForm.after_pass.value]).checker){
								form.submit();
							}
							else{
								form.after_pass.value = form.after_pass.placeholder;
							form.submit();
							}	
						}else{
							alert("비밀번호를 입력하세요.");
						} 
					});
				}	
				//remove
				if(document.getElementById('deleteConfirmBtn')!=null){
					document.getElementById('deleteConfirmBtn').addEventListener('click',function(){
						var form = document.getElementById('deleteForm');
						if(service.nullChecker([form.password.value]).checker){
							form.action = x+"/member.do";
							form.method = "post";
							
							var node = document.createElement('input');
							node.setAttribute("type","hidden");
							node.setAttribute("name","action");
							node.setAttribute("value","remove");
							form.appendChild(node); 
							form.submit();
						}
						else{
							alert("비밀번호를 입력하세요.");
						}
					});
				}
				
				//change page
				document.getElementById("goHome").addEventListener('click',function(){ //콜백함수
					router.move({context : x,
						domain : 'common'}
						);
				});	
				if(document.getElementById("goMypage")!=null){
					document.getElementById("goMypage").addEventListener('click',function(){ 
						router.move({context : x,
									domain : 'member',
									action : 'retrieve',
									page : 'retrieve'});
					});
				}
				if(document.getElementById("moveLogin")!=null){
					document.getElementById("moveLogin").addEventListener('click',function(){ //콜백함수
						router.move({context : x,
							domain : 'member',
							action : 'move',
							page : 'login'});
					});
				}
				if(document.getElementById("moveJoin")!=null){
					document.getElementById("moveJoin").addEventListener('click',function(){ 
						router.move({context : x,
									domain : 'member',
									action : 'move',
									page : 'add'});
					});
				}
			}
		}
	})();
		
	
	
	
	
	
	
	
	
	
	