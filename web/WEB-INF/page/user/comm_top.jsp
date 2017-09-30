<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/static/user/index/js/jquery.min.js" type=text/javascript></script>
 <script src="${pageContext.request.contextPath}/static/user/comm/comm_top/data.js" type=text/javascript></script>
  <script src="${pageContext.request.contextPath}/static/user/comm/comm_top/sise_Scroll.js" type=text/javascript></script>
 <link rel="stylesheet" type='text/css' href='${pageContext.request.contextPath}/static/user/comm/comm_top/comm_css.css'>
<style>
.index_ingo a{
	display:block;
	overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
}
.index_ingo a{
	/* width:550px; */
	display:block;
}
#memu ul{
    margin: 0;
    padding: 0;
    border: 0;
    font-family: inherit;
    list-style: none;
}
#memu>ul>li>a{
display:block;
}
.intro_Li{
    position: relative;
}
.intro_ul{
   z-index:1;
   display:none;
   font-size: 13px;
    color: #fff;
    letter-spacing: 2px;
    left: 0px;
    position: absolute;
/*     background: url(/beishite/static/user/comm/comm_top/banner.png) repeat-y center; */
}
.intro_ul li{
      height: 30px!important;
      line-height: 30px!important;
       background: url(/static/user/comm/comm_top/intro.jpg) no-repeat center;
}
.intro_ul li a{
display:block;
}
.intro_ul li a:hove{
    color: #FF7200;
}
#memu li a{
font-size: 16px;
font-weight: bold;
font-family:"宋体"; 
 
} 
.main_top_1 ul li a{
font-family:"宋体"; 
font-size: 15px;
}
.intro_ul li a{
font-size: 13px!important;
}
.main_top_11{
text-align:center;
font-family:"宋体"; 
}
</style>
<script>
  $(function(){
	  $(".intro_Li").mouseover(function(){
		  $(this).find(".intro_ul").fadeIn();
	  }).mouseleave(function(){
		  $(this).find(".intro_ul").fadeOut();
	  })
  })
</script>
</head>
<body>
<!--banner部分-->
<div class="logo_fottin"><img alt="logo图标" src="${pageContext.request.contextPath}/static/user/index/images/logo.jpg" border="0"></div>
<!--banner部分-->
<!--nav部分-->
<div id="memu">
    <ul>
        <li><a href="${pageContext.request.contextPath}/user/index/home.html">首页</a></li>
        <li class='intro_Li'> <a href="${pageContext.request.contextPath}/user/intro/selectAll.html?mark=0">研究院简介</a>
             <ul class='intro_ul'>
           
					<li><a href="${pageContext.request.contextPath}/user/intro/selectAll.html?mark=1" >本院领导</a></li>
					<li><a href="${pageContext.request.contextPath}/user/intro/selectAll.html?mark=2" >组织机构</a></li>
					<li><a href="${pageContext.request.contextPath}/user/intro/selectAll.html?mark=3" >宗旨与行动准则</a></li>
					<li><a href="${pageContext.request.contextPath}/user/intro/selectAll.html?mark=4">领导致辞</a>
			
             </ul>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/inform/informs.html">通知公告</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/activity/activitys.html">活动安排</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/recommend/recommends.html">项目产品推荐</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/user/news/newss.html">资讯新闻</a>
        </li>
        <li class='intro_Li'> <a href="${pageContext.request.contextPath}/user/forum/selectAll.html?mark=0">养生论坛</a>
            <ul class='intro_ul'>

                <li><a href="${pageContext.request.contextPath}/user/forum/selectAll.html?mark=1">组委会名单</a></li>
                <li><a href="${pageContext.request.contextPath}/user/forum/selectAll.html?mark=2">组织机构</a></li>
                <li><a href="${pageContext.request.contextPath}/user/forum/selectAll.html?mark=3">宗旨与主题</a></li>
                <li><a href="${pageContext.request.contextPath}/user/forum/permit/showList.html">政府批文</a></li>
                <%--<li><a href="${pageContext.request.contextPath}/user/luntan/selectTopic.html">话题讨论</a></li>--%>
                <li><a href="${pageContext.request.contextPath}/user/forum/file/showList.html">在线下载</a></li>

            </ul
        </li>
        <li><a href="${pageContext.request.contextPath}/user/literature/literatures.html">文献展示</a>

        </li>
        <li><a href="${pageContext.request.contextPath}/user/about/abouts.html">联系我们</a>

        </li>
    </ul>
</div>
<!--nav部分-->
<!--notice-->
<div id="main_top">
    <div class="main_top_1">
        <div class="main_top_11">"网站"公告:</div>
        <div id="scrollDiv_keleyi_com" class="scrollDiv">
            <ul style="margin-top: 0px;padding: 0px;margin:0px;">
            <c:forEach items="${inform}" var="list">
                <li class='index_ingo'><a href="${pageContext.request.contextPath}/user/inform/informID?id=${list.id}">${list.title }</a></li>
                </c:forEach>
            </ul>
        </div>
        <div id="main_top_12"></div>
    </div>
    <!--轮播-->
<!--轮播-->
</div>
<!--notice-->
</body>
</html>