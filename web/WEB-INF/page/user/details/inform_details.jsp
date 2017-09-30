<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${object.title }</title>
<link href="${pageContext.request.contextPath}/static/user/no_Annou_details/css/css.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/user/no_Annou_details/css/style.css" rel="stylesheet" type="text/css">
</head>
    <jsp:include page='../comm_top.jsp' />
<body background="../../../images/bg-0097.gif" bgproperties="fixed" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('/images/home1.gif','/images/selgserver1.gif','/images/selgserver3.gif')" class="abg">

<table width="1002" height="74" border="0" align="center" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou_details/images/dir_detail.gif" class="boxcenter">
  <tr>
    <td width="1002" valign="top"><table width="942" height="57" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="132">&nbsp;</td>
          <td width="810" valign="top" class="dir12" style="padding-top:35px;">您现在的位置：<a href="${pageContext.request.contextPath}/user/index/home.html" class='dir12'>贝仕特首页</a>-&gt;<a href="${pageContext.request.contextPath}/user/inform/informs.html" class='dir12'>通知公告</a></td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="1002" height="343" border="0" align="center" cellpadding="0" cellspacing="0" background="/images/detail/cbg.gif" class="boxcenter">
  <tr>
    <td width="1002" align="center" valign="top" class="bgctop"><table width="75%" border="0" cellpadding="0" cellspacing="0" class="title20">
        <tr>
          <td width="932" align="center" valign="top" style="font-size:22px">${object.title }</td>
        </tr>
      </table>
      <table border="0" cellspacing="0" cellpadding="0" height="12" width="75%">
        <tr>
          <td background="/images/detail/ccdot.gif"></td>
        </tr>
      </table>
      <table width="632" height="47" border="0" cellpadding="0" cellspacing="0" class="inf12">
        <tr valign="top" style="padding-top:3px;"> 
          <td align="center">
		  时间：
		    <fmt:formatDate  value="${object.time}" type="both" pattern="yyyy.MM.dd HH:mm:ss" />&nbsp;&nbsp;&nbsp;
          
		  
				来源：${object.sources }&nbsp;&nbsp;&nbsp;
		  		  </td>
          <!--td width="188" align="right">浏览次数：</td-->
        </tr>
      <tr valign="top" style="padding-top:3px;">
		<td align="center" id="keywords">
		</td>
	</tr>
      </table>
      <table width="74%" height="21" border="0" cellpadding="0" cellspacing="0" class="t14l24">
      <tr><td align="center">
            </td>
      </tr>
      <tr>
        <td width="100%" valign="top" style="padding-left:45px;font-size:14px;"><style id=_Custom_Style_>
.h1 {
	FONT-WEIGHT: bold; TEXT-JUSTIFY: inter-ideograph; FONT-SIZE: 22pt; MARGIN: 17pt 0cm 16.5pt; LINE-HEIGHT: 240%; TEXT-ALIGN: justify
}
.h2 {
	FONT-WEIGHT: bold; TEXT-JUSTIFY: inter-ideograph; FONT-SIZE: 16pt; MARGIN: 13pt 0cm; LINE-HEIGHT: 173%; TEXT-ALIGN: justify
}
.h3 {
	FONT-WEIGHT: bold; TEXT-JUSTIFY: inter-ideograph; FONT-SIZE: 16pt; MARGIN: 13pt 0cm; LINE-HEIGHT: 173%; TEXT-ALIGN: justify
}
DIV.union {
	FONT-SIZE: 14px; LINE-HEIGHT: 18px
}
DIV.union TD {
	FONT-SIZE: 14px; LINE-HEIGHT: 18px
}

</style>${object.content }</td>
      </tr>
      <tr>
         <td width="100%" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td width="100%" valign="top">
          <div id=appendix><strong>附件：</strong><br><br></div>
       </td>
      </tr>
      </table>


	  <!--判断是否有来源-->
          <script language="JavaScript">













		  var objs = document.getElementById("source");
		  var appendix = document.getElementById("appendix");
                  var keywords = document.getElementById("keywords");  
		  function hide(obj){
			if(obj==null)return;
			if(obj.innerText.length<10){
				obj.style.display="none";	
		        }	
		  }
		  hide(objs);
		  hide(appendix);
                  hide(keywords);
	  </script>
    </td>
  </tr>
</table>
<table width="1002" border="0" align="center" cellpadding="0" cellspacing="0" class="boxcenter">
  <tr>
    <td width="1002"><img src="${pageContext.request.contextPath}/static/user/no_Annou_details/images/gb.gif" width="1002" height="43" border="0" usemap="#Map"></td>
  </tr>
</table>
<table width="1002" height="8" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td> </td>
  </tr>
</table>
<style>
td{font-size:12px;}
</style>
<jsp:include page='../comm_bottom.jsp' />
<map name="Map">
  <area shape="rect" coords="796,6,919,34" href="javascript:window.close()">
</map>

<map name="Map2">
  <area shape="rect" coords="850,64,989,93" href="http://en.cnis.gov.cn/" target="_blank">
</map>


</body>
</html>