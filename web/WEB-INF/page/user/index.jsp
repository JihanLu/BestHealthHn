<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="baidu-site-verification" content="UiGkLfPfDV" />
    <title>欢迎光临,贝仕特（海南）健康养生研究院</title>
    <link href="${pageContext.request.contextPath}/static/user/index/css/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/user/index/css/index.css" rel="stylesheet" type="text/css">
   
</head>
<body class="abg">
    <jsp:include page='comm_top.jsp' />
    <div id="featured" >
        <ul class="ui-tabs-nav">
        <c:choose><c:when test="${news1.photo eq '' or news1.photo eq null}"></c:when>
           <c:otherwise><li class="ui-tabs-nav-item ui-tabs-selected" id="nav-fragment-1"><a href="#fragment-1"><img src="${pageContext.request.contextPath}/picture/${news1.photo }" alt="" /></a></li></c:otherwise></c:choose>
            <c:choose><c:when test="${news2.photo eq '' or news2.photo eq null}"></c:when>
             <c:otherwise><li class="ui-tabs-nav-item" id="nav-fragment-2"><a href="#fragment-2"><img src="${pageContext.request.contextPath}/picture/${news2.photo }" alt="" /></a></li></c:otherwise></c:choose>
            <c:choose><c:when test="${news3.photo eq '' or news3.photo eq null}"></c:when>
            <c:otherwise><li class="ui-tabs-nav-item" id="nav-fragment-3"><a href="#fragment-3"><img src="${pageContext.request.contextPath}/picture/${news3.photo }" alt="" /></a></li></c:otherwise></c:choose>
            <c:choose><c:when test="${news4.photo eq '' or news4.photo eq null}"></c:when>
            <c:otherwise><li class="ui-tabs-nav-item" id="nav-fragment-4"><a href="#fragment-4"><img src="${pageContext.request.contextPath}/picture/${news4.photo }" alt="" /></a></li></c:otherwise></c:choose>
        </ul>
        <c:choose><c:when test="${news1.photo eq '' or news1.photo eq null}"></c:when>
        <c:otherwise>
        <!-- First Content -->
        <div id="fragment-1" class="ui-tabs-panel" style="">
           <a href="${pageContext.request.contextPath}/user/news/newsID.html?id=${news1.id}"> <img src="${pageContext.request.contextPath}/picture/${news1.photo }" alt="" /></a>
            <div class="info" >
                <h2 class='banner_Pro'><a href="${pageContext.request.contextPath}/user/news/newsID.html?id=${news1.id}" >${news1.title }</a></h2>
            </div>
        </div>
        </c:otherwise></c:choose>
        <c:choose><c:when test="${news2.photo eq '' or news2.photo eq null}"></c:when>
        <c:otherwise>
        <!-- Second Content -->
        <div id="fragment-2" class="ui-tabs-panel ui-tabs-hide" style="">
            <img src="${pageContext.request.contextPath}/picture/${news2.photo }" alt="" />
            <div class="info" >
                <h2><a href="${pageContext.request.contextPath}/user/news/newsID.html?id=${news2.id}" >${news2.title }</a></h2>
            </div>
        </div>
        </c:otherwise></c:choose>
        <c:choose><c:when test="${news3.photo eq '' or news3.photo eq null}"></c:when>
        <c:otherwise>
        <!-- Third Content -->
        <div id="fragment-3" class="ui-tabs-panel ui-tabs-hide" style="">
            <img src="${pageContext.request.contextPath}/picture/${news3.photo }" alt="" />
            <div class="info" >
                <h2><a href="${pageContext.request.contextPath}/user/news/newsID.html?id=${news3.id}" >${news3.title }</a></h2>
            </div>
        </div>
        </c:otherwise></c:choose>
        <c:choose><c:when test="${news4.photo eq '' or news4.photo eq null}"></c:when>
        <c:otherwise>
        <!-- Fourth Content -->
        <div id="fragment-4" class="ui-tabs-panel ui-tabs-hide" style="">
            <img src="${pageContext.request.contextPath}/picture/${news4.photo }" alt="" />
            <div class="info" >
                <h2><a href="${pageContext.request.contextPath}/user/news/newsID.html?id=${news4.id}" >${news4.title }</a></h2>
            </div>
        </div>
        </c:otherwise></c:choose>
    </div>
