package com.jeecg.cms.cmsdata.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.jeecgframework.p3.core.utils.common.ApplicationContextUtil;

import com.jeecg.cms.cmsdata.CmsDataCollectI;
import com.jeecg.cms.common.CmsConstant;
import com.jeecg.cms.common.CmsDataContent;
import com.jeecg.cms.dao.CmsAdDao;
import com.jeecg.cms.dao.CmsMenuDao;
import com.jeecg.cms.entity.CmsAd;
import com.jeecg.cms.entity.CmsMenu;



/**
 * CMS首页数据收集器
 * @author jg_huangxg
 *
 */
public class CmsIndexDataCollect implements CmsDataCollectI {

	@Override
	public void collect(Map<String, String> params) {
		//注意其他方法调用只能写在里面
		CmsAdDao cmsAdDao = (CmsAdDao) ApplicationContextUtil.getContext().getBean("cmsAdDao");
		CmsMenuDao cmsMenuDao = (CmsMenuDao) ApplicationContextUtil.getContext().getBean("cmsMenuDao");
		
		List<CmsAd> adList = cmsAdDao.getAll().getResults();
		CmsDataContent.put(CmsConstant.CMS_DATA_LIST_AD, adList);
		List<CmsMenu> menuList = cmsMenuDao.getAll().getResults();
		
		CmsDataContent.put(CmsConstant.CMS_DATA_LIST_MENU, menuList);
		String res = CmsConstant.CMS_ROOT_PATH + File.separator + params.get(CmsConstant.CMS_STYLE_NAME);
		//资源路径
		CmsDataContent.put(CmsConstant.BASE, res);
		CmsDataContent.put(CmsConstant.BASEPATH, params.get(CmsConstant.BASEPATH));
	}
}