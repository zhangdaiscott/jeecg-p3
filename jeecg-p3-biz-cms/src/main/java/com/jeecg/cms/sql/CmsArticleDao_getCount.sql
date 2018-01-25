SELECT count(*) FROM cms_article WHERE 1=1
<#if columnid ?exists && columnid?length gt 0>
	and column_id = :columnid
</#if>
