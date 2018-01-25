package com.jeecg.order.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.order.entity.JpDemoOrderProductEntity;

/**
 * 描述：</b>JpDemoOrderProductDao<br>
 * @author：p3.jeecg
 * @since：2016年09月03日 14时07分24秒 星期六 
 * @version:1.0
 */
@Repository
public interface JpDemoOrderProductDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM jp_demo_order_product WHERE ID = :id")
	JpDemoOrderProductEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param jpDemoOrderProduct
	 * @return
	 */
	int update(@Param("jpDemoOrderProduct") JpDemoOrderProductEntity jpDemoOrderProduct);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("jpDemoOrderProduct") JpDemoOrderProductEntity jpDemoOrderProduct);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param jpDemoOrderProduct
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(JpDemoOrderProductEntity.class)
	public MiniDaoPage<JpDemoOrderProductEntity> getAll(@Param("jpDemoOrderProduct") JpDemoOrderProductEntity jpDemoOrderProduct,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from jp_demo_order_product WHERE ID = :jpDemoOrderProduct.id")
	public void delete(@Param("jpDemoOrderProduct") JpDemoOrderProductEntity jpDemoOrderProduct);
	
	
	@Sql("select * from jp_demo_order_product WHERE GO_ORDER_CODE = :goOrderCode and delflag = 0")
	List<JpDemoOrderProductEntity> getByOrderCode(@Param("goOrderCode") String goOrderCode);

	@Sql("update jp_demo_order_product set DELFLAG = 1, DEL_DT = now() where GO_ORDER_CODE = :goOrderCode")
	void delByOrderCode(@Param("goOrderCode") String goOrderCode);

	@Sql("select count(id) from jp_demo_order_product WHERE GO_ORDER_CODE = :goOrderCode")
	int getCountByOrderCode(@Param("goOrderCode") String goOrderCode);

	@Sql("delete from jp_demo_order_product WHERE GO_ORDER_CODE = :goOrderCode")
	void deleteByOrderCode(@Param("goOrderCode") String goOrderCode);
	
}

