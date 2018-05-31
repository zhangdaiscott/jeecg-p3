package com.jeecg.helloworld.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述：hello world
 * @version:1.0
 */
@Controller
@RequestMapping("/hello")
public class HelloController extends BaseController {

	/**
	 * 访问页面
	 * @return
	 */
	@RequestMapping(params = "list", method = { RequestMethod.GET, RequestMethod.POST })
	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info(" jrbel ------");
		
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "helloworld/hello.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}
	
	/**
	 * 访问页面
	 * @return
	 */
	@RequestMapping(params = "btform", method = { RequestMethod.GET, RequestMethod.POST })
	public void btform(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.info(" jrbel ------");
		
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "helloworld/bt-form.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

}
