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
    
    <title>题目更新</title>
    
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
     <form action="Problem/Problem_update.action" method="post">
     	<input type="hidden" name="problem.id" value="<s:property value="problem.id"/>">	
    	题目：<input type="text" name="problem.title" value="<s:property value="problem.title"/>"><br>
    	内容：<textarea name="problem.content" rows="10"><s:property value="problem.content"/></textarea><br>
    	输入：<input type="text" name="problem.testIn" value="<s:property value="problem.testIn"/>"><br>
    	输出：<input type="text" name="problem.testOut" value="<s:property value="problem.testOut"/>"><br>
    		<input type="submit" value="提交">
    </form>
  </body>
</html>
