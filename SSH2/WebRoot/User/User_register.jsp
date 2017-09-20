<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- CSS -->
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel="stylesheet" href="asset/css/reset.css">
<link rel="stylesheet" href="asset/css/supersized.css">
<link rel="stylesheet" href="asset/css/style.css">

</head>

<body>

	<td>
		<div align=center id=rollword>
			<marquee scrollamount=2 width=600 scrolldelay=30
				onMouseOver="javascript:this.stop();"
				onMouseOut="javascript:this.start();">
				<b style="margin-right:20px"></b>
			</marquee>
		</div></td>

	<style type="text/css">
<!--
.TEXT165 {
	width: 220px;
	height: 22px;
	font-family: Arial;
	font-size: 14px;
	border: #879BFF 1px dashed;
	background: transparent
}

.TEXT165_80 {
	width: 220px;
	height: 80pt;
	font-family: Arial;
	font-size: 14px;
	border: #879BFF 1px dashed;
	background: transparent
}

.REG_ERROR {
	color: red;
	font-family: Tahoma;
	font-size: 9pt
}

select {
	font-family: Arial;
	font-size: 14px;
	height: 23px;
	margin: -1px
}

#container {
	overflow: hidden;
	height: 22px;
	border: #879BFF 1px dashed
}
-->
</style>

	<TR>
		<TD>
			<FORM method="post" action="User/User_register.action">
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
					<TBODY>

						<TR>
							<TD width=33% rowspan="15">&nbsp;</TD>
							<TD colspan="2">
								<H1 style="COLOR: #1A5CC8" align=center>Register New Author</H1>
								<DIV align=center style=" color:#B0C4DE ">
									Please fill the following information
								</DIV>
								<BR></TD>
							<TD width=33%>&nbsp;</TD>
						</TR>

						<TR>
							<TD style="color:white">Author ID</TD>
							<TD width="26%"><input name="user.name" type="text"
								maxlength="20" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"> &nbsp;
							</TD>
						</TR>
						<TR>
							<TD style="color:white">Password</TD>
							<TD width="26%"><input name="user.password" type="password"
								maxlength="20" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"> &nbsp;
							</TD>
						</TR>
						<TR>
							<TD style="color:white">Confirm Psw.</TD>
							<TD width="26%"><input name="user.password2"
								type="password" maxlength="20" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"> &nbsp;
							</TD>
						</TR>
						<TR>
							<TD style="color:white">Email</TD>
							<TD width="26%"><input name="user.email" type="text"
								maxlength="48" onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"> &nbsp; 
							</TD>
						</TR>
						<TR>
							<TD style="color:white">Sex</TD>
							<TD width="26%"><s:radio list="{'male','female'}"
									name="user.sex" value="'male'" cssStyle="width:20" /> &nbsp;
							</TD>
						</TR>


						<TR>
							<TD>&nbsp;</TD>
							<TD align="center"><BR> <input 
								type="submit"  value="Submit" class="BUTTON40"
								style="background-color:blue">&nbsp;&nbsp;&nbsp;</TD>
							<TD>&nbsp;</TD>
						</TR>
					</TBODY>
				</TABLE>
			</FORM>
			</TD>
	</TR>
	<a href="User/User_login.jsp">返回</a>
	<!-- Javascript -->
	<script src="asset/js/jquery-1.8.2.min.js"></script>
	<script src="asset/js/supersized.3.2.7.min.js"></script>
	<script src="asset/js/supersized-init.js"></script>
	<script src="asset/js/scripts.js"></script>
	
</body>
</html>
