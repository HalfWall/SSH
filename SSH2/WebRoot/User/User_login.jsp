<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<base href="<%=basePath%>">

<title>login界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

 <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="asset/css/reset.css">
        <link rel="stylesheet" href="asset/css/supersized.css">
        <link rel="stylesheet" href="asset/css/style.css">

       
</head>

<body>
	
	<div class="page-container">
            <h1 style="color:#FF7F24">Login</h1>
            <form action="User/User_login.action" method="post" ">
                <input type="text" name="user.name"  placeholder="Username" >
                <input type="password" name="user.password"  placeholder="Password">
                <input type="text" name="user.pinCode"  placeholder="PINcode" style="width:150px">
                <span><iframe id="codeFrame" src="PINcode.jpg" height="25" width="115">
		     	  </iframe>
		        </span> 	
                <button type="submit">Sign me in</button>
                <div class="error"><span>+</span></div>
            </form>
    </div>
        <div><br><br></div>
        <div align="center" style="color:#FF7F24">No Account 
        <a href="User/User_register.jsp"  >注册</a>
        </div>

        <!-- Javascript -->
        <script src="asset/js/jquery-1.8.2.min.js"></script>
        <script src="asset/js/supersized.3.2.7.min.js"></script>
        <script src="asset/js/supersized-init.js"></script>
        <script src="asset/js/scripts.js"></script>
</body>
</html>
