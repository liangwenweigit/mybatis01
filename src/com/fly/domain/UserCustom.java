package com.fly.domain;

import com.fly.domain.User;

/**
 * 用户扩展类
 * @author liang
 * 2018年11月11日下午3:39:17
 */
public class UserCustom  extends User{
	
	private String like;

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

}
