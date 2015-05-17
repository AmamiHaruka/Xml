<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  	<li><a href="welcome/showTopics.action?themeID=1">男神的世界</a></li>
  	<li><a href="welcome/showTopics.action?themeID=2">教授讲武堂</a></li>
  	<li><a href="welcome/showTopics.action?themeID=3">宝宝新科技</a></li>
  	<li><a href="welcome/showTopics.action?themeID=4">我爱毛主席</a></li>
  	<li><a href="welcome/showTopics.action?themeID=5">最炫民族风</a></li>
  	<li class="divider"></li>
  	</ul>
  	</li>
  	<li><a href="#">留言<span class="badge">50</span></a></li>
  	<li><a href="post/toPost.action?themeID=${param.themeID }">发帖</a></li>
  	<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">设置<b class="caret"></b></a>
  	<ul class="dropdown-menu">
  	<li><a href="modify/personModify!toModify.action">修改个人信息</a></li>
  	<li><a href="modify/personModify!toModifyPassword.action">修改密码</a>
  	</ul>
  	<li>
 
  	</ul>
  	<p style="color:white;margin-left: 1100px">欢迎你！${sessionScope.username}</p>
  </div>
 
  </nav>
   <div class="panel panel-primary">
   <div class="panel-body">
   <table class="table table-striped">
  
  
   	<tr>
   	 
   	<th>标题</th>
   	<th>作者</th>
   	<th>回复数</th>
   	<th>发帖时间</th>
   
   	</tr>
   
   
   
   <c:forEach var="topicTop" items="${requestScope.topicsTop }" varStatus="st">
   <tr>
   
   <td><span style="color:red">置顶</span><a href="reply/showReplys.action?topicID=${topicTop.id }&themeID=${param.themeID }">${topicTop.title }</a>
   <c:if test="${topicTop.excellent=='1' }">
   <span style="color:red">精</span>&nbsp;
   </c:if>
   </td>
   <td>${topicTop.author }</td>
   <td>${topicTop.replynum }</td>
   <td>${topicTop.postTime }</td>
   <c:if test="${sessionScope.role=='root'}" var="resultEL">
   		<td><a href="root/delete.action?topicID=${topicTop.id }&themeID=${param.themeID }">删除</a></td>
   		<c:choose>
   			<c:when test="${topicTop.excellent=='1' }">
   				<td><a href="root/deExcellent.action?topicID=${topicTop.id }&themeID=${param.themeID }">取消加精</a></td>
   			</c:when>
   			<c:otherwise>
   				<td><a href="root/excellent.action?topicID=${topicTop.id }&themeID=${param.themeID }">加精</a></td>
   			</c:otherwise>
   		</c:choose>
   		<td><a href="root/detop.action?topicID=${topicTop.id }&themeID=${param.themeID }">取消置顶</a></td>
   </c:if>
   </tr>
   
   </c:forEach>

   <s:iterator value="topics" var="topic">
   
   
   <tr>
   <td><a href="reply/showReplys.action?topicID=${topic.id }&themeID=${param.themeID }"${topic }"">${topic.title }</a>
   <c:if test="${topic.excellent=='1' }">
   <span style="color:red">精</span>&nbsp;
   </c:if></td>
   <td>${topic.author }</td>
   <td>${topic.replynum }</td>
   <td>${topic.postTime }</td>
   <c:if test="${sessionScope.role=='root'}" var="resultEL">
   		<td><a href="root/delete.action?topicID=${topic.id }&themeID=${param.themeID }">删除</a></td>
   		<c:choose>
   			<c:when test="${topic.excellent=='1' }">
   				<td><a href="root/deExcellent.action?topicID=${topic.id }&themeID=${param.themeID }">取消加精</a></td>
   			</c:when>
   			<c:otherwise>
   				<td><a href="root/excellent.action?topicID=${topic.id }&themeID=${param.themeID }">加精</a></td>
   			</c:otherwise>
   		</c:choose>
   		<td><a href="root/top.action?topicID=${topic.id }&themeID=${param.themeID }">置顶</a></td>
   </c:if>
   </tr>
   </s:iterator>
   
   
   </table>
    </div>
   </div>
  </body>

</html>
