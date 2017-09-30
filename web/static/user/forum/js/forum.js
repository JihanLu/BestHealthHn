$(function(){
	$(".user_forum").click(function(){
		
		var forum_ID=$(this).parents(".forum_ma").find(".content_xinxi").data("currid");//发帖人id
		var user_Id=$(this).data("id");//回复id
		var that=$(this);
		if(user_Id==''){
			layer.msg('您还没有登录哦');
			return false;
		}
		var forum_con=$(this).parents(".content_div").find(".forum_po").val();//回复内容
		var topicID=$(this).parents(".content_div").find("#topicID").val();//帖子的id
		if(forum_con==''){
			layer.tips("请输入要发布的内容",'.forum_po');
			return false;
		}
/*		forum_ID 发帖人ID  
		forum_con评论内容
		user_Id  评论人ID 
		topicID 帖子id
		*/
		$.ajax({
			url:"/user/luntan/insert1.html",
			data:{"content":forum_con,"beihuiID":forum_ID,"topicID":topicID},
			type:"post",
			dataType:"json",
			success:function(data){
				
				if(data.i==0){
					layer.msg('您还没有登录哦',{icon:1,time:2000});
				}else if(data.i==1){
					layer.msg('回复失败',{icon:1,time:2000});
				}else if(data.i==2){
					window.location.reload();
					}
			},error:function(){
				
			}
			
		})
	})
	/*点击回复*/
$("body").on("click",".one_forum",function(){
	$(this).parents(".user_forum_rang").find(".second_Main").show();
	/*用户id*/
	/*var forum_ID=$(this).parents(".forum_ma").find(".content_xinxi").data("currid");*/
})
$("body").on("click",".forum_Nu",function(){
/*	$(this).parents(".forum_ma").find(".user_forum_rang").toggle();*/
	$(this).parents(".content_div").find(".user_forum").show();
	$(this).parents(".content_div").find(".forum_po").show();
	that.parents(".content_div").find(".forum_Img").css("top","191");
	$(this).parents(".content_div").find(".forun_yijifatie").removeClass("forun_yijifatie");
})
$(".shouqi").click(function(){
	
	$(this).toggleClass("check_hide_show");
	var showCheck=$(this).parents(".content_div").find(".shouqi").hasClass("check_hide_show");
	if(showCheck==true){
		$(this).find("span").hide();
		$(this).find("span").eq(1).show();
		$(this).parents(".content_div").find(".forum_po").hide();
		$(this).parents(".content_div").find(".user_forum").hide();
		$(this).parents(".content_div").find(".user_forum_rang").hide();
	}else{
		$(this).find("span").hide();
		$(this).find("span").eq(0).show();
		$(this).parents(".content_div").find(".forum_po").show();
		$(this).parents(".content_div").find(".user_forum").show();
		$(this).parents(".content_div").find(".user_forum_rang").show();
	}
	
	
})

		/*结束*/	
/*二级发布按钮触发*/
$("body").on("click",".second_user_forum",function(){
	var second=$(this);
	//var forum_ID=$(this).parents(".forum_ma").find(".content_xinxi").data("currid");//发帖人回复
	var beihuiID=$(this).parents(".user_forum_rang").find(".userName span a").eq(0).data("userid");//被回复的id
	var huiID=$(this).parents(".user_forum_rang").find(".userName span a").eq(1).data("forumid");//被回复的id
	var replyOneid=$(this).parents(".user_forum_rang").find("#replyOneid").val();//帖子的id
	if(huiID==''){
		layer.msg('您还没有登录哦',{icon:1,time:2000});
		return false;
	}
	var second_forum=$(this).parents(".second_Main").find(".second_Input").val();
	
	var topicID=$(this).parents(".content_div").find("#topicID").val();//帖子的id
	
	/*alert("beihuiID=="+beihuiID)
	alert("huiID=="+huiID)
	alert("second_forum=="+second_forum)
	alert("topicID=="+topicID)
	alert("replyOneid=="+replyOneid)*/
	
	$.ajax({
		url:"/user/luntan/insert2.html",
		data:{"content":second_forum,"beihuiID":beihuiID,"topicID":topicID,"repltOneID":replyOneid},
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.i==0){
				layer.msg('您还没有登录哦',{icon:1,time:2000});
			}else if(data.i==1){
				layer.msg('回复失败',{icon:1,time:2000});
			}else{
				window.location.reload();
				}
		  }
	   })
	
})

//
$("body").on("click",".second_forum_fit",function(){
	
})
   $("body").on("click",".thredd_user_forum",function(){
	    
    	var that=$(this);
    	var beihuiID=$(this).parents(".forum_ma").find(".content_xinxi").data("currid");//被回复id
    	var huiID=$(this).parents(".content_div").find(".user_forum").data("id");//要回复id
    	var second_forum=$(this).parents(".thred_main").find(".thred_Input").val();//回复内容
    	var topicID=$(this).parents(".content_div").find("#topicID").val();//帖子的id
    	var replyOneid=$(this).parents(".user_forum_rang").find("#replyOneid").val();//帖子的id
    	/*alert("beihuiID=="+beihuiID)
    	alert("huiID=="+huiID)
    	alert("second_forum=="+second_forum)
    	alert("topicID=="+topicID)
    	alert("replyOneid=="+replyOneid)*/
    	$.ajax({
    		url:"/user/luntan/insert2.html",
    		data:{"content":second_forum,"beihuiID":beihuiID,"topicID":topicID,"repltOneID":replyOneid},
    		type:"post",
    		dataType:"json",
    		success:function(data){
    			if(data.i==0){
    				layer.msg('您还没有登录哦',{icon:1,time:2000});
    			}else if(data.i==1){
    				layer.msg('回复失败',{icon:1,time:2000});
    			}else{
    				window.location.reload();
    				}
    		  }
    	   })

    })
})