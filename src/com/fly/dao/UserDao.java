package com.fly.dao;

import java.sql.SQLException;

import com.fly.domain.User;

/**
 * 用户管理接口
 * @author liang
 * 2018年11月10日下午10:08:53
 */
public interface UserDao {
	
	//根据id查询用户信息
	public User findUserById(int id)throws SQLException;
	//添加用户
	public void addUser(User user)throws SQLException;
	//删除用户
	public void deleteUser(int id)throws SQLException;

}
