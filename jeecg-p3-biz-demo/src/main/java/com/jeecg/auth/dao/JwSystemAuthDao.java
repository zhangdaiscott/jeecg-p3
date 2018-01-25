package com.jeecg.auth.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.auth.entity.JwSystemAuth;


@Repository
public interface JwSystemAuthDao {

	/**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM jp_demo_auth WHERE ID = :id")
	JwSystemAuth get(@Param("id") Long id);


	/**
	 * 修改数据
	 * @param auth
	 * @return
	 */
	int update(@Param("auth") JwSystemAuth auth);

	/**
	 * 插入数据
	 * @param auth
	 */
	void insert(@Param("auth") JwSystemAuth auth);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param auth
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(JwSystemAuth.class)
	public MiniDaoPage<JwSystemAuth> getAll(@Param("auth") JwSystemAuth act,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from jp_demo_auth WHERE ID = :auth.id")
	public void delete(@Param("auth") JwSystemAuth auth);
	
	@ResultType(JwSystemAuth.class)
	public List<JwSystemAuth> queryMenuAndFuncAuth();
}
