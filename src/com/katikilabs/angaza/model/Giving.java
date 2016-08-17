package com.katikilabs.angaza.model;

import java.util.Date;

public class Giving {

	private int id;
	private int partner_id;
	private int delegate_id;
	private int amount;
	private String givingDate;
	
	public Giving (){
		
	}

	public Giving(int id, int partner_id, int delegate_id, int amount, String givingDate) {
		super();
		this.id = id;
		this.partner_id = partner_id;
		this.delegate_id = delegate_id;
		this.amount = amount;
		this.givingDate = givingDate;
	}

	public Giving(int partner_id, int delegate_id, int amount, String givingDate) {
		super();
		this.partner_id = partner_id;
		this.delegate_id = delegate_id;
		this.amount = amount;
		this.givingDate = givingDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	public int getDelegate_id() {
		return delegate_id;
	}

	public void setDelegate_id(int delegate_id) {
		this.delegate_id = delegate_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getGivingDate() {
		//return String.format("%1$tb %1$td, %1$tY", now);//eg Oct 19, 2015
		return givingDate;
	}

	public void setGivingDate(String givingDate) {
		
		this.givingDate = givingDate;
	}
}