<table class="cbox boxcenter" border="0" cellspacing="0" cellpadding="0">
    <tbody>
     <tr>
        <td cellspacing="8" width="224" valign="top" style="margin-right: 8px">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="ibox11 magb6">
                <tbody>
                <tr>
                    <td height="168" valign="top">
                        <dl class="ibox12">
                            <dt>项目产品推荐</dt>
                            <dd class="more12"><a href="${pageContext.request.contextPath}/user/recommend/recommends.html">更多&gt;&gt;</a></dd>
                        </dl>
                        <c:forEach items="${recommend}" var="list">
                        <ul class="ibox13 black12 p_p_Recom">
                            <dl><dt><a href="${pageContext.request.contextPath}/user/recommend/recommendID?id=${list.id}" target="_blank"><img src="${pageContext.request.contextPath}/picture/${list.photo}" width="203" height="122"></a></dt>
                            <dd class='index_Pro'><a href="${pageContext.request.contextPath}/user/recommend/recommendID?id=${list.id}" target="_blank" title="${list.title}">${list.title}</a></dd></dl>
                            <!--<dl><dt><a href="./201706/t20170619_22402.shtml" target="_blank"><img src="index/images/ban1.png" width="203" height="122"></a></dt><dd><a href="./201706/t20170619_22402.shtml" target="_blank" title="践行节能环保  崇尚绿色生活">践行节能环保  崇尚绿色生活</a></dd></dl>-->

                        </ul>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td><img src="./images/index19.gif" width="224" height="3"></td>
                </tr>
                </tbody>
            </table>
        </td>
        <td width="8px" height="100%" valign="top"  style="color: #fff">1</td>
        <td width="552" valign="top">
            <table class="ibox9" width="552" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td width="14" height="42" valign="top">&nbsp;</td>
                    <td width="110" align="center" valign="top" class="white14b lhctitle">资讯新闻</td>
                    <td width="375" valign="top">&nbsp;</td>
                    <td width="53" valign="top" class="more12 lhctitlem"><a href="${pageContext.request.contextPath}/user/news/newss.html">更多&gt;&gt;</a></td>
                </tr>
                
                <tr>
                    <td height="150" colspan="4" valign="top">
                     <c:forEach items="${news}" var="list">
                        <dl class="ibox10">
                            <dt class="black14"><a href="${pageContext.request.contextPath}/user/news/newsID.html?id=${list.id}" target="_blank" title="${list.title}">${list.title}</a></dt>
                            <dd><fmt:formatDate  value="${list.time}" type="both" pattern="yyyy.MM.dd HH:mm:ss" /></dd>
                        </dl>
                        </c:forEach>
                    </td>
                </tr>
                </tbody></table>
            <table class="ibox9" width="552" border="0" cellspacing="0" cellpadding="0">
                <tbody><tr>
                    <td width="14" height="44" valign="top">&nbsp;</td>
                    <td width="110" align="center" valign="top" class="white14b lhctitle">活动安排</td>
                    <td width="375" valign="top">&nbsp;</td>
                    <td width="53" valign="top" class="more12 lhctitlem"><a href="${pageContext.request.contextPath}/user/activity/activitys.html">更多&gt;&gt;</a></td>
                </tr>
                <tr>
                    <td height="150" colspan="4" valign="top">
                    <c:forEach items="${activity}" var="list">
                        <dl class="ibox10">
                            <dt class="black14"><a href="${pageContext.request.contextPath}/user/activity/activityID.html?id=${list.id}" target="_blank" title="${list.title}">${list.title}</a></dt>
                            <dd><fmt:formatDate  value="${list.time}" type="both" pattern="yyyy.MM.dd HH:mm:ss" /></dd>
                        </dl>
                        </c:forEach>
                    </td>
                </tr>
                </tbody></table>
         </td>
        <td width="8" valign="top" style="color: #fff">1</td>
        <td width="210" valign="top">
            <table class="ibox3 magb7" border="0" cellspacing="0" cellpadding="0" style="margin-top:2px;">
                <tbody><tr>
                    <td height="182" valign="top">
                    <c:if test="${sessionScope.user eq null}">
                        <dl class="ibox4 magb6">
                            <dt>登录</dt>
                            <dd class="more12"></dd>
                        </dl>
                        </c:if>
                        <c:if test="${sessionScope.user ne null}">
                        <dl class="ibox4 magb6">
                            <dt>已登录</dt>
                            <dd class="more12"></dd>
                        </dl>
                        </c:if>
                        <c:if test="${sessionScope.user ne null}" >
                        <div class='login_After'>
							<a href='${pageContext.request.contextPath}/user/indes/look.html'> <img
								src="${pageContext.request.contextPath}/picture/${sessionScope.user.headPhoto}">
							</a>
						</div>
						 <span class='forum_name'>你好,${sessionScope.user.name eq null? sessionScope.user.account:sessionScope.user.name}</span>
                         <a href='${pageContext.request.contextPath}/user/indes/Exit.html' class='quit_Login'>退出登录</a>
                        </c:if>
                        <c:if test="${sessionScope.user eq null}">
                        <form action="" method="post" id="login_Lo">
                            <ul class="ibox20 black12 log_partial">
                                <li>用户名:<input type="text" class="login_Inp login_val"/></li>
                                <li>密&ensp;&ensp;码:<input type="password" class="login_Inp pass_val"/></li>
                                <li>验证码:<input type="text"  class="show_code"/><a id="check_Code" onclick="createCode()" href="javascript:;" title="点击换一张"></a></li>
                                <li>
                                    <span class="log log_button">登录${sessionScope.user.name}</span>
                                    <a href="javascript:;" class="forget">忘记密码</a><br>
                                </li>
                            </ul>
                        </form>
                        </c:if>
                         <!--头像模块 -->
				        <!--头像模块 -->
                    </td>
                </tr>
                <tr>
                    <td><img src="./images/index11.gif" width="210" height="3"></td>
                </tr>
                </tbody></table>


            <table class="ibox3 magb7" border="0" cellspacing="0" cellpadding="0" style="margin-top:2px;">
                <tbody><tr>
                    <td height="200" valign="top">
                        <dl class="ibox4 magb7">
                            <dt>注册</dt>
                            <dd class="more12"></dd>
                        </dl>
                        <form action="" method="post" id="check_reg" autocomplete="off">
                        <ul class="ibox20 black12 log_partial">
                            <li>&ensp;&ensp;用户名:<input type="text" class="login_Inp reg_user_val"/></li>
                            <li>密&ensp;&ensp;&ensp;&ensp;码:<input type="password" class="login_Inp reg_pass_old_val"/></li>
                            <li>确认密码:<input type="password" class="login_Inp reg_pass_age_val"/></li>
                            <li>手机号码:<input type="text" class="login_Inp reg_iph_val"/></li>
                            <li class="res_bott">
                                <span class="re reg reg_button">注册</span>
                                <input type="reset" class="re" value="重置"/>
                            </li>
                        </ul>
                        </form>
                       

                        
                    </td>
                </tr>
                <tr>
                    <td><img src="./images/index11.gif" width="210" height="3"></td>
                </tr>
                </tbody></table>


            <table class="ibox3 magb7" border="0" cellspacing="0" cellpadding="0" style="margin-top:2px;">
                <tbody><tr>
                    <td height="173" valign="top">
                        <dl class="ibox4 magb7">
                            <dt>通知公告</dt>
                            <dd class="more12"><a href="${pageContext.request.contextPath}/user/inform/informs.html">更多&gt;&gt;</a></dd>
                        </dl>
                        <c:forEach items="${inform}" var="list">
                        <ul class="ibox20 black12">
                            <li>·<a href="${pageContext.request.contextPath}/user/inform/informID.html?id=${list.id}" target="_blank" title="${list.title }">${list.title }</a></li>                         
                        </ul>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td><img src="./images/index11.gif" width="210" height="3"></td>
                </tr>
                </tbody></table>

        </td>
    </tr>
    </tbody>
