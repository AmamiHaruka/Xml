<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="javaScript/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="javaScript/register.js"></script>
  </head>
  
  <body>
   <form action="welcome/register.action" id="registerForm">
   <input type="text" name="username" id="username" onblur="verifyUserName()"><span id="nameError"></span><br/>
   <input type="text" name="password" id="password" onblur="VerifyPwd()"><span id="pwdError"></span><br/>
   <input type="text" name="repassword" id="repassword" onblur="verifyPassword()"><span id="repwdError"></span><br/>
   <input type="button" value="提交" onclick="submit()">
    </form>
  </body>
</html>
