<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 

   <!--<link rel="stylesheet" href="stylesheets/bootstrap-responsive.css">  --> 
    <base href="<%=basePath%>">
    
    <title>超级论坛</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<link rel="stylesheet" href="bootstrap/bootstrap/css/bootstrap.css">
 	 <!--  <link rel="stylesheet" href="Flat-UI-master/Flat-UI-master/dist/css/flat-ui.css">-->
    <script src="javaScript/jquery-1.11.3.min.js"></script>
    <script src="bootstrap/bootstrap/js/bootstrap.js"></script>
       <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;

        }
        #button1{
         left:1040px;
         position: relative;
        }
        #button2{
        left:1040px;
        position: relative;
        }
        .form{
        left:60px;
        position: relative;
        }
    </style>
    <script src="javaScript/login.js"></script>
  </head>
  
  <body>
  <nav class="navbar   navbar-inverse navbar-fixed-top " role="navigation">
  <div class="navbar-header">
 
  <a class="navbar-brand" href="#">论坛</a>
  </div>
  <div>
  	<ul class="nav navbar-nav">
 
  	<li><a href="/Test/Login.jsp">登录 </a></li>
  	<li><a href="/Test/reg.jsp">注册</a></li>
  
 
  	</ul>
     </div>
      
     <a type="button" href="welcome/toRegister.action" class="btn btn-info navbar-btn   " id="button1">注册</a>
     
     <a type="button" href="welcome/sightseer.action"  class="btn btn-danger navbar-btn  " id="button2">游客</a>
     </nav>
     
     <span>
     <div class="hello-unit col-lg-9">
 	 <h1>欢迎来到 超级论坛</h1>
  	<p>超级论坛 是一个基于Java 论坛系统。</p>
   
    </div>
    <div class="form col-lg-2 ">
    <form class="form-horizontal" role="form" id="loginForm" action="welcome/login.action">
     <fieldset style="width:250	px; margin:0px auto" >
     <div class="form-group">
     <label class=" label-control  " for="username">用户名：</label>
     
     	<input type="text" class="form-control " id="username" placeholder="请输入用户名" name="username">
      
     
     </div>
     <div class=" form-group">
     
     <label class="label-control " for="password">密码：</label>
      
     <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
     <span id="loginError"></span>
     </div>
     <div class="form-group" style>
     <button class="btn btn-success btn-lg" type="button" style="witdh:150%" onclick="login()">Login </button>
     
     </div>
      
     </fieldset>
     </form>
 
    </div>
     </span>
     

    

  </body>
  
</html>