</table>
<!--标题-->
<table class="fabu scroll" width="1002" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
        <td width="14" height="44" valign="top">&nbsp;</td>
        <td width="110" align="center" valign="top" class="white14b lhctitle">文献展示</td>
        <td width="375" valign="top">&nbsp;</td>
        <td width="53" valign="top" class="more12 lhctitlem"><a href="${pageContext.request.contextPath}/user/literature/literatures.html">更多&gt;&gt;</a></td>
    </tr>
    <tr>
        <td height="150" colspan="4" valign="top">
        
            <!--无缝滚动-->
            <div id="ScrollBox" class="con1_imgs">
                <ul style="width: 4880px;">
                <c:forEach items="${literature}" var="list">
                    <li> <a href="${pageContext.request.contextPath}/user/literature/literatureID.html?id=${list.id}" title="${list.title }" class="con1_imgs_border"><img src="${pageContext.request.contextPath}/picture/${list.photo }" width="220" height="220" class="PicAuto" alt="${list.title }" style="padding: 0px;"></a>
                        <p><a href="${pageContext.request.contextPath}/user/literature/literatureID.html?id=${list.id}" title="${list.title }">${list.title }</a></p>
                    </li>
                      </c:forEach>
                </ul>   
            </div>
        </td>
    </tr>
    </tbody></table>


<style>
    td{font-size:12px;}
</style>
<jsp:include page='comm_bottom.jsp' />
<%-- <script src="${pageContext.request.contextPath}/static/user/forum/js/jquery-1.9.1.min.js"></script> --%>
    <script src="${pageContext.request.contextPath}/static/user/index/js/check.js" type=text/javascript></script>
    <!--顶部轮播图所需-->
    <script src="${pageContext.request.contextPath}/static/user/index/js/jquery-ui.min.js" type=text/javascript></script>
    <script src="${pageContext.request.contextPath}/static/user/index/js/top_banner.js" type=text/javascript></script>
    <script src="${pageContext.request.contextPath}/static/user/index/js/LiScroll.js"></script>
    <script src="${pageContext.request.contextPath}/static/user/index/js/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/static/user/index/js/creadCode.js" type=text/javascript></script>
<script src="${pageContext.request.contextPath}/static/user/index/js/switch.js"></script>
<script src="${pageContext.request.contextPath}/static/user/index/js/layer/layer.js"></script>
</body>
</html>
