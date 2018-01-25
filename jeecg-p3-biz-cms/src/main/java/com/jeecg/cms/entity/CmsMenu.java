package com.jeecg.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：</b>CmsMenu:<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double 
 * @author p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
public class CmsMenu implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *CREATE_BY	 */	private String createBy;	/**	 *CREATE_DATE	 */	private Date createDate;	/**	 *CREATE_NAME	 */	private String createName;	/**	 *IMAGE_HREF	 */	private String imageHref;	/**	 *IMAGE_NAME	 */	private String imageName;	/**	 *NAME	 */	private String name;	/**	 *类型	 */	private String type;	/**	 *PARENT_CODE	 */	private String parentCode;	/**	 *HREF	 */	private String href;
		public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getCreateName() {	    return this.createName;	}	public void setCreateName(String createName) {	    this.createName=createName;	}	public String getImageHref() {	    return this.imageHref;	}	public void setImageHref(String imageHref) {	    this.imageHref=imageHref;	}	public String getImageName() {	    return this.imageName;	}	public void setImageName(String imageName) {	    this.imageName=imageName;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}	public String getParentCode() {	    return this.parentCode;	}	public void setParentCode(String parentCode) {	    this.parentCode=parentCode;	}	public String getHref() {	    return this.href;	}	public void setHref(String href) {	    this.href=href;	}
}

