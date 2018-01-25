UPDATE jp_demo_order_custom
SET 
	    <#if jpDemoOrderCustom.createDt ?exists>
		   CREATE_DT = :jpDemoOrderCustom.createDt,
		</#if>
	   <#if jpDemoOrderCustom.crtuser ?exists>
		   CRTUSER = :jpDemoOrderCustom.crtuser,
		</#if>
	   <#if jpDemoOrderCustom.crtuserName ?exists>
		   CRTUSER_NAME = :jpDemoOrderCustom.crtuserName,
		</#if>
	    <#if jpDemoOrderCustom.delDt ?exists>
		   DEL_DT = :jpDemoOrderCustom.delDt,
		</#if>
	   <#if jpDemoOrderCustom.delflag ?exists>
		   DELFLAG = :jpDemoOrderCustom.delflag,
		</#if>
	   <#if jpDemoOrderCustom.goOrderCode ?exists>
		   GO_ORDER_CODE = :jpDemoOrderCustom.goOrderCode,
		</#if>
	   <#if jpDemoOrderCustom.gocBussContent ?exists>
		   GOC_BUSS_CONTENT = :jpDemoOrderCustom.gocBussContent,
		</#if>
	   <#if jpDemoOrderCustom.gocContent ?exists>
		   GOC_CONTENT = :jpDemoOrderCustom.gocContent,
		</#if>
	   <#if jpDemoOrderCustom.gocCusName ?exists>
		   GOC_CUS_NAME = :jpDemoOrderCustom.gocCusName,
		</#if>
	   <#if jpDemoOrderCustom.gocIdcard ?exists>
		   GOC_IDCARD = :jpDemoOrderCustom.gocIdcard,
		</#if>
	   <#if jpDemoOrderCustom.gocPassportCode ?exists>
		   GOC_PASSPORT_CODE = :jpDemoOrderCustom.gocPassportCode,
		</#if>
	   <#if jpDemoOrderCustom.gocSex ?exists>
		   GOC_SEX = :jpDemoOrderCustom.gocSex,
		</#if>
	   <#if jpDemoOrderCustom.modifier ?exists>
		   MODIFIER = :jpDemoOrderCustom.modifier,
		</#if>
	   <#if jpDemoOrderCustom.modifierName ?exists>
		   MODIFIER_NAME = :jpDemoOrderCustom.modifierName,
		</#if>
	    <#if jpDemoOrderCustom.modifyDt ?exists>
		   MODIFY_DT = :jpDemoOrderCustom.modifyDt,
		</#if>
WHERE id = :jpDemoOrderCustom.id