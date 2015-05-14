<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ModifyPassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" href="Flat-UI-master/Flat-UI-master/doc/assets/css/demo.css">
	  <link rel="stylesheet" href="bootstrap/bootstrap/css/bootstrap.css">
 	<link rel="stylesheet" href="Flat-UI-master/Flat-UI-master/dist/css/flat-ui.css">
 	<link rel="stylesheet" href="icheck-1.x/skins/square/green.css">
 	
 	<script src="icheck-1.x/icheck.js"></script>
    <script src="bootstrap/bootstrap/js/jquery-1.11.2.js"></script>
    <script src="bootstrap/bootstrap/js/bootstrap.js"></script>
    
    <style type="text/css">
    .panel{
      width:730px;
      margin:0px auto;
    }
    </style>
  </head>
  
  <body>
     
      <div class="panel panel-primary">
  <div class="panel-heading">
  <p>修改个人密码</p>
  </div>
  <div class="panel-body">
   <fieldset style="width: 550px; margin:0px auto;">
     <form class="form-horizontal" role="form">
    
     
     <div class="form-group">
     
  		<label for="passwordpre">原始密码</label>
  		<input type="text" class="form-control"  id="passwordpre" name="passwordpre">
  	</div>
  	<div class="form-group">
     
  		<label for="passwordpre">密码</label>
  		<input type="text" class="form-control"  id="password " name="password ">
  	</div>
  	<div class="form-group">
     
  		<label for="passwordpre">再次输入密码</label>
  		<input type="text" class="form-control"  id="passwordre" name="passwordre">
  	</div>
  	<div class="form-group">
  	<button type="submit" class="btn btn-primary">提交</button>
  	</div>
    
     </form>
     </fieldset>
     </div>
     </div>
    
      
  </body>
</html>
