package com.test.springboottest.springrestful;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

	int Id;
	@NotBlank(message = "Name is mandatory")
	//@Size(min = 2,message = "minimum characters 2" )
	String name;
	Date dob;

	public User(int id, String name, Date dob) {
		super();
		Id = id;
		this.name = name;
		this.dob = dob;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", dob=" + dob + "]";
	}

}
