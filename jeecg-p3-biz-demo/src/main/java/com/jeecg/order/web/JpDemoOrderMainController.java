package com.jeecg.order.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.jeecg.order.entity.JpDemoOrderCustomEntity;
import com.jeecg.order.entity.JpDemoOrderMainEntity;
import com.jeecg.order.entity.JpDemoOrderProductEntity;
import com.jeecg.order.page.JpDemoOrderMainPage;
import com.jeecg.order.service.JpDemoOrderCustomService;
import com.jeecg.order.service.JpDemoOrderMainService;
import com.jeecg.order.service.JpDemoOrderProductService;

 /**
 * 描述：订单控制器
 * @author 张加强
 * @since：2016年09月03日 14时07分23秒 星期六 
 * @version:1.0
 */
@Controller
@RequestMapping("/demo/jpDemoOrderMain")
public class JpDemoOrderMainController extends BaseController{
  @Autowired
  private JpDemoOrderMainService jpDemoOrderMainService;
  @Autowired
  private JpDemoOrderProductService jpDemoOrderProductService;
  @Autowired
  private JpDemoOrderCustomService jpDemoOrderCustomService;
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute JpDemoOrderMainEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	//分页数据
				MiniDaoPage<JpDemoOrderMainEntity> list =  jpDemoOrderMainService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				query.setDelflag(0);
				velocityContext.put("jpDemoOrderMain",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "order/jpDemoOrderMain-list.vm";
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
	public void jpDemoOrderMainDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "order/jpDemoOrderMain-detail.vm";
			JpDemoOrderMainEntity jpDemoOrderMain = jpDemoOrderMainService.get(id);
			 List<JpDemoOrderCustomEntity> customEntities = this.jpDemoOrderCustomService.getByOrderCode(jpDemoOrderMain.getGoOrderCode());	
			 List<JpDemoOrderProductEntity> productEntities = this.jpDemoOrderProductService.getByOrderCode(jpDemoOrderMain.getGoOrderCode());
			 velocityContext.put("jpDemoOrderMain",jpDemoOrderMain);
			 velocityContext.put("customEntities", customEntities);
			 velocityContext.put("productEntities", productEntities);
			 velocityContext.put("customSize", customEntities.size());
			 velocityContext.put("productSize", productEntities.size());
			
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "order/jpDemoOrderMain-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JpDemoOrderMainEntity jpDemoOrderMain,
			@ModelAttribute JpDemoOrderMainPage orderMainPage){
		AjaxJson j = new AjaxJson();
		try {
		   
			/*
			 * 添加的时候需要添加对应的客户列表数据信息和产品列表数据信息
			 */
			List<JpDemoOrderCustomEntity> orderCustomEntities = orderMainPage.getOrderCustomEntities();
			List<JpDemoOrderProductEntity> orderProductEntities = orderMainPage.getOrderProductEntities();
			
			if(orderCustomEntities.size() <= 0 || orderProductEntities.size() <= 0){
				j.setMsg("请至少添加一个产品详情或者客户详情");
				j.setSuccess(false);
			}else{
				String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			    jpDemoOrderMain.setId(randomSeed);
			    jpDemoOrderMain.setDelflag(0);
			    jpDemoOrderMain.setCreateDt(new Date());
				jpDemoOrderMainService.insert(jpDemoOrderMain);
				
				for (JpDemoOrderProductEntity entity : orderProductEntities) {
					randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
					entity.setId(randomSeed);
					entity.setGoOrderCode(jpDemoOrderMain.getGoOrderCode());
					entity.setCreateDt(new Date());
					entity.setDelflag(0);
					jpDemoOrderProductService.insert(entity);
				}
				for (JpDemoOrderCustomEntity customEntity : orderCustomEntities) {
					randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
					customEntity.setId(randomSeed);
					customEntity.setGoOrderCode(jpDemoOrderMain.getGoOrderCode());
					customEntity.setCreateDt(new Date());
					customEntity.setDelflag(0);
					jpDemoOrderCustomService.insert(customEntity);
				}
				
				j.setMsg("保存成功");
			}
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
		try{
			VelocityContext velocityContext = new VelocityContext();
			 JpDemoOrderMainEntity jpDemoOrderMain = jpDemoOrderMainService.get(id);
			 List<JpDemoOrderCustomEntity> customEntities = this.jpDemoOrderCustomService.getByOrderCode(jpDemoOrderMain.getGoOrderCode());	
			 List<JpDemoOrderProductEntity> productEntities = this.jpDemoOrderProductService.getByOrderCode(jpDemoOrderMain.getGoOrderCode());
			 velocityContext.put("jpDemoOrderMain",jpDemoOrderMain);
			 velocityContext.put("customEntities", customEntities);
			 velocityContext.put("productEntities", productEntities);
			 velocityContext.put("customSize", customEntities.size());
			 velocityContext.put("productSize", productEntities.size());
			 String viewName = "order/jpDemoOrderMain-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JpDemoOrderMainEntity jpDemoOrderMain,
			@ModelAttribute JpDemoOrderMainPage orderMainPage){
		AjaxJson j = new AjaxJson();
		try {
			/**
			 * 根据获取到的客户和产品列表数据修订对应的数据信息
			 */
			List<JpDemoOrderCustomEntity> orderCustomEntities = orderMainPage.getOrderCustomEntities();
			List<JpDemoOrderProductEntity> orderProductEntities = orderMainPage.getOrderProductEntities();
			if(orderCustomEntities.size() <= 0 || orderProductEntities.size() <= 0){
				j.setMsg("请至少添加一个产品详情或者客户详情");
				j.setSuccess(false);
			}else{
				JpDemoOrderMainEntity tempEntity = this.jpDemoOrderMainService.get(jpDemoOrderMain.getId());
				jpDemoOrderMainService.update(jpDemoOrderMain);
				
				/*
				 * 获取现有的数据量，如果数据量与数据库当中保存的数据量不对等的情况下
				 * 删除数据库当中与订单编码一致的所有数据信息
				 */
				boolean customIsChange = false;
				boolean productIsChange = false;
				if(!tempEntity.getGoOrderCode().equals(jpDemoOrderMain.getGoOrderCode())){
					this.jpDemoOrderCustomService.deleteByOrderCode(tempEntity.getGoOrderCode());
					customIsChange = true;
					this.jpDemoOrderProductService.deleteByOrderCode(tempEntity.getGoOrderCode());
					productIsChange = true;
				}else{
					Integer customCount = this.jpDemoOrderCustomService.getCountByOrderCode(jpDemoOrderMain.getGoOrderCode());
					if(customCount != orderCustomEntities.size()){
						this.jpDemoOrderCustomService.deleteByOrderCode(jpDemoOrderMain.getGoOrderCode());
						customIsChange = true;
					}
					Integer productCount = this.jpDemoOrderProductService.getCountByOrderCode(jpDemoOrderMain.getGoOrderCode());
					if(productCount != orderProductEntities.size()){
						this.jpDemoOrderProductService.deleteByOrderCode(jpDemoOrderMain.getGoOrderCode());
						productIsChange = true;
					}
				}
				for(JpDemoOrderCustomEntity entity : orderCustomEntities){
					if(StringUtils.isEmpty(entity.getId()) || customIsChange){
						String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
						entity.setId(randomSeed);
						entity.setCreateDt(new Date());
						entity.setDelflag(0);
						entity.setGoOrderCode(jpDemoOrderMain.getGoOrderCode());
						this.jpDemoOrderCustomService.insert(entity);
					}else{
						this.jpDemoOrderCustomService.update(entity);
					}
				}
				for(JpDemoOrderProductEntity entity : orderProductEntities){
					if(StringUtils.isEmpty(entity.getId()) || productIsChange){
						String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
						entity.setId(randomSeed);
						entity.setCreateDt(new Date());
						entity.setDelflag(0);
						entity.setGoOrderCode(jpDemoOrderMain.getGoOrderCode());
						this.jpDemoOrderProductService.insert(entity);
					}else{
						this.jpDemoOrderProductService.update(entity);
					}
				}
				j.setMsg("编辑成功");
			}
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
			    JpDemoOrderMainEntity jpDemoOrderMain = new JpDemoOrderMainEntity();
				jpDemoOrderMain.setId(id);
				jpDemoOrderMainService.delete(jpDemoOrderMain);
				/**
				 * 删除的时候，一起删除对应的产品列表和客户列表数据信息
				 * 
				 * 根据订单编号进行删除数据
				 */
				this.jpDemoOrderCustomService.delByOrderCode(jpDemoOrderMain.getGoOrderCode());
				this.jpDemoOrderProductService.delbyOrderCode(jpDemoOrderMain.getGoOrderCode());
				j.setMsg("删除成功");
			} catch (Exception e) {
			    log.info(e.getMessage());
				j.setSuccess(false);
				j.setMsg("删除失败");
			}
			return j;
	}


	
	/**
	 * 校验订单编号是否可以正常使用
	 * @param orderCode
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(params="checkOrderCode")
	@ResponseBody
	public Map<String, String> checkOrderCode(String orderCode,String id,HttpServletRequest request){
		orderCode = request.getParameter("param");
		Map<String, String> resultMap = new HashMap<String, String>();
		try{
			if(orderCode != null && !orderCode.trim().equals("")){
				JpDemoOrderMainEntity orderMainEntity = this.jpDemoOrderMainService.getByOrderCode(orderCode);
				LOG.debug("orderMainEntity == null"+(orderMainEntity == null));
				if(orderMainEntity != null && !orderMainEntity.getId().equals(id)){
					resultMap.put("info", "该编码不可用");  
					resultMap.put("status", "n"); 
				}else{
					resultMap.put("info", "该编码可用");  
					resultMap.put("status", "y");  
				}
			}else{
				resultMap.put("info", "该编码可用");  
				resultMap.put("status", "y"); 
			}
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("info", "服务端异常："+e.getMessage());  
			resultMap.put("status", "n");  
		}
		
		LOG.debug(resultMap.toString());
		return resultMap;
		
	}
	
}

