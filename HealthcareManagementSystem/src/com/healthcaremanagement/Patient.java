package com.healthcaremanagement;

public class Patient {
	private String name;
	private String dob;
	private String phone_no;
	private int age;
	private String  gender;
	
	public Patient(String name, String dob, String phono_no, String gender, int age){
	this.name= name;
	this.dob = dob;
	this.phone_no = phono_no;
	this.age = age;
	this.gender =gender; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String  getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	}


