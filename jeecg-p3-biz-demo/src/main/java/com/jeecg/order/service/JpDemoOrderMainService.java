package com.jeecg.order.service;

import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.order.entity.JpDemoOrderMainEntity;

/**
 * 描述：</b>JpDemoOrderMainService<br>
 * @author:p3.jeecg
 * @since：2016年09月03日 14时07分23秒 星期六 
 * @version:1.0
 */
public interface JpDemoOrderMainService {
	public JpDemoOrderMainEntity get(String id);

	public int update(JpDemoOrderMainEntity jpDemoOrderMain);

	public void insert(JpDemoOrderMainEntity jpDemoOrderMain);

	public MiniDaoPage<JpDemoOrderMainEntity> getAll(JpDemoOrderMainEntity jpDemoOrderMain,int page,int rows);

	public void delete(JpDemoOrderMainEntity jpDemoOrderMain);

	public JpDemoOrderMainEntity getByOrderCode(String orderCode);
	
}
