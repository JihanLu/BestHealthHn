
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
//图片延迟加载
if(document.querySelectorAll !== undefined){
	if(typeof Echo !== 'undefined' ){
		Echo.init({
		    offset: 0,
		    throttle: 0
		});
	}
}
function seller_vote(obj,id){
	if($('#seller-vote').size() > 0) return false;
	var url = $(obj).attr('data');
	var pos = $(obj).offset();
	var w = $(obj).width();
	var html = '<div id="seller-vote" style="position: absolute;top:' + (pos.top - 30) + 'px;left:' + (pos.left - (120-w)/2) + 'px;height:30px;line-height:30px; width:140px;text-align:center;font-size:14px; color:#f00;background:rgba(255,255,255,0.6);border-radius:20px;z-index:9999;"></div>';
	$(html).appendTo($('body'));
	$.getJSON(url,{'id':id},function (data){
		if(data.status == 1){
			var num = $(obj).find('span').text();
			var titles = $(obj).find('span').attr('title');
			$(obj).find('span').attr('title',parseInt(titles) + 1);
			if(!isNaN(num)){
				$(obj).find('span').text(parseInt(num) + 1);
			}
		}
		$('#seller-vote').html(data.info);
		setTimeout(function (){
			$('#seller-vote').animate({
				'top': pos.top - 30 - 40
			},function (){
				$('#seller-vote').remove();
			});
		},1000);
	});
}