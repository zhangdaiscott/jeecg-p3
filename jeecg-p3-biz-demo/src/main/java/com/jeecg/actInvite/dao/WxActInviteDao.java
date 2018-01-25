package com.jeecg.actInvite.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;
import com.jeecg.actInvite.entity.WxActInvite;


@Repository
public interface WxActInviteDao {

	/**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM jp_demo_activity WHERE ID = :id")
	WxActInvite get(@Param("id") String id);


	/**
	 * 修改数据
	 * @param act
	 * @return
	 */
	int update(@Param("act") WxActInvite act);

	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("act") WxActInvite act);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param act
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WxActInvite.class)
	public MiniDaoPage<WxActInvite> getAll(@Param("act") WxActInvite act,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from jp_demo_activity WHERE ID = :act.id")
	public void delete(@Param("act") WxActInvite act);
}
