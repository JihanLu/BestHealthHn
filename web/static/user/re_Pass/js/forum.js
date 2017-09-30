﻿$(function(){

	$(".info_save").click(function(){
		/*info_nickName 原密码*/
		/*new_pass 新密码*/
		var info_nickName=$(".old_pass").val().trim();
		var info_iphone=$(".old_iphone").val().trim();
		var new_pass=$(".new_pass").val().trim();
		if(info_nickName==''){
			layer.msg("原密码不能为空",{icon:6});
			$(".old_pass").foucs();
			return false;
		}
		if(info_iphone==""){
			layer.msg("手机号码不能为空",{icon:6});
			$(".old_iphone").foucs();
			return false;
		}
        var reg_iph = /^[1][3578]\d{9}$/;
             if (!reg_iph.test(info_iphone)) {
            	 layer.msg("手机号码格式输入错误",{icon:6});
                 return false;
        }
		if(new_pass==''){
			layer.msg("新密码不能为空",{icon:6});
			$(".new_pass").foucs();
			return false;
		}
		var reg=/^[0-9a-zA-Z_]{6,}$/;
		if(new_pass.length<5||new_pass.length>16){
			layer.msg("密码长度为6-11",{icon:6})
			return false;
		}
		if(!reg.test(new_pass)){
			layer.msg("密码由数字或字母或下划线组成，长度最多为6-16",{icon:6});
			return false;
		}
		$.ajax({
			url:"",
			data:{"info_nickName":info_nickName,"new_pass":new_pass},
			type:"post",
			success:function(data){
				if(data.a=="0"){
					layer.msg("原密码不正确",{icon:6})
					return false;
				}else if(data.a="1"){
					layer.msg("原手机号码不对",{icon:6});
					return false;
				}
				else{
					layer.msg("修改密码成功",{icon:6})
	                                setTimeout(function(){
						window.location.reload();
					},1500)
				}
			},error:function(data){
				alert("error");
			}
		})
		
	})
})