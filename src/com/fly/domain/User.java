package com.fly.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class User implements Serializable{
	
	//属性名和数据库表的字段对应
	private int id;
	private String username;// 用户姓名
	private String sex;// 性别
	private Date birthday;// 生日
	private String address;// 地址
	
	private List<Orders> orders = new ArrayList<Orders>(0);
	
	public User(String username, String sex, Date birthday, String address) {
		super();
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", orders=" + orders + "]";
	}

	public String getAddress() {
		return address;
	}
	public User(int id, String username, String sex, Date birthday, String address) {
		super();
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


}
