package com.fly.domain;

import java.io.Serializable;


/**
 * 用户包装类
 * @author liang
 * 2018年11月11日下午3:16:32
 */
public class UserQueryV implements Serializable{
    //包装查询条件
	//查询用户的条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	//还可以包装订单
}
