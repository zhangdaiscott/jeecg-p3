package com.jeecg.order.service;

import java.util.List;

import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.order.entity.JpDemoOrderCustomEntity;

/**
 * 描述：</b>JpDemoOrderCustomService<br>
 * @author:p3.jeecg
 * @since：2016年09月03日 14时07分21秒 星期六 
 * @version:1.0
 */
public interface JpDemoOrderCustomService {
	public JpDemoOrderCustomEntity get(String id);

	public int update(JpDemoOrderCustomEntity jpDemoOrderCustom);

	public void insert(JpDemoOrderCustomEntity jpDemoOrderCustom);

	public MiniDaoPage<JpDemoOrderCustomEntity> getAll(JpDemoOrderCustomEntity jpDemoOrderCustom,int page,int rows);

	public void delete(JpDemoOrderCustomEntity jpDemoOrderCustom);

	public List<JpDemoOrderCustomEntity> getByOrderCode(String goOrderCode);
	
	public void delByOrderCode(String goOrderCode);

	public void deleteByOrderCode(String goOrderCode);
	/**
	 * 查询数量
	 * @param goOrderCode
	 * @return
	 */
	public Integer getCountByOrderCode(String goOrderCode);
}
