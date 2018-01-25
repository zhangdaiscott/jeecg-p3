package com.jeecg.cms.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.cms.entity.CmsSite;

/**
 * 描述：</b>CmsSiteDao<br>
 * @author：p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
@Repository
public interface CmsSiteDao extends CmsDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cms_site WHERE ID = :id")
	CmsSite get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cmsSite
	 * @return
	 */
	int update(@Param("cmsSite") CmsSite cmsSite);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cmsSite") CmsSite cmsSite);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cmsSite
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CmsSite.class)
	public MiniDaoPage<CmsSite> getAll(@Param("cmsSite") CmsSite cmsSite,@Param("page")  int page,@Param("rows") int rows);
	
	@ResultType(CmsSite.class)
	public MiniDaoPage<CmsSite> getAll();
	
	@Sql("DELETE from cms_site WHERE ID = :cmsSite.id")
	public void delete(@Param("cmsSite") CmsSite cmsSite);
	
}

