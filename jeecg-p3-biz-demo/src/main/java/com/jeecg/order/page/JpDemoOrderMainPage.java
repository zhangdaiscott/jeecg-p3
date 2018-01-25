package com.jeecg.order.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jeecg.order.entity.JpDemoOrderCustomEntity;
import com.jeecg.order.entity.JpDemoOrderProductEntity;

public class JpDemoOrderMainPage implements Serializable{

	/**
	 * 客户列表
	 */
	private List<JpDemoOrderCustomEntity> orderCustomEntities = new ArrayList<JpDemoOrderCustomEntity>();
	/**
	 * 产品列表
	 */
	private List<JpDemoOrderProductEntity> orderProductEntities = new ArrayList<JpDemoOrderProductEntity>();

	public List<JpDemoOrderCustomEntity> getOrderCustomEntities() {
		return orderCustomEntities;
	}

	public void setOrderCustomEntities(List<JpDemoOrderCustomEntity> orderCustomEntities) {
		this.orderCustomEntities = orderCustomEntities;
	}

	public List<JpDemoOrderProductEntity> getOrderProductEntities() {
		return orderProductEntities;
	}

	public void setOrderProductEntities(List<JpDemoOrderProductEntity> orderProductEntities) {
		this.orderProductEntities = orderProductEntities;
	}
	
	
}
