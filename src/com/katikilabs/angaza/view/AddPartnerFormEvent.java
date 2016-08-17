package com.katikilabs.angaza.view;

import java.util.EventObject;

public class AddPartnerFormEvent extends EventObject{

	private String firstName;
	private String secondName;
	private int pledge;
	private String mode;
	
	public AddPartnerFormEvent(Object source){
		super(source);
	}

	public AddPartnerFormEvent(Object source, String firstName,
			String secondName, int pledge, String mode) {
		super(source);
		this.firstName = firstName;
		this.secondName = secondName;
		this.pledge = pledge;
		this.mode = mode;
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
}
