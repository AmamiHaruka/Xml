<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Message.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!--  <link rel="stylesheet" href="Flat-UI-master/Flat-UI-master/doc/assets/css/demo.css">-->
	  <link rel="stylesheet" href="bootstrap/bootstrap/css/bootstrap.css">
 	<link rel="stylesheet" href="Flat-UI-master/Flat-UI-master/dist/css/flat-ui.css">
 	<!--<link rel="stylesheet" href="icheck-1.x/skins/square/green.css">-->
 	
 	<!--  <script src="icheck-1.x/icheck.js"></script>-->
    <script src="bootstrap/bootstrap/js/jquery-1.11.2.js"></script>
    <script src="bootstrap/bootstrap/js/bootstrap.js"></script>
    <script src="Flat-UI/master/Flat-UI-master/dist/js/flat-ui.js"></script>
    <style type="text/css">
    .panel{
      width:730px;
      margin:auto;
    }
    
    .form-control{
    	width:530px;
    	margin:0px auto;
    	
    }
    .passage{
    	margin:0px auto;
    }
    </style>
  </head>
  
  <body>
   <div class="panel panel-success">
   <div class="panel-body">
   <div class="passage">
   <h1>Smart 的一天</h1>
   <p>sdasdfakdflasfjdjfajlsfjsalfjsldfjlasdflsdjfsjdfldsfsdlfasdfj<P>
   </div>
   <div class="form">
   <form class="form-horizontal" role="form">
   <div class="form-group">
   <textarea rows="3" cols="" class="form-control"></textarea>
   </div>
   <div class="form-group">
   <button type="submit" class="btn btn-primary"></button>
   </div>
   </form>
   </div>
   </div>
   </div>
  </body>
</html>
