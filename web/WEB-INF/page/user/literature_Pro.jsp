<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>文献展示</title>
<link href="${pageContext.request.contextPath}/static/user/pro_Pro/css/style.css" rel="stylesheet" type="text/css" />
</head>
 <jsp:include page='comm_top.jsp' />
<body class="abg">
    <td width="1002">
    <table width="1002" height="57" class='pro_main' border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/pro_Pro/images/dirs.gif">
      <tr>
        <td width="62">&nbsp;</td>
        <td width="701" valign="top" class="dir12" style="padding-top:12px;">您现在的位置：<a href="${pageContext.request.contextPath}/user/index/home.html">贝仕特首页</a>-&gt;<a href="${pageContext.request.contextPath}/user/literature/literatures.html">文献展示</a></td>
      </tr>
    </table>
      <table width="1002" height="62" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/pro_Pro/images/btoplbgg.gif" class='pro_main'>
        <tr>
          <td width="219" height="62">&nbsp;</td>
          <td width="308" align="center" valign="top" class="h14b" style="padding-top:16px;">文献展示</td>
          <td width="236">&nbsp;</td>
        </tr>
      </table>
      <table width="1002" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/pro_Pro/images/clbg.gif" class='pro_main'>
        <tr valign="top">
          <td width="32">&nbsp;</td>
          <td width="720" class="picstyle">
          <c:forEach items="${literature}" var="list">
          <dl>
          <dt>
            <a href="${pageContext.request.contextPath}/user/literature/literatureID.html?id=${list.id}" target="_blank" title="${list.title}" target="_blank"><img src="${pageContext.request.contextPath}/picture/${list.photo }" width=203 height=122></a></dt>
          <dd class='pro_Pro_sheng'>
            <a href="${pageContext.request.contextPath}/user/literature/literatureID.html?id=${list.id}" target="_blank" title="${list.title}" target="_blank" title="${list.title }">${list.title }</a>
          </dd>
          </dl></c:forEach>
          <div class="csline"><img src="${pageContext.request.contextPath}/static/user/pro_Pro/images/csline.gif" width="690" height="28"></div>
          </td>
          <td width="11" align="right">&nbsp;</td>
        </tr>
    </table>
    <table width="1002" height="51" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/introduce/images/bkhg.gif" style="margin-bottom:18px;" class='pro_main'>
        <tbody><tr> 
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
	document.write("<a href="+"${pageContext.request.contextPath}/user/literature/literatures.html?PAGENOW="+ 1 +"\ title=\"首页\">"+imgIndex+"</a>&nbsp;<a href="+"${pageContext.request.contextPath}/user/literature/literatures.html?PAGENOW="+ prevPage + "\ title=\"上一页\">"+imgPrev+"</a>&nbsp;");
else if(countPage>1&&currentPage!=0&&currentPage==1)
	document.write("<a href="+"${pageContext.request.contextPath}/user/literature/literatures.html?PAGENOW="+imgIndex+"</a>&nbsp;<a href=\"#\">"+imgPrev+"</a>&nbsp;");
else
	document.write(imgIndex+"&nbsp;"+imgPrev+"&nbsp;");
//循环
var num = 5;
for(var i=0+(currentPage-1-(currentPage-1)%num) ; i<=(num+(currentPage-1-(currentPage-1)%num))&&(i<countPage) ; i++){
	if(i+1==1){
		document.write("<a href="+"${pageContext.request.contextPath}/user/literature/literatures.html?PAGENOW="+ (i+1) +"\ title=\"\">"+(i+1)+"</a>&nbsp;"); 
	}else if(currentPage!=i+1){

		document.write("<a href="+"${pageContext.request.contextPath}/user/literature/literatures.html?PAGENOW="+ (i+1) +"\ title=\"\">"+(i+1)+"</a>&nbsp;"); 
	}else{
		document.write((i+1)+"&nbsp;");
	}
}

//设置下一页代码 
if(countPage>0&&currentPage!=(countPage))
	document.write("<a href="+"${pageContext.request.contextPath}/user/literature/literatures.html?PAGENOW="+ nextPage +"\ title=\"下一页\">"+imgNext+"</a>&nbsp;<a href="+"${pageContext.request.contextPath}/user/literature/literatures.html?PAGENOW="+ countPage + "\ title=\"最后一页\">"+imgLast+"</a>&nbsp;");
else
	document.write(imgNext+"&nbsp;"+imgLast+"&nbsp;");
            </script>
		  </td>
          <td width="39">&nbsp;</td>
        </tr>
      </tbody></table>
<style>
td{font-size:12px;}
</style>
<script src='${pageContext.request.contextPath}/static/user/activity_arr/js/check_Page.js'></script>
<jsp:include page='comm_bottom.jsp' />
</body>
</html>