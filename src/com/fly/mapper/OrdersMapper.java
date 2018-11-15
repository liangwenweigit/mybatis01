package com.fly.mapper;

import java.util.List;

import com.fly.domain.Orders;
import com.fly.domain.OrdersCustom;
import com.fly.domain.User;

/**
 * orders接口类
 * @author liang
 * 2018年11月12日下午5:09:16
 */
public interface OrdersMapper {
	//01查询订单关联查询用户resultType
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//02查询订单关联查询用户resultMap 
	public List<Orders> findOrdersUserResultMap()throws Exception;
	
	//03查询订单关联查询用户及订单明细 resultMap
	public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;
	
	//04查询用户及用户购买商品信息。多对多4表
	public List<User> findAll()throws Exception;
	
	//05association延迟加载 查询订单并且关联查询用户信息
	public List<Orders> findOrdersUserLazyLoading()throws Exception;
}
