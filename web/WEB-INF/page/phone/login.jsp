<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="initial-scale=1,maximum-scale=3,minimum-scale=1,user-scalable=no"/>
<title>登录界面</title>
    <script src="${pageContext.request.contextPath}/static/phone/register/js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/tribune/js/layer.js"></script>
    <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/style/layer.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/phone/login/style/index.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/phone/login/font/iconfont.css" />
  <script src="${pageContext.request.contextPath}/static/phone/login/js/checklogin.js" type="text/javascript"></script>
<style type="text/css">
        .denglu p {
           width: 100%;
    margin: 3% auto;
/*     border-bottom: 1px solid #d9d9d9; */
    <%--background-color: #243240;--%>
    border-radius: 0.4em;
    margin-bottom: 1em;
  /*   background: url(/home/login/images/bg.png) no-repeat ; */
  
    background-color: rgba(0,0,0,0.5);

        }
        #tips{position: fixed;top: 0;right: 0;bottom: 0;left: 0;background: rgba(0,0,0,0);z-index: 99999;display: none;}
        #tips div{position: absolute;top: 30%;left: 50%;padding: 10px;width: 110px;margin-left: -65px;background: rgba(0,0,0,0.8);color: #fff;text-align: center;font-size: 1.1em;border-radius: 4px;}
        #tips .loading{padding-top: 38px;background: url(/Static/images/loading.gif) center top no-repeat;}
    </style>
</head>
<body>
<div class="bj">
    <img src="${pageContext.request.contextPath}/static/phone/login/images/bj.jpg" />
</div>
<div class="logo">
    <a href="${pageContext.request.contextPath}/user/phone/skipNews.html"><img src="${pageContext.request.contextPath}/static/phone/login/images/logo (1).png"></a>
</div>

<form action="" method="post">
    <div class="denglu">
       <!--  <h1>商家中心</h1> -->
        <p>
          <i class="fa fa-user icon iconfont">&#xe620;</i><input name="phone" type="text" data-form-un="1463655433107.7947">
          <!--  <span class="iphnull">手机号不能为空</span>
           <span class="ipherror">请输入正确的手机号码</span> -->
        </p>
        <p>
          <i class="fa fa-lock icon iconfont">&#xe61b;</i><input name="password" type="password"  class="pho">
         <!--   <span class="pswnull">请输入密码</span>
			<s:if test="#request.i==1">
			<p class="zhmm">输入不能为空</p>
			</s:if>
			<s:if test="#request.i==2">
			<p class="zhmm">账户或密码有误</p>
			</s:if>
			<s:if test="#request.i==3">
			<p class="zhmm">该用户还未激活</p>
			</s:if>
			<s:if test="#request.i==4">
			<p class="zhmm">该用户的VIP已到期</p>
			</s:if> -->
        </p>
       <!--  <h2 onclick="chk();"> -->
        <input type="button" value="登 录" class="login" onclick="checkLog()">
    <!--     </h2> -->
        <a onclick="wjmima()">忘记密码</a> <a href="${pageContext.request.contextPath}/user/phone/skipRegister.html" class="zc">注册</a>
    </div>
</form>
<div id="tips"></div>
<script>
    function t_loading (html){
        var html=arguments[0]?arguments[0]:'';
        $('#tips').html('<div><p class="loading">'+html+'</p></div>').show();
    }

    function t_delay(html,timer){
        var timer=arguments[1]?arguments[1]:800;
        $('#tips').html('<div>'+html+'</div>').show().delay(timer).fadeOut();
    }

</script>
<!-- <div class="zhuce">
    <a href="http://www.zx85.cn/index/register">注册微店</a>
</div> -->
<script src="/Public/tongji_wap.js"></script><p style="display:none;"><img src="http://wm.zx85.cn/tongji/wap?is_root=1&amp;gd=7ZHZeCFJN2jCjcbAGGUx2X4yaDXWxTFt&amp;bhid=7981&amp;locationurl=http%3A%2F%2Fucenter.zx85.cn%2Flogin%2Findex.html%3Fproid%3D462078&amp;title=%E5%95%86%E5%AE%B6%E7%99%BB%E5%BD%95&amp;lasturl=http%3A%2F%2Fwww.ctfnsl.zx85.cn%2Fshop%2F&amp;_=1463655431814"></p>

</body>
</html>