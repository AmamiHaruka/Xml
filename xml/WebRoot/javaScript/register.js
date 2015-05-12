/**
 * 
 */
var r1,r2,r3;
	function verifyUserName(){
		var data={username:$("#username").val()};
		$.post("welcome/nameVerify.action",data,function(result){
			if(result==0){
				$("#nameError").text("username has existed");
			}else if (result==2){
				$("#nameError").text("Ok");
			}else{
				$("#nameError").text("UserName cannot be empty!");
			}
			r1=result;
		});
	}
	function verifyPassword(){
		var data={password:$("#password").val(),repassword:$("#repassword").val()};
		console.log("repassword:"+data.password);
		$.post("welcome/repasswordVerify.action",data,function(result){
		    if(result==2){
				$("#repwdError").text("Ok");
			}else if(result==3){
				$("#repwdError").text("Two password not same");
			}else{
				$("#repwdError").text("Pleace re-sure your password");
			}
			r2=result;
		});
	}
	function VerifyPwd(){
		var data={password:$("#password").val()};
		$.post("welcome/pwdVerify.action",data,function(result){
		console.log("password:"+result);
			if(result==0){
				$("#pwdError").text("Password cannot be empty！");
			}else{
				$("#pwdError").text("Ok");
			}
			r3=result;
		});
		
	}
	function submit(){
		console.log(r1+r2+r3);
			if(r1==2&&r2==2&&r3==2){
				$("#registerForm").submit();
			
			}
	}
		
	