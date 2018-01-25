package com.jeecg.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：</b>CmsSite:<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double 
 * @author p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
public class CmsSite implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *COMPANY_TEL	 */	private String companyTel;	/**	 *CREATE_DATE	 */	private Date createDate;	/**	 *CREATE_NAME	 */	private String createName;	/**	 *SITE_LOGO	 */	private String siteLogo;	/**	 *SITE_NAME	 */	private String siteName;
	/**	 *SITE_TEMPLATE_STYLE	 */	private String siteTemplateStyle;	/**	 *UPDATE_DATE	 */	private Date updateDate;	/**	 *UPDATE_NAME	 */	private String updateName;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getCompanyTel() {	    return this.companyTel;	}	public void setCompanyTel(String companyTel) {	    this.companyTel=companyTel;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getCreateName() {	    return this.createName;	}	public void setCreateName(String createName) {	    this.createName=createName;	}	public String getSiteLogo() {	    return this.siteLogo;	}	public void setSiteLogo(String siteLogo) {	    this.siteLogo=siteLogo;	}	public String getSiteName() {	    return this.siteName;	}	public void setSiteName(String siteName) {	    this.siteName=siteName;	}	public String getSiteTemplateStyle() {	    return this.siteTemplateStyle;	}	public void setSiteTemplateStyle(String siteTemplateStyle) {	    this.siteTemplateStyle=siteTemplateStyle;	}	public Date getUpdateDate() {	    return this.updateDate;	}	public void setUpdateDate(Date updateDate) {	    this.updateDate=updateDate;	}	public String getUpdateName() {	    return this.updateName;	}	public void setUpdateName(String updateName) {	    this.updateName=updateName;	}
}

