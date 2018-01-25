package com.jeecg.order.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.order.entity.JpDemoOrderCustomEntity;

/**
 * 描述：</b>JpDemoOrderCustomDao<br>
 * @author：p3.jeecg
 * @since：2016年09月03日 14时07分21秒 星期六 
 * @version:1.0
 */
@Repository
public interface JpDemoOrderCustomDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM jp_demo_order_custom WHERE ID = :id")
	JpDemoOrderCustomEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param jpDemoOrderCustom
	 * @return
	 */
	int update(@Param("jpDemoOrderCustom") JpDemoOrderCustomEntity jpDemoOrderCustom);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("jpDemoOrderCustom") JpDemoOrderCustomEntity jpDemoOrderCustom);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param jpDemoOrderCustom
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(JpDemoOrderCustomEntity.class)
	public MiniDaoPage<JpDemoOrderCustomEntity> getAll(@Param("jpDemoOrderCustom") JpDemoOrderCustomEntity jpDemoOrderCustom,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from jp_demo_order_custom WHERE ID = :jpDemoOrderCustom.id")
	public void delete(@Param("jpDemoOrderCustom") JpDemoOrderCustomEntity jpDemoOrderCustom);
	
	@Sql("select * from jp_demo_order_custom where GO_ORDER_CODE =:goOrderCode and delflag = 0")
	List<JpDemoOrderCustomEntity> getByOrderCode(@Param("goOrderCode")String goOrderCode);

	@Sql("update jp_demo_order_custom set DELFLAG = 1, DEL_DT = now() where GO_ORDER_CODE =:goOrderCode")
	void delByOrderCode(@Param("goOrderCode") String goOrderCode);
	
	@Sql("DELETE from jp_demo_order_custom WHERE GO_ORDER_CODE =:goOrderCode")
	void deleteByOrderCode(@Param("goOrderCode") String goOrderCode);

	@Sql("select count(id) from jp_demo_order_custom where go_order_code = :goOrderCode")
	Integer getCountByOrderCode(@Param("goOrderCode") String goOrderCode);
	
}

