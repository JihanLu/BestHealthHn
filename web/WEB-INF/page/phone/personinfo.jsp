<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑资料</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/jinruketangqian/js/jquery-1.11.3.min.js"></script>
  <meta name="viewport" content="initial-scale=1,maximum-scale=3,minimum-scale=1,user-scalable=no"/>
<%--   <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/tribune/js/layer.js"></script> --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/personinfo/js/ajax.js"></script>
        <script src="${pageContext.request.contextPath}/static/phone/register/layer/layer.js"></script>
<%--     <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/style/layer.css" rel="stylesheet" /> --%>
        <link type="text/css" href="${pageContext.request.contextPath}/static/phone/personinfo/style/index.css" rel="stylesheet" />
             <link type="text/css" href="${pageContext.request.contextPath}/static/phone/personinfo/font/iconfont.css" rel="stylesheet" /> 
             <link type="text/css" href="${pageContext.request.contextPath}/static/phone/personinfo/style/font-awesome.min.css" rel="stylesheet" />
<%--     <link type="text/css" href="${pageContext.request.contextPath}/static/phone/personinfo/style/layer.css" rel="stylesheet" /> --%>
              <style>
        #body .blue{
            color:#3D5DFF;
            border-color:#3D5DFF;
        }
        #body .ccc{
            color:#ccc;
            border-color:#ccc;
        }

    </style>
</head>
<body>
<!-- 这个是用户编辑资料页面 -->
<input type="text" value="${user.userID}" style="display:none;" class="person">
<div class="heading">
    <!-- <a href="#" class="back"><i class="fa fa-angle-left"></i></a> -->
    <span>编辑资料</span>
    <a href="" class="more"> </a>
</div>
<div class="kong" style="height:50px"></div>

<div id="body">
        
    <form id="myform" name="myform" method="post">
        <div class="label" style="height:110px;line-height:98px;text-align:center;width:100%;border:none;margin:1rem 0;"><!-- <p>头像</p> -->
            <div class="right" style="border:none">
                <div id="main">
                    <div id="SelectBox">
                    <%-- <div class="tk">
                    
                    <a href='${pageContext.request.contextPath}/user/phone/skipLogin.hmtl'><input type="button" name="xh" id="zh" value="切换账号"></a>
                    <input type="button" name="tc" id="dl" value="退出登录">
                    <input type="hidden" name="i01d" value="${user.userID }">
                    
                    </div> --%>
                        <!--<form    name="FORM" method="post"  target="POSTiframe">-->
                        <input type="hidden" name="upic" value="20160320/56ee5cf8c3aef.png">
                        <a href="#" class='head_A'><img src="${pageContext.request.contextPath}/picture/${user.headPhoto}" alt="" style="width: 100px;height:100px;position: relative;border-radius:60px"></a>
                    </div>
                    <div id="relat">
                        <div id="black"></div>
                    </div>
                   
                </div>
            </div>
            
        </div>
        
         <div style="text-align:center;font-size:1.5em;color:#333;margin:-1.4rem 0 0 -.4rem"><span>${user.account }</span></div>
         <div class="label">
            <div class="label0">
                <p><i class="fa fa-user" style="font-size:1.2em;"></i></p>
                <div class="right">
                    <input onblur="is_user(this.value)" type="text" placeholder="昵称" maxlength="11" value="${user.name }" name="name" style="color: #444">
                </div>
                <span id="name">昵称格式错误</span>
            </div>
          
            <input type="hidden" id="is_open_mobile" name="is_open_mobile" value="0">
            <div class="smoll">*昵称具有唯一性,不可与其他用户相同</div>
        </div>
            <!-- <div class="label">
            <div class="label0" style="width:89%"><p><i class="fa fa-user"></i></p> <div class="right"><input type="text" placeholder="我的姓名" name="name" value="" maxlength="6">
            </div>
            </div>
        </div> -->
        <!-- <div style="height:1rem;background:#EFEFF5"></div> -->
          <div style="width: 90%;height: 1.5rem;display: block;margin: auto;font-size: 1rem;color: #777777;">
              <p>性别：
                <input type="radio" name="sex" value="nan" id="nan" ${user.sex eq 'nan'?'checked="checked"':''}/><label for="nan">男</label>
                <input type="radio" name="sex" value="nv" id="nv" ${user.sex eq 'nv'?'checked="checked"':''}/><label for="nv">女</label>
              </p>
         </div>
        <div class="label">
            <div class="label0">
                <p><i class="fa fa-mobile" style="font-size:1.8em;"></i></p>
                <div class="right">
                    <input onblur="is_user(this.value)" type="text" placeholder="手机号码" maxlength="11" value="${user.phone }" name="phone" style="color: #444">
                </div>
                <span id="tel">手机号码格式错误</span>
            </div>
            <input type="hidden" id="is_open_mobile" name="is_open_mobile" value="0">
        </div>
        <div class="smoll">*手机号码可用来修改密码，请谨慎填写</div>
          <div class="tk">
                    
                    <a href='${pageContext.request.contextPath}/user/phone/skipLogin.hmtl'><input type="button" name="xh" id="zh" value="切换账号"></a>
                    <input type="button" name="tc" id="dl" value="退出登录">
                    <input type="hidden" name="i01d" value="${user.userID }">
                    
                    </div>
          <div class="pd">                 
                     <p style="font-size: 1.3rem;color: black;line-height: 2rem;width: 90%;margin-left: 5%;">
                                            是否选择退出：
                     <a href='${pageContext.request.contextPath}/user/phone/skipPhoneExit.html'><input type="button" name="ture" id="yes" value="是"></a>
                     <input type="submit" name="fasle" id="no" value="否">
                     </p>                     
             </div>
         
        <div class="finish"><a href="" onclick="crk()"> 完 成</a></div>
        <div class="smoll" style="color: red">*点击头像可选择切换用户及退出登陆</div>
    </form>
  
