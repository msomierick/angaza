package com.katikilabs.angaza.model;

import java.sql.SQLException;
import java.util.List;

public interface IPartnerDAO {

	public void addPartner(Partner partner)throws SQLException;
	public Partner getPartner(int id) throws SQLException;
	public List<Partner> getPartners()throws SQLException;
	public int deletePartner(int id) throws SQLException;
	public int deleteAll() throws SQLException;
}
