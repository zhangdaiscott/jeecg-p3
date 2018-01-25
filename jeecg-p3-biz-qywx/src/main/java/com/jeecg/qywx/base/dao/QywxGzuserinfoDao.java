package com.jeecg.qywx.base.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.qywx.base.entity.QywxGzuserinfo;

/**
 * 描述：</b>QywxGzuserinfoDao<br>
 * @author：zhoujf
 * @since：2016年03月25日 15时24分11秒 星期五 
 * @version:1.0
 */
@Repository
public interface QywxGzuserinfoDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM qywx_gzuserinfo WHERE ID = :id")
	QywxGzuserinfo get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param qywxGzuserinfo
	 * @return
	 */
	int update(@Param("qywxGzuserinfo") QywxGzuserinfo qywxGzuserinfo);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("qywxGzuserinfo") QywxGzuserinfo qywxGzuserinfo);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param qywxGzuserinfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(QywxGzuserinfo.class)
	public MiniDaoPage<QywxGzuserinfo> getAll(@Param("qywxGzuserinfo") QywxGzuserinfo qywxGzuserinfo,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from qywx_gzuserinfo WHERE ID = :qywxGzuserinfo.id")
	public void delete(@Param("qywxGzuserinfo") QywxGzuserinfo qywxGzuserinfo);
	
}

