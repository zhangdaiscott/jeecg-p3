UPDATE jp_demo_activity 
SET 
	<#if act.id ?exists && act.id ?length gt 0>
	    id = :act.id
	</#if>
	<#if act.name ?exists && act.name ?length gt 0>
	    ,name = :act.name
	</#if>
	<#if act.beginTime ?exists>
	    ,begin_time = :act.beginTime
	</#if>
	<#if act.endTime ?exists>
	    ,end_time = :act.endTime
	</#if>
	<#if act.hdurl ?exists && act.hdurl ?length gt 0>
		,hdurl = :act.hdurl
	</#if>
WHERE id = :act.id