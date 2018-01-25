#parse("content/base/back/common/macro.vm")
<!DOCTYPE html>
<html lang="en">
#parse("content/base/back/common/head.vm")
<body style='overflow:scroll;overflow-x:hidden'>
	<div class="container bs-docs-container" style="width:100%;">
		<div class="row">
			<form role="form" class="form-inline" action="$!{basePath}/${projectName}/${lowerName}.do?list" method="post"  id="formSubmit">
				<div  class="col-md-10" style="width:100%">
					<div class="panel panel-default">
						<div class="panel-heading">列表</div>
						<div class="panel-body">
							<div class="search">
								<#list columnDatas as item>
									<#if item.columnName != 'id'>
									<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
									<#if item.columnType == "datetime" ||item.columnType == "date" || item.columnType == "timestamp">
										<div class="form-group col-sm-3">
											<label for="${item.domainPropertyName}" class="control-label col-sm-3 line34">${item.columnComment}</label>
											<div class="col-sm-8">
												<input type="text" name="${item.domainPropertyName}" id="${item.domainPropertyName}" value="$!dateTool.format('yyyy-MM-dd',$!{${lowerName}.${item.domainPropertyName}})" class="form-control">
											</div>
										 </div>
									<#else>
										 <div class="form-group col-sm-3">
											<label for="${item.domainPropertyName}" class="control-label col-sm-3 line34">${item.columnComment}</label>
											<div class="col-sm-8">
												<input type="text" name="${item.domainPropertyName}" id="${item.domainPropertyName}" value="$!{${lowerName}.${item.domainPropertyName}}" class="form-control">
											</div>
										 </div>
									</#if>
									</#if>
									</#if>
								</#list>
								<button type="submit" class="btn btn-primary">搜  索</button>
								<div class="clearfix"></div>
							</div>
							<div id="legend">
								<legend  class="le"><button type="button" class="btn btn-primary" onclick="doUrl('$!{basePath}/${projectName}/${lowerName}.do?toAdd')" >新增</button></legend> 
							</div>
							<table class="table table-striped">
								<thead>
									<#list columnDatas as item>
										<#if item.columnName != 'id'>
											<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
											<th>${item.columnComment}</th>
											</#if>
										</#if>
									</#list>
									<th>操作</th>
								</thead>
								<tbody>
								#if($!{pageInfos})
									#foreach($!{info} in $!{pageInfos})
										<tr>			
											<#list columnDatas as item>
												<#if item.columnName != 'id'>
												<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
													<#if item.columnType == "datetime" ||item.columnType == "date" || item.columnType == "timestamp">
														<td>$!dateTool.format("yyyy-MM-dd",$!{info.${item.domainPropertyName}})</td>
													<#else>
														<td>$!{info.${item.domainPropertyName}}</td>
													</#if>
												</#if>
												</#if>
											</#list> 
											<td class="last">
											<a href="javascript:doUrl('$!{basePath}/${projectName}/${lowerName}.do?toEdit&id=$!{info.id}')" >编辑</a>
											<a href="javascript:delData('$!{basePath}/${projectName}/${lowerName}.do?doDelete&id=$!{info.id}')">删除</a>
											<a href="javascript:doUrl('$!{basePath}/${projectName}/${lowerName}.do?toDetail&id=$!{info.id}')">详情</a>
											</td>
										</tr>
									 #end
								 #end
								</tbody>
							</table>
							<div class="text-right">
								<!--公用翻页代码-->
								#set($attr='formSubmit')
								#showPageList($pageInfos $attr)
								<!--END公用翻页代码-->
							</div>
						</div>
					</div>
				</div>  
			</form>
		</div>
	</div>
</body>
</html>