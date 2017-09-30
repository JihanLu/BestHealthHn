//生成二维码结束
function AutoScroll(obj) {
    $(obj).find("ul:first").animate({marginTop : "-25px"}, 500, function() {
        $(this).css({marginTop : "0px"}).find("li:first").appendTo(this);
    });
}
$(function(){
    setInterval('AutoScroll("#scrollDiv_keleyi_com")', 3000);
})