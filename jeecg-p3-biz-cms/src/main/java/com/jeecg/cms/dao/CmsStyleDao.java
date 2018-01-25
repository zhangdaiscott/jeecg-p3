package com.jeecg.cms.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.cms.entity.CmsStyle;

/**
 * 描述：</b>CmsStyleDao<br>
 * @author：p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
@Repository
public interface CmsStyleDao extends CmsDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cms_style WHERE ID = :id")
	CmsStyle get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cmsStyle
	 * @return
	 */
	int update(@Param("cmsStyle") CmsStyle cmsStyle);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cmsStyle") CmsStyle cmsStyle);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cmsStyle
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CmsStyle.class)
	public MiniDaoPage<CmsStyle> getAll(@Param("cmsStyle") CmsStyle cmsStyle,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cms_style WHERE ID = :cmsStyle.id")
	public void delete(@Param("cmsStyle") CmsStyle cmsStyle);
	
}

