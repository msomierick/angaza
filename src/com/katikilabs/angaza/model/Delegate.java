package com.katikilabs.angaza.model;

public class Delegate {

	private String firstName;
	private String secondName;
	private String house;
	private String username;
	private String password;
	
	public Delegate(){
		
	}
	

	public Delegate(String firstName, String secondName, String house) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.house = house;
	}
	
	public Delegate(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firsstName) {
		this.firstName = firsstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
