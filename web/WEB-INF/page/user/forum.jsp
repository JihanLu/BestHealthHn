<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>论坛首页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/static/h-ui/css/pageSty.css" />

<link href="${pageContext.request.contextPath}/static/user/forum/css/css.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/user/forum/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/user/forum/js/wangEditor/dist/css/wangEditor.min.css" />	
</head>
<body background="" bgproperties="fixed" leftmargin="0" topmargin="0"
	marginwidth="0" marginheight="0"
	onLoad="MM_preloadImages('/images/home1.gif','/images/selgserver1.gif','/images/selgserver3.gif')"
	class="abg">
	<jsp:include page='comm_top.jsp' />
	<table width="1002" height="298" border="0" align="center"
		cellpadding="0" cellspacing="0"
		background="${pageContext.request.contextPath}/static/user/forum/images/lbg.gif"
		bgcolor="#FFFFFF" class="boxcenter">
		<tr valign="top">
			<td width="239" class="bluebk" style="padding-bottom: 110px;"><table
					width="239" height="90" border="0" cellpadding="0" cellspacing="0"
					background="${pageContext.request.contextPath}/static/user/forum/images/ltopbg.gif">
					<tr>
						<td width="239" valign="top"><table width="222" height="81"
								border="0" cellpadding="0" cellspacing="0" class="lb14b">
								<tr>
									<td width="30">&nbsp;</td>
									<td width="190" align="center" valign="top"
										style="padding-top: 44px;">账号登录</td>
								</tr>
							</table></td>
					</tr>
				</table> <!--频道--> <!-- 登录模块 -->
				  <c:if test="${sessionScope.user eq null}" >
				
				<form action="${pageContext.request.contextPath}/user/indes/login.html" method="post" id="login_Lo">
					<ul class="ibox20 black12 log_partial">
						<li>用户名：<input type="text" name="account" class="login_Inp login_val"></li>
						<li>密&ensp;&ensp;码：<input type="password" name="password" class="login_Inp pass_val"></li>
						<li>验证码：<input type="text" class="show_code"><a
							id="check_Code" onclick="createCode()" href="javascript:;"
							title="点击换一张" class="code"></a></li>
						<li><span class="log log_button">登录</span> <a
							href="${pageContext.request.contextPath}/user/indes/forget.html" class="forget">忘记密码</a></li>
						<c:if test="${!empty mess}">
							<li>${mess}</li>
						</c:if>
					</ul>
				</form> <!-- 登录模块 -->
				</c:if>
				 <!--头像模块 -->
				<c:if test="${!empty sessionScope.user}">
				<div class='login_After'>
					<a href='${pageContext.request.contextPath}/user/indes/look.html'> <img
						src="${pageContext.request.contextPath}/picture/${sessionScope.user.headPhoto}">
					</a>
				</div> <span class='forum_name'>你好,${sessionScope.user.name eq null? sessionScope.user.account:sessionScope.user.name}</span> <!--头像模块 -->
				</c:if>
			    <!-- 注册模块 -->
				<form action="" method="post" id="check_reg" autocomplete="off">
                        <ul class="ibox20 black12 log_partial">
                            <li>用&ensp;户&ensp;名：<input type="text" class="login_Inp reg_user_val"/></li>
                            <li>密&ensp;&ensp;&ensp;&ensp;码：<input type="password" class="login_Inp reg_pass_old_val"/></li>
                            <li>确认密码：<input type="password" class="login_Inp reg_pass_age_val"/></li>
                            <li>手机号码：<input type="text" class="login_Inp reg_iph_val"/></li>
                            <li class="res_bott">
                            
                            	 <c:if test="${sessionScope.user ne null}" >
                                <span class="forum_Quit_Login">退出登录</span>
                                </c:if>
                                <span class="re reg reg_button">注册</span>
                                <input type="reset" class="re" value="重置"/>
                            </li>
                        </ul>
                        </form>
				<!-- 注册模块 -->
				
				
				<table class="c-table opr-toplist-table">
					<thead>

					</thead>

					

				</table> <!--频道--></td>
			<td width="763"><table width="763" height="57" border="0"
					cellpadding="0" cellspacing="0"
					background="${pageContext.request.contextPath}/static/user/forum/images/dir.gif">
					<tr>
						<td width="62">&nbsp;</td>
						<td width="701" valign="top" class="dir12"
							style="padding-top: 15px;">您现在的位置：<a href="${pageContext.request.contextPath}/user/index/home.html">贝仕特首页</a>-&gt;<a
							href="${pageContext.request.contextPath}/user/luntan/selectTopic.html">论坛</a></td>
					</tr>
				</table>
				<table width="763" height="65" border="0" cellpadding="0"
					cellspacing="0"
					background="${pageContext.request.contextPath}/static/user/forum/images/btoplbg.gif">
					<tr>
						<td width="210" height="65">&nbsp;</td>
						<td width="317" align="center" valign="top" class="h14b"
							style="padding-top: 20px;">论坛</td>
						<td width="236">&nbsp;</td>
					</tr>
				</table>
				<table width="763" border="0" cellpadding="0" cellspacing="0"
					background="${pageContext.request.contextPath}/static/user/forum/images/clbg.gif">
					<tr valign="top">
						<td width="25">&nbsp;</td>
						<td width="693" style="padding-bottom: 14px;" class='fourum'>

							<form action='' method='post'>
								<div class='forum_M'>

									<div class='fourun_main'>
										<!-- <span class='forum_t'>标题：</span><input type='text'
											class='forum_Title' /> -->
										<div class='edi'>
											<div id="editor"></div>
										</div>
										<input type='button' value='发布'
											class="edi_sub forun_right" />
									</div>

								</div>
							</form> <!--   动态模块 -->
							
							
							<c:forEach items="${luntanlist}" var="topic">
							
							<div class="content_div">
							   <input type="hidden" id="topicID" name="topicID" value="${topic.topicID }">
								<div class='forum_ma'>
									<div class="content_xinxi" data-currId='${topic.fa_ID}'>
										<div class="touxiang">
											<img
												src="${pageContext.request.contextPath}/picture/${topic.userPhoto}">
										</div>
										<div class="owenBen">
											<div class="userName">
												<span> <a href="#">${topic.name}</a>
												</span> <span class="down icon-chevron-down"> </span>
											</div>
											<div class="shijian">
												<a href="#">${topic.time}</a>
											</div>
											<div class="textContent">${topic.content}​​​​</div>
											<div class="picture">
												<div class="picture_box">
													<ul class="imgs"></ul>
												</div>
											
											</div>
										</div>

										 <span class='forum_seo'> 
											<!-- <span>3</span>  -->
											<span class='shouqi'>
											      <span>收起<img src='${pageContext.request.contextPath}/static/user/forum/images/up.png'></span>
											      <span class='zk'>展开<img src='${pageContext.request.contextPath}/static/user/forum/images/down.png'></span>
											</span>
										</span> 
									</div>

									<!--   回复 -->
									 <input class='forum_po' /> <span class='user_forum'
										data-id='${sessionScope.user.userID}'>发布</span> 
										<%-- <img
										src='${pageContext.request.contextPath}/static/user/forum/images/san.png'
										class='forum_Img' />  --%>
									<!--   回复 -->
									<!--   用户回复区域 -->
									<c:forEach items="${topic.replyOne}" var="replyOne"> 
									
									
									<div class='user_forum_rang'>
									<input type="hidden" id="replyOneid" value="${replyOne.replyOneId}">
										<div class="content_xinxi one_con">
											<div class="touxiang">
												<img
													src="${pageContext.request.contextPath}/picture/${replyOne.replyUserPhoto}">
											</div>
											<div class="owenBen">
												<div class="userName">
													<span> <a href="#" data-userID='${replyOne.huifuID}'>${replyOne.replyName}</a> 回复<a
														href="javascript:;" data-forumID='${replyOne.beihuifuID}'>${replyOne.replyName1}</a>
													</span> <span class="down icon-chevron-down">
														<div class="downDiv"></div>
													</span>
												</div>
												<div class="shijian">
													<a href="javascript:;">${replyOne.replyTime}</a>
												</div>
												<div class="textContent user_forum_mess">${replyOne.replyContent}​​​​</div>
												<span class='forUs  one_forum'>回复</span>
												<!--   发布输入框 -->
													<!-- <div class='thred_main'>
														<input type='text' class='thred_Input'> <span
															class="thredd_user_forum">发布</span>
													</div> -->
												<!--   发布输入框 -->
											</div>
											<!--  二级用户回复输入框 -->
											 <div class='second_Main'>
												<input class='second_Input' /> <span
													class="second_user_forum">发布</span>
											</div>
											<!-- 二级回复 -->
									<c:forEach items="${replyOne.replyTow}" var="replyTow">
									 <div class="content_xinxi second_forun ">
									 					<%-- <input type="hidden" id="replyOneid" value="${replyTow.treplyOneId}"> --%>
												<div class="touxiang">
													<img
														src="${pageContext.request.contextPath}/picture/${replyTow.treplyUserPhoto}">
												</div>
												<div class="owenBen second_owenBen">
													<div class="userName">
														<span> <a href="#" data-forumid="${replyTow.thuifuID}"
															class='thredd_fo'>${replyTow.treplyName}</a>回复<a href="#"
															class='thredd_use' data-userid="${replyTow.tbeihuifuID}">${replyTow.treplyName1}</a>
														</span> 
													</div>
													<div class="shijian">
														<a href="javascript:;">${replyTow.treplyTime}</a>
													</div>
													<div class="textContent user_forum_mess">${replyTow.treplyContent}​​​​</div>
													<span class="forUs second_forum_fit">回复</span>
													<!--   发布输入框 -->
													<div class='thred_main'>
														<input type='text' class='thred_Input'> <span
															class="thredd_user_forum" data-id="">发布</span>
													</div>
													<!--   发布输入框 -->
													<div class="picture">
														<div class="picture_box">
															<ul class="imgs"></ul>
														</div>
														<div class="big_picBox hidden">
															<div class="big_wimglst">
																<div class="big_imgbox">
																	<ul></ul>
																</div>
															</div>
															<div class="spc_10"></div>
														</div>
													</div>
												</div>
											</div>  
											</c:forEach> 
											<!--    二级回复 -->
										</div>
									</div>
									
									</c:forEach>
									<!--   用户回复区域 -->
								</div>
							</div>
							</c:forEach>
							
							
							
						</td>
						<td width="45" align="right">&nbsp;</td>
					</tr>
				</table>




				<table width="763" height="51" border="0" cellpadding="0"
					cellspacing="0"
					background="${pageContext.request.contextPath}/static/user/forum/images/bkh.gif"
					style="margin-bottom: 18px;">
					<tr>
						<td width="13">&nbsp;</td>
						<td width="711" align="center" class="h14b"></td>
						<td width="39">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
	</table>
	
	<c:if test="${totalPage >1}">
								<div class="fanyue">
									<div class="list-page">
									<c:if test="${pageNow != 1}">
										<a title="${pageNow-1}" class="pageStyle"> 上一页 </a>
									</c:if>
									<!-- 页数列表 -->
									<c:forEach var="n"
										begin="${pageNow>4?pageNow+5>totalPage?totalPage>10?totalPage-9:1:pageNow-4:1}"
										end="${pageNow>4?pageNow+5>totalPage?totalPage:pageNow+5:totalPage>10?10:totalPage}">
										<c:choose>
											<c:when test="${n == pageNow}">
												<span title="${n}" class="currentPage pageStyle">${n}</span>
											</c:when>
											<c:otherwise>
												<a title="${n}" class="pageStyle">${n}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<!-- 下一页 -->
									<c:if test="${pageNow != totalPage}">
										<a title="${pageNow+1}" class="pageStyle"> 下一页 </a>
									</c:if>
								    </div>
								</div>
							</c:if>
	<form action="${pageContext.request.contextPath}/user/luntan/selectTopic.html" method="post" id="pageform"></form>
	
	
	
	
	
	
	
	<jsp:include page='comm_bottom.jsp' />
	<script
		src="${pageContext.request.contextPath}/static/user/forum/js/select.js"></script>
		<script
	src="${pageContext.request.contextPath}/static/user/index/js/creadCode.js"></script>
	<script
	src="${pageContext.request.contextPath}/static/user/forum/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/user/forum/js/check.js"
	type=text/javascript></script>
