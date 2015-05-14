/**
 * 
 */
function login(){
      	var data={username:$("#username").val(),password:$("#password").val()};
     	$.post("welcome/loginVerify.action",data,function(result){
     		console.log(result);
     		if(result=="ok"){
     			$("#loginForm").submit();
     		}else if(result=="nouser"){
     			$("#loginError").text("No such user!");
     		}else{
     			$("#loginError").text("username doesn't match password");
     		}
     	});
     }