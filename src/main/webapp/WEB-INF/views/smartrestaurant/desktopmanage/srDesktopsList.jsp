<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>餐台管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/desktopmanage/srDesktops/">餐台列表</a></li>
		<shiro:hasPermission name="desktopmanage:srDesktops:edit"><li><a href="${ctx}/desktopmanage/srDesktops/form">餐台添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="srDesktops" action="${ctx}/desktopmanage/srDesktops/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>桌号：</label>
				<form:input path="number" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>容纳人数：</label>
				<form:input path="accommodate" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>桌号</th>
				<th>服务员</th>
				<th>容纳人数</th>
				<shiro:hasPermission name="desktopmanage:srDesktops:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="srDesktops">
			<tr>
				<td><a href="${ctx}/desktopmanage/srDesktops/form?id=${srDesktops.id}">
					${srDesktops.number}
				</a></td>
				<td>
					${srDesktops.waiter}
				</td>
				<td>
					${srDesktops.accommodate}
				</td>
				<shiro:hasPermission name="desktopmanage:srDesktops:edit"><td>
    				<a href="${ctx}/desktopmanage/srDesktops/form?id=${srDesktops.id}">修改</a>
					<a href="${ctx}/desktopmanage/srDesktops/delete?id=${srDesktops.id}" onclick="return confirmx('确认要删除该餐台吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>