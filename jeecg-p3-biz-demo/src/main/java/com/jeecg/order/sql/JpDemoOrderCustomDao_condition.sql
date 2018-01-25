	    <#if ( jpDemoOrderCustom.createDt )??>
		    /* CREATE_DT */
			and jdoc.CREATE_DT = :jpDemoOrderCustom.createDt
		</#if>
		<#if ( jpDemoOrderCustom.crtuser )?? && jpDemoOrderCustom.crtuser ?length gt 0>
		    /* CRTUSER */
			and jdoc.CRTUSER like CONCAT('%', :jpDemoOrderCustom.crtuser ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.crtuserName )?? && jpDemoOrderCustom.crtuserName ?length gt 0>
		    /* CRTUSER_NAME */
			and jdoc.CRTUSER_NAME like CONCAT('%', :jpDemoOrderCustom.crtuserName ,'%') 
		</#if>
	    <#if ( jpDemoOrderCustom.delDt )??>
		    /* DEL_DT */
			and jdoc.DEL_DT = :jpDemoOrderCustom.delDt
		</#if>
		<#if ( jpDemoOrderCustom.delflag )?? && jpDemoOrderCustom.delflag ?length gt 0>
		    /* DELFLAG */
			and jdoc.DELFLAG like CONCAT('%', :jpDemoOrderCustom.delflag ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.goOrderCode )?? && jpDemoOrderCustom.goOrderCode ?length gt 0>
		    /* 团购订单号 */
			and jdoc.GO_ORDER_CODE like CONCAT('%', :jpDemoOrderCustom.goOrderCode ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.gocBussContent )?? && jpDemoOrderCustom.gocBussContent ?length gt 0>
		    /* 业务 */
			and jdoc.GOC_BUSS_CONTENT like CONCAT('%', :jpDemoOrderCustom.gocBussContent ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.gocContent )?? && jpDemoOrderCustom.gocContent ?length gt 0>
		    /* 备注 */
			and jdoc.GOC_CONTENT like CONCAT('%', :jpDemoOrderCustom.gocContent ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.gocCusName )?? && jpDemoOrderCustom.gocCusName ?length gt 0>
		    /* 姓名 */
			and jdoc.GOC_CUS_NAME like CONCAT('%', :jpDemoOrderCustom.gocCusName ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.gocIdcard )?? && jpDemoOrderCustom.gocIdcard ?length gt 0>
		    /* 身份证号 */
			and jdoc.GOC_IDCARD like CONCAT('%', :jpDemoOrderCustom.gocIdcard ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.gocPassportCode )?? && jpDemoOrderCustom.gocPassportCode ?length gt 0>
		    /* 护照号 */
			and jdoc.GOC_PASSPORT_CODE like CONCAT('%', :jpDemoOrderCustom.gocPassportCode ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.gocSex )?? && jpDemoOrderCustom.gocSex ?length gt 0>
		    /* 性别 */
			and jdoc.GOC_SEX like CONCAT('%', :jpDemoOrderCustom.gocSex ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.modifier )?? && jpDemoOrderCustom.modifier ?length gt 0>
		    /* MODIFIER */
			and jdoc.MODIFIER like CONCAT('%', :jpDemoOrderCustom.modifier ,'%') 
		</#if>
		<#if ( jpDemoOrderCustom.modifierName )?? && jpDemoOrderCustom.modifierName ?length gt 0>
		    /* MODIFIER_NAME */
			and jdoc.MODIFIER_NAME like CONCAT('%', :jpDemoOrderCustom.modifierName ,'%') 
		</#if>
	    <#if ( jpDemoOrderCustom.modifyDt )??>
		    /* MODIFY_DT */
			and jdoc.MODIFY_DT = :jpDemoOrderCustom.modifyDt
		</#if>
