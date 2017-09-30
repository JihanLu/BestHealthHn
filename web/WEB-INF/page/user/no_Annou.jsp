<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>通知公告</title>
<link href="${pageContext.request.contextPath}/static/user/no_Annou/css/css.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/user/no_Annou/css/style.css" rel="stylesheet" type="text/css">
</head>

<body background="${pageContext.request.contextPath}/static/user/no_Annou/images/bg.gif" bgproperties="fixed" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('/images/home1.gif','/images/selgserver1.gif','/images/selgserver3.gif')" class="abg">
 <jsp:include page='comm_top.jsp' />
<table width="1002" height="298" border="0" align="center" cellpadding="0" cellspacing="0" background="../../images/lbg.gif" bgcolor="#FFFFFF" class="boxcenter">
  <tr valign="top"> 
 
    <td width="763"><table width="1002" height="57" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou/images/dirs.gif">
        <tr> 
          <td width="62">&nbsp;</td>
          <td width="701" valign="top" class="dir12" style="padding-top:15px;">您现在的位置：<a href="${pageContext.request.contextPath}/user/index/home.html">贝仕特首页</a>-&gt;<a href="${pageContext.request.contextPath}/user/inform/informs.html">通知公告</a></td>
        </tr>
      </table>
      <table width="1002" height="65" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou/images/btoplbgg.gif">
        <tr> 
          <td width="210" height="65">&nbsp;</td>
          <td width="317" align="center" valign="top" class="h14b" style="padding-top:20px;">通知公告</td>
          <td width="236">&nbsp;</td>
        </tr>
      </table>
      <table width="763" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou/images/clbg.gif">
        <tr valign="top"> 
          <td width="25">&nbsp;</td>
          <td width="693" style="padding-bottom:14px;">
          <table width="986" border="0" cellpadding="0" cellspacing="0" background="">
              <c:forEach items="${inform1}" var="list">
			  <tr valign="top"> 
                <td width="138" height="28" class='icon'>&nbsp;<img src='${pageContext.request.contextPath}/static/user/no_Annou/images/dott1.png'>&ensp;</td>
                <td width="527" class="out14" style="padding-right:10px"><a href="${pageContext.request.contextPath}/user/inform/informID.html?id=${list.id}" target="_blank" title="${list.title}" target="_blank" title="${list.title }" class='out14'>${list.title }</a></td>
                <td width="205" class="h12" style="padding-top:3px;"><fmt:formatDate  value="${list.time}" type="both" pattern="yyyy.MM.dd HH:mm:ss" /></td>
              </tr>	
              </c:forEach>
            </table>
            </td>
          
        </tr>
      </table>
      
      <table width="1002" height="51" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou/images/bkhg.gif" style="margin-bottom:18px;">
        <tr> 
          <td width="13">&nbsp;</td>
          <td width="711" align="center" class="h14b ch">
          <input type="hidden" value="${currentPage}" id="p" style="width: 20px">
          <input id='totPage' value='${countPage}' type="hidden"/>
		  <script language="JavaScript">
var currentPage=${currentPage};//所在页从1开始
var prevPage = currentPage-1//上一页
var nextPage = currentPage+1//下一页
var countPage = ${countPage};//共多少页

var imgIndex= "<img src="+"${pageContext.request.contextPath}/static/user/activity_arr/images/j1.gif width=28 height=24 border=0 align=absmiddle>";
var imgPrev = "<img src="+"${pageContext.request.contextPath}/static/user/activity_arr/images/j2.gif width=36 height=24 border=0 align=absmiddle>";
var imgNext = "<img src="+"${pageContext.request.contextPath}/static/user/activity_arr/images/j3.gif width=36 height=24 border=0 align=absmiddle>";
var imgLast = "<img src="+"${pageContext.request.contextPath}/static/user/activity_arr/images/j4.gif width=28 height=24 border=0 align=absmiddle>";

//document.write("共"+countPage+"页&nbsp;&nbsp;");
//设置上一页代码
if(countPage>1&&currentPage!=0&&currentPage!=1)
	document.write("<a href="+"${pageContext.request.contextPath}/user/inform/informs.html?PAGENOW="+ 1 +"\ title=\"首页\">"+imgIndex+"</a>&nbsp;<a href="+"${pageContext.request.contextPath}/user/inform/informs.html?PAGENOW="+ prevPage + "\ title=\"上一页\">"+imgPrev+"</a>&nbsp;");
else if(countPage>1&&currentPage!=0&&currentPage==1)
	document.write("<a href="+"${pageContext.request.contextPath}/user/inform/informs.html?PAGENOW="+imgIndex+"</a>&nbsp;<a href=\"#\">"+imgPrev+"</a>&nbsp;");
else
	document.write(imgIndex+"&nbsp;"+imgPrev+"&nbsp;");
//循环
var num = 5;
for(var i=0+(currentPage-1-(currentPage-1)%num) ; i<=(num+(currentPage-1-(currentPage-1)%num))&&(i<countPage) ; i++){
	if(i+1==1){
		document.write("<a href="+"${pageContext.request.contextPath}/user/inform/informs.html?PAGENOW="+ (i+1) +"\ title=\"\">"+(i+1)+"</a>&nbsp;"); 
	}else if(currentPage!=i+1){

		document.write("<a href="+"${pageContext.request.contextPath}/user/inform/informs.html?PAGENOW="+ (i+1) +"\ title=\"\">"+(i+1)+"</a>&nbsp;"); 
	}else{
		document.write((i+1)+"&nbsp;");
	}
}

//设置下一页代码 
if(countPage>0&&currentPage!=(countPage))
	document.write("<a href="+"${pageContext.request.contextPath}/user/inform/informs.html?PAGENOW="+ nextPage +"\ title=\"下一页\">"+imgNext+"</a>&nbsp;<a href="+"${pageContext.request.contextPath}/user/inform/informs.html?PAGENOW="+ countPage + "\ title=\"最后一页\">"+imgLast+"</a>&nbsp;");
else
	document.write(imgNext+"&nbsp;"+imgLast+"&nbsp;");
            </script>
		  </td>
          <td width="39">&nbsp;</td>
        </tr>
      </table>
      </td>
  </tr>
</table>
<script src='${pageContext.request.contextPath}/static/user/activity_arr/js/check_Page.js'></script>
<jsp:include page='comm_bottom.jsp' />
</body>
</html>