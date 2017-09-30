/**
 * Created by Administrator on 2016/3/7.
 */
$(document).ready(function(){
//用户名
    $("#iph").focus(function(){
   var nameval=$("#name").val();
        if(nameval==""){
        	layer.msg("用户名不能为空");
            $("#name").focus();
            return false;
        }
        if(nameval.length<6||nameval.length>11){
        	layer.msg("用户名长度6-11！");
        	return false;
        }
        if(!/^[0-9a-zA-Z_]{6,}$/.test(nameval)){
        	layer.msg("用户名只能输入英文和数字！");
        	return false;
        }
    });

//手机号码
    $("#psw").focus(function(){
        var iphvar=$("#iph").val();
        var iphleng=$("#iph").val().length;
        var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
        if(iphvar==""){
        	layer.msg("请输入手机号码");
            $("#iph").focus();
            return false;
        }
        if(iphleng!=11){
        	layer.msg("手机号码长度为11位");
            $("#iph").focus();
            return false;
        }
        if(!/^0?1[3|4|5|8][0-9]\d{8}$/.test(iphvar)){
        	layer.msg("请输入正确的手机号码");
        }
    });
    
    //登录密码
$("#car").focus(function(){  
	var cfmval=$("#confim").val();
   var pswval=$("#psw").val();
   var pseleng=pswval.length;
    if(pswval==""){    
    	layer.msg("密码不能为空");
        $("#psw").focus();
        return false;        
    }else if(!/^[0-9a-zA-Z_]{6,}$/.test(pswval)){
    	layer.msg("只能输入英文和数字！");
    	return false;
    }else if(pseleng<6||pseleng>11){
    	layer.msg("登录密码长度为6-11");
        $("#psw").focus();
        return false;
    }else if(cfmval==""){    
    	layer.msg("确定密码不能为空");
        $("#confim").focus();
        return false;
    }else if(cfmval!=pswval){
    	layer.msg("确定密码一致");
        $("#confim").focus();
        return false;
    }
    
});    	 
});

