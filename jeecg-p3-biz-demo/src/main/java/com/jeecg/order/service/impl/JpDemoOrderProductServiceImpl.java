package com.jeecg.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.order.dao.JpDemoOrderProductDao;
import com.jeecg.order.entity.JpDemoOrderProductEntity;
import com.jeecg.order.service.JpDemoOrderProductService;

/**
 * 描述：</b>JpDemoOrderProductServiceImpl<br>
 * @author:p3.jeecg
 * @since：2016年09月03日 14时07分24秒 星期六 
 * @version:1.0
 */

@Service("jpDemoOrderProductService")
public class JpDemoOrderProductServiceImpl implements JpDemoOrderProductService {
	@Resource
	private JpDemoOrderProductDao jpDemoOrderProductDao;

	@Override
	public JpDemoOrderProductEntity get(String id) {
		return jpDemoOrderProductDao.get(id);
	}

	@Override
	public int update(JpDemoOrderProductEntity jpDemoOrderProduct) {
		return jpDemoOrderProductDao.update(jpDemoOrderProduct);
	}

	@Override
	public void insert(JpDemoOrderProductEntity jpDemoOrderProduct) {
		jpDemoOrderProductDao.insert(jpDemoOrderProduct);
		
	}

	@Override
	public MiniDaoPage<JpDemoOrderProductEntity> getAll(JpDemoOrderProductEntity jpDemoOrderProduct, int page, int rows) {
		return jpDemoOrderProductDao.getAll(jpDemoOrderProduct, page, rows);
	}

	@Override
	public void delete(JpDemoOrderProductEntity jpDemoOrderProduct) {
		jpDemoOrderProductDao.delete(jpDemoOrderProduct);
	}
	
	@Override
	public List<JpDemoOrderProductEntity> getByOrderCode(String goOrderCode) {
		return jpDemoOrderProductDao.getByOrderCode(goOrderCode);
	}

	@Override
	public void delbyOrderCode(String goOrderCode) {
		this.jpDemoOrderProductDao.delByOrderCode(goOrderCode);
	}

	@Override
	public int getCountByOrderCode(String goOrderCode) {
		return this.jpDemoOrderProductDao.getCountByOrderCode(goOrderCode);
	}

	@Override
	public void deleteByOrderCode(String goOrderCode) {
		this.jpDemoOrderProductDao.deleteByOrderCode(goOrderCode);
	}
}
