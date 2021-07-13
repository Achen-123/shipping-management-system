package com.po;

//存储servelt业务处理以后的数据
public class Userinfo {
	private Integer id;
	private String username;
	private String pwd;
	private String sex;
	private String hobby;
	
	public Userinfo() {
		super();
	}
	public Userinfo(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	

}
