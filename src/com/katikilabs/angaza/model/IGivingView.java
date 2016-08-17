package com.katikilabs.angaza.model;

import java.sql.SQLException;
import java.util.List;

public interface IGivingView {

	public void addGivingView(GivingView givingView)throws SQLException;
	public Giving getGivingView(int id) throws SQLException;
	public List<GivingView> getGivingViews()throws SQLException;
}
