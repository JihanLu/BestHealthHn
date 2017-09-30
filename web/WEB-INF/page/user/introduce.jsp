<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle}</title>
<link href="${pageContext.request.contextPath}/static/user/introduce/css/style.css" rel="stylesheet" type="text/css">
</head>
<body background="" bgproperties="fixed" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" class="abg">
 <jsp:include page='comm_top.jsp' />
      <table width="1002" height="57" class='intro_auot' border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/introduce/images/dirs.gif">
        <tr> 
          <td width="62">&nbsp;</td>
          <td width="701" valign="top" class="dir12" style="padding-top:13px;">您现在的位置：<a href="${pageContext.request.contextPath}/user/index/home.html" class='dir12'>贝仕特首页</a>-&gt;<a href="${pageContext.request.contextPath}/user/intro/selectAll.html?mark=${mark}" class='dir12'>${title }</a></td>
        </tr>
      </table>
      <table width="1002" height="65" border="0" class='intro_auot' cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/no_Annou/images/btoplbgg.gif">
        <tr> 
          <td width="210" height="65">&nbsp;</td>
          <td width="317" align="center" valign="top" class="h14b" style="padding-top:20px;">${title }</td>
          <td width="236">&nbsp;</td>
        </tr>
      </table>
      <table width="1002" border="0" cellpadding="0" class='intro_auot' cellspacing="0" background="${pageContext.request.contextPath}/static/user/introduce/images/clbg.gif">
        <tr valign="top"> 
          <td width="25">&nbsp;</td>
          <td width="693" style="padding-bottom:14px;">&nbsp;</td>
          <td width="45" align="right">&nbsp;</td>
        </tr>
        <tr valign="top">
          <td>&nbsp;</td> 
          <td style="font-size:14px;">
          ${intro.content} 
          </td>
          <td align="right">&nbsp;</td>
        </tr>
      </table>
      
      <table width="1002" height="51" border="0" cellpadding="0" class='intro_auot' cellspacing="0" background="${pageContext.request.contextPath}/static/user/introduce/images/bkhg.gif" style="margin-bottom:18px;">
        <tr>
          <td width="13">&nbsp;</td>
          <td width="711" align="center" class="h14b">
          </td>
          <td width="39">&nbsp;</td>
        </tr>
      </table>
<jsp:include page='comm_bottom.jsp' />
</body>
</html>