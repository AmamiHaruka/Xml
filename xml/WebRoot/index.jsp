<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="javaScript/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="javaScript/login.js">
     
    </script>

  </head>
  
  <body>
  <form action="welcome/login.action" id="loginForm">
  	<input type="text" name="username" id="username"><span id="loginError"></span><br>
  	<input type="password" name="password" id="password"><br>
  	<input type="button" value="Submit" onclick="login()"><br>
  	
  	<input type="submit" value="123">
  </form>
  
  <div id="result"></div>
  </body>
</html>
