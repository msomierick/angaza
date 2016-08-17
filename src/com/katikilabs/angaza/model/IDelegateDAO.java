package com.katikilabs.angaza.model;

import java.sql.SQLException;
import java.util.List;

public interface IDelegateDAO {
	
	public void addDelegate(Delegate user)throws SQLException;
	public Delegate getDelegate(int id) throws SQLException;
	public List<Delegate> getDelegates()throws SQLException;
	public int deleteDelegates() throws SQLException;
	public int deleteAll() throws SQLException;
	public void addUser(Delegate user)throws SQLException;
}