</div>
<div class="last">
    <ul>
       <li id="lbg"><span><a href="${pageContext.request.contextPath}/user/phone/skipNews.html">资讯</a></span></li>
       <li><span><a href="${pageContext.request.contextPath}/user/phone/skipLantan.html">论坛</a></span></li>
       <li id="liId"><span id="userInfo">个人中心</span></li> 
    </ul>
</div>




<script>
/*     $("i.fa-toggle-on").click(function() {
        if($(this).hasClass('blue')){
            $(this).removeClass('blue').addClass('ccc').siblings(".label0").children().children("input").css('color','#A9A9A9');
            $(this).removeClass('blue').addClass('ccc').siblings(".label0").children().children(".select").children("select").css('color','#A9A9A9');
            $(this).css("transform","rotate(180deg)");
            $(this).siblings("input[type='hidden']").val(1);

        } else {
            $(this).removeClass('ccc').addClass('blue').siblings(".label0").children().children("input").css('color','#444');
            $(this).removeClass('ccc').addClass('blue').siblings(".label0").children().children(".select").children("select").css('color','#444');
            $(this).css("transform","rotate(0deg)");
            $(this).siblings("input[type='hidden']").val(0);
        }
    });

   $(".label0 span").click(function(){
       $(this).fadeOut(300);
   })

/*     addressInit('province', 'city', 'county', '海南', '海口市', ''); */

    //提交相关
   /*  $('input[name=site]').blur(function() {
        var iv = $(this).val(),
                obj = $(this);
        $.getJSON('/info/checksite', {
                    'site': iv
                },
                function(data) {
                    if (data.status == 0) {
                        t_delay(data.info);
                    }
                });
    }); */ 
    // $('input[name=site]').focus(function() {
    //     var obj = $(this);
    //     obj.siblings('h3').html(obj.siblings('h3').attr('data'));
    // });
   /*  $('form').submit(function() {
        if ($('input[name=upic]').val() == '') {
            t_delay('没有选择图片');
            return false;
        }
        if(($('input[name="sign"]').val()).length>=30){
            t_delay('签名不能超过30字');
            return false;
        }
        var iv = $('input[name=site]').val(),
                reg = /^[0-9a-z]*$/g;
        if (iv != undefined && !reg.test(iv)) {
            t_delay('网址只能是数字+字母');
            return false;
        }
        sends = $(this).serializeArray(),
                t_loading();
        $.post(url, sends,
                function(data) {
                    t_delay(data.info);
                    if (data.status == 1) setTimeout(function() {
                                window.location.href = "/home/action/cookie";
                            },
                            800)
                },
                'json');
        return false;
    }); */
</script>
<!-- <script type="text/javascript">
    //各种验证
    function is_site (str) {
        var regu = /^[0-9a-z]{2,6}$/;
        var re = new RegExp(regu);
        if(str){
            if(!re.test(str)){
                $("#site").fadeIn(500);
                $("#site").parent(".label0").css("border-color","#D16D62");
            }else{
                document.getElementById('site').style.display='none';
                $("#site").parent(".label0").css("border-color","#ccc");
            }
        }else{

        }

    }

    function is_mobile (str) {
        var regu = /^1[3-8]+\d{9}$/;
        var re = new RegExp(regu);
        if(str){
            if(!re.test(str)){
                $("#tel").fadeOut(5000);
                $("#tel").parent(".label0").css("border-color","#D16D62");
              layer.msg('');
            }else{
                document.getElementById('tel').style.display='none';
                $("#tel").parent(".label0").css("border-color","#ccc");
            }
        }else{

        }
    } 
</script> -->

<script>
   /*  $(".label0 .right input,.label0 .right textarea").focus(function(){
        $(this).parent().parent(".label0").removeClass("ccc").addClass("blue");
        $(this).parent().parent(".label0").children("span").css("display","none");
    })
    $(".label0 .right input,.label0 .right textarea").blur(function(){
        $(this).parent().parent(".label0").removeClass("blue").addClass("ccc");
    }) */

</script>

<!-- <div id="qq-sendUrl-btn"></div> -->
</body>
</html>