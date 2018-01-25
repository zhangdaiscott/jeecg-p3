UPDATE jp_demo_order_product
SET 
	    <#if jpDemoOrderProduct.createDt ?exists>
		   CREATE_DT = :jpDemoOrderProduct.createDt,
		</#if>
	   <#if jpDemoOrderProduct.crtuser ?exists>
		   CRTUSER = :jpDemoOrderProduct.crtuser,
		</#if>
	   <#if jpDemoOrderProduct.crtuserName ?exists>
		   CRTUSER_NAME = :jpDemoOrderProduct.crtuserName,
		</#if>
	    <#if jpDemoOrderProduct.delDt ?exists>
		   DEL_DT = :jpDemoOrderProduct.delDt,
		</#if>
	   <#if jpDemoOrderProduct.delflag ?exists>
		   DELFLAG = :jpDemoOrderProduct.delflag,
		</#if>
	   <#if jpDemoOrderProduct.goOrderCode ?exists>
		   GO_ORDER_CODE = :jpDemoOrderProduct.goOrderCode,
		</#if>
	   <#if jpDemoOrderProduct.gopContent ?exists>
		   GOP_CONTENT = :jpDemoOrderProduct.gopContent,
		</#if>
	   <#if jpDemoOrderProduct.gopCount ?exists>
		   GOP_COUNT = :jpDemoOrderProduct.gopCount,
		</#if>
	   <#if jpDemoOrderProduct.gopOnePrice ?exists>
		   GOP_ONE_PRICE = :jpDemoOrderProduct.gopOnePrice,
		</#if>
	   <#if jpDemoOrderProduct.gopProductName ?exists>
		   GOP_PRODUCT_NAME = :jpDemoOrderProduct.gopProductName,
		</#if>
	   <#if jpDemoOrderProduct.gopProductType ?exists>
		   GOP_PRODUCT_TYPE = :jpDemoOrderProduct.gopProductType,
		</#if>
	   <#if jpDemoOrderProduct.gopSumPrice ?exists>
		   GOP_SUM_PRICE = :jpDemoOrderProduct.gopSumPrice,
		</#if>
	   <#if jpDemoOrderProduct.modifier ?exists>
		   MODIFIER = :jpDemoOrderProduct.modifier,
		</#if>
	   <#if jpDemoOrderProduct.modifierName ?exists>
		   MODIFIER_NAME = :jpDemoOrderProduct.modifierName,
		</#if>
	    <#if jpDemoOrderProduct.modifyDt ?exists>
		   MODIFY_DT = :jpDemoOrderProduct.modifyDt,
		</#if>
WHERE id = :jpDemoOrderProduct.id