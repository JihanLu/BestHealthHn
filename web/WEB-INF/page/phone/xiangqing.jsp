<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <title>最新资讯详情页</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=3,minimum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/phone/news/css/xiangqing.css" type="text/css"/>
    <%-- <script src="${pageContext.request.contextPath}/static/phone/register/js/jquery-1.10.2.min.js" type="text/javascript"></script> --%>
         <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/zhixiao/lib/jquery/jquery-2.1.4.min.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/static/phone/news/js/ser.js" type="text/javascript"></script> --%>

</head>
<body>
<div class="top">
    <a href="${pageContext.request.contextPath}/user/phone/skipNews.html"><span class="top_a">
 <img src="${pageContext.request.contextPath}/static/phone/news/img/shangchengleft.png"/>
    </span></a>
    <span class="top_b">返回</span>
</div>
<!--<div class="center">-->
    <!--<div class="center_img"><img src="/home/news/img/bg.jpg" width="100%" height="100%"/></div>-->
<!--</div>-->
<div class="ttl">
    <h1>${news.title }</h1>
    <img src="${pageContext.request.contextPath}/static/phone/news/img/ccdot.gif" alt=""/>
    <p>时间：<span><fmt:formatDate  value="${news.time}" type="both" pattern="yyyy.MM.dd HH:mm:ss" /></span></p>
</div>
<div class="main">
    <div class="nr">
        <ul>
            <li><p>${news.content }</p></li>
        </ul>
    </div>

</div>
<div class="foot">

</div>

<!--<div class="foot">-->
<!--<a href="#">-->
<!--<sapn class="foootspan"><img src="/home/shangcheng/img/18.png" width="40" height="30"></sapn>-->
<!--<span>商城首页</span>-->
<!--</a>-->
<!--<a href="#">-->
<!--<span class="foootspan"><img src="/home/shangcheng/img/19.png" width="40" height="30"></span>-->
<!--<span>分类</span>-->
<!--</a>-->
<!--<a href="#">-->
<!--<span class="foootspan"><img src="/home/shangcheng/img/20.png" width="40" height="30"></span>-->
<!--<span>购物车</span>-->
<!--</a>-->
<!--<a href="#">-->
<!--<span class="foootspan"><img src="/home/shangcheng/img/21.png" width="40" height="30"></span>-->
<!--<span>商家中心</span>-->
<!--</a>-->
<!--</div>-->
<script>
$(function(){
	
	$(".main img").addClass("img_wh");
})
</script>

</body>
</html>