<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link href="${pageContext.request.contextPath}/static/user/re_Pass/css/css.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/user/re_Pass/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/user/font/iconfont.css" rel="stylesheet" type="text/css">
</head>
<body background="" bgproperties="fixed" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('/images/home1.gif','/images/selgserver1.gif','/images/selgserver3.gif')" class="abg">
 <jsp:include page='comm_top.jsp' />
<table width="1002" height="298" border="0" align="center" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/forum/images/lbg.gif" bgcolor="#FFFFFF" class="boxcenter">
  <tr valign="top"> 
    <td width="239" class="bluebk" style="padding-bottom:110px;"><table width="239" height="90" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/forum/images/ltopbg.gif">
        <tr>
          <td width="239" valign="top"><table width="222" height="81" border="0" cellpadding="0" cellspacing="0" class="lb14b">
              <tr> 
                <td width="30">&nbsp;</td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!--频道-->
	  <jsp:include page='comm_left.jsp' />
   <!--     排行榜 -->
   
	  <!--频道-->
    </td>
    <td width="763"><table width="763" height="57" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/forum/images/dir.gif">
        <tr> 
          <td width="62">&nbsp;</td>
          <td width="701" valign="top" class="dir12" style="padding-top:15px;">您现在的位置：<a href="./../../">贝仕特首页</a>-&gt;<a href="./../">个人资料</a></td>
        </tr>
      </table>
      <table width="763" height="65" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/forum/images/btoplbg.gif">
        <tr> 
          <td width="210" height="65">&nbsp;</td>
          <td width="317" align="center" valign="top" class="h14b" style="padding-top:20px;">修改密码</td>
          <td width="236">&nbsp;</td>
        </tr>
      </table>
      <table width="763" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/forum/images/clbg.gif">
        <tr valign="top"> 
          <td width="25">&nbsp;</td>
          <td width="693" style="padding-bottom:14px;" class='fourum'>
               <div class="Contend-Lt-toux">
					
                	
						<span class='nick'>原密码：&ensp;&ensp;</span>
						<input type='text' class='old_pass'/><br/>
						<span class='nick'>手机号码：</span>
						<input type='text' class='old_iphone'/><br/>
						<span class='nick'>新密码：&ensp;&ensp;</span>
						<input type="password" class='new_pass'/>
						<div class='info_save'>修改</div>
				 
				</div>
				
                 
          </td>
          <td width="45" align="right">&nbsp;</td>
        </tr>
      </table>
      
      <table width="763" height="51" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/forum/images/bkh.gif">
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

<script src="${pageContext.request.contextPath}/static/user/index/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/user/re_Pass/js/forum.js"></script>
<jsp:include page='comm_bottom.jsp' />
</body>
</html>