<script
	src="${pageContext.request.contextPath}/static/user/index/js/layer/layer.js"></script>

<script
	src="${pageContext.request.contextPath}/static/user/forum/js/forum.js"></script>
	<script
	src="${pageContext.request.contextPath}/static/user/forum/js/win_load.js"></script>
	  <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
	
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/user/forum/js/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/user/forum/js/wangEditor/dist/js/wangEditor.js"></script>
    <script type="text/javascript">
    var editor = new wangEditor('editor');
    editor.config.uploadImgUrl = '/ckeditorUpload2.html';
    editor.config.uploadImgFileName = 'upload';
    // 配置自定义参数（举例）
    editor.config.uploadParams = {
        token: 'abcdefg',
        user: 'wangfupeng1988'
    };
    
    // 设置 headers（举例）
    editor.config.uploadHeaders = {
        'Accept' : 'text/x-json'
    };
    editor.config.emotions = {
		    // 支持多组表情

		    // 第一组，id叫做 'default' 
		    'classical': {
		        title: '经典表情',  // 组名称
		        data: '/beishite/static/user/forum/js/classical.data' 
		    },
		    'symbol':{
		    	 title: '符号表情',  // 组名称
			     data: '/beishite/static/user/forum/js/symbol.data'  
		    }
		};

/*     自定义菜单 */
    editor.create();
    
    </script>
    
    
    <script type="text/javascript">
			$(".list-page a").click(function() {
				pageNow = $(this).attr("title");
				title = $("#aaa").val();
				$("#pageform").append("<input type=\"hidden\" name=\"pageNow\" value="+pageNow+">");
				$("#pageform").append("<input type=\"hidden\" name=\"title\" value="+title+">");
				$("#pageform").submit();
			});
			
			
			$(".forum_Quit_Login").click(function(){
				window.location.href="/user/indes/Exit1.html";
			})
			
</script>
</body>
</html>