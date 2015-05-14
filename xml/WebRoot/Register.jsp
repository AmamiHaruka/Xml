<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="bootstrap/bootstrap/css/bootstrap.css">
 	<link rel="stylesheet" href="Flat-UI-master/Flat-UI-master/dist/css/flat-ui.css">
    <script src="javaScript/jquery-1.11.3.min.js"></script>
    <script src="bootstrap/bootstrap/js/bootstrap.js"></script>
     <style type="text/css">
     .form-control{
     width:50%;
     }
    
    
     </style>
     <script type="text/javascript" src="javaScript/verify.js">
     
     </script>
     <script>
     function tijiao(){
		verifyUserName();
		VerifyPwd();
		verifyPassword();
		emailVeify();
			if(resultName==2&&resultRe==2&&resultPassword==2&&resultEmail==2){
				$("#registerForm").submit();
			
			}
	}</script>
  </head>
  
  <body>
  <nav class="navbar   navbar-inverse navbar-stacked " role="navigation">
  <div class="navbar-header">
 
  <a class="navbar-brand" href="#">论坛</a>
  </div>
  <div>
  	<ul class="nav navbar-nav">
  	<li class="dropdown">
  	
  	<a href="#" class="dropdown-toggle" data-toggle="dropdown">论坛主题<b class="caret"></b></a>
  	<ul class="dropdown-menu">
  	<li><a href="#">smart</a></li>
  	<li><a href="#">ssss</a>
  	<li class="divider"></li>
  	</ul>
  	</li>
  	<li><a href="#">留言<span class="badge">50</span></a></li>
  	<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">设置<b class="caret"></b></a>
  	<ul class="dropdown-menu">
  	<li><a href="#">修改个人信息</a></li>
  	<li><a href="#">修改密码</a>
  	</ul>
  	<li>
 
  	</ul>
  </div>
 
  </nav>
   
    <fieldset style="width:730px; margin:0px auto" >
  <form class="form-horizontal" role="form" id="registerForm" action="welcome/register.action">
   
  <div class="form-group"  >
  <label for="username" class=" contorl-label">用户名</label>
  <input type="text" class="  form-control " onblur="verifyUserName()" placeholder="请输入用户名" name="username" id="username">
  <span id="nameError"></span>
  
  </div>
  <div class="form-group">  
  <label for="password">密码</label>
  <input type="password" class="form-control" onblur="VerifyPwd('#pwdError')" placeholder="请输入密码" name="password" id="password">
  <span id="pwdError"></span>
  </div>
  <div class="form-group">
  <label for="password-rp">重复输入密码</label>
  <input type="password" class="form-control" onblur="verifyPassword()" name="repassword" id="repassword">
 <span id="repwdError"></span>
  </div >
  
  <div class="form-group">
  <label for="email">邮箱</label>
  <input type="text" class="form-control"  id="email" name="email" onblur="emailVerify()"><span id="emailError"></span>
  </div>
  <div class="form-group">
  <label for="sex">性别：    </label>
  <input type="radio" 	 name="sex"  value="male" data-toggle="radio" checked >男
 
  <input type="radio" name="sex" value="female">女
  </div>
  <br>
  <div class="form">
  <input type="button" class="btn btn-primary" onclick="tijiao()" value="注册">
  </div>
  </form>
  </fieldset>
  </body>
</html>

