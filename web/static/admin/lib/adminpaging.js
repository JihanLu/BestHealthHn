function selectTitle1(){

		  title = document.getElementById("aaa").value.trim();
		
		  if(title==""){
			  layer.msg('账号不能为空',{icon:1,time:3000});
			  return false;
		  }else{
			  window.location.href="/admin/admin/selectTitle.html?title="+title+"";
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
 		        url:"/admin/admin/delectAll.html",
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

 /*资讯-编辑*/
 function article_edit(id){
 	window.location.href="/admin/admin/select.html?id="+id+"";
 }
 
 
 /*资讯-删除*/
 function activity_del(obj,id){
 	layer.confirm('确认要删除吗？',function(index){
 		$.ajax({
 			type: 'POST',
 			url: '/admin/admin/delect.html',
 			dataType: 'json',
 			  data: {"id": id},
 			success: function(data){
 				if(data.del==0){
 					$(obj).parents("tr").remove();
 					layer.msg('已删除!',{icon:1,time:1000});
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


function goPage(pno,psize){
            var itable = document.getElementById("idData");
            var num = itable.rows.length;//表格所有行数(所有记录数)
            /*console.log(num);*/
            var totalPage = 0;//总页数
            var pageSize = psize;//每页显示行数
            //总共分几页
            if(num/pageSize > parseInt(num/pageSize)){
                totalPage=parseInt(num/pageSize)+1;
            }else{
                totalPage=parseInt(num/pageSize);
            }
            var currentPage = pno;//当前页数
            var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  
            var endRow = currentPage * pageSize;//结束显示的行   
            endRow = (endRow > num)? num : endRow;    
            /*console.log(endRow);*/
            //遍历显示数据实现分页
            for(var i=1;i<(num+1);i++){
                var irow = itable.rows[i-1];
                if(i>=startRow && i<=endRow){
                    irow.style.display = "table-row";
                  irow.firstElementChild.firstElementChild.setAttribute("name","id[]")
                }else{
                    irow.style.display = "none";
                    irow.firstElementChild.firstElementChild.removeAttribute("name","")
                }
            }
            /*var pageEnd = document.getElementById("pageEnd");*/
            var tempStr = "共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
            if(currentPage>1){
                tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
                tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"><上一页</a>"
            }else{
                tempStr += "<span class='disabled'>首页</span>";
                tempStr += "<span class='disabled'><上一页</span>";
            }
            if(currentPage != 1 && currentPage >= 4 && totalPage != 4){
                tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\">"+1+"</a>"
            }
            if(currentPage-2 > 2 && currentPage <= totalPage && totalPage > 5){
                tempStr +="<span>...</span>";
            }
            var start = currentPage -2,end = currentPage+2;
            if((start > 1 && currentPage < 4)||currentPage == 1){
                end++;
            }
            if(currentPage > totalPage-4 && currentPage >= totalPage){
                start--;
            }
            for (;start <= end; start++) {
                if(start <= totalPage && start >= 1){
                    if(start != currentPage){
                        tempStr += "<a href=\"#\" onClick=\"goPage("+(start)+","+psize+")\">"+start+"</a>"
                    }else{
                        tempStr += "<span class='current'>"+start+"</span>";
                    }
                }
            }
            if(currentPage + 2 < totalPage - 1 && currentPage >= 1 && totalPage > 5){
                tempStr +="<span>...</span>";
            }
            if(currentPage != totalPage && currentPage < totalPage -2  && totalPage != 4){
                tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\">"+totalPage+"</a>"
            }

            if(currentPage<totalPage){
                tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页></a>";
                tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
            }else{
                tempStr += "<span class='disabled'>下一页></span>";
                tempStr += "<span class='disabled'>尾页</span>";
            }

            document.getElementById("tcdPageCode").innerHTML = tempStr;

}
