package com.jeecg.cms.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.common.utils.StringUtil;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.cms.dao.CmsMenuDao;
import com.jeecg.cms.entity.CmsMenu;
import com.jeecg.cms.util.SimpleTreeIdBuild;

 /**
 * 描述：</b>CmsMenuController<br>
 * @author p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
@Controller
@RequestMapping("/p3/cms/cmsMenu")
public class CmsMenuController extends BaseController{
	@Autowired
	private CmsMenuDao cmsMenuDao;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute CmsMenu query,HttpServletRequest request,HttpServletResponse response,
		@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
		@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
		try {
		 	LOG.info(request, " back list");
		 	//分页数据
			MiniDaoPage<CmsMenu> list =  cmsMenuDao.getAll(query,pageNo,pageSize);
			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("cmsMenu",query);
			velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
			String viewName = "cms/cmsMenu-list.vm";
			ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void cmsMenuDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "cms/cmsMenu-detail.vm";
		CmsMenu cmsMenu = cmsMenuDao.get(id);
		velocityContext.put("cmsMenu",cmsMenu);
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "cms/cmsMenu-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute CmsMenu cmsMenu){
		AjaxJson j = new AjaxJson();
		try {
		    if (StringUtil.isEmpty(cmsMenu.getParentCode())) {//无上级
		    	cmsMenu.setId(new SimpleTreeIdBuild().getId(this.cmsMenuDao,null));
		    	cmsMenu.setParentCode(null);
			}else{//有上级
				cmsMenu.setId(new SimpleTreeIdBuild().getId(this.cmsMenuDao,cmsMenu.getParentCode()));
			}
			cmsMenuDao.insert(cmsMenu);
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
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 CmsMenu cmsMenu = cmsMenuDao.get(id);
		 velocityContext.put("cmsMenu",cmsMenu);
		 String viewName = "cms/cmsMenu-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute CmsMenu cmsMenu){
		AjaxJson j = new AjaxJson();
		try {
			cmsMenuDao.update(cmsMenu);
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
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
		AjaxJson j = new AjaxJson();
		try {
		    CmsMenu cmsMenu = new CmsMenu();
			cmsMenu.setId(id);
			cmsMenuDao.delete(cmsMenu);
			j.setMsg("删除成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
	}
	@RequestMapping(params = "tree")
	@ResponseBody
	public List<CmsMenu> tree() {
		MiniDaoPage<CmsMenu> list = cmsMenuDao.getTree();
		List<CmsMenu> cmsMenuList = list.getResults();
		return cmsMenuList;
	}
}

