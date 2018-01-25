package com.jeecg.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：</b>CmsAd:<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double 
 * @author p3.jeecg
 * @since：2016年06月13日 15时00分28秒 星期一 
 * @version:1.0
 */
public class CmsAd implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *createName	 */	private String createName;	/**	 *createBy	 */	private String createBy;	/**	 *createDate	 */	private Date createDate;	/**	 *标题	 */	private String title;	/**	 *图片地址	 */	private String imageHref;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getCreateName() {	    return this.createName;	}	public void setCreateName(String createName) {	    this.createName=createName;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getTitle() {	    return this.title;	}	public void setTitle(String title) {	    this.title=title;	}	public String getImageHref() {	    return this.imageHref;	}	public void setImageHref(String imageHref) {	    this.imageHref=imageHref;	}}

