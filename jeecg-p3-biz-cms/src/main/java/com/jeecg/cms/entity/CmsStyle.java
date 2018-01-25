package com.jeecg.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：</b>CmsStyle:<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double 
 * @author p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
public class CmsStyle implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *CREATE_DATE	 */	private Date createDate;	/**	 *CREATE_NAME	 */	private String createName;	/**	 *REVIEW_IMG_URL	 */	private String reviewImgUrl;	/**	 *TEMPLATE_NAME	 */	private String templateName;	/**	 *TEMPLATE_URL	 */	private String templateUrl;	/**	 *UPDATE_DATE	 */	private Date updateDate;	/**	 *UPDATE_NAME	 */	private String updateName;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getCreateName() {	    return this.createName;	}	public void setCreateName(String createName) {	    this.createName=createName;	}	public String getReviewImgUrl() {	    return this.reviewImgUrl;	}	public void setReviewImgUrl(String reviewImgUrl) {	    this.reviewImgUrl=reviewImgUrl;	}	public String getTemplateName() {	    return this.templateName;	}	public void setTemplateName(String templateName) {	    this.templateName=templateName;	}	public String getTemplateUrl() {	    return this.templateUrl;	}	public void setTemplateUrl(String templateUrl) {	    this.templateUrl=templateUrl;	}	public Date getUpdateDate() {	    return this.updateDate;	}	public void setUpdateDate(Date updateDate) {	    this.updateDate=updateDate;	}	public String getUpdateName() {	    return this.updateName;	}	public void setUpdateName(String updateName) {	    this.updateName=updateName;	}
}

