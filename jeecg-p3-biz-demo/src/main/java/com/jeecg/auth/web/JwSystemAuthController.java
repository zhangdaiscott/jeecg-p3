package com.jeecg.auth.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.auth.dao.JwSystemAuthDao;
import com.jeecg.auth.entity.JwSystemAuth;
import com.jeecg.auth.util.SystemUtil;

/**
 * 描述：</b>JwSystemAuthController<br>
 * 运营系统权限表; InnoDB free: 9216 kB
 * 
 * @author junfeng.zhou
 * @since：2015年12月21日 10时28分27秒 星期一
 * @version:1.0
 */
@Controller
@RequestMapping("/p3/auth")
public class JwSystemAuthController extends BaseController {
	@Autowired
	private JwSystemAuthDao jwSystemAuthDao;

	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping(params = "list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void list(
			@ModelAttribute JwSystemAuth query,
			HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "100") int pageSize)
			throws Exception {
		// 分页数据
		MiniDaoPage<JwSystemAuth> list = jwSystemAuthDao.getAll(query, pageNo,
				pageSize);
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("jwSystemAuth", query);
		velocityContext
				.put("pageInfos", SystemTools.convertPaginatedList(list));
		String viewName = "auth/jwSystemAuth-list.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	/**
	 * 详情
	 * 
	 * @return
	 */
	@RequestMapping(params = "toDetail", method = RequestMethod.GET)
	public void jwSystemAuthDetail(
			@RequestParam(required = true, value = "id") Long id,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "auth/jwSystemAuth-detail.vm";
		JwSystemAuth jwSystemAuth = jwSystemAuthDao.get(id);
		velocityContext.put("jwSystemAuth", jwSystemAuth);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "toAdd", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void toAddDialog(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "auth/jwSystemAuth-add.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemAuth jwSystemAuth) {
		AjaxJson j = new AjaxJson();
		try {
			jwSystemAuthDao.insert(jwSystemAuth);
			j.setMsg("保存成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "toEdit", method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id") Long id,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemAuth jwSystemAuth = jwSystemAuthDao.get(id);
		velocityContext.put("jwSystemAuth", jwSystemAuth);
		String viewName = "auth/jwSystemAuth-edit.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(params = "doEdit", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemAuth jwSystemAuth) {
		AjaxJson j = new AjaxJson();
		try {
			jwSystemAuthDao.update(jwSystemAuth);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}
		return j;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDelete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(
			@RequestParam(required = true, value = "id") Long id) {
		AjaxJson j = new AjaxJson();
		try {
			JwSystemAuth jwSystemAuth = new JwSystemAuth();
			jwSystemAuth.setId(id);
			jwSystemAuthDao.delete(jwSystemAuth);
			j.setMsg("删除成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
	}


	/**
	 * 得到权限树
	 * 
	 * @return
	 */
	@RequestMapping(params = "getAuthTree", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getAuthTree(HttpServletRequest request,
			HttpServletResponse response) {
		String tree = "";
		try {
			// 所有权限
			List<JwSystemAuth> allAuthList = jwSystemAuthDao
					.queryMenuAndFuncAuth();
			tree = SystemUtil.listTreeToAuth(allAuthList);
			log.info("权限树: " + tree);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return tree;
	}
}
