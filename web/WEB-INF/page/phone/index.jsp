<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
   <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
     <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/zhixiao/lib/jquery/jquery-2.1.4.min.js"></script>
     <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/phone/index/style/index.css" />
     <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/phone/index/font/iconfont.css" />
</head>
<body>

<div class="top" style="position:relative;">
    <div class="people">
        <div class="left_pp">
            <div class="pic_kk"></div>
            <!-- <i class="font font">&#xe62b;</i> -->
            <img src="${pageContext.request.contextPath}/picture/${user.headPhoto}" alt="">
        </div>
        <div class="right_pp">
            <div class="name">
                <h1>${user.name}</h1><br>
                                              
            </div>
            
        </div>
    </div>
     
</div>
<script type="text/javascript">
    $(".tubiao a em").click(function(){
        $(".tubiao a em").removeClass("yellow");
        $(this).addClass("yellow");
    });
    $("#ww2").hide();
    $("#qq").click(function(){
        $("#ww2").show();
        $("#ww2 em").click(function(){
            $("#ww2").hide();
        });
    });
    $("#ww1").hide();
    $("#wwxin").click(function(){
        $("#ww1").show();
        $("#ww1 em").click(function(){
            $("#ww1").hide();
        });
    });//会员显示信息
    $(".tubiao a.no").click(function(){
        $("#ww1").show();
        $("#ww1 em").click(function(){
            $("#ww1").hide();
        });
    });//非会员不显示信息
</script>

<div class="list">
    <table  cellspacing="2px;">
        <tbody><tr>
            <td style="border-left:none;" class="one" data="${pageContext.request.contextPath}/user/phone/skipLantan.html">
            <img src="${pageContext.request.contextPath}/static/phone/index/lt.png"><br>养生论坛
            <img src="${pageContext.request.contextPath}/static/phone/index/rtn.png" style="float: right;width: 1rem;height: 1.5rem;display: block;margin: auto;margin-right: 2%;">
            </td>
            <td class="two" data="${pageContext.request.contextPath}/user/phone/skipNews.html">
            <img src="${pageContext.request.contextPath}/static/phone/index/new.png"><br>资讯新闻
            <p id="p" style="float: right;color: #C8C8C8;margin-right: 2%;font-size: 0.5rem;"></p>
             </td>
            <td class="three" style="border-right:none;" data="${pageContext.request.contextPath}/user/phone/userInfo.html?userID=${user.userID}">
            <img src="${pageContext.request.contextPath}/static/phone/index/selt.png"><br>个人中心
            <img src="${pageContext.request.contextPath}/static/phone/index/rtn.png" style="float: right;width: 1rem;height: 1.5rem;display: block;margin: auto;margin-right: 2%;">
            </td>
        </tr>      
    </tbody></table>
</div>
<script type="text/javascript">
    $(".five2").click(function(){
        $(".alert").show();
        $(".alert i").click(function(){
            $(this).parent().hide();
        })
    })
</script>


<div class="mmm" id="light"></div>
<script>
    $(".list td").click(function(){
        location.href=$(this).attr("data");
    })
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/index/js/com.js"></script>

<script>
        $("#reg1").click(function(){
            if(confirm("您已登录，去注册将退出登录状态，确定去注册吗？")) {
                window.location.href=$(this).attr("data")+"gotoregister/?uid="+"462078";
            }else{
                return false;
            }
        });
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/index/js/jweixin-1.0.0.js"></script>
<script>
//share
var imgurl=$('meta[name=share]').attr('content');
var share={};
share.url=window.location.href + "%3Fproid%3D" + "462078";
share.url2=window.location.href+"?proid="+"462078&f_t=6";
share.title=document.title;
share.pic=imgurl.indexOf('http')!=0?'http://'+document.domain+imgurl:imgurl;
share.desc = $('meta[name=description]').attr('content');

//如果是微信
if(typeof document.addEventListener == 'undefined'){
    document.attachEvent('WeixinJSBridgeReady', function onBridgeReady(){
        $('<img src="'+share.pic+'" style="width:0;height:0;margin:0;padding:0;display:block;" />').prependTo($('body'));
    });
}else{
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady(){
        $('<img src="'+share.pic+'" style="width:0;height:0;margin:0;padding:0;display:block;" />').prependTo($('body'));
    });
}

