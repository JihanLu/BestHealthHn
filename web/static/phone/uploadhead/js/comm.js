/**
 * Created by Administrator on 2016/5/26.
 */
function t_loading (html){
    var html=arguments[0]?arguments[0]:'';
    $('#tips').html('<div><p class="loading">'+html+'</p></div>').show();
}

function t_delay(html,timer){
    var timer=arguments[1]?arguments[1]:800;
    $('#tips').html('<div>'+html+'</div>').show().delay(timer).fadeOut();
}

function t_hide(){
    $('#tips').hide();
}

function confirmit(url,method,sends,callback){
    $.confirm({
        'title':'删除记录?',
        'message':'您确认删除该记录? <br />删除后无法恢复记录.',
        'buttons':{
            '确定':{'class':'blue',
                'action': function(){
                    t_loading('请求提交中...');
                    if(method=='get'){
                        $.get(url,sends,function(data){
                            if(data){
                                t_delay(data.info,500);
                                if(data.status==1&&callback) callback();
                            }else{
                                t_delay('未知错误',500);
                            }
                        },'json');
                    }else{
                        $.post(url,sends,function(data){
                            if(data){
                                t_delay(data.info,500);
                                if(data.status==1&&callback) callback();
                            }else{
                                t_delay('未知错误',500);
                            }
                        },'json');
                    }
                }
            },
            '取消':{'class':'gray'}
        }
    });
}

//顶部返回键
var url = window.location.pathname;
if(url.indexOf('index')==1||url=='/'){
    $('#toper a:first').html('<i class="fa fa-home"></i>').attr('href','/');
}else{
    $('#toper a:first').html('<i class="fa fa-angle-left"></i>').attr('href','javascript:window.history.back(-1);');
}