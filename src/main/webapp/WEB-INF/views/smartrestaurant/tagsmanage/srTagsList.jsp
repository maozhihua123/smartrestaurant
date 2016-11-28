<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>标签管理</title>
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
		<li class="active"><a href="${ctx}/tagsmanage/srTags/">标签列表</a></li>
		<shiro:hasPermission name="tagsmanage:srTags:edit"><li><a href="${ctx}/tagsmanage/srTags/form">标签添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="srTags" action="${ctx}/tagsmanage/srTags/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标签名：</label>
				<form:input path="label" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>数据值</th>
				<th>标签名</th>
				<th>排序（升序）</th>
				<shiro:hasPermission name="tagsmanage:srTags:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="srTags">
			<tr>
				<td><a href="${ctx}/tagsmanage/srTags/form?id=${srTags.id}">
					${srTags.value}
				</a></td>
				<td>
					${srTags.label}
				</td>
				<td>
					${srTags.sort}
				</td>
				<shiro:hasPermission name="tagsmanage:srTags:edit"><td>
    				<a href="${ctx}/tagsmanage/srTags/form?id=${srTags.id}">修改</a>
					<a href="${ctx}/tagsmanage/srTags/delete?id=${srTags.id}" onclick="return confirmx('确认要删除该标签吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>