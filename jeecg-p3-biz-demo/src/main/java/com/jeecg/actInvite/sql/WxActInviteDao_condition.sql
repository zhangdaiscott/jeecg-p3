<#if act.name ?exists && act.name ?length gt 0>
	and name like CONCAT('%', :act.name ,'%') 
</#if>
<#if act.beginTime ?exists>
	and begin_time >= :act.beginTime
</#if>
<#if act.endTime ?exists> 
	and end_time <= :act.endTime
</#if>
<#if act.hdurl ?exists && act.hdurl ?length gt 0>
	and hdurl like CONCAT('%', :act.hdurl ,'%')
</#if>