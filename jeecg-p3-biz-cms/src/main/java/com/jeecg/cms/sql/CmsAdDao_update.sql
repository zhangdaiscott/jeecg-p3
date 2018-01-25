UPDATE cms_ad
SET 
	   <#if cmsAd.createName ?exists>
		   create_name = :cmsAd.createName,
		</#if>
	   <#if cmsAd.createBy ?exists>
		   create_by = :cmsAd.createBy,
		</#if>
	    <#if cmsAd.createDate ?exists>
		   create_date = :cmsAd.createDate,
		</#if>
	   <#if cmsAd.title ?exists>
		   title = :cmsAd.title,
		</#if>
	   <#if cmsAd.imageHref ?exists>
		   image_href = :cmsAd.imageHref,
		</#if>
WHERE id = :cmsAd.id