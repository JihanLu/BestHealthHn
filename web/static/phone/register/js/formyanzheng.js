/**
 * Created by Administrator on 2016/3/8.
 */
function checkReg(){
    var jsnameval=document.getElementById("name").value;
    var names=$("#name").val();
    if(jsnameval==""){
        layer.msg("用户名不能为空");
        document.getElementById("name").focus();
        return false;
    }
    if(!/^[0-9a-zA-Z_]{6,}$/.test(names)){
    	layer.msg("用户名只能输入英文和数字！");
    	return false;
    }
    if(names.length<6||names.length>11){
    	layer.msg("用户名长度6-11！");
    	return false;
    }
    var jsiphvar=document.getElementById("iph").value;
    var phones=$("#iph").val();
    var jsiphleng=jsiphvar.length;
    var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
    if(jsiphvar==""){
    	layer.msg("请输入手机号码");
        document.getElementById("iph").focus();
        return false;
    }
    if(!/^0?1[3|4|5|8][0-9]\d{8}$/.test(phones)){
    	layer.msg("请输入正确的手机号码");
        return false;
    }
    if(phones.length!=11){
    	layer.msg("手机号码长度为11位");
        return false;
    }
    var jscfmval=document.getElementById("confim").value;
    var jspswvar= document.getElementById("psw").value;
    var jspswleng=jspswvar.length;
   
    if(jspswvar==""){       
    	layer.msg("密码不能为空");
    	document.getElementById("psw").focus();
    	return false;     	
    }
    if(jspswleng<6||jspswleng>11){
    	layer.msg("登录密码过于简单");
        document.getElementById("psw").focus();
        return false; 
    }
    if(jscfmval==""){       
    	layer.msg("确认密码不能为空");
    	document.getElementById("confim").focus();
    	return false;     	
    }
    if(jscfmval!=jspswvar){
    	layer.msg("确认密码一致");
    	document.getElementById("confim").focus();
        return false;
    }
    var jscodeval=document.getElementById("code").value.toLowerCase();
    var jscodessval=document.getElementById("check_Code").innerHTML.toLowerCase();
    
    if(jscodeval==""){      
    	layer.msg("请输入您的验证码");
    	document.getElementById("code").focus();
    	return false;     	
    }
    if(jscodessval!=jscodeval){      
    	layer.msg("验证码不正确");
    	document.getElementById("check_Code").focus();
    	return false;     	
    }
    if($("#checkb").val()=="on"){      
     	
    }else{
    	layer.msg("未同意贝仕特相关协议！");
    
    	return false;    
    }
   
     $.ajax({
		type:"post",
		url:"/user/phone/add.html",
		data:{"account":jsnameval,"password":jspswvar,"phone":jsiphvar},
		dataType:"json",
		async: false,
		success:function(data){
			if(data.a=="8"){
				window.location="/user/phone/logins.html?userID="+data.id+"";
			}else if(data.a=="2"){
				layer.msg("注册失败！");
			}else if(data.a=="1"){
				layer.msg("用户已存在！");
			}else if(data.a=="0"){
				layer.msg("注册失败！");
			}else{
				alert("发生未知错误...");
			}
		},
		error:function(data){
			alert("返回类型错误...")
		}
    });
	
   /* jsagreeval=document.getElementById("checkb").checked;
    alert(jsagreeval)*/
    /*var jsagreeval=document.getElementById("checkb").checked;
     
    if($("#checkb").prop("checked")){         
    	layer.msg("请点击同意协议");
    	document.getElementById("checkb").focus();
    	return false;     	
    }*/
    /*if($("input[type='checkbox'][name='qw']:checked").attr("checked")){
    	alert("ff")
    	}else{
    	alert("gg")
    	}*/
   

}