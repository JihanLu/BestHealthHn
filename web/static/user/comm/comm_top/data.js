
function showtime(){
    var now=new Date();
    var year=now.getFullYear();
    var month=now.getMonth()+1;
    var day=now.getDate();
    var hours=now.getHours();
    var minutes=now.getMinutes();
    var seconds=now.getSeconds();
    var week = [ '日', '一', '二', '三', '四','五', '六' ];
    time=year+'年'+month+'月'+day +'日'+hours+':'+minutes+':'+seconds;
    var main_top_12=document.getElementById("main_top_12")
    main_top_12.innerHTML=time + "&nbsp;" + "星期" + week[now.getDay()];
}

function letstart(){
    taskId=setInterval(showtime,500);
}

window.onload=function(){
    /*var div1=document.getElementById('div1');
     div1.onclick=letstart;*/
    letstart();
}