package com.spring.jagalchi.model;

public class MemberModel {
	String id;  //아이디
	String password;  //비밀번호
	String name;  //이름
	String major; //전공
	int age; //나이
	
	public MemberModel() {	}
	
	public MemberModel(String id, String password, String name, String major, int age) {
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
