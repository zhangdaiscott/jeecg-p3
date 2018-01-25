		<#if (cmsMenu.createBy)?? && cmsMenu.createBy ?length gt 0>
		    /* CREATE_BY */
			and cm.CREATE_BY like CONCAT('%', :cmsMenu.createBy ,'%') 
		</#if>
	    <#if (cmsMenu.createDate)??>
		    /* CREATE_DATE */
			and cm.CREATE_DATE = :cmsMenu.createDate
		</#if>
		<#if (cmsMenu.createName)?? && cmsMenu.createName ?length gt 0>
		    /* CREATE_NAME */
			and cm.CREATE_NAME like CONCAT('%', :cmsMenu.createName ,'%') 
		</#if>
		<#if (cmsMenu.imageHref)?? && cmsMenu.imageHref ?length gt 0>
		    /* IMAGE_HREF */
			and cm.IMAGE_HREF like CONCAT('%', :cmsMenu.imageHref ,'%') 
		</#if>
		<#if (cmsMenu.imageName)?? && cmsMenu.imageName ?length gt 0>
		    /* IMAGE_NAME */
			and cm.IMAGE_NAME like CONCAT('%', :cmsMenu.imageName ,'%') 
		</#if>
		<#if (cmsMenu.name)?? && cmsMenu.name ?length gt 0>
		    /* NAME */
			and cm.NAME like CONCAT('%', :cmsMenu.name ,'%') 
		</#if>
		<#if (cmsMenu.type)?? && cmsMenu.type ?length gt 0>
		    /* 类型 */
			and cm.TYPE like CONCAT('%', :cmsMenu.type ,'%') 
		</#if>
		<#if (cmsMenu.parentCode)?? && cmsMenu.parentCode ?length gt 0>
		    /* PARENT_CODE */
			and cm.PARENT_CODE like CONCAT('%', :cmsMenu.parentCode ,'%') 
		</#if>
		<#if (cmsMenu.href)?? && cmsMenu.href ?length gt 0>
		    /* HREF */
			and cm.HREF like CONCAT('%', :cmsMenu.href ,'%') 
		</#if>
