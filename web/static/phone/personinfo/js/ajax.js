/**
 * Created by Administrator on 2016/6/22.
 */
$(function(){	
	$(".head_A").click(function(){
		$(".tk").show();
	})
	setTimeout(function(){
		/*alert("aa")*/
		$(".tk").hide();		
	},5000);
	
});
$(function(){	
	$("#dl").click(function(){		
		$(".tk").hide();
		$(".pd").show();
	})
	setTimeout(function(){
		/*alert("aa")*/
		$(".pd").hide();		
	},5000);
	
})
/*$(function(){
    var url="/home/action/userjson";
    var playlist;
    $.ajax({
        type:"post",
        url:url,
        data:{"i":"1"},
        cache: false,
        dataType: "json",
        error:function(){
            layer.msg("请重新登陆");
        },
        success:function(data){
            var value =eval(data);
            playlist = new Array();
            $(".shipinbofantotal").html("");
            //遍历json返回数据
            $.each(value['list'],function(i,mem){
                          alert(mem.wifioff);
                playlist=data.list;
                $("img").attr("src",mem.photo);
                console.log($("img").attr("src"));
                $("input[name=name]").attr("value",mem.name);
                $("input[name=tel]").attr("value",mem.phone);
              

            });
        }
    })   
});*/
function crk(){
	var name = document.myform.name.value;
    var sex = document.myform.sex.value;
    var phone = document.myform.phone.value;
    var id = document.myform.i01d.value;

    var pre1 = /^1[3-8]+\d{9}$/;
    if(!pre1.test(phone)){
    	alert("手机号码格式不正确！");
     /*layer.open({
            content: '手机号码格式不正确！',
            style: 'background-color:#fff; color:#333; border:none;font-size:1.2em;text-align:center;font-family:Microsoft YaHei',
            time: 5000
        });
        document.myform.tel.focus();*/
    	return false;
    }
    var pre2=/^[\u4E00-\u9FA5\uF900-\uFA2D\da-zA-Z]{2,10}$/;
    if(!pre2.test(name)){
    	alert("昵称需在2-10个字符之间！");
       /* layer.open({
            content: '昵称需在2-8个字符之间！',
            style: 'background-color:#fff; color:#333; border:none;font-size:1.2em;text-align:center;font-family:Microsoft YaHei',
            time: 5000
        });
        document.myform.name.focus();*/
        return false;
    }else{
    	$.ajax({
		url:"/user/phone/UpdateUserInfo.html",
    	type:"post",
		data:{"name":name,"sex":sex,"phone":phone,"userID":id},
		dataType:"json",
		async: false,
		success:function(data){
			if(data.a=="5"){
				alert("修改成功！");
				window.location="/user/phone/skipUserInfo.html";
				/*layer.alert("修改成功！");*/
				/*layer.msg("修改成功！");*/
			    /*alert(data.a);*/
				 /* layer.open({
			            content: '修改成功！',
			            style: 'background-color:#fff; color:#333; border:none;font-size:1.2em;text-align:center;font-family:Microsoft YaHei',
			            time: 5000
			        });*/
				/*setTimeout(function(){
					window.location="/user/phone/skipUserInfo.html";				
				},5000)*/
				
			}else if(data.a=="1"){
				alert("昵称已存在！");
				 /*layer.msg("昵称已存在！");*/
				 return false;
			}else{
				alert("昵称已存在！");
				/*layer.msg("添加失败！");*/
				return false;
			}
		},
		error:function(data){
			layer.msg("返回未知错误！");
			return false;
		}
    });
    }
}
