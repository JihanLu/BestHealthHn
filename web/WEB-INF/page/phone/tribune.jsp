<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="initial-scale=1,maximum-scale=3,minimum-scale=1,user-scalable=no" />
  <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/style/basic_shequ.css" rel="stylesheet" />
  <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/style/index.css" rel="stylesheet" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/zhixiao/lib/jquery/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/tribune/js/layer.js"></script>
 <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/style/layer.css" rel="stylesheet" /> 

 <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/tribune/js/comeajax.js"></script>


    <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/font4/iconfont.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/font1/iconfont.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/font2/iconfont.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/style/style.css" rel="stylesheet" />
      <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/style/css.css" rel="stylesheet" />
      <!--   <script>var path=${pageContext.request.contextPath}</script>
            <script>alert(path)</script> -->
               <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/tribune/js/win_load.js"></script> --%>
      <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/tribune/js/forum.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/tribune/js/time.js"></script>
<title>论坛主页</title>
</head>

<body style="background-color:#ebeff8;">

<div class="header_shequ">
    <div class="touxiang" style="top: 8px;">
    <c:if test="${sessionScope.user eq null}">
        <img src="${pageContext.request.contextPath}/static/phone/tribune/images/8.png" />
        </c:if>
        <c:if test="${sessionScope.user ne null}">
        <img src="${pageContext.request.contextPath}/picture/${user.headPhoto}" />
        </c:if>
    </div>
    <div class="message">
        <strong>海南贝仕特养生论坛</strong>
        <!--<p></p>-->
        你好,<input type='text' value='${sessionScope.user.account}' id='userAccout'/>
        <em>动态：${dynamic }</em>

        <!--<a class="mysq1" href="javascript:;" style="bottom:7%;">我的社区 <i class="iconfont">&#xe720;</i></a>-->
    </div>
</div>
<div class="xian"><img src="${pageContext.request.contextPath}/static/phone/tribune/images/xuxian.png" /></div>

<div class="zairu" style="color:#B2B2B2;width:100%;text-align:center;padding:1% 0;">载入中，请稍候...</div>
<div class="go_top" id="go-top" style="display: none;">
    <a href="javascript:scroll(0,0)"><img src="${pageContext.request.contextPath}/static/phone/tribune/images/top.png"></a>
</div>
 

<div class="main_Lon">
</div>
<div class="last">
    <ul>
       <li id="lbg"><span><a href="${pageContext.request.contextPath}/user/phone/skipNews.html">资讯</a></span></li>
       <li id="liId"><span><a href="${pageContext.request.contextPath}/user/phone/skipLantan.html">论坛</a></span></li>
       <li><span id="userInfo">个人中心</span></li> 
    </ul>
</div>
<!-- 当前登录用户的id -->
<input type='hidden' id='user_id' value='${sessionScope.user.userID}' />

<style type="text/css">
	   .foot i{
	   	position: relative;
	   	top:-2px;
	   }
</style>

<script type="text/javascript">
    $(document).ready(function() {
        var h1=$(".header_shequ").outerHeight();
        var h2=$(".touxiang").outerHeight();
        $(".touxiang").css("top",(h1-h2)/2);
    });
    //头像居中
</script>
<script type="text/javascript">
    $(".nav a").click(function(){
        $(".nav a i").removeClass("current");
        $(this).children("i").addClass("current");
    });//点击nav图标变颜色
</script>
<script type="text/javascript">
    $(document).ready(function() {
        var n=$(".content .picture img").outerWidth();
        $(".content .picture img").css("height",n);
    }); //设置图片尺寸
</script>
<script type="text/javascript">
    $("#go-top").hide();
   /*  var auto_load = true, is_onload = false;
    page=2; */
    $(window).scroll(function(){
    	if($(window).scrollTop()>0){
    		$("#go-top").fadeIn();
    	}else{
    		$("#go-top").fadeOut();
    	}
    })

</script>

<script>
  /* var type="qbdt";
    if((type=='')||(type=='undefined')){
        type="qbdt";
    }
    var obj=$(".nav a[data='"+type+"']");

    $(".nav a i").removeClass("current");
    $(obj).find("i").addClass("current");
    $(".article").click(function(){
        id=$(this).attr("data");
        location.href="/community/detail/?id="+id;
    })
    $(".picture").click(function(){
        id=$(this).attr("data");
        location.href="/community/detail/?id="+id;
    })

    $("body").on("click",".myzan1",function(){
   
    }) */

 </script>
</body>
</html>