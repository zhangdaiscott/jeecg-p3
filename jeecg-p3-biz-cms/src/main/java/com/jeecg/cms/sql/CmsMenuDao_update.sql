UPDATE cms_menu
SET 
	   <#if cmsMenu.createBy ?exists>
		   CREATE_BY = :cmsMenu.createBy,
		</#if>
	    <#if cmsMenu.createDate ?exists>
		   CREATE_DATE = :cmsMenu.createDate,
		</#if>
	   <#if cmsMenu.createName ?exists>
		   CREATE_NAME = :cmsMenu.createName,
		</#if>
	   <#if cmsMenu.imageHref ?exists>
		   IMAGE_HREF = :cmsMenu.imageHref,
		</#if>
	   <#if cmsMenu.imageName ?exists>
		   IMAGE_NAME = :cmsMenu.imageName,
		</#if>
	   <#if cmsMenu.name ?exists>
		   NAME = :cmsMenu.name,
		</#if>
	   <#if cmsMenu.type ?exists>
		   TYPE = :cmsMenu.type,
		</#if>
	   <#if cmsMenu.parentCode ?exists>
		   PARENT_CODE = :cmsMenu.parentCode,
		</#if>
	   <#if cmsMenu.href ?exists>
		   HREF = :cmsMenu.href,
		</#if>
WHERE id = :cmsMenu.id