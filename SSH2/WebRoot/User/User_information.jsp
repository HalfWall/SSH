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
    
    <title>个人信息</title>
    
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
    	用户名：<input type="text" name="user.name" value="<s:property value="user.name"/>" readonly><br>
    	性别：<input type="text" name="user.sex" value="<s:property value="user.sex"/>" readonly><br>
    	邮箱<input type="text" name="user.email" value="<s:property value="user.email"/>" readonly><br>
    	AcSum：<input type="text" name="user.acSum" value="<s:property value="user.acSum"/>" readonly><br>
  </body>
</html>