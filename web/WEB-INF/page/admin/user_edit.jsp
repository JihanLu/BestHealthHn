<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/css/style.css" />
<style type="text/css">
.Contend-Lt-touxx {
    width: 82px;
    height: 82px;
    border-radius: 82px;
    border: 4px solid white;
    text-align: center;
    box-shadow: 1px 1px 3px 1px #646464;
    line-height: 80px;
    float: left;
    clear: left;
    overflow: hidden;
}


</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/ckeditor/ckeditor.js"></script> 
<title>新增文章 - 资讯管理 - H-ui.admin v3.0</title>
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add" enctype="multipart/form-data" action="#" method="post">
		<input type="hidden" value="${user.userID}" id="userID">
		<div class="Contend-Lt-touxx headPor"><img src="${pageContext.request.contextPath}/picture/${user.headPhoto}"> </div> 
		<div class="row cl">
		
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>登录名：${user.account}</label>
			<%-- 
			<div class="formControls col-xs-8 col-sm-9">
				
				<input type="text" class="input-text" value="${user.account}" placeholder="" id="title" name="title">
			</div> --%>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">密码名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" class="input-text" value="${user.password }" placeholder="" id="sources" name="sources">
			</div>
		</div>
		
			<%-- <div class="formControls col-xs-8 col-sm-9"> 
				<input type="file" name="image" value="${news.photo}"><br>
				<img alt="" src="${pageContext.request.contextPath}/picture/${news.photo}" height="200px" width="200px">
			</div> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">手机号码：${user.phone }</label>
			<%-- <div class="formControls col-xs-8 col-sm-9"> 
				<input type="text" class="input-text" value="${user.phone }" placeholder="" id="phone" name="phone">
			</div> --%>
			<div class="form-group" style="margin-left:300px;">
					<!-- <input class="btn btn-primary" id="reset" value="重置" type="reset"> -->
					<input class="btn btn-primary" onclick="addActivity();" value="保存" type="button">
				</div>
		</div>
		
	</form>
</article>
<script type="text/javascript" >
$(document).ready(function(){
$("#reset").click(function(){
CKEDITOR.instances.content.setData(' ');//蓝色为控件名称
});
});
</script>

<script type="text/javascript">
	function addActivity(){
	
		var new_pass=$("#sources").val();
		    
	           if(new_pass==''){
	     			layer.msg("新密码不能为空",{icon:6});
	     			$("#sources").foucs();
	     			return false;
	     		}
	           $.ajax({
	   			url:"/admin/user/updatepass.html",
	   			data:{"password":new_pass,"id":$("#userID").val()},
	   			type:"post",
	   			success:function(data){
	   				if(data.a==0){
	   					layer.msg("账号或手机号码不正确",{icon:6})
	   					return false;
	   				}else if(data.a==1){

	   					layer.msg("更改密码成功",{icon:6});
	   					setTimeout(function(){
	   						window.location.reload();
	   					},1500)
	   				
	   				}else if(data.a==2){
	   					layer.msg("更改密码失败",{icon:6});
	   					return false;
	   				}
	   			},error:function(data){
	   				alert("error");
	   			}
	   		})
	        
	}

</script>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/static/admin/lib/forum.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>

<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>