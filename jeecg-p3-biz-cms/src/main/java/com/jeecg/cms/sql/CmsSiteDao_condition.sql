		<#if (cmsSite.companyTel)?? && cmsSite.companyTel ?length gt 0>
		    /* COMPANY_TEL */
			and cs.COMPANY_TEL like CONCAT('%', :cmsSite.companyTel ,'%') 
		</#if>
	    <#if (cmsSite.createDate)??>
		    /* CREATE_DATE */
			and cs.CREATE_DATE = :cmsSite.createDate
		</#if>
		<#if (cmsSite.createName)?? && cmsSite.createName ?length gt 0>
		    /* CREATE_NAME */
			and cs.CREATE_NAME like CONCAT('%', :cmsSite.createName ,'%') 
		</#if>
		<#if (cmsSite.siteLogo)?? && cmsSite.siteLogo ?length gt 0>
		    /* SITE_LOGO */
			and cs.SITE_LOGO like CONCAT('%', :cmsSite.siteLogo ,'%') 
		</#if>
		<#if (cmsSite.siteName)?? && cmsSite.siteName ?length gt 0>
		    /* SITE_NAME */
			and cs.SITE_NAME like CONCAT('%', :cmsSite.siteName ,'%') 
		</#if>
		<#if (cmsSite.siteTemplateStyle)?? && cmsSite.siteTemplateStyle ?length gt 0>
		    /* SITE_TEMPLATE_STYLE */
			and cs.SITE_TEMPLATE_STYLE like CONCAT('%', :cmsSite.siteTemplateStyle ,'%') 
		</#if>
	    <#if (cmsSite.updateDate)??>
		    /* UPDATE_DATE */
			and cs.UPDATE_DATE = :cmsSite.updateDate
		</#if>
		<#if (cmsSite.updateName)?? && cmsSite.updateName ?length gt 0>
		    /* UPDATE_NAME */
			and cs.UPDATE_NAME like CONCAT('%', :cmsSite.updateName ,'%') 
		</#if>
