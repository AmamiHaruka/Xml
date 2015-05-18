<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     
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
    <script src="bootstrap/bootstrap/js/jquery-1.11.2.js"></script>
    <script src="bootstrap/bootstrap/js/bootstrap.js"></script>
     <style>
     .form-control{
     width:50%;
     }
     
     </style>
  </head>
  
  <body>
     
     <form class="form-horizontal" role="form" method="post" action="welcome/login.action">
     <fieldset style="width:730px; margin:0px auto" >
     <div class="form-group">
     <label class=" label-control  " for="username">用户名：</label>
     
     	<input type="text" class="form-control " id="username" placeholder="请输入用户名">
      
     
     </div>
     <div class=" form-group">
     
     <label class="label-control " for="password">密码：</label>
      
     <input type="password" class="form-control" id="password" placeholder="请输入密码">
     
     </div>
      
     <button class="btn btn-info" onclick="login()">Login</button>
     </fieldset>
     </form>
     
  </body>
</html>
