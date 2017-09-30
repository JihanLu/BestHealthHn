<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>联系我们</title>
<link href="${pageContext.request.contextPath}/static/user/about/css/css.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/user/about/css/style.css" rel="stylesheet" type="text/css">
</head>

<body background="${pageContext.request.contextPath}/static/user/no_Annou/images/bg.gif" bgproperties="fixed" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('/images/home1.gif','/images/selgserver1.gif','/images/selgserver3.gif')" class="abg">
 <jsp:include page='comm_top.jsp' />
<table width="1002" height="298" border="0" align="center" cellpadding="0" cellspacing="0" background="../../images/lbg.gif" bgcolor="#FFFFFF" class="boxcenter">
  <tr valign="top"> 
 
    <td width="763"><table width="1002" height="57" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou/images/dirs.gif">
        <tr> 
          <td width="62">&nbsp;</td>
          <td width="701" valign="top" class="dir12" style="padding-top:15px;">您现在的位置：<a href="${pageContext.request.contextPath}/user/index/home.html">贝仕特首页</a>-&gt;<a href="${pageContext.request.contextPath}/user/about/abouts.html">联系我们</a></td>
        </tr>
      </table>
      <table width="1002" height="65" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou/images/btoplbgg.gif">
        <tr> 
          <td width="210" height="65">&nbsp;</td>
          <td width="317" align="center" valign="top" class="h14b" style="padding-top:20px;">联系我们</td>
          <td width="236">&nbsp;</td>
        </tr>
      </table>
      <table width="763" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou/images/clbg.gif">
        <tr valign="top"> 
          <td width="25">&nbsp;</td>
          <td width="693" style="padding-bottom:14px;">
          <table width="986" border="0" cellpadding="0" cellspacing="0" background="" class='about'> 
             <tr><td>${about.content}</td></tr>  	
            </table>
            </td>
          
        </tr>
      </table>
      
      <table width="1002" height="51" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/introduce/images/bkhg.gif" style="margin-bottom:18px;">
        <tr> 
          <td width="13">&nbsp;</td>
          <td width="711" align="center" class="h14b">
		  </td>
          <td width="39">&nbsp;</td>
        </tr>
      </table>
      </td>
  </tr>
</table>

<jsp:include page='comm_bottom.jsp' />
</body>
</html>