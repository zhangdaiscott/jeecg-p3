UPDATE jp_demo_auth 
SET 
	<#if auth.id ?exists && auth.id ?length gt 0>
	    id = :auth.id
	</#if>
	<#if auth.authId ?exists && auth.authId ?length gt 0>
	    ,auth_id = :auth.authId
	</#if>
	<#if auth.authName ?exists && auth.authName ?length gt 0>
	    ,auth_name = :auth.authName
	</#if>
	<#if auth.authType ?exists && auth.authType ?length gt 0>
		,auth_type = :auth.authType
	</#if>
	<#if auth.authContr ?exists && auth.authContr ?length gt 0>
		,auth_contr = :auth.authContr
	</#if>
	<#if auth.parentAuthId ?exists && auth.parentAuthId ?length gt 0>
		,parent_auth_id = :auth.parentAuthId
	</#if>
	<#if auth.leafInd ?exists && auth.leafInd ?length gt 0>
		,leaf_ind = :auth.leafInd
	</#if>
WHERE id = :auth.id