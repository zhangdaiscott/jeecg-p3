package com.jeecg.cms.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.cms.entity.CmsAd;

/**
 * 描述：</b>CmsAdDao<br>
 * @author：p3.jeecg
 * @since：2016年06月13日 15时00分28秒 星期一 
 * @version:1.0
 */
@Repository
public interface CmsAdDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cms_ad WHERE ID = :id")
	CmsAd get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cmsAd
	 * @return
	 */
	int update(@Param("cmsAd") CmsAd cmsAd);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cmsAd") CmsAd cmsAd);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cmsAd
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CmsAd.class)
	public MiniDaoPage<CmsAd> getAll(@Param("cmsAd") CmsAd cmsAd,@Param("page")  int page,@Param("rows") int rows);
	
	@ResultType(CmsAd.class)
	public MiniDaoPage<CmsAd> getAll();
	
	@Sql("DELETE from cms_ad WHERE ID = :cmsAd.id")
	public void delete(@Param("cmsAd") CmsAd cmsAd);
	
}

