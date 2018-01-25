package com.jeecg.qywx.base.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.qywx.base.entity.QywxGzentity;

/**
 * 描述：</b>QywxGzentityDao<br>
 * @author：zhoujf
 * @since：2016年03月25日 12时04分15秒 星期五 
 * @version:1.0
 */
@Repository
public interface QywxGzentityDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM qywx_gzentity WHERE ID = :id")
	QywxGzentity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param qywxGzentity
	 * @return
	 */
	int update(@Param("qywxGzentity") QywxGzentity qywxGzentity);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("qywxGzentity") QywxGzentity qywxGzentity);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param qywxGzentity
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(QywxGzentity.class)
	public MiniDaoPage<QywxGzentity> getAll(@Param("qywxGzentity") QywxGzentity qywxGzentity,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from qywx_gzentity WHERE ID = :qywxGzentity.id")
	public void delete(@Param("qywxGzentity") QywxGzentity qywxGzentity);
	
}

