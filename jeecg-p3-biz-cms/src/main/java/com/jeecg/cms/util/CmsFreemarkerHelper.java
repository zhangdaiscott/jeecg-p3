package com.jeecg.cms.util;

import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * @Title:FreemarkerHelper
 * @description:Freemarker引擎协助类
 * @author 赵俊夫
 * @date Jul 5, 2013 2:58:29 PM
 * @version V1.0
 */
public class CmsFreemarkerHelper {
	private static Configuration _tplConfig = new Configuration();

	public CmsFreemarkerHelper() {
		try {
			_tplConfig.setClassForTemplateLoading(this.getClass(), "/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析ftl
	 * 
	 * @param tplName
	 *            模板名
	 * @param encoding
	 *            编码
	 * @param paras
	 *            参数
	 * @return
	 */
	public String parseTemplate(String tplName, String encoding,
			Map<String, Object> paras) {
		try {
			StringWriter swriter = new StringWriter();
			Template mytpl = null;
			mytpl = _tplConfig.getTemplate(tplName, encoding);
			mytpl.process(paras, swriter);
			return swriter.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}

	}

	public String parseTemplate(String tplName, Map<String, Object> paras) {
		return this.parseTemplate(tplName, "utf-8", paras);
	}
}