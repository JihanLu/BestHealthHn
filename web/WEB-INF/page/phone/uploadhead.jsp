    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" name="viewport"/>
<title>修改头像</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/phone/uploadhead/style/mreset.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/phone/uploadhead/style/basic_1.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/phone/uploadhead/style/jquery.Jcrop.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/phone/uploadhead/style/ucenter.css" />
   <link type="text/css" href="${pageContext.request.contextPath}/static/phone/personinfo/font/iconfont.css" rel="stylesheet" /> 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/phone/uploadhead/style/member.css" />
     <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/uploadhead/js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/uploadhead/js/ajax.js"></script>
         <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/tribune/js/layer.js"></script>
             <link type="text/css" href="${pageContext.request.contextPath}/static/phone/tribune/style/layer.css" rel="stylesheet" />

<style type="text/css">
    .cells a.toupdate{ 
        display: inline-block;
        border-radius: 5px;
        margin:0 auto;
        margin-top: 20px;
        text-align: center;
        width: 90%;
        border: none;
        color: #fff;
        height: 2.6em;
        line-height: 2.6em;
        font-size: 1em;
        box-shadow: none;
        background: #204fa1; 
        
    } 
    .pics{position: relative;width: 100%;height: 280px;overflow: hidden;border: 2px solid #ccc;background: #fff;}
    .picss{position: relative;width: 100%;height: 280px;overflow: hidden;border: 2px solid #ccc;background: #fff;}
</style>
<!-- <script type="text/javascript" src="/Themes/ucenter/mobile/public/js/common.js"></script> -->
</head>
<body>

<div class="tophead">
    <div class="heading">
        <a href="javascript:window.history.back();" class="back"></a>
        <span>修改头像</span>
    </div>
    <div class="head_bottom"></div>
</div>



<div id="main" style="margin-top:40px">



   <form class="head-form" action="#" method="post" enctype="multipart/form-data">

   <div class="pics" style="border:none">
	        <div id="picker" class="picker-img webuploader-container" style="top:50px;left:50%;width:100px;height:100px;margin-left:-50px">
	            <div class="webuploader-pick webuploader-pick-hover">
                   <img src="${pageContext.request.contextPath}/static/phone/uploadhead/images/pic_picker.png" /> 
                </div>
                <div id="rt_rt_1algrg22o1ddn16lq12f9q8sfj71" style="position: absolute;top:0px; left: 0px;right:0px;bottom:1px;overflow:hidden;">
                    <input type="file" name="file" class="webuploader-element-invisible" accept="image/*">
                    <label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                </div>
            </div>
            <span></span><i></i>
   </div>

        <input type="hidden" name="upic">
        <input type="hidden" name="x" id="x">
        <input type="hidden" name="y" id="y">
        <input type="hidden" name="w" id="w">
        <input type="hidden" name="h" id="h">
        <div id="uploadProgress"></div>
        <div id="privew" class="old" style="border:none">
            <img src="${pageContext.request.contextPath}/picture/${user.headPhoto }" data="${user.headPhoto }">
        </div>
        <div class="cells cells-sub" style="clear:both;overflow:hidden;margin:0 0 0 0;text-align:center;">
            <a style="width:46%" href="javascript:;" class="toupdate">确定上传</a>
            <a href="javascript:;" class="choise reset" style="width:46%;border:1px solid #CCC;height:2.6em;float:right;font-size:1em;border-radius:.3rem;box-shadow:none;color:#666">重新选择</a>
        </div>
  </form>
</div>
<div id="tips" style="display: none;"><div>未选择图片</div></div>
<!-- <script type="text/javascript" src="/home/uploadhead/js/comm.js"></script> -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/uploadhead/js/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/phone/uploadhead/js/jquery.Jcrop.min.js"></script>
<script>
 $('.users').attr('src', $('.users').attr('src') + '?' + Math.random());
$('#privew img').attr('src', $('#privew img').attr('src') + '?' + Math.random());
//变量       
var jcrop_api, boundx, boundy, bw = $('.pics').width(), bh = $('.pics').height(), rw = $('#privew').width(), rh = $('#privew').height(), btn = true;
//图片裁切函数
function updatePreview(c) {
    if (parseInt(c.w) > 0) {
        var rx = rw / c.w, ry = rh / c.h;
        if (btn) {
        
            boundx = $('.pics img').filter(':not(.webuploader-pick img)').width();
         
      
            boundy = $('.pics img').filter(':not(.webuploader-pick img)').height();
            btn = false;
        }
        $('#privew img').css({
            width: Math.round(rx * boundx) + 'px',
            height: Math.round(ry * boundy) + 'px',
            marginLeft: '-' + Math.round(rx * c.x) + 'px',
            marginTop: '-' + Math.round(ry * c.y) + 'px'
        });
    }
    $('#x').val(parseInt(c.x));
    $('#y').val(parseInt(c.y));
    $('#w').val(parseInt(c.w));
    $('#h').val(parseInt(c.h));
}

//删除图片
/* function delpic() {
	alert("删除图片"); */
   /*  var _arguments = arguments.length; */
    /* $.getJSON('/info/delpic', {'pic': pic}, function (data) { */
        //if (data.status == 1)
       /*  resets(); */
  /*   }); */
/* } */

//重置
function resets() {
	alert("重置");
    if ($('input[name=upic]').val() == '') {
      /*   t_delay('未选择图片'); */
        alert('未选择图片');
        return false;
    }
    jcrop_api.destroy();
    uploader.reset();
    $('input[name=upic]').val('');
    $('#picker').show().siblings('p').show().siblings('img').remove();
    $('#picker').siblings('img').remove();
    $('#privew').addClass('old').find('img').attr({'src': $('#privew').find('img').attr('data'), 'style': ''});
    btn = true;
}

var uploader = WebUploader.create({
    swf:'/static/phone/Rtn/js/Uploader.swf',
/*     server:'/home/action/dynamicUpload', */
     server:'', 
    auto: true,
    pick: {
        id:'#picker',
        multiple: false
    },
    accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
    },
    fileSingleSizeLimit: 1048576*5,
    compress: false
});
//图片上传出错
 uploader.on('error', function (type) {
     var text = '';
     switch (type) {
         case 'F_EXCEED_SIZE':
             text = '图片大小超出限制';
             break;
         case 'F_TYPE_DENIED':
             text = '图片类型不正确';
             break;
         case 'F_DUPLICATE':
             text = '图片文件重复';
             break;
         default:
             text = type;
     }
   /*   t_delay(text); */
     alert(text);
 });
//文件选择
 uploader.on('fileQueued', function (file) {
	 alert(file);
    $('.pics').find('span').show().siblings('p').hide();
    $('<img src="" />').appendTo($('.pics'));
    var $img = $('.pics').find('img').filter(':not(.webuploader-pick img)');
    
    uploader.makeThumb(file, function (error, src) {
        if (error) {
            $('.pics').find('i').html('不能预览').show();
            return;
        }
        $img.attr('src', src);
    }, bw, bh);
    $('#uploadProgress').show();
});
//图片上传成功
uploader.on('uploadSuccess', function (file, data) {
	alert(file);
    $('#uploadProgress').html("正在处理请稍候，可能因为图片太大而缓慢");
    $('.picker-img').hide();
    alert(".picker-img no hide");
    var obj = $('.pics').find('img').filter(':not(.webuploader-pick img)');
  
    $('input[name=upic]').val(data.address);
    obj.attr('src', data.address);

    obj.load(function () {

        $('#uploadProgress').html("").hide();
        $('.pics').find('span,i').hide();
        $('#privew').removeClass('old').find('img').attr('src', data.address);
        var iw = obj.width(), ih = obj.height();
        if (ih < 200 || ih > 1400 || iw < 200 || iw > 1400) {
         /*   t_delay('图片尺寸须在200-1000像素之间');  */
           alert('图片尺寸须在200-1000像素之间'); 
         
           uploader.reset();
           $('input[name=upic]').val('');
           $('#picker').show().siblings('p').show().siblings('img').remove();
           $('#picker').siblings('img').remove();
           $('#privew').addClass('old').find('img').attr({'src': $('#privew').find('img').attr('data'), 'style': ''});
           btn = true;
           /*  delpic(data.info); */
           /*  delpic(); */
              var url="";
    var playlist;
    $.ajax({
        type:"post",
        url:url,
        data:{"i":"1"},
        cache: false,
        dataType: "json",
        error:function(){
            alert("请重新登陆");
        },
        success:function(data){
            var value =eval(data);
            playlist = new Array();
            $(".shipinbofantotal").html("");
            //遍历json返回数据
            $.each(value['list'],function(i,mem){
                /*          alert(mem.wifioff);*/
                playlist=data.list;
                $('#privew img').attr('src',mem.photo);
                $('#privew img').data('data',mem.photo);
            });
        }
    })  
         
           
           
            return false;

        }
        obj.Jcrop({
            keySupport: false,
            boxWidth: bw,
            boxHeight: bh,
            setSelect: [200, 200, 0, 0],
            maxSize: [400, 400],
            minSize: [200, 200],
            aspectRatio: 1,
            allowSelect: false,
            onChange: updatePreview,
            onSelect: updatePreview
        }, function () {
            var bounds = this.getBounds();
            boundx = bounds[0], boundy = bounds[1];
            jcrop_api = this;
        });
    });
});
uploader.on('uploadProgress',function (file,percentage){
    var pcent = percentage*100;
    pcent = pcent.toFixed(2);
    $('#uploadProgress').html("上传进度：" + pcent+'%');

});

//重新选择
$('.reset').click(function () {
    resets();
    var url="";
    var playlist;
    $.ajax({
        type:"post",
        url:url,
        data:{"i":"1"},
        cache: false,
        dataType: "json",
        error:function(){
            alert("请重新登陆");
        },
        success:function(data){
            var value =eval(data);
            playlist = new Array();
            $(".shipinbofantotal").html("");
            //遍历json返回数据
            $.each(value['list'],function(i,mem){
                /*          alert(mem.wifioff);*/
                playlist=data.list;
                $('#privew img').attr('src',mem.photo);
                $('#privew img').data('data',mem.photo);
            });
        }
    })
    
    
    
});

$('.toupdate').click(function () {
    var frm = $('.head-form');
    if ($('input[name=upic]').val() == '') {
      /*   t_delay('没有选择图片'); */
        alert('没有选择图片');
        return false;
    }
    var url = frm.attr('action'), sends = frm.serializeArray();
  /*   t_loading('正在保存'); */
  /*   alert(url); */
  var urls="";
    $.post(urls, sends, function (data) {
  /*       t_delay(data.info); */
        if (data.address == 1){
        	layer.msg('上传成功');
            setTimeout(function () {
                $('.users').attr('src', $('.users').attr('src') + '?' + Math.random());
                $('#privew img').attr('src', $('#privew img').attr('src') + '?' + Math.random());
               
                window.location.href = "/home/action/userAction";
            }, 2500);
        }
        if (data.address == 2){
        	alert("上传失败");
        	return false;
        }
    });
 /*    return false; */
});
</script>


</body>
</html>