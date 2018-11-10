package com.fly.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tools.ant.types.resources.comparators.Date;
import org.junit.Test;
import com.fly.domain.User;



public class fun {
	
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
	
	@Test
	public void fun1() throws IOException{
		//加载主配置文件
		String resource = "SqlMapConfig.xml";
		//获得主配置文件流
		InputStream is = Resources.getResourceAsStream(resource);
		//获取回话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//获取SqlSession实例，能直接执行已经映射的收起来 语句
		SqlSession session = sessionFactory.openSession();
		//第一个参数是：mapper.xml映射文件的 namespace.id 组成的字符串
		//第二个参数是：mapper.xml映射文件对应id的parameterType类型的参数
		User user = session.selectOne("com.fly.domain.User.getUserById", 1);
		//结果是mapper.xml映射文件对应的resultType
		System.out.println(user);
		//关闭session
		session.close();
	}
	//<!--根据用户名模糊查询  select * from user where username like ? -->
	@Test
	public void fun2(){
		SqlSession session = getSqlSession();
		List<User> users = session.selectList("com.fly.domain.User.getUserByName", "%"+"小明"+"%");
		for (User u : users) {
			System.out.println(u);
		}
		session.close();
	}
	//添加用户
	@Test
	public void fun3() throws ParseException{
		SqlSession session = getSqlSession();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = sd.parse("2017-05-02");
		User user = new User("测试","1",d,"广东");
		session.insert("com.fly.domain.User.addUser", user);
		session.commit();//需要提交 要不然存不进去数据库
		System.out.println(user.getId());
		session.close();
	}
	//删除用户
	@Test
	public void fun4(){
		SqlSession session = getSqlSession();
		session.selectOne("com.fly.domain.User.deleteUser", 34);
		session.commit();
		session.close();
	}
	//更新用户
	@Test
	public void fun5(){
		SqlSession session = getSqlSession();
		User user = session.selectOne("com.fly.domain.User.getUserById", 33);
		user.setUsername("更新更新");
		session.update("com.fly.domain.User.updateUser", user);
		session.commit();
		session.close();
	}
}
