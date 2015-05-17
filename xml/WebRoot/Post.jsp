<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发帖</title>
    
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
	<script >
	var titleResult=0,contentResult=0;
		function verifyTitle(){
		var data={title:$("#title").val()}
			$.post("post/titleVerify.action",data,function(result){
				if(result==0){
					$("#titleError").text("Title can't be Empty!").css("color","red");
				}else{
					$("#titleError").text("Ok").css("color","green");
				}
				titleResult=result;
			});
		}
		function contentVerify()
		{
			var data={content:$("#content").val()};
			$.post("post/contentVerify.action",data,function(result){
				if(result==0){
					$("#contentError").text("Content can't be Empty!").css("color","red");
				}else{
					$("#contentError").text("Ok").css("color","green");
				}
				contentResult=result;
			});
		}
		function tijiao(){
			verifyTitle();
			contentVerify();
			if(contentResult==2&&titleResult==2){
				$("#postForm").submit();
			}
		}
		var themeID="${param.themeID}";
		$(document).ready(function(){
			$("[value="+themeID+"]").attr("selected","selected");
		});
	</script>

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
  	<li><a href="welcome/showTopics.action?themeID=1">男神的世界</a></li>
  	<li><a href="welcome/showTopics.action?themeID=2">教授讲武堂</a></li>
  	<li><a href="welcome/showTopics.action?themeID=3">宝宝新科技</a></li>
  	<li><a href="welcome/showTopics.action?themeID=4">我爱毛主席</a></li>
  	<li><a href="welcome/showTopics.action?themeID=5">最炫民族风</a></li>
  	<li class="divider"></li>
  	</ul>
  	</li>
  	<li><a href="#">留言<span class="badge">50</span></a></li>
  	<li><a href="/post">发帖</a></li>
  	<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">设置<b class="caret"></b></a>
  	<ul class="dropdown-menu">
  	<li><a href="#">修改个人信息</a></li>
  	<li><a href="#">修改密码</a>
  	</ul>
  	<li>
 		
  	</ul>
  </div>
  </nav>
       
  <form class="form-horizontal" id="postForm" action="post/post.action" method="post">
   <fieldset style="width:730px; margin:0px auto" >
  	<div class="form-group">
  	<label for="title">标题</label>
  	<input type="text" class="form-control" id="title" placetitle="请输入标题" name="title" onblur="verifyTitle()"><span id="titleError"></span>
  	</div>
  	<div class="form-group">
  	<label for="theme">主题</label>
  	<select   class="form-control" name="themeID"><
  	<option value="1" >男神的世界</option>
  	<option value="2" >教授讲武堂</option>
  	<option value="3">宝宝新科技</option>>
  	<option value="4">我爱毛主席</option>
  	<option value="5">最炫民族风</option>
  	</select>
  	</div>
  	<div class="form-group">
  	<textarea rows="3" cols="" class="form-control" name="content" id="content" onblur="contentVerify()"></textarea>
  	<p id="contentError" style="height: 20px"></p>
  	
  	</div>
  	<input class="btn btn-info" type="button" onclick="tijiao()" value="发布" >
   
  	</form>
  </body>
</html>
