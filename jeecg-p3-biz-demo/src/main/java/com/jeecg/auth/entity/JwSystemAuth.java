package com.jeecg.auth.entity;

import java.io.Serializable;

/**
 * 描述：</b>JwSystemAuth:运营系统权限表; InnoDB free: 9216 kB<br>
 * @author junfeng.zhou
 * @since：2015年12月21日 10时28分27秒 星期一 
 * @version:1.0
 */
public class JwSystemAuth implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *序号	 */	private Long id;	/**	 *权限编码	 */	private String authId;	/**	 *权限名称	 */	private String authName;	/**	 *权限类型 0:菜单;1:功能	 */	private String authType;	/**	 *权限控制	 */	private String authContr;	/**	 *上一级权限编码	 */	private String parentAuthId;	/**	 *是否叶子节点	 */	private String leafInd;	public Long getId() {	    return this.id;	}	public void setId(Long id) {	    this.id=id;	}	public String getAuthId() {	    return this.authId;	}	public void setAuthId(String authId) {	    this.authId=authId;	}	public String getAuthName() {	    return this.authName;	}	public void setAuthName(String authName) {	    this.authName=authName;	}	public String getAuthType() {	    return this.authType;	}	public void setAuthType(String authType) {	    this.authType=authType;	}	public String getAuthContr() {	    return this.authContr;	}	public void setAuthContr(String authContr) {	    this.authContr=authContr;	}	public String getParentAuthId() {	    return this.parentAuthId;	}	public void setParentAuthId(String parentAuthId) {	    this.parentAuthId=parentAuthId;	}	public String getLeafInd() {	    return this.leafInd;	}	public void setLeafInd(String leafInd) {	    this.leafInd=leafInd;	}
	@Override
	public String toString() {
		return "JwSystemAuth [id=" + id + ", authId=" + authId + ", authName="
				+ authName  + ", authType=" + authType
				+ ", authContr=" + authContr
				+ ", parentAuthId=" + parentAuthId +", leafInd=" + leafInd
				+ "]";
	}
	
}

