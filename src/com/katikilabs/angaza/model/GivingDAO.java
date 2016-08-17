package com.katikilabs.angaza.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GivingDAO implements IGivingDAO {

	@Override
	public void addGiving(Giving giving) throws SQLException {
		Connection con = Database.getConnection();

		String sql = "INSERT INTO giving(partner_id, delegate_id, amount, date) values(?, ?, ?, ?);";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setInt(1, giving.getPartner_id());
		pst.setInt(2, giving.getDelegate_id());
		pst.setInt(3, giving.getAmount());
		pst.setString(4, giving.getGivingDate());

		pst.execute();
		pst.close();
		con.close();

	}

	@Override
	public Giving getGiving(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Giving> getGivings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteGiving() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
