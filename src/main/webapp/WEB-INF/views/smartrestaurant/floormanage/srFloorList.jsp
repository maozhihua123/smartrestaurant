<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>楼层管理</title>
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
		<li class="active"><a href="${ctx}/floormanage/srFloor/">楼层列表</a></li>
		<shiro:hasPermission name="floormanage:srFloor:edit"><li><a href="${ctx}/floormanage/srFloor/form">楼层添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="srFloor" action="${ctx}/floormanage/srFloor/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>层数：</label>
				<form:input path="level" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>楼层名：</label>
				<form:input path="name" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li><label>包间数量：</label>
				<form:input path="room" htmlEscape="false" maxlength="45" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>楼层名</th>
				<th>服务员数量</th>
				<th>包间数量</th>
				<shiro:hasPermission name="floormanage:srFloor:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="srFloor">
			<tr>
				<td><a href="${ctx}/floormanage/srFloor/form?id=${srFloor.id}">
					${srFloor.name}
				</a></td>
				<td>
					${srFloor.waiter}
				</td>
				<td>
					${srFloor.room}
				</td>
				<shiro:hasPermission name="floormanage:srFloor:edit"><td>
    				<a href="${ctx}/floormanage/srFloor/form?id=${srFloor.id}">修改</a>
					<a href="${ctx}/floormanage/srFloor/delete?id=${srFloor.id}" onclick="return confirmx('确认要删除该楼层吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>