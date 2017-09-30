/**
 * Created by Administrator on 2016/3/6.
 */




$(function(){
    var page=1;    
    $.post("/user/phone/luntan.html",{"PAGENOW":page},function(data){
        //循环变量开始

  if(data.i=="0"){
	 layer.msg("没有更多了");
	 return false;
  }else if(data.i=="1"){
	    str='';
	    $(data.list).each(function(i,m){
	    	str += "<div class='content'>" +
            "<div class='name'>" +
            "<img src=/picture/"+m.headPhoto+" class='mtx1' data='ctfnsl'>" +            
            "<em>" + m.name +
            "</em>" +
            "</br>"+
            "<span>" + m.time + "</span>" +
            "<a>" +
            "<h3>"+ m.title +"</h3>"+
            "<div class='article' data='47902'>"+ m.content +"</div>  " +
            "</a>" +
            "</div>" +                            
            "<div class='pinglun'>" +
            "<a href='/home/action/commentList?id='"+m.content +">" +                              
            "<i class='fa icon iconfont'>&#xe642;</i>评论 ( " + 5 + " )</a>" +  
            "</div>" +
            "</div>";
	    })
             $(".main_Lon").html(str); 
              
    }          
    },'json');
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
                $.post("/user/phone/luntan.html",{"PAGENOW":page},function(data){
                    
                    //循环变量开始

              if(data.i=="0"){
            	 layer.msg("没有更多了");
            	 return false;
              }else if(data.i=="1"){
            	  str='';
          	    $(data.list).each(function(i,m){
          	    	str += "<div class='content'>" +
                    "<div class='name'>" +
                    "<img src=/picture/"+m.headPhoto+" class='mtx1' data='ctfnsl'>" +            
                    "<em>" + m.name +
                    "</em>" +
                    "</br>"+
                    "<span>" + m.time + "</span>" +
                    "<a>" +
                    "<h3>"+ m.title +"</h3>"+
                    "<div class='article' data='47902'>"+ m.content +"</div>  " +
                    "</a>" +
                    "</div>" +                            
                    "<div class='pinglun'>" +
                    "<a href='/home/action/commentList?id='"+m.content +">" +                              
                    "<i class='fa icon iconfont'>&#xe642;</i>评论 ( " + 5 + " )</a>" +  
                    "</div>" +
                    "</div>";
          	    })
                       $(".main_Lon").append(str); 
                }          
                },'json');
                    // $(".main_Con").append(str); 
        	   page++;
        	   
            }
        }

    })
//向下滚动结束
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
