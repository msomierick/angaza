package com.katikilabs.angaza.model;

import java.sql.SQLException;
import java.util.List;

public interface IGivingDAO {

	public void addGiving(Giving giving)throws SQLException;
	public Giving getGiving(int id) throws SQLException;
	public List<Giving> getGivings()throws SQLException;
	public int deleteGiving() throws SQLException;
	public int deleteAll() throws SQLException;
}
