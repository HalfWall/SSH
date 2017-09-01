<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>答题界面</title>

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
	<table align="center">
		<tr>
			<th>题目：<input type="text" name="problem.title" 
				value="<s:property value="problem.title"/>" readonly><br>
				<br>
				<textarea name="problem.content" style="width: 667px; height: 373px" readonly><s:property value="problem.content" /></textarea><br> 
				
				输入：<input type="text" name="problem.testIn"
				value="<s:property value="problem.testIn"/>" readonly><br>
				
				输出：<input type="text" name="problem.testOut"
				value="<s:property value="problem.testOut"/>" readonly><br>
				<br>
				<br>
				<hr>
			</th>
		</tr>

		<tr>
			<td align="center">
				<form action="Status/Status_judge?id=<s:property value="problem.id"/>" method="post">
					<textarea name="status.code" style="width: 667px; height: 373px"></textarea><br>
					<br>
					<input type="submit" value="提交">

				</form>
			</td>
		</tr>
	</table>
</body>
</html>
