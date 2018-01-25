package com.jeecg.order.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：</b>JpDemoOrderCustom:<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double 
 * @author p3.jeecg
 * @since：2016年09月03日 14时07分21秒 星期六 
 * @version:1.0
 */
public class JpDemoOrderCustomEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *CREATE_DT	 */	private Date createDt;	/**	 *CRTUSER	 */	private String crtuser;	/**	 *CRTUSER_NAME	 */	private String crtuserName;	/**	 *DEL_DT	 */	private Date delDt;	/**	 *DELFLAG	 */	private Integer delflag;	/**	 *团购订单号	 */	private String goOrderCode;	/**	 *业务	 */	private String gocBussContent;	/**	 *备注	 */	private String gocContent;	/**	 *姓名	 */	private String gocCusName;	/**	 *身份证号	 */	private String gocIdcard;	/**	 *护照号	 */	private String gocPassportCode;	/**	 *性别	 */	private String gocSex;	/**	 *MODIFIER	 */	private String modifier;	/**	 *MODIFIER_NAME	 */	private String modifierName;	/**	 *MODIFY_DT	 */	private Date modifyDt;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public Date getCreateDt() {	    return this.createDt;	}	public void setCreateDt(Date createDt) {	    this.createDt=createDt;	}	public String getCrtuser() {	    return this.crtuser;	}	public void setCrtuser(String crtuser) {	    this.crtuser=crtuser;	}	public String getCrtuserName() {	    return this.crtuserName;	}	public void setCrtuserName(String crtuserName) {	    this.crtuserName=crtuserName;	}	public Date getDelDt() {	    return this.delDt;	}	public void setDelDt(Date delDt) {	    this.delDt=delDt;	}	public Integer getDelflag() {	    return this.delflag;	}	public void setDelflag(Integer delflag) {	    this.delflag=delflag;	}	public String getGoOrderCode() {	    return this.goOrderCode;	}	public void setGoOrderCode(String goOrderCode) {	    this.goOrderCode=goOrderCode;	}	public String getGocBussContent() {	    return this.gocBussContent;	}	public void setGocBussContent(String gocBussContent) {	    this.gocBussContent=gocBussContent;	}	public String getGocContent() {	    return this.gocContent;	}	public void setGocContent(String gocContent) {	    this.gocContent=gocContent;	}	public String getGocCusName() {	    return this.gocCusName;	}	public void setGocCusName(String gocCusName) {	    this.gocCusName=gocCusName;	}	public String getGocIdcard() {	    return this.gocIdcard;	}	public void setGocIdcard(String gocIdcard) {	    this.gocIdcard=gocIdcard;	}	public String getGocPassportCode() {	    return this.gocPassportCode;	}	public void setGocPassportCode(String gocPassportCode) {	    this.gocPassportCode=gocPassportCode;	}	public String getGocSex() {	    return this.gocSex;	}	public void setGocSex(String gocSex) {	    this.gocSex=gocSex;	}	public String getModifier() {	    return this.modifier;	}	public void setModifier(String modifier) {	    this.modifier=modifier;	}	public String getModifierName() {	    return this.modifierName;	}	public void setModifierName(String modifierName) {	    this.modifierName=modifierName;	}	public Date getModifyDt() {	    return this.modifyDt;	}	public void setModifyDt(Date modifyDt) {	    this.modifyDt=modifyDt;	}
}

