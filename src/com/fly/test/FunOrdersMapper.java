package com.fly.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.fly.domain.Orders;
import com.fly.domain.OrdersCustom;
import com.fly.domain.User;
import com.fly.mapper.OrdersMapper;
import com.fly.mapper.UserMapper;

public class FunOrdersMapper {
	public SqlSession getSqlSession(){
		//加载主配置文件
		String resource = "SqlMapConfig.xml";
		//获得主配置文件流
		InputStream is = null;
		SqlSession session = null;
		try {
			is = Resources.getResourceAsStream(resource);
			//获取回话工厂
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
			//获取SqlSession实例，能直接执行已经映射的收起来 语句
			session = sessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	//01查询订单关联查询用户resultType
	@Test
	public void fun01() throws Exception{
		SqlSession session = getSqlSession();
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<OrdersCustom> os = ordersMapper.findOrdersUser();
		for (OrdersCustom ordersCustom : os) {
			System.out.println(ordersCustom);
		}
	}
	
	//02查询订单关联查询用户resultMap
	@Test
	public void fun02() throws Exception{
		SqlSession session = getSqlSession();
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<Orders> os = ordersMapper.findOrdersUserResultMap();
		for (Orders orders : os) {
			System.out.println(orders);
		}
	}
	
	//03查询订单关联查询用户及订单明细 resultMap
	@Test
	public void fun03() throws Exception{
		SqlSession session = getSqlSession();
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<Orders> os = ordersMapper.findOrdersAndOrderDetailResultMap();
		for (Orders orders : os) {
			System.out.println(orders);
		}
	}
	
	//04查询用户及用户购买商品信息。多对多4表
	@Test
	public void fun04() throws Exception{
		SqlSession session = getSqlSession();
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<User> users = ordersMapper.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	//05association延迟加载 查询订单并且关联查询用户信息
	@Test
	public void fun05() throws Exception{
		SqlSession session = getSqlSession();
		OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
		List<Orders> os = ordersMapper.findOrdersUserLazyLoading();
		for (Orders orders : os) {
			System.out.println(orders.getUser());
		}
	}
}
