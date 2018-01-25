package com.jeecg.order.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.order.entity.JpDemoOrderMainEntity;

/**
 * 描述：</b>JpDemoOrderMainDao<br>
 * @author：p3.jeecg
 * @since：2016年09月03日 14时07分23秒 星期六 
 * @version:1.0
 */
@Repository
public interface JpDemoOrderMainDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM jp_demo_order_main WHERE ID = :id")
	JpDemoOrderMainEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param jpDemoOrderMain
	 * @return
	 */
	int update(@Param("jpDemoOrderMain") JpDemoOrderMainEntity jpDemoOrderMain);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("jpDemoOrderMain") JpDemoOrderMainEntity jpDemoOrderMain);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param jpDemoOrderMain
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(JpDemoOrderMainEntity.class)
	public MiniDaoPage<JpDemoOrderMainEntity> getAll(@Param("jpDemoOrderMain") JpDemoOrderMainEntity jpDemoOrderMain,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from jp_demo_order_main WHERE ID = :jpDemoOrderMain.id")
	public void delete(@Param("jpDemoOrderMain") JpDemoOrderMainEntity jpDemoOrderMain);

	@Sql("select * from jp_demo_order_main WHERE GO_ORDER_CODE = :orderCode")
	JpDemoOrderMainEntity getByOrderCode(@Param("orderCode") String orderCode);
	
}

