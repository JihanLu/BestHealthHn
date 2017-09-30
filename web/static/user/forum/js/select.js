$(function(){
	/*发布触发*/
	$(".forun_right").click(function(){
		
		var edi=editor.$txt.html();
		
		if(edi==''){
			layer.tips("发布内容不能为空",'#editor');
			return false;
		}
		$.ajax({
			url:"/user/luntan/insert.html",
			data:{"content":edi},
			type:"post",
			dataType:"json",
			success:function(data){
				
				if(data.i==1){
					layer.tips("发布成功",'.forun_right');
					setTimeout(function(){
						window.location.reload();
					},1000)
					
				}else if(data.i==0){
					layer.tips("发布失败",'.forun_right');
					return false;
				}else{
					/*alert("aa")*/
					layer.msg("登录才能发布");
					
				}
				
			},error:function(){
				
			}
			
		})
	})
	$('#editor').css('height', 100);
	
})