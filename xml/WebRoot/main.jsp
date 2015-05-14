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

  </head>
  
  <body>
  <nav class="navbar   navbar-inverse   " role="navigation">
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
  	<li><a href="/post">发帖</a></li>
  	<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">设置<b class="caret"></b></a>
  	<ul class="dropdown-menu">
  	<li><a href="modify/personModify!toModify.action">修改个人信息</a></li>
  	<li><a href="modify/personModify!toModifyPassword.action">修改密码</a>
  	</ul>
  	<li>
 
  	</ul>
  </div>
 
  </nav>
   <div class="panel panel-primary">
   <div class="panel-body">
   <table class="table table-striped">
   <thead>
  
   	<tr>
   	 
   	<th>标题</th>
   	<th>作者</th>
   	<th>回复数</th>
   	<th>最后修改时间</th>
   
   	</tr>
   
   </thead>
   
   <tbody>
   
   <tr>
   <td><a href="/Test/Message.jsp">Smart</a></td>
   <td>sss</td>
   <td>2</td>
   <td>2013/2/2</td>
   </tr>
   </tbody>
   
   </table>
    </div>
   </div>
  </body>

</html>
