package com.fly.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.fly.domain.User;
import com.fly.domain.UserCustom;
import com.fly.domain.UserQueryV;
import com.fly.mapper.UserMapper;
/**
 * 测试mapper代码方式
 * @author liang
 * 2018年11月11日上午12:46:20
 */
public class funMapper {
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
	//查询一个
	@Test
	public void fun1() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		User user = userMapper.findUser(1);
		System.out.println(user);
		session.close();
	}
	//添加用户
	@Test
	public void fun2() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sd.parse("2011-11-05");
		User user = new User("mapper", "0", date, "深圳");
		userMapper.addUser(user);
		session.commit();
		session.close();
	}
	//删除用户
	@Test
	public void fun3() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		userMapper.deleteUser(26);
		session.commit();
		session.close();
	}
	//更新用户
	@Test
	public void fun4() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		User user = userMapper.findUser(1);
		user.setSex("0");
		user.setAddress("非洲");
		userMapper.updateUser(user);
		session.commit();
		session.close();
	}
	//模糊查询
	@Test
	public void fun5() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		List<User> users = userMapper.findUserByName("%小明%");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	//用户综合查询
	@Test
	public void fun6() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//封装条件
		UserQueryV uqv = new UserQueryV();
		UserCustom u = new UserCustom();
		u.setSex("1");
		u.setLike("%小明%");
		uqv.setUserCustom(u);
		//调用UserMapper的方法
		List<User> users = userMapper.findUserList(uqv);
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	//聚合函数
	@Test
	public void fun7() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//封装条件
		UserQueryV uqv = new UserQueryV();
		UserCustom u = new UserCustom();
		u.setSex("1");
		u.setLike("%小明%");
		uqv.setUserCustom(u);
		//调用UserMapper的方法
		int result = userMapper.findUserCount(uqv);
		System.out.println(result);
		session.close();
	}
	
	//resultMap
	@Test
	public void fun8() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		User user = userMapper.findUserResultMap(1);
		System.out.println(user);
		session.close();
	}
	
	//动态sql综合查询
	@Test
	public void fun9() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//封装条件
		UserQueryV uqv = new UserQueryV();
		UserCustom u = new UserCustom();
		u.setSex("1");
		//u.setLike("%小明%");//分别打开关闭注释 看输出的sql语句
		uqv.setUserCustom(u);
		//调用UserMapper的方法
		List<User> users = userMapper.findUserListSQL(uqv);
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	//动态sql聚合函数
	@Test
	public void fun10() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//封装条件
		UserQueryV uqv = new UserQueryV();
		UserCustom u = new UserCustom();
		u.setSex("1");
		//u.setLike("%小明%");//分别打开关闭注释 看输出的sql语句
		uqv.setUserCustom(u);
		//调用UserMapper的方法
		int result = userMapper.findUserCountSQL(uqv);
		System.out.println(result);
		session.close();
	}
	
	//动态sql综合查询
	@Test
	public void fun11() throws Exception{
		//获取SqlSession
		SqlSession session = getSqlSession();
		//创建UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//封装条件
		UserQueryV uqv = new UserQueryV();
		UserCustom u = new UserCustom();
		u.setSex("1");
		u.setLike("%小明%");//分别打开关闭注释 看输出的sql语句
		uqv.setUserCustom(u);
		//调用UserMapper的方法
		List<User> users = userMapper.findUserListSQLpd(uqv);
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
}
