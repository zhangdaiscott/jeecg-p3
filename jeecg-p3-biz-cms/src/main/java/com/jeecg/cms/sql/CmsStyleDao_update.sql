UPDATE cms_style
SET 
	    <#if cmsStyle.createDate ?exists>
		   CREATE_DATE = :cmsStyle.createDate,
		</#if>
	   <#if cmsStyle.createName ?exists>
		   CREATE_NAME = :cmsStyle.createName,
		</#if>
	   <#if cmsStyle.reviewImgUrl ?exists>
		   REVIEW_IMG_URL = :cmsStyle.reviewImgUrl,
		</#if>
	   <#if cmsStyle.templateName ?exists>
		   TEMPLATE_NAME = :cmsStyle.templateName,
		</#if>
	   <#if cmsStyle.templateUrl ?exists>
		   TEMPLATE_URL = :cmsStyle.templateUrl,
		</#if>
	    <#if cmsStyle.updateDate ?exists>
		   UPDATE_DATE = :cmsStyle.updateDate,
		</#if>
	   <#if cmsStyle.updateName ?exists>
		   UPDATE_NAME = :cmsStyle.updateName,
		</#if>
WHERE id = :cmsStyle.id