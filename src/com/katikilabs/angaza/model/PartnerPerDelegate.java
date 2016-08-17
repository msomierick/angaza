package com.katikilabs.angaza.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartnerPerDelegate {

	private PartnerDAO patDAO;
	private DelegateDAO delDAO;
	private List<Partner> partnerList;
	private List<Delegate> delegateList;

	public PartnerPerDelegate() throws SQLException{
		partnerList = patDAO.getPartners();
		delegateList = delDAO.getDelegates();
	}
}
