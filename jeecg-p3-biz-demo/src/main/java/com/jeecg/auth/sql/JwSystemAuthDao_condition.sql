<#if auth.authId ?exists && auth.authId ?length gt 0>
	and auth_id like CONCAT('%', :auth.authId ,'%') 
</#if>
<#if auth.parentAuthId ?exists && auth.parentAuthId ?length gt 0>
	and parent_auth_id like CONCAT('%', :auth.parentAuthId ,'%')
</#if>