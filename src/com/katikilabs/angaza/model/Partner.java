package com.katikilabs.angaza.model;

import java.util.Comparator;

public class Partner implements Comparable<Partner>{

	private int id;
	private String firstName;
	private String secondName;
	private int pledge;
	private String mode;
	private int delegateId;
	
	public Partner(){
		
	}

	public Partner(String firstName, String secondName, int pledge,
			String mode, int delegateId) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.pledge = pledge;
		this.mode = mode;
		this.delegateId = delegateId;
	}


	public Partner(int id, String firstName, String secondName, int pledge,
			String mode, int delegate_id) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.pledge = pledge;
		this.mode = mode;
		this.delegateId = delegate_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getDelegateId() {
		return delegateId;
	}

	public void setDelegateId(int delegate_id) {
		this.delegateId = delegate_id;
	}

	@Override
	public int compareTo(Partner partner) {
		return (this.id-partner.id);//ascending order
	}
	public static Comparator<Partner> NameComparator = new Comparator<Partner>() {
		
		@Override
		public int compare(Partner p1, Partner p2) {
			return p1.getFirstName().compareTo(p2.getFirstName());//ascending
		}
	};
public static Comparator<Partner> PledgeComparator = new Comparator<Partner>() {
		
		@Override
		public int compare(Partner p1, Partner p2) {
			return (p1.getPledge()-p2.getPledge());//ascending
		}
	};
}
