package com.fly.mapper;

import java.util.List;

import com.fly.domain.User;
import com.fly.domain.UserQueryV;

public interface UserMapper {
	//1查询一个用户
	public User findUser(int id)throws Exception;
	//2添加用户
	public void addUser(User user)throws Exception;
	//3删除用户
	public void deleteUser(int id)throws Exception;
	//4更新用户
	public void updateUser(User user)throws Exception;
	//5迷糊查询
	public List<User> findUserByName(String name)throws Exception;
	
	//6用户综合查询
	public List<User> findUserList(UserQueryV uqv)throws Exception;
	
	//7聚合函数
	public int findUserCount(UserQueryV uqv)throws Exception;
	
	//8ResultMap（表字段和实体类属性不一致时可用）
	public User findUserResultMap(int id)throws Exception;
	
	//9动态sql用户综合查询
	public List<User> findUserListSQL(UserQueryV uqv)throws Exception;
	
	//10动态sql聚合函数
	public int findUserCountSQL(UserQueryV uqv)throws Exception;
	
	//11动态sql用户综合查询 之sql片段
	public List<User> findUserListSQLpd(UserQueryV uqv)throws Exception;

}
