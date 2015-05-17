var resultName=0,resultRe=0,resultPassword=0,resultEmail=0,resultOringin;
	function verifyUserName(){
		var data={username:$("#username").val()};
		$.post("verify/nameVerify.action",data,function(result){
			if(result==0){
				$("#nameError").text("username has existed").css("color","red");
			}else if (result==2){
				$("#nameError").text("Ok").css("color","green");
			}else{
				$("#nameError").text("UserName cannot be empty!").css("color","red");
			}
			resultName=result;
		});
	}
	/*
	 * 验证在此输入密码
	 */
	function verifyPassword(){
		var data={password:$("#password").val(),repassword:$("#repassword").val()};
		console.log("repassword:"+data.password);
		$.post("verify/repasswordVerify.action",data,function(result){
		    if(result==2){
				$("#repwdError").text("Ok").css("color","green");
			}else if(result==3){
				$("#repwdError").text("Two password not same").css("color","red");
			}else{
				$("#repwdError").text("Pleace re-sure your password").css("color","red");
			}
			resultRe=result;
		});
	}
	/*
	 * 验证密码
	 */
	function VerifyPwd(id){
		var data={password:$("#password").val()};
		$.post("verify/pwdVerify.action",data,function(result){
		
			if(result==0){
				$(id).text("Password cannot be empty！").css("color","red");
			}else{
				$(id).text("Ok").css("color","green");
			}
			resultPassword=result;
		});
		
	}
	function emailVerify(){
		var data={email:$("#email").val()};
		$.post("verify/emailVerify.action",data,function(result){
			if(result==0){
				$("#emailError").text("Email can't be empty!").css("color","red");
			}else{
				$("#emailError").text("Ok").css("color","green");
			}
			resultEmail=result;
		});
	}
	function prePassword(){
		var data={passwordpre:$("#passwordpre").val()};
		$.post("verify/preVerify.action",data,function(result){
		
			if(result==0){
				$("#preError").text("Password cannot be empty！").css("color","red");
			}else if(result==1){
				$("#preError").text("Password Wrong!").css("color","red");
			}else{
				$("#preError").text("Ok").css("color","green");
			}
			resultOringin=result;
		});
		
	}
	