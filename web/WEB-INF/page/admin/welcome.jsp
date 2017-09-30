<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/css/style.css" />

<title>我的桌面</title>
</head>
<body>
<p class="f-20 text-success" style="margin:10px 10px">欢迎使用<span class="f-14"></span>后台管理功能</p>
<div class="page-container" align="center" id="dly">
	
	<!-- <p>管理员信息</p> -->
	<p id="name">账户名称：${sessionScope.adminSession.adminsName }</p>
	<p id="gly">用户类型：管理员</p>
	<p id="lxfs">联系方式：${sessionScope.adminSession.phone }</p>
</div>

<jsp:include page="comm_bottom.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/static/h-ui/js/H-ui.min.js"></script> 

</body>
</html>