package com.katikilabs.angaza.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DelegateDAO implements IDelegateDAO {

	@Override
	public void addDelegate(Delegate delegate) throws SQLException {
		Connection con = Database.getConnection();

		PreparedStatement p = con
				.prepareStatement("insert into delegate (firstname, secondname, house) values (?,?, ?)");

		p.setString(1, delegate.getFirstName());
		p.setString(2, delegate.getSecondName());
		p.setString(3, delegate.getHouse());

		p.executeUpdate();
		p.close();
	}

	@Override
	public Delegate getDelegate(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Delegate> getDelegates() throws SQLException {
		List<Delegate> delegates = new ArrayList<Delegate>();
		Connection con = Database.getConnection();
		
		String sql = "SELECT firstname, secondname, house FROM delegate";
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rst = pst.executeQuery();
		
		while(rst.next()){
			String fname = rst.getString(1);
			String sname = rst.getString(2);
			String house = rst.getString(3);
			
			Delegate delegate  = new  Delegate(fname, sname, house);
			
			delegates.add(delegate);
		}
		rst.close();
		pst.close();
		
		return delegates;
	}

	@Override
	public int deleteDelegates() throws SQLException {

		return 0;
	}

	@Override
	public int deleteAll() throws SQLException {
		Connection con = Database.getConnection();

		String sql = "DELETE FROM delegate";
		PreparedStatement pst = con.prepareStatement(sql);

		pst.execute();

		pst.close();
		con.close();
		return 0;
	}

	public static void main(String[] args) throws SQLException {
		DelegateDAO d  = new DelegateDAO();
		
		Delegate del =  d.getUser(1);
		System.out.println(del.getUsername());
		System.out.println(del.getPassword());
		
	}

	@Override
	public void addUser(Delegate delegate) throws SQLException {

		Connection con = Database.getConnection();

		PreparedStatement p = con.prepareStatement("update delegate set username=?, password=? WHERE delegate_id=1;");
		p.setString(1, delegate.getUsername());
		p.setString(2, delegate.getPassword());

		p.executeUpdate();
		p.close();
	}
	public Delegate getUser(int id) throws SQLException {
		Connection con = Database.getConnection();
		
		String sql = String.format("SELECT username, password FROM delegate where delegate_id = %s", id);
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		Delegate delegate = new Delegate(rs.getString(1), rs.getString(2));
		
		rs.close();
		pst.close();
		return delegate;
	}

}
