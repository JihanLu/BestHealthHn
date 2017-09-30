<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/static/h-ui/css/pageSty.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/static/h-ui/css/theme.css" />
<title>论坛列表</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		论坛管理 <span class="c-gray en">&gt;</span> 论坛列表 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
			<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除</a> 
			<%-- <a class="btn btn-primary radius" data-title="添加活动"
				href="${pageContext.request.contextPath}/admin/activity/insertjsp.html">
				<i class="Hui-iconfont">&#xe600;</i> 添加活动</a> --%>
				<input type="text" value="${title}" id="aaa" name="selectTitle" placeholder="请输入发布账号"
				style="width: 250px" class="input-text">
				<a href="javascript:;"  onclick="selectTitle1()" class="btn btn-success" >
				<i class="Hui-iconfont">&#xe665;</i> 搜索
			</a>
				
				</span> <%-- <span
				class="r">共有数据：<strong>${actitylist.size()}</strong> 条
			</span> --%>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="45"><input type="checkbox" id="checkall"/>全选</th>
						<!-- <th width="80">序号</th> -->
						
						<th>发布账号</th>
						<th>昵称</th>
						<th>内容</th>
						<th>评论详情</th>
						<th>发布时间</th>
						<th width="120">操作</th>
					</tr>
				</thead>
				<tbody id="idData">
					<c:forEach items="${list}" var="topic"  varStatus="loop">
						<tr class="text-c">
							<td><input type="checkbox" value="${topic.topicID}" name="id[]" onclick="check()"></td>
						<%-- 	<td>${activity.id}</td> --%>
						
							<td>
							 ${userlist[loop.count-1].account}
							
							</td>
							<td>
							 ${userlist[loop.count-1].name}
							
							</td>
							<td>${topic.content}</td>
							<td><a href="${pageContext.request.contextPath}/admin/replyOne/list1.html?id=${topic.topicID}">评论详情</a></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${topic.time}"/></td>


							<td class="f-14 td-manage">
								<a style="text-decoration: none" class="ml-5" onClick="activity_del(this,'${topic.topicID}')" href="javascript:;"
								title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
	<c:if test="${totalPage >=1}">
								<div class="fanyue">
									<div class="list-page">
									<c:if test="${pageNow != 1}">
										<a title="${pageNow-1}" class="pageStyle"> 上一页 </a>
									</c:if>
									<!-- 页数列表 -->
									<c:forEach var="n"
										begin="${pageNow>4?pageNow+5>totalPage?totalPage>10?totalPage-9:1:pageNow-4:1}"
										end="${pageNow>4?pageNow+5>totalPage?totalPage:pageNow+5:totalPage>10?10:totalPage}">
										<c:choose>
											<c:when test="${n == pageNow}">
												<span title="${n}" class="currentPage pageStyle">${n}</span>
											</c:when>
											<c:otherwise>
												<a title="${n}" class="pageStyle">${n}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<!-- 下一页 -->
									<c:if test="${pageNow != totalPage}">
										<a title="${pageNow+1}" class="pageStyle"> 下一页 </a>
									</c:if>
								    </div>
								</div>
							</c:if>
	<form action="${pageContext.request.contextPath}/admin/topic/list.html" method="post" id="pageform"></form>
	
	<!-- <div class="tcdPageCode" id="tcdPageCode"></div> -->

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/admin/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/admin/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/admin/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/admin/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->
	
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/admin/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/admin/lib/luntanpaging.js"></script>

<script type="text/javascript">
	
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,8]}// 不参与排序的列
	]
});


//全选
$("#checkall").click(function(){ 
	if(this.checked){
		 $("input[name='id[]']").each(function(){
				  this.checked = true;
			  });
	}else{
		 $("input[name='id[]']").each(function(){
				  this.checked = false;
			  });
	}
});
function check(){
  var checkBoxs = $("input[name='id[]']:checked").length;
  var allcheckBoxs = $("input[name='id[]']").length;
  if (checkBoxs < allcheckBoxs) {
      $("#checkall").attr("checked", false);
  } else {
      $("#checkall").attr("checked", true);
  }
}
</script>


		<script type="text/javascript">
			$(".list-page a").click(function() {
				pageNow = $(this).attr("title");
				title = $("#aaa").val();
				$("#pageform").append("<input type=\"hidden\" name=\"pageNow\" value="+pageNow+">");
				$("#pageform").append("<input type=\"hidden\" name=\"title\" value="+title+">");
				$("#pageform").submit();
			});
</script>


</body>
</html>