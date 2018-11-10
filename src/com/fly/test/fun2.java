package com.fly.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class fun2 {
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
}
