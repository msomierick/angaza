package com.katikilabs.angaza.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GivingViewDAO implements IGivingView{

	@Override
	public void addGivingView(GivingView givingView) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Giving getGivingView(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GivingView> getGivingViews() throws SQLException {
		List<GivingView>list = new ArrayList<GivingView>();
		Connection con = Database.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT* FROM givingview");

		while (rs.next()) {
			GivingView view = new GivingView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			list.add(view);

		}
		rs.close();
		stmt.close();
		con.close();
		return list;
	}

}
