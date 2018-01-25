package com.jeecg.cms.cmsdata.impl;

import java.io.File;
import java.util.Map;

import org.jeecgframework.p3.core.utils.common.ApplicationContextUtil;

import com.jeecg.cms.cmsdata.CmsDataCollectI;
import com.jeecg.cms.common.CmsConstant;
import com.jeecg.cms.common.CmsDataContent;
import com.jeecg.cms.dao.CmsArticleDao;
import com.jeecg.cms.entity.CmsArticle;


/**
 * CMS 文章数据收集器
 * @author jg_huangxg
 *
 */
public class CmsArticleDataCollect implements CmsDataCollectI {

	@Override
	public void collect(Map<String, String> params) {
		CmsArticleDao cmsArticleDao = (CmsArticleDao) ApplicationContextUtil.getContext().getBean("cmsArticleDao");
		
		String articleid = params.get("articleid") != null ? params.get("articleid").toString() : "-";
		CmsArticle cmsArticleEntity = cmsArticleDao.get(articleid);
		if (cmsArticleEntity != null) {
			CmsDataContent.put(CmsConstant.CMS_DATA_MAP_ARTICLE, cmsArticleEntity);
			CmsDataContent.put(CmsConstant.CMS_DATA_STR_TITLE, cmsArticleEntity.getTitle());
		}else{
			CmsDataContent.put(CmsConstant.CMS_DATA_MAP_ARTICLE, new CmsArticle());
			CmsDataContent.put(CmsConstant.CMS_DATA_STR_TITLE, "文章明细");
		}
		String res = CmsConstant.CMS_ROOT_PATH + File.separator + params.get(CmsConstant.CMS_STYLE_NAME);
		//资源路径
		CmsDataContent.put(CmsConstant.BASE, res);
		CmsDataContent.put(CmsConstant.BASEPATH, params.get(CmsConstant.BASEPATH));
	}

}
