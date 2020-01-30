package com.spring.jagalchi.model;

public class MemberModel {
	String id;
	String password;
	String name;
	String major;
	int age;
	
	public MemberModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberModel(String id, String password, String name, String major, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.major = major;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberModel [id=" + id + ", password=" + password + ", name=" + name + ", major=" + major + ", age="
				+ age + "]";
	}
	
}
