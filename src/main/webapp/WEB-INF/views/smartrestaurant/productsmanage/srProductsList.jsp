<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>菜品管理</title>
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
		<li class="active"><a href="${ctx}/productsmanage/srProducts/">菜品列表</a></li>
		<shiro:hasPermission name="productsmanage:srProducts:edit"><li><a href="${ctx}/productsmanage/srProducts/form">菜品添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="srProducts" action="${ctx}/productsmanage/srProducts/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>标签：</label>
				<form:checkboxes path="tagIds" items="${fns:getDictList('TAGS')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>标签</th>
				<th>排序</th>
				<th>价格</th>
				<th>单位</th>
				<th>销量</th>
				<shiro:hasPermission name="productsmanage:srProducts:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="srProducts">
			<tr>
				<td><a href="${ctx}/productsmanage/srProducts/form?id=${srProducts.id}">
					${srProducts.name}
				</a></td>
				<td>
					${fns:getDictLabel(srProducts.tagIds, 'TAGS', '')}
				</td>
				<td>
					${srProducts.sort}
				</td>
				<td>
					${srProducts.price}
				</td>
				<td>
					${fns:getDictLabel(srProducts.unit, 'UNIT', '')}
				</td>
				<td>
					${srProducts.count}
				</td>
				<shiro:hasPermission name="productsmanage:srProducts:edit"><td>
    				<a href="${ctx}/productsmanage/srProducts/form?id=${srProducts.id}">修改</a>
					<a href="${ctx}/productsmanage/srProducts/delete?id=${srProducts.id}" onclick="return confirmx('确认要删除该菜品吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>