package com.jeecg.cms.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.cms.entity.CmsArticle;

/**
 * 描述：</b>CmsArticleDao<br>
 * @author：p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
@Repository
public interface CmsArticleDao extends CmsDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cms_article WHERE ID = :id")
	CmsArticle get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cmsArticle
	 * @return
	 */
	int update(@Param("cmsArticle") CmsArticle cmsArticle);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cmsArticle") CmsArticle cmsArticle);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cmsArticle
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CmsArticle.class)
	public MiniDaoPage<CmsArticle> getAll(@Param("cmsArticle") CmsArticle cmsArticle,@Param("page")  int page,@Param("rows") int rows);
	
	@ResultType(CmsArticle.class)
	public MiniDaoPage<CmsArticle> getAll();
	
	@ResultType(CmsArticle.class)
	public MiniDaoPage<CmsArticle> getListByMenu(@Param("coulmnId") String coulmnId );
	
	@ResultType(String.class)
	public String getCount(@Param("coulmnId") String coulmnId );
	
	@Sql("DELETE from cms_article WHERE ID = :cmsArticle.id")
	public void delete(@Param("cmsArticle") CmsArticle cmsArticle);
	
}

