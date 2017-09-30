$(function(){
	$(".info_save").click(function(){
		var info_nickName=$(".info_nickName").val().trim();
		var info_pass=$(".info_pass").val().trim();
		var userID=$("#userID").val();
		var iphne=$(".iphne").val().trim();
		if(info_pass==''){
			layer.msg("密码不能为空",{icon:6});
			return false;
		}
		if(info_nickName==''){
			layer.msg("呢称不能为空",{icon:6});
			return false;
		}
		if(info_nickName.length>10){
			layer.msg("呢称不能超10个字",{icon:6})
			return false;
		}
		  var reg_iph = /^[1][3578]\d{9}$/;
		  if(iphne==''){
				 layer.msg("手机号码不能为空",{icon:6});
				 return false;
		  }
          if (!reg_iph.test(iphne)) {
         	 layer.msg("手机号码格式输入错误",{icon:6});
              return false;
           }
          
          $.ajax({
  			url:"/user/indes/update.html",
  			data:{"id":userID,"name":info_nickName,"phone":iphne,"password":info_pass},
  			type:"post",
  			dataType:"json",
  			success:function(data){
  				if(data.i==1){
  					layer.tips("修改成功",'.info_save');
  					setTimeout(function(){
  						window.location.reload();
  					},1500)
  					
  				}else if(data.i==3){
  					layer.tips("昵称已存在",'.info_save');
  					return false;
  				}else if(data.i==0){
  					layer.tips("更新失败",'.info_save');
  					return false;
  				}else{
  					/*alert("aa")*/
  					layer.msg("请登录",'.info_save');
  					
  				}
  				
  			},error:function(){
  				
  			}
  			
  		})
	})
})