package com.jeecg.cms.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.cms.entity.CmsMenu;

/**
 * 描述：</b>CmsMenuDao<br>
 * @author：p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
@Repository
public interface CmsMenuDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cms_menu WHERE ID = :id")
	CmsMenu get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cmsMenu
	 * @return
	 */
	int update(@Param("cmsMenu") CmsMenu cmsMenu);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cmsMenu") CmsMenu cmsMenu);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cmsMenu
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CmsMenu.class)
	public MiniDaoPage<CmsMenu> getAll(@Param("cmsMenu") CmsMenu cmsMenu,@Param("page")  int page,@Param("rows") int rows);
	
	@ResultType(CmsMenu.class)
	public MiniDaoPage<CmsMenu> getAll();
	
	@Sql("DELETE from cms_menu WHERE ID = :cmsMenu.id")
	public void delete(@Param("cmsMenu") CmsMenu cmsMenu);
	
	@ResultType(CmsMenu.class)
	public MiniDaoPage<CmsMenu> getTree();

	@ResultType(String.class)
	public String getMaxLocalCode(@Param("localCodeLength") String localCodeLength,@Param("parentCode") String parentCode);
}

