package com.katikilabs.angaza.model;

public class GivingView {

	private int id;
	private String firstName;
	private String secondName;
	private int pledge;
	private String mode;
	private int amount;
	private String date;
	
	public GivingView(){
		
	}

	public GivingView(String firstName, String secondName, int pledge,
			String mode, int amount, String date) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.pledge = pledge;
		this.mode = mode;
		this.amount = amount;
		this.date = date;
	}


	public GivingView(int id, String firstName, String secondName, int pledge,
			String mode, int amount, String date) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.pledge = pledge;
		this.mode = mode;
		this.amount = amount;
		this.date = date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getPledge() {
		return pledge;
	}

	public void setPledge(int pledge) {
		this.pledge = pledge;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
