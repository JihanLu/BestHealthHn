/**
 * Created by Administrator on 2016/5/8.
 */
$(function(){
    var page=1;
    var status=1;
    var playlist;
    $(".zairu").hide();
    $.post("/home/action/dynamicList",{"pagenow":page,"status":status},function(data){
        var value =eval( data );
        playlist = new Array();
        $.each( value['list'],function(i,mem){
            /*alert(data.list);*/
            playlist=data.list;
        });
        //循环变量开始
        for (var i=0; i<playlist.length; i++){
            var item = playlist[i];
            $('.zairu').before("<div class='content'>"+
                "<div class='name'>"+
                "<img src='/home/cellcenter/images/8.png' class='mtx1' data='ctfnsl'>"+
                "<a>"+
                "<em>"+item.name+"</em>"+
                "<span>"+item.time+"</span>"+
                "</a>"+
                "</div>"+
                "<div class='article' data='47902'>"+item.content+"</div>"+
                "<div class='picture' data='47902'>"+
                "<a href='javascript:;'><img src='"+item.photo1+"' id='1' data='"+item.photo1+"' udata='47902' class='refpic' style='height:103px;' /></a>"+
                "<a href='javascript:;'><img src='"+item.photo2+"' id='2' data='"+item.photo2+"' udata='47902' class='refpic' style='height: 103px;' /></a>"+
                "<a href='javascript:;'><img src='"+item.photo3+"' id='3' data='"+item.photo3+"' udata='47902' class='refpic' style='height:103px;' /></a>"+
                "<a href='javascript:;'><img src='"+item.photo4+"'' id='4' data='"+item.photo4+"'   udata='47902' class='refpic' style='height: 103px;' /></a>"+
                "<a href='javascript:;'><img src='"+item.photo5+"' id='5'  data='"+item.photo5+"'   udata='47902' class='refpic' style='height:103px;' /></a>"+
                "<a href='javascript:;'><img src='"+item.photo6+"' id='6' data='"+item.photo6+"' udata='47902' class='refpic' style='height: 103px;' /></a>"+
                "<a href='javascript:;'><img src='"+item.photo7+"' id='7' data='"+item.photo7+"' udata='47902' class='refpic' style='height:103px;' /></a>"+
                "<a href='javascript:;'><img src='"+item.photo8+"' id='8' data='"+item.photo8+"' udata='47902' class='refpic' style='height: 103px;' /></a>"+
                "<a href='javascript:;'><img src='"+item.photo9+"' id='9' data='"+item.photo9+"' udata='47902' class='refpic' style='height: 103px;' /></a>"+
                "</div>"+
                "<div class='pinglun'>"+
                "<a href='/home/action/commentList?id="+item.id+" '><i class='fa icon iconfont'>&#xe642;</i>评论 ( "+item.comment+" )</a>"+
               
                "</div>"+
                "</div>");

                    $("img").each(function(){

                        if($(this).attr("src")=="null"){
                            $(this).parent().remove();
                        }
                    })
        }

        //循环变量结束
        //alert($("img").siblings(".ph").html());

//       alert($(".ph").src());
       
       
       
    },'json');



});
