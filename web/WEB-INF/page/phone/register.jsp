<%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head lang="en">
        <meta charset="UTF-8">
        <title>注册界面</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <meta name="description" content="zx家园网注册页面"/>
        <meta name="keywords" content="zx家园网"/>
        <meta name="viewport" content="initial-scale=1,maximum-scale=3,minimum-scale=1,user-scalable=no"/>
        <!-- iOS 设备 begin -->
        <meta name="apple-mobile-web-app-title" content="标题">
        <meta name="apple-mobile-web-app-capable" content="yes"/>
        <!--样式开始-->
        <link type="text/css" href="${pageContext.request.contextPath}/static/phone/register/style/register.css" rel="stylesheet" />
        <link type="text/css" href="${pageContext.request.contextPath}/static/phone/register/style/style.css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/static/phone/register/js/jquery-1.10.2.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/static/phone/register/js/checkbox.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/phone/register/js/yanzheng.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/phone/register/layer/layer.js"></script>

        </head>
        <body>
        <div class="top">
        <div class="topimg"><a href="${pageContext.request.contextPath}/user/phone/skipLogin.html"><img src="${pageContext.request.contextPath}/static/phone/register/images/left.png" class="tm" alt=""/></a></div>
        <span>欢迎注册</span>
        </div>
        <h4 class="tit"></h4>
        <c:if test="${i==1}"><p class="zhmm">验证码已过期</p></c:if>
        <c:if test="${i==1}"><p class="zhmm">此号码已被注册</p></c:if>
        <form action=""  method="post">     
        <div class="name">
        <label for="name" class="codes">用户名</label><input type="text" placeholder="请填写您的用户名" class="nametext" id="name" name="name"/>
        </div>
        <div class="ip">
        <label for="iph" class="n">手机号码</label><input type="text" placeholder="请输入您的手机号码" class="nametext" id="iph"  name="phone"/>
        </div>
        <div class="psw">
        <label for="psw" class="n">登录密码</label><input type="password" placeholder="密码不能少于6位" class="nametext" id="psw"  name="password"/>
        </div>
        <div class="confim">
        <label for="confim" class="n">确认密码</label><input type="password" placeholder="请再次确认登录密码" class="nametext" id="confim"  name="password"/>
        </div>
        <div class="code">
        <label for="code" class="codes">验证码</label><input type="text" placeholder="请输入您的验证码" class="nametext" id="code"  name="invitationcode"/>
        
        <a id="check_Code" onclick="createCode()" href="javascript:;" title="点击换一张" class="codess"></a>

        </div>
       
        <div class="sele1">
        <span class="checkbox_item">
         <input type="checkbox" id="checkb" name="qw" checked="checked"/>
        <label class="check_label on">
       <!--  <i class="checkbox_icon"></i> -->
        <span class="checkbox_text">同意&lt;&lt;贝仕特研究院服务协议&gt;&gt;</span>
        </label>
        </span>
        </div>     
        <div class="sure"><input name="confirm"  type="checkbox" id="cb" checked="checked" value="on"></div>
        <div class="res">
        <input type="button" value="立即注册" class="re" id="tj" onclick="checkReg()">
        </div>
     </form>
        <script src="${pageContext.request.contextPath}/static/phone/register/js/formyanzheng.js" type="text/javascript"></script>
       <!--  <script type="text/javascript">
        $(function(){//页面加载好的时候再执行
        $("#checkbox_item").click(function(){//绑定click事件
        $("#tj").prop("disabled", !this.checked);//设置 tj 的disabled
        }).trigger('click');//触发 click 以便在页面加载的时候, 根据 cb 的选中状态 设置一次tj的disabled
        });
        </script> -->
          <script type="text/javascript">
          $("#checkb").click(function(){
        	  if($(this).val()=="on"){
        		  $(this).val("no");
        	  }else{
        		  $(this).val("on");
        	  }
		});
/* 
			 $(".checkb").checkbox();
			var num = $(".box input[type=checkbox]:checked").length;
			if(num > 2){
				alert("不可以超过两个选项");
			} */
			var codess;
			/* $("#check_Code").click(function(){
				  codess = "";
				    var codeLength = 4;//验证码的长度
				    //var checkCode = document.getElementById("check_Code");
				    var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
				    //所有候选组成验证码的字符，当然也可以用中文的
				    for (var i = 0; i < codeLength; i++) {
				        var charIndex = Math.floor(Math.random() * 36);
				        codess += selectChar[charIndex];
				    }
				    $(this).addClass("codess");
				    $(this).html(codess);
				  
				    if (checkCode) {
				        checkCode.className = "codess";
				        checkCode.innerHTML = codess;
				    } 
			}); */
			 function createCode() {
			    codess = "";
			    var codeLength = 4;//验证码的长度
			    var checkCode = document.getElementById("check_Code");
			    var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
			    //所有候选组成验证码的字符，当然也可以用中文的
			    for (var i = 0; i < codeLength; i++) {
			        var charIndex = Math.floor(Math.random() * 36);
			        codess += selectChar[charIndex];
			    }
			    if (checkCode) {
			        checkCode.className = "codess";
			        checkCode.innerHTML = codess;
			    }
			} 
     
			window.onload=function(){
				createCode();
				//$("#check_Code").click();
				}
			
        </script>
        <%--<input type="submit"  name="submit1" value="提交"   id="tj" />--%>
      
       <div class="zhlogin"><a href="${pageContext.request.contextPath}/user/phone/skipLogin.html">已有账号?去登陆</a></div>
        <%-- <div class="bottoms">
        <a href="#">网站申请</a><span class="bottomsspan">|</span><a href="#">商家中心</a><span  class="bottomsspan">|</span><a href="#">关于我们</a>
        </div>
        <div class="footer">
        wenjdfnsk@ 2015 XXX版权所有<br/>
        技术支持：直销网
        </div>  --%>
   
        </body>
        </html>