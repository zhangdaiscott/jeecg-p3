package com.jeecg.order.service;

import java.util.List;

import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.order.entity.JpDemoOrderProductEntity;

/**
 * 描述：</b>JpDemoOrderProductService<br>
 * @author:p3.jeecg
 * @since：2016年09月03日 14时07分24秒 星期六 
 * @version:1.0
 */
public interface JpDemoOrderProductService {
	public JpDemoOrderProductEntity get(String id);

	public int update(JpDemoOrderProductEntity jpDemoOrderProduct);

	public void insert(JpDemoOrderProductEntity jpDemoOrderProduct);

	public MiniDaoPage<JpDemoOrderProductEntity> getAll(JpDemoOrderProductEntity jpDemoOrderProduct,int page,int rows);

	public void delete(JpDemoOrderProductEntity jpDemoOrderProduct);
	
	public List<JpDemoOrderProductEntity> getByOrderCode(String goOrderCode);

	public void delbyOrderCode(String goOrderCode);

	public int getCountByOrderCode(String goOrderCode);

	public void deleteByOrderCode(String goOrderCode);
}
