   $(function(){
	   
	  $(".one_forum").hide();
	   var useID=$(".content_div").eq(0).find(".user_forum").data("id");
	   if(useID==''){
		  $(".one_forum").hide();
		  return false;
	   }
	   var content_div=$(".content_div");
	   var conLen=content_div.length;
	   for(var i=0;i<content_div.length;i++){
		   content_div[i].index=i;
		/*   var useVal=$(".content_div").eq(i).find(".user_forum_rang:last").find(".userName span").eq(0).data("userid");*/
		   var useVal=$(".content_div").eq(i).find(".user_forum_rang:last").find(".userName span a").eq(1).data("forumid");
		  /* alert(useID)
		    alert(useVal)*/
		 if(useVal==useID){
			 /*  alert(i)*/
			  
			   $(".content_div").eq(i).find(".content_xinxi").find(".one_forum").show();
		   }
		 
		  
		     
	   }
	/*点击二级回复出现发布按钮*/
	$(".second_forum_fit").click(function(){
		$(this).parents(".second_owenBen").find(".thred_main").show();
	})
	var user_forum_rang=$(".user_forum_rang");
	 for(var i=0;i<content_div.length;i++){ 
		 for(var j=0;j<user_forum_rang.length;j++){
			 console.log(content_div.eq(i).find(".user_forum_rang").eq(j).find(".second_forun").length)
			 if(content_div.eq(i).find(user_forum_rang).eq(j).find(".second_forun").length>0){
				 content_div.eq(i).find(".user_forum_rang").eq(j).find(".one_forum").hide();	
			 }
		 }
		
	 }
	$(".second_forum_fit").hide();
	for(var i=0;i<content_div.length;i++){ 
		 for(var j=0;j<user_forum_rang.length;j++){
			 console.log(content_div.eq(i).find(".user_forum_rang").eq(j).find(".second_forun").length)
			 if(content_div.eq(i).find(user_forum_rang).eq(j).find(".second_forun").length>0){
				
				 var  useVal=content_div.eq(i).find(".user_forum_rang").eq(j).find(".second_forun:last").find(".userName span a").eq(1).data("userid");
			     /*useID当前登录用户的id*/
				 if(useVal==useID){	
					 content_div.eq(i).find(".user_forum_rang").eq(j).find(".second_forun:last").find(".second_forum_fit").show();
				   }
			 }
		 }
		
	 }
	
   })