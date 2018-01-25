package com.jeecg.order.service.impl;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.order.dao.JpDemoOrderMainDao;
import com.jeecg.order.entity.JpDemoOrderMainEntity;
import com.jeecg.order.service.JpDemoOrderMainService;

/**
 * 描述：</b>JpDemoOrderMainServiceImpl<br>
 * @author:p3.jeecg
 * @since：2016年09月03日 14时07分23秒 星期六 
 * @version:1.0
 */

@Service("jpDemoOrderMainService")
public class JpDemoOrderMainServiceImpl implements JpDemoOrderMainService {
	@Resource
	private JpDemoOrderMainDao jpDemoOrderMainDao;

	@Override
	public JpDemoOrderMainEntity get(String id) {
		return jpDemoOrderMainDao.get(id);
	}

	@Override
	public int update(JpDemoOrderMainEntity jpDemoOrderMain) {
		return jpDemoOrderMainDao.update(jpDemoOrderMain);
	}

	@Override
	public void insert(JpDemoOrderMainEntity jpDemoOrderMain) {
		jpDemoOrderMainDao.insert(jpDemoOrderMain);
		
	}

	@Override
	public MiniDaoPage<JpDemoOrderMainEntity> getAll(JpDemoOrderMainEntity jpDemoOrderMain, int page, int rows) {
		return jpDemoOrderMainDao.getAll(jpDemoOrderMain, page, rows);
	}

	@Override
	public void delete(JpDemoOrderMainEntity jpDemoOrderMain) {
		jpDemoOrderMainDao.delete(jpDemoOrderMain);
		
	}

	@Override
	public JpDemoOrderMainEntity getByOrderCode(String orderCode) {
		return jpDemoOrderMainDao.getByOrderCode(orderCode);
	}
}
