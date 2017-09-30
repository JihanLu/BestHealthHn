$(function(){
	var pageNow=window.location.search.split('=')[1];
	if(pageNow==undefined){
		return false;
	}
	var countPage = $("#totPage").val();
	
	if(pageNow==1){
		$(".ch a").eq(1).hide();
	}
	if(countPage==pageNow){
		for(var i=0;i<2;i++){
			$(".ch>img").eq(i).hide();	
		}
		
	}
})