	    <#if (cmsStyle.createDate)??>
		    /* CREATE_DATE */
			and cs.CREATE_DATE = :cmsStyle.createDate
		</#if>
		<#if (cmsStyle.createName)?? && cmsStyle.createName ?length gt 0>
		    /* CREATE_NAME */
			and cs.CREATE_NAME like CONCAT('%', :cmsStyle.createName ,'%') 
		</#if>
		<#if (cmsStyle.reviewImgUrl)?? && cmsStyle.reviewImgUrl ?length gt 0>
		    /* REVIEW_IMG_URL */
			and cs.REVIEW_IMG_URL like CONCAT('%', :cmsStyle.reviewImgUrl ,'%') 
		</#if>
		<#if (cmsStyle.templateName)?? && cmsStyle.templateName ?length gt 0>
		    /* TEMPLATE_NAME */
			and cs.TEMPLATE_NAME like CONCAT('%', :cmsStyle.templateName ,'%') 
		</#if>
		<#if (cmsStyle.templateUrl)?? && cmsStyle.templateUrl ?length gt 0>
		    /* TEMPLATE_URL */
			and cs.TEMPLATE_URL like CONCAT('%', :cmsStyle.templateUrl ,'%') 
		</#if>
	    <#if (cmsStyle.updateDate)??>
		    /* UPDATE_DATE */
			and cs.UPDATE_DATE = :cmsStyle.updateDate
		</#if>
		<#if (cmsStyle.updateName)?? && cmsStyle.updateName ?length gt 0>
		    /* UPDATE_NAME */
			and cs.UPDATE_NAME like CONCAT('%', :cmsStyle.updateName ,'%') 
		</#if>
