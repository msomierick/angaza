package com.katikilabs.angaza.model;

import java.sql.SQLException;
import java.util.List;

public interface IPartnerResponseDAO {
	
	public void addPartnerResponse(PartnerResponse partnerResponse)throws SQLException;
	public PartnerResponse getPartnerResponse(int id) throws SQLException;
	public List<PartnerResponse> getPartnerResponses()throws SQLException;
	public int deletePartnerResponse(int id) throws SQLException;
	public int deleteAll() throws SQLException;

}
