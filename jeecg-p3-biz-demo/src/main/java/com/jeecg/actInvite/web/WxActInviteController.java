package com.jeecg.actInvite.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.author.LoginUser;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ContextHolderUtils;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.actInvite.dao.WxActInviteDao;
import com.jeecg.actInvite.entity.WxActInvite;

 /**
 * 描述：</b>BackController<br>系统欢迎页
 * @author Alex
 * @since：2015年12月23日 12时04分42秒 星期二 
 * @version:1.0
 */
@Controller
@RequestMapping("/p3/wxActInvite")
public class WxActInviteController extends BaseController{
	private static final Logger logger = Logger.getLogger(WxActInviteController.class);
	
	@Autowired
	private WxActInviteDao wxActCommoninviteDao;
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute WxActInvite query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
		 try {
			 LOG.info(request, " back list");
			 	//分页数据
			 MiniDaoPage<WxActInvite> list =  wxActCommoninviteDao.getAll(query,pageNo,pageSize);
			 VelocityContext velocityContext = new VelocityContext();
			 velocityContext.put("wxActCommoninvite",query);
			 velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
			 String viewName = "actInvite/wxActCommoninvite-list.vm";
			 
			 LoginUser u = ContextHolderUtils.getLoginSessionUser();
			 logger.info(" -- test -- "+ u.getRealName());
			 
			 
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
	public void wxActCommoninviteDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "actInvite/wxActCommoninvite-detail.vm";
			WxActInvite wxActCommoninvite = wxActCommoninviteDao.get(id);
			velocityContext.put("wxActCommoninvite",wxActCommoninvite);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "actInvite/wxActCommoninvite-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute WxActInvite wxActCommoninvite){
		AjaxJson j = new AjaxJson();
		try {
			 String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			 wxActCommoninvite.setId(randomSeed);
			 wxActCommoninviteDao.insert(wxActCommoninvite);
			j.setMsg("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
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
			 WxActInvite wxActCommoninvite = wxActCommoninviteDao.get(id);
			 velocityContext.put("wxActCommoninvite",wxActCommoninvite);
			 String viewName = "actInvite/wxActCommoninvite-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}
	
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute WxActInvite wxActCommoninvite){
		AjaxJson j = new AjaxJson();
		try {
			wxActCommoninviteDao.update(wxActCommoninvite);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			e.printStackTrace();
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
				WxActInvite invite = new WxActInvite();
				invite.setId(id);
				wxActCommoninviteDao.delete(invite);
				j.setMsg("删除成功");
			} catch (Exception e) {
				e.printStackTrace();
				j.setSuccess(false);
				j.setMsg("删除失败");
			}
			return j;
	}
}

