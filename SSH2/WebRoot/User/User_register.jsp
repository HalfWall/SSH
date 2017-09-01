<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form method="post" action="User/User_register.action">
    	账号：<input type="text" name="user.name"><br>
    	密码：<input type="password" name="user.password"><br>
    	重复密码：<input type="password" name="user.password2"><br>
    	邮箱：<input type="text" name="user.email"><br>
    	<s:radio list="{'male','female'}" name="user.sex" value="'male'"/><br>
    			<input type="submit" value="提交">
    
    </form>
  </body>
</html>
