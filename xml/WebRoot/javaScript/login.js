/**
 * 
 */
function login(){
      	var data={username:$("#username").val(),password:$("#password").val()};
     	console.log(data);
      	$.post("verify/loginVerify.action",data,function(result){
     		console.log(result);
     		if(result=="ok"){
     			$("#loginForm").submit();
     		}else if(result=="nouser"){
     			$("#loginError").text("No such user!").css("color","red");
     		}else{
     			$("#loginError").text("username doesn't match password").css("color","red");
     		}
     	});
     }