<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 研究院信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/admin/news/selectAll.html" data-title="资讯新闻" href="javascript:void(0)">资讯新闻</a></li>
					<li><a data-href="${pageContext.request.contextPath}/admin/activity/selectAll.html" data-title="活动安排" href="javascript:void(0)">活动安排</a></li>

					<li><a data-href="${pageContext.request.contextPath}/admin/about/selectAll.html" data-title="联系我们" href="javascript:void(0)">联系我们</a></li>
					<li><a data-href="${pageContext.request.contextPath}/admin/inform/selectAll.html" data-title="通知公告" href="javascript:void(0)">通知公告</a></li>
					<li><a data-href="${pageContext.request.contextPath}/admin/literature/selectAll.html" data-title="文献发布" href="javascript:void(0)">文献列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/admin/intro/selectAll.html?mark=0" data-title="研究院简介" href="javascript:void(0)">研究院简介</a></li>
					<li><a data-href="${pageContext.request.contextPath}/admin/intro/selectAll.html?mark=1" data-title="领导人简介" href="javascript:void(0)">领导人简介</a></li>
					<li><a data-href="${pageContext.request.contextPath}/admin/intro/selectAll.html?mark=2" data-title="组织机构" href="javascript:void(0)">组织机构</a></li>
					<li><a data-href="${pageContext.request.contextPath}/admin/intro/selectAll.html?mark=3" data-title="宗旨与行动准则" href="javascript:void(0)">宗旨与行动准则</a></li>
					<li><a data-href="${pageContext.request.contextPath}/admin/intro/selectAll.html?mark=4" data-title="领导致辞" href="javascript:void(0)">领导致辞</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-article1">
		<dt><i class="Hui-iconfont">&#xe616;</i> 论坛信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		<dd>
			<ul>
				<li><a data-href="${pageContext.request.contextPath}/admin/forum/selectAll.html?mark=0" data-title="养生论坛简介" href="javascript:void(0)">养生论坛简介</a></li>
				<li><a data-href="${pageContext.request.contextPath}/admin/forum/selectAll.html?mark=1" data-title="组委会名单" href="javascript:void(0)">组委会名单</a></li>
				<li><a data-href="${pageContext.request.contextPath}/admin/forum/selectAll.html?mark=2" data-title="组织机构" href="javascript:void(0)">组织机构</a></li>
				<li><a data-href="${pageContext.request.contextPath}/admin/forum/selectAll.html?mark=3" data-title="宗旨与主题" href="javascript:void(0)">宗旨与主题</a></li>
				<%--<li><a data-href="${pageContext.request.contextPath}/admin/forum/permit/show.html" data-title="单位批复" href="javascript:void(0)">单位批复</a></li>--%>
				<li><a data-href="${pageContext.request.contextPath}/admin/picture/list.html" data-title="单位批复" href="javascript:void(0)">单位批复</a></li>
				<li><a data-href="${pageContext.request.contextPath}/admin/file/list.html" data-title="相关下载文件列表" href="javascript:void(0)">相关下载文件列表</a></li>
			</ul>
		</dd>
		</dl>

		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe613;</i> 文献管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/admin/inform/selectAll.html" data-title="文献管理" href="javascript:void(0)">文献列表</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> 项目产品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/admin/recommend/selectAll.html" data-title="产品管理" href="javascript:void(0)">项目产品列表</a></li>
				
				</ul>
			</dd>
		</dl>
		<%--<dl id="menu-comments">--%>
			<%--<dt><i class="Hui-iconfont">&#xe622;</i> 论坛管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>--%>
			<%--<dd>--%>
				<%--<ul>--%>
					<%--<li><a data-href="${pageContext.request.contextPath}/admin/topic/list.html" data-title="发帖列表" href="javascript:;">发帖列表</a></li>--%>
				<%--</ul>--%>
			<%--</dd>--%>
		<%--</dl>--%>
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/admin/user/selectTitle.html" data-title="用户列表" href="javascript:;">用户列表</a></li>
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					
					<li><a data-href="${pageContext.request.contextPath}/admin/admin/selectAll.html" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
				</ul>
			</dd>
		</dl>
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>