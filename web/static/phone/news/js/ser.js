/**
 * Created by Administrator on 2016/3/6.
 */



$(function(){
	
    var page=1;    
    $.post("/user/phone/news.html",{"PAGENOW":page},function(data){
        //循环变量开始

  if(data.i=="0"){
	 layer.msg("没有更多了");
	 return false;
  }else if(data.i=="1"){
	    str='';
	    $(data.list).each(function(i,m){
	    	str+="<div class='main'>"+
            "<a href=/user/phone/newsDetails.html?id="+m.id+">"+
            "<div class='left'>"+
            "<img src=/picture/"+m.new_IMG+" alt=''/>"+
            "</div>"+
            "<div class='right'>"+
            "<div class='r_top'>"+
            "<p>"+m.new_title+"</p>"+
            "<span>"+m.new_Yea+"</span>"+
            "</div>"+
            "<div class='r_bottom'>"+
            "<p>"+m.new_Data+"</p>"+
            "<span><em>"+m.read+"</em><img src="+"'/static/phone/news/img/liulan.png' alt=''/></span>"+
            "</div>"+
            "</div>"+
            "</a>"+
            "</div>";
	    })
             $(".main_Con").html(str); 
              
    }          
    },'json');
});
$(function(){
	$("#userInfo").click(function(){
		$.ajax({
			type:"post",
			url:"/user/phone/userInfo.html",
			data:{},
			dataType:"json",
			async: false,
			success:function(data){
				if(data.a=="7"){
					window.location="/user/phone/skipUserInfo.html";
				}else if(data=="6"){
					layer.msg("用户尚未登陆！");
					window.location="/user/phone/skipLogin.html";
				}else{		
					layer.msg("用户尚未登陆！");
					window.location="/user/phone/skipLogin.html";
				}
			},
			error:function(data){
				alert("返回类型错误...")
			}
        });
	});
});
$(function(){
    //click开始
    var auto_load = true, is_onload = false;
    page = 2;
    $(window).scroll(function() {

        //ajax加载
        if (auto_load === true && is_onload == false) {
            if ($(window).scrollTop() >= $(document).outerHeight() - $(window).height()) {
                //navval = $(this).attr("id");
                $.post("/user/phone/news.html",{"PAGENOW":page},function(data){
                    
                    //循环变量开始

              if(data.i=="0"){
            	 layer.msg("没有更多了");
            	 return false;
              }else if(data.i=="1"){
            	    str='';
            	    $(data.list).each(function(i,m){
            	    	str+="<div class='main'>"+
                        "<a href=/user/phone/newsDetails.html?id="+m.id+">"+
                        "<div class='left'>"+
                        "<img src=/picture/"+m.new_IMG+" alt=''/>"+
                        "</div>"+
                        "<div class='right'>"+
                        "<div class='r_top'>"+
                        "<p>"+m.new_title+"</p>"+
                        "<span>"+m.new_Yea+"</span>"+
                        "</div>"+
                        "<div class='r_bottom'>"+
                        "<p>"+m.new_Data+"</p>"+
                        "<span><em>"+m.read+"</em><img src="+"'/static/phone/news/img/liulan.png' alt=''/></span>"+
                        "</div>"+
                        "</div>"+
                        "</a>"+
                        "</div>";
            	    })  
            	    $(".main_Con").append(str);
                }          
                },'json');
                    // $(".main_Con").append(str); 
        	   page++;
        	   
            }
        }

    })
//向下滚动结束
});

