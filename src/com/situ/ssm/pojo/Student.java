package com.situ.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	private Integer id;
	private String name;
	private String address;
	private String gender;
	private Integer age;
	private Date birthday;
	private Banji banji;
	
	
	
	public Student() {
		super();
	}

	
	
	public Student(String name, String address, String gender, Integer age, Date birthday) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
	}



	public Student(String name, String address, String gender, Integer age, Date birthday, Banji banji) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.banji = banji;
	}



	public Student(Integer id, String name, String address, String gender, Integer age, Date birthday, Banji banji) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.banji = banji;
	}



	public Banji getBanji() {
		return banji;
	}



	public void setBanji(Banji banji) {
		this.banji = banji;
	}



	public Student(Integer id, String name, String address, String gender, Integer age, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", age=" + age
				+ ", birthday=" + birthday + "]";
	}
	
	
}
