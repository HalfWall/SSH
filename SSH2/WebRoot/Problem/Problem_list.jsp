<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>题目列表</title>
    
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
  	<a href="Problem/Problem_add.jsp">添加题目</a>
  	<hr>
    <s:iterator value="problems">
    	<s:property value="id"/>
    	<s:property value="title"/>
    	<a href="Problem/Problem_delete?id=<s:property value="id"/>">删除</a>
    	<a href="Problem/Problem_load?id=<s:property value="id"/>">编辑</a><br>
    </s:iterator>
    <hr>
    <a href="User/manager.jsp">返回</a>
    <s:debug></s:debug>
  </body>
</html>
