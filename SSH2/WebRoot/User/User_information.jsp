<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">

<title>个人信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<!-- BOOTSTRAP CORE STYLE CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLE CSS -->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLE CSS -->
<link href="assets/css/style.css" rel="stylesheet" />
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top ">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><strong style="">ZJ</strong> <i
					class="fa fa-globe"></i>J </a>
			</div>
			<div class="navbar-collapse collapse move-me">
				<ul class="nav navbar-nav navbar-right set-links">
					<li><a href="User/User_login_Success.jsp">首页</a></li>
                    <li><a href="User/Problem_list">题目</a></li>
                    <li><a href="">排名</a></li>
                    <li><a href="User/User_load?id=${userId }">${userName}</a></li>

				</ul>
			</div>

		</div>
	</div>
	<!--MENU SECTION END-->
	<section id="home-sec">
	<div class="overlay text-center"></div>
	</section>
	<div class="container main">
		<div class="row">
			<div class="col-md-12 col-lg-12">
				<div class="row"></div>
				<div>
					<table class="table table-striped">
						<tbody>
							<center>
								<br>
								用户名:<input type="text" name="user.name" value="<s:property value="user.name"/>" readonly>
								<br><br>
    							性别:<input type="text" name="user.sex" value="<s:property value="user.sex"/>" readonly>
    							<br><br>
    							邮箱:<input type="text" name="user.email" value="<s:property value="user.email"/>" readonly>
    							<br><br>
    							AcSum:<input type="text" name="user.acSum" value="<s:property value="user.acSum"/>" readonly>
    							<br>
								
							</center>


						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- COPY TEXT SECTION END-->
	<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<script src="assets/js/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="assets/js/bootstrap.js"></script>
	<!-- CUSTOM SCRIPTS  -->
	<script src="assets/js/custom.js"></script>
</body>
</html>
