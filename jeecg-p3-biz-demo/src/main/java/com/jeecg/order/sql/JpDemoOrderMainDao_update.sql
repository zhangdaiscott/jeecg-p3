UPDATE jp_demo_order_main
SET 
	    <#if jpDemoOrderMain.createDt ?exists>
		   CREATE_DT = :jpDemoOrderMain.createDt,
		</#if>
	   <#if jpDemoOrderMain.crtuser ?exists>
		   CRTUSER = :jpDemoOrderMain.crtuser,
		</#if>
	   <#if jpDemoOrderMain.crtuserName ?exists>
		   CRTUSER_NAME = :jpDemoOrderMain.crtuserName,
		</#if>
	    <#if jpDemoOrderMain.delDt ?exists>
		   DEL_DT = :jpDemoOrderMain.delDt,
		</#if>
	   <#if jpDemoOrderMain.delflag ?exists>
		   DELFLAG = :jpDemoOrderMain.delflag,
		</#if>
	   <#if jpDemoOrderMain.goAllPrice ?exists>
		   GO_ALL_PRICE = :jpDemoOrderMain.goAllPrice,
		</#if>
	   <#if jpDemoOrderMain.goContactName ?exists>
		   GO_CONTACT_NAME = :jpDemoOrderMain.goContactName,
		</#if>
	   <#if jpDemoOrderMain.goContent ?exists>
		   GO_CONTENT = :jpDemoOrderMain.goContent,
		</#if>
	   <#if jpDemoOrderMain.goOrderCode ?exists>
		   GO_ORDER_CODE = :jpDemoOrderMain.goOrderCode,
		</#if>
	   <#if jpDemoOrderMain.goOrderCount ?exists>
		   GO_ORDER_COUNT = :jpDemoOrderMain.goOrderCount,
		</#if>
	   <#if jpDemoOrderMain.goReturnPrice ?exists>
		   GO_RETURN_PRICE = :jpDemoOrderMain.goReturnPrice,
		</#if>
	   <#if jpDemoOrderMain.goTelphone ?exists>
		   GO_TELPHONE = :jpDemoOrderMain.goTelphone,
		</#if>
	   <#if jpDemoOrderMain.goderType ?exists>
		   GODER_TYPE = :jpDemoOrderMain.goderType,
		</#if>
	   <#if jpDemoOrderMain.modifier ?exists>
		   MODIFIER = :jpDemoOrderMain.modifier,
		</#if>
	   <#if jpDemoOrderMain.modifierName ?exists>
		   MODIFIER_NAME = :jpDemoOrderMain.modifierName,
		</#if>
	    <#if jpDemoOrderMain.modifyDt ?exists>
		   MODIFY_DT = :jpDemoOrderMain.modifyDt,
		</#if>
	   <#if jpDemoOrderMain.usertype ?exists>
		   USERTYPE = :jpDemoOrderMain.usertype,
		</#if>
WHERE id = :jpDemoOrderMain.id