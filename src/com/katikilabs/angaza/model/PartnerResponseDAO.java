package com.katikilabs.angaza.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PartnerResponseDAO implements IPartnerResponseDAO{

	@Override
	public void addPartnerResponse(PartnerResponse partnerResponse)
			throws SQLException {
	}

	@Override
	public PartnerResponse getPartnerResponse(int id) throws SQLException {
		return null;
	}

	@Override
	public List<PartnerResponse> getPartnerResponses() throws SQLException {
		List<PartnerResponse>list = new ArrayList<PartnerResponse>();
		Connection con = Database.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT* FROM PartnerRespose");

		while (rs.next()) {
			PartnerResponse response = new PartnerResponse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			list.add(response);

		}
		rs.close();
		stmt.close();
		con.close();
		return list;
	}

	@Override
	public int deletePartnerResponse(int id) throws SQLException {
		return 0;
	}

	@Override
	public int deleteAll() throws SQLException {
		return 0;
	}

}