var shareurl={};
shareurl.qzone='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=' + share.url + '%26f_t%3D2&title='+share.title+'&summary='+share.desc+'&pics='+share.pic+'';
shareurl.sqq='http://connect.qq.com/widget/shareqq/index.html?url=' + share.url + '%26f_t%3D1&desc='+share.desc+'&summary='+share.desc+'&site='+share.url+'&pics='+share.pic+'';
shareurl.tqq='http://v.t.qq.com/share/share.php?title='+share.title+'&url='+share.url+'%26f_t%3D4&site='+share.url+'&pic='+share.pic+'';
shareurl.sina='http://v.t.sina.com.cn/share/share.php?url='+share.url+'%26f_t%3D3&title='+share.title+'&&source='+share.url+'&sourceUrl='+share.url+'&content='+share.desc+'&pic='+share.pic+'';
shareurl.douban='http://www.douban.com/share/service?image='+share.pic+'&href='+share.url+'%26f_t%3D5&name='+share.title+'&text='+share.desc+'';

function add_css(css_text){
 	try{
  		var style = document.createStyleSheet();
  		style.cssText = css_text;
 	}catch (e){
  		var style = document.createElement('style');
  		style.type = 'text/css';
  		style.textContent = css_text;
  		document.getElementsByTagName('head').item(0).appendChild(style);
 	}
}
var css='#share-box{position: fixed; top: 30%; z-index: 999; left: 50%; width: 310px; margin-left: -157px; border: 1px solid #ccc; background: #fff; display: none;}'+
		'#share-box .s-title{height: 2.4em; line-height: 2.4em; font-size: 1.2em;padding: 0 0.5em; position: relative;}'+
		'#share-box .s-title a{position: absolute; right: 0; top: 0; padding: 0 0.5em; font-size: 1.3em;}'+
		'#share-box .share-list{padding: 5px 0; width: 300px; margin: 0 auto; text-align: center;text-align: center;}'+
		'#share-box .share-list a {display: inline-block; width: 90px; text-align: center; height: 80px; line-height: 22px; font-size: 1em;margin-bottom:.8rem}'+
		'#share-box .share-list a img {display: block; width: 50px; text-align: center; height: 50px;margin-left:20px}'+
		'#share-box .share-list a p {display: block; height:25px;line-height:25px;text-align: center;margin-top: 5px;}'+
		'#weixin{position: fixed; top: 0; left: 0; right: 0; bottom: 0; z-index: 99999; text-align: center; background: rgba(0,0,0,0.5); display: none; z-index: 99999999;}'+
		'#weixin .w-tips{display: none;}'+
		'#weixin div{color: #fff; line-height: 3em; padding: 4em 0; display: none;}'+
		'#weixin img{display: block; margin: 0 auto; max-width: 100%;}'+
		'#weixin a{display: block; position: absolute; top: 0.8em; left: 0.8em; font-size: 2em; color: #fff;}';
function create_share(){
	add_css(css);
	
	$('<div id="share-box">'+
		'<div class="s-title"><span>分享</span><a href="javascript:;">x</a></div>'+
		'<div class="share-list">'+
			'<a href="javascript:;" data="weixin"><img src="/Public/theme_v3/blog/wap/images/weixin.png" /><p>微信</p></a>' +
			'<a href="javascript:;" data="qzone"><img src="/Public/theme_v3/blog/wap/images/kongjian.png" /><p>QQ空间</p></a>' +
			'<a href="javascript:;" data="sqq"><img src="/Public/theme_v3/blog/wap/images/QQ.png" /><p>QQ好友</p></a>' +
			'<a href="javascript:;" data="tqq"><img src="/Public/theme_v3/blog/wap/images/tengxun.png" /><p>腾讯微博</p></a>' +
			'<a href="javascript:;" data="sina"><img src="/Public/theme_v3/blog/wap/images/xinlang.png" /><p>新浪微博</p></a>'+
			'<a href="javascript:;" data="douban"><img src="/Public/theme_v3/blog/wap/images/douban.png" /><p>豆瓣</p></a>' +
		'</div>'+
	'</div>'+
	'<div id="weixin">'+
		'<a href="javascript:;">x</a>'+
		'<img src="/Public/images/weixin.png" class="w-tips" />'+
		'<div>'+
			'<p>打开微信，使用"扫一扫"即可将网页分享到我的朋友圈</p>'+
			'<img src="" class="weixinpic" />'+
		'</div>'+
	'</div>').appendTo($('body'));
}

//在手机网站上如果有在线交谈则隐藏掉分享的按钮
if($('#wap-online-talk').size()<1) create_share();

$('.weixinpic').attr('src','http://s.jiathis.com/qrcode.php?url='+share.url);

$('#share-btn').click(function (){
	$('#share-box').show();
});

$('.s-title a').click(function (){
	$('#share-box').hide();
});


$('.share-list a').click(function (){
	var type=$(this).attr('data');
	if(type=='weixin'){
            if(typeof window.WeixinJSBridge != 'undefined'){
                $('#weixin').show().find('.w-tips').show();
	    }else{
                $('#weixin').show().find('div').show();
	    }
	} else if (type == 'sqq') {
            if (typeof WeixinJSBridge == "undefined") {
                window.open(shareurl[type]);
            } else {
                $('#weixin').show().find('.w-tips').show();
            }
        } else if (type == 'qzone') {
            if (typeof WeixinJSBridge == "undefined") {
                window.open(shareurl[type]);
            } else {
                $('#weixin').show().find('.w-tips').show();
            }
        } else {
		window.open(shareurl[type]);
	}
});

