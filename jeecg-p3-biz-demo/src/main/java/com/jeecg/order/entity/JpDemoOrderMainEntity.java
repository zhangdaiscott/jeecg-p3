package com.jeecg.order.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：</b>JpDemoOrderMain:<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double 
 * @author p3.jeecg
 * @since：2016年09月03日 14时07分23秒 星期六 
 * @version:1.0
 */
public class JpDemoOrderMainEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *CREATE_DT	 */	private Date createDt;	/**	 *CRTUSER	 */	private String crtuser;	/**	 *CRTUSER_NAME	 */	private String crtuserName;	/**	 *DEL_DT	 */	private Date delDt;	/**	 *DELFLAG	 */	private Integer delflag;	/**	 *总价(不含返款)	 */	private BigDecimal goAllPrice;	/**	 *联系人	 */	private String goContactName;	/**	 *备注	 */	private String goContent;	/**	 *订单号	 */	private String goOrderCode;	/**	 *订单人数	 */	private Integer goOrderCount;	/**	 *返款	 */	private BigDecimal goReturnPrice;	/**	 *手机	 */	private String goTelphone;	/**	 *订单类型	 */	private String goderType;	/**	 *MODIFIER	 */	private String modifier;	/**	 *MODIFIER_NAME	 */	private String modifierName;	/**	 *MODIFY_DT	 */	private Date modifyDt;	/**	 *顾客类型 : 1直客 2同行	 */	private String usertype;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public Date getCreateDt() {	    return this.createDt;	}	public void setCreateDt(Date createDt) {	    this.createDt=createDt;	}	public String getCrtuser() {	    return this.crtuser;	}	public void setCrtuser(String crtuser) {	    this.crtuser=crtuser;	}	public String getCrtuserName() {	    return this.crtuserName;	}	public void setCrtuserName(String crtuserName) {	    this.crtuserName=crtuserName;	}	public Date getDelDt() {	    return this.delDt;	}	public void setDelDt(Date delDt) {	    this.delDt=delDt;	}	public Integer getDelflag() {	    return this.delflag;	}	public void setDelflag(Integer delflag) {	    this.delflag=delflag;	}	public BigDecimal getGoAllPrice() {	    return this.goAllPrice;	}	public void setGoAllPrice(BigDecimal goAllPrice) {	    this.goAllPrice=goAllPrice;	}	public String getGoContactName() {	    return this.goContactName;	}	public void setGoContactName(String goContactName) {	    this.goContactName=goContactName;	}	public String getGoContent() {	    return this.goContent;	}	public void setGoContent(String goContent) {	    this.goContent=goContent;	}	public String getGoOrderCode() {	    return this.goOrderCode;	}	public void setGoOrderCode(String goOrderCode) {	    this.goOrderCode=goOrderCode;	}	public Integer getGoOrderCount() {	    return this.goOrderCount;	}	public void setGoOrderCount(Integer goOrderCount) {	    this.goOrderCount=goOrderCount;	}	public BigDecimal getGoReturnPrice() {	    return this.goReturnPrice;	}	public void setGoReturnPrice(BigDecimal goReturnPrice) {	    this.goReturnPrice=goReturnPrice;	}	public String getGoTelphone() {	    return this.goTelphone;	}	public void setGoTelphone(String goTelphone) {	    this.goTelphone=goTelphone;	}	public String getGoderType() {	    return this.goderType;	}	public void setGoderType(String goderType) {	    this.goderType=goderType;	}	public String getModifier() {	    return this.modifier;	}	public void setModifier(String modifier) {	    this.modifier=modifier;	}	public String getModifierName() {	    return this.modifierName;	}	public void setModifierName(String modifierName) {	    this.modifierName=modifierName;	}	public Date getModifyDt() {	    return this.modifyDt;	}	public void setModifyDt(Date modifyDt) {	    this.modifyDt=modifyDt;	}	public String getUsertype() {	    return this.usertype;	}	public void setUsertype(String usertype) {	    this.usertype=usertype;	}
}

