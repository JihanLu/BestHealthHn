   $(function(){
        $(".log_button").click(function(){
            var login_val=$(".login_val").val().trim();
            var pass_val=$(".pass_val").val().trim();
            var show_code=$(".show_code").val().trim();
            var check_Code=$("#check_Code").text().trim();
            if(login_val==''){
                layer.tips("用户名不能为空",".login_val");
                return false;
            }
           
            if(pass_val==''){
                layer.tips("密码不能为空",".pass_val");
                return false;
            }
           
            if(show_code==''){
                layer.tips("验证码不能为空",".show_code");
                return false;
            }
            if(show_code.toUpperCase()!=check_Code.toUpperCase()){
                layer.tips("请输入正确的验证码","#check_Code");
                return false;
            }
            $.ajax({
    			type:"post",
    			url:"/user/indes/login.html",
    			data:{"account":login_val,"password":pass_val},
    			dataType:"json",
    			success:function(data){
    				if(data=="7"){
    					window.location.reload();
    				}else if(data=="6"){
    					 layer.tips("密码错误！",".pass_val");
    				   
    				}else if(data=="5"){
    			
    					 layer.tips("用户名不存在",".login_val");
    				}else if(data=="4"){
    					
    					layer.tips("用户名为空！",".login_val");
    				}else{
    				
    					layer.tips("用户名不存在！",".login_val");

    				}
    			},
    			error:function(data){
    				alert("返回类型错误...")
    			}
            });
        })
        $(".reg_button").click(function(){
            var reg_user_val=$(".reg_user_val").val().trim();
            var reg_pass_old_val=$(".reg_pass_old_val").val().trim();
            var reg_pass_age_val=$(".reg_pass_age_val").val().trim();
            var reg_iph_val=$(".reg_iph_val").val().trim();
            if(reg_user_val==''){
                layer.tips("用户名不能为空",".reg_user_val");
                return false;
            }
           
    		if(reg_user_val.length<6||reg_user_val.length>11){
    			
    			 layer.tips("用户名长度为6-11",".reg_user_val");
    			layer.close();
    			return false;
    		}
    		 var reg_User=/^[0-9a-zA-Z_]{6,}$/;
    		if(!reg_User.test(reg_user_val)){
    			 layer.tips("用户名由数字或字母或下划线组成，长度最多为6-16",".reg_user_val");
    			
    			return false;
    		}

            if(reg_pass_old_val==''){
                layer.tips("密码不能为空",".reg_pass_old_val");
                return false;
            }
            var pass_User=/^[0-9a-zA-Z_]{6,}$/;
    		if(reg_pass_old_val.length<5||reg_pass_old_val.length>16){
    	
    			layer.tips("密码长度为6-11",".reg_pass_old_val");
    			return false;
    		}
    		if(!pass_User.test(reg_pass_old_val)){
    		
    			layer.tips("密码由数字或字母或下划线组成，长度最多为6-16",".reg_pass_old_val");
    			return false;
    		}
            if(reg_pass_age_val==''){
                layer.tips("确认密码不能为空",".reg_pass_age_val");
                return false;
            }
            if(reg_pass_old_val!=reg_pass_age_val){
                layer.tips("两次输入的密码不相同",".reg_pass_age_val");
                return false;
            }
            if(reg_iph_val==''){
                layer.tips("手机号码不能为空",".reg_iph_val");
                return false;
            }
            var reg = /^[1][3578]\d{9}$/;
            if ( !reg.test(reg_iph_val)) {
                layer.tips("手机号码格式输入错误",".reg_iph_val");
                return false;
            }
            $.ajax({
    			type:"post",
    			url:"/user/indes/add.html",
    			data:{"account":reg_user_val,"password":reg_pass_old_val,"phone":reg_iph_val},
    			dataType:"json",
    			success:function(data){
    				if(data=="8"){
    					window.location.reload();
    				/*	window.location="/user/index/home.html";*/
    				}else if(data=="2"){
    					
    					layer.tips("注册失败！",".reg_button");
    				}else if(data=="1"){
    				
    					layer.tips("用户已存在！",".reg_user_val");
    				}else if(data=="0"){
    					layer.tips("内容为空！",".reg_user_val");
    				}else{
    					alert("发生未知错误...");
    				}
    			},
    			error:function(data){
    				alert("返回类型错误...")
    			}
            });
        })
        $(".forget").click(function(){
            layer.tips("请联系管理员",".forget");
        })
    })


