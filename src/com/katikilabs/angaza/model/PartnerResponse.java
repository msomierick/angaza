package com.katikilabs.angaza.model;

public class PartnerResponse {

	private int id;
	private String date;
	private String message;
	private String followup;
	
	private PartnerResponse(){
		
	}

	public PartnerResponse(int id, String date, String message, String followup) {
		super();
		this.id = id;
		this.date = date;
		this.message = message;
		this.followup = followup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFollowup() {
		return followup;
	}

	public void setFollowup(String followup) {
		this.followup = followup;
	}
}
