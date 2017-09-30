/**
 * Created by Administrator on 2016/5/19.
 */
function checkLog(){
    var useval=$("input[type=text]").val();
    if(useval==""){
        layer.msg("用户名不能为空");
        return false;
    }
    var pas=$("input[type=password]").val();
    if(pas==""){
        layer.msg("密码不能为空");
        return false;
    }
    $.ajax({
		type:"post",
		url:"/user/phone/login.html",
		data:{"account":useval,"password":pas},
		dataType:"json",
		async: false,
		success:function(data){
			if(data.a=="7"){
				window.location="/user/phone/logins.html?userID="+data.id+"";
			}else if(data.a=="6"){
				 layer.msg("密码错误！");
			}else if(data.a=="5"){
				layer.msg("用户名不存在！");
			}else if(data.a=="4"){
				layer.msg("用户名为空！");
			}else{
				layer.msg("用户名不存在！");
			}
		},
		error:function(data){
			alert("返回类型错误...")
		}
    });
}
function wjmima(){
/*	layer.msg("请使用手机号联系管理员若同手机号存在多个账户请表明所需要修改的用户名管理员：1XXXXXXXXXX")*/
	layer.msg("请使用手机号联系管理员</br>" +
			"若同手机号存在多个账户</br>" +
			"请表明所需要修改的用户名</br>"+
			"管理员：1XXXXXXXXXX",{time:5000,offset:'50%'});
	
}
