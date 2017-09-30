/**
 * Created by Administrator on 2016/5/13.
 */
$(function(){
    var data=new Date();
    $(".time").html(data.getFullYear());
    $(".timeage").html(data.getFullYear()-2);

})