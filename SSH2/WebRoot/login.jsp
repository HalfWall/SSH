<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
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
     <form method="post" action="login.action">
    	账号：<input type="text" name="user.name"><br>
    	密码：<input type="password" name="user.password"><br>
    	验证码：<input type="text" name="user.pinCode">
          		<iframe id="codeFrame" src="PINcode.jpg" height="25" width="115"></iframe><br>
    			<input type="submit" value="提交">
    
    </form>
    <a href="register.jsp">注册</a>
  </body>
</html>
