<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人资料</title>
<link href="${pageContext.request.contextPath}/static/user/info/css/css.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/user/info/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/user/font/iconfont.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/user/info/css/sctx.css" rel="stylesheet" type="text/css">
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
	
    <%--   <jsp:include page='comm_left.jsp' /> --%>
   <!--     排行榜 -->
   
	  <!--频道-->
    </td>
    <td width="763"><table width="763" height="57" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/forum/images/dir.gif">
        <tr> 
          <td width="62">&nbsp;</td>
          <td width="701" valign="top" class="dir12" style="padding-top:15px;">您现在的位置：<a href="./../../">贝仕特首页</a>-&gt;<a href="./../">个人资料</a></td>
        </tr>
      </table>
      <table width="763" height="65" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/forum/images/btoplbg.gif">
        <tr> 
          <td width="210" height="65">&nbsp;</td>
          <td width="317" align="center" valign="top" class="h14b" style="padding-top:20px;">个人资料</td>
          <td width="236">&nbsp;</td>
        </tr>
      </table>
      <table width="763" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/user/forum/images/clbg.gif">
        <tr valign="top"> 
          <td width="25">&nbsp;</td>
          <td width="693" style="padding-bottom:14px;" class='fourum'>
               <div class="Contend-Lt-toux">
					<div class="Contend-Lt-touxx headPor"><img src="${pageContext.request.contextPath}/picture/${user.headPhoto}"> </div> 
                	<p> &nbsp;&nbsp;&nbsp; 登录名：${user.account}</p>
                	<form action="#" method='post' id='info_f'>
                	<input type="hidden" value="${user.userID}" id="userID">
						<span class='nick'>呢&ensp;&ensp;&ensp;&ensp;称：</span><input  type='text' value='${user.name }' class='info_nickName'/><br/>
						<span class='nick pass_olds'>密&ensp;&ensp;&ensp;&ensp;码：</span><input type='password' value='${user.password }' class='info_pass'/><br/>
						<!-- <span class='sex'>性别：&ensp;&ensp;&ensp;&ensp;</span>
						<input type='radio' value='男' name='sex' checked='checked'/>男
						<input type='radio' value='女' name='sex' />女<br/> -->
					<!-- 	<span class='sex'>职称：&ensp;&ensp;&ensp;&ensp;</span><input type='text' value='经理' class='info_nickName manager'/><br/> -->
						<span class='sex'>手机号码：</span><input type='text' value='${user.phone }' class='info_nickName iphne'/><br/>
						<div class='info_save'>保存</div>
				    </form>
				</div>
				
                 
          </td>
          <td width="45" align="right">&nbsp;</td>
        </tr>
      </table>
      
      <table width="763" height="51" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/forum/images/bkh.gif" style="margin-bottom:18px;">
        <tr> 
          <td width="13">&nbsp;</td>
          <td width="711" align="center" class="h14b">
		 
		  </td>
          <td width="39">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
  <!-- 头像部分  -->
           
             <div class="sctx" id="sctx">
            <div class="touTt"><p>头像设置</p><span class="sctxClose" id="sctxClose">╳</span></div>
            <div class="container">
                <div class="imageBox">
                    <div class="thumbBox"></div>
                    <div class="spinner" style="display: none">Loading...</div>
                </div>
                <div class="action">
                    <!-- <input type="file" id="file" style=" width: 200px">-->
                    <div class="new-contentarea tc">
                        <a href="javascript:void(0)" class="upload-img">
                            <label for="upload-file">本地上传</label>
                        </a>
                        <input type="file" class="" name="upload-file" id="upload-file" />
                    </div>
                    <input type="button" id="btnCrop"  class="Btnsty_peyton" value="确定">
                    <input type="button" id="btnZoomIn" class="Btnsty_peyton icon-plus"value="╊"  >
                    <input type="button" id="btnZoomOut" class="Btnsty_peyton" value="—" >
                </div>
                <div class="entOrNot">
                    <input type="button" id="ent"  class="ent entNot" value="保存">
                    <input type="button" id="not"  class="not entNot" value="取消">
                </div>
                <div class="cropped"></div>
            </div>
        </div>
        <!-- 头像部分  -->    
<div class="fixed"></div>
	<script
	src="${pageContext.request.contextPath}/static/user/forum/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/user/info/js/cropbox.js"></script>
<script src="${pageContext.request.contextPath}/static/user/index/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/user/info/js/forum.js"></script>
<jsp:include page='comm_bottom.jsp' />
</body>
</html>