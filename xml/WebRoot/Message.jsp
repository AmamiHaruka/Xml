<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>帖子详情</title>
    
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
    <script>
      	
    	function contentVerify()
		{
			var data={content:$("#content").val()};
			$.post("post/contentVerify.action",data,function(result){
				if(result==0){
					$("#contentError").text("Content can't be Empty!").css("color","red");
				}else if(result==1){
					$("#lo").text("Login");
					$("#contentError").text(" to Reply").css("color","red");
				}
				else{
					$("#replyForm").submit();
				}
				
			});
		}
    </script>
  </head>
  
  <body>
   <div class="panel panel-success">
  <p style="font-size: 30px;color:blue"><a href="welcome/showTopics.action?topicID=${param.topicID }&themeID=${param.themeID}">回到主页</a></p>
   <hr noshade color="red" size="20px"></hr>
   <div class="panel-body">
	   <div class="passage">
	   <h6>${requestScope.topic.title }</h6>
	   <p style="width:700px;height:100px; word-wrap: break-word">${requestScope.topic.content }<P>
	   <p style="margin-left: 400px">${requestScope.topic.author }发表于${requestScope.topic.postTime }</p>
	   </div>
	   <hr noshade color="red" size="20px"></hr>
	   <c:forEach items="${requestScope.replys}" var="reply">
	   <div class="passage">
	   <h6 style="color:green">${reply.rname } Replied</h6>
	   <p style="width:700px;height:100px; word-wrap: break-word">${reply.content }</p>
	   <p style="margin-left: 450px">回复时间${reply.date}</p>
	   </div>
	   <hr color="red" size="20px"></hr>
	   </c:forEach>
   <div class="form">
   <form class="form-horizontal" action="reply/reply.action" id="replyForm" method="post">
   <div class="form-group">
   <textarea rows="10" cols="" class="form-control" name="content" id="content" style="width: 700px"></textarea><a href="index.jsp" id="lo"></a><span id="contentError"></span>
   </div>
   <input type="hidden" name="topicID" value="${param.topicID }">
   <input type="hidden" name="themeID" value="${param.themeID }">
   <div class="form-group">
   <input type="button" class="btn btn-primary" onclick="contentVerify()" value="提交" style="margin-left: 650px">
   </div>
   </form>
   </div>
   </div>
   </div>
  </body>
</html>
