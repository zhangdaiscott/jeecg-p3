	    <#if ( jpDemoOrderProduct.createDt )??>
		    /* CREATE_DT */
			and jdop.CREATE_DT = :jpDemoOrderProduct.createDt
		</#if>
		<#if ( jpDemoOrderProduct.crtuser )?? && jpDemoOrderProduct.crtuser ?length gt 0>
		    /* CRTUSER */
			and jdop.CRTUSER like CONCAT('%', :jpDemoOrderProduct.crtuser ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.crtuserName )?? && jpDemoOrderProduct.crtuserName ?length gt 0>
		    /* CRTUSER_NAME */
			and jdop.CRTUSER_NAME like CONCAT('%', :jpDemoOrderProduct.crtuserName ,'%') 
		</#if>
	    <#if ( jpDemoOrderProduct.delDt )??>
		    /* DEL_DT */
			and jdop.DEL_DT = :jpDemoOrderProduct.delDt
		</#if>
		<#if ( jpDemoOrderProduct.delflag )?? && jpDemoOrderProduct.delflag ?length gt 0>
		    /* DELFLAG */
			and jdop.DELFLAG like CONCAT('%', :jpDemoOrderProduct.delflag ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.goOrderCode )?? && jpDemoOrderProduct.goOrderCode ?length gt 0>
		    /* 团购订单号 */
			and jdop.GO_ORDER_CODE like CONCAT('%', :jpDemoOrderProduct.goOrderCode ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.gopContent )?? && jpDemoOrderProduct.gopContent ?length gt 0>
		    /* 备注 */
			and jdop.GOP_CONTENT like CONCAT('%', :jpDemoOrderProduct.gopContent ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.gopCount )?? && jpDemoOrderProduct.gopCount ?length gt 0>
		    /* 个数 */
			and jdop.GOP_COUNT like CONCAT('%', :jpDemoOrderProduct.gopCount ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.gopOnePrice )?? && jpDemoOrderProduct.gopOnePrice ?length gt 0>
		    /* 单价 */
			and jdop.GOP_ONE_PRICE like CONCAT('%', :jpDemoOrderProduct.gopOnePrice ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.gopProductName )?? && jpDemoOrderProduct.gopProductName ?length gt 0>
		    /* 产品名称 */
			and jdop.GOP_PRODUCT_NAME like CONCAT('%', :jpDemoOrderProduct.gopProductName ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.gopProductType )?? && jpDemoOrderProduct.gopProductType ?length gt 0>
		    /* 服务项目类型 */
			and jdop.GOP_PRODUCT_TYPE like CONCAT('%', :jpDemoOrderProduct.gopProductType ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.gopSumPrice )?? && jpDemoOrderProduct.gopSumPrice ?length gt 0>
		    /* 小计 */
			and jdop.GOP_SUM_PRICE like CONCAT('%', :jpDemoOrderProduct.gopSumPrice ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.modifier )?? && jpDemoOrderProduct.modifier ?length gt 0>
		    /* MODIFIER */
			and jdop.MODIFIER like CONCAT('%', :jpDemoOrderProduct.modifier ,'%') 
		</#if>
		<#if ( jpDemoOrderProduct.modifierName )?? && jpDemoOrderProduct.modifierName ?length gt 0>
		    /* MODIFIER_NAME */
			and jdop.MODIFIER_NAME like CONCAT('%', :jpDemoOrderProduct.modifierName ,'%') 
		</#if>
	    <#if ( jpDemoOrderProduct.modifyDt )??>
		    /* MODIFY_DT */
			and jdop.MODIFY_DT = :jpDemoOrderProduct.modifyDt
		</#if>
