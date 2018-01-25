package com.jeecg.cms.cmsdata.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jeecgframework.p3.core.utils.common.ApplicationContextUtil;

import com.jeecg.cms.cmsdata.CmsDataCollectI;
import com.jeecg.cms.common.CmsConstant;
import com.jeecg.cms.common.CmsDataContent;
import com.jeecg.cms.dao.CmsArticleDao;
import com.jeecg.cms.dao.CmsMenuDao;
import com.jeecg.cms.entity.CmsArticle;
import com.jeecg.cms.entity.CmsMenu;
import com.jeecg.cms.util.MyBeanUtils;



/**
 * CMS 栏目数据收集器
 * @author jg_huangxg
 *
 */
public class CmsMenuDataCollect implements CmsDataCollectI {

	@Override
	public void collect(Map<String, String> params) {
		CmsMenuDao cmsMenuDao = (CmsMenuDao) ApplicationContextUtil.getContext().getBean("cmsMenuDao");
		CmsArticleDao cmsArticleDao = (CmsArticleDao) ApplicationContextUtil.getContext().getBean("cmsArticleDao");
		
		String menuid = params.get("id") != null ? params.get("id").toString(): "-";
		CmsMenu menuEntity = cmsMenuDao.get(menuid);
		CmsArticle cmsArticleEntity = null;
		if (menuEntity != null) {
			//------------------------------------------------------------------
			List<CmsArticle> list = cmsArticleDao.getListByMenu(menuid).getResults();
			//判断Menu类型
			if("link".equals(menuEntity.getType())){
				//单文章类型，则加载排序第一条文章
				if(list!=null&&list.size()>0){
					 cmsArticleEntity = list.get(0);
					 ArrayList<CmsArticle> articles = new ArrayList<CmsArticle>();
					 articles.add(cmsArticleEntity);
					 CmsDataContent.put(CmsConstant.CMS_DATA_LIST_ARTICLE, articles);
				}
			} else {
				CmsDataContent.put(CmsConstant.CMS_DATA_LIST_ARTICLE, list);
			}
			Map<String, CmsArticle> valueMap = new HashMap<String, CmsArticle>();
			MyBeanUtils.copyBean2Map(valueMap, menuEntity);
			if(cmsArticleEntity==null)
					cmsArticleEntity = new CmsArticle();
			valueMap.put("article", cmsArticleEntity);
			//------------------------------------------------------------------
			CmsDataContent.put(CmsConstant.CMS_DATA_MAP_MENU, valueMap);
			CmsDataContent.put(CmsConstant.CMS_DATA_STR_TITLE, menuEntity.getName());
		} else {
			CmsDataContent.put(CmsConstant.CMS_DATA_MAP_MENU, new CmsMenu());
			CmsDataContent.put(CmsConstant.CMS_DATA_STR_TITLE, "信息列表");
		}
		String res = CmsConstant.CMS_ROOT_PATH + File.separator + params.get(CmsConstant.CMS_STYLE_NAME);
		//资源路径
		CmsDataContent.put(CmsConstant.BASE, res);
		CmsDataContent.put(CmsConstant.BASEPATH, params.get(CmsConstant.BASEPATH));
	}

}
