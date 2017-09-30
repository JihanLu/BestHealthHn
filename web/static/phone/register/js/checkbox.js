;(function($){
	$.fn.extend({
		checkbox : function(){
			return this.each(function(){
				var $this = $(this);
				if($this.hasClass("on")){
    				$this.siblings("input").prop("checked","checked");
    			}else{
    				$this.siblings("input").removeAttr("checked");
    				/*layer.msg("啊啊");*/
    			
    				
    			}
    			$this.on("click",function(){
					$("#cb").click(function(){//��click�¼�
						$("#tj").prop("disabled", !this.checked);//���� tj ��disabled
					
					}).trigger('click');//���� clic
					if($this.hasClass("on")){
						$this.siblings("input").removeAttr("checked");
						$this.removeClass("on");
						
					}else{
						$this.siblings("input").prop("checked","checked");
						$this.addClass("on");

					}
				});	
    			layer.msg("注册信息请谨慎填写</br>且同意贝仕特相关协议！");
			});
		}
	});	

	

})(jQuery);

