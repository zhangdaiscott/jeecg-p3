package com.jeecg.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.order.dao.JpDemoOrderCustomDao;
import com.jeecg.order.entity.JpDemoOrderCustomEntity;
import com.jeecg.order.service.JpDemoOrderCustomService;

/**
 * 描述：</b>JpDemoOrderCustomServiceImpl<br>
 * @author:p3.jeecg
 * @since：2016年09月03日 14时07分21秒 星期六 
 * @version:1.0
 */

@Service("jpDemoOrderCustomService")
public class JpDemoOrderCustomServiceImpl implements JpDemoOrderCustomService {
	@Resource
	private JpDemoOrderCustomDao jpDemoOrderCustomDao;

	@Override
	public JpDemoOrderCustomEntity get(String id) {
		return jpDemoOrderCustomDao.get(id);
	}

	@Override
	public int update(JpDemoOrderCustomEntity jpDemoOrderCustom) {
		return jpDemoOrderCustomDao.update(jpDemoOrderCustom);
	}

	@Override
	public void insert(JpDemoOrderCustomEntity jpDemoOrderCustom) {
		jpDemoOrderCustomDao.insert(jpDemoOrderCustom);
		
	}

	@Override
	public MiniDaoPage<JpDemoOrderCustomEntity> getAll(JpDemoOrderCustomEntity jpDemoOrderCustom, int page, int rows) {
		return jpDemoOrderCustomDao.getAll(jpDemoOrderCustom, page, rows);
	}

	@Override
	public void delete(JpDemoOrderCustomEntity jpDemoOrderCustom) {
		jpDemoOrderCustomDao.delete(jpDemoOrderCustom);
		
	}

	@Override
	public List<JpDemoOrderCustomEntity> getByOrderCode(String goOrderCode) {
		return this.jpDemoOrderCustomDao.getByOrderCode(goOrderCode);
	}
	
	@Override
	public void delByOrderCode(String goOrderCode) {
		this.jpDemoOrderCustomDao.delByOrderCode(goOrderCode);
	}

	@Override
	public void deleteByOrderCode(String goOrderCode) {
		this.jpDemoOrderCustomDao.deleteByOrderCode(goOrderCode);
	}

	@Override
	public Integer getCountByOrderCode(String goOrderCode) {
		return jpDemoOrderCustomDao.getCountByOrderCode(goOrderCode);
	}
	
}