$('#weixin a').click(function(){$(this).siblings().hide().parent().hide();});

//微信分享相关
wx.config({
	debug: false,
	appId: 'wx5af803882512a141',
	timestamp: 1463813898,
	nonceStr: 'DBc03CC7YTFfhiFN',
	signature: '6a949fdb3ff94b6f5792678950a8f4be9275df76',
	jsApiList: [
		'onMenuShareTimeline',
		'onMenuShareAppMessage',
		'onMenuShareQQ',
		'onMenuShareWeibo',
		'onMenuShareQZone'
	]
});
wx.ready(function () {
	wx.onMenuShareQQ({
		title: share.title,
		desc: share.desc,
		link: share.url2,
		imgUrl: share.pic,
		trigger: function (res) {
			//alert('用户点击分享到QQ');
		},
		complete: function (res) {
			//alert(JSON.stringify(res));
		},
		success: function (res) {
			alert('已分享');
		},
		cancel: function (res) {
			alert('已取消');
		},
		fail: function (res) {
			//alert(JSON.stringify(res));
		}
	});

	wx.onMenuShareTimeline({
		title: share.title,
		link: share.url2,
		imgUrl: share.pic,
		trigger: function (res) {
			// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			//alert('用户点击分享到朋友圈');
		},
		success: function (res) {
			alert('已分享');
		},
		cancel: function (res) {
			alert('已取消');
		},
		fail: function (res) {
			//alert(JSON.stringify(res));
		}
	});
	
	wx.onMenuShareAppMessage({
		title: share.title,
		desc: share.desc,
		link: share.url2,
		imgUrl: share.pic,
		trigger: function (res) {
			// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			//alert('用户点击发送给朋友');
		},
		success: function (res) {
			alert('已分享');
		},
		cancel: function (res) {
			alert('已取消');
		},
		fail: function (res) {
			//alert(JSON.stringify(res));
		}
	});
	
	wx.onMenuShareWeibo({
		title: share.title,
		desc: share.desc,
		link: share.url2,
		imgUrl: share.pic,
		trigger: function (res) {
			//alert('用户点击分享到微博');
		},
		complete: function (res) {
			//alert(JSON.stringify(res));
		},
		success: function (res) {
			alert('已分享');
		},
		cancel: function (res) {
			alert('已取消');
		},
		fail: function (res) {
			//alert(JSON.stringify(res));
		}
	});
	
	wx.onMenuShareQZone({
		title: share.title,
		desc: share.desc,
		link: share.url2,
		imgUrl: share.pic,
		trigger: function (res) {
			//alert('用户点击分享到QZone');
		},
		complete: function (res) {
			//alert(JSON.stringify(res));
		},
		success: function (res) {
			alert('已分享');
		},
		cancel: function (res) {
			alert('已取消');
		},
		fail: function (res) {
			//alert(JSON.stringify(res));
		}
	});
});
</script><div id="share-box"><div class="s-title"><span>分享</span><a href="javascript:;">x</a></div><div class="share-list"><a href="javascript:;" data="weixin"><img src="/Public/theme_v3/blog/wap/images/weixin.png"><p>微信</p></a><a href="javascript:;" data="qzone"><img src="/Public/theme_v3/blog/wap/images/kongjian.png"><p>QQ空间</p></a><a href="javascript:;" data="sqq"><img src="/Public/theme_v3/blog/wap/images/QQ.png"><p>QQ好友</p></a><a href="javascript:;" data="tqq"><img src="/Public/theme_v3/blog/wap/images/tengxun.png"><p>腾讯微博</p></a><a href="javascript:;" data="sina"><img src="/Public/theme_v3/blog/wap/images/xinlang.png"><p>新浪微博</p></a><a href="javascript:;" data="douban"><img src="/Public/theme_v3/blog/wap/images/douban.png"><p>豆瓣</p></a></div></div><div id="weixin"><a href="javascript:;">x</a><img src="/Public/images/weixin.png" class="w-tips"><div><p>打开微信，使用"扫一扫"即可将网页分享到我的朋友圈</p><img src="http://s.jiathis.com/qrcode.php?url=http://www.ctfnsl.zx85.cn/%3Fproid%3D462078" class="weixinpic"></div></div>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?3c655380a50bcfd1330c5e41ef5c4935";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

<div id="qq-sendUrl-btn"></div><div id="qb-sougou-search" style="display: none; opacity: 0;"><p>搜索</p><p class="last-btn">复制</p><iframe src=""></iframe></div></body>
</html>