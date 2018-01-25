package com.jeecg.${projectName}.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 /**
 * 描述：首页
 * @author scott
 * @version:1.0
 */
@Controller
@RequestMapping("/${projectName}/index")
public class ${projectNameUpperName}IndexController extends BaseController{

	/**
	 * 跳转首页
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public void index(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		 try {
			 VelocityContext velocityContext = new VelocityContext();
			 String viewName = "${projectName}/main/index.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

