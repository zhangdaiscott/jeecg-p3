package com.jeecg.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：</b>CmsArticle:<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double 
 * @author p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
public class CmsArticle implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *标题	 */	private String title;	/**	 *图片地址	 */	private String imageHref;	/**	 *summary	 */	private String summary;	/**	 *内容	 */	private String content;	/**	 *栏目id	 */	private String columnId;	/**	 *创建人	 */	private String createName;	/**	 *创建人id	 */	private String createBy;	/**	 *创建日期	 */	private Date createDate;	/**	 *publish	 */	private String publish;	/**	 *PUBLISH_DATE	 */	private Date publishDate;	/**	 *AUTHOR	 */	private String author;	/**	 *LABEL	 */	private String label;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getTitle() {	    return this.title;	}	public void setTitle(String title) {	    this.title=title;	}	public String getImageHref() {	    return this.imageHref;	}	public void setImageHref(String imageHref) {	    this.imageHref=imageHref;	}	public String getSummary() {	    return this.summary;	}	public void setSummary(String summary) {	    this.summary=summary;	}	public String getContent() {	    return this.content;	}	public void setContent(String content) {	    this.content=content;	}	public String getColumnId() {	    return this.columnId;	}	public void setColumnId(String columnId) {	    this.columnId=columnId;	}	public String getCreateName() {	    return this.createName;	}	public void setCreateName(String createName) {	    this.createName=createName;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getPublish() {	    return this.publish;	}	public void setPublish(String publish) {	    this.publish=publish;	}	public Date getPublishDate() {	    return this.publishDate;	}	public void setPublishDate(Date publishDate) {	    this.publishDate=publishDate;	}	public String getAuthor() {	    return this.author;	}	public void setAuthor(String author) {	    this.author=author;	}	public String getLabel() {	    return this.label;	}	public void setLabel(String label) {	    this.label=label;	}}

