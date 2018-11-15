package com.fly.domain;

import java.io.Serializable;

/**
 * 订单扩展类，包括订单信息、用户信息
 * @author
 * 
 */
public class OrdersCustom extends Orders implements Serializable{

	private String username;// 用户名称
	private String sex;//用户性别
	private String address;// 用户地址
	public String getUsername() {
		return username;
	}
	@Override
	public String toString() {
		System.out.println(super.toString());
		return "OrdersCustom [username=" + username + ", sex=" + sex + ", address=" + address + "]";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
