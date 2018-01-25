package com.jeecg.cms.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeecg.cms.cmsdata.CmsDataCollectI;
import com.jeecg.cms.cmsdata.impl.CmsArticleDataCollect;
import com.jeecg.cms.cmsdata.impl.CmsIndexDataCollect;
import com.jeecg.cms.cmsdata.impl.CmsMenuDataCollect;
import com.jeecg.cms.common.CmsConstant;
import com.jeecg.cms.common.CmsDataContent;
import com.jeecg.cms.dao.CmsSiteDao;
import com.jeecg.cms.dao.CmsStyleDao;
import com.jeecg.cms.entity.CmsSite;
import com.jeecg.cms.entity.CmsStyle;
import com.jeecg.cms.util.CmsFreemarkerHelper;


/**
 * CMS微站核心控制器
 * 
 * @author zhangdaihao
 * 
 */
@Controller
@RequestMapping("/p3/cms/cmsController")
public class CmsController extends BaseController {
	@Autowired
	private CmsSiteDao cmsSiteDao;
	
	@Autowired
	private CmsStyleDao cmsStyleDao;

	/**
	 * CMS 数据收集器配置
	 */
	private static Map<String, Object> dataCollectContent = new HashMap<String, Object>();
	static {
		// 载CMS首页数据
		dataCollectContent.put(CmsConstant.CMS_PAGE_INDEX, new CmsIndexDataCollect());
		// CMS栏目数据
		dataCollectContent.put(CmsConstant.CMS_PAGE_MENU, new CmsMenuDataCollect());
		// CMS文章数据
		dataCollectContent.put(CmsConstant.CMS_PAGE_ARTICLE, new CmsArticleDataCollect());
	}


	/**
	 * 页面调整引擎
	 * 
	 * @param request
	 * @param response
	 * @param page
	 *            模板页
	 * @param id
	 *            数据ID
	 */
	@RequestMapping(params = "goPage")
	public void goPage(HttpServletRequest request, HttpServletResponse response, @RequestParam String page) {
		Map<String, String> params = paramsToMap(request);
		
		// ---------------------------------------------------------------------------------------------------------
		// 获取站点的网站样式风格 模块根路径
		String rootUrl = CmsConstant.CMS_ROOT_PATH;
		String styleUrl = null;
		
		// 站点信息
		CmsSite cmsSiteEntity = null;
		List<CmsSite> cmsSiteList = cmsSiteDao.getAll().getResults();
		if (cmsSiteList.size() > 0) {
			cmsSiteEntity = cmsSiteList.get(0);
		}

		// 站点模板样式
		CmsStyle cmsStyleEntity = null;
		// 模板名字 add by liuqiang
		String templateName = null;
		// mod by liuqiang 如果是微相册的请求用默认模板default
		if (cmsSiteEntity != null) {
			if (cmsSiteEntity.getSiteTemplateStyle() != null) {
				cmsStyleEntity = cmsStyleDao.get(cmsSiteEntity.getId());
			}
			if (cmsStyleEntity != null) {
				templateName = File.separator + cmsStyleEntity.getTemplateUrl();
				styleUrl = rootUrl + "/" + cmsStyleEntity.getTemplateUrl() + CmsConstant.CMS_TEMPL_PACKAGE;
				
			} else {
				templateName = CmsConstant.CMS_DEFAULT_TEMPLATE;
				styleUrl = rootUrl + CmsConstant.CMS_DEFAULT_STYLE;
			}
		} else {
			templateName = CmsConstant.CMS_DEFAULT_TEMPLATE;
			styleUrl = rootUrl + CmsConstant.CMS_DEFAULT_STYLE;
			
		}
		params.put(CmsConstant.CMS_STYLE_NAME, templateName);
		params.put(CmsConstant.BASEPATH, request.getContextPath());
		// ---------------------------------------------------------------------------------------------------------
		CmsFreemarkerHelper cmsFreemarkerHelper = new CmsFreemarkerHelper();
		// 调用对应的数据收集器数据
		if (dataCollectContent.get(page) != null) {
			CmsDataCollectI cmsDataCollect = (CmsDataCollectI) dataCollectContent.get(page);
			cmsDataCollect.collect(params);
		}

		// 将所有容器的数据访问，加上前缀cmsData，注意大小写
		String pageurl = styleUrl + page + CmsConstant.CMS_TEMPL_INDEX;
		String html = cmsFreemarkerHelper.parseTemplate(pageurl, CmsDataContent.loadContent());
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-store");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println(html);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (Exception e2) {
			}
		}
	}

	/**
	 * 封装request请求参数到Map里
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, String> paramsToMap(HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		// 得到枚举类型的参数名称，参数名称若有重复的只能得到第一个
		Enumeration<?> em = request.getParameterNames();
		while (em.hasMoreElements()) {
			String paramName = (String) em.nextElement();
			String paramValue = request.getParameter(paramName);
			// 形成键值对应的map
			params.put(paramName, paramValue);
		}
		return params;
	}
}
