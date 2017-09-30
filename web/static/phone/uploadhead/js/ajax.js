/**
 * Created by Administrator on 2016/6/22.
 */
$(function(){
    var url="";
    var playlist;
    $.ajax({
        type:"post",
        url:url,
        data:{"i":"1"},
        cache: false,
        dataType: "json",
        error:function(){
            /*alert("请重新登陆");*/
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
})
