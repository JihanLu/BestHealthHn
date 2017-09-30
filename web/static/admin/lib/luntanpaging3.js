function selectTitle1(){

		  title = document.getElementById("aaa").value.trim();
		
		  if(title==""){
			  layer.msg('标题不能为空',{icon:1,time:3000});
			  return false;
		  }else{
			  window.location.href="/admin/replyTow/selectTitle.html?title="+title;
		  }
	}
//批量删除
 function datadel(){
	
 	var Checkbox=false;
 	var checkval=new Array();
 	var boxes = document.getElementsByName("id[]");
	for(k in boxes){
		if(boxes[k].checked){
			Checkbox=true;
			checkval.push(boxes[k].value);
		}
	}
 	if (Checkbox){
 		 layer.confirm('您确认要删除选中的内容吗？', {
 		    btn: ['确定', '取消'] //按钮
 		}, function () {
 		    $.ajax({
 		        url:"/admin/replyTow/delectAll.html",
 		        dataType: "json",
 		        type: "post",
 		        data: {"items": checkval.toString()},
 		        success: function (data) {
 		        	for (var x = 0; x < boxes.length; x++) {
 		               if (boxes[x].checked) {
 		                   var oTrNode = boxes[x].parentNode.parentNode;
 		                   oTrNode.parentNode.removeChild(oTrNode);
 		                   x--;
 		               }
 		           }
 		        	layer.alert('删除成功');
 		        	/*var idDataLen=$("#idData tr").length;
 		        	//alert(idDataLen)
 		        	if(idDataLen==0){
 		        		var pageNow=parseInt($(".currentPage").text())-1;
 		        		alert(pageNow)
 		        		var title = $("#aaa").val();
 		        		window.location.href="/admin/replyTow/list3.html?title="+title+"&pageNow="+pageNow;
 		        	}*/
 		        	
 		       }
 		    });
 		}, function () {
 		     layer.close();
 		});
 	}
 	else{
 		layer.alert('请选择您要删除的内容!');
 		return false;
 	}
 }

 
 /*资讯-删除*/
 function activity_del(obj,id){
 	layer.confirm('确认要删除吗？',function(index){
 		$.ajax({
 			type: 'POST',
 			url: '/admin/replyTow/delect.html',
 			dataType: 'json',
 			  data: {"id": id},
 			success: function(data){
 				if(data.del==0){
 					$(obj).parents("tr").remove();
 					layer.msg('已删除!',{icon:1,time:1000});
 					
 					/*var idDataLen=$("#idData tr").length;
 		        	//alert(idDataLen)
 		        	if(idDataLen==0){
 		        		var pageNow=parseInt($(".currentPage").text())-1;
 		        		alert(pageNow)
 		        		var title = $("#aaa").val();
 		        		window.location.href="/admin/replyTow/list3.html?title="+title+"&pageNow="+pageNow;
 		        	}*/
 					
 				}else{
 					layer.msg('删除失败!',{icon:1,time:1000});
 				}
 				
 			},
 			error:function(data) {
 				console.log(data.msg);
 			},
 		});		
 	});
 }

