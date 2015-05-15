<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>


<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href="styles.css">
	 

    
    
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
    
    <script>
$(document).ready(function(){
  $('input').iCheck({
    checkboxClass: 'icheckbox_square-red',
    radioClass: 'iradio_square-red',
    increaseArea: '20%' // optional
  });
});
</script>
<script type="text/javascript" src="javaScript/verify.js"></script>
<script type="text/javascript">
function tijiao(){
	emailVerify();
	if(resultEmail==2){
		$("#modifyForm").submit();
	}
}
</script>
  </head>
  
  <body>
  <div class="panel panel-primary">
  <div class="panel-heading">
  <p>修改个人信息</p>
  </div>
  <div class="panel-body">
   <fieldset style="width: 550px; margin:0px auto;">
     <form class="form-horizontal"  action="modify/personModify!modifyInfo.action" id="modifyForm">
     <div class="form-group">
     
     <label for="sex">性别</label>
     
   <s:if test="#request.sex=='male'">
     <input type="radio" name="sex" value="male" checked>男
     	<input type="radio" name="sex" value="female" >女
    </s:if>
    <s:elseif test="#request.sex=='female'">
    	<input type="radio" name="sex" value="male" >男
     	<input type="radio" name="sex" value="female" checked>女
    </s:elseif>
     </div>
     <div class="form-group">
     
  		<label for="email">邮箱</label>
  		<input type="email" class="form-control" id="email" name="email" onblur="emailVerify()" value=<%=request.getAttribute("email") %>><span id="emailError">
  	</div>
  	<div class="form-group">
  	<input type="button" class="btn btn-primary" value="提交" onclick="tijiao()">
  	</div>
    
     </form>
     </fieldset>
     </div>
     </div>
    
  </body>
</html>
