UPDATE cms_site
SET 
	   <#if cmsSite.companyTel ?exists>
		   COMPANY_TEL = :cmsSite.companyTel,
		</#if>
	    <#if cmsSite.createDate ?exists>
		   CREATE_DATE = :cmsSite.createDate,
		</#if>
	   <#if cmsSite.createName ?exists>
		   CREATE_NAME = :cmsSite.createName,
		</#if>
	   <#if cmsSite.siteLogo ?exists>
		   SITE_LOGO = :cmsSite.siteLogo,
		</#if>
	   <#if cmsSite.siteName ?exists>
		   SITE_NAME = :cmsSite.siteName,
		</#if>
	   <#if cmsSite.siteTemplateStyle ?exists>
		   SITE_TEMPLATE_STYLE = :cmsSite.siteTemplateStyle,
		</#if>
	    <#if cmsSite.updateDate ?exists>
		   UPDATE_DATE = :cmsSite.updateDate,
		</#if>
	   <#if cmsSite.updateName ?exists>
		   UPDATE_NAME = :cmsSite.updateName,
		</#if>
WHERE id = :cmsSite.id